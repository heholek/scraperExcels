/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IO;

/**
 *
 * @author soporte
 */
public class celda {
    private String cel;
    private int row,col;
    public celda(String cel){
        this.cel=cel;
        char aux = cel.charAt(0);
        switch(aux){
            case 'a':
                row = 0;
                break;
            case 'b':
                row = 1;
                break;
            case 'c':
                row = 2;
                break;
            case 'd':
                row = 3;
                break;
            case 'e':
                row = 4;
                break;
            case 'f':
                row = 5;
                break;
            case 'g':
                row = 6;
                break;
            case 'h':
                row = 7;
                break;
            case 'i':
                row = 8;
                break;
            case 'j':
                row = 9;
                break;
            default:
                row = 0;
                break;
        }
        col = Integer.parseInt(cel.substring(1))-1;
    }
    public int getRow(){
        
        
        return this.col;
    }
    public int getCol(){
        
        return this.row;
    }
}
