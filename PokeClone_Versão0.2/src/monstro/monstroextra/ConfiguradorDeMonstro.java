package monstro.monstroextra;

import main.AcervoSprite;
import monstro.monstrosuperclasse.Monstro;
import monstro.monstroinstancia.MonstroJogador;

public class ConfiguradorDeMonstro {
    // Nome, tipo, velocidade e vida
    private static String[] nome = new String[]{"Charizard", "Blastoise", "Venossauro"};
    private static String[] tipo = new String[]{"Fire", "Water", "Grass"};
    private static byte[] velocidade = new byte[]{94, 78, 77};// 0 min, 100max
    private static float[] vida = new float[]{158f, 160f, 155f};
    private static short[] tamanhoSprite = new short[]{224, 160};
    private static short[] qtdSprites = new short[]{46, 78, 58};
    
    public static void setMonstro(Monstro monstro) { 
        monstro.render = new RenderMonstro(monstro);
        
        switch(monstro.id) {
            
            case 0: // Charizard             
                monstro.nome = nome[0];// Charizard
                monstro.vida = vida[0];// 158
                monstro.vidaTotal = monstro.vida;
                monstro.tipo = tipo[0];// fogo
                monstro.velocidade = velocidade[0];// 94 
                monstro.render.tamanhoSprite = tamanhoSprite[0];
                monstro.render.qtdSprites = qtdSprites[0];
                
                if(monstro instanceof MonstroJogador) {
                   monstro.render.sprite = AcervoSprite.charizDireita;
                }
                else {
                    monstro.render.sprite = AcervoSprite.charizEsquerda;
                }
                break;
                
            case 1: // Blastoise
                monstro.nome = nome[1];// Blastoise
                monstro.vida = vida[1];// 160
                monstro.vidaTotal = monstro.vida;
                monstro.tipo = tipo[1];// água
                monstro.velocidade = velocidade[1];// 78
                monstro.render.tamanhoSprite = tamanhoSprite[1];
                monstro.render.qtdSprites = qtdSprites[1];
                
                if(monstro instanceof MonstroJogador) {
                    monstro.render.sprite = AcervoSprite.blastDireita;
                }
                else {
                    monstro.render.sprite = AcervoSprite.blastEsquerda;
                }
                break;
            
            case 2: // Venossauro
                monstro.nome = nome[2];// Venossauro
                monstro.vida = vida[2];// 155
                monstro.vidaTotal = monstro.vida;
                monstro.tipo = tipo[2];// grama
                monstro.velocidade = velocidade[2];// 77
                monstro.render.tamanhoSprite = tamanhoSprite[1];
                monstro.render.qtdSprites = qtdSprites[2];
                
                if(monstro instanceof MonstroJogador) {
                    monstro.render.sprite = AcervoSprite.venoDireita;
                }
                else {
                    monstro.render.sprite = AcervoSprite.venoEsquerda;
                }
                break;
        }
        
        monstro.render.setPosMonstro();
        monstro.status = "Normal";
    }
}
