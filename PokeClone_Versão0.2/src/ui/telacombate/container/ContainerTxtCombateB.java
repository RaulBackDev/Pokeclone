package ui.telacombate.container;

import ui.ContainerTxt;

public class ContainerTxtCombateB extends ContainerTxt {
   
    public ContainerTxtCombateB(ContainerTxtCombateA containerTxt) {      
        
        super.setDimensoesContainer(calcularPosX(containerTxt), containerTxt.posY,
                calcularLargura(containerTxt), containerTxt.altura);
    }
    
    private short calcularLargura(ContainerTxtCombateA containerTxt) {
        
        // Essa equação faz o container especializado ter a maior largura possível, 
        // subtraindo todos pixels já utilizados na tela
        return (short)(768 - containerTxt.largura - containerTxt.posX * 3);
    }
    
    private short calcularPosX(ContainerTxtCombateA containerTxt) {
        
        // Essa equação faz o espaço entre os Containers ser sempre igual
        return (short)(containerTxt.largura + containerTxt.posX * 2);
    }
}
