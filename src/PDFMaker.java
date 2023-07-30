
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.borders.Border;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.properties.TextAlignment;
import com.itextpdf.layout.properties.UnitValue;
import com.itextpdf.layout.properties.VerticalAlignment;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Deepanshu Sahu
 */
public class PDFMaker {
    
    private PdfDocument pdfFile;
    private ExcelFileData excelFile;
    private PageInfo pageConfiguration;
    
    public PDFMaker(PdfDocument dest, ExcelFileData src, PageInfo config)
    {
        pdfFile = dest;
        excelFile = src;
        pageConfiguration = config;
    }
    public void makePdf()
    {
        Document document = new Document(pdfFile, PageSize.A4);
        document.setMargins(0, 0, 0, 0);
        ObservableList<String> excelFileData = excelFile.getExcelFileData();
        Table table=null;
        Cell cell;
        for(int i=0;i<excelFileData.size();i++)
        {
            if(i%(pageConfiguration.getMaxCol()*pageConfiguration.getMaxRow())==0)
            {
                if(table!=null)
                    document.add(table);
                table = new Table(UnitValue.createPercentArray(excelFile.getNumberOfColumns())).useAllAvailableWidth();
                pageConfiguration.setTableProps(table);
            }
            
            cell = new Cell();
            pageConfiguration.setCellProps(cell);
            cell.add(new Paragraph(excelFileData.get(i)));
            table.addCell(cell);
        }
        document.close();
    }
    
    public static void main(String [] args) throws FileNotFoundException, IOException
    {
        String pdfPath="C:\\Users\\Deepanshu Sahu\\Desktop\\sample";
        String pdfFileName="New Pdf.pdf";
        File sourceFile = new File("D:\\CS\\projects\\COSIR\\Sample Data.xlsx");
        ExcelFileData excelFile = new ExcelFileData();
        excelFile.loadFile(sourceFile);
        PdfWriter writer = new PdfWriter(pdfPath+"\\"+pdfFileName);
        PdfDocument pdfFile = new PdfDocument(writer);
        PageInfo pageInfo = new PageInfo();
        pageInfo.setCellBorder(false);
        pageInfo.setTableBorder(false);
        PDFMaker pdfMaker = new PDFMaker(pdfFile,excelFile,pageInfo);
        
        pdfMaker.makePdf();
        Runtime.getRuntime().exec("\"C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe\" \"C:\\Users\\Deepanshu Sahu\\Desktop\\sample\\New Pdf.pdf\"");
        
    }
}
