package ui.telaselecaomonstro.camposuperclasse;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import main.AcervoFonte;
import main.AcervoSprite;
import main.JanelaCore;
import ui.CampoTxt;

public abstract class CampoTxtSelecaoMonstroA extends CampoTxt {
    public static byte idJogador = -1, idInimigo = -1;
    
    private final short gapTxtHJanela = 80;
    private final short gapTxtVJanela = 30;
    private boolean execUnica = true;
    
    private final short tamanhoSpriteA = 164;
    private final short tamanhoSpriteB = 128;
    private final short[] posXSprite = new short[3];
    private final short[] posYSprite = new short[3];
    
    private String monstroJSelecionado;
    private String monstroISelecionado;
    
    public static byte escolha = 0;// Se escolha = 0 então você está selecionando o monstro para o jogador, se escolha = 1 monstro inimigo
    
    public CampoTxtSelecaoMonstroA(String[] txtCampos) {
        super((byte)9, (byte)9, (byte)9);
        super.txt = txtCampos;
    }
    
    public void desenhar(Graphics2D g2) {
        byte afastamentoX = 2, afastamentoY = 3;
        
        // Cores dos campos Logo e Instrução
        super.setCores(Color.BLACK, Color.GRAY);
        
        // Fonte campo logo
        g2.setFont(AcervoFonte.fonte4);     
        if(execUnica) {
            setPosCampoLogo(g2);
        }
        
        // Desenhar campo Logo
        super.desenharSombraCampo(g2, txt[0], posX[0], posY[0], afastamentoX, afastamentoY);
        super.desenharCampoNaoSelecionavel(g2, txt[0], posX[0], posY[0]);
        
        afastamentoX = 1; afastamentoY = 2;
        
        // Fonte campo Instrução
        g2.setFont(AcervoFonte.fonte1);
        if(execUnica) {
            setPosCampoInstrucao(g2);
        }
        
        // Desenhar campo Instrução
        super.desenharSombraCampo(g2, txt[1], posX[1], posY[1], afastamentoX, afastamentoY);
        super.desenharCampoNaoSelecionavel(g2, txt[1], posX[1], posY[1]);
        
        if(execUnica) {
            setPosCamposMonstro(g2);
        }
        
        // Desenhar campos Monstro     
        // campo Charizard
        super.corTxt = Color.RED;
        super.desenharSombraCampo(g2, txt[2], posX[2], posY[2], afastamentoX, afastamentoY);
        super.desenharCampoNaoSelecionavel(g2, txt[2], posX[2], posY[2]);
        
        // campo Blastoise
        super.corTxt = Color.BLUE;
        super.desenharSombraCampo(g2, txt[3], posX[3], posY[3], afastamentoX, afastamentoY);
        super.desenharCampoNaoSelecionavel(g2, txt[3], posX[3], posY[3]);
        
        // campo Venossauro
        super.corTxt = Color.GREEN;
        super.desenharSombraCampo(g2, txt[4], posX[4], posY[4], afastamentoX, afastamentoY);
        super.desenharCampoNaoSelecionavel(g2, txt[4], posX[4], posY[4]);
        
        if(execUnica) {
            setPosSprites();
        }
        
        // Desenhar sprites
        desenharSprite(g2, AcervoSprite.spritesTelaSelecao[0], posXSprite[0], posYSprite[0], (byte)0);
        desenharSprite(g2, AcervoSprite.spritesTelaSelecao[1], posXSprite[1], posYSprite[1], (byte)1);
        desenharSprite(g2, AcervoSprite.spritesTelaSelecao[2], posXSprite[2], posYSprite[2], (byte)2);
        
        // Cor e fonte dos campos de confirmação
        g2.setFont(AcervoFonte.fonte0);
        super.setCores(Color.BLACK, Color.GRAY);   
        if(execUnica) {
            setPosCamposConfirmacao(g2);         
        }
        
        afastamentoX = 0; afastamentoY = 2;
        // Desenhar campos de confimação
        super.desenharSombraCampo(g2, txt[5], posX[5], posY[5], afastamentoX, afastamentoY);
        super.desenharCampo(g2, txt[5], posX[5], posY[5], (byte)3, (byte)16, Color.BLACK);
        
        super.desenharSombraCampo(g2, txt[6], posX[6], posY[6], afastamentoX, afastamentoY);
        super.desenharCampo(g2, txt[6], posX[6], posY[6], (byte)4, (byte)16, Color.BLACK);
        
        if(execUnica) {
            setPosCamposMonstroSelecionados(g2);
            execUnica = false;
        }
        // Desenhar campos de monstro selecionado
         
        // Jogador
        getTxtMonstroJSelecionado();
        super.desenharSombraCampo(g2, txt[7] + monstroJSelecionado, posX[7], posY[7], afastamentoX, afastamentoY);
        super.desenharCampoNaoSelecionavel(g2, txt[7] + monstroJSelecionado, posX[7], posY[7]);
        
        //Inimigo
        getTxtMonstroISelecionado();
        super.desenharSombraCampo(g2, txt[8] + monstroISelecionado, posX[8], posY[8], afastamentoX, afastamentoY);
        super.desenharCampoNaoSelecionavel(g2, txt[8] + monstroISelecionado, posX[8], posY[8]);
    }
    
