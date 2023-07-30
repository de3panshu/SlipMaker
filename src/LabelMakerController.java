/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.Iterator;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.stage.FileChooser;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * FXML Controller class
 *
 * @author Deepanshu Sahu
 */
public class LabelMakerController implements Initializable {

    @FXML
    private BorderPane borderPane;
    @FXML
    TableView<FileData> table;
    ObservableList<FileData> data;
    ObservableList<String> list;
    private final int NO_OF_COL=3;
    private File excelFile;
    private FileChooser fileChooser;
    @FXML
    private Label fileNameLabel;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        table = new TableView<FileData>();
        table.setStyle("-fx-font-size:26px");
        data = FXCollections.observableArrayList();
        //loadData();
        TableColumn name = new TableColumn("NAME");
        name.setMinWidth(300);
        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        TableColumn rno = new TableColumn("RNO");
        rno.setMinWidth(300);
        rno.setCellValueFactory(new PropertyValueFactory<>("rno"));
        TableColumn course = new TableColumn("COURSE");
        course.setMinWidth(300);
        course.setCellValueFactory(new PropertyValueFactory<>("course"));
        list = FXCollections.observableArrayList();
        table.setItems(data);
        table.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        table.getColumns().addAll(name,rno,course);
        borderPane.setCenter(table);
        
        //adding the file chooser  functionality
        fileChooser = new FileChooser();
        fileChooser.setTitle("Open EXCEL File");
        
    }    
    private void loadData() 
    {
        
            FileInputStream fis = null;
            try {
                fis = new FileInputStream(excelFile);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(LabelMakerController.class.getName()).log(Level.SEVERE, null, ex);
            }
            XSSFWorkbook wb = null;
        try {
            wb = new XSSFWorkbook(fis);
        } catch (IOException ex) {
            Logger.getLogger(LabelMakerController.class.getName()).log(Level.SEVERE, null, ex);
        }
            XSSFSheet sheet = wb.getSheetAt(0);
            Iterator<org.apache.poi.ss.usermodel.Row> itr = sheet.iterator();
            String celldata[]=new String[NO_OF_COL];
            while (itr.hasNext())
            {
                Row row = (Row) itr.next();
                Iterator<Cell> cellIterator = row.cellIterator();   //iterating over each column
                Cell cell;
                for(int i=0;i<NO_OF_COL;i++)   
		{  
		    celldata[i]="";
                    if(cellIterator.hasNext())
                    {
                        cell = cellIterator.next();  
			switch (cell.getCellType())               
			{  
                            case Cell.CELL_TYPE_STRING:
                                celldata[i]=cell.getStringCellValue();
                                break;  
			    case Cell.CELL_TYPE_NUMERIC:    
                                celldata[i]=""+(long)(cell.getNumericCellValue());
                                break;  
                        }
                    }
                }
                data.add(new FileData(celldata[0],celldata[1],celldata[2]));
            
        } 
	
    }

    @FXML
    private void chooseFileButtonAvtionEvent(ActionEvent event) 
    {
        excelFile = fileChooser.showOpenDialog(App.STAGE);
        if(excelFile != null)
        {
            data.clear();
            loadData();
            fileNameLabel.setText(excelFile.getName());
        }
    }
    @FXML
    private void createLabelsActionEvent(ActionEvent event) 
    {
        if(excelFile!=null)
        {
            File htmlFile = new File(excelFile.getParent()+"\\Label.html");
            //System.out.println("excel file: "+excelFile.getParent());
            if(!htmlFile.exists()) 
                try {
                    htmlFile.createNewFile();
            } catch (IOException ex) {
                Logger.getLogger(LabelMakerController.class.getName()).log(Level.SEVERE, null, ex);
            }
	    BufferedWriter bw=null;
            try {
                bw = new BufferedWriter(new FileWriter(htmlFile));
            } catch (IOException ex) {
                Logger.getLogger(LabelMakerController.class.getName()).log(Level.SEVERE, null, ex);
            }
	    StringBuilder htmlContent = new StringBuilder();
	    htmlContent.append("<!DOCTYPE html>\n" +
"<html>\n" +
"<head>\n" +
"	<meta charset=\"utf-8\">\n" +
"	<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n" +
"	<title>Label Creater</title>\n" +
"	<link rel=\"stylesheet\" type=\"text/css\" href=\"style.css\">\n" +
"	<style type=\"text/css\">\n" +
"		*\n" +
"		{\n" +
"			margin: 0px;\n" +
"			padding: 0px;\n" +
"		}\n" +
"		table\n" +
"		{\n" +
"			margin: .3cm 0cm 1.2cm 0cm;\n" +
"			width: 21.1cm;\n" +
"			border-collapse: collapse;\n" +
"			border: 0px solid red;\n" +
"		}\n" +
"		td\n" +
"		{\n" +
"			width:6.5cm;\n" +
"			height: 3.782cm;\n" +
"			border: 0px  solid;\n" +
"			margin: 0cm;\n" +
"			padding: 0px;\n" +
"			text-align: center;\n" +
"			vertical-align: center;\n" +
"			font-size: .8em;\n" +
"		}\n" +	
"	</style>\n" +
"</head>\n" +
"<body>");
            File file = new File(excelFile.getAbsolutePath());  
            FileInputStream fis = null;
                try {
                    fis = new FileInputStream(file);
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(LabelMakerController.class.getName()).log(Level.SEVERE, null, ex);
                }
            XSSFWorkbook wb = null;   
            try {
                wb = new XSSFWorkbook(fis);
            } catch (IOException ex) {
                Logger.getLogger(LabelMakerController.class.getName()).log(Level.SEVERE, null, ex);
            }
            XSSFSheet sheet = wb.getSheetAt(0);     
            Iterator<Row> itr = sheet.iterator(); 
            int i=0,j=0;
            while (itr.hasNext())                 
            { 
                if(j==0) htmlContent.append("<table>");
                Row row = itr.next();  
                if(i==0)
                    htmlContent.append("<tr>");
                htmlContent.append("<td>");
                Iterator<Cell> cellIterator = row.cellIterator();
                while (cellIterator.hasNext())   
                {  
                    Cell cell = cellIterator.next();  
                    switch (cell.getCellType())               
                    {  
                        case Cell.CELL_TYPE_STRING:
                            htmlContent.append(cell.getStringCellValue()+"<br>");
                            break;  
                        case Cell.CELL_TYPE_NUMERIC: 
                            htmlContent.append((long)(cell.getNumericCellValue())+"<br>");
                            break;  
                    }
                }  
                htmlContent.append("</td>");
                i++;
                if(i==3)
                {	
                    i=0;
                    htmlContent.append("</tr>");
                }
                
                if(j==23)
                {
                    j=-1;
                    htmlContent.append("</table>");
                }
                        
                j++;
            }  
            htmlContent.append("	</table>\r\n"
                + "</body>\r\n"
                + "</html>");
            try
            {
                bw.write(htmlContent.toString());
                bw.close();
                Alert a = new Alert(AlertType.NONE);
                a.setAlertType(AlertType.INFORMATION);
                a.setContentText("A Label.html file is created at "+excelFile.getParent());
                a.setHeaderText("File created sucessfully");
                a.show();
            }  
            catch(Exception e)  
            {  
                e.printStackTrace();  
            }  
        }
    }
}
/**
 * Assuming that first row is NAME second is RNO and last is COURSE.
 * The Excel file should contain only three column.
 * The column-head should not be in excel file.
 */