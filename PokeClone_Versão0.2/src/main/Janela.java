package main;

import javax.swing.JFrame;

public class Janela {
    // Janela
    JFrame jframe = new JFrame("GameDev");
    
    // JanelaCore (Core = coração ou núcleo)
    JanelaCore janelaC = new JanelaCore();;
    
    public Janela() {
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);        
        jframe.add(janelaC);
        jframe.pack();
        
        jframe.setResizable(false);
        jframe.setLocationRelativeTo(null);
        jframe.setVisible(true);
    }
}
