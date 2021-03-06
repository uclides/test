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
import static demo.GenericInterface.rd;
import demo.connections.adb;
import demo.connections.files;
import demo.connections.server;
import demo.tables.Apk;
import demo.tables.Chart;
import demo.tables.Fail;
import demo.tables.Mant;
import demo.tables.Tst;
import demo.tables.Update;
import java.awt.Desktop;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashSet;
import java.util.LinkedList;
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
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Series;
import javafx.scene.control.Accordion;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ContextMenu;
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
import javafx.scene.control.TitledPane;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.TilePane;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Callback;
import javafx.util.Duration;
import org.apache.commons.io.FileUtils;
import org.controlsfx.control.ButtonBar;
import org.controlsfx.control.ButtonBar.ButtonType;
import org.controlsfx.control.action.AbstractAction;
import org.controlsfx.control.action.Action;
import org.controlsfx.dialog.Dialog;
import reports.Reports;


/**
 *
 * @author project
 */
public class DashboardController extends AnchorPane implements Initializable,GenericInterface{
    @FXML
    Button detectdevice,bdevice,bcontinue,bcontinue2,bcomponente,bprovider,bapp,bcompare,
            exit,bmanual,baddcomporprov,bmore,bprocapp,binstapp,binitbech,bsavebech,bxml,bloadimg,borrarimgs,baddfails,
            bfails,bprev,bnext,bcreatec,binduction,badvantage,brestore,banyimg,bfreport,bgreport,
            generatereport,btest,visualize,addmant,addnewmant,bmant,bimgdevice;
    @FXML
    Label activedevice,user,permission,dateuser,lblcompinfo,estatusapp,estatusbench,lblr0,lblr1,
            lblr2,lblr3,lblr4,lblr5,lblimg,lblcapt,lblphoto,lblfilter,lblmsjimg,helper,lblinfod,lblinfofail,lblversus,
            lbldesmant,lblmant1,lblmant2,lblmant3,lblmant4,lblmant5,lblmant6,lblinfomant,lblreport;
    @FXML
    TextField txtnf;
    @FXML
    TextArea txtdf;
    @FXML
    ImageView avatar,photo;
    @FXML
    Accordion accordion;
    @FXML
    TabPane tabdash,tabchart;
    @FXML
    Tab tabinduction,tabdevice,tabcomp,tabapp,tabtest,tabimage,tabcompare,tabfails,tabreport,tabmant,
            tabbar1,tabbar4,tabbar5,tabbar6,tabbar7,tabbar8,tabbar9,tabbar10,tabbar11;
    @FXML
    TitledPane  accorIdentificacion,accorBenchmark,accorImagenes,accorVersus,
            accorFallas,accorReporte,accorMantenimiento,accorAyuda;
    @FXML
    TextArea outConsole,positive,negative;
    @FXML
    ProgressBar bardashboard; 
    @FXML
    ProgressIndicator probarapp,progreport; 
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
    TableView<Mant> tablemant;
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
    TableColumn<Tst,String>columnaitest1;
    @FXML
    TableColumn<Tst,String>columnaitest2;
    @FXML
    TableColumn<Tst,String>columnaitest3;
    @FXML
    TableColumn<Tst,String>columnaitest4;
    @FXML
    TableColumn<Fail,String> columnafuser;
    @FXML
    TableColumn<Fail,String> columnafname;
    @FXML
    TableColumn<Fail,String> columnafdesc;
    @FXML
    TableColumn<Fail,String> columnafimg;
    @FXML
    TableColumn<Fail,String> columnafdate;
    @FXML
    TableColumn<Chart,Boolean> columnaselect;
    @FXML
    TableColumn<Chart,String> columnanchart;
    @FXML
    TableColumn<Mant,String> columnamant1,columnamant2,columnamant3,columnamant4,columnamant5;
    @FXML
    SplitPane splitPane; 
    @FXML
    ComboBox tecnologiadisplay,cbtypedis,cbtactildis,cbtypebat,cbbluetooth,cbprov,cbcertgoogle,cbbench,cbcompatible,
             cbfilterimg,cbtypecomp,cbspecomp,cbmante;
    @FXML
    ColorPicker cpdev;
    @FXML
    MenuButton choicewifi,choiceband,choicesensor,choicematerialdev;
    
    @FXML 
    TextField txthdev,txtwdev,txtbulkdev,txtweight,txtcolordis,txtcapbat,txtelemadd1,
              txtelemadd2,txtelemadd3,result1,result2,result3,result4,result5,
            txtmant1,txtmant2,txtmant3,txtmant4,txtmant5,txtmant6;
    List<CheckMenuItem> itemsband,itemswifi;
    @FXML
    ScrollPane scrollPane;
    @FXML
    TilePane tilePane;
    @FXML
    CheckBox chkpref;
    @FXML
    BarChart<String,Number> barChart,barChart3,barChart4,barChart5,barChart6,barChart7,barChart8,barChart9,barChart10;
    @FXML
    CategoryAxis xAxis,xAxis1=new CategoryAxis();
    @FXML
    NumberAxis yAxis,yAxis1= new NumberAxis();;
    Task task2;
     int tpng=0;int z=0;int fpng=0;
    //instances
 adb adb = new adb();
 files files=new files();
Reports reporte=new Reports();
  String[] info,info2,info3,info4,info5,info6,info7,info8,info9,
          info10,info11,info12,info13,info14,info15,info16,
          info17,info18,info19,info20,info21;
  String[] items=new String[1];
  String[] listimg=new String[100];
  String[] listimgfail=new String[100];
  String[] listdelimg=new String[100];
  String[] listdelimgfail=new String[100];
  List<String> functiondevice=new ArrayList<>();
  String[] fail=new String[10];
  String idu,device,date,devi;
   ObservableList<Device> data=FXCollections.observableArrayList();
   ObservableList<App> dataapp=FXCollections.observableArrayList();
   ObservableList<Apk> dataappIns=FXCollections.observableArrayList();
   ObservableList<Update> dataappUp=FXCollections.observableArrayList();
   ObservableList<Tst> dataBench=FXCollections.observableArrayList();
    ObservableList<Fail> datafail=FXCollections.observableArrayList();
    ObservableList<Chart>datachart=FXCollections.observableArrayList();
    ObservableList<Mant>datamant=FXCollections.observableArrayList();
   public ObservableList<String> attrLogin;
private Main application;
LoginController login=new LoginController();
String[] out = new String[100];
    private Timeline task;
server s=new server();
Controls c=new Controls();
String[] foldersdevice=new String[10];

    int count;
public int VAL;
final TextField namefail = new TextField();
final TextArea descriptionfail = new TextArea();
final Label lblimgfail =new Label();
final Action actionFail,actioncapinmg,actionRestore,actionfunc;
String imgc,imgtest;

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
        if(adb.execGeneric(pullimg[0]+String.valueOf(ramdom2)+capturedis[1]+" "+folderimg[0]+device, null, adb.b)==null){
            imgc="no se pudo enviar la imagen al servidor";
        }
        else{
        imgc=foldersdevice[0]+"/"+String.valueOf(ramdom2)+capturedis[1];
        this.setDisabled(true);
        } 
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
    
 
System.out.println(date);
String[] val={"uf","nf","df","imgf","datef"};

  tablefails.setEditable(true);
  columnafuser.setCellValueFactory(new PropertyValueFactory<>(val[0]));
  columnafname.setCellValueFactory(new PropertyValueFactory<>(val[1]));
  columnafdesc.setCellValueFactory(new PropertyValueFactory<>(val[2]));
  columnafimg.setCellValueFactory(new PropertyValueFactory<>(val[3]));
  columnafdate.setCellValueFactory(new PropertyValueFactory<>(val[4]));
  tablefails.setItems(datafail);
    fail[1]=namefail.getText();
    fail[2]=descriptionfail.getText();
    fail[3]=lblimgfail.getText();
    fail[4]=date;
    int i=s.ConsultforUIInt("select count(id_image)as t from image","t");
    i+=1;
    s.Addelement("insert into image values("+i+",'"+device+"','falla','"+date+"','"+"file:"+fail[3]+"')");
    
    int j=s.ConsultforUIInt("select count(id_fail) as t from device_failure","t");
    j+=1;
    s.Addelement("insert into device_failure values("+j+",'"+device+"','"+fail[1]+"','"+fail[2]+"',"+i+",'"+date+"',"+idu+")");
    createRowsFails(datafail,user.getText(),fail[1],fail[2],fail[3],fail[4]);
    actioncapinmg.disabledProperty().set(false);
    lblimgfail.setText("");  
    d.hide();
       } 
