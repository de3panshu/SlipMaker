
import javafx.beans.property.SimpleStringProperty;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Deepanshu Sahu
 */
public class FileData {
    private SimpleStringProperty name;
    private SimpleStringProperty rno;
    private SimpleStringProperty course;
    
    public FileData(String name,String rno,String course)
    {
        setName(name);
        setRno(rno);
        setCourse(course);
    }
    public void setName(String name)
    {
        this.name=new SimpleStringProperty(name);
    }
    public void setRno(String rno)
    {
        this.rno=new SimpleStringProperty(rno);
    }
    public void setCourse(String course)
    {
        this.course=new SimpleStringProperty(course);
    }
    public String getName()
    {
        return this.name.get();
    }
    public String getRno()
    {
        return this.rno.get();
    }
    public String getCourse()
    {
        return this.course.get();
    }
    
}
