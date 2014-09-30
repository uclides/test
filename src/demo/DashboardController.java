/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package demo;

import demo.connections.adb;
import demo.connections.files;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Accordion;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TitledPane;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;


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
    @FXML
    TableView<Device> tableinfodevice;
    @FXML
    TableColumn<Device,String> columnitem;
    @FXML
    TableColumn<Device,String> columndescription;
    //instances
 adb adb = new adb();
 files files=new files();
private Main application;
int detectvalue = 0;
String[] out = new String[100];
    private Timeline task;
//private final ObservableList<Device> data=FXCollections.observableArrayList(
//new Device("SP-5050","SP-5050","SP-5050","Siragon","4.4.2","KAAI255_VZA_EN_1.12.912",
//"es_VE","Linux version 3.4.67","Almacenamiento Externo SD","Almacenamiento A2SD",
//"854","480","240 dpi","4.08","64.82")
//);
    int count;

public DashboardController(){
        this.tableinfodevice = new TableView<>();


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
       //files.checkDir(folderegister,"zip");
//files.FileToArray();

pushInfo();
   }
    @SuppressWarnings("Convert2Diamond")
   public void pushInfo(){
       String[] info,info2,info3,info4;
       
        info = files.PushInfoBasic("Dispositivo");
         info2 = files.PushInfoExt("Almacenamiento Externo SD");
//       info3 = files.ParseValues("Almacenamiento A2SD");
//        info4 = files.ParseValues("Informacion de Pantalla");
   columnitem.setCellValueFactory(new PropertyValueFactory<Device,String>("item"));
   columndescription.setCellValueFactory(new PropertyValueFactory<Device,String>("device"));
   ObservableList<Device> data=FXCollections.observableArrayList(
new Device("Dispositivo",info[0]),
new Device("Modelo",info[1]),
new Device("Producto",info[2]),
new Device("Marca",info[3]),
new Device("Release",info[4]),
new Device("Build",info[5]),
new Device("Locale",info[6]),
new Device("Kernel",info[7]),
new Device("Almacenamiento externo SD total",info2[0]),
new Device("Almacenamiento externo SD Disponible",info2[1])
//new Device("Almacenamiento A2SD total",info3[0]),
//new Device("Almacenamiento A2SD Disponible",info3[1]),
//new Device("Pantalla Height",info4[0]),
//new Device("Pantalla Width",info4[1]),
//new Device("Pantalla density",info4[2]),
//new Device("Pantalla size",info4[3]),
//new Device("Pantalla refresh rate",info4[4])
);
   tableinfodevice.setItems(data);

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

