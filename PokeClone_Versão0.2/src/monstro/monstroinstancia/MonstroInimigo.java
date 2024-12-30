package monstro.monstroinstancia;

import monstro.monstrosuperclasse.Monstro;

public class MonstroInimigo extends Monstro {   
    
    public void atacarIA() {          
        float dano = 0;
        byte indiceVetorDanoIA = 0;  
        
        if(turno == true && vida > 1) {    
            super.habilidade.efeitoNegativoDeStatus();
            
            if(turno) {
                 usarItemStatusIA();
            } 
            if(turno) {
                usarItemCuraIA();
            }
        
            if(turno) {
                
                for(byte i = 0; i <= 2; i++) {// Seleciona a habilidade com maior dano possível
                    if(dano < habilidade.dano[i] && habilidade.usosDisponiveis[i] > 0) {
                        dano = habilidade.dano[i];
                        indiceVetorDanoIA = i;
                    }
                }
                
                if(dano > 0) {
                    habilidade.usarEfeitoEspecialHabilidade((byte)indiceVetorDanoIA); 
                    habilidade.atacarStatusOponente(indiceVetorDanoIA);
                    
                    habilidade.usosDisponiveis[indiceVetorDanoIA] -= 1;                 
                    oponente.vida -= dano;
                    turno = false;
                    
                    super.sfxMonstro.tocarSom((byte)0);
                    if(oponente.vida < 1) {
                        oponente.vida = 0;  
                        oponente.turno = false;
                    }
                    else {
                        oponente.turno = true;
                    }
                }
                else {
                    this.turno = false;
                    oponente.turno = true;
                }
            }
            else {
                oponente.turno = true;
            }               
        } 
    }
    
    public void usarItemStatusIA() {
        byte indiceVetorStatus = -1;
        
        if(vida > 1 && !status.equals("Normal")) {  
            
            for(byte i = 0; i <= 2; i++) {               
                if(item.tipo[i].equals("Status")) {
                    indiceVetorStatus = i;
                }
            } 
            if(indiceVetorStatus != -1) {
                item.usarItemDeStatus(indiceVetorStatus); 
            }        
        }
    }
    
    public void usarItemCuraIA() {
        float cura = 0;
        byte indiceVetorCuraIA = 0;
        
        if(this.vida < this.vidaTotal * 0.25f) { 
            
            for(byte i = 0; i <= 2; i++) {
                if(item.tipo[i].equals("Heal") && cura < item.qtdCura[i] && item.usosDisponiveis[i] > 0) {             
                        cura = item.qtdCura[i];
                        indiceVetorCuraIA = i;
                }      
            }            
            if(cura > 0) {
                item.usarItemDeCura(indiceVetorCuraIA);
            }
        }
    }
}
