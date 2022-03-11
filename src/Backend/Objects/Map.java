/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend.Objects;

import Backend.Objects.Cells.Cell;
import Backend.Objects.Cells.ExitCell;
import Backend.Objects.Cells.GoldCell;
import Backend.Objects.Cells.PathCell;
import Backend.Objects.Cells.PlayerCell;
import Backend.Objects.Cells.WallCell;

/**
 *
 * @author jose_
 */
public class Map {
    
    private Position playerPosition;
    private Cell[][] cells;
    
    public Map(int rows, int columns){
        this.cells = new Cell[rows][columns];
    }

    public Position getPlayerPosition() {
        return playerPosition;
    }

    public void setPlayerPosition(Position playerPosition) {
        this.playerPosition = playerPosition;
    }

    public Cell[][] getCells() {
        return cells;
    }

    public void setCells(Cell[][] cells) {
        this.cells = cells;
    }

    public void moveUp() { this.movePlayer(0,-1); }

    public void moveLeft() { this.movePlayer(-1,0); }

    public void moveDown() { this.movePlayer(0, 1); }

    public void moveRight() { this.movePlayer(1,0); }
    
    private void movePlayer(int x, int y){
        try{
            PlayerCell playerCell = ((PlayerCell) this.cells[playerPosition.getY()][playerPosition.getX()]); //Obtenemos la celda donde esta el jugador
            Cell aux = playerCell.getUnderCell(); //Almacenamos temporalmente la celda sobre la que se encuentra el jugador
            Cell newCell = this.cells[playerPosition.getY()+(y)][playerPosition.getX()+(x)];
            if(newCell instanceof WallCell){
                System.out.println("No te puedes mover sobre un muro");
            }else{
                playerCell.setUnderCell(newCell); //Cambiamos la celda sobre la que se encuentra el jugador
                this.cells[playerPosition.getY()+(y)][playerPosition.getX()+(x)] = playerCell; //Cambiamos la celda a la que se moverá por una celda tipo jugador
                this.cells[playerPosition.getY()][playerPosition.getX()] = aux; //Colocamos la celda que estaba debajo del jugador en la posición donde estaba
                playerPosition.setX(playerPosition.getX()+(x)); //modificamos la posición en la que se encuentra el jugador
                playerPosition.setY(playerPosition.getY()+(y)); //modificamos la posición en la que se encuentra el jugador
            }
        }catch(IndexOutOfBoundsException ex){
            System.out.println("No te puedes mover fuera del mapa");
        }
    }
    
    public String toString(){
        String map = "";
        for (int i = 0; i < this.cells.length; i++) {
            for (int j = 0; j < this.cells[i].length; j++) {
                if(this.cells[i][j] instanceof WallCell){
                    map+=" # ";
                }else if(this.cells[i][j] instanceof PathCell){
                    map+=" O ";
                }else if(this.cells[i][j] instanceof GoldCell){
                    map+=" G ";
                }else if(this.cells[i][j] instanceof ExitCell){
                    map+=" S ";
                }else if(this.cells[i][j] instanceof PlayerCell){
                    map+=" J ";
                }
            }
            map+="\n";
        }
        return map;
    }
}
