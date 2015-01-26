/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package demo.connections;


import demo.GenericInterface;
import static demo.GenericInterface.detect;
import static demo.GenericInterface.devicedisp;
import static demo.GenericInterface.mesagges;
import static demo.GenericInterface.runlogcat;
import demo.Main;
import demo.MonitorController;
import demo.tables.Apk;
import eu.hansolo.enzo.notification.Notification.Notifier;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javax.xml.parsers.ParserConfigurationException;
import org.controlsfx.control.action.Action;
import org.controlsfx.dialog.Dialog;
import org.controlsfx.dialog.DialogStyle;
import org.controlsfx.dialog.Dialogs;

/**
 *
 * @author desarrollo06
 */
public class adb implements Runnable,GenericInterface{
public Thread thread;

int temporal=0;int val = 0;
int inte=0,iterator=0,x;
public int b;
public String input;

AnchorPane root = null;
public String lineadb="hoaaaaaaaaaaaaaaaa111111111111",ID;

double  xOffset,yOffset;
     double xOffset2,yOffset2;
      final double fxOffset2 = 0,fyOffset2 = 0;
private Main application;
public Stage stage2=new Stage();
public Stage stage3=new Stage();
public Scene monitorscene;
public Scene failscene;
public String Id;
public int booleandevice,validatedialog=0;
    Boolean monitoruser;
Action responseconfirm;
    Timer timer;
public Thread t;
adb(String sinput){

this.input= sinput;
}

    public adb() {


    }

    public int execCmd(Label label,String command) {
int val = 0;
    try {
                Runtime rt = Runtime.getRuntime();
                //Process pr = rt.exec("cmd /c dir");
                Process pr = rt.exec(command);
 
                BufferedReader input = new BufferedReader(new InputStreamReader(pr.getInputStream()));
 
                String line=null;
                String [] temp = new String [5];
                int x=0;
                while((line=input.readLine()) != null) {
                    temp[x]=line;
                    //System.out.print(temp[x]);
                    
                    x++;
                   
                }
if(temp[1].indexOf("device")!= -1){
  label.setText(temp[1]+" detectado");
  Notifier.INSTANCE.notifySuccess("Síragon", temp[1]+" detectado");
val=0;

}
else{
  if(temp.length > 1){
  label.setText("verifique modo depuración o drivers instalados");
  Notifier.INSTANCE.notifyWarning("Síragon", "dispositivo no conectado");

  
}
  val=-1;
    }

                int exitVal = pr.waitFor();
                //System.out.println("Exited with error code "+exitVal);
 
            } catch(IOException | InterruptedException e) {
                System.out.println(e.toString());
            }
        return val;
        }
    public String returnID(String command) {
int val = 0;
    try {
                Runtime rt = Runtime.getRuntime();
                //Process pr = rt.exec("cmd /c dir");
                Process pr = rt.exec(command);
 
                BufferedReader input = new BufferedReader(new InputStreamReader(pr.getInputStream()));
 
                String line=null;
                String [] temp = new String [5];
                int x=0;
                while((line=input.readLine()) != null) {
                    temp[x]=line;
                    //System.out.print(temp[x]);
                    
                    x++;
                   
                }
if(temp[1].indexOf("device")!= -1){
  ID=temp[1];

}
else{

    }

                int exitVal = pr.waitFor();
                //System.out.println("Exited with error code "+exitVal);
 
            } catch(IOException | InterruptedException e) {
                System.out.println(e.toString());
            }
        return ID.replaceAll("device", "").trim();
        }
    public String[] execGeneric(String command,TextArea textArea,int i) {
 String [] temp = new String [50000];   
//Thread t=new Thread(new Task() {
//
//    @Override
//    protected Object call() throws Exception {

    try {
        if(i==1) {
            
                Runtime rt = Runtime.getRuntime();
                Process pr = rt.exec(command);
 
                BufferedReader input = new BufferedReader(new InputStreamReader(pr.getInputStream()));
 
                String line="null";
               
                int x=0;
                while((line=input.readLine()) != null) {
                    lineadb+=line;
                    if(line!=null && !"".equals(line) && !line.contains("WARNING: linker:")){
                    temp[x]=line;
                    }
                    
                    System.out.println(line);
                    x++;
                }

                int exitVal = pr.waitFor();
                if(exitVal==0){
                    
                }
                
               // return 1;
        }else{
        alertMessage(mesagges[0]);
      //  return 0;
        }
            } catch(IOException e) {
                
                System.out.println(e.toString());
                return null;
            } catch (InterruptedException ex) {
        Logger.getLogger(adb.class.getName()).log(Level.SEVERE, null, ex);
        return null;
    }
//            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//});
//t.setDaemon(true);
//t.start();
//if(t.isInterrupted()){
//System.out.println("FINALIZA HILO");
//}

  // return 0;
    return temp;
        }

