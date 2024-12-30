package monstro.monstrosuperclasse;

import monstro.monstroextra.ConfiguradorDeMonstro;
import monstro.item.Item;
import monstro.habilidade.Habilidade;

import java.util.Random;
import main.Som;
import monstro.monstroextra.RenderMonstro;

public abstract class Monstro {    
    // Atributos básicos
    public byte id;// 0 = charizard, 1 = blastoise, 2 = venossauro
    public String nome, tipo;// Fire, Water, Grass
    public float vida, vidaTotal;
    public byte velocidade;
    public String status;// Normal, Confused  
    
    // Objetos da classe
    public Item item; public Habilidade habilidade;
    public RenderMonstro render;
    
    // Referência do MonstroInimigo
    public Monstro oponente; 
    
    // Lógica
    public Random randomizador = new Random();
    public boolean turno;
    
    public Som sfxMonstro = new Som((byte)1);
  
    public void preencherMonstro(byte id) {
        // Preenche os atributos básicos do monstro
        this.id = id;
        ConfiguradorDeMonstro.setMonstro(this);
        
        // Preenche os auxiliares
        item = new Item(this);
        habilidade = new Habilidade(this);
    }
    
    public void deletarMonstro() {
        this.id = -1;
        this.nome = null;
        this.tipo = null;
        this.vida = -1;
        this.vidaTotal = -1;
        this.velocidade = -1;
        this.status = null;
        
        this.render = null;
        this.item = null;
        this.habilidade = null;
        this.oponente = null;
        this.turno = false;
    }
}    

