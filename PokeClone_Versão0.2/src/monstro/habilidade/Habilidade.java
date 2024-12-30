package monstro.habilidade;

import monstro.monstrosuperclasse.Monstro;

public class Habilidade {
    Monstro monstro;
    
    public float[] dano = new float[3];
    public String[] nome = new String[3];
    public String[] tipo = new String[3];// fire, water, grass
    public String[] status = new String[3];// ex: burn
    public String[] efeito = new String[3];// ex: drain
    public byte[] usosDisponiveis = new byte[3];
    
    public Habilidade(Monstro monstro) {
        this.monstro = monstro;
        ConfiguradorDeHabilidade.setHabilidadesMonstro(this);
    }
    
    // efeito negativo de status
    public void efeitoNegativoDeStatus() {// Efeitos negativos no próprio status
        if(monstro.status.equals("Confused")) {
            confused();
        }
    }   
    
    public void confused() {// Enquanto em efeito de confusão possui chance de pular o round
        int resultado = monstro.randomizador.nextInt(10);
        
        if(resultado < 2) {
            monstro.turno = false;
        }
    }
    
    // Efeito especial da habilidade
    public void usarEfeitoEspecialHabilidade(byte indice) {
        switch(nome[indice]) {
            
            case "Giga drain":
                efeitoGigaDrain();
                break;
        }
    }
    
    public void efeitoGigaDrain() {
        monstro.vida += monstro.oponente.vida * 0.25;
    }
    
    // Atacar status oponente
    public void atacarStatusOponente(byte indiceVetor) {
        if(monstro.oponente.status.equals("Normal")) {             
            causarConfusion(indiceVetor);
        } 
    }      
    
    public void causarConfusion(byte indiceVetor) {
        int resultado = monstro.randomizador.nextInt(10);
        
        if(monstro.habilidade.tipo[indiceVetor].equals("Normal") && resultado < 3) {// tipo da sua habilidade = normal
            monstro.oponente.status = "Confused";
        } 
    }
       
    // Vantagem de tipo
    public void setVantagemDeTipo() {
        switch(monstro.oponente.tipo) {   
            
            case "Fire":// tipo oponente = fogo     
                vantagemAtaque("Water", "Grass");// Forte contra grama, fraco conta água
                break;
            
            case "Water":// tipo oponente = água        
                vantagemAtaque("Grass", "Fire");// Forte contra fogo, fraca contra grama           
                break;  
                
            case "Grass":// tipo oponente = grama         
                vantagemAtaque("Fire", "Water");// Forte contra agua, fraca contra fogo
                break;
        }
    }
    
    public void vantagemAtaque(String tipoHabilideForteContraOponente, String tipoHabilideFracaContraOponente) {
        for(byte i = 0; i <= 2; i++) {
            
            if(this.tipo[i].equals(tipoHabilideForteContraOponente)) {
                this.dano[i] = this.dano[i] * 1.5f;
            }   
            else if(this.tipo[i].equals(tipoHabilideFracaContraOponente)) {
                this.dano[i] = this.dano[i] * 0.75f;
            }
        } 
    }
}
