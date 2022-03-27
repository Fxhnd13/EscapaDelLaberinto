/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend.utilities;

import backend.objects.Map;
import backend.objects.cells.Cell;
import backend.objects.cells.ExitCell;
import backend.objects.cells.GoldCell;
import backend.objects.cells.PathCell;
import backend.objects.cells.WallCell;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author Soberanis
 */
public class MapCreator {
    
    public Map createMap(){
        Map map = null;
        try {   
            File file = selectFile();
            if(file!=null){
                Cell[][] cells = setDimensions(file);
                Scanner sc = new Scanner(file);
                int i=0,j=0;
                while(sc.hasNext()){
                    String[] lineValues = sc.nextLine().split(",");
                    for (String value : lineValues) {
                        String[] valueParameters = value.split("-");
                        switch(valueParameters[0]){
                            case "#": cells[i][j] = createWallCell(); break;
                            case "O": cells[i][j] = createPathCell(); break;
                            case "G": cells[i][j] = createGoldCell(valueParameters); break;
                            case "S": cells[i][j] = createExitCell(valueParameters); break;
                        }
                        j++;
                    }
                    j=0;
                    i++;
                }
                fillNullCells(cells);
                String name = JOptionPane.showInputDialog(null, "Por favor ingrese el nombre que tendrá el mapa cargado", "Nombre mapa", JOptionPane.INFORMATION_MESSAGE);
                map = new Map(cells.length,cells[0].length, name);
                map.setCells(cells);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(MapCreator.class.getName()).log(Level.SEVERE, null, ex);
        }
        return map;
    }
    
    public File selectFile() throws FileNotFoundException{
        JFileChooser fileChooser = new JFileChooser();
        int respuesta = fileChooser.showOpenDialog(null);
        switch(respuesta){
            case JFileChooser.APPROVE_OPTION: return fileChooser.getSelectedFile();
            case JFileChooser.CANCEL_OPTION: break;
            case JFileChooser.ERROR_OPTION: break;
        }
        return null;
    }
    
    public Cell[][] setDimensions(File file) throws FileNotFoundException{
        int rows = 0;
        int maxColumns = 0;
        Scanner sc = new Scanner(file);
        while(sc.hasNext()){
            rows++;
            String linea = sc.nextLine();
            if(linea.split(",").length > maxColumns) maxColumns = linea.split(",").length;
        }
        return new Cell[rows][maxColumns];
    }
    
    private Cell createGoldCell(String[] values){
        return new GoldCell(Integer.parseInt(values[1]));
    }
    
    private Cell createExitCell(String[] values){
        return new ExitCell(Integer.parseInt(values[1]));
    }
    
    private Cell createPathCell(){
        return new PathCell();
    }
    
    private Cell createWallCell(){
        return new WallCell();
    }

    private void fillNullCells(Cell[][] cells) {
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[i].length; j++) {
                if(cells[i][j] == null) cells[i][j] = createWallCell();
            }
        }
    }
    
}