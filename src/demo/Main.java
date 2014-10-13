/*
 * Copyright (c) 2012, Oracle and/or its affiliates. All rights reserved.
 */
package demo;

import demo.connections.adb;
import demo.connections.server;
import demo.model.User;
import demo.security.Authenticator;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.controlsfx.control.action.Action;
import org.controlsfx.dialog.Dialogs;


/**
 * Main Application. This class handles navigation and user session.
 */
public class Main extends Application {
    int temporal=0;int val = 0;
int inte=0;
server servidor = new server();
adb adb=new adb();
    private Stage stage;
    private User loggedUser;
    private final double MINIMUM_WINDOW_WIDTH = 1250.0;
    private final double MINIMUM_WINDOW_HEIGHT = 650.0;
    double  xOffset,yOffset;
     double xOffset2,yOffset2;
      final double fxOffset2 = 0,fyOffset2 = 0;
       AnchorPane root = null;
Stage stage2=new Stage();
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Application.launch(Main.class, (java.lang.String[])null);
          
    }

    @Override
    public void start(Stage primaryStage) {
        try {
           
            primaryStage.initStyle(StageStyle.UNDECORATED);
            stage = primaryStage;
            stage.setTitle("Síragon");
            stage.setMinWidth(MINIMUM_WINDOW_WIDTH);
            stage.setMinHeight(MINIMUM_WINDOW_HEIGHT);
            
            gotoLogin();
            primaryStage.show();
            servidor.conectar();
          
        } catch (Exception ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public User getLoggedUser() {
        return loggedUser;
    }
        
    public boolean userLogging(String userId, String password){
        if (Authenticator.validate(userId, password)) {
            loggedUser = User.of(userId);
            gotoProfile();
            return true;
        } else {
            return false;
        }
    }
    
    void userLogout(){
        loggedUser = null;
        gotoLogin();
    }
    
    private void gotoProfile() {
        try {
          
            DashboardController profile = (DashboardController) replaceSceneContent("dashboard.fxml");
            profile.setApp(this);
            openMonitor();
//            Platform.runLater(new Runnable() {
//
//                @Override
//                public void run() {
//
//                    try {
//                        adb.checkDevice();
//                      Runnable r= new Runnable() {
//
//                            @Override
//                            public void run() {
//                                  if(adb.execDetectDevice("adb devices")==1){
//                                    
//                            adb.execGeneric("adb logcat",null);
//                        
//                        }
//                        else{
//                        }
//                            }
//                        };
//                      new Thread(r).start();
//
//                    } catch (Throwable ex) {
//                        Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
//                    }
//                }
//            });
        } catch (Exception ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void gotoLogin() {
        try {
            LoginController login = (LoginController) replaceSceneContent("login.fxml");
            login.setApp(this);
            
        } catch (Exception ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void openMonitor()throws Exception{
        try {
 

                root = FXMLLoader.load(MonitorController.class.getResource("monitor.fxml"));
                
            Scene monitorscene = new Scene(root);
            Stage stage2=new Stage();
            stage2.initStyle(StageStyle.UNDECORATED);
            stage2.setScene(monitorscene);
            stage2.show();
             
            root.setOnMousePressed(new EventHandler<MouseEvent>(){
            public void handle(MouseEvent event){
            xOffset2=event.getSceneX();
            yOffset2=event.getSceneY();
            }
        });
        root.setOnMouseDragged(new EventHandler<MouseEvent>(){
            public void handle(MouseEvent event){
               if (event.getButton() != MouseButton.MIDDLE) {
                root.getScene().getWindow().setX(event.getScreenX() - xOffset2);
                root.getScene().getWindow().setY(event.getScreenY() - yOffset2);
            }
            }
        });
        
        
    
        } catch (Exception ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static EventType<Event> llenar() {
        return EventType.ROOT;
    }

    private Initializable replaceSceneContent(String fxml) throws Exception {
        FXMLLoader loader = new FXMLLoader();
        InputStream in = Main.class.getResourceAsStream(fxml);
        loader.setBuilderFactory(new JavaFXBuilderFactory());
        loader.setLocation(Main.class.getResource(fxml));
        AnchorPane page;
        try {
            page = (AnchorPane) loader.load(in);
              page.setOnMousePressed(new EventHandler<MouseEvent>(){
            public void handle(MouseEvent event){
            xOffset=event.getSceneX();
            yOffset=event.getSceneY();
            }
        });
        page.setOnMouseDragged(new EventHandler<MouseEvent>(){
            public void handle(MouseEvent event){
               if (event.getButton() != MouseButton.MIDDLE) {
                page.getScene().getWindow().setX(event.getScreenX() - xOffset);
                page.getScene().getWindow().setY(event.getScreenY() - yOffset);
            }
            }
        });
        } finally {
            in.close();
        } 
        Scene scene = new Scene(page, 1250, 650);
        
        stage.setScene(scene);
        stage.sizeToScene();
        return (Initializable) loader.getController();
    }
}
