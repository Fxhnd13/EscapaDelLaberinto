/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Frontend;

import Backend.Objects.Cells.*;
import Backend.Objects.Map;
import Backend.Objects.Player;
import Backend.Objects.Position;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author jose_
 */
public class Gameplay {
    
    private ArrayList<Map> maps;
    private Map actualMap;
    
    public Gameplay(){
        this.maps = new ArrayList<Map>();
    }
    
    public void play(){
        this.doMap();
        Scanner scanner = new Scanner(System.in);
        this.actualMap.setPlayerPosition(new Position(1,1));
        while(true){
            System.out.print("Ingrese la dirección a la que desea moverse: ");
            String direccion = scanner.nextLine();
            this.movePlayer(direccion);
            System.out.println("--------------------------------------------------------------------");
            System.out.println(this.actualMap.toString());
            System.out.println("--------------------------------------------------------------------");
        }
    }

    public void doMap(){
        actualMap = new Map(6,6);
        Cell[][] cells = {{new WallCell(false),new WallCell(false),new WallCell(false),new WallCell(false),new WallCell(false),new WallCell(false)},
                          {new WallCell(false),new PlayerCell(false, new PathCell(false), new Player()),new PathCell(false),new PathCell(false),new PathCell(false),new ExitCell(false, 5)},
                          {new WallCell(false),new PathCell(false),new GoldCell(8,false),new PathCell(false),new PathCell(false),new WallCell(false)},
                          {new WallCell(false),new PathCell(false),new PathCell(false),new GoldCell(6,false),new PathCell(false), new WallCell(false)},
                          {new WallCell(false),new PathCell(false),new PathCell(false),new PathCell(false),new PathCell(false),new WallCell(false)},
                          {new WallCell(false),new WallCell(false),new WallCell(false),new WallCell(false),new WallCell(false),new WallCell(false)}};
        actualMap.setCells(cells);
    }
    
    public ArrayList<Map> getMaps() {
        return maps;
    }

    public void setMaps(ArrayList<Map> maps) {
        this.maps = maps;
    }

    public Map getActualMap() {
        return actualMap;
    }

    public void setActualMap(Map actualMap) {
        this.actualMap = actualMap;
    }
    
    public void movePlayer(String direction){
        switch(direction){
            case "W" -> this.actualMap.moveUp();
            case "A" -> this.actualMap.moveLeft();
            case "S" -> this.actualMap.moveDown();
            case "D" -> this.actualMap.moveRight();
        }
    }
}
