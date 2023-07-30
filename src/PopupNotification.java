/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.tools.popupnotification;

import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;

/**
 *
 * @author Deepanshu Sahu
 */
public class PopupNotification {
    
    public void confirm(String title,String text)
    {
        Notifications notification  = Notifications.create()
                                        .title(title)
                                        .graphic(new ImageView(new Image(getClass().getResourceAsStream("tick.png"))))
                                        .text(text)
                                        .hideAfter(Duration.seconds(3))
                                        .position(Pos.BOTTOM_RIGHT);
        notification.darkStyle();

        notification.showInformation();
    }
    public void alert(String title,String text)
    {
        Notifications notification  = Notifications.create()
                                        .title(title)
                                        .graphic(null)
                                        .text(text)
                                        .hideAfter(Duration.seconds(3))
                                        .position(Pos.BOTTOM_RIGHT);
        notification.darkStyle();

        notification.showError();
    }
    public void warning(String title,String text)
    {
        Notifications notification  = Notifications.create()
                                        .title(title)
                                        .graphic(null)
                                        .text(text)
                                        .hideAfter(Duration.seconds(6))
                                        .position(Pos.BOTTOM_RIGHT);
        notification.darkStyle();

        notification.showWarning();
    }
}
