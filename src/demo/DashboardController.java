/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package demo;

import static demo.GenericInterface.apktochecks;
import demo.tables.Device;
import demo.tables.App;
import static demo.GenericInterface.devicedisp;
import static demo.GenericInterface.valappinstall;
import demo.Controls;
import demo.connections.adb;
import demo.connections.files;
import demo.connections.server;
import demo.tables.Apk;
import demo.tables.Chart;
import demo.tables.Fail;
import demo.tables.Tst;
import demo.tables.Update;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.beans.binding.Bindings;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Accordion;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Control;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.SplitPane;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputControl;
import javafx.scene.control.TitledPane;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.TilePane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Callback;
import javafx.util.Duration;
import org.controlsfx.control.ButtonBar;
import org.controlsfx.control.ButtonBar.ButtonType;
import org.controlsfx.control.action.AbstractAction;
import org.controlsfx.control.action.Action;
import org.controlsfx.dialog.Dialog;


/**
 *
 * @author project
 */
public class DashboardController extends AnchorPane implements Initializable,GenericInterface{
    @FXML
    Button detectdevice,bdevice,bcontinue,bcontinue2,bcomponente,bprovider,bapp,bcompare,
            exit,bmanual,baddcomporprov,bmore,bprocapp,binstapp,binitbech,bsavebech,bxml,bloadimg,borrarimgs,baddfails,
            bfails,bprev,bnext,bcreatec,binduction,badvantage;
    @FXML
    Label activedevice,user,permission,dateuser,lblcompinfo,estatusapp,estatusbench,lblr0,lblr1,
            lblr2,lblr3,lblr4,lblr5,lblimg,lblcapt,lblphoto,lblfilter,lblmsjimg,helper;
    @FXML
    TextField txtnf;
    @FXML
    TextArea txtdf;
    @FXML
    ImageView avatar,photo;
    @FXML
    Accordion accordion;
    @FXML
    TabPane tabdash;
    @FXML
    Tab tabinduction,tabdevice,tabcomp,tabapp,tabtest,tabimage,tabcompare,tabfails;
    @FXML
    TitledPane  accorIdentificacion,accorBenchmark,accorImagenes,accorVersus,
            accorFallas,accorReporte,accorMantenimiento,accorAyuda;
    @FXML
    TextArea outConsole;
    @FXML
    ProgressBar bardashboard; 
    @FXML
    ProgressIndicator probarapp; 
    @FXML
    TableView<Device> tableinfodevice;
    @FXML
    TableView<App> tableapp;
    @FXML
    TableView<Apk> tableappinstall;
    @FXML
    TableView<Update> tableappupdate;
    @FXML
    TableView<Tst> tabletest;
    @FXML
    TableView<Fail> tablefails;
    @FXML
    TableView<Chart> tablechart;
    @FXML
    TableColumn<Device,String> columnitem,columndescription;
    @FXML
    TableColumn<App,String>columnappdevice;
    @FXML
    TableColumn<Apk,String>columnappinstall;
    @FXML
    TableColumn<Update,String>columnappupdate;
    @FXML
    TableColumn<Tst,String>columnantest;
    @FXML
    TableColumn<Tst,String>columnartest;
    @FXML
    TableColumn<Tst,String>columnaitest;
    @FXML
    TableColumn<Fail,String> columnafuser;
    @FXML
    TableColumn<Fail,String> columnafname;
    @FXML
    TableColumn<Fail,String> columnafdesc;
    @FXML
    TableColumn<Fail,String> columnafimg;
    @FXML
    TableColumn<Chart,Boolean> columnaselect;
    @FXML
    TableColumn<Chart,String> columnanchart;
    @FXML
    SplitPane splitPane; 
    @FXML
    ComboBox tecnologiadisplay,cbtypedis,cbtactildis,cbtypebat,cbbluetooth,cbprov,cbcertgoogle,cbbench,cbcompatible,
             cbfilterimg,cbtypecomp;
    @FXML
    ColorPicker cpdev;
    @FXML
    MenuButton choicewifi,choiceband,choicesensor,choicematerialdev;
    
