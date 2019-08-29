/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transporte;

import IO.leerExcel;

/**
 *
 * @author soporte
 */
public class Transporte {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //System.out.println("asdf");
        leerExcel leer = new leerExcel();
        String[] obra1 = {"c5","f4","e13","c18","c20","d20","e20","f20","d22","f22","c25","c26","c27","c28","c29","d25","d26","d27","d28","d29","e25","e26","e27","e28","e29","f25","f26","f27","f28","f29","c30","c33","c34","c35","c36","d33","d34","d35","d36","e33","e34","e35","e36","f33","f34","f35","f36","c37","d37","e37","f37","c38","d38","e38","f38","c39","b40"};
        leer.readCellArray(obra1);
    }
    
}
