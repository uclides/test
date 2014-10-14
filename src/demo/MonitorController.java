/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo;

import demo.connections.adb;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 *
 * @author project
 */
public class MonitorController extends AnchorPane implements Initializable, GenericInterface{
    @FXML
    public TextArea textarea;
   private Main application;
    adb adb = new adb();
    @FXML

    @Override
    public void initialize(URL location, ResourceBundle resources) {

 Platform.runLater(new Runnable() {
        @Override
                       public void run() {

                    try {
                        adb.checkDevice();
                      Runnable r= new Runnable() {

                            @Override
                            public void run() {
                                  if(adb.execDetectDevice("adb devices")==1){
                                    
                            adb.execGeneric("adb logcat",null);
                        
                        }
                        else{
                        }
                            }
                        };
                      new Thread(r).start();

                    } catch (Throwable ex) {
                        Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
   });
    }


}