    @FXML 
    TextField txthdev,txtwdev,txtbulkdev,txtweight,txtcolordis,txtcapbat,txtelemadd1,
              txtelemadd2,txtelemadd3,result1,result2,result3,result4,result5;
    List<CheckMenuItem> itemsband,itemswifi;
    @FXML
    ScrollPane scrollPane;
    @FXML
    TilePane tilePane;
    @FXML
    CheckBox chkpref;
    Task task2;
     int tpng=0;int z=0;int fpng=0;
    //instances
 adb adb = new adb();
 files files=new files();
  String[] info,info2,info3,info4,info5,info6,info7,info8,info9,
          info10,info11,info12,info13,info14,info15,info16,
          info17,info18,info19,info20,info21;
  String[] items=new String[1];
  String[] listimg=new String[100];
  String[] listimgfail=new String[100];
  String[] listdelimg=new String[100];
  String[] listdelimgfail=new String[100];
  String[] fail=new String[10];
  String idu,device;
   ObservableList<Device> data=FXCollections.observableArrayList();
   ObservableList<App> dataapp=FXCollections.observableArrayList();
   ObservableList<Apk> dataappIns=FXCollections.observableArrayList();
   ObservableList<Update> dataappUp=FXCollections.observableArrayList();
   ObservableList<Tst> dataBench=FXCollections.observableArrayList();
    ObservableList<Fail> datafail=FXCollections.observableArrayList();
    ObservableList<Chart>datachart=FXCollections.observableArrayList();
   public ObservableList<String> attrLogin;
private Main application;
LoginController login=new LoginController();
String[] out = new String[100];
    private Timeline task;
server s=new server();
Controls c=new Controls();
    int count;
public int VAL;
final TextField namefail = new TextField();
final TextArea descriptionfail = new TextArea();
final Label lblimgfail =new Label();
final Action actionFail,actioncapinmg;
String imgc;
public DashboardController(){  

        this.tableinfodevice = new TableView<>();
        this.tableapp = new TableView<>();
        this.tableappinstall = new TableView<>();
        this.tableappupdate=new TableView<>();
        this.tabletest=new TableView<>();
        this.tablefails=new TableView<>();

        this.actioncapinmg = new AbstractAction("capturar imagen") {
            // This method is called when the login button is clicked ...
            @Override
            public void handle(ActionEvent ae) {
                if(adb.b==1){
                int ramdom2=new Random().nextInt(1000000000);
        adb.execGeneric(capturedis[0]+String.valueOf(ramdom2)+capturedis[1], null, adb.b);
        adb.execGeneric(pullimg+String.valueOf(ramdom2)+capturedis[1]+" "+folderimg[1], null, adb.b);
        imgc=folderimg[1]+"\\"+String.valueOf(ramdom2)+capturedis[1];
        this.setDisabled(true);
                }
                else{
                adb.alertMessage(mesagges[0]);
                lblimgfail.setText("");
                }
            }
        };
        this.actionFail = new AbstractAction("aceptar") {
            // This method is called when the login button is clicked ...
            @Override
            public void handle(ActionEvent ae) {
                Dialog d = (Dialog) ae.getSource();
                // Do the login here.

if(!namefail.getText().equals("")&&!descriptionfail.getText().equals("")){
String[] val={"uf","nf","df","imgf"};

  tablefails.setEditable(true);
  columnafuser.setCellValueFactory(new PropertyValueFactory<>(val[0]));
  columnafname.setCellValueFactory(new PropertyValueFactory<>(val[1]));
  columnafdesc.setCellValueFactory(new PropertyValueFactory<>(val[2]));
  columnafimg.setCellValueFactory(new PropertyValueFactory<>(val[3]));

  tablefails.setItems(datafail);
    fail[1]=namefail.getText();
    fail[2]=descriptionfail.getText();
    fail[3]=lblimgfail.getText();
    createRowsFails(datafail,user.getText(),fail[1],fail[2],fail[3]);
    actioncapinmg.disabledProperty().set(false);
    lblimgfail.setText("");
    d.hide();
       } 
else{
    adb.alertMessage(mesagges[6]);
}
            }
        };
        
}
    public void setApp(Main application){
        this.application = application;

     
     
    }
   public void LoadInfoInitialPhone(ActionEvent actionEvent){
//  System.out.println("ESGRACIAOOOOOOOOOOOOO: "+adb.b);
       if(tableinfodevice.getItems().isEmpty())
       {
  if(adb.b==1) {
      device=adb.returnID(devicedisp);
      System.out.println(device);
         if(s.Consultation("select * from device where id_device='"+device+"'")!=0){ 
                            
                            if(adb.confirmMessage(exrecord,question1[0])){
                                System.out.println("LOAD INFORMATION DEVICE");
                           BDtoTable(0,0,new String[]{valdev,valmod,valprod,valrel,valker,valbui,valoc,valextt,valextd,vala2sdt,vala2sdd,alminter[0],alminter[1],almsis[0],almsis[1],dispcache[0],dispcache[1],dispm[0],dispm[1],dispm[2],"color","alto","ancho","grosor","peso","tipo de bluetooth","certificado google"},tableinfodevice,columnitem,columndescription,new String[]{valitem,valdevi});
                           BDtoTable(1,0,new String[]{"tipo de camara","megapixels",est[0],sup[0],vidsup[0],mod[0],otfeature[0],otfeature[1],otfeature[2],otfeature[3],otfeature[4],otfeature[5],otfeature[6]},tableinfodevice,columnitem,columndescription,new String[]{valitem,valdevi});
                           BDtoTable(2,0,new String[]{"tipo de camara","megapixels",est[0],sup2[0],vidsup2[0],mod[0],otfeature[0],otfeature[1],otfeature[2],otfeature[3],otfeature[4],otfeature[5],otfeature[6]},tableinfodevice,columnitem,columndescription,new String[]{valitem,valdevi});
                           BDtoTable(3,0,new String[]{proc[0],frec[0],"Cores CPU",profeature[0],profeature[7],profeature[6],"GPU"},tableinfodevice,columnitem,columndescription,new String[]{valitem,valdevi});
                           bcontinue.setDisable(true);
                            }
                        }
                        else{
                            ProgressBar(2);
adb.execGeneric(installSiragonapp,outConsole,adb.b);
ProgressBar(1);
adb.execGeneric(start+startapps[0],outConsole,adb.b);
ProgressBar(1);
adb.execGeneric(pullfile,outConsole,adb.b);
pushInfo();
                           // activedevice.setText("verifica estatus del servidor");                       
//                          profile.detectdevice.setOnAction((event) -> {
//                              adb.execTerminal(server);
//                           });
                            
     bcontinue.setDisable(false);                       
                        }

   }
   else{
    adb.alertMessage(mesagges[0]);
    }
   }
    else{
    activedevice.setText(mesagges[3]);
    }
        //ProgressBar(1);
//adb.execGeneric(pullfile,outConsole);
//pushInfo();
////////////////////////////////////////////////////7
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
        
        //files.unZip();
        //files.checkDir(folderegister,"zip");
//files.FileToArray();
        
        
//application.openMonitor();


    } 
   public void initProcApp(ActionEvent actionEvent){
                 tableapp.setEditable(true);
   columnappdevice.setCellValueFactory(new PropertyValueFactory<>(valapdetect));

   tableapp.setItems(dataapp);

   info21 = files.PushInfoApp(valappinstall);
        
createRowsApp(dataapp,info21);
if(!tableapp.getItems().isEmpty()){
   bprocapp.setText(chantxtbt[0]);
   bprocapp.setOnAction(installApp());
   

}
bprocapp.setOnAction(new EventHandler<ActionEvent>() {

                     @Override
                     public void handle(ActionEvent event) {
                                     tableappupdate.setEditable(true);
   columnappupdate.setCellValueFactory(new PropertyValueFactory<>(apktochecks));

   tableappupdate.setItems(dataappUp);

   info21 = files.RemoveNullValue2(adb.execGeneric("adb shell pm list package", outConsole, adb.b));
        
createRowsAppUp(dataappUp,info21);
                     }
                 });

   }
    @SuppressWarnings("Convert2Diamond")
   public void pushInfo(){
       
       if(files.unZip()){
  
         if(adb.confirmMessage("No se ha detectado archivo valido del dispositivo", "¿Desea continuar el proceso de forma manual?")){
         System.err.println("editable table");
         fillTableManual();
         }
         else{
        // fillTableAuto();
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
        

        

   columnitem.setCellValueFactory(new PropertyValueFactory<>(valitem));
   columndescription.setCellValueFactory(new PropertyValueFactory<>(valdevi));
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
new Device(vala2sdd,info3[1]),
new Device(valph,info4[1]),
new Device(valpw,info4[2]),
new Device(valpd,info4[3]),
new Device(valps,info4[4]),
new Device(valpfr,info4[5])
);
    
   tableinfodevice.setItems(data);
   createRowsDevice(data,info5,sup);
   createRowsDevice(data,info6,vidsup);
   createRowsDevice(data,info8,sup2);
   createRowsDevice(data,info9,vidsup2);
   createRowsDevice(data,info10,mod);
   createRowsDevice2(data,info7,otfeature);
   createRowsDevice(data,info11,cameras);
   createRowsDevice(data,info12,est);
   createRowsDevice3(data,info13,alminter);
   createRowsDevice3(data,info14,almsis);
   createRowsDevice3(data,info15,dispcache);
   createRowsDevice3(data,info16,dispm);
   createRowsDevice3(data,info17,proc);
   createRowsDevice3(data,info18,frec);
   createRowsDevice3(data,info19,red);
    createRowsDevice2(data,info20,profeature);
    data.add(new Device("Cores CPU",""));
    data.add(new Device("GPU",""));

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
new Device(vala2sdd,""),
new Device(valph,""),
new Device(valpw,""),
new Device(valpd,""),
new Device(valps,""),
new Device(valpfr,""),
new Device("Cores CPU",""),
new Device("GPU","")         
);
   tableinfodevice.setItems(data);

  


   }
   public void createRowsDevice(ObservableList<Device> data,String[] val,String[] desc){
    
   for(int y=1;y<files.RemoveNullValue(val).length;y++){
           if(desc.length==1){
               data.add(new Device(desc[0]+" ",val[y]));
           }
           else{
  data.add(new Device(desc[y]+" ",val[y]));
           }
       
   }

   }
   public void createRowsDevice2(ObservableList<Device> data,String[] val,String[] desc){
       
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
   public void createRowsDevice3(ObservableList<Device> data,String[] val,String[] desc){
       
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
   public void createRowsApp(ObservableList<App> data,String[] val1){
   
    for(int y=1;y<files.RemoveNullValue(val1).length;y++){

    data.add(new App(val1[y++]));

    }


   }
   public void createRowsAppUp(ObservableList<Update> data,String[] val1){
   
    for(int y=1;y<files.RemoveNullValue(val1).length;y++){

    data.add(new Update(val1[y++]));

    }


   }
   public void createRowsBench(ObservableList<Tst> data,String va1,String va2,String va3){

    data.add(new Tst(va1, va2, va3));

   }
   public void createRowsAppInst(ObservableList<Apk> data,String[] val1){
       int y=val1.length;

        for (String val11 : val1) {
            
          
           // Platform.runLater( new Thread(adb.execGenericLoop(insgenbench+val11, outConsole, adb.b,data,val11,estatusapp)));
                //data.add(new Apk(val11));
                   Platform.runLater( new Thread(adb.execGenericLoop(insgenbench+val11, outConsole, adb.b,data,val11,estatusapp,y,probarapp)));

        }
   }
   public void createRowsFails(ObservableList<Fail> data,String va1,String va2,String va3,String va4){

    data.add(new Fail(va1, va2, va3, va4));

   }
   public void createRowsChart(ObservableList<Chart> data,String va2){

    data.add(new Chart(va2));

   }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
menuItemTable();
viewMITable();
splitPane.setOnSwipeRight(null);    
  adb.LoopAdb(activedevice);

  choicematerialdev.getItems().addAll(s.ConsultforUICMItem(consults[0],columnsdb[0]));
  choiceband.getItems().addAll(s.ConsultforUICMItem(consults[1],columnsdb[1]));
  choiceband.getItems().addAll(s.ConsultforUICMItem(consults[1],columnsdb[1]));
  choicewifi.getItems().addAll(s.ConsultforUICMItem(consults[2],columnsdb[1]));
  choicesensor.getItems().addAll(s.ConsultforUICMItem(consults[7],columnsdb[6]));
  ObservableList<String> olistblu = FXCollections.observableArrayList(s.ConsultforUIArray(consults[3],columnsdb[2]));
  cbbluetooth.setItems(olistblu);
    ObservableList<String> olistdis = FXCollections.observableArrayList(s.ConsultforUIArray(consults[4],columnsdb[3]));
  cbtypedis.setItems(olistdis);
      ObservableList<String> olisttactil = FXCollections.observableArrayList(s.ConsultforUIArray(consults[5],columnsdb[4]));
  cbtactildis.setItems(olisttactil);
        ObservableList<String> olistbat = FXCollections.observableArrayList(s.ConsultforUIArray(consults[6],columnsdb[5]));
  cbtypebat.setItems(olistbat);
          ObservableList<String> olistprov = FXCollections.observableArrayList(s.ConsultforUIArray(consults[8],columnsdb[7]));
  cbprov.setItems(olistprov);
  cbcertgoogle.getItems().addAll("si","no");
  cbfilterimg.getItems().addAll("pruebas","fallas","dispositivo","otras");
  ObservableList<String> olistbech = FXCollections.observableArrayList(s.ConsultforUIArray(consults[9],columnsdb[8]));
  cbbench.setItems(olistbech);

c.validateTextFile(txthdev,lblcompinfo);txthdev.addEventFilter(KeyEvent.KEY_TYPED, c.numericValidation(10));
c.validateTextFile(txtwdev,lblcompinfo);txtwdev.addEventFilter(KeyEvent.KEY_TYPED, c.numericValidation(10));
c.validateTextFile(txtbulkdev,lblcompinfo);txtbulkdev.addEventFilter(KeyEvent.KEY_TYPED, c.numericValidation(10));
c.validateTextFile(txtcolordis,lblcompinfo);txtcolordis.addEventFilter(KeyEvent.KEY_TYPED, c.numericValidation(20));
c.validateTextFile(txtcapbat,lblcompinfo);txtcapbat.addEventFilter(KeyEvent.KEY_TYPED, c.numericValidation(20));
c.validateTextFile(txtweight,lblcompinfo);txtweight.addEventFilter(KeyEvent.KEY_TYPED, c.numericValidation(10));
c.validateTextFile(result1,lblcompinfo);
c.validateTextFile(result2,lblcompinfo);
c.validateTextFile(result3,lblcompinfo);
c.validateTextFile(result4,lblcompinfo);
c.validateTextFile(result5,lblcompinfo);
  photo.addEventHandler(MouseEvent.MOUSE_CLICKED,new EventHandler<MouseEvent>() {
    @Override
    public void handle(MouseEvent event) {
       
        int ramdom=new Random().nextInt(1000000000);
        adb.execGeneric(capturedis[0]+String.valueOf(ramdom)+capturedis[1], null, adb.b);
        adb.execGeneric(pullimg+String.valueOf(ramdom)+capturedis[1]+" "+folderimg[0], null, adb.b);
        listimg[tpng]=folderimg[0]+"\\"+String.valueOf(ramdom)+capturedis[1];
        System.out.println(listimg[tpng]);
        tpng++;
        lblimg.setText(String.valueOf(tpng));
        
    }
});
  chkpref.selectedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if(s.Consultation("select * from user_preferences where u_pref="+idu+" and id_pref=1")!=0){
                s.UpdatElement("update user_preferences set desc_pref = ? where u_pref="+idu+" and id_pref=1",new int[]{0},new String[]{newValue.toString()}, null);
                }
                else{
                s.Addelement("insert into user_preferences values ("+idu+",1,"+"'"+newValue.toString()+"'"+")");
                }
                }
        });
       
  binduction.setOnAction(new EventHandler<ActionEvent>() {
    @Override
    public void handle(ActionEvent event) {
    tabdash.getSelectionModel().select(tabdevice);
    }
  });
  
  helper.setOnMouseClicked(new EventHandler<MouseEvent>() {

    @Override
    public void handle(MouseEvent event) {
        adb.execTerminal(web);
    }
});


    }
    public void buttonLoadTab(ActionEvent actionEvent){
      switch(actionEvent.getSource().toString()){
          case "Button[id=bdevice, styleClass=button]'Dispositivo'":
            tabdash.getSelectionModel().select(tabdevice);
              break;
          case "Button[id=bcomponente, styleClass=button]'Componentes / Proveedor'":
            tabdash.getSelectionModel().select(tabcomp);
             break;
          case "Button[id=bapp, styleClass=button]'Aplicaciones'":
            tabdash.getSelectionModel().select(tabapp);
              break;
          case "Button[id=btest, styleClass=button]'Pruebas'":
            tabdash.getSelectionModel().select(tabtest);
              break;
          case "Button[id=bimgdevice, styleClass=button]'General'":
            tabdash.getSelectionModel().select(tabimage);
              break;    
          case "Button[id=bcompare, styleClass=button]'Comparar'":
            tabdash.getSelectionModel().select(tabcompare);
              break;
          case "Button[id=bfails, styleClass=button]'Información'":
            tabdash.getSelectionModel().select(tabfails);
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
        switch(tabdash.getSelectionModel().getSelectedItem().getId()){
        case("tabdevice"):
            Boolean bool=false;
               for(int x=0;x<columndescription.getTableView().getItems().size();x++){
                   if(columndescription.getCellData(x).isEmpty()){
                   bool=true;
                   }
               }
                if(!bool){
            if(adb.confirmMessage("Aviso",question1[1])){
                s.generateInfoIdent(tabdash,columnitem,columndescription);
                tabdash.getSelectionModel().select(tabcomp);
                bcomponente.setDisable(false);                         
            }
                }
            else{
                adb.alertMessage("Existen campos vacíos en la tabla");
            }

               // System.out.println(s.name_cpu);

            break;
        case("tabcomp"):
           String apps=files.oneString(files.RemoveNullValue2(adb.execGeneric("adb shell pm list package", outConsole, adb.b)));
           c.getInfoTabComp(lblcompinfo,new TextField[]{txthdev,txtwdev,txtbulkdev,txtcolordis,txtcapbat,txtweight},new MenuButton[]{choicematerialdev,choiceband,choicewifi,choicesensor},new ComboBox[]{cbbluetooth,cbtypedis,cbtactildis,cbtypebat,cbprov,cbcertgoogle},cpdev);
           String blu=s.ConsultforUIString("select id_blu from bluetooth where type_blu='"+c.values[7][0]+"'", "id_blu");
           int cert= files.booleanToint("si",c.values[15][0]);
           int mat=files.RemoveNullValue2(c.values[3]).length;
           int band=files.RemoveNullValue2(c.values[5]).length;
           int wifi=files.RemoveNullValue2(c.values[6]).length;
           int other=files.RemoveNullValue2(c.values[13]).length;
           String bat=s.ConsultforUIString("select id_bat from battery where type_bat='"+c.values[11][0]+"'", "id_bat");
           String type_d=s.ConsultforUIString("select id_type_dis from display_type where name_dis='"+c.values[8][0]+"'", "id_type_dis");
           String type_tac=s.ConsultforUIString("select id_tactil from display_tactil where name_tactil='"+c.values[10][0]+"'", "id_tactil");
           String[] c1=files.RemoveNullValue2(s.firsttab[0]);
           String[] c2=files.RemoveNullValue2(s.firsttab[2]);
            if(s.Consultation("select * from device where id_device='"+device+"'")!=0){
                s.UpdatElement("update device set name_dev= ?,model_dev= ?,ver_so= ?,kernel= ?,build_dev= ?,locale_dev= ?,sto_ext_sd_t= ?,sto_ext_sd_d= ?,sto_s2sd_t= ?,sto_s2sd_d= ?,sto_inter_t= ?,sto_inter_d= ?,sto_sys_t= ?,sto_sys_d= ?,cache_sys_t= ?,cache_sys_d= ?,ram_t= ?,ram_d= ?,ram_l= ?,color= ?,h_dev= ?,w_dev= ?,bulk_dev= ?,weight_dev= ?,id_blu= ?,cert_google= ?,all_app_dev= ? where id_device='"+device+"'",
                        new int[]{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,0},
                        new String[]{s.name_dev,s.model_dev,s.ver_so,s.kernel_dev,s.build_dev,s.locale_dev,s.sto_ext_sd_t,s.sto_ext_sd_t,s.sto_ext_sd_d,s.sto_s2sd_t,s.sto_s2sd_d,s.sto_inter_t,s.sto_inter_d,s.sto_sys_t,s.sto_sys_d,s.cache_sys_t,s.cache_sys_d,s.ram_t,s.ram_d,s.ram_l,c.values[4][0],c.values[0][0],c.values[1][0],c.values[2][0],c.values[16][0],apps},
                        new int[]{Integer.valueOf(blu),cert});
                  if(s.Consultation("select * from cpu where name_cpu='"+s.name_cpu+"'")!=0){
                                  int cpu=s.ConsultforUIInt("select id_cpu as sel from cpu where name_cpu='"+s.name_cpu+"'", "sel");    
                                 s.Addelement("insert into device_cpu values ('"+device+"',"+cpu+")");
                            }
                  else{
                                int lastcpu=s.ConsultforUIInt("select count(*) as t from cpu", "t");
                                lastcpu+=1;
                                s.Addelement("insert into cpu values ("+lastcpu+",'"+s.name_cpu+"','"+s.frec_cpu+"',"+s.core_cpu+",'"+s.feature_cpu.replaceAll(" ",";")+"','"+s.revision_cpu+"','"+s.revision_cpu+"','"+s.gpu+"')");
                                
                      }
               
                  
                  
                }
                else{
                            s.Addelement("insert into device values ('"+device+"','"+s.name_dev+"','"+s.model_dev+"','"+s.ver_so+"','"+s.kernel_dev+"','"+s.build_dev+"','"+s.locale_dev+"','"+s.sto_ext_sd_t+"','"+s.sto_ext_sd_d+"','"+s.sto_s2sd_t+"','"+s.sto_s2sd_d+"','"+s.sto_inter_t+"','"+s.sto_inter_d+"','"+s.sto_sys_t+"','"+s.sto_sys_d+"','"+s.cache_sys_t+"','"+s.cache_sys_d+"','"+s.ram_t+"','"+s.ram_d+"','"+s.ram_l+"','"+c.values[4][0]+"','"+c.values[0][0]+"','"+c.values[1][0]+"','"+c.values[2][0]+"','"+c.values[16][0]+"',"+blu+","+cert+",'"+apps+"')");
                            s.Addelement("insert into display values('"+device+"',"+type_d+","+s.p_width_dev+","+s.p_height_dev+","+type_tac+",'"+s.p_size_dev+"','"+s.p_refresh_dev+"','"+s.p_density_dev+"','"+c.values[9][0]+"')");                          
                            if(s.n_cam_dev.contains("2")){
                                      s.Addelement("insert into device_cam values ('"+device+"','primary','"+c1[c1.length-1]+"',"+files.booleanToint("true",s.sta_flash.trim())+",'"+files.oneString(s.firsttab[0]).replaceAll(" ","")+"','"+files.oneString(s.firsttab[1]).replaceAll(" ","")+"','"+files.oneString(s.firsttab[4]).replaceAll(" ","")+"','"+s.focus_mode+"','"+s.max_focus_area+"','"+s.whitebalance_cam.replaceAll("\\s|null|\\]|\\[|", "")+"','"+s.scene_mode_cam.replaceAll("\\s|null|\\]|\\[|", "")+"',"+files.booleanToint("true",s.stabilization_video.trim())+",'"+s.quality_img+"','"+s.quality_thumb+"')");
   //                                   s.Addelement("insert into device_cam values ('"+device+"','secundary','"+c2[c2.length-1]+"',0,'"+files.oneString(s.firsttab[2]).replaceAll(" ","")+"','"+files.oneString(s.firsttab[3]).replaceAll(" ","")+"','null','null','null','null','null',0,'null','null')");
                                      s.Addelement("insert into device_cam values ('"+device+"','secundary','"+c2[c2.length-1]+"',0,'"+files.oneString(s.firsttab[2]).replaceAll(" ","")+"','"+files.oneString(s.firsttab[3]).replaceAll(" ","")+"','N/A','N/A','N/A','N/A','N/A',0,'N/A','N/A')");
                            }
                                else{
                                if(s.n_cam_dev.contains("1")){
                                          s.Addelement("insert into device_cam values ('"+device+"','primary','"+c1[c1.length-1]+"',"+files.booleanToint("true",s.sta_flash.trim())+",'"+files.oneString(s.firsttab[0]).replaceAll(" ","")+"','"+files.oneString(s.firsttab[1]).replaceAll(" ","")+"','"+files.oneString(s.firsttab[4]).replaceAll(" ","")+"','"+s.focus_mode+"','"+s.max_focus_area+"','"+s.whitebalance_cam.replaceAll("\\s|null|\\]|\\[|", "")+"','"+s.scene_mode_cam.replaceAll("\\s|null|\\]|\\[|", "")+"',"+files.booleanToint("true",s.stabilization_video.trim())+",'"+s.quality_img+"','"+s.quality_thumb+"')");
                                          }
                                }
                            if(s.Consultation("select * from cpu where name_cpu='"+s.name_cpu+"'")!=0){
      
                                  int cpu=s.ConsultforUIInt("select id_cpu as sel from cpu where name_cpu='"+s.name_cpu+"'", "sel");    

                                 s.Addelement("insert into device_cpu values ('"+device+"',"+cpu+")");
                            }

                                else{
                                    int lastcpu=s.ConsultforUIInt("select count(*) as t from cpu", "t");
                                    lastcpu+=1;
                                    s.Addelement("insert into cpu values ("+lastcpu+",'"+s.name_cpu+"','"+s.frec_cpu+"',"+s.core_cpu+",'"+s.feature_cpu.replaceAll(" ",";")+"','"+s.revision_cpu+"','"+s.revision_cpu+"','"+s.gpu+"')");
                                }
                            for(int i=0;i<mat;i++){
                            int ma=s.ConsultforUIInt("select id_mat from material where name_mat='"+c.values[3][i]+"'", "id_mat");
                            s.Addelement("insert into device_mat values ('"+device+"',"+ma+")");
                            }
                            for(int i=0;i<band;i++){
                            int nt=s.ConsultforUIInt("select id_net from network where val_net='"+c.values[5][i]+"'", "id_net");
                            s.Addelement("insert into device_network values ('"+device+"',"+nt+")");
                            }
                            for(int i=0;i<wifi;i++){
                            int nt=s.ConsultforUIInt("select id_net from network where val_net='"+c.values[6][i]+"'", "id_net");
                            s.Addelement("insert into device_network values ('"+device+"',"+nt+")");
                            }
                            s.Addelement("insert into device_battery values ('"+device+"',"+bat+",'"+c.values[12][0]+"')");
                            for(int i=0;i<other;i++){
                            int ot=s.ConsultforUIInt("select id_sup from other_support where name_sup='"+c.values[13][i]+"'", "id_sup");
                            s.Addelement("insert into device_support values ('"+device+"',"+ot+")");
                            }
                }

//                        int icpu = 0;
//            if(s.Consultation("select id_cpu from cpu where name_cpu='"+s.name_cpu+"'")==0){
//                if(s.Addelement("insert into cpu values ('"+s.name_cpu+"','"+s.frec_cpu+"',"+Integer.valueOf(s.core_cpu)+",'"+s.feature_cpu+"','"+s.revision_cpu+"','"+s.hard_cpu+"','"+s.gpu+"')")==true){ 
//                    icpu=Integer.valueOf(s.ConsultforUIString("select id_cpu from cpu where name_cpu='"+s.name_cpu+"'","id_cpu"));
//                }
//            }
//            else{
//            icpu=Integer.valueOf(s.ConsultforUIString("select id_cpu from cpu where name_cpu='"+s.name_cpu+"'","id_cpu"));
//            }
//            for(String s:c.values[3]){
//            
//            }
            tabdash.getSelectionModel().select(tabapp);         
            

            break;        
            
        }
    
    }
    public void AddApp(ActionEvent actionEvent){
    
    }
    public void menuItemTable(){
    tableinfodevice.setRowFactory(
    new Callback<TableView<Device>, TableRow<Device>>(){

        @Override
        public TableRow<Device> call(TableView<Device> param) {
            final TableRow<Device> row=new TableRow<>();
            final ContextMenu contextMenu=new ContextMenu();
            MenuItem modItem=new MenuItem("modificar");
            modItem.setOnAction((ActionEvent event) -> {
                columndescription.setCellFactory(TextFieldTableCell.<Device>forTableColumn());
             
            });
            MenuItem addItem=new MenuItem("agregar");
            addItem.setOnAction((ActionEvent event) -> {
                data.add(tableinfodevice.getSelectionModel().getSelectedIndex()+1,
                        new Device(tableinfodevice.getSelectionModel().getSelectedItem().getItem(),""));          
            });
            MenuItem deliItem=new MenuItem("eliminar");
            deliItem.setOnAction((ActionEvent event) -> {
                tableinfodevice.getItems().remove(row.getItem());
            });
            contextMenu.getItems().addAll(modItem,addItem,deliItem);
            row.contextMenuProperty().bind(
      Bindings.when(Bindings.isNotNull(row.itemProperty()))
      .then(contextMenu)
      .otherwise((ContextMenu)null));
            
            
            return row;
            
        }
    
    }
    );
    }
    public void viewMITable(){
    tablefails.setRowFactory(
    new Callback<TableView<Fail>, TableRow<Fail>>(){

        @Override
        public TableRow<Fail> call(TableView<Fail> param) {
            final TableRow<Fail> row=new TableRow<>();
            row.setOnMouseClicked(new EventHandler<MouseEvent>() {

                @Override
                public void handle(MouseEvent event) {
                    System.out.println(row.getItem().uf.getValue());
                    System.out.println(row.getItem().imgf.getValue());
                    txtnf.setText(row.getItem().nf.getValue());
                    txtdf.setText(row.getItem().df.getValue());
                }
            });
            return row;
        }
    
    }
    );
    }
    public void exit(ActionEvent actionEvent){
    System.exit(0);
    }
    public void minimize(ActionEvent actionEvent){
    
    }
    public void ProgressBar(int seconds){
 task = new Timeline(
        new KeyFrame(
                Duration.ZERO,       
                new KeyValue(bardashboard.progressProperty(), 0)
        ),
        new KeyFrame(
                Duration.seconds(seconds), 
                new KeyValue(bardashboard.progressProperty(), 1)
        )
    );  
    task.playFromStart();
  

}
    public void getParametersUser(ObservableList<String> observableList){
        idu=observableList.get(0);
      user.setText(observableList.get(1));
      permission.setText(observableList.get(2));
      avatar.setImage(new Image(observableList.get(3)));
      dateuser.setText(observableList.get(4));
    }
    public void getADB(int i){
    VAL=i;
    }
    public void typeAccess(int i){
    switch(i){
        case 0:
         accorMantenimiento.setDisable(true);
            break;
        case 1:
         accorMantenimiento.setDisable(false);   
            break;
        default:
            
    }
    }
    public void getColor(ActionEvent actionEvent){
    System.out.println(cpdev.getValue().toString());
    }
    public EventHandler<ActionEvent> installApp(){
                       columnappinstall.setCellValueFactory(new PropertyValueFactory<>(apktoinstalled));

   tableappinstall.setItems(dataappIns);
       createRowsAppInst(dataappIns, files.GetNameVariousFile(folderappbench));
        return null;
    }
    public void bench(String val){
      if(adb.b==1) {
        switch(val){
            case("antutu"):
                result1.setDisable(true);result2.setDisable(true);result3.setDisable(true);result4.setDisable(true);;result5.setDisable(true);
                cbcompatible.setDisable(true);lblr0.setDisable(true);lblr1.setDisable(true);lblr2.setDisable(true);lblr3.setDisable(true);lblr4.setDisable(true);lblr5.setDisable(true);
                estatusbench.setText("presione TEST para iniciar la prueba");
                photo.setVisible(true);
                lblphoto.setVisible(true);
                adb.execGeneric(start[0]+startapps[1], outConsole, adb.b);
                adb.execConsole(start[1]+startapps[1]+start[2], outConsole, adb.b,finishapp[0], estatusbench, probarapp, bsavebech,photo);
                result1.setDisable(false);
                lblr1.setDisable(false);
                lblimg.setDisable(false);
                lblcapt.setDisable(false);
                binitbech.setDisable(false);
                break;
            case("battery benchmark"):
                result1.setDisable(true);result2.setDisable(true);result3.setDisable(true);result4.setDisable(true);;result5.setDisable(true);
                cbcompatible.setDisable(true);lblr0.setDisable(true);lblr1.setDisable(true);lblr2.setDisable(true);lblr3.setDisable(true);lblr4.setDisable(true);lblr5.setDisable(true);
                estatusbench.setText("presione start bench para iniciar la prueba");
                photo.setVisible(true);
                lblphoto.setVisible(true);
                adb.execGeneric(start[0]+startapps[6], outConsole, adb.b);
                result1.setDisable(false);result2.setDisable(false);
                lblr1.setDisable(false);lblr2.setDisable(false);
                lblimg.setDisable(false);lblcapt.setDisable(false);
                binitbech.setDisable(false);    
            break;
            case("AndEBench"):
                result1.setDisable(true);result2.setDisable(true);result3.setDisable(true);result4.setDisable(true);;result5.setDisable(true);
                cbcompatible.setDisable(true);lblr0.setDisable(true);lblr1.setDisable(true);lblr2.setDisable(true);lblr3.setDisable(true);lblr4.setDisable(true);lblr5.setDisable(true);
                estatusbench.setText("presione START para iniciar la prueba");
                photo.setVisible(true);
                lblphoto.setVisible(true);
                adb.execGeneric(start[0]+startapps[2], outConsole, adb.b);
                result1.setDisable(false);result2.setDisable(false);
                lblr1.setDisable(false);lblr2.setDisable(false);
                lblimg.setDisable(false);lblcapt.setDisable(false);
                binitbech.setDisable(false);    
            break;
            case("3DMark"):
                result1.setDisable(true);result2.setDisable(true);result3.setDisable(true);result4.setDisable(true);;result5.setDisable(true);
                cbcompatible.setDisable(true);lblr0.setDisable(true);lblr1.setDisable(true);lblr2.setDisable(true);lblr3.setDisable(true);lblr4.setDisable(true);lblr5.setDisable(true);
                estatusbench.setText("presione RUN para iniciar la prueba");
                photo.setVisible(true);
                lblphoto.setVisible(true);
                adb.execGeneric(start[0]+startapps[5], outConsole, adb.b);
                result1.setDisable(false);
                lblr1.setDisable(false);
                lblimg.setDisable(false);lblcapt.setDisable(false);
                binitbech.setDisable(false);    
                adb.execConsole(start[1]+startapps[1]+start[2], outConsole, adb.b,finishapp[2], estatusbench, probarapp, bsavebech,photo);                

            break;
//            case("GXBench"):
//                estatusbench.setText("presione START ALL para iniciar la prueba");
//                photo.setVisible(true);
//                lblphoto.setVisible(true);
//                adb.execGeneric(start[0]+startapps[4], outConsole, adb.b);
//                result1.setDisable(false);result2.setDisable(false);
//                lblr1.setDisable(false);lblr2.setDisable(false);
//                lblimg.setDisable(false);lblcapt.setDisable(false);
//                binitbech.setDisable(false);    
//            break;
            case("Geekbench"):
                result1.setDisable(true);result2.setDisable(true);result3.setDisable(true);result4.setDisable(true);;result5.setDisable(true);
                cbcompatible.setDisable(true);lblr0.setDisable(true);lblr1.setDisable(true);lblr2.setDisable(true);lblr3.setDisable(true);lblr4.setDisable(true);lblr5.setDisable(true);
                estatusbench.setText("presione RUN BENCHMARKS para iniciar la prueba");
                photo.setVisible(true);
                lblphoto.setVisible(true);
                adb.execGeneric(start[0]+startapps[7], outConsole, adb.b);
                result1.setDisable(false);result2.setDisable(false);
                lblr1.setDisable(false);lblr2.setDisable(false);
                lblimg.setDisable(false);lblcapt.setDisable(false);
                binitbech.setDisable(false);
                adb.execConsole(start[1]+startapps[1]+start[2], outConsole, adb.b,finishapp[3], estatusbench, probarapp, bsavebech,photo);                

            break;
            case("Vellamo"):
                result1.setDisable(true);result2.setDisable(true);result3.setDisable(true);result4.setDisable(true);;result5.setDisable(true);
                cbcompatible.setDisable(true);lblr0.setDisable(true);lblr1.setDisable(true);lblr2.setDisable(true);lblr3.setDisable(true);lblr4.setDisable(true);lblr5.setDisable(true);
                estatusbench.setText("presione start para iniciar la prueba");
                photo.setVisible(true);
                lblphoto.setVisible(true);
                adb.execGeneric(start[0]+startapps[3], outConsole, adb.b);
                result1.setDisable(false);result2.setDisable(false);result3.setDisable(false);
                lblr1.setDisable(false);lblr2.setDisable(false);lblr3.setDisable(false);
                lblimg.setDisable(false);lblcapt.setDisable(false);
                binitbech.setDisable(false); 
                adb.execConsole(start[1]+startapps[1]+start[2], outConsole, adb.b,finishapp[1], estatusbench, probarapp, bsavebech,photo);                

            break;
            case("Basemark X"):
                result1.setDisable(true);result2.setDisable(true);result3.setDisable(true);result4.setDisable(true);;result5.setDisable(true);
                cbcompatible.setDisable(true);lblr0.setDisable(true);lblr1.setDisable(true);lblr2.setDisable(true);lblr3.setDisable(true);lblr4.setDisable(true);lblr5.setDisable(true);
                estatusbench.setText("presione start para iniciar la prueba");
                photo.setVisible(true);
                lblphoto.setVisible(true);
                adb.execGeneric(start[0]+startapps[9], outConsole, adb.b);
                result1.setDisable(false);result2.setDisable(false);
                lblr1.setDisable(false);lblr2.setDisable(false);
                lblimg.setDisable(false);lblcapt.setDisable(false);
                binitbech.setDisable(false);    
            break;
            case("Basemark OS II"):
                result1.setDisable(true);result2.setDisable(true);result3.setDisable(true);result4.setDisable(true);;result5.setDisable(true);
                cbcompatible.setDisable(true);lblr0.setDisable(true);lblr1.setDisable(true);lblr2.setDisable(true);lblr3.setDisable(true);lblr4.setDisable(true);lblr5.setDisable(true);
                estatusbench.setText("presione RUN BENCHMARK para iniciar la prueba");
                photo.setVisible(true);
                lblphoto.setVisible(true);
                adb.execGeneric(start[0]+startapps[8], outConsole, adb.b);
                result1.setDisable(false);result2.setDisable(false);result3.setDisable(false);
                result4.setDisable(false);result5.setDisable(false);
                lblr1.setDisable(false);lblr2.setDisable(false);lblr3.setDisable(false);
                lblr4.setDisable(false);lblr5.setDisable(false);
                lblimg.setDisable(false);lblcapt.setDisable(false);
                binitbech.setDisable(false);    
            break;
            case("Display Tester"):
                result1.setDisable(true);result2.setDisable(true);result3.setDisable(true);result4.setDisable(true);;result5.setDisable(true);
                cbcompatible.setDisable(true);lblr0.setDisable(true);lblr1.setDisable(true);lblr2.setDisable(true);lblr3.setDisable(true);lblr4.setDisable(true);lblr5.setDisable(true);
                estatusbench.setText("presione start para iniciar la prueba");
                photo.setVisible(true);
                lblphoto.setVisible(true);
                adb.execGeneric(start[0]+startapps[2], outConsole, adb.b);
                result1.setDisable(false);result2.setDisable(false);
                lblr1.setDisable(false);lblr2.setDisable(false);
                lblimg.setDisable(false);lblcapt.setDisable(false);
                binitbech.setDisable(false);    
            break;
            case("twitter"):
                result1.setDisable(true);result2.setDisable(true);result3.setDisable(true);result4.setDisable(true);;result5.setDisable(true);
                cbcompatible.setDisable(true);lblr0.setDisable(true);lblr1.setDisable(true);lblr2.setDisable(true);lblr3.setDisable(true);lblr4.setDisable(true);lblr5.setDisable(true);
                estatusbench.setText("inicie sesion y pruebe la aplicación");
                photo.setVisible(true);
                lblphoto.setVisible(true);
                adb.execGeneric(start[0]+startapps[10], outConsole, adb.b);
                cbcompatible.setDisable(false);lblr0.setDisable(false);
                break;
            case("instagram"):
                result1.setDisable(true);result2.setDisable(true);result3.setDisable(true);result4.setDisable(true);;result5.setDisable(true);
                cbcompatible.setDisable(true);lblr0.setDisable(true);lblr1.setDisable(true);lblr2.setDisable(true);lblr3.setDisable(true);lblr4.setDisable(true);lblr5.setDisable(true);
                estatusbench.setText("inicie sesion y pruebe la aplicación");
                photo.setVisible(true);
                lblphoto.setVisible(true);
                adb.execGeneric(start[0]+startapps[11], outConsole, adb.b);
                cbcompatible.setDisable(false);lblr0.setDisable(false);
                break;
            case("facebook"):
                result1.setDisable(true);result2.setDisable(true);result3.setDisable(true);result4.setDisable(true);;result5.setDisable(true);
                cbcompatible.setDisable(true);lblr0.setDisable(true);lblr1.setDisable(true);lblr2.setDisable(true);lblr3.setDisable(true);lblr4.setDisable(true);lblr5.setDisable(true);
                estatusbench.setText("inicie sesion y pruebe la aplicación");
                photo.setVisible(true);
                lblphoto.setVisible(true);
                adb.execGeneric(start[0]+startapps[12], outConsole, adb.b);
                cbcompatible.setDisable(false);lblr0.setDisable(false);
                break;
            case("whatsapp"):
                result1.setDisable(true);result2.setDisable(true);result3.setDisable(true);result4.setDisable(true);;result5.setDisable(true);
                cbcompatible.setDisable(true);lblr0.setDisable(true);lblr1.setDisable(true);lblr2.setDisable(true);lblr3.setDisable(true);lblr4.setDisable(true);lblr5.setDisable(true);
                estatusbench.setText("inicie sesion y pruebe la aplicación");
                photo.setVisible(true);
                lblphoto.setVisible(true);
                adb.execGeneric(start[0]+startapps[13], outConsole, adb.b);
                cbcompatible.setDisable(false);lblr0.setDisable(false);
                break;
            case("skype"):
                result1.setDisable(true);result2.setDisable(true);result3.setDisable(true);result4.setDisable(true);;result5.setDisable(true);
                cbcompatible.setDisable(true);lblr0.setDisable(true);lblr1.setDisable(true);lblr2.setDisable(true);lblr3.setDisable(true);lblr4.setDisable(true);lblr5.setDisable(true);
                estatusbench.setText("inicie sesion y pruebe la aplicación");
                photo.setVisible(true);
                lblphoto.setVisible(true);
                adb.execGeneric(start[0]+startapps[14], outConsole, adb.b);
                cbcompatible.setDisable(false);lblr0.setDisable(false);
                break;
        }   

      }
      else{
      adb.alertMessage(mesagges[0]);
      }
    }
    public void startBench(ActionEvent actionEvent){
    bench(files.getValueCb(cbbench));
    }
    public void saveRBench(ActionEvent actionEvent){
if(!result1.getText().equals("")&&!lblimg.getText().equals("")){
  tabletest.setEditable(true);
  columnantest.setCellValueFactory(new PropertyValueFactory<>("nt"));
  columnartest.setCellValueFactory(new PropertyValueFactory<>("rt"));
  columnaitest.setCellValueFactory(new PropertyValueFactory<>("it"));
  tabletest.setItems(dataBench);
  String cb=files.getValueCb(cbbench);

        switch(cb){
        
            case("antutu"):
                createRowsBench(dataBench,cb,result1.getText(),files.oneString(listimg));
                break;
            case("battery benchmark"):
                createRowsBench(dataBench,cb,result1.getText(),files.oneString(listimg));
                break;
            case("AndEBench"):
                createRowsBench(dataBench,cb,result1.getText()+";"+result2.getText(),files.oneString(listimg));
                break;
            case("3DMark"):
                createRowsBench(dataBench,cb,result1.getText(),files.oneString(listimg));
                break;
            case("Geekbench"):
                createRowsBench(dataBench,cb,result1.getText(),files.oneString(listimg));
                break;
            case("Vellamo"):
                createRowsBench(dataBench,cb,result1.getText(),files.oneString(listimg));
                break;
            case("Basemark X"):
                createRowsBench(dataBench,cb,result1.getText(),files.oneString(listimg));
                break;
            case("Basemark OS II"):
                createRowsBench(dataBench,cb,result1.getText(),files.oneString(listimg));
                break;
            case("Display Tester"):
                createRowsBench(dataBench,cb,result1.getText(),files.oneString(listimg));
                break;
            case("twitter"):
                createRowsBench(dataBench,cb,files.getValueCb(cbcompatible),files.oneString(listimg));
                break;
            case("instagram"):
                createRowsBench(dataBench,cb,files.getValueCb(cbcompatible),files.oneString(listimg));
                break;
            case("facebook"):
                createRowsBench(dataBench,cb,files.getValueCb(cbcompatible),files.oneString(listimg));
                break;
            case("whatsapp"):
                createRowsBench(dataBench,cb,files.getValueCb(cbcompatible),files.oneString(listimg));
                break;
            case("skype"):
                createRowsBench(dataBench,cb,files.getValueCb(cbcompatible),files.oneString(listimg));
                break;
        }
        
       } 
else{
    adb.alertMessage(mesagges[6]);
}
    }
    public void Img(String path){
         ImageView imageView = null;
        File folder=new File(path);
        File[] listFiles=folder.listFiles();
        if(listFiles.length>0){
            tilePane.getChildren().clear();
            lblmsjimg.setText("presione 2 click izquierdo para visualizar / derecho para descartar imagen");
        for(final File file:listFiles){
                try {
                    imageView=createImageView(file);
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(DashboardController.class.getName()).log(Level.SEVERE, null, ex);
                }
            tilePane.getChildren().addAll(imageView);
          
        }
        imageView.setImage(null);
        listFiles=null;
        folder=null;
        }
        else{
            tilePane.getChildren().clear();
        lblmsjimg.setText("no hay imagenes disponibles");
        }
    }
    private ImageView createImageView(final File imageFile) throws FileNotFoundException{
        // DEFAULT_THUMBNAIL_WIDTH is a constant you need to define
        // The last two arguments are: preserveRatio, and use smooth (slower)
        // resizing
        FileInputStream fileInputStream = new FileInputStream(imageFile);
        
  Image image = null;
  ImageView imageView1=new ImageView();
  BorderPane borderPane = new BorderPane();
  image = new Image(fileInputStream, 150, 0, true,
          true);
             ImageView imageView = new ImageView(image);
      
            imageView.setFitWidth(150);
            imageView.setOnMouseClicked((MouseEvent mouseEvent) -> {
                if (mouseEvent.getButton().equals(MouseButton.PRIMARY)) {
                    if (mouseEvent.getClickCount() == 2) {
                        FileInputStream fileInputStream2 = null;
                        try {
                            fileInputStream2 = new FileInputStream(imageFile);
                            Image image1 = null;
                            image1 = new Image(fileInputStream2);
                            imageView1.setImage(image1);
                            imageView1.setStyle("-fx-background-color: null");
                            imageView1.setFitHeight(application.stage.getHeight() - 10);
                            imageView1.setPreserveRatio(true);
                            imageView1.setSmooth(true);
                            imageView1.setCache(true);
                            borderPane.setCenter(imageView1);
                            borderPane.setStyle("-fx-background-color: null");
                            Stage newStage = new Stage();
                            newStage.setWidth(application.stage.getWidth());
                            newStage.setHeight(application.stage.getHeight());
                            newStage.setTitle(imageFile.getName());
                            Scene scene1 = new Scene(borderPane,Color.WHITE);
                            newStage.setScene(scene1);
                            newStage.show();
                        } catch (FileNotFoundException ex) {
                            Logger.getLogger(DashboardController.class.getName()).log(Level.SEVERE, null, ex);
                        } finally {
                            try {
                                fileInputStream2.close();
                            } catch (IOException ex) {
                                Logger.getLogger(DashboardController.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                        try {
                            fileInputStream2.close();
                        } catch (IOException ex) {
                            Logger.getLogger(DashboardController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                   
                }
           
                if (mouseEvent.getButton().equals(MouseButton.SECONDARY)) {
            if (mouseEvent.getClickCount() == 2) {
                
                listdelimg[z]=imageFile.getAbsolutePath();
                imageFile.deleteOnExit();
                tilePane.getChildren().remove(imageView);
                
                
               z++;

            }
                    
                }
            
            });
           image=null;
        try {
            fileInputStream.close();
        } catch (IOException ex) {
            Logger.getLogger(DashboardController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return imageView;
    }
    public void Loadimg(ActionEvent actionEvent){
        switch(files.getValueCb(cbfilterimg)){
            case("pruebas"):
                Img("C:\\application\\img\\test");
            break;
            case("fallas"):
                Img("C:\\application\\img\\fails");
            break;
            case("dispositivo"):
                Img("C:\\application\\img\\device");
            break;
            case("otras"):
                Img("C:\\application\\img\\others");
            break;    

        }
    } 
    public void deleteImg(ActionEvent actionEvent){
     Path path;
                    tilePane.getChildren().clear();
                try {
                    for(String paths:files.RemoveNullValue2(listdelimg)){
                         path = Paths.get(paths);
                         Files.deleteIfExists(path);
                    }
                   
                    //Files.delete(path);
                } catch (IOException ex) {
                    Logger.getLogger(DashboardController.class.getName()).log(Level.SEVERE, null, ex);
                }
    }
    public void addfails(ActionEvent actionEvent){
        // Create the custom dialog.
            fail[1]="";fail[2]="";fail[3]="";
    Button bcapfails=new Button("capturar imagen");   
    Dialog dlg = new Dialog(application.stage, "Fallas");

    GridPane grid = new GridPane();
    grid.setHgap(10);
    grid.setVgap(10);
    grid.setPadding(new Insets(0, 10, 0, 10));

    namefail.setPromptText("tipo de falla");
    descriptionfail.setPromptText("descripción de la falla");

    grid.add(new Label("nombre:"), 0, 0);
    grid.add(namefail, 1, 0);
    
    grid.add(new Label("descripción:"), 0, 1);
    grid.add(descriptionfail, 1, 1);
    grid.add(lblimgfail, 1, 2);

    ButtonBar.setType(actionFail, ButtonType.OK_DONE);
    actionFail.disabledProperty().set(true);
   // bcapfails.setOnAction(actioncapinmg);
    // Do some validation (using the Java 8 lambda syntax).
    namefail.textProperty().addListener((observable, oldValue, newValue) -> {
        actionFail.disabledProperty().set(newValue.trim().isEmpty());
    });
    actioncapinmg.disabledProperty().addListener((observable, oldValue, newValue) -> {
        lblimgfail.setText(imgc);
    });

    dlg.setMasthead("ingrese información referente a falla");
    dlg.setContent(grid);
    dlg.getActions().addAll(actionFail,actioncapinmg, Dialog.Actions.CANCEL);

    // Request focus on the username field by default.
    
    namefail.setText("");
    descriptionfail.setText("");
    descriptionfail.setWrapText(true);
    dlg.show();
    
    } 
    public void getChartDevice(ActionEvent actionEvent){
        String[] val={"bd","nd"};

  tablechart.setEditable(true);
  columnaselect.setCellValueFactory(new PropertyValueFactory<>(val[0]));
  columnaselect.setCellFactory(CheckBoxTableCell.forTableColumn(columnaselect));
  columnaselect.setEditable(true);
  columnanchart.setCellValueFactory(new PropertyValueFactory<>(val[1]));

 tablechart.setItems(datachart);
        createRowsChart(datachart,"fedwjfwpf");
    }
    public void getCherDeviceTrue(ActionEvent actionEvent){
        for(Chart c:tablechart.getItems()){
            if(c.getBd()==true){
                System.out.println("EXISSTE");
            }
        }
    }
    public void checkInduction(String val){
        if(s.Consultation("select * from user_preferences where u_pref="+val+" and id_pref=1 and desc_pref='true'")==0){
   tabdash.getSelectionModel().select(tabinduction);
  }
  else{
       tabdash.getSelectionModel().select(tabdevice);
            bcontinue.setVisible(true);
            baddfails.setVisible(true);
            badvantage.setVisible(true);
  }
    }
    public void BDtoTable(int i,int y,String[] desc,TableView tv,TableColumn tc,TableColumn tc1,String[] ses){
        int z=0,x=0;
    switch(i){
        case(0):
            
   tc.setCellValueFactory(new PropertyValueFactory<>(ses[0]));
   tc1.setCellValueFactory(new PropertyValueFactory<>(ses[1]));
   tv.setItems(data);
          String[][] val= s.getBD(1,"select * from device where id_Device='"+device+"'",new String[]{"id_device","name_dev","model_dev","ver_so","kernel","build_dev","locale_dev","sto_ext_sd_t",
                "sto_ext_sd_d","sto_s2sd_t","sto_s2sd_d","sto_inter_t","sto_inter_d","sto_sys_t","sto_sys_d","cache_sys_t","cache_sys_d","ram_t","ram_d","ram_l","color","h_dev","w_dev","bulk_dev",
                "weight_dev","id_blu","cert_google"});

                for(String g: files.RemoveNullValue2(val[0])){
                System.out.println(g);
                data.add(new Device(desc[x],g));
                x++;
                }       
        break;
        case 1:
          x=0;
            String[][] va=s.getBD(2,"select * from device_cam where id_dev_cam='"+device+"'",new String[]{"type_cam","mp_cam","flash_cam","supp_img_cam","supp_vid_cam","dis_focus","focus_enabled","focus_area","whitebalance","scene_mode","sta_vid","q_jpeg","q_thum"});
          
              for(String c:files.RemoveNullValue2(va[0])){
             System.out.println(c);
             data.add(new Device(desc[x],c));
             x++;
             }
        break;
        case 2:
          x=0;
            String[][] va1=s.getBD(2,"select * from device_cam where id_dev_cam='"+device+"'",new String[]{"type_cam","mp_cam","flash_cam","supp_img_cam","supp_vid_cam","dis_focus","focus_enabled","focus_area","whitebalance","scene_mode","sta_vid","q_jpeg","q_thum"});
          
             for(String c:files.RemoveNullValue2(va1[1])){
             System.out.println(c);
             data.add(new Device(desc[z],c));
             z++;
             }
        break;
        case 3:
          x=0;
          String cpu=s.ConsultforUIString("select * from device_cpu where id_dev_cpu='"+device+"'","id_cpu_c");
            String[][] va2=s.getBD(1,"select * from cpu where id_cpu="+cpu+"",new String[]{"name_cpu","frec_cpu","core_cpu","feature_cpu","revision_cpu","hard_cpu","gpu"});
          
              for(String c:files.RemoveNullValue2(va2[0])){
             System.out.println(c);
             data.add(new Device(desc[x],c));
             x++;
             }

        break;

    }
    }
    }
    


