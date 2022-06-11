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
 * 
 * Clase que almacena la información de un juego en específico (una partida activa)
 */
public class Game {
    
    private Map map;
    
    public Game(Map map){
        this.map = map;
        this.map.putPlayer();
    }
    
    /**
     * Función que verifica si un jugador ha tenido más de tres equivocaciones para reiniciar el juego
     * @return true si ha tenido tres o más errores, falso de otra forma
     */
    public boolean verifyErrors(){
        return this.map.getPlayerCell().getPlayer().getErrors()>=3;
    }

    /**
     * Metodo utilizado para recoger el oro de una casilla que se encuentra debajo del jugador
     */
    public void pickUpGold() {
        PlayerCell cell = this.map.getPlayerCell(); //Obtiene la casilla en la que se encuentra el jugador
        if(cell.getUnderCell() instanceof GoldCell){ //Verifica que la casilla sobre la que se encuentra el jugador sea de oro
            cell.getPlayer().setGold(cell.getPlayer().getGold()+((GoldCell)cell.getUnderCell()).getGoldAmount()); //Modificamos la cantidad de oro del jugador
            JOptionPane.showMessageDialog(null, "Has recogido "+((GoldCell)cell.getUnderCell()).getGoldAmount()+" de oro", "Información", JOptionPane.INFORMATION_MESSAGE); //Mensaje informativo
            cell.setUnderCell(new PathCell()); //Modificamos la casilla sobre la que se encontraba de oro -> camino
        }else{
            penalizePlayer(cell); //Si no es una casilla de oro sobre la que se encuentra pero ejecutó el recoger oro, se penaliza
        } 
    }
    
    /**
     * Metodo para penalizar al jugador (restándole oro y colocándolo en una nueva posición del mapa)
     * @param cell Casilla en la que se encuentra el jugador
     */
    private void penalizePlayer(PlayerCell cell) {
        if(cell.getPlayer().getGold()>0){
            int lostGold = (int) Math.random()*cell.getPlayer().getGold();
            cell.getPlayer().setGold(cell.getPlayer().getGold()-lostGold);
            this.map.setPathCellToGoldCell(lostGold);
        }
        cell.getPlayer().plusError();
        JOptionPane.showMessageDialog(null, "Has ejecutado una acción incorrecta, llevas: "+this.map.getPlayerCell().getPlayer().getErrors());
    }

    /**
     * Funcion para que el jugador pueda salir del laberinto
     * @return Verdadero si puede salir, falso de otra manera
     */
    public boolean exitMap() {
        PlayerCell cell = this.map.getPlayerCell();
        if(cell.getUnderCell() instanceof ExitCell){
            if(cell.getPlayer().getGold() >= ((ExitCell)cell.getUnderCell()).getGoldNeeded()){
                return true;
            }
        }else{
            penalizePlayer(cell); //Penaliza al jugador si no se encuentra sobre una casilla salir
        }
        return false;
    }

    /**
     * Función para verificar el oro requerido en una salida pra poder salir
     * @return Un entero con la cantidad de oro necesario, -1 si no se encuentra sobre una casilla de salida
     */
    public int goldRequired() {
        PlayerCell cell = this.map.getPlayerCell();
        if(cell.getUnderCell() instanceof ExitCell){
            return ((ExitCell)cell.getUnderCell()).getGoldNeeded();
        }else{
            penalizePlayer(cell);
        }
        return -1;
    }

    /**
     * Funcion que muestra en pantalla todas las estadísticas del jugador en la partida que jugó
     */
    public void showPlayerStatistic() {
        Player player = this.map.getPlayerCell().getPlayer();
        JOptionPane.showMessageDialog(null, "Oro final: "+player.getGold()+"\nMovimientos realizados: "+player.getMovements(), "Estadisticas de partida", JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * Mueve el jugador hacia arriba
     */
    public void moveUp() { this.map.movePlayer(0,-1); }

    /**
     * Mueve el jugador hacia la izquierda
     */
    public void moveLeft() { this.map.movePlayer(-1,0); }

    /**
     * Mueve el jugador hacia abajo
     */
    public void moveDown() { this.map.movePlayer(0, 1); }

    /**
     * Mueve el jugador hacia la derecha
     */
    public void moveRight() { this.map.movePlayer(1,0); }

    /**
     * Retorna el mapa que se está jugando actualmente
     * @return 
     */
    public Map getMap() {
        return map;
    }

    public void setMap(Map map) {
        this.map = map;
    }
    
}
