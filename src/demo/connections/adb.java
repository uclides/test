/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package demo.connections;


import eu.hansolo.enzo.notification.Notification;
import eu.hansolo.enzo.notification.Notification.Notifier;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.controlsfx.control.action.Action;
import org.controlsfx.dialog.Dialogs;

/**
 *
 * @author desarrollo06
 */
public class adb implements Runnable{
public Thread thread;
int temporal=0;int val = 0;
int inte=0;

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
                    x++;//System.out.print(temp);
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
 
            } catch(IOException e) {
                System.out.println(e.toString());
            } catch (InterruptedException e) {
                System.out.println(e.toString());
        }
        return val;
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
inte=-1;
alertMessage();
}

  }
  val=2;
  
    }
temporal=val;

                int exitVal = pr.waitFor();
                //System.out.println("Exited with error code "+exitVal);
 
            } catch(IOException e) {
                System.out.println(e.toString());
            } catch (InterruptedException e) {
                System.out.println(e.toString());
        }
        return val;
        }
    public String returnDevice(String string){
           
            return string;
        }
    
    public void execTerminal(String commands){
           try {
    // Execute command
    String command = "cmd /c start cmd.exe";
    Process child = Runtime.getRuntime().exec(commands);

    // Get output stream to write from it

} catch (IOException e) {
}
    }
    
    public void alertMessage(){
    Action response = Dialogs.create()
      .owner(null)
      .title("You do want dialogs right?")
      .masthead(null)
      .message( "I was a bit worried that you might not want them, so I wanted to double check.")
      .showConfirm();
    }
    public void checkDevice(){
          try {
        do{
        inte= execDetectDevice("adb devices");
        Thread.sleep(1000);
        
        if(temporal ==1){
            
        }
        }
        
        while(inte!=-1);{

        //this.start();
    }
    } catch (InterruptedException ex) {
        Logger.getLogger(adb.class.getName()).log(Level.SEVERE, null, ex);
    }
    }
    @Override
   
    public void run() {
        
//    try {
//        do{
//        inte= execDetectDevice("adb devices");
//        Thread.sleep(1000);
//        
//        if(temporal ==1){
//            
//        }
//        }
//        
//        while(inte!=-1);{
//
//        //this.start();
//    }
//    } catch (InterruptedException ex) {
//        Logger.getLogger(adb.class.getName()).log(Level.SEVERE, null, ex);
//    }
    }
    public void start(){
        thread= new Thread(this);
        thread.start();
}
}
