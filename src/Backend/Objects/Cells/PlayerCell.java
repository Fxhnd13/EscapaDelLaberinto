/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend.Objects.Cells;

import Backend.Objects.Player;
import Backend.Utilities.CellType;

/**
 *
 * @author jose_
 */
public class PlayerCell extends Cell {
    
    private Player player;
    private Cell underCell;

    public PlayerCell(boolean isVisible, Cell underCell, Player player) {
        super(isVisible, CellType.PLAYER_CELL);
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
    
}
