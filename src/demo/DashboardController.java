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
  String[] info,info2,info3,info4,info5,info6;
   ObservableList<Device> data=FXCollections.observableArrayList();
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
      
       
        info = files.PushInfoBasic(valdev);
         info2 = files.PushInfoExt(valinf2);
         info3 = files.PushInfoA2SD(valinf3);
        info4 = files.PushInfoDisplay(valinf4);
         info5 = files.PushInfoImgGeneric(valinf5);
         info6 = files.PushInfoImgGeneric(valinf6);
        createFileDevice(info5);
   columnitem.setCellValueFactory(new PropertyValueFactory<Device,String>(valitem));
   columndescription.setCellValueFactory(new PropertyValueFactory<Device,String>(valdevi));
    data=FXCollections.observableArrayList(
new Device(valdev,info[0]),
new Device(valmod,info[1]),
new Device(valprod,info[2]),
new Device(valmarc,info[3]),
new Device(valrel,info[4]),
new Device(valbui,info[5]),
new Device(valoc,info[6]),
new Device(valker,info[7]),
new Device(valextt,info2[0]),
new Device(valextd,info2[1]),
new Device(vala2sdt,info3[0]),
new Device(vala2sdt,info3[1]),
new Device(valph,info4[1]),
new Device(valpw,info4[2]),
new Device(valpd,info4[3]),
new Device(valps,info4[4]),
new Device(valpfr,info4[5])
);
   tableinfodevice.setItems(data);
   createFileDevice(info5);
   createFileDevice(info6);
   }
   public void createFileDevice(String[] val){
       
   for(int y=0;y<files.RemoveNullValue(val).length;y++){
       if(val!=null && y!=0){
  data.add(new Device("soporte "+y,val[y]));}
   }
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

