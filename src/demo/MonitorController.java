/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo;

import static demo.GenericInterface.folderLogs;
import demo.connections.adb;
import demo.connections.files;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TextArea;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author project
 */
public class MonitorController extends AnchorPane implements Initializable, GenericInterface{
    @FXML
    public TextArea textarea;
    files files=new files();
   public String values="NENE";
   public List<String>valuess;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
valuess= files.FileToArray(folderLogs,files.GetNameFile(folderLogs));
valuess.stream().forEach((s) -> {
    textarea.appendText(s+"\n");
});
System.out.println(values);
//                             //   items= file.FileToArray(folderLogs,file.GetNameFile(folderLogs));

}
    
        
    
}
