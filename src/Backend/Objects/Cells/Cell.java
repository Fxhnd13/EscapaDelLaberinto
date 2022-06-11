
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend.objects.cells;
import javax.swing.JLabel;

/**
 *
 * @author jose_
 * Clase 'casilla' de la que heredan todas las casillas posibles en el juego camino, muro, oro, salida, de jugador, etc.
 */
public interface Cell extends Cloneable{
    
    /**
     * Metodo para colocar en el label enviado de parametro la imagen que posea la casilla almacenada (según su tipo)
     * @param isVisible (si se encuentra la linterta encendida)
     * @param label (Label al que queremos colocar la imagen)
     */
    public void setImage(boolean isVisible, JLabel label);
    public Object clone() throws CloneNotSupportedException;
}