else{
    adb.alertMessage(mesagges[6]);
}
            }
        };
        this.actionRestore = new AbstractAction("") {
            // This method is called when the login button is clicked ...
            @Override
            public void handle(ActionEvent ae) {
  if(adb.confirmMessage("restablecer proceso",question1[0])){
      brestore.setVisible(false);
      detectdevice.setVisible(true);
      
      tableinfodevice.getItems().removeAll(data);
      for(String p:new String[]{rd[1]+device+rd[0],rd[1]+device+rd[0],rd[2]+device+rd[0],rd[2]+device+rd[0],rd[3]+device+rd[0],rd[4]+device+rd[0],
            rd[5]+device+rd[0],rd[6]+device+rd[0],rd[7]+device+rd[0],rd[8]+device+rd[0],rd[9]+device+rd[0]}){
        s.Addelement(p);
      }
      lblinfod.setText("Operación realizada, puede volver a evaluar el dispositivo");
      baddfails.setDisable(true);
                            }

            }
        };
        this.actionfunc=new AbstractAction("Aceptar") {
            
            @Override
            public void handle(ActionEvent event) {
                
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
       
      adb.checkDir(1, new String[]{"C:\\Users\\project\\AppData\\Local\\Android\\android-studio\\sdk\\platform-tools\\adb shell ls /storage/sdcard0/app-siragon","C:\\Users\\project\\AppData\\Local\\Android\\android-studio\\sdk\\platform-tools\\adb shell mkdir -p /storage/sdcard0/app-siragon/ADB","C:\\Users\\project\\AppData\\Local\\Android\\android-studio\\sdk\\platform-tools\\adb shell mkdir -p /storage/sdcard0/app-siragon/captures","C:\\Users\\project\\AppData\\Local\\Android\\android-studio\\sdk\\platform-tools\\adb shell mkdir -p /storage/sdcard0/app-siragon/result-benchmark","C:\\Users\\project\\AppData\\Local\\Android\\android-studio\\sdk\\platform-tools\\adb shell mkdir -p /storage/sdcard0/app-siragon/apk","C:\\Users\\project\\AppData\\Local\\Android\\android-studio\\sdk\\platform-tools\\adb shell mkdir -p /storage/sdcard0/logs"},"No such file or directory");
  
      device=adb.returnID(devicedisp);
        for(String st:new String[]{folderimg[0],folderimg[1],folderimg[2],folderimg[3]}){
      int x=0;
               File f=new File(st+device);
             if(!f.exists()){
          try {
              f.mkdir();
              new File(f.getAbsolutePath(),"temp").createNewFile();
              foldersdevice[x]=folderimgA[x]+device+"/";
          } catch (IOException ex) {
              Logger.getLogger(DashboardController.class.getName()).log(Level.SEVERE, null, ex);
          }
                 
             }
             else{
             foldersdevice[x]=folderimgA[x]+device;
                 
             }
             x++;
  }
      device=adb.returnID(devicedisp);
      System.out.println(device);
         if(s.Consultation("select * from device where id_device='"+device+"'")!=0){ 
                            
                            if(adb.confirmMessage(exrecord,question1[0])){
                                System.out.println("LOAD INFORMATION DEVICE");
                           BDtoTable(0,0,new String[]{valdev,valmod,valprod,valrel,valker,valbui,valoc,valextt,valextd,vala2sdt,vala2sdd,alminter[0],alminter[1],almsis[0],almsis[1],dispcache[0],dispcache[1],dispm[0],dispm[1],dispm[2],"color","alto","ancho","grosor","peso","tipo de bluetooth","certificado google"},tableinfodevice,columnitem,columndescription,new String[]{valitem,valdevi});
                           BDtoTable(1,0,new String[]{"tipo de camara","megapixels",est[0],sup[0],vidsup[0],mod[0],otfeature[0],otfeature[1],otfeature[2],otfeature[3],otfeature[4],otfeature[5],otfeature[6]},tableinfodevice,columnitem,columndescription,new String[]{valitem,valdevi});
                           BDtoTable(2,0,new String[]{"tipo de camara","megapixels",est[0],sup2[0],vidsup2[0],mod[0],otfeature[0],otfeature[1],otfeature[2],otfeature[3],otfeature[4],otfeature[5],otfeature[6]},tableinfodevice,columnitem,columndescription,new String[]{valitem,valdevi});
                           BDtoTable(3,0,new String[]{proc[0],frec[0],"Cores CPU",profeature[0],profeature[7],profeature[6],"GPU"},tableinfodevice,columnitem,columndescription,new String[]{valitem,valdevi});
                           detectdevice.setVisible(false);
                           lblinfod.setText("Se ha cargado la información correctamente, si desea evaluar el dispositivo nuevamente se borraran todos sus registros ");
                           brestore.setVisible(true);
                           brestore.setOnAction(actionRestore);
                           baddfails.setDisable(false);
                            }
                        }
                        else{
//             File f=new File(folderimg[4]+device);
//             if(!f.exists()){
//                 f.mkdir();
//                 folderimg[1]=folderimg[4]+device;
//                 ffail=folderimg[4]+device+"\\\\\\\\";
//             }
                            ProgressBar(2);
adb.execGeneric(installSiragonapp,outConsole,adb.b);
ProgressBar(1);
adb.execGeneric("C:\\Users\\project\\AppData\\Local\\Android\\android-studio\\sdk\\platform-tools\\adb shell am start -n org.uguess.android.sysinfo/.SiragonInfo",outConsole,adb.b);
ProgressBar(1);
if(!files.checkDir("/storage/sdcard0/logs", ".zip")){
adb.execGeneric(pullfile,outConsole,adb.b);
lblinfod.setText("Información obtenida correctamente");
}
lblinfod.setText("Información obtenida correctamente");
//adb.execGeneric(pullfile,outConsole,adb.b);
pushInfo();
                           // activedevice.setText("verifica estatus del servidor");                       
//                          profile.detectdevice.setOnAction((event) -> {
//                              adb.execTerminal(server);
//                           });
                bcontinue.setVisible(true);            
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
if(new File(folderegister).listFiles().length==0){
info21 = files.RemoveNullValue2(adb.execGeneric("C:\\Users\\project\\AppData\\Local\\Android\\android-studio\\sdk\\platform-tools\\adb shell pm list package", outConsole, adb.b));
        
createRowsApp(dataapp,info21);
}
else{
   info21 = files.PushInfoApp(valappinstall);
        
createRowsApp(dataapp,info21);
}
if(!tableapp.getItems().isEmpty()){
   bprocapp.setText(chantxtbt[0]);
   bprocapp.setOnAction(installApp());
   

}
bprocapp.setText("verificar aplicaciones");
bprocapp.setOnAction(new EventHandler<ActionEvent>() {

                     @Override
                     public void handle(ActionEvent event) {
                                     tableappupdate.setEditable(true);
   columnappupdate.setCellValueFactory(new PropertyValueFactory<>(apktochecks));

   tableappupdate.setItems(dataappUp);

   info21 = files.RemoveNullValue2(adb.execGeneric("C:\\Users\\project\\AppData\\Local\\Android\\android-studio\\sdk\\platform-tools\\adb shell pm list package", outConsole, adb.b));
        
createRowsAppUp(dataappUp,info21);
bcontinue.setDisable(false);
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
             lblinfod.setText("Es necesario generar el reporte a tráves de la aplicación móvil Opción: (Enviar informe)");
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
          
   columnitem.setCellValueFactory(new PropertyValueFactory<>(valitem));
   columndescription.setCellValueFactory(new PropertyValueFactory<>(valdevi));
   columndescription.setCellFactory(TextFieldTableCell.<Device>forTableColumn());

    data=FXCollections.observableArrayList(
new Device("Dispositivo",""),
new Device("Modelo",""),
new Device("Producto",""),
new Device("Marca",""),
new Device("Release",""),
new Device("Build",""),
new Device("Locale",""),
new Device("Kernel",""),
new Device("Almacenamiento externo SD total",""),
new Device("Almacenamiento externo SD Disponible",""),
new Device("Almacenamiento A2SD total",""),
new Device("Almacenamiento A2SD Disponible",""),
new Device("Pantalla Height",""),
new Device("Pantalla Width",""),
new Device("Pantalla density",""),
new Device("Pantalla size",""),
new Device("Pantalla refresh rate",""),
new Device("soporte resolución imagenes camara principal ",""),
new Device("soporte resolución video camara principal ",""),
new Device("soporte resolución imagenes camara secundaria ",""),
new Device("soporte resolución video camara secundaria ",""),
new Device("modo de foco cámara ",""),
new Device("Focus mode",""),
new Device("Max Num Focus Areas",""),
new Device("Whitebalance Values",""),
new Device("Scene mode Values",""),
new Device("Stabilization Video",""),
new Device("Quality JPEG",""),
new Device("Quality Thumbnail",""),
new Device("numero camara  ",""),
new Device("estatus flash ",""),
new Device("Almacenamiento Interno Total",""),
new Device("Almacenamiento Interno Disponible",""),
new Device("Almacenamiento del Sistema Total",""),
new Device("Almacenamiento del Sistema Disponible",""),
new Device("Caché del Sistema Total",""),
new Device("Caché del Sistema Disponible",""),
new Device("Memoria RAM Total",""),
new Device("Memoria RAM Disponible",""),
new Device("Memoria RAM Idle",""),
new Device("Tipo CPU",""),
new Device("Frecuencia CPU",""),
new Device("Red",""),
new Device("Caracteristicas",""),
new Device("CPU implementador",""),
new Device("CPU arquitectura",""),
new Device("CPU variante",""),
new Device("CPU parte",""),
new Device("CPU revision",""),
new Device("Hardware",""),
new Device("Revision",""),
new Device("Serial",""),
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
   System.out.println(files.RemoveNullValue(val1).length+"  CANTIDAD");
    for(int y=0;y<files.RemoveNullValue(val1).length-1;y++){

    data.add(new App(val1[y]));

    }


   }
   public void createRowsAppUp(ObservableList<Update> data,String[] val1){
   
    for(int y=1;y<files.RemoveNullValue(val1).length;y++){

    data.add(new Update(val1[y++]));

    }


   }
   public void createRowsBench(ObservableList<Tst> data,String va1,String va2,String va3,String va4,String va5,String va6,String va7){

    data.add(new Tst(va1,va2,va3,va4,va5,va6,va7));

   }
   public void createRowsAppInst(ObservableList<Apk> data,String[] val1){
       int y=val1.length;

        for (String val11 : val1) {
            
          
           // Platform.runLater( new Thread(adb.execGenericLoop(insgenbench+val11, outConsole, adb.b,data,val11,estatusapp)));
                //data.add(new Apk(val11));
                   Platform.runLater( new Thread(adb.execGenericLoop(insgenbench+val11, outConsole, adb.b,data,val11,estatusapp,y,probarapp)));

        }
   }
   public void createRowsFails(ObservableList<Fail> data,String va1,String va2,String va3,String va4,String va5){

    data.add(new Fail(va1, va2, va3, va4, va5));

   }
   public void createRowsChart(ObservableList<Chart> data,String va2){

    data.add(new Chart(va2));

   }
   public void createRowsMant(ObservableList<Mant> data,String va1,String va2,String va3,String va4,String va5){

    data.add(new Mant(va1,va2,va3,va4,va5));

   }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
menuItemTable();
viewMITable();
mantTable();
splitPane.setOnSwipeRight(null);    
  device=adb.LoopAdb(activedevice);
  adb.execConsole(start[1]+startapps[1]+start[2], outConsole, adb.b,finishapp[0], estatusbench, probarapp, bsavebech,photo);
  
  choicematerialdev.getItems().addAll(s.ConsultforUICMItem(consults[0],columnsdb[0]));
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
  cbcompatible.getItems().addAll("si","no");
  cbfilterimg.getItems().addAll("pruebas","fallas","dispositivo","otras");
  cbmante.getItems().addAll("bluetooth","material","proveedor","network","sensores","usuario");
  ObservableList<String> olistbech = FXCollections.observableArrayList(s.ConsultforUIArray(consults[9],columnsdb[8]));
  cbbench.setItems(olistbech);
  ObservableList<String> olistparams = FXCollections.observableArrayList(s.ConsultforUIArray(consults[10],columnsdb[9]));
  cbtypecomp.setItems(olistparams);
c.validateTextFile(txthdev,lblcompinfo);txthdev.addEventFilter(KeyEvent.KEY_TYPED, c.numericValidation(10));
c.validateTextFile(txtwdev,lblcompinfo);txtwdev.addEventFilter(KeyEvent.KEY_TYPED, c.numericValidation(10));
c.validateTextFile(txtbulkdev,lblcompinfo);txtbulkdev.addEventFilter(KeyEvent.KEY_TYPED, c.numericValidation(10));
c.validateTextFile(txtcolordis,lblcompinfo);txtcolordis.addEventFilter(KeyEvent.KEY_TYPED, c.numericValidation(20));
c.validateTextFile(txtcapbat,lblcompinfo);txtcapbat.addEventFilter(KeyEvent.KEY_TYPED, c.numericValidation(20));
c.validateTextFile(txtweight,lblcompinfo);txtweight.addEventFilter(KeyEvent.KEY_TYPED, c.numericValidation(10));
c.validateTextFile(result1,lblcompinfo);result1.addEventFilter(KeyEvent.KEY_TYPED, c.numericValidation(10));
c.validateTextFile(result2,lblcompinfo);result2.addEventFilter(KeyEvent.KEY_TYPED, c.numericValidation(10));
c.validateTextFile(result3,lblcompinfo);result3.addEventFilter(KeyEvent.KEY_TYPED, c.numericValidation(10));
c.validateTextFile(result4,lblcompinfo);result4.addEventFilter(KeyEvent.KEY_TYPED, c.numericValidation(10));
c.validateTextFile(result5,lblcompinfo);result5.addEventFilter(KeyEvent.KEY_TYPED, c.numericValidation(10));
  photo.addEventHandler(MouseEvent.MOUSE_CLICKED,new EventHandler<MouseEvent>() {
    @Override
    public void handle(MouseEvent event) {
        if(adb.b==1) {
      String dv=adb.returnID(devicedisp);
        int ramdom=new Random().nextInt(1000000000);
        adb.execGeneric(capturedis[0]+String.valueOf(ramdom)+capturedis[1], null, adb.b);
        adb.execGeneric(pullimg[0]+String.valueOf(ramdom)+capturedis[1]+" "+folderimg[1]+dv, null, adb.b);
        //adb.execGeneric(pullimg[0]+String.valueOf(ramdom2)+capturedis[1]+" "+folderimg[0]+device, null, adb.b)
        listimg[tpng]="file:"+folderimgA[1]+dv+"/"+String.valueOf(ramdom)+capturedis[1];
        System.out.println(listimg[tpng]);
        tpng++;
        lblimg.setText(String.valueOf(tpng));
        photo.setDisable(true);
    }
        else{}
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
  cbbench.setOnAction(new EventHandler() {

            @Override
            public void handle(Event event) {
                binitbech.setVisible(true);
            }
        });
 date=new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
 cbfilterimg.setOnAction(new EventHandler() {

            @Override
            public void handle(Event event) {
                if(cbfilterimg.getSelectionModel().getSelectedItem()=="otras" ||cbfilterimg.getSelectionModel().getSelectedItem()=="dispositivo"){
                banyimg.setVisible(true);
                }
                else{
                banyimg.setVisible(false);banyimg.setDisable(true);
                }
                
            }
        });
 cbtypecomp.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
    @Override
    public void changed(ObservableValue observable, Object oldValue, Object newValue) {
        tablechart.getItems().removeAll(datachart);
        String[] farr = new String[1000];
        String[] v=s.ConsultforUIArray("select nvalues as t from params where nparams='"+newValue.toString()+"'", "t");
            for (String v1 : v) {
                farr = v1.split(";");
            }
        ObservableList<String> ol = FXCollections.observableArrayList(farr);
        cbspecomp.setItems(ol);
    }
        });
  cbspecomp.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
    @Override
    public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                String[] val={"bd","nd"};

  tablechart.setEditable(true);
  columnaselect.setCellValueFactory(new PropertyValueFactory<>(val[0]));
  columnaselect.setCellFactory(CheckBoxTableCell.forTableColumn(columnaselect));
  columnaselect.setEditable(true);
  columnanchart.setCellValueFactory(new PropertyValueFactory<>(val[1]));

 tablechart.setItems(datachart);
   if(adb.b==1) {
      device=adb.returnID(devicedisp);
String e;
String[] arr;
        switch(cbtypecomp.getSelectionModel().getSelectedItem().toString()){
            
                        case("memoria RAM"):
                switch(cbspecomp.getSelectionModel().getSelectedItem().toString()){
                    case("512MB"):
                            arr=s.ConsultforUIArray("select id_device as t from device where ram_t like'%MB%'", "t");
                            if(arr!=null){
                                                tablechart.getItems().removeAll(datachart);
                            for (String v1 : files.RemoveNullValue2(arr)) {
                                createRowsChart(datachart,v1);
                            }
                            }
                            else{
                                tablechart.getItems().removeAll(datachart);
                            lblversus.setText("no existen dispositivos con la descripción seleccionada");
                            }
                        break;
                    case("1GB"):
                            arr=s.ConsultforUIArray("select id_device as t from device where ram_t like'%0,9%'", "t");
                            if(arr!=null){
                                                tablechart.getItems().removeAll(datachart);
                            for (String v1 : files.RemoveNullValue2(arr)) {

                                createRowsChart(datachart,v1);
                            }
                            }
                            else{
                                tablechart.getItems().removeAll(datachart);
                            lblversus.setText("no existen dispositivos con la descripción seleccionada");
                            }
                        break;
                    case("2GB"):
                            arr=s.ConsultforUIArray("select id_device as t from device where ram_t like'%1,9%'", "t");
                            if(arr!=null){
                                                tablechart.getItems().removeAll(datachart);
                            for (String v1 : files.RemoveNullValue2(arr)) {

                                createRowsChart(datachart,v1);
                            }
                            }
                            else{
                                tablechart.getItems().removeAll(datachart);
                            lblversus.setText("no existen dispositivos con la descripción seleccionada");
                            }
                        break;
                    case("3GB"):
                            arr=s.ConsultforUIArray("select id_device as t from device where ram_t like'%2,9%'", "t");
                            if(arr!=null){
                                                tablechart.getItems().removeAll(datachart);
                            for (String v1 : files.RemoveNullValue2(arr)) {

                                createRowsChart(datachart,v1);
                            }
                            }
                            else{
                                tablechart.getItems().removeAll(datachart);
                            lblversus.setText("no existen dispositivos con la descripción seleccionada");
                            }
                        break;
                }

                break;
            case("tamaño"):
                switch(cbspecomp.getSelectionModel().getSelectedItem().toString()){
                    case("3.5"):
                            arr=s.ConsultforUIArray("select id_device as t from device,display where i_dev=id_device and size_dis between 3.5 and 4.2", "t");
                            if(arr!=null){
                                                tablechart.getItems().removeAll(datachart);
                            for (String v1 : files.RemoveNullValue2(arr)) {

                                createRowsChart(datachart,v1);
                            }
                            }
                            else{
                                tablechart.getItems().removeAll(datachart);
                            lblversus.setText("no existen dispositivos con la descripción seleccionada");
                            }
                        break;
                    case("4.3"):
                            arr=s.ConsultforUIArray("select id_device as t from device,display where i_dev=id_device and size_dis between 4.3 and 4.6", "t");
                            if(arr!=null){
                                                tablechart.getItems().removeAll(datachart);
                            for (String v1 : files.RemoveNullValue2(arr)) {

                                createRowsChart(datachart,v1);
                            }
                            }
                            else{
                                tablechart.getItems().removeAll(datachart);
                            lblversus.setText("no existen dispositivos con la descripción seleccionada");
                            }
                        break;
                    case("4.7"):
                            arr=s.ConsultforUIArray("select id_device as t from device,display where i_dev=id_device and size_dis between 4.7 and 4.9","t");
                            if(arr!=null){
                                                tablechart.getItems().removeAll(datachart);
                            for (String v1 : files.RemoveNullValue2(arr)) {

                                createRowsChart(datachart,v1);
                            }
                            }
                            else{
                                tablechart.getItems().removeAll(datachart);
                            lblversus.setText("no existen dispositivos con la descripción seleccionada");
                            }
                        break;
                    case("5.0"):
                            arr=s.ConsultforUIArray("select id_device as t from device,display where i_dev=id_device and size_dis between 5.0 and 5.4","t");
                            if(arr!=null){
                                                tablechart.getItems().removeAll(datachart);
                            for (String v1 : files.RemoveNullValue2(arr)) {

                                createRowsChart(datachart,v1);
                            }
                            }
                            else{
                                tablechart.getItems().removeAll(datachart);
                            lblversus.setText("no existen dispositivos con la descripción seleccionada");
                            }
                        break;
                    case("5.5"):
                            arr=s.ConsultforUIArray("select id_device as t from device,display where i_dev=id_device and size_dis between 5.5 and 5.9","t");
                            if(arr!=null){
                                                tablechart.getItems().removeAll(datachart);
                            for (String v1 : files.RemoveNullValue2(arr)) {

                                createRowsChart(datachart,v1);
                            }
                            }
                            else{
                                tablechart.getItems().removeAll(datachart);
                            lblversus.setText("no existen dispositivos con la descripción seleccionada");
                            }     
                        break;
                }

                break;
            case("cores"):
                 switch(cbspecomp.getSelectionModel().getSelectedItem().toString()){
                     case("1"):
                            arr=s.ConsultforUIArray("select id_device as t from device,device_cpu where id_dev_cpu=id_device and id_cpu_c in(select id_cpu from cpu where core_cpu=1)","t");
                            if(arr!=null){
                                                tablechart.getItems().removeAll(datachart);
                            for (String v1 : files.RemoveNullValue2(arr)) {

                                createRowsChart(datachart,v1);
                            }
                            }
                            else{
                                tablechart.getItems().removeAll(datachart);
                            lblversus.setText("no existen dispositivos con la descripción seleccionada");
                            }     
                         break;
                     case("2"):
                         arr=s.ConsultforUIArray("select id_device as t from device,device_cpu where id_dev_cpu=id_device and id_cpu_c in(select id_cpu from cpu where core_cpu=2)","t");
                            if(arr!=null){
                                                tablechart.getItems().removeAll(datachart);
                            for (String v1 : files.RemoveNullValue2(arr)) {

                                createRowsChart(datachart,v1);
                            }
                            }
                            else{
                                tablechart.getItems().removeAll(datachart);
                            lblversus.setText("no existen dispositivos con la descripción seleccionada");
                            } 
                         break;
                     case("4"):
                         arr=s.ConsultforUIArray("select id_device as t from device,device_cpu where id_dev_cpu=id_device and id_cpu_c in(select id_cpu from cpu where core_cpu=4)","t");
                            if(arr!=null){
                                                tablechart.getItems().removeAll(datachart);
                            for (String v1 : files.RemoveNullValue2(arr)) {

                                createRowsChart(datachart,v1);
                            }
                            }
                            else{
                                tablechart.getItems().removeAll(datachart);
                            lblversus.setText("no existen dispositivos con la descripción seleccionada");
                            } 
                         break;
                     case("6"):
                         arr=s.ConsultforUIArray("select id_device as t from device,device_cpu where id_dev_cpu=id_device and id_cpu_c in(select id_cpu from cpu where core_cpu=6)","t");
                            if(arr!=null){
                                                tablechart.getItems().removeAll(datachart);
                            for (String v1 : files.RemoveNullValue2(arr)) {

                                createRowsChart(datachart,v1);
                            }
                            }
                            else{
                                tablechart.getItems().removeAll(datachart);
                            lblversus.setText("no existen dispositivos con la descripción seleccionada");
                            } 
                         break;
                     case("8"):
                         arr=s.ConsultforUIArray("select id_device as t from device,device_cpu where id_dev_cpu=id_device and id_cpu_c in(select id_cpu from cpu where core_cpu=8)","t");
                            if(arr!=null){
                                                tablechart.getItems().removeAll(datachart);
                            for (String v1 : files.RemoveNullValue2(arr)) {

                                createRowsChart(datachart,v1);
                            }
                            }
                            else{
                                tablechart.getItems().removeAll(datachart);
                            lblversus.setText("no existen dispositivos con la descripción seleccionada");
                            } 
                         break;
                 }
                break;
            case("general"):
                arr=s.ConsultforUIArray("select id_device as t from device","t");
                System.out.println("DATOSSSSSSSS: "+arr.length);
                for(String g:files.RemoveNullValue2(arr)){
                    if(!"null".equals(g)){
                    //tablechart.getItems().removeAll(datachart);
                    createRowsChart(datachart,g);
                    }
                }
                if(arr.length==0){
                    tablechart.getItems().removeAll(datachart);
                lblversus.setText("no existen dispositivos con la descripción seleccionada");
                }
                break;
        }
   }
//        String[] farr = new String[1000];
//        String[] v=s.ConsultforUIArray("select nvalues as t from params where nparams='"+newValue.toString()+"'", "t");
//            for (String v1 : v) {
//                farr = v1.split(";");
//            }
//new code
    }
        });
  cbmante.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
    @Override
    public void changed(ObservableValue observable, Object oldValue, Object newValue) {

    tablemant.setEditable(true);
  columnamant1.setCellValueFactory(new PropertyValueFactory<>("mant1"));
  columnamant2.setCellValueFactory(new PropertyValueFactory<>("mant2"));
  columnamant3.setCellValueFactory(new PropertyValueFactory<>("mant3"));
  columnamant4.setCellValueFactory(new PropertyValueFactory<>("mant4"));
  columnamant5.setCellValueFactory(new PropertyValueFactory<>("mant5"));
  tablemant.setItems(datamant);

String e;
String[] arr;
lbldesmant.setVisible(false);
        switch(cbmante.getSelectionModel().getSelectedItem().toString()){
            
                        case("bluetooth"):
                            lblinfomant.setText("");
                            arr=s.ConsultforUIArray("select type_blu as t from bluetooth", "t");
                            if(arr!=null){
                                                tablemant.getItems().removeAll(datamant);
                            for (String v1 : files.RemoveNullValue2(arr)) {
                                createRowsMant(datamant,v1,"","","","");
                            }
                            addnewmant.setVisible(true);
                            }
                            else{
                                tablemant.getItems().removeAll(datamant);
                            lblversus.setText("no existen elementos");
                            }
                        break;
                        case("material"):
                            lblinfomant.setText("");
                            arr=s.ConsultforUIArray("select name_mat as t from material", "t");
                            if(arr!=null){
                                                tablemant.getItems().removeAll(datamant);
                            for (String v1 : files.RemoveNullValue2(arr)) {
                                createRowsMant(datamant,v1,"","","","");
                            }
                            addnewmant.setVisible(true);
                            }
                            else{
                                tablemant.getItems().removeAll(datamant);
                            lblversus.setText("no existen elementos");
                            }
                        break;
                        case("proveedor"):
                            lblinfomant.setText("");
                            String[][]array=s.getBD(0, "select name_provider,contacts_provider,detail_provider from provider", new String[]{"name_provider","contacts_provider","detail_provider"});
                            if(array!=null){
                                                tablemant.getItems().removeAll(datamant);
                            for (int i=0;i<array.length;i++) {
                                
                                
                                createRowsMant(datamant,array[i][0],array[i][1],array[i][2],array[i][3],"");
                                
                                
                            }
                            addnewmant.setVisible(true);
                            }
                            else{
                                tablemant.getItems().removeAll(datamant);
                            lblversus.setText("no existen elementos");
                            }
                        break;
                        case("network"):
                            lblinfomant.setText("");
                            array=s.getBD(0, "select type_net,val_net from network", new String[]{"type_net","val_net"});
                            if(array!=null){
                                                tablemant.getItems().removeAll(datamant);
                            for (int i=0;i<array.length;i++) {
                                
                                
                                createRowsMant(datamant,array[i][0],array[i][1],"","","");
                                
                                
                            }
                            addnewmant.setVisible(true);
                            }
                            else{
                                tablemant.getItems().removeAll(datamant);
                            lblversus.setText("no existen elementos");
                            }
                        break;
                        case("sensores"):
                            lblinfomant.setText("");
                            array=s.getBD(0, "select name_sup,desc_sup,type from other_support", new String[]{"name_sup","desc_sup","type"});
                            if(array!=null){
                                                tablemant.getItems().removeAll(datamant);
                            for (int i=0;i<array.length;i++) {
                                
                                
                                createRowsMant(datamant,array[i][0],array[i][1],array[i][2],"","");
                                
                                
                            }
                            addnewmant.setVisible(true);
                            }
                            else{
                                tablemant.getItems().removeAll(datamant);
                            lblversus.setText("no existen elementos");
                            }
                        break;
                        case("usuario"):
                            lblinfomant.setText("");
                            array=s.getBD(0, "select id_user,name_user,password,permission,avatar,sesion from user", new String[]{"id_user","name_user","password","permission","avatar","sesion"});
                            if(array!=null){
                                                tablemant.getItems().removeAll(datamant);
                            for (int i=0;i<array.length;i++) {
                                
                                
                                createRowsMant(datamant,array[i][0],array[i][1],array[i][2],array[i][3],array[i][4]);
                                
                                
                            }
                            addnewmant.setVisible(true);
                            }
                            else{
                                tablemant.getItems().removeAll(datamant);
                            lblversus.setText("no existen elementos");
                            }
                        break;
            
        }
   
//        String[] farr = new String[1000];
//        String[] v=s.ConsultforUIArray("select nvalues as t from params where nparams='"+newValue.toString()+"'", "t");
//            for (String v1 : v) {
//                farr = v1.split(";");
//            }
//new code
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
          case "Button[id=bfreport, styleClass=button]'Fallas'":
            tabdash.getSelectionModel().select(tabreport);
              break;
          case "Button[id=bgreport, styleClass=button]'General'":
            tabdash.getSelectionModel().select(tabreport);
            bcontinue.setVisible(false);
              break;
              case "Button[id=bmant, styleClass=button]'General'":
            tabdash.getSelectionModel().select(tabmant);
            bcontinue.setVisible(false);
            baddfails.setVisible(false);
            badvantage.setVisible(false);
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
            
            baddfails.setDisable(false);
           String apps=files.oneString(files.RemoveNullValue2(adb.execGeneric("C:\\Users\\project\\AppData\\Local\\Android\\android-studio\\sdk\\platform-tools\\adb shell pm list package", outConsole, adb.b)));
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
                accorBenchmark.setDisable(false);
                bapp.setDisable(false);
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
                accorBenchmark.setDisable(false);
                bapp.setDisable(false);
                            s.Addelement("insert into device values ('"+device+"','"+s.name_dev+"','"+s.model_dev+"','"+s.ver_so+"','"+s.kernel_dev+"','"+s.build_dev+"','"+s.locale_dev+"','"+s.sto_ext_sd_t+"','"+s.sto_ext_sd_d+"','"+s.sto_s2sd_t+"','"+s.sto_s2sd_d+"','"+s.sto_inter_t+"','"+s.sto_inter_d+"','"+s.sto_sys_t+"','"+s.sto_sys_d+"','"+s.cache_sys_t+"','"+s.cache_sys_d+"','"+s.ram_t+"','"+s.ram_d+"','"+s.ram_l+"','"+c.values[4][0]+"','"+c.values[0][0]+"','"+c.values[1][0]+"','"+c.values[2][0]+"','"+c.values[16][0]+"',"+Integer.valueOf(blu)+","+cert+",'"+apps+"')");
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
                                    int cpu=s.ConsultforUIInt("select id_cpu as sel from cpu where name_cpu='"+s.name_cpu+"'", "sel");    

                                 s.Addelement("insert into device_cpu values ('"+device+"',"+cpu+")");
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
            if(s.ConsultforUIString("select id_device as t from device where id_device='"+device+"'", "t")==null){
            
            }else{
                baddfails.setDisable(false);
            tabdash.getSelectionModel().select(tabapp);  
            accorBenchmark.setDisable(false);
            bapp.setDisable(false);
            baddfails.setVisible(true);
            badvantage.setVisible(true);
            }

            break;
            case("tabapp"):
                
                baddfails.setDisable(false);
                baddfails.setVisible(true);
                btest.setDisable(false);
                btest.setVisible(true);
                tabdash.getSelectionModel().select(tabtest); 
                btest.setDisable(false);
            break;
            case("tabtest"):
                Boolean bol = null;
                List result=new LinkedList();
                String[] valids =new String[100];
                String[] va=s.ConsultforUIArray("select name_test as t from test", "t");
                String[]fi=va;
                 btest.setDisable(false);
            if(adb.confirmMessage("Aviso",question1[1])){
                s.generateInfoIdent(tabdash,columnitem,columndescription);
                //tabdash.getSelectionModel().select(tabcomp);
                bcomponente.setDisable(false);                         
           
                    for(int i=0;i<columnantest.getTableView().getItems().size();i++){
                      valids[i]=(String) columnantest.getCellData(i);
                    }
                    valids=new HashSet<>(Arrays.asList(valids)).toArray(new String[0]);
                    valids=files.RemoveNullValue(valids);
                    for(int y=0;y<valids.length;y++){
                            for(int x=0;x<va.length;x++){
                                if(valids[y]==null){}
                                else{
                                if(va[x].contains(valids[y])){
                                     for(int e=0;e<fi.length;e++){
                                         if(fi[e].contains(valids[y])){
                                         fi[e]="";
                                         fi=files.RemoveNullValue3(fi);
                                         }
                                     }
                                     
                                }
                                 else{
                                 
                                }
                                }
                               
                            }
                    }
                    for(String z:fi){
                        //System.out.println(z);
                    int n=s.ConsultforUIInt("select id_test as n from test where name_test='"+z+"'","n");    
                    System.out.println(n);
                    bol=s.Addelement("insert into device_test values("+n+",'"+devi+"',1,'N/A',0,0,0,0,0)");
                    }
                    accorImagenes.setDisable(false);
                    bimgdevice.setDisable(false);
                        tabdash.getSelectionModel().select(tabimage); 
                     }
                
            else{
                adb.alertMessage("Debe agregar al menos un valor");
            }
                break;
            case("tabimage"):
                String[] val={"uf","nf","df","imgf","datef"};

  tablefails.setEditable(true);
  columnafuser.setCellValueFactory(new PropertyValueFactory<>(val[0]));
  columnafname.setCellValueFactory(new PropertyValueFactory<>(val[1]));
  columnafdesc.setCellValueFactory(new PropertyValueFactory<>(val[2]));
  columnafimg.setCellValueFactory(new PropertyValueFactory<>(val[3]));
  columnafdate.setCellValueFactory(new PropertyValueFactory<>(val[4]));

  tablefails.setItems(datafail);
                 if(adb.confirmMessage("Aviso",question1[1])){
                     String[][] lfails=s.getBD(0,"select * from device_failure",new String[]{"id_fail","id_dev","name_fail","desc_fail","id_img_fail","date_fail_dev","id_user"});
for(int i=0;i<files.RemoveNullArray(lfails).length;i++){
//       for(String c:files.RemoveNullValue2(f)){
//             System.out.println(c);
////             data.add(new Device(desc[x],c));
////             x++;
//             } 
 
    createRowsFails(datafail,lfails[i][6],lfails[i][2],lfails[i][3],lfails[i][4],lfails[i][5]);
    
}
                 

tabdash.getSelectionModel().select(tabfails);  
lblinfofail.setText("a través del click derecho puede eliminar registro de falla");
accorFallas.setDisable(false);
bfails.setDisable(false);
            }
                
            else{
                adb.alertMessage("ha ocurrido un problema");
            }     
                break;
                case("tabfails"):
                    tabdash.getSelectionModel().select(tabcompare); 
                    accorVersus.setDisable(false);
                    bcompare.setDisable(false);
                break;
                case("tabcompare"):
                    tabdash.getSelectionModel().select(tabreport); 
                    baddfails.setVisible(false);
                    badvantage.setVisible(false);
                    accorReporte.setDisable(false);
                    bgreport.setDisable(false);
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
            
            
        final ContextMenu contextMenu=new ContextMenu();

            MenuItem deliItem=new MenuItem("eliminar");
            deliItem.setOnAction((ActionEvent event) -> {
                tablefails.getItems().remove(row.getItem());
                int i=s.ConsultforUIInt("select id_fail as t from device_failure where id_img_fail="+row.getItem().imgf.getValue()+" and name_fail='"+row.getItem().nf.getValue()+"' and desc_fail='"+row.getItem().df.getValue()+"'", "t");
                if(s.Addelement("delete from device_failure where id_fail="+i)){
                    if(s.Addelement("delete from image where id_image="+i)){
                    
                    }
                }
            });
            contextMenu.getItems().addAll(deliItem);
            row.contextMenuProperty().bind(
      Bindings.when(Bindings.isNotNull(row.itemProperty()))
      .then(contextMenu)
      .otherwise((ContextMenu)null));
            
            
           
            return row;
        }
    
    }
    );
    }
    public void mantTable(){
    tablemant.setRowFactory(
    new Callback<TableView<Mant>, TableRow<Mant>>(){

        @Override
        public TableRow<Mant> call(TableView<Mant> param) {
            final TableRow<Mant> row=new TableRow<>();
            row.setOnMouseClicked(new EventHandler<MouseEvent>() {

                @Override
                public void handle(MouseEvent event) {
                   
                }
            });
            
            
        final ContextMenu contextMenu=new ContextMenu();

            MenuItem deliItem=new MenuItem("eliminar");
            deliItem.setOnAction((ActionEvent event) -> {
                
                switch(cbmante.getSelectionModel().getSelectedItem().toString()){

                   case("bluetooth"):
                    // int i=s.ConsultforUIInt("select id_fail as t from device_failure where id_img_fail="+row.getItem().imgf.getValue()+" and name_fail='"+row.getItem().nf.getValue()+"' and desc_fail='"+row.getItem().df.getValue()+"'", "t");
                  if(adb.confirmMessage("Aviso",question1[3])){
                    s.Addelement("delete from bluetooth where type_blu='"+row.getItem().mant1.getValue()+"'");
                  }
                       break;
                   case("material"):
                    // int i=s.ConsultforUIInt("select id_fail as t from device_failure where id_img_fail="+row.getItem().imgf.getValue()+" and name_fail='"+row.getItem().nf.getValue()+"' and desc_fail='"+row.getItem().df.getValue()+"'", "t");
                  if(adb.confirmMessage("Aviso",question1[3])){
                    s.Addelement("delete from material where name_mat='"+row.getItem().mant1.getValue()+"'");
                  }
                       break;
                   case("proveedor"):
                    // int i=s.ConsultforUIInt("select id_fail as t from device_failure where id_img_fail="+row.getItem().imgf.getValue()+" and name_fail='"+row.getItem().nf.getValue()+"' and desc_fail='"+row.getItem().df.getValue()+"'", "t");
                  if(adb.confirmMessage("Aviso",question1[3])){
                    s.Addelement("delete from provider where name_provider='"+row.getItem().mant1.getValue()+"'");
                  }
                       break;
                   case("network"):
                    // int i=s.ConsultforUIInt("select id_fail as t from device_failure where id_img_fail="+row.getItem().imgf.getValue()+" and name_fail='"+row.getItem().nf.getValue()+"' and desc_fail='"+row.getItem().df.getValue()+"'", "t");
                  if(adb.confirmMessage("Aviso",question1[3])){
                    s.Addelement("delete from network where val_net='"+row.getItem().mant2.getValue()+"'");
                  }
                       break;
                   case("sensores"):
                    // int i=s.ConsultforUIInt("select id_fail as t from device_failure where id_img_fail="+row.getItem().imgf.getValue()+" and name_fail='"+row.getItem().nf.getValue()+"' and desc_fail='"+row.getItem().df.getValue()+"'", "t");
                  if(adb.confirmMessage("Aviso",question1[3])){
                    s.Addelement("delete from other_support where name_sup='"+row.getItem().mant1.getValue()+"'");
                  }
                       break;
                   case("usuario"):
                    // int i=s.ConsultforUIInt("select id_fail as t from device_failure where id_img_fail="+row.getItem().imgf.getValue()+" and name_fail='"+row.getItem().nf.getValue()+"' and desc_fail='"+row.getItem().df.getValue()+"'", "t");
                  if(adb.confirmMessage("Aviso",question1[3])){
                    s.Addelement("delete from user where id_user='"+row.getItem().mant1.getValue()+"'");
                  }
                       break;
                }
                tablemant.getItems().remove(row.getItem());
            });
            contextMenu.getItems().addAll(deliItem);
            row.contextMenuProperty().bind(
      Bindings.when(Bindings.isNotNull(row.itemProperty()))
      .then(contextMenu)
      .otherwise((ContextMenu)null));
            
            
           
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
          tpng=0;
         
          result1.setText("");result2.setText("");result3.setText("");result4.setText("");result5.setText("");cbcompatible.getSelectionModel().select(null);
          result1.setDisable(true);result2.setDisable(true);result3.setDisable(true);result4.setDisable(true);;result5.setDisable(true);
          cbcompatible.setDisable(true);lblr0.setDisable(true);lblr1.setDisable(true);lblr2.setDisable(true);lblr3.setDisable(true);lblr4.setDisable(true);lblr5.setDisable(true);
          bsavebech.setDisable(false);
          switch(val){
            case("antutu"):
                 photo.setDisable(false);
                result1.setDisable(true);result2.setDisable(true);result3.setDisable(true);result4.setDisable(true);;result5.setDisable(true);
                cbcompatible.setDisable(true);lblr0.setDisable(true);lblr1.setDisable(true);lblr2.setDisable(true);lblr3.setDisable(true);lblr4.setDisable(true);lblr5.setDisable(true);
                estatusbench.setText("presione TEST para iniciar la prueba");
                photo.setVisible(true);
                lblphoto.setVisible(true);
                adb.execGeneric(start[0]+startapps[1], outConsole, adb.b);
                adb.execConsole(start[1]+startapps[1]+start[2], outConsole, adb.b,finishapp[0], estatusbench, probarapp, bsavebech,photo);
                result1.setDisable(false);
                lblr1.setDisable(false);
                lblimg.setDisable(false);lblimg.setText("");
                lblcapt.setDisable(false);
                binitbech.setDisable(false);
                break;
            case("battery benchmark"):
                photo.setDisable(false);
                result1.setDisable(true);result2.setDisable(true);result3.setDisable(true);result4.setDisable(true);;result5.setDisable(true);
                cbcompatible.setDisable(true);lblr0.setDisable(true);lblr1.setDisable(true);lblr2.setDisable(true);lblr3.setDisable(true);lblr4.setDisable(true);lblr5.setDisable(true);
                estatusbench.setText("presione start bench para iniciar la prueba");
                photo.setVisible(true);
                lblphoto.setVisible(true);
                adb.execGeneric(start[0]+startapps[6], outConsole, adb.b);
                result1.setDisable(false);result2.setDisable(false);
                lblr1.setDisable(false);lblr2.setDisable(false);
                lblimg.setDisable(false);lblcapt.setDisable(false);lblimg.setText("");
                binitbech.setDisable(false);    
            break;
            case("AndEBench"):
                photo.setDisable(false);
                result1.setDisable(true);result2.setDisable(true);result3.setDisable(true);result4.setDisable(true);;result5.setDisable(true);
                cbcompatible.setDisable(true);lblr0.setDisable(true);lblr1.setDisable(true);lblr2.setDisable(true);lblr3.setDisable(true);lblr4.setDisable(true);lblr5.setDisable(true);
                estatusbench.setText("presione START para iniciar la prueba");
                photo.setVisible(true);
                lblphoto.setVisible(true);
                adb.execGeneric(start[0]+startapps[2], outConsole, adb.b);
                result1.setDisable(false);result2.setDisable(false);
                lblr1.setDisable(false);lblr2.setDisable(false);
                lblimg.setDisable(false);lblcapt.setDisable(false);lblimg.setText("");
                binitbech.setDisable(false);    
            break;
            case("3DMark"):
                photo.setDisable(false);
                result1.setDisable(true);result2.setDisable(true);result3.setDisable(true);result4.setDisable(true);;result5.setDisable(true);
                cbcompatible.setDisable(true);lblr0.setDisable(true);lblr1.setDisable(true);lblr2.setDisable(true);lblr3.setDisable(true);lblr4.setDisable(true);lblr5.setDisable(true);
                estatusbench.setText("presione RUN para iniciar la prueba");
                photo.setVisible(true);
                lblphoto.setVisible(true);
                adb.execGeneric(start[0]+startapps[5], outConsole, adb.b);
                result1.setDisable(false);
                lblr1.setDisable(false);
                lblimg.setDisable(false);lblcapt.setDisable(false);lblimg.setText("");
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
                photo.setDisable(false);
                result1.setDisable(true);result2.setDisable(true);result3.setDisable(true);result4.setDisable(true);;result5.setDisable(true);
                cbcompatible.setDisable(true);lblr0.setDisable(true);lblr1.setDisable(true);lblr2.setDisable(true);lblr3.setDisable(true);lblr4.setDisable(true);lblr5.setDisable(true);
                estatusbench.setText("presione RUN BENCHMARKS para iniciar la prueba");
                photo.setVisible(true);
                lblphoto.setVisible(true);
                adb.execGeneric(start[0]+startapps[7], outConsole, adb.b);
                result1.setDisable(false);result2.setDisable(false);
                lblr1.setDisable(false);lblr2.setDisable(false);
                lblimg.setDisable(false);lblcapt.setDisable(false);lblimg.setText("");
                binitbech.setDisable(false);
                adb.execConsole(start[1]+startapps[1]+start[2], outConsole, adb.b,finishapp[3], estatusbench, probarapp, bsavebech,photo);                

            break;
            case("Vellamo"):
                photo.setDisable(false);
                result1.setDisable(true);result2.setDisable(true);result3.setDisable(true);result4.setDisable(true);;result5.setDisable(true);
                cbcompatible.setDisable(true);lblr0.setDisable(true);lblr1.setDisable(true);lblr2.setDisable(true);lblr3.setDisable(true);lblr4.setDisable(true);lblr5.setDisable(true);
                estatusbench.setText("presione start para iniciar la prueba");
                photo.setVisible(true);
                lblphoto.setVisible(true);
                adb.execGeneric(start[0]+startapps[3], outConsole, adb.b);
                result1.setDisable(false);result2.setDisable(false);result3.setDisable(false);
                lblr1.setDisable(false);lblr2.setDisable(false);lblr3.setDisable(false);
                lblimg.setDisable(false);lblcapt.setDisable(false);lblimg.setText("");
                binitbech.setDisable(false); 
                adb.execConsole(start[1]+startapps[1]+start[2], outConsole, adb.b,finishapp[1], estatusbench, probarapp, bsavebech,photo);                

            break;
            case("Basemark X"):
                photo.setDisable(false);
                result1.setDisable(true);result2.setDisable(true);result3.setDisable(true);result4.setDisable(true);;result5.setDisable(true);
                cbcompatible.setDisable(true);lblr0.setDisable(true);lblr1.setDisable(true);lblr2.setDisable(true);lblr3.setDisable(true);lblr4.setDisable(true);lblr5.setDisable(true);
                estatusbench.setText("presione start para iniciar la prueba");
                photo.setVisible(true);
                lblphoto.setVisible(true);
                adb.execGeneric(start[0]+startapps[9], outConsole, adb.b);
                result1.setDisable(false);result2.setDisable(false);
                lblr1.setDisable(false);lblr2.setDisable(false);
                lblimg.setDisable(false);lblcapt.setDisable(false);lblimg.setText("");
                binitbech.setDisable(false);    
            break;
            case("Basemark OS II"):
                photo.setDisable(false);
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
                lblimg.setDisable(false);lblcapt.setDisable(false);lblimg.setText("");
                binitbech.setDisable(false);    
            break;
            case("Display Tester"):
                photo.setDisable(false);
                result1.setDisable(true);result2.setDisable(true);result3.setDisable(true);result4.setDisable(true);;result5.setDisable(true);
                cbcompatible.setDisable(true);lblr0.setDisable(true);lblr1.setDisable(true);lblr2.setDisable(true);lblr3.setDisable(true);lblr4.setDisable(true);lblr5.setDisable(true);
                estatusbench.setText("presione start para iniciar la prueba");
                photo.setVisible(true);
                lblphoto.setVisible(true);
                adb.execGeneric(start[0]+startapps[2], outConsole, adb.b);
                result1.setDisable(false);result2.setDisable(false);
                lblr1.setDisable(false);lblr2.setDisable(false);
                lblimg.setDisable(false);lblcapt.setDisable(false);lblimg.setText("");
                binitbech.setDisable(false);    
            break;
            case("twitter"):
                photo.setDisable(false);
                photo.setDisable(false);
                result1.setDisable(true);result2.setDisable(true);result3.setDisable(true);result4.setDisable(true);;result5.setDisable(true);
                cbcompatible.setDisable(true);lblr0.setDisable(true);lblr1.setDisable(true);lblr2.setDisable(true);lblr3.setDisable(true);lblr4.setDisable(true);lblr5.setDisable(true);
                estatusbench.setText("inicie sesion y pruebe la aplicación");
                photo.setVisible(true);
                lblphoto.setVisible(true);
                adb.execGeneric(start[0]+startapps[10], outConsole, adb.b);
                cbcompatible.setDisable(false);lblr0.setDisable(false);
                lblimg.setText("");
                break;
            case("instagram"):
                photo.setDisable(false);
                result1.setDisable(true);result2.setDisable(true);result3.setDisable(true);result4.setDisable(true);;result5.setDisable(true);
                cbcompatible.setDisable(true);lblr0.setDisable(true);lblr1.setDisable(true);lblr2.setDisable(true);lblr3.setDisable(true);lblr4.setDisable(true);lblr5.setDisable(true);
                estatusbench.setText("inicie sesion y pruebe la aplicación");
                photo.setVisible(true);
                lblphoto.setVisible(true);
                adb.execGeneric(start[0]+startapps[11], outConsole, adb.b);
                cbcompatible.setDisable(false);lblr0.setDisable(false);
                lblimg.setText("");
                break;
            case("facebook"):
                photo.setDisable(false);
                result1.setDisable(true);result2.setDisable(true);result3.setDisable(true);result4.setDisable(true);;result5.setDisable(true);
                cbcompatible.setDisable(true);lblr0.setDisable(true);lblr1.setDisable(true);lblr2.setDisable(true);lblr3.setDisable(true);lblr4.setDisable(true);lblr5.setDisable(true);
                estatusbench.setText("inicie sesion y pruebe la aplicación");
                photo.setVisible(true);
                lblphoto.setVisible(true);
                adb.execGeneric(start[0]+startapps[12], outConsole, adb.b);
                cbcompatible.setDisable(false);lblr0.setDisable(false);
                lblimg.setText("");
                break;
            case("whatsapp"):
                photo.setDisable(false);
                result1.setDisable(true);result2.setDisable(true);result3.setDisable(true);result4.setDisable(true);;result5.setDisable(true);
                cbcompatible.setDisable(true);lblr0.setDisable(true);lblr1.setDisable(true);lblr2.setDisable(true);lblr3.setDisable(true);lblr4.setDisable(true);lblr5.setDisable(true);
                estatusbench.setText("inicie sesion y pruebe la aplicación");
                photo.setVisible(true);
                lblphoto.setVisible(true);
                adb.execGeneric(start[0]+startapps[13], outConsole, adb.b);
                cbcompatible.setDisable(false);lblr0.setDisable(false);
                lblimg.setText("");
                break;
            case("skype"):
                photo.setDisable(false);
                result1.setDisable(true);result2.setDisable(true);result3.setDisable(true);result4.setDisable(true);;result5.setDisable(true);
                cbcompatible.setDisable(true);lblr0.setDisable(true);lblr1.setDisable(true);lblr2.setDisable(true);lblr3.setDisable(true);lblr4.setDisable(true);lblr5.setDisable(true);
                estatusbench.setText("inicie sesion y pruebe la aplicación");
                photo.setVisible(true);
                lblphoto.setVisible(true);
                adb.execGeneric(start[0]+startapps[14], outConsole, adb.b);
                cbcompatible.setDisable(false);lblr0.setDisable(false);
                lblimg.setText("");
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
         if(adb.b==1){
  devi=adb.returnID(devicedisp);
  bcontinue.setDisable(false);
  tabletest.setEditable(true);
  columnantest.setCellValueFactory(new PropertyValueFactory<>("nt"));
  columnartest.setCellValueFactory(new PropertyValueFactory<>("rt"));
  columnaitest.setCellValueFactory(new PropertyValueFactory<>("it"));
  columnaitest1.setCellValueFactory(new PropertyValueFactory<>("it1"));
  columnaitest2.setCellValueFactory(new PropertyValueFactory<>("it2"));
  columnaitest3.setCellValueFactory(new PropertyValueFactory<>("it3"));
  columnaitest4.setCellValueFactory(new PropertyValueFactory<>("it4"));
  tabletest.setItems(dataBench);
  String cb=files.getValueCb(cbbench);
  
  int n=s.ConsultforUIInt("select id_test as n from test where name_test='"+cb+"'","n");
  String[] sfortest=new String[10];
  sfortest[0]=result1.getText();sfortest[1]=result2.getText();sfortest[2]=result3.getText();sfortest[3]=result4.getText();sfortest[4]=result5.getText();
  int vimg=s.ConsultforUIInt("select count(id_image) as t from image", "t");
  bsavebech.setDisable(false);
  switch(cb){      
            case("antutu"):
                if(!result1.getText().equals("")&&!lblimg.getText().equals("")){
               // System.out.println(devi+" HOLAAAAAAAAAAAAAAAAAAAAAAAAAA");
                    for(String str:files.RemoveNullValue2(listimg)){
                        vimg++;
                               s.Addelement("insert into image values("+vimg+",'"+devi+"','test','"+date+"','"+str+"')");
                               if(s.Addelement("insert into device_test values("+n+",'"+devi+"',"+vimg+",'N/A',"+sfortest[0]+",0,0,0,0)")){
                               estatusbench.setText("Se han guardado los datos correctamente");   
                               createRowsBench(dataBench,cb,str,sfortest[0],"N/A","N/A","N/A","N/A");
                               result1.setText("");result2.setText("");result3.setText("");result4.setText("");result5.setText("");cbcompatible.getSelectionModel().select(null);
                               result1.setDisable(true);result2.setDisable(true);result3.setDisable(true);result4.setDisable(true);;result5.setDisable(true);
                               cbcompatible.setDisable(true);lblr0.setDisable(true);lblr1.setDisable(true);lblr2.setDisable(true);lblr3.setDisable(true);lblr4.setDisable(true);lblr5.setDisable(true);
                               lblcapt.setDisable(true);lblimg.setDisable(true);lblimg.setText("");bsavebech.setDisable(true);photo.setVisible(false);lblphoto.setVisible(false);
                                 ObservableList<String> olistbech = FXCollections.observableArrayList(s.ConsultforUIArray("select name_test from test where name_test!='"+cb+"'",columnsdb[8]));
                                 cbbench.setItems(olistbech);
                               }          
                    }            
                } 
                else{
                    adb.alertMessage(mesagges[6]);
                }
                
                //createRowsBench(dataBench,cb,result1.getText(),files.oneString(listimg));
                break;
            case("battery benchmark"):
                for(String str:files.RemoveNullValue2(listimg)){
                    vimg++;
                           s.Addelement("insert into image values("+vimg+",'"+devi+"','test','"+date+"','"+str+"')");
                           if(s.Addelement("insert into device_test values("+n+",'"+devi+"',"+vimg+",'N/A',"+sfortest[0]+","+sfortest[1]+",0,0,0)")){
                           estatusbench.setText("Se han guardado los datos correctamente");
                           createRowsBench(dataBench,cb,str,sfortest[0],sfortest[1],"N/A","N/A","N/A");
                           result1.setText("");result2.setText("");result3.setText("");result4.setText("");result5.setText("");cbcompatible.getSelectionModel().select(null);
                           result1.setDisable(true);result2.setDisable(true);result3.setDisable(true);result4.setDisable(true);;result5.setDisable(true);
                           cbcompatible.setDisable(true);lblr0.setDisable(true);lblr1.setDisable(true);lblr2.setDisable(true);lblr3.setDisable(true);lblr4.setDisable(true);lblr5.setDisable(true);
                           lblcapt.setDisable(true);lblimg.setDisable(true);lblimg.setText("");bsavebech.setDisable(true);photo.setVisible(false);lblphoto.setVisible(false);
                           }
                }
                break;
            case("AndEBench"):
                for(String str:files.RemoveNullValue2(listimg)){
                    vimg++;
                           s.Addelement("insert into image values("+vimg+",'"+devi+"','test','"+date+"','"+str+"')");
                           if(s.Addelement("insert into device_test values("+n+",'"+devi+"',"+vimg+",'N/A',"+sfortest[0]+","+sfortest[1]+",0,0,0)")){
                           estatusbench.setText("Se han guardado los datos correctamente");
                           createRowsBench(dataBench,cb,str,sfortest[0],sfortest[1],"N/A","N/A","N/A");
                           result1.setText("");result2.setText("");result3.setText("");result4.setText("");result5.setText("");cbcompatible.getSelectionModel().select(null);
                           result1.setDisable(true);result2.setDisable(true);result3.setDisable(true);result4.setDisable(true);;result5.setDisable(true);
                           cbcompatible.setDisable(true);lblr0.setDisable(true);lblr1.setDisable(true);lblr2.setDisable(true);lblr3.setDisable(true);lblr4.setDisable(true);lblr5.setDisable(true);
                           lblcapt.setDisable(true);lblimg.setDisable(true);lblimg.setText("");bsavebech.setDisable(true);photo.setVisible(false);lblphoto.setVisible(false);
                           }
                }
                break;
            case("3DMark"):
                for(String str:files.RemoveNullValue2(listimg)){
                    vimg++;
                           s.Addelement("insert into image values("+vimg+",'"+devi+"','test','"+date+"','"+str+"')");
                           if(s.Addelement("insert into device_test values("+n+",'"+devi+"',"+vimg+",'N/A',"+sfortest[0]+",0,0,0,0)")){
                           estatusbench.setText("Se han guardado los datos correctamente");
                           createRowsBench(dataBench,cb,str,sfortest[0],"N/A","N/A","N/A","N/A");
                           result1.setText("");result2.setText("");result3.setText("");result4.setText("");result5.setText("");cbcompatible.getSelectionModel().select(null);
                           result1.setDisable(true);result2.setDisable(true);result3.setDisable(true);result4.setDisable(true);;result5.setDisable(true);
                           cbcompatible.setDisable(true);lblr0.setDisable(true);lblr1.setDisable(true);lblr2.setDisable(true);lblr3.setDisable(true);lblr4.setDisable(true);lblr5.setDisable(true);
                           lblcapt.setDisable(true);lblimg.setDisable(true);lblimg.setText("");bsavebech.setDisable(true);photo.setVisible(false);lblphoto.setVisible(false);
                           }
                }
                break;
            case("Geekbench"):
                for(String str:files.RemoveNullValue2(listimg)){
                    vimg++;
                           s.Addelement("insert into image values("+vimg+",'"+devi+"','test','"+date+"','"+str+"')");
                           if(s.Addelement("insert into device_test values("+n+",'"+devi+"',"+vimg+",'N/A',"+sfortest[0]+","+sfortest[1]+",0,0,0)")){
                           estatusbench.setText("Se han guardado los datos correctamente");
                           createRowsBench(dataBench,cb,str,sfortest[0],sfortest[1],"N/A","N/A","N/A");
                           result1.setText("");result2.setText("");result3.setText("");result4.setText("");result5.setText("");cbcompatible.getSelectionModel().select(null);
                           result1.setDisable(true);result2.setDisable(true);result3.setDisable(true);result4.setDisable(true);;result5.setDisable(true);
                           cbcompatible.setDisable(true);lblr0.setDisable(true);lblr1.setDisable(true);lblr2.setDisable(true);lblr3.setDisable(true);lblr4.setDisable(true);lblr5.setDisable(true);
                           lblcapt.setDisable(true);lblimg.setDisable(true);lblimg.setText("");bsavebech.setDisable(true);photo.setVisible(false);lblphoto.setVisible(false);
                           }
                }
                break;
            case("Vellamo"):
                for(String str:files.RemoveNullValue2(listimg)){
                    vimg++;
                           s.Addelement("insert into image values("+vimg+",'"+devi+"','test','"+date+"','"+str+"')");
                           if(s.Addelement("insert into device_test values("+n+",'"+devi+"',"+vimg+",'N/A',"+sfortest[0]+","+sfortest[1]+","+sfortest[2]+",0,0)")){
                           estatusbench.setText("Se han guardado los datos correctamente");
                           createRowsBench(dataBench,cb,str,sfortest[0],sfortest[1],sfortest[2],"N/A","N/A");
                           result1.setText("");result2.setText("");result3.setText("");result4.setText("");result5.setText("");cbcompatible.getSelectionModel().select(null);
                           result1.setDisable(true);result2.setDisable(true);result3.setDisable(true);result4.setDisable(true);;result5.setDisable(true);
                               cbcompatible.setDisable(true);lblr0.setDisable(true);lblr1.setDisable(true);lblr2.setDisable(true);lblr3.setDisable(true);lblr4.setDisable(true);lblr5.setDisable(true);
                           lblcapt.setDisable(true);lblimg.setDisable(true);lblimg.setText("");bsavebech.setDisable(true);photo.setVisible(false);lblphoto.setVisible(false);
                           }
                }
                break;
            case("Basemark X"):
                for(String str:files.RemoveNullValue2(listimg)){
                    vimg++;
                           s.Addelement("insert into image values("+vimg+",'"+devi+"','test','"+date+"','"+str+"')");
                           if(s.Addelement("insert into device_test values("+n+",'"+devi+"',"+vimg+",'N/A',"+sfortest[0]+","+sfortest[1]+",0,0,0)")){
                           estatusbench.setText("Se han guardado los datos correctamente");
                           createRowsBench(dataBench,cb,str,sfortest[0],sfortest[1],"N/A","N/A","N/A");
                           result1.setText("");result2.setText("");result3.setText("");result4.setText("");result5.setText("");cbcompatible.getSelectionModel().select(null);
                           result1.setDisable(true);result2.setDisable(true);result3.setDisable(true);result4.setDisable(true);;result5.setDisable(true);
                               cbcompatible.setDisable(true);lblr0.setDisable(true);lblr1.setDisable(true);lblr2.setDisable(true);lblr3.setDisable(true);lblr4.setDisable(true);lblr5.setDisable(true);
                           lblcapt.setDisable(true);lblimg.setDisable(true);lblimg.setText("");bsavebech.setDisable(true);photo.setVisible(false);lblphoto.setVisible(false);
                           }
                }
                break;
            case("Basemark OS II"):
                for(String str:files.RemoveNullValue2(listimg)){
                    vimg++;
                           s.Addelement("insert into image values("+vimg+",'"+devi+"','test','"+date+"','"+str+"')");
                           if(s.Addelement("insert into device_test values("+n+",'"+devi+"',"+vimg+",'N/A',"+sfortest[0]+","+sfortest[1]+","+sfortest[2]+","+sfortest[3]+","+sfortest[4]+")")){
                           estatusbench.setText("Se han guardado los datos correctamente");
                           createRowsBench(dataBench,cb,str,sfortest[0],sfortest[1],sfortest[2],sfortest[3],sfortest[4]);
                           result1.setText("");result2.setText("");result3.setText("");result4.setText("");result5.setText("");cbcompatible.getSelectionModel().select(null);
                           result1.setDisable(true);result2.setDisable(true);result3.setDisable(true);result4.setDisable(true);;result5.setDisable(true);
                               cbcompatible.setDisable(true);lblr0.setDisable(true);lblr1.setDisable(true);lblr2.setDisable(true);lblr3.setDisable(true);lblr4.setDisable(true);lblr5.setDisable(true);
                           lblcapt.setDisable(true);lblimg.setDisable(true);lblimg.setText("");bsavebech.setDisable(true);photo.setVisible(false);lblphoto.setVisible(false);
                           }
                }
                break;
            case("Display Tester"):
                for(String str:files.RemoveNullValue2(listimg)){
                    vimg++;
                           s.Addelement("insert into image values("+vimg+",'"+devi+"','test','"+date+"','"+str+"')");
                           if(s.Addelement("insert into device_test values("+n+",'"+devi+"',"+vimg+",'N/A',"+sfortest[0]+","+sfortest[1]+",0,0,0)")){
                           estatusbench.setText("Se han guardado los datos correctamente");
                           createRowsBench(dataBench,cb,str,sfortest[0],sfortest[1],"N/A","N/A","N/A");
                           result1.setText("");result2.setText("");result3.setText("");result4.setText("");result5.setText("");cbcompatible.getSelectionModel().select(null);
                           result1.setDisable(true);result2.setDisable(true);result3.setDisable(true);result4.setDisable(true);;result5.setDisable(true);
                               cbcompatible.setDisable(true);lblr0.setDisable(true);lblr1.setDisable(true);lblr2.setDisable(true);lblr3.setDisable(true);lblr4.setDisable(true);lblr5.setDisable(true);
                           lblcapt.setDisable(true);lblimg.setDisable(true);lblimg.setText("");bsavebech.setDisable(true);photo.setVisible(false);lblphoto.setVisible(false);
                           }
                }
                break;
            case("twitter"):
                String comp=files.getValueCb(cbcompatible);
                for(String str:files.RemoveNullValue2(listimg)){
                    vimg++;
                           s.Addelement("insert into image values("+vimg+",'"+devi+"','test','"+date+"','"+str+"')");
                           if(s.Addelement("insert into device_test values("+n+",'"+devi+"',"+vimg+",'"+comp+"',0,0,0,0,0)")){
                           estatusbench.setText("Se han guardado los datos correctamente");
                           createRowsBench(dataBench,cb,str,sfortest[0],"N/A","N/A","N/A","N/A");
                           result1.setText("");result2.setText("");result3.setText("");result4.setText("");result5.setText("");cbcompatible.getSelectionModel().select(null);
                           result1.setDisable(true);result2.setDisable(true);result3.setDisable(true);result4.setDisable(true);;result5.setDisable(true);
                               cbcompatible.setDisable(true);lblr0.setDisable(true);lblr1.setDisable(true);lblr2.setDisable(true);lblr3.setDisable(true);lblr4.setDisable(true);lblr5.setDisable(true);
                           lblcapt.setDisable(true);lblimg.setDisable(true);lblimg.setText("");bsavebech.setDisable(true);photo.setVisible(false);lblphoto.setVisible(false);
                           }
                }
                break;
            case("instagram"):
                comp=files.getValueCb(cbcompatible);
                for(String str:files.RemoveNullValue2(listimg)){
                    vimg++;
                           s.Addelement("insert into image values("+vimg+",'"+devi+"','test','"+date+"','"+str+"')");
                           if(s.Addelement("insert into device_test values("+n+",'"+devi+"',"+vimg+",'"+comp+"',0,0,0,0,0)")){
                           estatusbench.setText("Se han guardado los datos correctamente");
                           createRowsBench(dataBench,cb,str,"N/A","N/A","N/A","N/A","N/A");
                           result1.setText("");result2.setText("");result3.setText("");result4.setText("");result5.setText("");cbcompatible.getSelectionModel().select(null);
                           result1.setDisable(true);result2.setDisable(true);result3.setDisable(true);result4.setDisable(true);;result5.setDisable(true);
                               cbcompatible.setDisable(true);lblr0.setDisable(true);lblr1.setDisable(true);lblr2.setDisable(true);lblr3.setDisable(true);lblr4.setDisable(true);lblr5.setDisable(true);
                           lblcapt.setDisable(true);lblimg.setDisable(true);lblimg.setText("");bsavebech.setDisable(true);photo.setVisible(false);lblphoto.setVisible(false);
                           }
                }
                break;
            case("facebook"):
                comp=files.getValueCb(cbcompatible);
                for(String str:files.RemoveNullValue2(listimg)){
                    vimg++;
                           s.Addelement("insert into image values("+vimg+",'"+devi+"','test','"+date+"','"+str+"')");
                           if(s.Addelement("insert into device_test values("+n+",'"+devi+"',"+vimg+",'"+comp+"',0,0,0,0,0)")){
                           estatusbench.setText("Se han guardado los datos correctamente");
                           createRowsBench(dataBench,cb,str,"N/A","N/A","N/A","N/A","N/A");
                           result1.setText("");result2.setText("");result3.setText("");result4.setText("");result5.setText("");cbcompatible.getSelectionModel().select(null);
                           result1.setDisable(true);result2.setDisable(true);result3.setDisable(true);result4.setDisable(true);;result5.setDisable(true);
                               cbcompatible.setDisable(true);lblr0.setDisable(true);lblr1.setDisable(true);lblr2.setDisable(true);lblr3.setDisable(true);lblr4.setDisable(true);lblr5.setDisable(true);
                           lblcapt.setDisable(true);lblimg.setDisable(true);lblimg.setText("");bsavebech.setDisable(true);photo.setVisible(false);lblphoto.setVisible(false);
                           }
                }
                break;
            case("whatsapp"):
                comp=files.getValueCb(cbcompatible);
                for(String str:files.RemoveNullValue2(listimg)){
                    vimg++;
                           s.Addelement("insert into image values("+vimg+",'"+devi+"','test','"+date+"','"+str+"')");
                           if(s.Addelement("insert into device_test values("+n+",'"+devi+"',"+vimg+",'"+comp+"',0,0,0,0,0)")){
                           estatusbench.setText("Se han guardado los datos correctamente");
                           createRowsBench(dataBench,cb,str,"N/A","N/A","N/A","N/A","N/A");
                           result1.setText("");result2.setText("");result3.setText("");result4.setText("");result5.setText("");cbcompatible.getSelectionModel().select(null);
                           result1.setDisable(true);result2.setDisable(true);result3.setDisable(true);result4.setDisable(true);;result5.setDisable(true);
                               cbcompatible.setDisable(true);lblr0.setDisable(true);lblr1.setDisable(true);lblr2.setDisable(true);lblr3.setDisable(true);lblr4.setDisable(true);lblr5.setDisable(true);
                           lblcapt.setDisable(true);lblimg.setDisable(true);lblimg.setText("");bsavebech.setDisable(true);photo.setVisible(false);lblphoto.setVisible(false);
                           }
                }
                break;
            case("skype"):
                comp=files.getValueCb(cbcompatible);
                for(String str:files.RemoveNullValue2(listimg)){
                    vimg++;
                           s.Addelement("insert into image values("+vimg+",'"+devi+"','test','"+date+"','"+str+"')");
                           if(s.Addelement("insert into device_test values("+n+",'"+devi+"',"+vimg+",'"+comp+"',0,0,0,0,0)")){
                           estatusbench.setText("Se han guardado los datos correctamente");
                           createRowsBench(dataBench,cb,str,"N/A","N/A","N/A","N/A","N/A");
                           result1.setText("");result2.setText("");result3.setText("");result4.setText("");result5.setText("");cbcompatible.getSelectionModel().select(null);cbbench.getSelectionModel().select(null);
                           result1.setDisable(true);result2.setDisable(true);result3.setDisable(true);result4.setDisable(true);;result5.setDisable(true);
                               cbcompatible.setDisable(true);lblr0.setDisable(true);lblr1.setDisable(true);lblr2.setDisable(true);lblr3.setDisable(true);lblr4.setDisable(true);lblr5.setDisable(true);
                           lblcapt.setDisable(true);lblimg.setDisable(true);lblimg.setText("");bsavebech.setDisable(true);photo.setVisible(false);lblphoto.setVisible(false);
                           }
                }
                break;
            
        }
        

}
         else{
    adb.alertMessage(mesagges[0]);
}
    }
    public void Img(String path, String consult){
        
         ImageView imageView = null;
        File folder=new File(path);
        if(folder.exists()){
        File[] listFiles=folder.listFiles();
       
         if(adb.b==1) {
      device=adb.returnID(devicedisp);
        if(listFiles.length>1){
            
            tilePane.getChildren().clear();
            lblmsjimg.setText("presione doble click izquierdo para ampliar la imagen");
        for(int f=0;f<listFiles.length;f++){
            System.out.println(listFiles[f].getName());
if(cbfilterimg.getSelectionModel().getSelectedItem()=="dispositivo"){
    if(s.Consultation(consult+listFiles[f].getName()+"'")!=0){
                try {
                    imageView=createImageView(listFiles[f],"mspaint "+listFiles[f]);
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(DashboardController.class.getName()).log(Level.SEVERE, null, ex);
                }
            tilePane.getChildren().addAll(imageView);
        }
            else{}
}
else{
    if(cbfilterimg.getSelectionModel().getSelectedItem()=="otras"){
    if(s.Consultation(consult+listFiles[f].getName()+"'")!=0){
                try {
                    imageView=createImageView(listFiles[f],"mspaint "+listFiles[f]);
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(DashboardController.class.getName()).log(Level.SEVERE, null, ex);
                }
            tilePane.getChildren().addAll(imageView);
        }
            else{}
}
    else{
            if(s.Consultation(consult+listFiles[f].getName()+"')")!=0){
                try {
                    imageView=createImageView(listFiles[f],"mspaint "+listFiles[f]);
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(DashboardController.class.getName()).log(Level.SEVERE, null, ex);
                }
            tilePane.getChildren().addAll(imageView);
        } 
            else{
 
            }
    }
    
        }
        }

        }
        else{
            tilePane.getChildren().clear();
        lblmsjimg.setText("no hay imagenes disponibles");
        }
    }
            else{
    adb.alertMessage(mesagges[0]);
    }
        }
                else{
    adb.alertMessage("no existe directorio válido para el dispositivo");
    }
    }
    private ImageView createImageView(final File imageFile,String sentence) throws FileNotFoundException{
        // DEFAULT_THUMBNAIL_WIDTH is a constant you need to define
        // The last two arguments are: preserveRatio, and use smooth (slower)
        // resizing
        FileInputStream fileInputStream = new FileInputStream(imageFile);
  Stage newStage = new Stage();
  Image image = null;
  ImageView imageView1=new ImageView();
  BorderPane borderPane = new BorderPane();
  Scene scene1=new Scene(borderPane,Color.WHITE);
                             
                            newStage.setScene(scene1);
                            newStage.initModality(Modality.WINDOW_MODAL);
  Button edit=new Button("Editar");
  edit.setStyle("    -fx-background-color:\n" +
"        #FF9640;\n" +
"    -fx-font-family: \"Síragon\";\n" +
"    -fx-text-fill: white;\n" +
"    -fx-font-size: 14;");
  
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
                            BorderPane.setAlignment(imageView1, Pos.CENTER);
                            borderPane.setTop(edit);
                            edit.setOnAction(new EventHandler<ActionEvent>() {

                                @Override
                                public void handle(ActionEvent event) {
                                    adb.execCmd(null, sentence);
                                newStage.close();
                                }
                            });
                            BorderPane.setAlignment(edit, Pos.CENTER);
                            borderPane.setStyle("-fx-background-color: null");  
                            newStage.setWidth(application.stage.getWidth());
                            newStage.setHeight(application.stage.getHeight());
                            newStage.setTitle(imageFile.getName());

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
           
//                if (mouseEvent.getButton().equals(MouseButton.SECONDARY)) {
//            if (mouseEvent.getClickCount() == 2) {
//                
//                listdelimg[z]=imageFile.getAbsolutePath();
//                imageFile.deleteOnExit();
//                tilePane.getChildren().remove(imageView);
//                
//                
//               z++;
//
//            }
//                    
//                }
            
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
        if(adb.b==1) {
            banyimg.setDisable(false);
      String devic=adb.returnID(devicedisp);
        switch(files.getValueCb(cbfilterimg)){
            case("pruebas"):
                Img("C:\\application\\img\\test\\"+devic,"select id_img_test from device_test where id_img_test=(select id_image from image where type_img='test' and file_img like'%");
            break;
            case("fallas"):
                Img("C:\\application\\img\\fails\\"+devic,"select id_img_fail as t from device_failure where id_img_fail=(select id_image from image where type_img='falla' and file_img like'%");
            break;
            case("dispositivo"):
                Img("C:\\application\\img\\device\\"+devic,"select id_image from image where type_img='dispositivo' and file_img like'%");
            break;
            case("otras"):
                Img("C:\\application\\img\\others\\"+devic,"select id_image from image where type_img='otras' and file_img like'%");
            break;    

        }
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
        imgc="";
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
        actioncapinmg.disabledProperty().set(newValue.trim().isEmpty());
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
    lblimgfail.setText("");
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
       List<XYChart.Series<String, Number>> obs = FXCollections.observableArrayList();
      List<XYChart.Series<String, Number>> seriesList = new ArrayList<>();
     Series<String, Number> ser = new Series<>();
     String[] valuesarr={"id_dev_test","id_test_test","result_test1","result_test2","result_test3","result_test4","result_test5"};
     
            GenerateChart(barChart,xAxis,yAxis,GenerateGraphicsData(obs,seriesList,ser,"select id_dev_test,id_test_test,result_test1,result_test2,result_test3,result_test4,result_test5 from device_test where id_test_test=1 and id_dev_test in(select id_device from device where id_device='","",2,valuesarr), "Antutu Benchmark", "Dispositivos", "Resultados");
            GenerateChart(barChart3,xAxis,yAxis,GenerateGraphicsData(obs,seriesList,ser,"select id_dev_test,id_test_test,result_test1,result_test2,result_test3,result_test4,result_test5 from device_test where id_test_test=4 and id_dev_test in(select id_device from device where id_device='","",2,valuesarr), "3DMark Benchmark", "Dispositivos", "Resultados");
            GenerateChart(barChart4,xAxis,yAxis,GenerateGraphicsData(obs,seriesList,ser,"select id_dev_test,id_test_test,result_test1,result_test2,result_test3,result_test4,result_test5 from device_test where id_test_test=5 and id_dev_test in(select id_device from device where id_device='","",2,valuesarr), "Geekbench (SINGLE-CORE) Benchmark", "Dispositivos", "Resultados");
            GenerateChart(barChart5,xAxis,yAxis,GenerateGraphicsData(obs,seriesList,ser,"select id_dev_test,id_test_test,result_test1,result_test2,result_test3,result_test4,result_test5 from device_test where id_test_test=5 and id_dev_test in(select id_device from device where id_device='","",3,valuesarr), "Geekbench (MULTI-CORE)", "Dispositivos", "Resultados");
            GenerateChart(barChart6,xAxis,yAxis,GenerateGraphicsData(obs,seriesList,ser,"select id_dev_test,id_test_test,result_test1,result_test2,result_test3,result_test4,result_test5 from device_test where id_test_test=6 and id_dev_test in(select id_device from device where id_device='","",2,valuesarr), "Vellamo (BROWSER)Benchmark", "Dispositivos", "Resultados");
            GenerateChart(barChart7,xAxis,yAxis,GenerateGraphicsData(obs,seriesList,ser,"select id_dev_test,id_test_test,result_test1,result_test2,result_test3,result_test4,result_test5 from device_test where id_test_test=6 and id_dev_test in(select id_device from device where id_device='","",3,valuesarr), "Vellamo (MULTICORE)Benchmark", "Dispositivos", "Resultados");
            GenerateChart(barChart8,xAxis,yAxis,GenerateGraphicsData(obs,seriesList,ser,"select id_dev_test,id_test_test,result_test1,result_test2,result_test3,result_test4,result_test5 from device_test where id_test_test=6 and id_dev_test in(select id_device from device where id_device='","",4,valuesarr), "Vellamo (METAL)Benchmark", "Dispositivos", "Resultados");
            GenerateChart(barChart9,xAxis,yAxis,GenerateGraphicsData(obs,seriesList,ser,"select id_device,ram_t from device where id_device=('","memoria",1,new String[]{"id_device","ram_t"}), "Memoria RAM", "Dispositivos", "Resultados");
            GenerateChart(barChart10,xAxis,yAxis,GenerateGraphicsData(obs,seriesList,ser,"select id_device,sto_inter_t from device where id_device=('","interna",1,new String[]{"id_device","sto_inter_t"}), "Almacenamiento Interno Total", "Dispositivos", "Resultados");
    }
    public void checkInduction(String val){
        if(s.Consultation("select * from user_preferences where u_pref="+val+" and id_pref=1 and desc_pref='true'")==0){
   tabdash.getSelectionModel().select(tabinduction);
  }
  else{
       tabdash.getSelectionModel().select(tabdevice);

         
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
    public Boolean addImage(ActionEvent actionEvent) throws FileNotFoundException, IOException{
        ExtensionFilter filter = new ExtensionFilter("Image Files", "*.jpg", "*.png", "*.gif", "*.jpeg");
          FileChooser fileChooser=new FileChooser();
          Node node = (Node) actionEvent.getSource();
          fileChooser.getExtensionFilters().add(filter);
              fileChooser.setInitialDirectory(new File(folderLogs));
     File directory=fileChooser.showOpenDialog(node.getScene().getWindow());

             //  File directory = new File(folderLogs);
//if (directory.isDirectory()) {
    if (directory!=null) {

        //return files.FileToArray2(directory.getPath(),"",null,null,null);
        System.out.println(directory.getPath());
            int i=s.ConsultforUIInt("select count(id_image)as t from image","t");
    i+=1;
    String correct=directory.getPath();

    if(cbfilterimg.getSelectionModel().getSelectedItem()=="dispositivo"){
        File f1=new File(directory.getPath());
        File f2=new File("C:\\application\\img\\device\\"+device+"\\"+directory.getName());
        FileUtils.copyFile(f1, f2);
        s.Addelement("insert into image values("+i+",'"+device+"','"+cbfilterimg.getSelectionModel().getSelectedItem()+"','"+date+"','"+"file:"+"C:/application/img/device/"+device+"/"+directory.getName()+"')");
    }
    else{
        if(cbfilterimg.getSelectionModel().getSelectedItem()=="otras"){
        File f1=new File(directory.getPath());
        File f2=new File("C:\\application\\img\\others\\"+device+"\\"+directory.getName());
        FileUtils.copyFile(f1, f2);
        s.Addelement("insert into image values("+i+",'"+device+"','"+cbfilterimg.getSelectionModel().getSelectedItem()+"','"+date+"','"+"file:"+"C:/application/img/others/"+device+"/"+directory.getName()+"')");
    }
        else{
        File f1=new File(directory.getPath());
        File f2=new File("C:\\application\\img\\others\\"+device+"\\"+directory.getName());
        FileUtils.copyFile(f1, f2);
        s.Addelement("insert into image values("+i+",'"+device+"','"+cbfilterimg.getSelectionModel().getSelectedItem()+"','"+date+"','"+"file:"+"C:/application/img/device/"+device+"/"+directory.getName()+"')");
    }
    }
 

    } 
    return true;
    }
    public void GenerateChart(BarChart bar,CategoryAxis xAxis,NumberAxis yAxis,List<XYChart.Series<String, Number>>  serie,String title,String labelx,String labely){
      //BarChart<String,Number> barChart,barChart1;

        xAxis.setLabel(labelx); 
        yAxis.setLabel(labely); 
        bar.setTitle(title);
       for(XYChart.Series<String, Number> s: serie){
        bar.getData().add(s);
       }
       
    }
    public List<XYChart.Series<String, Number>> GenerateGraphicsData(List<XYChart.Series<String, Number>> obs,List<XYChart.Series<String, Number>> seriesList,Series<String, Number> ser,String sql,String typetest,int col,String[] columarray){
      String[] selecte=new String[100];

        obs = FXCollections.observableArrayList();
      seriesList = new ArrayList<>();
     ser = new Series<>();
     
        int x=0;
        for(Chart c:tablechart.getItems()){
            if(c.getBd()==true){
                selecte[x]=c.getNd();
            }
            else{
            }
            x++;
        }for(int v=0;v<files.RemoveNullValue2(selecte).length;v++){
            ser=new Series<>();
            String[][] arrays=s.getBD(1,sql+selecte[v]+"')",columarray ); 
            for(int a=0;a<files.RemoveNullArray(arrays).length;a++){
                
                for(int b=0;b<files.RemoveNullValue2(arrays[a]).length;b++){
                    switch(typetest){
                        case("memoria"):
                                if(selecte[v].contains(device)){
                            ser.setName(arrays[a][0]+" (EN PRUEBAS)");
                            if(arrays[a][1].contains("GB")){
                                String temp=arrays[a][1].trim();
                                temp=temp.replaceAll(" ", "");
                                temp=temp.replaceAll("GB","");
                                temp=temp.replaceAll(",", ".");
                                Double db=Double.parseDouble(temp);
                                db*=1024;
                                           ser.getData().add(new XYChart.Data<>("",db));
                                        }
                                        else{
                                String temp=arrays[a][1].trim();
                                temp=temp.replaceAll(" ", "");
                                temp=temp.replaceAll("MB","");
                                int ib=Integer.parseInt(temp);
                                           ser.getData().add(new XYChart.Data<>("",ib));
                                        }

                            }
                            else{
                                    ser.setName(arrays[a][0]);
                                  if(arrays[a][1].contains("GB")){
                                String temp=arrays[a][1].trim();
                                temp=temp.replaceAll(" ", "");
                                temp=temp.replaceAll("GB","");
                                temp=temp.replaceAll(",", ".");
                                Double db=Double.parseDouble(temp);
                                db*=1024;
                                           ser.getData().add(new XYChart.Data<>("",db));
                                        }
                                        else{
                                String temp=arrays[a][1].trim();
                                temp=temp.replaceAll(" ", "");
                                temp=temp.replaceAll("MB","");
                                int ib=Integer.parseInt(temp);
                                           ser.getData().add(new XYChart.Data<>("",ib));
                                        }
                            }

                        break;
                        case("interna"):
                                if(selecte[v].contains(device)){
                            ser.setName(arrays[a][0]+" (EN PRUEBAS)");
                            if(arrays[a][1].contains("GB")){
                                String temp=arrays[a][1].trim();
                                temp=temp.replaceAll(" ", "");
                                temp=temp.replaceAll("GB","");
                                temp=temp.replaceAll(",", ".");
                                Double db=Double.parseDouble(temp);
                                db*=1024;
                                           ser.getData().add(new XYChart.Data<>("",db));
                                        }
                                        else{
                                String temp=arrays[a][1].trim();
                                temp=temp.replaceAll(" ", "");
                                temp=temp.replaceAll("MB","");
                                int ib=Integer.parseInt(temp);
                                           ser.getData().add(new XYChart.Data<>("",ib));
                                        }

                            }
                            else{
                                    ser.setName(arrays[a][0]);
                                  if(arrays[a][1].contains("GB")){
                                String temp=arrays[a][1].trim();
                                temp=temp.replaceAll(" ", "");
                                temp=temp.replaceAll("GB","");
                                temp=temp.replaceAll(",", ".");
                                Double db=Double.parseDouble(temp);
                                db*=1024;
                                           ser.getData().add(new XYChart.Data<>("",db));
                                        }
                                        else{
                                String temp=arrays[a][1].trim();
                                temp=temp.replaceAll(" ", "");
                                temp=temp.replaceAll("MB","");
                                int ib=Integer.parseInt(temp);
                                           ser.getData().add(new XYChart.Data<>("",ib));
                                        }
                            }

                        break;
                        case(""):
                             if(selecte[v].contains(device)){
                    ser.setName(arrays[a][0]+" (EN PRUEBAS)");
                            ser.getData().add(new XYChart.Data<>("",Integer.valueOf(arrays[a][col])));
                    }
                    else{
                          ser.setName(arrays[a][0]);
                            ser.getData().add(new XYChart.Data<>("",Integer.valueOf(arrays[a][col])));
                    }
                       break; 
                    }
                   
                }
            }
              obs.add(ser);
            
        }
        seriesList.addAll(obs);
          //GenerateChart(seriesList,"Antutu BenchMark","Resultados","Dispositivos");
    return seriesList;
    }
    public void nextChart(ActionEvent actionEvent){
          List<XYChart.Series<String, Number>> obs = FXCollections.observableArrayList();
      List<XYChart.Series<String, Number>> seriesList = new ArrayList<>();
     Series<String, Number> ser = new Series<>();
         switch(tabchart.getSelectionModel().getSelectedItem().getId()){
         
            case("tabbar1"):
                         tabchart.getSelectionModel().select(tabbar4);           
                break;
            case("tabbar4"):
                         tabchart.getSelectionModel().select(tabbar5);           
                break;
            case("tabbar5"):
                         tabchart.getSelectionModel().select(tabbar6);           
                break;
            case("tabbar6"):
                         tabchart.getSelectionModel().select(tabbar7);           
                break;
            case("tabbar7"):
                         tabchart.getSelectionModel().select(tabbar8);           
                break;    
            case("tabbar8"):
                         tabchart.getSelectionModel().select(tabbar9);           
                break;
            case("tabbar9"):
                         tabchart.getSelectionModel().select(tabbar10);           
                break;
            case("tabbar10"):
                         tabchart.getSelectionModel().select(tabbar11);           
                break;
         }
}
    public void prevChart(ActionEvent actionEvent){

         switch(tabchart.getSelectionModel().getSelectedItem().getId()){
         
            case("tabbar4"):
                         tabchart.getSelectionModel().select(tabbar1);         
                break;
             case("tabbar5"):
                         tabchart.getSelectionModel().select(tabbar4);         
                break;
             case("tabbar6"):
                         tabchart.getSelectionModel().select(tabbar5);         
                break;
             case("tabbar7"):
                         tabchart.getSelectionModel().select(tabbar6);         
                break;
             case("tabbar8"):
                         tabchart.getSelectionModel().select(tabbar7);         
                break;
             case("tabbar9"):
                         tabchart.getSelectionModel().select(tabbar8);         
                break;
             case("tabbar10"):
                         tabchart.getSelectionModel().select(tabbar9);         
                break;
             case("tabbar11"):
                         tabchart.getSelectionModel().select(tabbar10);         
                break;
         }
}
    public void viewReport(ActionEvent actionEvent){
        
Platform.runLater(new Thread(reporte.unitedReport("C:\\application\\pdf\\"+device+".pdf",new String[]{device,date,positive.getText(),negative.getText()},new Button[]{visualize,generatereport},functiondevice,paramsfuncge,lblreport,new TextArea[]{positive,negative})));

    }
    public void openReport(ActionEvent actionEvent){
    if (Desktop.isDesktopSupported()) {
    try {
        File myFile = new File("C:\\application\\pdf\\"+device+".pdf");
        Desktop.getDesktop().open(myFile);
    } catch (IOException ex) {
        // no application registered for PDFs
    }
}
    }
    public void getElementsMant(ActionEvent actionEvent){
    tablemant.setEditable(true);
  columnamant1.setCellValueFactory(new PropertyValueFactory<>("mant1"));
  columnamant2.setCellValueFactory(new PropertyValueFactory<>("mant2"));
  columnamant3.setCellValueFactory(new PropertyValueFactory<>("mant3"));
  columnamant4.setCellValueFactory(new PropertyValueFactory<>("mant4"));
  columnamant5.setCellValueFactory(new PropertyValueFactory<>("mant5"));
  tablemant.setItems(datamant);

  switch(cbmante.getSelectionModel().getSelectedItem().toString()){

                   case("bluetooth"):
                       lbldesmant.setVisible(true);
                       lblmant1.setVisible(false);lblmant2.setVisible(false);lblmant3.setVisible(false);lblmant4.setVisible(false);
                       txtmant1.setVisible(false);txtmant2.setVisible(false);txtmant3.setVisible(false);txtmant4.setVisible(false);
                       txtmant1.setText("");txtmant2.setText("");txtmant3.setText("");txtmant4.setText("");
                       lblmant1.setText("tipo de Bluetooth:");
                       lblmant1.setVisible(true);
                       txtmant1.setVisible(true);
                       break;
                   case("material"):
                       lbldesmant.setVisible(true);
                       lblmant1.setVisible(false);lblmant2.setVisible(false);lblmant3.setVisible(false);lblmant4.setVisible(false);
                       txtmant1.setVisible(false);txtmant2.setVisible(false);txtmant3.setVisible(false);txtmant4.setVisible(false);
                       txtmant1.setText("");txtmant2.setText("");txtmant3.setText("");txtmant4.setText("");
                       lblmant1.setText("tipo de Material:");
                       lblmant1.setVisible(true);
                       txtmant1.setVisible(true);
                       break;
                   case("proveedor"):
                       lbldesmant.setVisible(true);
                       lblmant1.setVisible(false);lblmant2.setVisible(false);lblmant3.setVisible(false);lblmant4.setVisible(false);
                       txtmant1.setVisible(false);txtmant2.setVisible(false);txtmant3.setVisible(false);txtmant4.setVisible(false);
                       txtmant1.setText("");txtmant2.setText("");txtmant3.setText("");txtmant4.setText("");
                       lblmant1.setText("nombre:");lblmant2.setText("contacto:");lblmant3.setText("detalles:");
                       lblmant1.setVisible(true);lblmant2.setVisible(true);lblmant3.setVisible(true);
                       txtmant1.setVisible(true);txtmant2.setVisible(true);txtmant3.setVisible(true);
                       break;
                   case("network"):
                       lbldesmant.setVisible(true);
                       lblmant1.setVisible(false);lblmant2.setVisible(false);lblmant3.setVisible(false);lblmant4.setVisible(false);
                       txtmant1.setVisible(false);txtmant2.setVisible(false);txtmant3.setVisible(false);txtmant4.setVisible(false);
                       txtmant1.setText("");txtmant2.setText("");txtmant3.setText("");txtmant4.setText("");
                       lblmant1.setText("tipo:");lblmant2.setText("valor:");
                       lblmant1.setVisible(true);lblmant2.setVisible(true);
                       txtmant1.setVisible(true);txtmant2.setVisible(true);
                       break;
                   case("sensores"):
                       lbldesmant.setVisible(true);
                       lblmant1.setVisible(false);lblmant2.setVisible(false);lblmant3.setVisible(false);lblmant4.setVisible(false);
                       txtmant1.setVisible(false);txtmant2.setVisible(false);txtmant3.setVisible(false);txtmant4.setVisible(false);
                       txtmant1.setText("");txtmant2.setText("");txtmant3.setText("");txtmant4.setText("");
                       lblmant1.setText("nombre:");lblmant2.setText("descripcion:");lblmant3.setText("tipo:");
                       lblmant1.setVisible(true);lblmant2.setVisible(true);lblmant3.setVisible(true);
                       txtmant1.setVisible(true);txtmant2.setVisible(true);txtmant3.setVisible(true);
                       break;
                   case("usuario"):
                       lbldesmant.setVisible(true);
                       lblmant1.setVisible(false);lblmant2.setVisible(false);lblmant3.setVisible(false);lblmant4.setVisible(false);
                       txtmant1.setVisible(false);txtmant2.setVisible(false);txtmant3.setVisible(false);txtmant4.setVisible(false);
                       txtmant1.setText("");txtmant2.setText("");txtmant3.setText("");txtmant4.setText("");
                       lblmant1.setText("nombre:");lblmant2.setText("contraseña:");lblmant3.setText("permisos:");lblmant4.setText("avatar:");
                       lblmant1.setVisible(true);lblmant2.setVisible(true);lblmant3.setVisible(true);lblmant4.setVisible(true);
                       txtmant1.setVisible(true);txtmant2.setVisible(true);txtmant3.setVisible(true);txtmant4.setVisible(true);
                       break;
                }
    }
    public void SaveElementMant(ActionEvent actionEvent){
     switch(cbmante.getSelectionModel().getSelectedItem().toString()){

                   case("bluetooth"):
                       if(adb.confirmMessage("Aviso",question1[4])){
                           int pos=s.ConsultforUIInt("select count(id_blu) as t from bluetooth","t");
                           pos++;
                       if(s.Addelement("insert into bluetooth values("+pos+",'"+txtmant1.getText()+"')")){
                          lblinfomant.setText("elemento agregado correctamente");
                          lbldesmant.setVisible(false);
                          lblmant1.setVisible(false);
                          txtmant1.setVisible(false);
                          
                       }
                       }
                       break;
                   case("material"):
                       if(adb.confirmMessage("Aviso",question1[4])){
                           int pos=s.ConsultforUIInt("select count(id_mat) as t from material","t");
                           pos++;
                       if(s.Addelement("insert into material values ("+pos+",'"+txtmant1.getText()+"')")){
                          lblinfomant.setText("elemento agregado correctamente");
                          lblmant1.setVisible(false);
                          txtmant1.setVisible(false);lbldesmant.setVisible(false);
                       }
                       }
               
                       break;
                   case("proveedor"):
                       if(adb.confirmMessage("Aviso",question1[4])){
                           int pos=s.ConsultforUIInt("select count(id_provider) as t from provider","t");
                           pos++;
                       if(s.Addelement("insert into provider values ("+pos+",'"+txtmant1.getText()+"','"+txtmant2.getText()+"','"+txtmant3.getText()+"')")){
                          lblinfomant.setText("elemento agregado correctamente");
                          lblmant1.setVisible(false);lblmant2.setVisible(false);lblmant3.setVisible(false);
                          txtmant1.setVisible(false);txtmant2.setVisible(false);txtmant3.setVisible(false);lbldesmant.setVisible(false);
                       }
                       }
                       break;
                   case("network"):
                       if(adb.confirmMessage("Aviso",question1[4])){
                           int pos=s.ConsultforUIInt("select count(id_net) as t from network","t");
                           pos++;
                       if(s.Addelement("insert into network values ("+pos+",'"+txtmant1.getText()+"','"+txtmant2.getText()+"')")){
                          lblinfomant.setText("elemento agregado correctamente");
                          lblmant1.setVisible(false);lblmant2.setVisible(false);
                          txtmant1.setVisible(false);txtmant2.setVisible(false);lbldesmant.setVisible(false);
                       }
                       }
                       break;
                   case("sensores"):
                       if(adb.confirmMessage("Aviso",question1[4])){
                           int pos=s.ConsultforUIInt("select count(id_sup)as t from other_support","t");
                           pos++;
                       if(s.Addelement("insert into other_support values ("+pos+",'"+txtmant1.getText()+"','"+txtmant2.getText()+"','"+txtmant3.getText()+"')")){
                          lblinfomant.setText("elemento agregado correctamente");
                          lblmant1.setVisible(false);lblmant2.setVisible(false);lblmant3.setVisible(false);
                          txtmant1.setVisible(false);txtmant2.setVisible(false);txtmant3.setVisible(false);lbldesmant.setVisible(false);
                       }
                       }
                       break;
                   case("usuario"):
                       if(adb.confirmMessage("Aviso",question1[4])){
                           int pos=s.ConsultforUIInt("select count(id_user) as t from user", "t");
                           pos++;
                       if(s.Addelement("insert into user values ("+pos+",'"+txtmant1.getText()+"','"+txtmant2.getText()+"',"+txtmant3.getText()+",'"+txtmant4.getText()+"','"+date+"')")){
                          lblinfomant.setText("elemento agregado correctamente");
                          lblmant1.setVisible(false);lblmant2.setVisible(false);lblmant3.setVisible(false);lblmant4.setVisible(false);lblmant5.setVisible(false);
                          txtmant1.setVisible(false);txtmant2.setVisible(false);txtmant3.setVisible(false);txtmant4.setVisible(false);txtmant5.setVisible(false);
                          lbldesmant.setVisible(false);
                       }
                       }
                       break;
                }
    }
    public void checkFuncDevice(ActionEvent actionEvent){
      Dialog dlg = new Dialog(application.stage, "Funciones del dispositivo");  
     
        Action actionfunc;
        Button aButton=new Button();

    CheckBox[] cb=new CheckBox[41];
    if(!functiondevice.isEmpty())
    {
      for(int i=0;i<cb.length;i++){
        if(functiondevice.get(i).contains("true")){
        cb[i]=new CheckBox();
        cb[i].setSelected(true);
        }
        else{
        cb[i]=new CheckBox();
        cb[i].setSelected(false);
        }
    }
    }  
    else{
    for(int i=0;i<cb.length;i++){    
        cb[i]=new CheckBox();
   
    }
    }
 
    GridPane grid = new GridPane();
    ScrollPane scrollPane=new ScrollPane();
    scrollPane.setMaxHeight(500);
    scrollPane.setMaxWidth(800);
    scrollPane.setContent(grid);
    scrollPane.setPannable(true);
//    grid.setMaxHeight(300);
//    grid.setMaxWidth(500);
    grid.setHgap(10);
    grid.setVgap(10);
    grid.setPadding(new Insets(0, 10, 0, 10));

    

    grid.add(new Label("Cierre correcto tapa trasera: "), 0, 0);
    grid.add(cb[0], 1, 0);
    grid.add(new Label("Colocación adeduada de Gomas protectoras de puertos: "), 0, 1);
    grid.add(cb[1], 1, 1);
    grid.add(new Label("Posicion correcta de antena superior / Inferior parte trasera"), 0, 2);
    grid.add(cb[2], 1, 2);
    grid.add(new Label("Logo en perfecto estado (Impreso en cover)"), 0, 3);
    grid.add(cb[3], 1, 3);
    grid.add(new Label("Panel sin manchas"), 0, 4);
    grid.add(cb[4], 1, 4);
    grid.add(new Label("No presenta golpes"), 0, 5);
    grid.add(cb[5], 1, 5);
    grid.add(new Label("Cierre completo del equipo (botones, pestaña en posicion correcta, tornillos completos)"), 0,6 );
    grid.add(cb[6], 1,6 );
    grid.add(new Label("Camara sin obstruccion (frontal / trasero)"),0 , 7);
    grid.add(cb[7], 1, 7);
    grid.add(new Label("Sensores sin obstruccion (Luminosidad / Proximidad)"),0 ,8 );
    grid.add(cb[8],1 ,8 );
    grid.add(new Label("Encendido"),0 ,9 );
    grid.add(cb[9], 1, 9);
    grid.add(new Label("Sonido speaker principal"), 0, 10);
    grid.add(cb[10],1 ,10 );
    grid.add(new Label("Suspension y reactivacion"),0 , 11);
    grid.add(cb[11], 1,11);
    grid.add(new Label("Funcion pantalla tactil"),0 ,12 );
    grid.add(cb[12],1 ,12 );
    grid.add(new Label("LED ( Llamada/Mensaje /Carga de Batería/Teclas Físicas de Navegación"),0 ,13 );
    grid.add(cb[13], 1,13 );
    grid.add(new Label("Funcionamiento Audio 3.5 mm"),0 , 14);
    grid.add(cb[14], 1,14 );
    grid.add(new Label("Funcionamiento tecla Volumen +/-"), 0, 15);
    grid.add(cb[15], 1,15 );
    grid.add(new Label("Instalación Correcta de Drivers ( Dispositivo Modo Instalador)"),0 ,16 );
    grid.add(cb[16],1 , 16);
    grid.add(new Label("Transferencia de Archivos (MTP/ Tarjeta de Almacenamiento)"),0 ,17 );
    grid.add(cb[17],1 ,17 );
    grid.add(new Label("Activar/Desactivar Barra de Notificaciones ( WIFI/Bluetooth/GPS/Rotación Sincronización/ Hotspoot/ Modo Avión)"),0 ,18 );
    grid.add(cb[18], 1, 18);
    grid.add(new Label("Carga de Batería ( AC/ USB)"),0 ,19 );
    grid.add(cb[19], 1,19 );
    grid.add(new Label("Conectar a Red WIFI"), 0, 20);
    grid.add(cb[20], 1, 20);
    grid.add(new Label("Conectar a MHL"),0 ,21 );
    grid.add(cb[21],1 ,21 );
    grid.add(new Label("Conectar a través de Miracast "),0 ,22 );
    grid.add(cb[22], 1,22 );
    grid.add(new Label("Compartir red a través de Hotspot "),0 ,23 );
    grid.add(cb[23], 1,23 );
    grid.add(new Label("Probar Aplicaciones Envío y Recepción de Archivos a través de ellas   (Waze/ Facebook/ Whatsapp)"),0 ,24 );
    grid.add(cb[24],1 , 24);
    grid.add(new Label("Restauración de Fabrica "),0, 25);
    grid.add(cb[25], 1,25 );
    grid.add(new Label("Conectar a traves de OTG"),0 , 26);
    grid.add(cb[26], 1, 26);
    grid.add(new Label("Emparejar a Dispositivo Bluetooth y Compartir  Archivo"),0 ,27 );
    grid.add(cb[27], 1,27 );
    grid.add(new Label("Ubicar posición por el GPS"),0 ,28 );
    grid.add(cb[28], 1, 28);
    grid.add(new Label("Función de Cámara Frontal/Trasera( Flash/ Zoom/ Modos de Captura)"), 0, 29);
    grid.add(cb[29], 1,29 );
    grid.add(new Label("Señal  TV Digital / Analógica "), 0,30 );
    grid.add(cb[30],1 , 30);
    grid.add(new Label("Verificación Acceso Root"), 0,31 );
    grid.add(cb[31], 1,31 );
    grid.add(new Label("Reconocimiento de  SIM CARD "),0 ,32 );
    grid.add(cb[32], 1,32 );
    grid.add(new Label("Enviar mensaje"),0 , 33);
    grid.add(cb[33], 1,33 );
    grid.add(new Label("Recibir mensaje"), 0,34 );
    grid.add(cb[34],1 ,34 );
    grid.add(new Label("Bloqueo de seguridad (Patron-PIN-Password)"),0 ,35 );
    grid.add(cb[35], 1,35 );
    grid.add(new Label("Llamada Saliente SIM1/ SIM 2 ( Altavoz/ Normal) ( Opcional)"),0 ,36 );
    grid.add(cb[36], 1,36 );
    grid.add(new Label("Llamada Entrante SIM1/ SIM 2 ( Altavoz/ Normal) ( Opcional)"),0 ,37 );
    grid.add(cb[37],1 ,37 );
    grid.add(new Label("Configuración Red Móvil ( APN / Operador de Red en  modo manual / automático)"), 0,38 );
    grid.add(cb[38], 1, 38);
    grid.add(new Label("Operaciones Contacto Teléfono ( Agregar/Modificar/ Borrar)"), 0,39 );
    grid.add(cb[39], 1,39 );
    grid.add(new Label("Verificar Descarga de Aplicaciones  desde el Escritorio/equipo (googleplay)"), 0,40 );
    grid.add(cb[40],1 ,40 );

//    grid.add(new Label("descripción:"), 0, 1);
//    grid.add(descriptionfail, 1, 1);
//    grid.add(lblimgfail, 1, 2);

    
      
    aButton.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
//             functiondevice.clear();
//             functiondevice.add(String.valueOf(cb1.isSelected()));
//             for(String v:functiondevice){
//             System.out.println(v);
//             }
                dlg.hide();
            }
        });
    actionfunc=new AbstractAction("Aceptar") {
            
            @Override
            public void handle(ActionEvent event) {
                  functiondevice.clear();
             
             for(int i=0;i<cb.length;i++){
             functiondevice.add(String.valueOf(cb[i].isSelected()));
             }
             dlg.hide();
            }
        };
   //ButtonBar.setType(aButton, ButtonType.OK_DONE);
//    
//    actionFail.disabledProperty().set(true);
   // bcapfails.setOnAction(actioncapinmg);
//    // Do some validation (using the Java 8 lambda syntax).
//    namefail.textProperty().addListener((observable, oldValue, newValue) -> {
//        actionFail.disabledProperty().set(newValue.trim().isEmpty());
//        actioncapinmg.disabledProperty().set(newValue.trim().isEmpty());
//    });
//    actioncapinmg.disabledProperty().addListener((observable, oldValue, newValue) -> {
//        lblimgfail.setText(imgc);
//    });
//
//    dlg.setMasthead("ingrese información referente a falla");
    dlg.setContent(scrollPane);
   dlg.getActions().addAll(actionfunc,Dialog.Actions.CANCEL);

    // Request focus on the username field by default.
    
    dlg.show();
    }
    }
    
    


