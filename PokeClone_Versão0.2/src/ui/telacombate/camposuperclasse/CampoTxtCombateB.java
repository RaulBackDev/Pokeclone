package ui.telacombate.camposuperclasse;

import ui.telacombate.campo.UICombate;
import ui.telacombate.container.ContainerTxtCombateB;
import java.awt.Graphics2D;
import main.AcervoFonte;
import monstro.monstroinstancia.MonstroJogador;
import ui.CampoTxt;

public abstract class CampoTxtCombateB extends CampoTxtCombateA {
    protected ContainerTxtCombateB containerB = new ContainerTxtCombateB(super.containerA);
    private boolean execUnica = true;
 
    public CampoTxtCombateB(MonstroJogador monstroJ) {
        super();
        super.monstroJ = monstroJ;
    }
 
    public void desenharCamposB(Graphics2D g2) {
        // Desenha campos a esquerda na tela
        super.desenharCamposA(g2);
               
        g2.setFont(AcervoFonte.fonte0);// Fonte do txt UsosDisp  
        if(this.execUnica) {
            setPosTxtUsosDisp(g2);
        }  
        // Desenha usos disponíveis
        desenharUsosDisponiveis(g2);
   
        // Desenhando o container de txt a direita na tela
        containerB.desenharContainer(g2);
        
        g2.setFont(AcervoFonte.fonte2);// Fonte do txt Turno
        if(this.execUnica) {
            setPosTxtTurno(g2);
            execUnica = false;
        }
        // Desenha texto do turno
        desenharTxtTurno(g2); 
    }
    
    private void setPosTxtUsosDisp(Graphics2D g2) {
        // Set posição usosDisponíveis
        super.posX[3] = posX[0];
        super.posY[3] = (short)(posY[2] + super.getAlturaFonte(g2) + gapVerticalEntreTxt);
    }
    
    private void desenharUsosDisponiveis(Graphics2D g2) {
        String usosDispTxt;
        
        if(UICombate.estadoCombate == 1) {
            usosDispTxt = "Usos Disponíveis " + String.valueOf(monstroJ.habilidade.usosDisponiveis[CampoTxt.campoSelecionado]);
        }
        else {
            usosDispTxt = "Usos Disponíveis " + String.valueOf(monstroJ.item.usosDisponiveis[CampoTxt.campoSelecionado]);
        }
  
        // Desenha os usos disponíveis
        super.desenharSombraCampo(g2, usosDispTxt, posX[3], (short)(posY[3] + 10), (byte)-2, (byte)3);
        super.desenharCampoNaoSelecionavel(g2, usosDispTxt, posX[3], (short)(posY[3] + 10));
    }
    
    private void setPosTxtTurno(Graphics2D g2) {    
        // pos do campo turno
        posY[4] = (short)(containerB.posY + super.getAlturaFonte(g2) + super.gapVerticalEntreTxt);
        posX[4] = (short)(containerB.posX + super.gapHorizontalEntreTxt);
    }
    
    private void desenharTxtTurno(Graphics2D g2) {   
        String txtTurno;
        
        if(monstroJ.vida > 0 && monstroJ.oponente.vida > 0) {
            
            if(monstroJ.turno) {
                txtTurno = "Turno jogador";
            }
            else {
                txtTurno =  "Turno Inimigo";
            }           
        }
        else {          
            if(monstroJ.vida > 0) {
                txtTurno =  "Você venceu!";
            }
            else {
                txtTurno =  "Você perdeu!";
            }
        }    
        super.desenharSombraCampo(g2, txtTurno, posX[4], posY[4], (byte)-2, (byte)3);
        super.desenharCampoNaoSelecionavel(g2, txtTurno, posX[4], posY[4]);
    }  
}
