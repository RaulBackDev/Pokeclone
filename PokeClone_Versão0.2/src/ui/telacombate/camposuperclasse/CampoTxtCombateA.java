package ui.telacombate.camposuperclasse;

import ui.telacombate.container.ContainerTxtCombateA;
import java.awt.Graphics2D;
import main.AcervoFonte;
import monstro.monstroinstancia.MonstroJogador;
import ui.CampoTxt;
import ui.telacombate.campo.CampoTxtCombateAtaque;
import ui.telacombate.campo.CampoTxtCombateHub;
import ui.telacombate.campo.UICombate;

public abstract class CampoTxtCombateA extends CampoTxt{
    protected MonstroJogador monstroJ;
    public ContainerTxtCombateA containerA = new ContainerTxtCombateA();
    
    public CampoTxtCombateA() {  
        super((byte)5, (byte)5, (byte)3);
    }
 
    public void desenharCamposA(Graphics2D g2) {
        // Afastamentos do texto
        byte afastamentoIndicacao = 16;
        byte afastamentoSombraX = -2;
        byte afastamentoSombraY = 3;
         
        // Define as posições, fonte e textos dentro dos campos
        setFonteTxt0a2(g2);
        setTxtCamposA();
        setPosTxt0a2(g2);
           
        // Desenhar container a esquerda na tela
        containerA.desenharContainer(g2);
           
        // Desenhar campo nº0
        super.desenharSombraCampo(g2, txt[0], posX[0], posY[0], afastamentoSombraX, afastamentoSombraY);
        super.desenharCampo(g2, txt[0], posX[0], posY[0], (byte)0, afastamentoIndicacao);
        
        // Desenhar campo nº1    
        super.desenharSombraCampo(g2, txt[1], posX[1], posY[1], afastamentoSombraX, afastamentoSombraY);
        super.desenharCampo(g2, txt[1], posX[1], posY[1], (byte)1, afastamentoIndicacao);

        // Desenhar campo nº2
        super.desenharSombraCampo(g2, txt[2], posX[2], posY[2], afastamentoSombraX, afastamentoSombraY);
        super.desenharCampo(g2, txt[2], posX[2], posY[2], (byte)2, afastamentoIndicacao);  
    }
    
    private void setFonteTxt0a2(Graphics2D g2) {
        if(UICombate.estadoCombate == 0) {
            g2.setFont(AcervoFonte.fonte2);
        }
        else {
            g2.setFont(AcervoFonte.fonte1);
        }
    }
    
    private void setTxtCamposA() {
        if(this instanceof CampoTxtCombateHub) {
            super.txt = new String[]{"Ataque","Mochila","Fuga"};
        }
        else if(this instanceof CampoTxtCombateAtaque) {
            super.txt = monstroJ.habilidade.nome;
        }
        else {
            super.txt = monstroJ.item.nome;
        }
    }
    
    private void setPosTxt0a2(Graphics2D g2) {
        // Set posição campo nº0
        super.posX[0] = (short)(containerA.posX + gapHorizontalEntreTxt);
        super.posY[0] = (short)(containerA.posY + super.getAlturaFonte(g2) + gapVerticalEntreTxt);
        
        // Set posição campo nº1
        super.posX[1] = (short)(super.posX[0] + super.getLarguraTxt(g2, txt[0]) + gapHorizontalEntreTxt);
        super.posY[1] = posY[0];
        
        // Set posição campo nº2
        super.posX[2] = posX[0];
        super.posY[2] = (short)(posY[0] + super.getAlturaFonte(g2) + gapVerticalEntreTxt);      
    }            
}
