package ui.telamenu.campo;

import ui.telamenu.camposuperclasse.CampoTxtInstrucaoA;

public class CampoTxtMenuInstrucao extends CampoTxtInstrucaoA {
    
    public CampoTxtMenuInstrucao() {
        super(new String[]{"COMANDOS TECLADO:", "W, A, S e D (Navega pelas opções)", 
            "J (Realiza ação dentro do campo)", "K (Volta ao menu/contexto anterior)"});
    }  
}
