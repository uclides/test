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
import javafx.scene.control.Label;

/**
 *
 * @author desarrollo06
 */
public class adb {
    
    public void execCmd(Label label,String command) {
  
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
}
else{
  if(temp.length > 1){
  label.setText("verifique modo depuración o drivers instalados");
  Notifier.INSTANCE.notifyWarning("Síragon", "dispositivo no conectado");
}
    }

                int exitVal = pr.waitFor();
                //System.out.println("Exited with error code "+exitVal);
 
            } catch(IOException e) {
                System.out.println(e.toString());
            } catch (InterruptedException e) {
                System.out.println(e.toString());
        }
        }public String returnDevice(String string){
           
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
}
