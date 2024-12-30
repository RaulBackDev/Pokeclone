package monstro.habilidade;

import monstro.habilidade.acervohabilidade.AcervoHabilidadeAgua;
import monstro.habilidade.acervohabilidade.AcervoHabilidadeFogo;
import monstro.habilidade.acervohabilidade.AcervoHabilidadeGrama;
import monstro.habilidade.acervohabilidade.AcervoHabilidadeNormal;

public class ConfiguradorDeHabilidade {   
    static AcervoHabilidadeFogo acervoFogo;
    static AcervoHabilidadeAgua acervoAgua;
    static AcervoHabilidadeGrama acervoGrama;
    static AcervoHabilidadeNormal acervoNormal;
    
    // Tipo habilidade [0](fire), [1](water), [2](grass), [3](normal) 
    public static String[] tipoDaHabilidade = new String[]{"Fire", "Water", "Grass", "Normal"};
   
    public static void setHabilidadesMonstro(Habilidade habilidade) {      
        switch(habilidade.monstro.id) {  
            
            case 0:// Charizard
                
                // Dano da habilidade
                habilidade.dano[0] = acervoFogo.danoHabilidade[0];// ember
                habilidade.dano[1] = acervoFogo.danoHabilidade[1];// flamerThrower
                habilidade.dano[2] = acervoNormal.danoHabilidade[0];// scratch
                
                // Tipo da habilidade
                habilidade.tipo[0] = tipoDaHabilidade[0];// Fogo
                habilidade.tipo[1] = tipoDaHabilidade[0];// Fogo
                habilidade.tipo[2] = tipoDaHabilidade[3];// Normal
                
                // Nome da habilidade
                habilidade.nome[0] = acervoFogo.nomeHabilidade[0];// Ember
                habilidade.nome[1] = acervoFogo.nomeHabilidade[1];// Flame thrower
                habilidade.nome[2] = acervoNormal.nomeHabilidade[0];// Scratch
                
                // Máximo de usos da habilidade
                habilidade.usosDisponiveis[0] = acervoFogo.usosDisponiveisHabilidade[0];
                habilidade.usosDisponiveis[1] = acervoFogo.usosDisponiveisHabilidade[1];
                habilidade.usosDisponiveis[2] = acervoNormal.usosDisponiveisHabilidade[0];
                break;   
                
            case 1:// Blastoise
                
                // Dano da habilidade
                habilidade.dano[0] = acervoAgua.danoHabilidade[1];// swim
                habilidade.dano[1] = acervoAgua.danoHabilidade[2];// hydroPump
                habilidade.dano[2] = acervoNormal.danoHabilidade[2];// kick
                
                // Tipo da habilidade
                habilidade.tipo[0] = tipoDaHabilidade[1];// Agua
                habilidade.tipo[1] = tipoDaHabilidade[1];// Agua
                habilidade.tipo[2] = tipoDaHabilidade[3];// Normal
                
                // Nome da habilidade
                habilidade.nome[0] = acervoAgua.nomeHabilidade[1];// Swim
                habilidade.nome[1] = acervoAgua.nomeHabilidade[2];// Hydro pump
                habilidade.nome[2] = acervoNormal.nomeHabilidade[2];// kick   
                
                // Máximo de usos da habilidade
                habilidade.usosDisponiveis[0] = acervoAgua.usosDisponiveisHabilidade[1];
                habilidade.usosDisponiveis[1] = acervoAgua.usosDisponiveisHabilidade[2];
                habilidade.usosDisponiveis[2] = acervoNormal.usosDisponiveisHabilidade[2];
                break;
                
            case 2:// Venossauro   
                
                // Dano da habilidade
                habilidade.dano[0] = acervoGrama.danoHabilidade[0];// gigaDrain
                habilidade.dano[1] = acervoGrama.danoHabilidade[2];// leafStorm
                habilidade.dano[2] = acervoNormal.danoHabilidade[1];// punch
                
                // Tipo da habilidade
                habilidade.tipo[0] = tipoDaHabilidade[2];// Grama
                habilidade.tipo[1] = tipoDaHabilidade[2];// Grama
                habilidade.tipo[2] = tipoDaHabilidade[3];// Normal
                
                // Nome da habilidade
                habilidade.nome[0] = acervoGrama.nomeHabilidade[0];// Giga drain
                habilidade.nome[1] = acervoGrama.nomeHabilidade[2];// Leaf storm
                habilidade.nome[2] = acervoNormal.nomeHabilidade[1];// punch
                
                // Máximo de usos da habilidade
                habilidade.usosDisponiveis[0] = acervoGrama.usosDisponiveisHabilidade[0];
                habilidade.usosDisponiveis[1] = acervoGrama.usosDisponiveisHabilidade[2];
                habilidade.usosDisponiveis[2] = acervoNormal.usosDisponiveisHabilidade[1];
                break;
        }
    }
}
