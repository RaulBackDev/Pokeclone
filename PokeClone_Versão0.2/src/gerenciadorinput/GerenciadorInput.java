package gerenciadorinput;

import javax.swing.JOptionPane;
import main.AcervoSprite;
import main.JanelaCore;
import monstro.monstroextra.GerenciadorDeMonstro;
import ui.CampoTxt;
import ui.telacombate.campo.UICombate;
import ui.telamenu.campo.UIMenu;
import ui.telaselecaomonstro.camposuperclasse.CampoTxtSelecaoMonstroA;

public class GerenciadorInput {  
    protected TecladoInput input;
    protected GerenciadorDeMonstro grMonstro;
    protected AcervoSprite acervoS;
    private byte estadoAnterior = -1;
    
    public GerenciadorInput(TecladoInput input, GerenciadorDeMonstro grMonstro, AcervoSprite acervoS) {
        this.input = input;
        this.grMonstro = grMonstro;
        this.acervoS = acervoS;
    }
    
    public void manipularInputs() {
        
        if(JanelaCore.estadoJogo != estadoAnterior) {
            estadoAnterior = JanelaCore.estadoJogo;
            CampoTxt.campoSelecionado = 0;
        }
        
        switch (JanelaCore.estadoJogo) {
            
            case 0:
                manipularMenu();
                break;
                
            case 2:
                manipularSelecaoMonstro();
                break;
                
            case 3:
                manipularCombate();
                break;
        }
    }
 
    private void manipularMenu() {
        
        // W PRESSIONADO
        if(input.wPress) {
            input.wPress = false;
            
            if(CampoTxt.campoSelecionado > 0) {
                CampoTxt.campoSelecionado--;
            }
        }
        
        // S PRESSIONADO
        if(input.sPress) {
            input.sPress = false;
            
            if(CampoTxt.campoSelecionado < 2) {
                CampoTxt.campoSelecionado++;
            }
        }
        
        // J PRESSIONADO
        if(input.jPress) {
            input.jPress = false;
            
            if(CampoTxt.campoSelecionado == 0) {
                JanelaCore.estadoJogo = 2;
            }
            else if(CampoTxt.campoSelecionado == 1){
                UIMenu.estadoMenu = 1;
            }
            else {
                System.exit(0);
            }
        }
       
        // K PRESSIONADO
        if(input.kPress) {
            input.kPress = false;
            
            if(UIMenu.estadoMenu == 1) {
                UIMenu.estadoMenu = 0;
            }
        }
    }
    
    private void manipularCombate() {
        
        // W PRESSIONADO
        if(input.wPress) {
            input.wPress = false;
            
            if(CampoTxt.campoSelecionado == 2) {
                CampoTxt.campoSelecionado = 0;
            }
        }
        
        // A PRESSIONADO
        if(input.aPress) {
            input.aPress = false;
            
            if(CampoTxt.campoSelecionado == 1) {
                CampoTxt.campoSelecionado = 0;
            }
        }
        
        // S PRESSIONADO
        if(input.sPress) {
            input.sPress = false;
            
            if(CampoTxt.campoSelecionado == 0) {
                CampoTxt.campoSelecionado = 2;
            }
        }
        
        // D PRESSIONADO
        if(input.dPress) {
            input.dPress = false;
            
            if(CampoTxt.campoSelecionado == 0) {
                CampoTxt.campoSelecionado = 1;
            }
        }
        
        // J PRESSIONADO
        if(input.jPress) {
            input.jPress = false;
            
            switch(UICombate.estadoCombate) {
                
                // HUB
                case 0:
                    if(CampoTxt.campoSelecionado == 0) {
                        UICombate.estadoCombate = 1;
                    }
                    else if(CampoTxt.campoSelecionado == 1) {
                        UICombate.estadoCombate = 2;
                    }
                    else {
                        JanelaCore.estadoJogo = 0;
                        JanelaCore.isTurnoHabilitado = false;
                        JanelaCore.sfx.pararSom();
                        JanelaCore.sfx.tocarSomLoop((byte)0);
                        
                        CampoTxtSelecaoMonstroA.resetarEscolhas();
                        grMonstro.deletarMonstros();
                    }
                    break;
                
                // Ataque
                case 1:
                    grMonstro.monstroJ.atacar();
                    break;
                    
                // Mochila    
                case 2:
                    grMonstro.monstroJ.usarItem();
                    break;
            }
        }
        
        // K PRESSIONADO
        if(input.kPress) {
            input.kPress = false;
            
            if(UICombate.estadoCombate != 0) {
                UICombate.estadoCombate = 0;
            }
        }
    }
    
