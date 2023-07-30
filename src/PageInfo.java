
import com.google.gson.Gson;
import com.itextpdf.layout.borders.Border;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.properties.TextAlignment;
import com.itextpdf.layout.properties.VerticalAlignment;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Deepanshu Sahu
 */
public class PageInfo {
    private String pageInfoName;
    private  float tableTopMargin;
    private  float tableRightMargin;
    private  float tableBottomMargin;
    private  float tableLeftMargin;
    private  float tableTopPadding;
    private  float tableRightPadding;
    private  float tableBottomPadding;
    private  float tableLeftPadding;
    private  float cellTopMargin;
    private  float cellRightMargin;
    private  float cellBottomMargin;
    private  float cellLeftMargin;
    private  float cellTopPadding;
    private  float cellBottomPadding;
    private  float cellRightPadding;
    private  float cellLeftPadding;
    private  boolean tableBorder; /*border doesn't work for now*/
    private  boolean cellBorder;  /*cell border too doesn't worj for now*/
    private int maxCol;
    private int maxRow;
    private float cellHeight;
    public static int dpi;
    private static final String  CONFIG_FILE = "configuration/";
    
    {
        dpi = 900;
        pageInfoName = "config1";
        tableLeftMargin = 0.0f;
        tableRightMargin = 0.0f;
        tableBottomMargin = 0.0f;
        tableTopPadding = 0.0f;
        tableRightPadding = 0.0f;
        tableLeftPadding = 0.0f;
        tableBottomPadding = 0.0f;
        cellTopMargin = 0.0f;
        cellLeftMargin = 0.0f;
        cellRightMargin = 0.0f;
        cellBottomMargin = 0.0f;
        cellTopPadding = 0.0f;
        cellLeftPadding = 0.0f;
        cellBottomPadding = 0.0f;
        cellRightPadding = 0.0f;
        tableBorder = false;
        cellBorder = false;
        maxCol=0;
        maxRow=0;
        cellHeight=0.0f;
    }
    public void configure()
    {
        File configFile = new File(PageInfo.CONFIG_FILE+this.pageInfoName+".txt");
        if(!configFile.exists())
        {
            try {
                new File(PageInfo.CONFIG_FILE).mkdirs();
                configFile.createNewFile();
            } catch (IOException ex) {
                Logger.getLogger(PageInfo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        FileWriter writer = null;
        try 
            {
                
                writer = new FileWriter(configFile);
                Gson gson = new Gson();
                gson.toJson(this,writer);
            } 
            catch (IOException ex) 
            {
                Logger.getLogger(PageInfo.class.getName()).log(Level.SEVERE, null, ex);
            }
            finally
        {
            try {
                writer.close();
            } catch (IOException ex) {
                Logger.getLogger(PageInfo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    public PageInfo[] loadConfiguration()
    {
        PageInfo configs[] = null;
        File dir = new File(PageInfo.CONFIG_FILE);
        FileReader reader = null;
        File allConfiguartions[] = null;
        if(dir.exists()&&dir.isDirectory())
        {
            allConfiguartions = dir.listFiles();
            configs = new PageInfo[allConfiguartions.length];
            for(int i=0;i<allConfiguartions.length;i++)
            {
                try 
                {
                    reader = new FileReader(PageInfo.CONFIG_FILE+allConfiguartions[i].getName());
                    configs[i] = new Gson().fromJson(reader, PageInfo.class);
                } 
                catch (FileNotFoundException ex) 
                {
                    Logger.getLogger(PageInfo.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return configs;
    }
    public void setTableMargins(float top,float right,float bottom, float left)
    {
        this.tableLeftMargin = left;
        this.tableBottomMargin = bottom;
        this.tableRightMargin = right;
        this.tableTopMargin = top;
    }
    public void setTablePaddings(float top,float right,float bottom, float left)
    {
        this.tableLeftPadding = left;
        this.tableBottomPadding = bottom;
        this.tableRightPadding = right;
        this.tableTopPadding = top;
    }
    public void setCellMargins(float top,float right,float bottom, float left)
    {
        this.cellLeftMargin = left;
        this.cellBottomMargin = bottom;
        this.cellRightMargin = right;
        this.cellTopMargin = top;
    }
    public void setCellPaddings(float top,float right,float bottom, float left)
    {
        this.cellLeftPadding = left;
        this.cellBottomPadding = bottom;
        this.cellRightPadding = right;
        this.cellTopPadding = top;
    }
    public void setTableBorder(boolean set)
    {
        this.tableBorder = set;
    }
    public void setCellBorder(boolean set)
    {
        this.cellBorder = set;
    }
    public int getMaxCol()
    {
        return this.maxCol;
    }
    public String getName()
    {
        return this.pageInfoName;
    }
    public int getMaxRow()
    {
        return this.maxRow;
    }
    public void setTableProps(Table table)
    {
        if(!this.tableBorder)
        {    table.setBorder(Border.NO_BORDER);
            System.out.println("table");
        }
        table.setMargins(this.tableTopMargin, this.tableRightMargin, this.tableBottomMargin, this.tableLeftMargin);
        table.setPaddings(this.tableTopPadding, this.tableRightPadding, this.tableBottomPadding, this.tableLeftPadding);
    }
    public void setCellProps(Cell cell)
    {
        cell.setMargins(this.cellTopMargin, this.cellRightMargin, this.cellBottomMargin, this.cellLeftMargin);
        cell.setPaddings(this.cellTopPadding, this.cellRightPadding, this.cellBottomPadding, this.cellLeftPadding);
        if(!this.cellBorder)
        {    cell.setBorderBottom(Border.NO_BORDER);
            System.out.println("cell");
        }
        cell.setTextAlignment(TextAlignment.CENTER);
        cell.setVerticalAlignment(VerticalAlignment.MIDDLE);
        cell.setHeight(this.cellHeight);
    }
    public void setCellHeight(float cellHeight)
    {
        this.cellHeight = cellHeight;
    }
    public float getCellHeight()
    {
        return this.cellHeight;
    }    
    public void setMaxRow(int row)
    {
        this.maxRow = row;
    }
    public void setMaxCol(int col)
    {
        this.maxCol = col;
    }
    public  float getTableTopMargin() {  return this.tableTopMargin; }
    public  float getTableRightMargin() { return this.tableRightMargin; }
    public  float getTableBottomMargin() { return this.tableBottomMargin; }
    public  float getTableLeftMargin() { return this.tableLeftMargin; }
    public  float getTableLeftPadding() { return this.tableLeftPadding; }
    public  float getTableTopPadding() { return this.tableTopPadding; }
    public  float getTableRightPadding() { return this.tableRightPadding; }
    public  float getTableBottomPadding() { return this.tableBottomPadding; }
    
    public  float getCellBottomPadding() { return this.cellBottomPadding; }
    public  float getCellLeftPadding() { return this.cellLeftPadding; }
    public  float getCellTopPadding() { return this.cellTopPadding; }
    public  float getCellRightPadding() { return this.cellRightPadding; }
    public  float getCellRightMargin() { return this.cellRightMargin; }
    public  float getCellBottomMargin() { return this.cellBottomMargin; }
    public  float getCellTopMargin() { return this.cellTopMargin; }
    public  float getCellLeftMargin() { return this.cellLeftMargin; }
            
    
    public static void main(String [] args)
    {
        System.out.println(new PageInfo().loadConfiguration()[1].getName());
    }
}
