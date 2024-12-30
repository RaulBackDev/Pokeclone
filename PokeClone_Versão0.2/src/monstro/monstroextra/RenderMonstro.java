package monstro.monstroextra;

import monstro.monstroinstancia.MonstroJogador;
import monstro.monstrosuperclasse.Monstro;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import main.AcervoFonte;
import main.JanelaCore;

public class RenderMonstro {
    // Referência monstro
    Monstro monstro;
    
    // Tamanho e posição 
    public int posX, posY;
    public final int posYReferencial = 130;// Usado para definir a posição y inicial do monstro e informações acima do mesmo
    
    public Image[] sprite;
    public short tamanhoSprite;
    public short qtdSprites;
    
    public RenderMonstro(Monstro monstro) {
        this.monstro = monstro;
    }
    
    private final short gapMonstroBordaHJanela = 96;
    private final byte gapMonstroEInfo = 10;
    public void setPosMonstro() {
        
        // Set posX
        if(monstro instanceof MonstroJogador) {
            posX = gapMonstroBordaHJanela;
        }
        else {
            posX = JanelaCore.larguraTela - tamanhoSprite - gapMonstroBordaHJanela;
        }
        
        // setPosY
        if(monstro.id == 0) {
            posY = posYReferencial + gapMonstroEInfo;
        }
        else {
            posY = posYReferencial + gapMonstroEInfo + 64;// Alguns sprites tem dimensões diferentes,
                                             // essa equação normaliza as posições deles.
        }
    }
    
    // Desenhar
    public void desenharMonstro(Graphics2D g2) {  
        g2.setFont(AcervoFonte.fonte0);
        int alturaTxt = g2.getFontMetrics().getHeight();
        
        // Desenha monstro 
        g2.drawImage(animacaoSprite(), posX, posY, tamanhoSprite,
                    tamanhoSprite, null);
        
        // Seleciona cor da vida do monstro
        if(monstro.vida < monstro.vidaTotal * 0.25f) {
            g2.setColor(Color.red);
        }
        else {
            g2.setColor(Color.blue);
        }        

        // Desenha cor atrás da vida do monstro
        g2.drawString("Vida "+ String.valueOf(monstro.vida), posX +1, posYReferencial + 1);
        
        g2.setColor(Color.BLACK);// Muda cor para as info
        
        // Desenha vida do monstro
        g2.drawString("Vida "+ String.valueOf(monstro.vida), posX, posYReferencial);
        
        // Desenha status do monstro
        g2.drawString("Status "+ monstro.status, posX, posYReferencial -  alturaTxt - 10);
        
        // Desenha nome do monstro
        g2.drawString(monstro.nome, posX, posYReferencial - (alturaTxt * 2) - 20);
    }  

    private short temporizadorAnimacao = 0, indiceSprite = 0;
    public Image animacaoSprite() {    
        temporizadorAnimacao++;
        
        if(temporizadorAnimacao >= 1) {
            temporizadorAnimacao = 0;
            indiceSprite++;
            
            if(indiceSprite == qtdSprites) {
                indiceSprite = 0;
            } 
        } 
        return sprite[indiceSprite];
    }
}
