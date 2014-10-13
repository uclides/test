/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo;

import demo.connections.adb;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;

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
 System.out.println("hoaaaaaaaaaaaaa");
    }
 public void setMonitor(Main application) {
        this.application = application;
    }

}