    private void manipularSelecaoMonstro() {
        
        // W PRESSIONADO
        if(input.wPress) {
            input.wPress = false;
            
            if(CampoTxt.campoSelecionado == 3 || CampoTxt.campoSelecionado == 4) {
                CampoTxt.campoSelecionado = 2;
            }
        }
        
        // A PRESSIONADO
        if(input.aPress) {
            input.aPress = false;
            
            if(CampoTxt.campoSelecionado == 4) {
                CampoTxt.campoSelecionado--;
            }
            else if(CampoTxt.campoSelecionado > 0 && CampoTxt.campoSelecionado != 3) {
                CampoTxt.campoSelecionado--;
            }
        }
        
        // S PRESSIONADO
        if(input.sPress) {
            input.sPress = false;
            
            if(CampoTxt.campoSelecionado >= 0 && CampoTxt.campoSelecionado <= 2) {
                CampoTxt.campoSelecionado = 3;
            }
        }
        
        // D PRESSIONADO
        if(input.dPress) {
            input.dPress = false;
            
            if(CampoTxt.campoSelecionado == 3) {
                CampoTxt.campoSelecionado++;
            }
            else if(CampoTxt.campoSelecionado < 2) {
                CampoTxt.campoSelecionado++;
            }
        }
        
        // J PRESSIONADO
        if(input.jPress) {
            input.jPress = false;
            
            // Campos 0 a 2
            if(CampoTxt.campoSelecionado <= 2) {
                
                switch (CampoTxtSelecaoMonstroA.escolha) {
                    
                    case 0:
                        CampoTxtSelecaoMonstroA.idJogador = CampoTxt.campoSelecionado;
                        CampoTxtSelecaoMonstroA.escolha++;
                        break;
                        
                    case 1:
                        CampoTxtSelecaoMonstroA.idInimigo = CampoTxt.campoSelecionado;
                        CampoTxtSelecaoMonstroA.escolha++;
                        break;
                        
                    default:
                        JOptionPane.showMessageDialog(null, "Você já escolheu os monstros, para remover pressione K");
                        break;
                }
            }
            
            // Campo 3 CONFIRMAR SELEÇÃO
            else if(CampoTxt.campoSelecionado == 3) {
                
                if(CampoTxtSelecaoMonstroA.escolha == 2) {
                    acervoS.getSpritesJ(CampoTxtSelecaoMonstroA.idJogador);
                    acervoS.getSpritesI(CampoTxtSelecaoMonstroA.idInimigo); 
                    
                    grMonstro.preencherMonstros(CampoTxtSelecaoMonstroA.idJogador, CampoTxtSelecaoMonstroA.idInimigo);  
                    
                    JanelaCore.sfx.pararSom();
                    JanelaCore.sfx.tocarSomLoop((byte)1);
                    JanelaCore.estadoJogo = 3;
                }
                else {
                    JOptionPane.showMessageDialog(null, "Selecione os monstros para continuar.");
                }
            }
            
            // Campo 4 VOLTAR AO MENU
            else {
                CampoTxtSelecaoMonstroA.resetarEscolhas();
                JanelaCore.estadoJogo = 0;
            }
        }
        
        // K PRESSIONADO
        if(input.kPress) {
            input.kPress = false;
            
            if(CampoTxtSelecaoMonstroA.escolha == 1 ) {
                CampoTxtSelecaoMonstroA.escolha--;
                CampoTxtSelecaoMonstroA.idJogador = -1;
            }
            else if(CampoTxtSelecaoMonstroA.escolha == 2) {
                CampoTxtSelecaoMonstroA.escolha--;
                CampoTxtSelecaoMonstroA.idInimigo = -1;
            }   
        }
    }
}
