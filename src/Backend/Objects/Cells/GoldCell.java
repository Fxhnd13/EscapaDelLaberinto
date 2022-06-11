/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend.objects.cells;

import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author jose_
 * Clase que almacena la información de una casilla de oros
 */
public class GoldCell implements Cell{
    
    private int goldAmount;

    public GoldCell(int goldAmount){
        this.goldAmount = goldAmount;
    }

    public int getGoldAmount() {
        return goldAmount;
    }

    public void setGoldAmount(int goldAmount) {
        this.goldAmount = goldAmount;
    }

    @Override
    public void setImage(boolean isVisible, JLabel label) {
        ImageIcon image = null;
        if(isVisible){
            image = new ImageIcon(getClass().getResource(CellResource.GOLD_CELL.resource()));
        }else{
            image = new ImageIcon(getClass().getResource(CellResource.HIDDEN_CELL.resource()));
        }
        label.setIcon(new ImageIcon(image.getImage().getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_DEFAULT)));
    }
    
    @Override
    public Object clone() throws CloneNotSupportedException{
        return super.clone();
    }
}
