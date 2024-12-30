package main;

import gerenciadorinput.TecladoInput;
import gerenciadorinput.GerenciadorInput;
import monstro.monstroextra.GerenciadorDeMonstro;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;
import ui.telacombate.campo.UICombate;
import ui.telamenu.campo.UIMenu;
import ui.telaselecaomonstro.campo.UISelecao;

public class JanelaCore extends JPanel implements Runnable {
    public static byte estadoJogo = 0;
    public static boolean isTurnoHabilitado = false;// Serve para habilitar o sistema de turno apenas ao entrar no menu de ataque
    
    // Tamanho da tela
    public static final short larguraTela = 768;// 768px
    public static final short alturaTela = 576;// 576px
    
    // Threads da JanelaCore
    Thread threadJogo; Thread threadTurno;
    
    // Sprite
    AcervoSprite acervoSprite = new AcervoSprite();  
 
    // Monstro
    public GerenciadorDeMonstro grMonstro = new GerenciadorDeMonstro(); 
   
    // Input
    public TecladoInput input = new TecladoInput();
    GerenciadorInput grInput = new GerenciadorInput(input, grMonstro, acervoSprite);
    
    // UI
    UIMenu uiM = new UIMenu();
    UICombate uiC = new UICombate(grMonstro.monstroJ);
    UISelecao uiS = new UISelecao();
    
    // Som
    public static Som sfx = new Som((byte)0);
    
    private void iniciarThreadJogo() {
        threadJogo = new Thread(this);
        threadJogo.setPriority(Thread.MAX_PRIORITY);// Define a prioridade desta thread como máxima
        threadJogo.start();
    }
    
    // Construtor da classe
    public JanelaCore() {             
        this.setPreferredSize(new Dimension(larguraTela, alturaTela));
        this.setBackground(Color.LIGHT_GRAY);
        this.setDoubleBuffered(true);
        this.addKeyListener(input);
        this.setFocusable(true);
        this.iniciarThreadJogo(); 
        sfx.tocarSomLoop((byte)0);
    }
    
    // Atualiza
    public void atualizar() {
        grInput.manipularInputs();
        
        if(estadoJogo == 3) {
            if(grMonstro.monstroI.turno && isTurnoHabilitado && threadTurno == null) {
                threadTurno = new Thread() { 
                    @Override
                    public void run() {    
                        try {
                            Thread.sleep(2000);// 2 segundos de intervalo para turno do inimigo
                            grMonstro.monstroI.atacarIA();
                        } catch (InterruptedException e) {}           
                    
                        //System.out.println("Nome da thread: "+ this.getName());// Debug
                        //System.out.println("Qtd de threads rodando: "+ Thread.activeCount());// Debug 
                        threadTurno = null;                  
                    }            
                }; 
                threadTurno.start();
            }
        }
    }
    
    // Desenha
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        
        switch(estadoJogo) {
            
            case 0:
                if(UIMenu.estadoMenu == 0) {
                    uiM.campoMenu.desenharCampos(g2);
                }   
                else {
                    uiM.campoMenu.desenharCampos(g2);
                    uiM.campoInstrucao.desenharCampos(g2);
                }
                break;
                
            case 1:
                break;
                
            case 2:
                if(UISelecao.estadoSelecao == 0) {
                    uiS.campoSelecao.desenhar(g2);
                }
                break;
                
            case 3:
                if(UICombate.estadoCombate == 0) {          
                    uiC.campoHub.desenharCamposA(g2);
                }    
                else if(UICombate.estadoCombate == 1){
                    if(isTurnoHabilitado == false) {
                        isTurnoHabilitado = true;
                    }
                    uiC.campoAtaque.desenharCamposB(g2);
                }
                else {
                    uiC.campoMochila.desenharCamposB(g2);
                }
                
                // Desenhar monstros
                grMonstro.monstroJ.render.desenharMonstro(g2);
                grMonstro.monstroI.render.desenharMonstro(g2);
                break;
        }        
        // Desenhar fps
        desenharFps(g2);
        g2.dispose();
    }
    
    // Loop do Jogo
    long temporizadorFps = 0;
    long contagemDeQuadros = 0;
    long ultimaContagemDeQuadros = 60;  
    long temporizador = 0;
    @Override
    public void run() {  
        long tempoInicio = System.nanoTime();
        long tempoAtual;
        long IntervaloDeDesenho = 16666666;// 16.666.666ns = 16ms = 60 fps

        while(threadJogo != null) {  
            tempoAtual = System.nanoTime();
            temporizador += (tempoAtual - tempoInicio);
            tempoInicio = tempoAtual;
                       
            if(temporizador >= IntervaloDeDesenho) {// Se temporizador >= 16ms, então atualiza e redesenha
                atualizar();
                repaint();
                
                temporizadorFps += temporizador;
                temporizador = 0;
                contagemDeQuadros++;     
            }                 
        }        
    }
    
    // Contador de fps
    public void desenharFps(Graphics2D g2) {
        
        if(estadoJogo == 0) {
            g2.setColor(Color.WHITE);
        }
        else {
            g2.setColor(Color.BLACK);
        }
        g2.setFont(AcervoFonte.fonte0);
        
        if(temporizadorFps >= 1000000000) {// temporizadorFps >= 1 segundo
            g2.drawString("FPS: "+ String.valueOf(contagemDeQuadros), 9, 30);
            ultimaContagemDeQuadros = contagemDeQuadros;
            temporizadorFps = 0;
            contagemDeQuadros = 0;
        }
        else {     
            g2.drawString("FPS: "+ String.valueOf(ultimaContagemDeQuadros), 10, 30);
        }
    }
}
