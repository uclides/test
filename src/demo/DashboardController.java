/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package demo;

import static demo.GenericInterface.devicedisp;
import demo.connections.adb;
import demo.connections.files;
import demo.connections.server;
import java.net.URL;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Accordion;
import javafx.scene.control.Button;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ProgressBar;
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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.util.Callback;
import javafx.util.Duration;
import org.controlsfx.control.CheckComboBox;


/**
 *
 * @author project
 */
public class DashboardController extends AnchorPane implements Initializable,GenericInterface{
    @FXML
    Button detectdevice,bdevice,bcontinue,bcontinue2,bcomponente,bprovider,bapp,bcompare,
            exit,bmanual,baddcomporprov,bmore;
    @FXML
    Label activedevice,user,permission,dateuser,lblcompinfo;
    @FXML
    ImageView avatar;
    @FXML
    Accordion accordion;
    @FXML
    TabPane tabdash;
    @FXML
    Tab tabdevice,tabcomp,tabapp,tabtest,tabimage,tabcompare;
    @FXML
    TitledPane  accorIdentificacion,accorBenchmark,accorImagenes,accorVersus,
            accorFallas,accorReporte,accorMantenimiento,accorAyuda;
    @FXML
    TextArea outConsole;
    @FXML
    ProgressBar bardashboard; 
    @FXML
    TableView<Device> tableinfodevice;
    @FXML
    TableColumn<Device,String> columnitem,columndescription;
    @FXML
    SplitPane splitPane; 
    @FXML
    ComboBox tecnologiadisplay,cbtypedis,cbtactildis,cbtypebat,cbbluetooth,cbprov,cbcertgoogle;
    @FXML
    ColorPicker cpdev;
    @FXML
    MenuButton choicewifi,choiceband,choicesensor,choicematerialdev;
    
    @FXML 
    TextField txthdev,txtwdev,txtbulkdev,txtcolordis,txtcapbat,txtelemadd1,txtelemadd2,txtelemadd3;
    List<CheckMenuItem> itemsband,itemswifi;
    