    public Runnable execGenericLoop(String command,TextArea textArea,int i,ObservableList<Apk> data,String nameapp,Label msj,int finish,ProgressIndicator pi) {
 //String [] temp = new String [10];
            
t=new Thread(new Task() {

    @Override
    protected Object call() throws Exception {

    try {
        if(i==1) {
                Thread runlbl=new Thread(){
                  @Override
                  public void run(){
                  updateLbl(msj,mesagges[4]+nameapp,pi,true);
                  }  
                };
         

              //msj.setText(mesagges[4]+nameapp);      
                Runtime rt = Runtime.getRuntime();
                Process pr = rt.exec(command);
                
                BufferedReader input = new BufferedReader(new InputStreamReader(pr.getInputStream()));
 
                String line="null";
               
                
                while((line=input.readLine()) != null) {
                    lineadb+=line;
//textArea.appendText(line+"\n");

                    System.out.println(line);
                    x++;
                   Platform.runLater(runlbl);
                }
             
data.add(new Apk(nameapp));
if(finish==data.size()){
  //  pi.setVisible(false);
    updateLbl(msj,"Aplicaciones instaladas correctamente",pi,false);
    
}
                int exitVal = pr.waitFor();
                if(exitVal==0){
                    
                }
                
               // return 1;
        }else{
        alertMessage(mesagges[0]);
      //  return 0;
        }
            } catch(IOException e) {
                System.out.println(e.toString());
            } catch (InterruptedException ex) {
        Logger.getLogger(adb.class.getName()).log(Level.SEVERE, null, ex);
    }
//            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return null;
        
    }
});
t.setDaemon(true);
t.start();
//if(t.isInterrupted()){
//System.out.println("FINALIZA HILO");
//}

  // return 0;
  //  return 0;

    return null;
        }
    public Runnable execConsole(String command,TextArea textArea,int i,String equal,Label label,ProgressIndicator pi,Button b,ImageView iv) {
     //String [] temp = new String [10];

    t=new Thread(new Task() {

        @Override
        protected Object call() throws Exception {
        try {
            if(i==1) {
                    Thread runlbl=new Thread(){
                      @Override
                      public void run(){
                      prepareDBech(label,mesagges[5],b);
                     
                      }  
                    };
                    
                    Runtime rt = Runtime.getRuntime();
                    Process pr = rt.exec(command);

                    BufferedReader input = new BufferedReader(new InputStreamReader(pr.getInputStream()));

                    String line="null";

                    while((line=input.readLine()) != null) {
                        
                        if(line.contains(equal)){
                            Platform.runLater(runlbl);
                         }

                    }


                    int exitVal = pr.waitFor();
                    if(exitVal==0){

                    }

                   // return 1;
            }else{
            alertMessage(mesagges[0]);
          //  return 0;
            }
                } catch(IOException e) {
                    System.out.println(e.toString());
                } catch (InterruptedException ex) {
            Logger.getLogger(adb.class.getName()).log(Level.SEVERE, null, ex);
        }
    //            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            return null;

        }
    });
    t.setDaemon(true);
    t.start();
    //if(t.isInterrupted()){
    //System.out.println("FINALIZA HILO");
    //}

      // return 0;
      //  return 0;

        return null;
        }
    public int execLogCat(String command,TextArea textArea) {
         Id=returnID(devicedisp).replaceAll("	device","");
       System.out.println(Id);
 //String [] temp = new String [10];   
    try {
                Runtime rt = Runtime.getRuntime();
                Process pr = rt.exec(command);
 
                BufferedReader input = new BufferedReader(new InputStreamReader(pr.getInputStream()));
 
                String line="null";
               
                int x=0;
                while((line=input.readLine()) != null) {
                    lineadb=line;

//textArea.appendText(line);

                    System.out.println(line);
                    x++;
                }

                int exitVal = pr.waitFor();
                if(exitVal==0){
           
                        Platform.runLater(new Runnable() {

                        @Override
                        public void run() {
                            try {
                                         if(confirmMessage(disconnect,question)){
                   
                                             if(execDetectDevice(devicedisp)==1){
                 
                      if(execTerminal("adb pull /storage/sdcard0/"+Id+" c:\\application\\logs\\"+Id+".txt")){      
                    showMonitor();
                                        }
                                         }
                                             else{
                                           checkDevice();
                                                  if(execDetectDevice("adb devices")==1){
                                    
                            if(execTerminal("adb pull /storage/sdcard0/"+Id+" c:\\application\\logs\\"+Id+".txt")){
                                
                    showMonitor();
                    
                                         }
                        }
                        else{
                       checkDevice();
                        }
                                             }
                                         }
                                
                            } catch (Exception ex) {
                                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                            } catch (Throwable ex) {
                                Logger.getLogger(adb.class.getName()).log(Level.SEVERE, null, ex);
                            }   }
                    });
               
                }
            } catch(IOException e) {
                System.out.println(e.toString());
            } catch (InterruptedException ex) {
        Logger.getLogger(adb.class.getName()).log(Level.SEVERE, null, ex);
    }
    return 0;
        }
    public String getOutAdb(){
    return this.input;
    }
    public void setOutAdb(String in){
    input=in;
    }
    public int execDetectDevice(String command) {

    try {
                Runtime rt = Runtime.getRuntime();
                //Process pr = rt.exec("cmd /c dir");
                Process pr = rt.exec(command);
                BufferedReader input = new BufferedReader(new InputStreamReader(pr.getInputStream()));
                String line=null;
                String [] temp = new String [5];
                int x=0;
                while((line=input.readLine()) != null) {
                    temp[x]=line;
                    x++;//System.out.print(temp);
                }
            
                if(temp[1].indexOf("device")!= -1 && temporal!=0){
val=1;
if(temporal==2){
System.out.println("Conectado");

}

}
                else {
  if(temp.length > 1 && temporal!=0){
if(temporal==1){
System.out.println("Desconectado");

}

  }
  val=2;
  
    }
temporal=val;

                int exitVal = pr.waitFor();
                //System.out.println("Exited with error code "+exitVal);
 iterator++;
            } catch(IOException | InterruptedException e) {
                System.out.println(e.toString());
            }
    System.out.println(val);
        this.b=val;
    return b;
         
        }
    public String returnDevice(String string){
           
            return string;
        }
    public Boolean execTerminal(String commands){
           try {
    // Execute command
    String command = "cmd /c start cmd.exe";
    Process child = Runtime.getRuntime().exec(commands);

    // Get output stream to write from it
return true;
} catch (IOException e) {
    return false;
}

    }
    public void alertMessage(String message){
    Action response = Dialogs.create()
      .owner(null)
      .style(DialogStyle.CROSS_PLATFORM_DARK)
      .title("aviso")
      .masthead(null)
      .message(message)
      .showWarning();
    }
    public Boolean confirmMessage(String string,String string1){
     responseconfirm = Dialogs.create()
        .owner(null)
        .style(DialogStyle.CROSS_PLATFORM_DARK)
        .title("Confirm Dialog with Custom Actions")
        .masthead(string)
        .message(string1)
        .actions(Dialog.Actions.OK, Dialog.Actions.CANCEL)
        .showConfirm();
     
    return responseconfirm==Dialog.Actions.OK;
    
    }
    public int checkDevice() throws Throwable{
        int y=0;
          try {
        do{
        inte= execDetectDevice(devicedisp);
        Thread.sleep(1000);
        
        if(temporal ==1){
           this.finalize();
            Notifier.INSTANCE.notifySuccess(company,detect);
        }
        else{
        if(temporal ==2){
            this.finalize();
       // alertMessage(mesagges[0]); 
            if(iterator>1){
          if(confirmMessage(noconnect,question2)){
                   
              inte=3;
          System.out.println("MODULE WITh DEVICE");
                                   }
          else{
          System.out.println("MODULE WITHOUT DEVICE");
          }
        }
        }
        }
        y=1;
        }
        
        while(inte==2);{
this.start();
    }
    } catch (InterruptedException ex) {
        Logger.getLogger(adb.class.getName()).log(Level.SEVERE, null, ex);
    }
          return temporal;
        
    }
    @Override
    public void run() {

    }
    public void start(){
        thread= new Thread(this);
        thread.setDaemon(true);
        thread.start();
}
     
