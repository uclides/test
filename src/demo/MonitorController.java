/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo;

import static demo.GenericInterface.folderLogs;
import demo.connections.adb;
import demo.connections.files;
import java.io.File;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author project
 */
public class MonitorController extends AnchorPane implements Initializable, GenericInterface{
    @FXML
    public TextArea textarea;
    @FXML
    Button exit;
    @FXML
    Button get;
    @FXML
    ProgressIndicator indicator;
    @FXML
    Label loading;
    files files=new files();
    adb adb =new adb();
    Main principal=new Main();
   public String values="NENE";
   public List<String>valuess;
    final FileChooser fileChooser = new FileChooser(); 
 ExtensionFilter filter = new ExtensionFilter("TXT files (*.txt)", "*.txt");
 
    @Override
    public void initialize(URL location, ResourceBundle resources) {

/* do something */ 
//valuess= files.FileToArray(folderLogs,files.GetNameFile(folderLogs));
//valuess.stream().forEach((s) -> {
//    textarea.appendText(s+"\n");
//});
System.out.println(values);

          
//         else{
//        System.out.println("NO HAY ARCHIVO DISPONIBLE");
//        }
//        
       
}
         public void exit(ActionEvent actionEvent){

                  
((Node)(actionEvent.getSource())).getScene().getWindow().hide();

    } 
                  public void get(ActionEvent actionEvent){
                      
     
                      textarea.clear();
                      textarea.setText("");
                      
          Node node = (Node) actionEvent.getSource();
          fileChooser.getExtensionFilters().add(filter);
              fileChooser.setInitialDirectory(new File(folderLogs));
     File directory=fileChooser.showOpenDialog(node.getScene().getWindow());

             //  File directory = new File(folderLogs);
//if (directory.isDirectory()) {
    if (directory!=null) {
   loading.setVisible(true);
   indicator.setVisible(true);
textarea.clear();
textarea.setText("");

        valuess= files.FileToArray2(directory.getPath(),"",textarea,loading,indicator);

        
      
//valuess.stream().forEach((s) -> {
//    textarea.appendText(s+"\n");
//});



//    String[] fil = directory.list();
//    if (fil.length == 0) {
//        //directory is empty
//        System.out.println("VACIO");
//    }
//    else{ 
//        textarea.clear();
//        valuess= files.FileToArray(folderLogs,files.GetNameFile(folderLogs));
//valuess.stream().forEach((s) -> {
//    textarea.appendText(s+"\n");
//});
//    
//    }
}

    } 
    
}
 