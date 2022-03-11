/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend.Objects.Cells;

import Backend.Utilities.CellType;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author jose_
 */
public abstract class Cell {
    
    private boolean isVisible;
    private CellType type;
    
    public Cell(boolean isVisible, CellType type){
        this.isVisible = isVisible;
        this.type = type;
    }
    
    public void setImage(boolean visibility, JLabel label){
        ImageIcon imagen = null;
        if(isVisible && !visibility){
            imagen = new ImageIcon(getClass().getResource("/media/oculto.png"));
        }else{
            switch(this.type){
                case EXIT_CELL -> imagen = new ImageIcon(getClass().getResource("/media/salida.jpg"));
                case GOLD_CELL -> imagen = new ImageIcon(getClass().getResource("/media/moneda.jpg"));
                case PLAYER_CELL -> imagen = new ImageIcon(getClass().getResource("/media/player.webp"));
                case WALL_CELL -> imagen = new ImageIcon(getClass().getResource("/media/wall.webp"));
                case PATH_CELL -> imagen = new ImageIcon(getClass().getResource("/media/camino.png"));
            }
        }
        label.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_DEFAULT)));
        isVisible = visibility;
    }
    
    public void setVisible(boolean isVisible){
        this.isVisible = isVisible;
    }
    
    public boolean isVisible(){
        return this.isVisible;
    }
    
}
