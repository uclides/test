/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package demo;

import demo.connections.adb;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Side;
import javafx.scene.control.Accordion;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.SelectionModel;
import javafx.scene.control.SingleSelectionModel;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.web.WebView;
import javax.swing.JButton;
import javax.swing.JTabbedPane;

/**
 *
 * @author project
 */
public class DashboardController extends AnchorPane implements Initializable{
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
    
     
    //instances
    private adb adb = new adb();
private Main application;

    public void setApp(Main application){
        this.application = application;

     
     
    }
   public void detectDevice(ActionEvent actionEvent){
   adb.execCmd(activedevice,"adb devices");
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
   adb.execTerminal("C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe"
   + " file:///C:/Users/Uclides%20Gil/Documents/GitHub/test/src/demo/manual/index.html");
    }
}

