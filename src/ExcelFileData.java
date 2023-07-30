
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Deepanshu Sahu
 */
public class ExcelFileData {
    private int numberOfRows;
    private int numberOfColumns;
    private ObservableList<String> excelData;
    public ExcelFileData()
    {
        this.numberOfColumns = 0;
        this.numberOfRows = 0;
        this.excelData = FXCollections.observableArrayList();
    }
       
    public boolean loadFile(File excelFile)
    {
        FileInputStream fis;
        XSSFWorkbook wb = null;   
        try 
        {
            fis = new FileInputStream(excelFile);
            wb = new XSSFWorkbook(fis);
        } 
        catch (IOException ex) 
        {
            Logger.getLogger(LabelMakerController.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        XSSFSheet sheet = wb.getSheetAt(0);     
        Iterator<Row> itr = sheet.iterator(); 
        int i=0,j=0;
       while (itr.hasNext())                 
        { 
            this.numberOfRows++;
            Row row = itr.next();
            Iterator<Cell> cellIterator = row.cellIterator();
            String data="";
            this.numberOfColumns=0;
//            System.out.println(row.toString());
            while (cellIterator.hasNext())   
                {  
                    this.numberOfColumns++;
                    Cell cell = cellIterator.next();  
                    switch (cell.getCellType())               
                    {  
                        case Cell.CELL_TYPE_STRING:
                            data=data+"\n"+cell.getStringCellValue();
                            break;  
                        case Cell.CELL_TYPE_NUMERIC: 
                            data=data+"\n"+String.format("%.0f",cell.getNumericCellValue());
                            break;  
                    }
                }  
                this.excelData.add(data);
            }
       return true;
    }
    public int getNumberOfRows()
    {
        return this.numberOfRows;
    }
    public int getNumberOfColumns()
    {
        return this.numberOfColumns;
    }
    public ObservableList<String> getExcelFileData()
    {
        return this.excelData;
    }
    
//    class CellData
//    {
//        private int rowIndex;
//        private int colIndex;
//        private String data;
//    }
    
    
//    public  static void main(String [] args)
//    {
//        File excelFile = new File("D:\\CS\\projects\\COSIR\\Sample Data.xlsx");
//        ExcelFileData file = new ExcelFileData();
//        file.loadFile(excelFile);
//        System.out.println(file.getNumberOfRows()+"X"+file.getNumberOfColumns()+"\n"+file.getExcelFileData().toString());
//    }
    
}

