package monstro.monstroinstancia;

import monstro.monstrosuperclasse.Monstro;
import main.JanelaCore;
import ui.CampoTxt;

public class MonstroJogador extends Monstro {
    
    public void atacar() {
        byte numeroBotao = CampoTxt.campoSelecionado;
       
        if(turno && JanelaCore.isTurnoHabilitado && this.vida > 1 && oponente.vida > 1) {
            habilidade.efeitoNegativoDeStatus();
                                
            if(turno && this.vida > 1 && this.habilidade.usosDisponiveis[numeroBotao] > 0) {
 
                float dano = this.habilidade.dano[numeroBotao];
                this.habilidade.usosDisponiveis[numeroBotao] -= 1;
                    
                habilidade.atacarStatusOponente(numeroBotao);
                habilidade.usarEfeitoEspecialHabilidade(numeroBotao);
                
                oponente.vida -= dano;              
                this.turno = false;
                
                super.sfxMonstro.tocarSom((byte)0);
                if(oponente.vida < 1) {
                    oponente.vida = 0;
                }
                else {
                    oponente.turno = true;
                }
            }  
        }     
    }
    
    public void usarItem() {
        byte indiceVetor = CampoTxt.campoSelecionado;
        
        if(turno && JanelaCore.isTurnoHabilitado && vida > 1 && oponente.vida > 0) {
            if(item.tipo[indiceVetor].equals("Heal") && vida < vidaTotal) {
                item.usarItemDeCura(indiceVetor);  
            }
            else if(item.tipo[indiceVetor].equals("Status")) {
                item.usarItemDeStatus(indiceVetor);
            }      
        }              
    }
}