    private void desenharSprite(Graphics2D g2, Image sprite, short posX, short posY, byte campoSelecionado) {
        if(CampoTxt.campoSelecionado == campoSelecionado) {
            if(campoSelecionado == 0) {
                g2.drawImage(sprite, posX, posY, (int)(tamanhoSpriteA * 1.25), (int)(tamanhoSpriteA * 1.25), null);
            }
            else {
                g2.drawImage(sprite, posX, posY, (int)(tamanhoSpriteB * 1.25), (int)(tamanhoSpriteB * 1.25), null);
            }      
        }   
        else {
            if(campoSelecionado == 0) {
                g2.drawImage(sprite, posX, posY, tamanhoSpriteA, tamanhoSpriteA, null);
            }
            else {
                g2.drawImage(sprite, posX, posY, tamanhoSpriteB, tamanhoSpriteB, null);
            } 
        }
    }
   
    private void setPosCampoLogo(Graphics2D g2) {
        // pos campo logo
        super.posX[0] = (short)(JanelaCore.larguraTela / 2 - getLarguraTxt(g2, txt[0])/ 2);
        super.posY[0] = (short)(15 + getAlturaFonte(g2)); 
    }
    
    private void setPosCampoInstrucao(Graphics2D g2) {
        // pos campo J, K
        super.posX[1] = (short)(JanelaCore.larguraTela / 2 - super.getLarguraTxt(g2, txt[1])/ 2);
        super.posY[1] = (short)(posY[0] + super.getAlturaFonte(g2) + 10);
    }
    
    private void setPosCamposMonstro(Graphics2D g2) {
        // pos campo Charizard
        super.posX[2] = gapTxtHJanela;
        super.posY[2] = (short)(posY[1] + getAlturaFonte(g2) + gapTxtVJanela); 
        
        // pos campo Blastoise
        super.posX[3] = (short)(posX[2] + super.getLarguraTxt(g2, txt[2]) + gapTxtHJanela);
        super.posY[3] = posY[2];
        
        // pos campo Venossauro
        super.posX[4] = (short)(posX[3] + super.getLarguraTxt(g2, txt[3]) + gapTxtHJanela);
        super.posY[4] = posY[2];
    }
    
    private void setPosSprites() {
        // pos sprite Charizard
        posXSprite[0] = posX[2];
        posYSprite[0] = (short)(posY[2] + 20);
        
        // pos sprite Blastoise
        posXSprite[1] = posX[3];
        posYSprite[1] = (short)(posY[2] + 20 + (tamanhoSpriteA - tamanhoSpriteB));
        
        // pos sprite Venossauro
        posXSprite[2] = posX[4];
        posYSprite[2] = posYSprite[1];
    }
    
    private void setPosCamposConfirmacao(Graphics2D g2) {
        // pos campo CONFIRMAR SELEÇÃO
        super.posX[5] = 300;
        super.posY[5] = 550;
        
        // pos campo VOLTAR AO MENU
        super.posX[6] = (short) (posX[5] + super.getLarguraTxt(g2, txt[5] + super.gapHorizontalEntreTxt));
        super.posY[6] = posY[5];
    }
    
    private void setPosCamposMonstroSelecionados(Graphics2D g2) {
        // pos campo MonstroJogador: 
        super.posX[7] = 10;
        super.posY[7] = 450;
       
        // pos campo MonstroInimigo:
        super.posX[8] = posX[7];
        super.posY[8] = (short)(posY[7] + super.getAlturaFonte(g2) + 10);
    }
    
    private void getTxtMonstroJSelecionado() {
        switch (idJogador) {
            
            case -1:
                monstroJSelecionado = "Não selecionado";
                break;
                
            case 0:
                monstroJSelecionado = "Charizard";
                break;
                
            case 1:
                monstroJSelecionado = "Blastoise";
                break;
                
            case 2:
                monstroJSelecionado = "Venossauro";
                break;
        }
    }
    
    private void getTxtMonstroISelecionado() {
        switch (idInimigo) {
            
            case -1:
                monstroISelecionado = "Não selecionado";
                break;
                
            case 0:
                monstroISelecionado = "Charizard";
                break;
                
            case 1:
                monstroISelecionado = "Blastoise";
                break;
                
            case 2:
                monstroISelecionado = "Venossauro";
                break;
        }
    }
    
    public static void resetarEscolhas() {
        idJogador = -1; idInimigo = -1;
        escolha = 0;
    }
}