    //instances
 adb adb = new adb();
 files files=new files();
  String[] info,info2,info3,info4,info5,info6,info7,info8,info9,
          info10,info11,info12,info13,info14,info15,info16,
          info17,info18,info19,info20;
   ObservableList<Device> data=FXCollections.observableArrayList();
   public ObservableList<String> attrLogin;
private Main application;
LoginController login=new LoginController();
String[] out = new String[100];
    private Timeline task;
server servidor=new server();
    int count;
public int VAL;
public DashboardController(){
       
        this.tableinfodevice = new TableView<>();


}
    public void setApp(Main application){
        this.application = application;

     
     
    }
   public void LoadInfoInitialPhone(ActionEvent actionEvent){
//  System.out.println("ESGRACIAOOOOOOOOOOOOO: "+adb.b);
       if(tableinfodevice.getItems().isEmpty())
       {
  if(adb.b==1) {
      String device=adb.returnID(devicedisp);
      System.out.println(device);
         if(servidor.Consultation("select * from device where id_device='"+device+"'")!=0){ 
                            
                            if(adb.confirmMessage(exrecord,question1)){
                                System.out.println("LOAD INFORMATION DEVICE");
                                
                            }
                        }
                        else{
                            ProgressBar(2);
adb.execGeneric(installSiragonapp,outConsole,adb.b);
ProgressBar(1);
adb.execGeneric(startSiragonapp,outConsole,adb.b);
ProgressBar(1);
adb.execGeneric(pullfile,outConsole,adb.b);
pushInfo();
                           // activedevice.setText("verifica estatus del servidor");                       
//                          profile.detectdevice.setOnAction((event) -> {
//                              adb.execTerminal(server);
//                           });
                            
                            
                        }
bcontinue.setDisable(false);
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
   columnitem.setCellValueFactory(new PropertyValueFactory<>(valitem));
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
new Device(vala2sdd,info3[1]),
new Device(valph,info4[1]),
new Device(valpw,info4[2]),
new Device(valpd,info4[3]),
new Device(valps,info4[4]),
new Device(valpfr,info4[5])
);
    
   tableinfodevice.setItems(data);
   createFileDevice(info5,sup);
   createFileDevice(info6,vidsup);
   createFileDevice(info8,sup2);
   createFileDevice(info9,vidsup2);
   createFileDevice(info10,mod);
   createFileDevice2(info7,otfeature);
   createFileDevice(info11,cams);
   createFileDevice(info12,est);
   createFileDevice3(info13,alminter);
   createFileDevice3(info14,almsis);
   createFileDevice3(info15,dispcache);
   createFileDevice3(info16,dispm);
   createFileDevice3(info17,proc);
   createFileDevice3(info18,frec);
   createFileDevice3(info19,red);
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
new Device(vala2sdd,""),
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
  adb.LoopAdb(activedevice);

  choicematerialdev.getItems().addAll(servidor.ConsultforUICMItem(consults[0],columnsdb[0]));
  choiceband.getItems().addAll(servidor.ConsultforUICMItem(consults[1],columnsdb[1]));
  choiceband.getItems().addAll(servidor.ConsultforUICMItem(consults[1],columnsdb[1]));
  choicewifi.getItems().addAll(servidor.ConsultforUICMItem(consults[2],columnsdb[1]));
  choicesensor.getItems().addAll(servidor.ConsultforUICMItem(consults[7],columnsdb[6]));
  ObservableList<String> olistblu = FXCollections.observableArrayList(servidor.ConsultforUIArray(consults[3],columnsdb[2]));
  cbbluetooth.setItems(olistblu);
    ObservableList<String> olistdis = FXCollections.observableArrayList(servidor.ConsultforUIArray(consults[4],columnsdb[3]));
  cbtypedis.setItems(olistdis);
      ObservableList<String> olisttactil = FXCollections.observableArrayList(servidor.ConsultforUIArray(consults[5],columnsdb[4]));
  cbtactildis.setItems(olisttactil);
        ObservableList<String> olistbat = FXCollections.observableArrayList(servidor.ConsultforUIArray(consults[6],columnsdb[5]));
  cbtypebat.setItems(olistbat);
          ObservableList<String> olistprov = FXCollections.observableArrayList(servidor.ConsultforUIArray(consults[8],columnsdb[7]));
  cbprov.setItems(olistprov);
  cbcertgoogle.getItems().addAll("si","no");

validateTextFile(txthdev);
validateTextFile(txtwdev);
validateTextFile(txtbulkdev);
validateTextFile(txtcolordis);
validateTextFile(txtcapbat);
  
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
        switch(tabdash.getSelectionModel().getSelectedItem().getId()){
        case("tabdevice"):
            servidor.generateInfoIdent(columnitem,columndescription);
            tabdash.getSelectionModel().select(tabcomp);
            break;
        case("tabcomp"):
            getInfoTabComp();
            //tabdash.getSelectionModel().select(tabapp);
            break;    
            
        }
    
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
      user.setText(observableList.get(0));
      permission.setText(observableList.get(1));
      avatar.setImage(new Image(observableList.get(2)));
      dateuser.setText(observableList.get(3));
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
    public void validateTextFile(TextField textField)
    {
    
  textField.setOnKeyTyped(new EventHandler<KeyEvent>(){

    @Override
    public void handle(KeyEvent event) {
        String valtxt=((TextInputControl)event.getTarget()).getText();
        if(valtxt.length()<0||valtxt.isEmpty()){
            ((Node)event.getTarget()).setStyle("-fx-border-color: red");
        }
        else{
        ((Node)event.getTarget()).setStyle("-fx-border-color: null");
        lblcompinfo.setText("");
        }
    }
  });
    }
//    public void returnComboBox(ActionEvent actionEvent){
//    System.out.println(files.getValueCb(cbmaterialdev));
//    }
    public String[] returnMenuItem(MenuButton mb){
        String array[]=new String [20];
        int y=0;
        for(String mi:files.getValueMI(mb)){
        array[y]=mi;
        y++;
        }
        return array;
        }
    public void getColor(ActionEvent actionEvent){
    System.out.println(cpdev.getValue().toString());
    }
    public String[][] getInfoTabComp(){
       String[][]values=new String[20][20];
int w = 0,x = 0,y = 0,z=0;
       if("".equals(txthdev.getText()) ||"".equals(txtwdev.getText())||"".equals(txtbulkdev.getText())
          ||"".equals(txtcolordis.getText())||"".equals(txtcapbat.getText()))
       {lblcompinfo.setText("Existen campos vacios, ingrese información correspondiente");}
       else{
       values[0][0]=txthdev.getText();
       values[1][0]=txtwdev.getText();
       values[2][0]=txtbulkdev.getText();
       for(String val:returnMenuItem(choicematerialdev)){ 
       values[3][w]=val;
       w++;
       }
       values[4][0]=cpdev.getValue().toString();
       for(String val:returnMenuItem(choiceband)){ 
       values[5][x]=val;
       x++;
       }
       for(String val:returnMenuItem(choicewifi)){ 
       values[6][y]=val;
       y++;
       }
       values[7][0]=files.getValueCb(cbbluetooth);
       values[8][0]=files.getValueCb(cbtypedis);
       values[9][0]=txtcolordis.getText();
       values[10][0]=files.getValueCb(cbtactildis);
       values[11][0]=files.getValueCb(cbtypebat);
       values[12][0]=txtcapbat.getText();
              for(String val:returnMenuItem(choicesensor)){ 
       values[13][z]=val;
       z++;
       }
       values[14][0]=files.getValueCb(cbprov);
       values[15][0]=files.getValueCb(cbcertgoogle);
       
//       for(String[] valu:values){
//       System.out.println(Arrays.toString(valu));
//       }
           for (String[] value1 : values) {
               for (String value : value1) {
                   if(value!=null){
                   System.out.println(value);
                   }
               }
           }
       }
    return values;
      

           
    }
    }
    


