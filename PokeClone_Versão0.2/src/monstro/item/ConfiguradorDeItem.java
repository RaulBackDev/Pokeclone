package monstro.item;

import monstro.item.acervoitem.AcervoItemCura;
import monstro.item.acervoitem.AcervoItemStatus;

public class ConfiguradorDeItem {  
    static AcervoItemCura acervoCura;
    static AcervoItemStatus acervoStatus;
    
    public static String[] tipoItem = new String[]{"Heal", "Status"};// [0] = cura, [1] = status
    
    public static void setItem(Item item) {
        
       // Item 0
       item.qtdCura[0] = acervoCura.qtdCura[0];// Vida +50
       item.usosDisponiveis[0] = acervoCura.usosItem[0];
       item.tipo[0] = tipoItem[0];// Cura
       item.nome[0] = acervoCura.nomeItem[0];// Poção
       
       // Item 1
       item.qtdCura[1] = acervoCura.qtdCura[1];// Vida +80
       item.usosDisponiveis[1] = acervoCura.usosItem[1];
       item.tipo[1] = tipoItem[0];// Cura
       item.nome[1] = acervoCura.nomeItem[1];// Super Poção
       
       // Item 2
       item.usosDisponiveis[2] = acervoStatus.usosItemStatus[0];
       item.tipo[2] = tipoItem[1];// Status
       item.nome[2] = acervoStatus.nomeItemDeStatus[0];// Burnheal    
    }
}
