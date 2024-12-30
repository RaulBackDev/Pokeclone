package ui.telamenu.camposuperclasse;

import java.awt.Graphics2D;
import main.AcervoFonte;
import ui.CampoTxt;
import ui.telamenu.container.ContainerTxtInstrucaoA;

public abstract class CampoTxtInstrucaoA extends CampoTxt{
    private ContainerTxtInstrucaoA containerA = new ContainerTxtInstrucaoA();
    private boolean execUnica = true;
    
    public CampoTxtInstrucaoA(String[] txtCampos) {
        super((byte)4, (byte)4, (byte)4);
        super.txt = txtCampos;
    }
    
    public void desenharCampos(Graphics2D g2) {
        containerA.desenharContainer(g2);
        byte afastamento = 2;
                
        g2.setFont(AcervoFonte.fonte2);
        if(this.execUnica) {
            setPosLogo(g2);
        }
        
        // Desenha campo Comandos
        super.desenharSombraCampo(g2, txt[0], posX[0], posY[0], afastamento, afastamento);
        super.desenharCampoNaoSelecionavel(g2, txt[0], posX[0], posY[0]);
        
        g2.setFont(AcervoFonte.fonte1);
        if(this.execUnica) {
            setPosCampos(g2);
            execUnica = false;
        }

        // Desenhar campo A e D
        super.desenharSombraCampo(g2, txt[1], posX[1], posY[1], afastamento, afastamento);
        super.desenharCampoNaoSelecionavel(g2, txt[1], posX[1], posY[1]);
        
        // Desenhar campo J    
        super.desenharSombraCampo(g2, txt[2], posX[2], posY[2], afastamento, afastamento);
        super.desenharCampoNaoSelecionavel(g2, txt[2], posX[2], posY[2]);
        
        // Desenhar campo K
        super.desenharSombraCampo(g2, txt[3], posX[3], posY[3], afastamento, afastamento);
        super.desenharCampoNaoSelecionavel(g2, txt[3], posX[3], posY[3]);

    }
    
    private void setPosLogo(Graphics2D g2) {
        posY[0] = (short)(containerA.posY + super.getAlturaFonte(g2) + 10);
        posX[0] = (short)(containerA.posX + containerA.largura/2 - super.getLarguraTxt(g2, txt[0])/2);
    }
    
    private void setPosCampos(Graphics2D g2) {    
        posY[1] = (short)(posY[0] + super.getAlturaFonte(g2) + 15);
        posX[1] = (short)(containerA.posX + 15);
        
        posY[2] = (short)(posY[1] + super.getAlturaFonte(g2) + 15);
        posX[2] = posX[1];
        
        posY[3] = (short)(posY[2] + super.getAlturaFonte(g2) + 15);
        posX[3] = posX[2];
    }
}
