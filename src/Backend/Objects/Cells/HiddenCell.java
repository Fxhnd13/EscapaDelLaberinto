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
 * @author Soberanis
 * Clase que sirve para mostrar en pantalla las casillas ocultas o bien, las que se encuentran fuera de los limites del mapa
 */
public class HiddenCell implements Cell{

    @Override
    public void setImage(boolean isVisible, JLabel label) {
        ImageIcon imagen = new ImageIcon(getClass().getResource(CellResource.HIDDEN_CELL.resource()));
        label.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_DEFAULT)));
    }
    
    @Override
    public Object clone() throws CloneNotSupportedException{
        return super.clone();
    }
}
