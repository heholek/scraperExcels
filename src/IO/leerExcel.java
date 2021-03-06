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

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import java.io.FileOutputStream;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

public class leerExcel {

    private static final String FILE_NAME = "Consolidado Mar-2018(1).xlsx";

   
    public  void escribir(){
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Datatypes in Java");
        Object[][] datatypes = {
                {"Datatype", "Type", "Size(in bytes)"},
                {"int", "Primitive", 2},
                {"float", "Primitive", 4},
                {"double", "Primitive", 8},
                {"char", "Primitive", 1},
                {"String", "Non-Primitive", "No fixed size"}
        };

        int rowNum = 0;
        System.out.println("Creating excel");

        for (Object[] datatype : datatypes) {
            Row row = sheet.createRow(rowNum++);
            int colNum = 0;
            for (Object field : datatype) {
                Cell cell = row.createCell(colNum++);
                if (field instanceof String) {
                    cell.setCellValue((String) field);
                } else if (field instanceof Integer) {
                    cell.setCellValue((Integer) field);
                }
            }
        }

        try {
            FileOutputStream outputStream = new FileOutputStream(FILE_NAME);
            workbook.write(outputStream);
            workbook.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Done");
    }
    public static void leer(){
        try {
            
            FileInputStream excelFile = new FileInputStream(new File(FILE_NAME));
           
            Workbook workbook = new XSSFWorkbook(excelFile);
            Sheet datatypeSheet = workbook.getSheetAt(0);
            Iterator<Row> iterator = datatypeSheet.iterator();
            /*
            celda c = new celda("e26");
            Cell auxC = datatypeSheet.getRow(c.getRow()).getCell(c.getCol());
            if(auxC.getCellType() == CellType.FORMULA) {
                System.out.println("test: "+auxC.getNumericCellValue());
            }
            else{
                System.out.println("test: "+auxC);
            }
            */
           // Cell auxC = datatypeSheet.getRow(c.getRow()).getCell(c.getCol());
            
            
            while (iterator.hasNext()) {

                Row currentRow = iterator.next();
                Iterator<Cell> cellIterator = currentRow.iterator();
                for (int i = 0; i < 10; i++) {
                    
                        Cell currentCell = currentRow.getCell(i);
                    //getCellTypeEnum shown as deprecated for version 3.15
                    //getCellTypeEnum ill be renamed to getCellType starting from version 4.0
                    if(currentCell!=null){
                        if (currentCell.getCellTypeEnum() == CellType.STRING) {
                            System.out.print(currentCell.getStringCellValue() + "\t");
                        } else if (currentCell.getCellTypeEnum() == CellType.NUMERIC) {
                            System.out.print(currentCell.getNumericCellValue() + "\t");
                        }
                    }
                    
                }
                /*
                while (cellIterator.hasNext()) {

                    Cell currentCell = cellIterator.next();
                    //getCellTypeEnum shown as deprecated for version 3.15
                    //getCellTypeEnum ill be renamed to getCellType starting from version 4.0
                    if (currentCell.getCellTypeEnum() == CellType.STRING) {
                        System.out.print(currentCell.getStringCellValue() + "\t");
                    } else if (currentCell.getCellTypeEnum() == CellType.NUMERIC) {
                        System.out.print(currentCell.getNumericCellValue() + "\t");
                    }

                }
                */
                System.out.println();
                    
                
            }
                
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public Object readCell(String le){
        try {

            FileInputStream excelFile = new FileInputStream(new File(FILE_NAME));
           
            Workbook workbook = new XSSFWorkbook(excelFile);
            Sheet datatypeSheet = workbook.getSheetAt(0);
            Iterator<Row> iterator = datatypeSheet.iterator();

            celda c = new celda(le);
            Cell auxC = datatypeSheet.getRow(c.getRow()).getCell(c.getCol());
            if(auxC.getCellType() == CellType.FORMULA) {
                //System.out.println("test: "+auxC.getNumericCellValue());
                return auxC.getNumericCellValue();
            }
            else{
                //System.out.println("test: "+auxC);
                return auxC;
            }
            
            
           // Cell auxC = datatypeSheet.getRow(c.getRow()).getCell(c.getCol());
            
            /*
            while (iterator.hasNext()) {

                Row currentRow = iterator.next();
                Iterator<Cell> cellIterator = currentRow.iterator();

                while (cellIterator.hasNext()) {

                    Cell currentCell = cellIterator.next();
                    //getCellTypeEnum shown as deprecated for version 3.15
                    //getCellTypeEnum ill be renamed to getCellType starting from version 4.0
                    if (currentCell.getCellTypeEnum() == CellType.STRING) {
                        System.out.print(currentCell.getStringCellValue() + "--");
                    } else if (currentCell.getCellTypeEnum() == CellType.NUMERIC) {
                        System.out.print(currentCell.getNumericCellValue() + "--");
                    }

                }
                System.out.println();
                    
                
            }
                */
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        catch(Exception e){
            System.out.println("Expcetion: "+e);
        }
        return null;
    }
    public void readCellArray(String[] le){
        try {

            FileInputStream excelFile = new FileInputStream(new File(FILE_NAME));
           
            Workbook workbook = new XSSFWorkbook(excelFile);
            Sheet datatypeSheet = workbook.getSheetAt(0);
            Iterator<Row> iterator = datatypeSheet.iterator();

            for (int i = 0; i < le.length; i++) {
                celda c = new celda(le[i]);
                Cell auxC = datatypeSheet.getRow(c.getRow()).getCell(c.getCol());
                if(auxC.getCellType() == CellType.FORMULA) {
                    System.out.println(auxC.getNumericCellValue()+"\t");
                    //return auxC.getNumericCellValue();
                }
                else{
                    System.out.println(auxC+"\t");
                    //return auxC;
                }
            }
            
            
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        catch(Exception e){
            System.out.println("Expcetion: "+e);
        }
        //return null;
    }

    
}
