package ui.telacombate.campo;

import monstro.monstroinstancia.MonstroJogador;

public class UICombate {
    public static byte estadoCombate = 0;// 0 - hub | 1 - ataque | 2 - mochila
    public CampoTxtCombateHub campoHub;
    public CampoTxtCombateAtaque campoAtaque;
    public CampoTxtCombateMochila campoMochila;
    
    public UICombate(MonstroJogador monstroJ) {
        campoHub = new CampoTxtCombateHub();
        campoAtaque = new CampoTxtCombateAtaque(monstroJ);
        campoMochila = new CampoTxtCombateMochila(monstroJ);
    }
}
