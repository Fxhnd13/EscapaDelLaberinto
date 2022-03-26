/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend.objects;

import backend.objects.cells.ExitCell;
import backend.objects.cells.GoldCell;
import backend.objects.cells.PathCell;
import backend.objects.cells.PlayerCell;
import javax.swing.JOptionPane;

/**
 *
 * @author Soberanis
 */
public class Game {
    
    private Map map;
    
    public Game(Map map){
        this.map = map;
        this.map.putPlayer();
    }
    
    public boolean verifyErrors(){
        return this.map.getPlayerCell().getPlayer().getErrors()>=3;
    }

    public void pickUpGold() {
        PlayerCell cell = this.map.getPlayerCell();
        if(cell.getUnderCell() instanceof GoldCell){
            cell.getPlayer().setGold(cell.getPlayer().getGold()+((GoldCell)cell.getUnderCell()).getGoldAmount());
            JOptionPane.showMessageDialog(null, "Has recogido "+((GoldCell)cell.getUnderCell()).getGoldAmount()+" de oro", "Información", JOptionPane.INFORMATION_MESSAGE);
            cell.setUnderCell(new PathCell());
        }else{
            penalizePlayer(cell);
        } 
    }

    private void penalizePlayer(PlayerCell cell) {
        if(cell.getPlayer().getGold()>0){
            int lostGold = (int) Math.random()*cell.getPlayer().getGold();
            cell.getPlayer().setGold(cell.getPlayer().getGold()-lostGold);
            this.map.setPathCellToGoldCell(lostGold);
        }
        cell.getPlayer().plusError();
        JOptionPane.showMessageDialog(null, "Has ejecutado una acción incorrecta, llevas: "+this.map.getPlayerCell().getPlayer().getErrors());
    }

    public boolean exitMap() {
        PlayerCell cell = this.map.getPlayerCell();
        if(cell.getUnderCell() instanceof ExitCell){
            if(cell.getPlayer().getGold() >= ((ExitCell)cell.getUnderCell()).getGoldNeeded()){
                return true;
            }
        }else{
            penalizePlayer(cell);
        }
        return false;
    }

    public int goldRequired() {
        PlayerCell cell = this.map.getPlayerCell();
        if(cell.getUnderCell() instanceof ExitCell){
            return ((ExitCell)cell.getUnderCell()).getGoldNeeded();
        }else{
            penalizePlayer(cell);
        }
        return -1;
    }

    public void showPlayerStatistic() {
        Player player = this.map.getPlayerCell().getPlayer();
        JOptionPane.showMessageDialog(null, "Oro final: "+player.getGold()+"\nMovimientos realizados: "+player.getMovements(), "Estadisticas de partida", JOptionPane.INFORMATION_MESSAGE);
    }

    public void moveUp() { this.map.movePlayer(0,-1); }

    public void moveLeft() { this.map.movePlayer(-1,0); }

    public void moveDown() { this.map.movePlayer(0, 1); }

    public void moveRight() { this.map.movePlayer(1,0); }

    public Map getMap() {
        return map;
    }

    public void setMap(Map map) {
        this.map = map;
    }
    
}
