package main;

import java.net.URL;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Som {
    public Clip clip;
    private byte escolhaSom;
    public URL musica[] = new URL[2];
    public URL somAcao[] = new URL[2];
    
    public Som(byte escolhaSom) {// 0 - musica, 1 - ação
        this.escolhaSom = escolhaSom;
        
        if(this.escolhaSom == 0) {
            getMusica();
        }
        else {
            getSomAcao();
        }
    }
    
    public void getMusica() {
        musica[0] = getClass().getResource("/Z_Sons/somMenu.wav");
        musica[1] = getClass().getResource("/Z_Sons/musicaCombate.wav");
    }
    
    public void getSomAcao() {
        somAcao[0] = getClass().getResource("/Z_Sons/somPancada.wav");
        somAcao[1] = getClass().getResource("/Z_Sons/somCura.wav");
    }
    
    private void setSom(byte i) {    
        try {
            AudioInputStream ais;
            
            if(escolhaSom == 0) {
                ais = AudioSystem.getAudioInputStream(musica[i]);
            }
            else {
                ais = AudioSystem.getAudioInputStream(somAcao[i]);
            }
            
            clip = AudioSystem.getClip();
            clip.open(ais);
      
        }catch(Exception e) {
            e.printStackTrace();
        }
    } 
   
    public void pararSom() {
        clip.stop();
    }
    
    public void tocarSom(byte i) {
        setSom(i);
         clip.start();
    }
    
    public void tocarSomLoop(byte i) {
        setSom(i);
        clip.start();
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }
}
