package main;

import java.awt.Image;
import javax.imageio.ImageIO;

public class AcervoSprite {
    public static Image[] spritesTelaSelecao = new Image[3];
    
    public static Image[] charizDireita = new Image[46];
    public static Image[] charizEsquerda = new Image[46];
    
    public static Image[] blastDireita = new Image[78];
    public static Image[] blastEsquerda = new Image[78];
    
    public static Image[] venoDireita = new Image[58];
    public static Image[] venoEsquerda = new Image[58];
    
    public static Image backMenu;
    
    public AcervoSprite() {
        getSprites();
    }
    
    private void getSprites() {
        try {
            getBackgroundTelaMenu();
            getSpritesTelaSelecao();
            
        }catch(Exception e) {}
    }        
    
    // Charizard
    public void getSpritesCharizardDireita() {
        try {
            for(int i = 0; i < 47; i ++) {
                charizDireita[i] = ImageIO.read(getClass().getResourceAsStream("/Z_sprites/"
                        + "spriteMonstro/charizard/charizardDireita/"+ i +".gif"));
            }
                    
        }catch(Exception e) {}
    }
    
    public void getSpritesCharizardEsquerda() {
        try {
            for(int i = 0; i < 47; i ++) {
                charizEsquerda[i] = ImageIO.read(getClass().getResourceAsStream("/Z_sprites/"
                        + "spriteMonstro/charizard/charizardEsquerda/"+ i +".gif"));
            }
                    
        }catch(Exception e) {}
    }
    
    // Blastoise
    public void getSpritesBlastoiseDireita() {
        try {
            for(int i = 0; i < 79; i ++) {
                blastDireita[i] = ImageIO.read(getClass().getResourceAsStream("/Z_sprites/"
                        + "spriteMonstro/blastoise/blastoiseDireita/"+ i +".gif"));
            }
                    
        }catch(Exception e) {}
    }
    
    public void getSpritesBlastoiseEsquerda() {
        try {
            for(int i = 0; i < 79; i ++) {
                blastEsquerda[i] = ImageIO.read(getClass().getResourceAsStream("/Z_sprites/"
                        + "spriteMonstro/blastoise/blastoiseEsquerda/"+ i +".gif"));
            }
                    
        }catch(Exception e) {}
    }
    
    // Venossauro
    public void getSpritesVenossauroDireita() {
        try {
            for(int i = 0; i < 59; i ++) {
                venoDireita[i] = ImageIO.read(getClass().getResourceAsStream("/Z_sprites/"
                        + "spriteMonstro/venossauro/venossauroDireita/"+ i +".gif"));
            }
                    
        }catch(Exception e) {}
    }
    
    public void getSpritesVenossauroEsquerda() {
        try {
            for(int i = 0; i < 59; i ++) {
                venoEsquerda[i] = ImageIO.read(getClass().getResourceAsStream("/Z_sprites/"
                        + "spriteMonstro/venossauro/venossauroEsquerda/"+ i +".gif"));
            }
                    
        }catch(Exception e) {}
    }
    
    // Sprites tela seleção 
    public void getSpritesTelaSelecao() {
        try {
            spritesTelaSelecao[0] = ImageIO.read(getClass().getResourceAsStream("/Z_sprites/"
                        + "spriteMonstro/charizard/charizardEsquerda/0.gif"));
            
            spritesTelaSelecao[1] = ImageIO.read(getClass().getResourceAsStream("/Z_sprites/"
                        + "spriteMonstro/blastoise/blastoiseEsquerda/0.gif"));
            
            spritesTelaSelecao[2] = ImageIO.read(getClass().getResourceAsStream("/Z_sprites/"
                        + "spriteMonstro/venossauro/venossauroEsquerda/0.gif"));
            
        }catch(Exception e) {}
    }
    
    // Background
    public void getBackgroundTelaMenu() {
        try {
            backMenu = ImageIO.read(getClass().getResourceAsStream("/Z_sprites/backgroundSprites/backTelaMenu.png"));
        }catch(Exception e) {}
    }
    
    public void getSpritesJ(byte idMonstroJogador) {
        if(idMonstroJogador == 0) {
            getSpritesCharizardDireita();
        }
        else if(idMonstroJogador == 1) {
            getSpritesBlastoiseDireita();
        }
        else if(idMonstroJogador == 2) {
            getSpritesVenossauroDireita();
        }
    }
    
    public void getSpritesI(byte idMonstroInimigo) {
        if(idMonstroInimigo == 0) {
            getSpritesCharizardEsquerda();
        }
        else if(idMonstroInimigo == 1) {
            getSpritesBlastoiseEsquerda();
        }
        else if(idMonstroInimigo == 2) {
            getSpritesVenossauroEsquerda();
        }
    }
}
