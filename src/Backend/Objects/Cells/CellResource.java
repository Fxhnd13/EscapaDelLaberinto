/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package backend.objects.cells;

/**
 *
 * @author Soberanis
 */
public enum CellResource {
    GOLD_CELL("/media/moneda.jpg"),
    WALL_CELL("/media/wall.png"),
    PLAYER_CELL("/media/player.jpg"),
    EXIT_CELL("/media/salida.jpg"),
    PATH_CELL("/media/camino.png"),
    HIDDEN_CELL("/media/oculto.png");
    
    private final String resource;
    CellResource(String resource){
        this.resource = resource;
    }
    public String resource(){ return resource; }
}
