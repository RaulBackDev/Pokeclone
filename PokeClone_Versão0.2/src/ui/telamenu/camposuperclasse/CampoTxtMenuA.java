package ui.telamenu.camposuperclasse;

import java.awt.Graphics2D;
import main.AcervoFonte;
import main.AcervoSprite;
import main.JanelaCore;
import ui.CampoTxt;

public abstract class CampoTxtMenuA extends CampoTxt{
    private boolean execUnica = true;
    
    public CampoTxtMenuA(String[] txtCampos) {
        super((byte)4, (byte)4, (byte)4);
        super.txt = txtCampos;
    }
    
    public void desenharCampos(Graphics2D g2) {
        // Desenha imagem do pikachu no menu
        g2.drawImage(AcervoSprite.backMenu, 0, 0, JanelaCore.larguraTela, JanelaCore.alturaTela, null);
        
        byte afastamentoIndicacao = 24;
        byte afastamentoSombraPosX = -4, afastamentoSombraPosY = 4;
        
        // Fonte da Logo
        g2.setFont(AcervoFonte.fonte4);
 
        // Definir pos logo
        if(execUnica) {
            setPosTxtLogo(g2);      
        }
        
        // Desenhar logo
        desenharSombraCampo(g2, txt[0], posX[0], posY[0], afastamentoSombraPosX, afastamentoSombraPosY);
        desenharCampoNaoSelecionavel(g2, txt[0], posX[0], posY[0]);
        
        // Fonte dos campos de opção 
        g2.setFont(AcervoFonte.fonte3);
        
        // Define pos dos campos: Jogar e Sair
        if(execUnica) {
            setPosTxt1a3(g2);
            execUnica = false;
        }
        
        // Desenhar campo Jogar
        desenharSombraCampo(g2, txt[1], posX[1], posY[1], afastamentoSombraPosX, afastamentoSombraPosY);   
        desenharCampo(g2, txt[1], posX[1], posY[1], (byte)0, afastamentoIndicacao);
        
        // Desenhar campo Instrução
        desenharSombraCampo(g2, txt[2], posX[2], posY[2], afastamentoSombraPosX, afastamentoSombraPosY);
        desenharCampo(g2, txt[2], posX[2], posY[2], (byte)1, afastamentoIndicacao);
        
        // Desenhar campo Sair
        desenharSombraCampo(g2, txt[3], posX[3], posY[3], afastamentoSombraPosX, afastamentoSombraPosY);
        desenharCampo(g2, txt[3], posX[3], posY[3], (byte)2, afastamentoIndicacao);
    }
    
    // Definir posição dos campos
    private void setPosTxtLogo(Graphics2D g2) {
        // pos logo
        super.posX[0] = (short)(370 - getLarguraTxt(g2, txt[0])/ 2);
        super.posY[0] = (short)(35 + getAlturaFonte(g2));      
    }
    
    private void setPosTxt1a3(Graphics2D g2) {
        // pos campo nº1
        super.posX[1] = (short)(350 - getLarguraTxt(g2, txt[1])/ 2);
        super.posY[1] = (short)(posY[0] + 50 + getAlturaFonte(g2));
        
        // pos campo nº2
        super.posX[2] = posX[1];
        super.posY[2] = (short)(posY[1] + 25 + getAlturaFonte(g2));
        
        // pos campo nº3
        super.posX[3] = posX[1];
        super.posY[3] = (short)(posY[2] + 25 + getAlturaFonte(g2));
    }
}
