package ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

public abstract class CampoTxt{
    public static byte campoSelecionado = 0;
     
    protected short[] posX, posY;// Posições x e y dos campos
    protected String[] txt;// Todos os txts usados nos campos
    protected short gapHorizontalEntreTxt, gapVerticalEntreTxt;// Define espaços vazios entre os campos de txt
    protected Color corTxt, corSombra;
   
    // Construtores
    public CampoTxt(byte qtdX, byte qtdY, byte qtdTxt) {
        setQtdIndicesPosETxt(qtdX, qtdY, qtdTxt);
        setCores(Color.WHITE, Color.BLACK);
        setGapsTxt((short)20, (short)10);
    }
    
    public CampoTxt(byte qtdX, byte qtdY, byte qtdTxt, Color corTxt, Color corSombra) {
        setQtdIndicesPosETxt(qtdX, qtdY, qtdTxt);
        setCores(corTxt, corSombra);
        setGapsTxt((short)20, (short)10);
    }
    
    public CampoTxt(byte qtdX, byte qtdY, byte qtdTxt, Color corTxt, Color corSombra, 
            short gapHorizontal, short gapVertical) {
        
        setQtdIndicesPosETxt(qtdX, qtdY, qtdTxt);
        setCores(corTxt, corSombra);
        setGapsTxt(gapHorizontal, gapVertical);
    }
    
    // Métodos de desenho de campo
    protected void desenharCampo(Graphics2D g2, String txt, short posX, short posY, 
            byte campoSelecionado, byte afastamento) {
        
        g2.setColor(corTxt);
        g2.drawString(txt, posX, posY);
        
        if(this.campoSelecionado == campoSelecionado) {           
            // Desenhar o indicador de seleção do campo. ">"
            g2.drawString(">", posX - afastamento, posY);                 
        }
    }
    
    protected void desenharCampo(Graphics2D g2, String txt, short posX, short posY, 
            byte campoSelecionado, byte afastamento, Color corAsterisco) {
        
        g2.setColor(corTxt);
        g2.drawString(txt, posX, posY);
        
        if(this.campoSelecionado == campoSelecionado) {           
            // Desenhar o indicador de seleção do campo. ">"
            g2.setColor(corAsterisco);
            g2.drawString("*", posX - afastamento, posY);                 
        }
    }
    
    protected void desenharSombraCampo(Graphics2D g2, String txt, short posX, short posY,
            byte afastamentoPosX, byte afastamentoPosY) {
        
        g2.setColor(corSombra);
        g2.drawString(txt, posX + afastamentoPosX, posY + afastamentoPosY);
    }
    
    protected void desenharCampoNaoSelecionavel(Graphics2D g2, String txt, short posX, short posY) {
        g2.setColor(corTxt);
        g2.drawString(txt, posX, posY);
    }
    
    // Pegar tamanho da fonte
    protected short getLarguraTxt(Graphics2D g2, String txt) {
        return (short)g2.getFontMetrics().stringWidth(txt);
    }
    
    protected short getAlturaFonte(Graphics2D g2) {
        return (short)g2.getFontMetrics().getHeight();
    }
    
    protected short getAlturaFonte(Graphics2D g2, Font fonte) {
        return (short)g2.getFontMetrics(fonte).getHeight();
    }

    // Definir quantidade de campos   
    protected final void setQtdIndicesPosETxt(byte qtdX, byte qtdY, byte qtdTxt) {
        posX = new short[qtdX]; 
        posY = new short[qtdY];
        txt = new String[qtdTxt];
    }
    
    // Definir cores
    protected final void setCores(Color corTxt, Color corSombra) {
        this.corTxt = corTxt;
        this.corSombra = corSombra;
    }
    
    // Definir espaçamento entre textos
    protected final void setGapsTxt(short gapHorizontal, short gapVertical) {
        this.gapHorizontalEntreTxt = gapHorizontal;
        this.gapVerticalEntreTxt = gapVertical;
    }
}
