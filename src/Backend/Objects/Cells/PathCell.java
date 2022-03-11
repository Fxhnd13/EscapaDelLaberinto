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
public class PathCell extends Cell {
    
    public PathCell(boolean isVisible) {
        super(isVisible, CellType.PATH_CELL);
    }
    
}
