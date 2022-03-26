/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend.objects;

import backend.objects.cells.Cell;
import backend.objects.cells.ExitCell;
import backend.objects.cells.GoldCell;
import backend.objects.cells.HiddenCell;
import backend.objects.cells.PathCell;
import backend.objects.cells.PlayerCell;
import backend.objects.cells.WallCell;
import java.util.ArrayList;

/**
 *
 * @author jose_
 */
public class Map {
    
    private Position playerPosition;
    private Cell[][] cells;
    private String name;
    
    public Map(int rows, int columns, String name){
        this.cells = new Cell[rows][columns];
        this.name = name;
    }

    public Map(Map map) {
        this.name = map.getName();
        this.cells = new Cell[map.getCells().length][map.getCells()[0].length];
        for (int i = 0; i < map.getCells().length; i++) {
            for (int j = 0; j < map.getCells().length; j++) {
                try {
                    this.cells[i][j] = (Cell) map.getCells()[i][j].clone();
                } catch (CloneNotSupportedException ex) {
                    System.out.println(ex);
                }
            }
        }
    }
    
    public void movePlayer(int x, int y){
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
                playerPosition.setY(playerPosition.getY()+(y)); //modificamos la posición en la que se encuentra el jugador
                playerPosition.setX(playerPosition.getX()+(x)); //modificamos la posición en la que se encuentra el jugador
                playerCell.getPlayer().plusMovement();
            }
        }catch(IndexOutOfBoundsException ex){
            System.out.println("No te puedes mover fuera del mapa");
        }
    }
    
    public ArrayList<Cell> getSurroundedCells(int visionRange, boolean isLinternOn){
        int visionValue = (visionRange-1)/2;
        ArrayList<Cell> cells = new ArrayList<Cell>();
        for (int i = this.playerPosition.getY()-visionValue; i <= this.playerPosition.getY()+visionValue; i++) {
            if(i>=0 && i < this.cells.length){
                for (int j = this.playerPosition.getX()-visionValue; j <= this.playerPosition.getX()+visionValue; j++) {
                    if(j>=0 && j < this.cells[i].length){
                        cells.add(this.cells[i][j]);
                    }else{
                        cells.add(new HiddenCell());
                    }
                }
            }else{
                for (int j = 0; j < (visionValue*2)+1; j++) {
                    cells.add(new HiddenCell());
                }
            }
        }
        return cells;
    }

    public void putPlayer() {
        removePlayer();
        boolean isPlayerInMap = false;
        while(!isPlayerInMap){
            int row = (int)(Math.random()*(this.cells.length-1));
            int column = (int)(Math.random()*(this.cells[0].length-1));
            if(this.cells[row][column] instanceof PathCell){
                isPlayerInMap = true;
                Cell cell = this.getCells()[row][column];
                this.cells[row][column] = new PlayerCell(cell, new Player());
                this.playerPosition = new Position(row,column);
            }
        }
    }

    public void setPathCellToGoldCell(int lostGold) {
        boolean isGoldInCell = false;
        while(!isGoldInCell){
            int row = (int)(Math.random()*(this.cells.length-1));
            int column = (int)(Math.random()*(this.cells[0].length-1));
            if(this.cells[row][column] instanceof PathCell){
                isGoldInCell = true;
                this.cells[row][column] = new GoldCell(lostGold);
            }
        }
    }
    
    private void removePlayer(){
        if(this.playerPosition != null){
            this.cells[this.playerPosition.getY()][this.playerPosition.getX()] = new PathCell();
            this.playerPosition = null;
        }
    }
    
    public PlayerCell getPlayerCell(){
        return (PlayerCell) this.cells[this.playerPosition.getY()][this.playerPosition.getX()];
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

    public String getName() {
        return this.name;
    }

    public void setName(String nombre) {
        this.name = nombre;
    }
}
