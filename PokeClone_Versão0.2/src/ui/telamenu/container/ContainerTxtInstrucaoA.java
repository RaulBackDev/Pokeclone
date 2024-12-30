package ui.telamenu.container;

import ui.ContainerTxt;

public class ContainerTxtInstrucaoA extends ContainerTxt {
    
    public ContainerTxtInstrucaoA( ) {
        super.setTamanho((short)500, (short)220);
        super.setPos(calcularPosX(), (short)100);
    }

    private short calcularPosX() {
        return (short)(370 - largura/2);
    }
}
