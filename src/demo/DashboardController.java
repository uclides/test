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
import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Accordion;
import javafx.scene.control.Button;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.SplitPane;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TitledPane;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.util.Callback;
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
    @FXML
    TableView<Device> tableinfodevice;
    @FXML
    TableColumn<Device,String> columnitem;
    @FXML
    TableColumn<Device,String> columndescription;
    @FXML
    SplitPane splitPane; 
    //instances
 adb adb = new adb();
 files files=new files();
  String[] info,info2,info3,info4,info5,info6,info7,info8,info9,
          info10,info11,info12,info13,info14,info15,info16,
          info17,info18,info19,info20;
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
   public void detectDevice(ActionEvent actionEvent) throws Exception{
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

//pushInfo();
application.openMonitor();
   }

    @SuppressWarnings("Convert2Diamond")
   public void pushInfo(){
       
       if(files.unZip()){
  
         if(adb.confirmMessage("No se ha detectado archivo valido del dispositivo", "¿Desea continuar el proceso de forma manual?")){
         System.err.println("editable table");
         fillTableManual();
         }
         else{
         
         }
           
           
       }
       else{
fillTableAuto();
   }
   }
   public void fillTableAuto(){
           info = files.PushInfoBasic(valdev);
        info2 = files.PushInfoExt(valinf2);
        info3 = files.PushInfoA2SD(valinf3);
        info4 = files.PushInfoDisplay(valinf4);
        info5 = files.PushInfoImgGeneric(valinf5);
        info6 = files.PushInfoImgGeneric(valinf6);
        info8 = files.PushInfoImgGeneric(valinf8);
        info9 = files.PushInfoImgGeneric(valinf9);
        info10 = files.PushInfoImgGeneric(valinf10);
        info7 = files.PushInfoOthers(valinf7);
        info11 = files.PushInfoOthers(valinf11);
        info12 = files.PushInfoOthers(valinf12);
        info13 = files.PushInfoExt(valinf13);
        info14 = files.PushInfoExt(valinf14);
        info15 = files.PushInfoExt(valinf15);
        info16 = files.PushInfoExt(valinf16);
        info17 = files.PushInfoExt(valinf17);
        info18 = files.PushInfoExt(valinf18);
        info19 = files.PushInfoExt(valinf19);
        info20 = files.PushInfoOthers(valinf20);
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
   createFileDevice(info5,sup);
   createFileDevice(info6,sup);
   createFileDevice(info8,sup);
   createFileDevice(info9,sup);
   createFileDevice(info10,mod);
   createFileDevice2(info7,otfeature);
   createFileDevice(info11,cams);
   createFileDevice(info12,est);
   createFileDevice3(info13,disp);
   createFileDevice3(info14,disp);
   createFileDevice3(info15,disp);
   createFileDevice3(info16,dispm);
   createFileDevice3(info17,proc);
   createFileDevice3(info18,proc);
   createFileDevice3(info19,proc);
    createFileDevice2(info20,profeature);
   }
      public void fillTableManual(){
          tableinfodevice.setEditable(true);
   columnitem.setCellValueFactory(new PropertyValueFactory<>(valitem));
   columndescription.setCellFactory(TextFieldTableCell.forTableColumn());
   columndescription.setEditable(true);
    data=FXCollections.observableArrayList(
new Device(valdev,""),
new Device(valmod,""),
new Device(valprod,""),
new Device(valmarc,""),
new Device(valrel,""),
new Device(valbui,""),
new Device(valoc,""),
new Device(valker,""),
new Device(valextt,""),
new Device(valextd,""),
new Device(vala2sdt,""),
new Device(vala2sdt,""),
new Device(valph,""),
new Device(valpw,""),
new Device(valpd,""),
new Device(valps,""),
new Device(valpfr,"")
);
   tableinfodevice.setItems(data);

  


   }
//   public void tableModeManual(){
//   tableinfodevice.setEditable(true);
//   }
   public void createFileDevice(String[] val,String[] desc){
       
   for(int y=1;y<files.RemoveNullValue(val).length;y++){
           if(desc.length==1){
               data.add(new Device(desc[0]+" ",val[y]));
           }
           else{
  data.add(new Device(desc[y],val[y++]));}
       
   }
   }
    public void createFileDevice2(String[] val,String[] desc){
       
   for(int y=0;y<files.RemoveNullValue(val).length;y++){
           if(desc.length==1){
               data.add(new Device(desc[0]+" "+y,val[y]));
           }
           else{
               
                   if(desc[y] != null){
  data.add(new Device(desc[y],val[y+1]));
                   }
                   else{}
               
  }
       
   }
   }
        public void createFileDevice3(String[] val,String[] desc){
       
   for(int y=0;y<files.RemoveNullValue(val).length;y++){
           if(desc.length==1){
               data.add(new Device(desc[0]+" "+y,val[y]));
           }
           else{
               
                   if(desc[y] != null){
  data.add(new Device(desc[y],val[y]));
                   }
                   else{}
               
  }
       
   }
   }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
menuItemTable();
splitPane.setOnSwipeRight(null);

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
    public void NextStep(ActionEvent actionEvent){
        tabdash.getSelectionModel().select(tabdevice);
    }
    public void menuItemTable(){
    tableinfodevice.setRowFactory(
    new Callback<TableView<Device>, TableRow<Device>>(){

        @Override
        public TableRow<Device> call(TableView<Device> param) {
            final TableRow<Device> row=new TableRow<>();
            final ContextMenu contextMenu=new ContextMenu();
            MenuItem addItem=new MenuItem("agregar");
            addItem.setOnAction((ActionEvent event) -> {
                data.add(tableinfodevice.getSelectionModel().getSelectedIndex()+1,
                        new Device(tableinfodevice.getSelectionModel().getSelectedItem().getItem(),""));
            });
            MenuItem deliItem=new MenuItem("eliminar");
            deliItem.setOnAction((ActionEvent event) -> {
                tableinfodevice.getItems().remove(row.getItem());
            });
            contextMenu.getItems().addAll(addItem,deliItem);
            row.contextMenuProperty().bind(
      Bindings.when(Bindings.isNotNull(row.itemProperty()))
      .then(contextMenu)
      .otherwise((ContextMenu)null));
            return row;
        }
    
    }
    );
    }
}

