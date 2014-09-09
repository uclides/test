/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package demo;

import demo.connections.adb;
import demo.connections.files;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Accordion;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;
import org.controlsfx.control.action.Action;
import org.controlsfx.dialog.Dialogs;


/**
 *
 * @author project
 */
public class DashboardController extends AnchorPane implements Initializable,GenericInterface{
    @FXML
    Button detectdevice;
    @FXML
    Button bdevice;
    @FXML
    Button bprovider;
    @FXML
    Button bapp;
    @FXML
    Button bcompare;
    @FXML
    Button bmanual;
    @FXML
    Label activedevice;
    @FXML
    Accordion accordion;
    @FXML
    TabPane tabdash;
    @FXML
    Tab tabdevice;
    @FXML
    Tab tabapp;
    @FXML
    Tab tabtest;
    @FXML
    Tab tabimage;
    @FXML
    Tab tabcompare;
    @FXML
    TitledPane  accorIdentificacion;
    @FXML
    TitledPane  accorBenchmark;
    @FXML
    TitledPane  accorImagenes;
    @FXML
    TitledPane  accorVersus;
    @FXML
    TitledPane  accorFallas;   
    @FXML
    TitledPane  accorReporte;
    @FXML
    TitledPane  accorMantenimiento;
    @FXML
    TitledPane  accorAyuda;  
    @FXML
    TextArea outConsole;
    @FXML
    ProgressBar bardashboard; 
    //instances
 adb adb = new adb();
 files files=new files();
private Main application;
int detectvalue = 0;
    private Timeline task;
public DashboardController(){


}
    public void setApp(Main application){
        this.application = application;

     
     
    }
   public void detectDevice(ActionEvent actionEvent){
// int ite=0;
// 
//   task = new Timeline(
//        new KeyFrame(
//                Duration.ZERO,       
//                new KeyValue(bardashboard.progressProperty(), 0)
//        ),
//        new KeyFrame(
//                Duration.seconds(3), 
//                new KeyValue(bardashboard.progressProperty(), 1)putty
//        )
//    );  
//    task.playFromStart();
// 
//      if( adb.execCmd(activedevice,"adb devices")==-1){
//       DisabledAll();
//       System.out.println("conéctalo!!!!!!!!!!!!!!!!!!!!!!");
//      Focus();
//      detectvalue=-1;
//   }
//   else{
//       EnabledAll();
//adb.execGeneric(installSiragonapp,outConsole);
//adb.execGeneric(startSiragonapp,outConsole);
//   }
//       
//System.out.println(files.GetNameFile());
       //adb.execGeneric(pullfile,outConsole);
      //files.unZip();
       files.checkDir(folderegister,"zip");
   }
    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }


    public void buttonLoadTab(ActionEvent actionEvent){
      switch(actionEvent.getSource().toString()){
          case "Button[id=bdevice, styleClass=button]'Dispositivo'":
            tabdash.getSelectionModel().select(tabdevice);
              break;
          case "Button[id=bapp, styleClass=button]'Aplicaciones'":
            tabdash.getSelectionModel().select(tabapp);
              break;
          case "Button[id=btest, styleClass=button]'Pruebas'":
            tabdash.getSelectionModel().select(tabtest);
              break;
          case "Button[id=bimgdevice, styleClass=button]'Dispositivo'":
            tabdash.getSelectionModel().select(tabimage);
              break;    
          case "Button[id=bcompare, styleClass=button]'Comparar'":
            tabdash.getSelectionModel().select(tabcompare);
              break; 
     }
    }
    
    public void LoadManual(ActionEvent actionEvent){       
   adb.execTerminal(web);
    }
    public void DisabledAll(){
    accorBenchmark.setDisable(true);
    accorImagenes.setDisable(true);
    accorMantenimiento.setDisable(true);
    accorFallas.setDisable(true);
    }
     public void EnabledAll(){
    accorBenchmark.setDisable(false);
    accorImagenes.setDisable(false);
    accorMantenimiento.setDisable(false);
    accorFallas.setDisable(false);
    }
    public void Focus(){
     accorAyuda.setTextFill(Color.BLACK);
    }
            
}

