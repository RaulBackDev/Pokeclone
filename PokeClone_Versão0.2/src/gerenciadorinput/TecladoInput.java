package gerenciadorinput;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class TecladoInput implements KeyListener {
    int codigo;
    public boolean wPress, aPress, sPress, dPress;
    public boolean jPress, kPress;
    
    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {
        codigo = e.getKeyCode();
        
        if(codigo == KeyEvent.VK_W) {
            wPress = true;     
        }
        if(codigo == KeyEvent.VK_A) {
            aPress = true;
        }
        if(codigo == KeyEvent.VK_S) {
            sPress = true;
        }
        if(codigo == KeyEvent.VK_D) {
            dPress = true;                    
        }
        if(codigo == KeyEvent.VK_J) {
            jPress = true;                    
        }
        if(codigo == KeyEvent.VK_K) {
            kPress = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        codigo = e.getKeyCode();
              
        if(codigo == KeyEvent.VK_W) {
            wPress = false;     
        }
        if(codigo == KeyEvent.VK_A) {
            aPress = false;
        }
        if(codigo == KeyEvent.VK_S) {
            sPress = false;
        }
        if(codigo == KeyEvent.VK_D) {
            dPress = false;                    
        }
        if(codigo == KeyEvent.VK_J) {
            jPress = false;                    
        }
        if(codigo == KeyEvent.VK_K) {
            kPress = false;
        }
    }   
}
