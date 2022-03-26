/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package frontend;

import backend.objects.Game;
import backend.objects.Map;
import backend.utilities.MapCreator;
import java.util.ArrayList;
import javax.swing.JComboBox;

/**
 *
 * @author jose_
 */
public class GameViewController {
    
    private ArrayList<Map> maps;
    private Game activeGame;
    
    public GameViewController(){
        this.maps = new ArrayList<Map>();
    }
    
    public ArrayList<Map> getMaps() {
        return maps;
    }

    public void setMaps(ArrayList<Map> maps) {
        this.maps = maps;
    }

    public Game getActiveGame() {
        return this.activeGame;
    }

    public void setActiveGame(Game activeGame) {
        this.activeGame = activeGame;
    }
    
    public void movePlayer(int direction){
        switch(direction){
            case 38 -> this.activeGame.moveUp();
            case 37 -> this.activeGame.moveLeft();
            case 40 -> this.activeGame.moveDown();
            case 39 -> this.activeGame.moveRight();
        }
    }

    public void createNewMap(JComboBox mapSelector) {
        MapCreator creator = new MapCreator();
        Map map = creator.createMap();
        this.maps.add(map);
        mapSelector.addItem(map.getName());
    }

    public void pickUpGold() {
        this.activeGame.pickUpGold();
    }

    public boolean exitMap() {
        return this.activeGame.exitMap();
    }

    public int goldRequired() {
        return this.activeGame.goldRequired();
    }
    
    public boolean verifyErrors(){
        return this.activeGame.verifyErrors();
    }

    public void selectMap(int selectedIndex) {
        this.activeGame = new Game(new Map(this.maps.get(selectedIndex)));
    }
    
    public boolean isInActiveGame(){
        return this.activeGame!=null;
    }

    public void finishGame() {
        this.activeGame = null;
    }
}