    public void showMonitor(){
         if(stage2.getScene()!=null){
         stage2.show();
         }
         else{
                try {
                    monitoruser=true;
                    // List<String> valueslog=file.FileToArray(folderLogs,file.GetNameFile(folderLogs));  /// SE DESCONECTA EL TELEFONO!!!!!!!!!!!!!!!!!!!!!!!!
                    root = FXMLLoader.load(MonitorController.class.getResource("monitor.fxml"));
                    
                    monitorscene = new Scene(root);
                    stage2.initStyle(StageStyle.UNDECORATED);
                    stage2.setScene(monitorscene);
                    stage2.show();
                    
                    root.setOnMousePressed(new EventHandler<MouseEvent>(){
                        @Override
                        public void handle(MouseEvent event){
                            xOffset2=event.getSceneX();
                            yOffset2=event.getSceneY();
                        }
                    });
                    root.setOnMouseDragged(new EventHandler<MouseEvent>(){
                        @Override
                        public void handle(MouseEvent event){
                            if (event.getButton() != MouseButton.MIDDLE) {
                                root.getScene().getWindow().setX(event.getScreenX() - xOffset2);
                                root.getScene().getWindow().setY(event.getScreenY() - yOffset2);
                            }
                        }
                    });
                }
         catch (IOException ex) {
                    Logger.getLogger(adb.class.getName()).log(Level.SEVERE, null, ex);
                }
         }
            
        }
    public String LoopAdb(Label label){
       
       timer = new java.util.Timer();

timer.schedule(new TimerTask() {
 int  bool,x=0,y,z;   
    @Override
    public void run() {
        
         Platform.runLater(() -> {
             
             bool = execDetectDevice(devicedisp);
             if(bool==1)
             {
             
                 if(x==1||x==0){
                     label.setText(detect);
                     execTerminal(removeFadb);
                     y++;
                      x=2;
                      z=0;
                      String ID=returnID(devicedisp)+y+".txt";
                      System.out.println(ID);
                 execTerminal(runlogcat+ID);
                 ID=returnID(devicedisp);
                 System.out.println("EJECUTANDO LOG");
                
                }
                 
             }
             else{
                 label.setText(offline);
                     System.out.println("DESCONECTADO:"+b);
                 if(z==0 && y>0){
                 z=2;
                 x=1;
                 
              if(validatedialog!=1){
                     validatedialog=1;

                                                     if(confirmMessage(disconnect,question)){
                
                                             if(execDetectDevice(devicedisp)==1){
                 
                      if(execTerminal("adb pull /storage/sdcard0/app-siragon/ADB c:\\application\\logs\\")){      
                          showMonitor();
                                        }
                                         }
                                             else{
                                                 try {
                                                     checkDevice();
                                                     if(execDetectDevice("adb devices")==1){
                                                         
                                                         if(execTerminal("adb pull /storage/sdcard0/ADB c:\\application\\logs\\")){
                                                             
                                                             showMonitor();
                                                             
                                                         }
                                                     }
                                                     else{
                                                         checkDevice();
                                                         validatedialog=0;
                                                     }                        } catch (Throwable ex) {
                                                     Logger.getLogger(adb.class.getName()).log(Level.SEVERE, null, ex);
                                                 }
                                                 validatedialog=0;
                                             }
                                            validatedialog=0; 
                                         }
                                                     validatedialog=0;
                 }
              else{
               System.out.println("YA SE EJECUTO DIALOG:"+b);}
             }        
             
             else{
            
             }
             }
         });
    }

}, 1000, 1000);
return ID;
        }
    public void updateLbl(Label lbl,String text,ProgressIndicator pi,Boolean b){
    Platform.runLater(new Task() {

        @Override
        protected Object call() throws Exception {
lbl.setText(text);
pi.setVisible(b);
            return null;
                }
    });
    }
    public void prepareDBech(Label lbl,String text,Button button){
    Platform.runLater(new Task() {

        @Override
        protected Object call() throws Exception {
lbl.setText(text);

button.setDisable(false);
            execGeneric(start[3]+moveresultsappbench[0], null,b);
            execGeneric(sendfiletoPcbench[0], null,b);
            loadxml().stream().forEach((val) -> {
                System.out.println(val);
            });
            return null;
                }
    });
    }
    public List<String> loadxml(){
        List<String> items=new ArrayList<>();
    try {
        files fil=new files();
        items=fil.readXml(pathfilebench[0]);
    } catch (ParserConfigurationException ex) {
        Logger.getLogger(adb.class.getName()).log(Level.SEVERE, null, ex);
    }
    return items;
    }   
    public void checkDir(int lines,String[] commands,String value) {
    try {
        Boolean exist=false;
        
        Runtime rt = Runtime.getRuntime();
        //Process pr = rt.exec("cmd /c dir");
        Process pr = rt.exec(commands[0]);
        
        BufferedReader input = new BufferedReader(new InputStreamReader(pr.getInputStream()));
        
        String line=null;
        String [] temp = new String [10];
        int x=0;
        while((line=input.readLine()) != null) {
            temp[x]=line;
            //System.out.print(temp[x]);
            
            x++;
            
        }
        if(temp[lines].contains(value)){
            exist=true;
            
        }
        
        //System.out.println("Exited with error code "+exitVal);
        if(!exist){
            
            // Execute command
            for(int i=0;i<commands.length;i++){
                Process child = Runtime.getRuntime().exec(commands[i]);
                
                // Get output stream to write from it
                OutputStream out = child.getOutputStream();
                
                out.write("cd C:/ /r/n".getBytes());
                out.flush();
                out.write("dir /r/n".getBytes());
                out.close();
            }
        }
        else{System.out.println("AHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHH");}
        int exitVal = pr.waitFor();
    } catch (InterruptedException | IOException ex) {
        Logger.getLogger(adb.class.getName()).log(Level.SEVERE, null, ex);
    }
 
            

        }
}