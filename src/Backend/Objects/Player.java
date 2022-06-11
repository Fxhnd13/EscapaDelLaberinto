/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend.objects;

/**
 *
 * @author jose_
 * Clase que almacena la información de un jugador
 */
public class Player {
    
    private int gold, movements;
    private int errors;
    
    public Player(){
        this.gold = 0;
        this.movements = 0;
        this.errors = 0;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public int getMovements() {
        return movements;
    }

    public void setMovements(int movements) {
        this.movements = movements;
    }

    public void setErrors(int errors) {
        this.errors = errors;
    }

    public int getErrors() {
        return errors;
    }
    
    public void plusError(){
        this.errors++;
    }
    
    public void plusMovement(){
        this.movements++;
    }
}
