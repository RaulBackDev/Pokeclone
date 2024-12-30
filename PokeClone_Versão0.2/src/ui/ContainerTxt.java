package ui;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;

public abstract class ContainerTxt{
    public short posX, posY;
    public short largura, altura;
    protected byte arredondamentoDasBordas = 32;
    protected Color corContainer, corBorda;
    
    public ContainerTxt() {
        setCores(Color.DARK_GRAY, Color.BLACK);
    }
    
    public void desenharContainer(Graphics2D g2) {
        
        // Desenhando Container
        g2.setColor(corContainer);
        g2.fillRoundRect(posX, posY, largura, altura, arredondamentoDasBordas, arredondamentoDasBordas);
        
        // Desenhando borda para o Container
        g2.setColor(corBorda); g2.setStroke(new BasicStroke(3));
        g2.drawRoundRect(posX, posY, largura, altura, arredondamentoDasBordas, arredondamentoDasBordas);
    }
    
    // Método para definição de cores do container
    protected void setCores(Color corContainer, Color corBorda) {
        this.corContainer = corContainer;
        this.corBorda = corBorda;
    }
    
    // Métodos para definição de dimensões do container
    protected void setDimensoesContainer(short posX, short posY, short largura, short altura) {
        this.posX = posX; this.posY = posY;
        this.largura = largura; this.altura = altura;
    }
    
    protected void setPos(short posX, short posY) {
        this.posX = posX; 
        this.posY = posY;    
    }
    
    protected void setTamanho(short largura, short altura) {
        this.largura = largura; 
        this.altura = altura;
    }
}
