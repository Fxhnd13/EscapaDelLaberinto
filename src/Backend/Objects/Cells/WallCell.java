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
public class WallCell extends Cell {
    
    public WallCell(boolean isVisible) {
        super(isVisible, CellType.WALL_CELL);
    }
    
}
