/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend.Objects.Cells;

import Backend.Utilities.CellType;

/**
 *
 * @author jose_
 */
public class ExitCell extends Cell {
    
    private int goldNeeded;
    
    public ExitCell(boolean isVisible, int goldNeeded) {
        super(isVisible, CellType.EXIT_CELL);
        this.goldNeeded = goldNeeded;
    }
    
    public void setGoldNeeded(int goldNeeded){
        this.goldNeeded = goldNeeded;
    }
    
    public int getGoldNeeded(){
        return this.goldNeeded;
    }
    
}
