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
public class GoldCell extends Cell {
    
    private int goldAmount;

    public GoldCell(int goldAmount, boolean isVisible){
        super(isVisible, CellType.GOLD_CELL);
        this.goldAmount = goldAmount;
    }

    public int getGoldAmount() {
        return goldAmount;
    }

    public void setGoldAmount(int goldAmount) {
        this.goldAmount = goldAmount;
    }
    
}
