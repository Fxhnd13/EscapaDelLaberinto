
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend.objects.cells;
import javax.swing.JLabel;

/**
 *
 * @author jose_
 */
public interface Cell extends Cloneable{
    
    public void setImage(boolean isVisible, JLabel label);
    public Object clone() throws CloneNotSupportedException;
}
