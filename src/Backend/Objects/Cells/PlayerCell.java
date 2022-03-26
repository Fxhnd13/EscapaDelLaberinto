/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend.objects.cells;

import backend.objects.Player;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author jose_
 */
public class PlayerCell implements Cell {
    
    private Player player;
    private Cell underCell;

    public PlayerCell(Cell underCell, Player player) {
        this.underCell = underCell;
        this.player = player;
    }
    
    public void setUnderCell(Cell underCell){
        this.underCell = underCell;
    }
    
    public Cell getUnderCell(){
        return this.underCell;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    @Override
    public void setImage(boolean isVisible, JLabel label) {
        ImageIcon imagen = new ImageIcon(getClass().getResource(CellResource.PLAYER_CELL.resource()));
        label.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_DEFAULT)));
    }
    
    @Override
    public Object clone() throws CloneNotSupportedException{
        return super.clone();
    }
}
