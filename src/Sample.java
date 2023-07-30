
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.Style;
import com.itextpdf.layout.element.Table;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.properties.TextAlignment;
import com.itextpdf.layout.properties.VerticalAlignment;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class Sample {
    private static File excelFile;
    public  static void main(String [] args)
    {
        String pdfPath="C:\\Users\\Deepanshu Sahu\\Desktop\\sample";
       String pdfFileName="New Pdf.pdf";
        excelFile = new File("D:\\CS\\projects\\COSIR\\Sample Data.xlsx");
        FileInputStream fis;
        XSSFWorkbook wb = null;   
        try {
            fis = new FileInputStream(excelFile);
        
                wb = new XSSFWorkbook(fis);
            } catch (IOException ex) {
                Logger.getLogger(LabelMakerController.class.getName()).log(Level.SEVERE, null, ex);
            }
            XSSFSheet sheet = wb.getSheetAt(0);     
            Iterator<Row> itr = sheet.iterator(); 
            int i=0,j=0;
             PdfWriter writer = null;
        try {
            writer = new PdfWriter(pdfPath+"\\"+pdfFileName);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Sample.class.getName()).log(Level.SEVERE, null, ex);
        }
            PdfDocument pdf = new PdfDocument(writer);
             Document document = new Document(pdf, PageSize.A4);
        document.setMargins(0,0, 0,0);
        float cm=170F/7F;
        float w=cm*6.5F;
        float h=cm*3.782F;
        int cell_no=0;
            float []pointColWidth = {w,w,w};
            StringTokenizer t = new StringTokenizer("Hello Deepanshu");
            Style cellStyle = new Style().setWidth(w).setMinHeight(h).setMargin(0F).setVerticalAlignment(VerticalAlignment.MIDDLE).setTextAlignment(TextAlignment.CENTER);
            Table table=null;
            while (itr.hasNext())                 
            { 
//                if(j==0) htmlContent.append("<table>");
                
                if(cell_no==0) 
                {
                    table = new Table(pointColWidth);
                    table.setMinHeight(cm*29F);
                    table.setMarginTop(cm*.3f);
                    table.setMarginBottom(cm*1.f);
                    
                }
                Row row = itr.next();  
//                if(i==0)
//                    htmlContent.append("<tr>");
//                htmlContent.append("<td>");
                Iterator<Cell> cellIterator = row.cellIterator();
                String data="";
                while (cellIterator.hasNext())   
                {  
                    Cell cell = cellIterator.next();  
                    switch (cell.getCellType())               
                    {  
                        case Cell.CELL_TYPE_STRING:
//                            htmlContent.append(cell.getStringCellValue()+"<br>");
                            data=data+"\n"+cell.getStringCellValue();
                           //table.addCell(new com.itextpdf.layout.element.Cell().add(new Paragraph(data)));
                            break;  
                        case Cell.CELL_TYPE_NUMERIC: 
//                            htmlContent.append((long)(cell.getNumericCellValue())+"<br>");
                                data=data+"\n"+cell.getNumericCellValue();
//table.addCell(new com.itextpdf.layout.element.Cell().add(new Paragraph(""+cell.getNumericCellValue())));
                            break;  
                    }
                }  
                table.addCell(new com.itextpdf.layout.element.Cell().add(new Paragraph(data)).addStyle(cellStyle));
                    System.out.println(cell_no+"\n"+data);
                cell_no++;    
                if(cell_no==24)
                {
                    document.add(table);
                    cell_no=0;
                }
            }  
              
        
            //cell1.
            document.close();   
    }
    
}
