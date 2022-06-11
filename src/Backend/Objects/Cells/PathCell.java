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
 * Clase que almacena la información de una casilla de tipo camino
 */
public class PathCell implements Cell {
    
    public PathCell() {
    }

    @Override
    public void setImage(boolean isVisible, JLabel label) {
        ImageIcon image = null;
        if(isVisible){
            image = new ImageIcon(getClass().getResource(CellResource.PATH_CELL.resource()));
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
