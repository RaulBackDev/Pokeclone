package monstro.item;

import monstro.monstrosuperclasse.Monstro;

public class Item { 
    // Monstro ao qual estes itens pertencem
    Monstro monstro;
    
    public float[] qtdCura = new float[3];
    public String[] nome = new String[3];
    public String[] tipo = new String[3];// 0 = Heal, 1 = Status  
    public byte[] usosDisponiveis = new byte[3];
    
    public Item(Monstro monstro) {
        this.monstro = monstro;
        ConfiguradorDeItem.setItem(this);
    }
    
    public void usarItemDeCura(byte indiceVetor) {  
        if(this.usosDisponiveis[indiceVetor] > 0) {
            this.usosDisponiveis[indiceVetor] -= 1;
            
            monstro.sfxMonstro.tocarSom((byte)1);
            monstro.vida += this.qtdCura[indiceVetor];   
            if(monstro.vida > monstro.vidaTotal) {
                monstro.vida = monstro.vidaTotal;
            }     
            monstro.turno = false;
            monstro.oponente.turno = true;
        }    
    }
    
    public void usarItemDeStatus(byte indiceVetor) {
        if(this.usosDisponiveis[indiceVetor] > 0) {
            
            switch(monstro.status) {
                
                case "Confused":
                    itemDeStatus(indiceVetor, "Confusion heal");
                    break;   
                
                // Adicionar mais itens de status +++++++++++++++++++++++++++++++++++++++++    
            }
        } 
    }
    
    private void itemDeStatus(byte indiceVetor, String nomeItemDeStatus) {    
        if(this.nome[indiceVetor].equals(nomeItemDeStatus)) {
            this.usosDisponiveis[indiceVetor] -= 1;      
            
            monstro.sfxMonstro.tocarSom((byte)1);
            monstro.status = "Normal";         
            monstro.turno = false;
            monstro.oponente.turno = true;
        }
    }
}
