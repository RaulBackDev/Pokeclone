package monstro.monstroextra;

import monstro.monstroinstancia.MonstroInimigo;
import monstro.monstroinstancia.MonstroJogador;

public class GerenciadorDeMonstro {
    public MonstroJogador monstroJ = new MonstroJogador();
    public MonstroInimigo monstroI = new MonstroInimigo();
      
    private void setOponentes() {
        monstroJ.oponente = monstroI;
        monstroI.oponente = monstroJ;
    } 
 
    private void setQuemComecaTurno() {
        if(monstroJ.velocidade >= monstroI.velocidade) {
            monstroJ.turno = true;
            monstroI.turno = false;
        }
        else {
            monstroJ.turno = false;
            monstroI.turno = true;
        }
    }
    
    private void definirVantagemDeAtaque() {
        // Multiplica ou divide o dano dos ataques de acordo com a tipagem do monstro inimigo
        monstroJ.habilidade.setVantagemDeTipo();
        monstroI.habilidade.setVantagemDeTipo();      
    }
    
    public void preencherMonstros(byte idMonstroJ, byte idMonstroI) {
        monstroJ.preencherMonstro(idMonstroJ);
        monstroI.preencherMonstro(idMonstroI); 
        setOponentes();
        setQuemComecaTurno();
        definirVantagemDeAtaque();// Define o multiplicador de dano
    }
    
    public void deletarMonstros() {
        monstroJ.deletarMonstro();
        monstroI.deletarMonstro();
    }
}
