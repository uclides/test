/*
 * Copyright (c) 2012, Oracle and/or its affiliates. All rights reserved.
 */
package demo;

import demo.connections.adb;
import demo.connections.server;
import demo.model.User;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.event.EventType;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Scene;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


/**
 * Main Application. This class handles navigation and user session.
 */
public class Main extends Application implements GenericInterface {
    int temporal=0;int val = 0;
int inte=0;
server servidor = new server();
adb adb=new adb();
    public Stage stage;
    private User loggedUser;
    private final double MINIMUM_WINDOW_WIDTH = 1250.0;
    private final double MINIMUM_WINDOW_HEIGHT = 650.0;
    double  xOffset,yOffset;
     double xOffset2,yOffset2;
      final double fxOffset2 = 0,fyOffset2 = 0;
       AnchorPane root = null;
       int estatusdevice;
       public int detectADB;
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
            
           
            primaryStage.show();
           gotoLogin();
   
          
        } catch (Exception ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public User getLoggedUser() {
        return loggedUser;
    }  
    void userLogout(){
        loggedUser = null;
        gotoLogin();
    }   
    void gotoProfile(ObservableList<String> ol) {
        
        
        try {
          
            DashboardController profile = (DashboardController) replaceSceneContent("dashboard.fxml");
            profile.setApp(this);
            profile.getParametersUser(ol);
            profile.checkInduction(ol.get(0));
            profile.typeAccess(Integer.parseInt(ol.get(2)));


        } catch (Exception ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        System.out.println("NO SE PUEDE INICIAR SESION PORQUE NO HAY CONEXION AL SERVIDOR");
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
    public static EventType<Event> llenar() {
        return EventType.ROOT;
    }
    private Initializable replaceSceneContent(String fxml) throws Exception {
        Scene scene;
        FXMLLoader loader = new FXMLLoader();
        InputStream in = Main.class.getResourceAsStream(fxml);
        loader.setBuilderFactory(new JavaFXBuilderFactory());
        loader.setLocation(Main.class.getResource(fxml));
        AnchorPane page;
        try {
            page = (AnchorPane) loader.load(in);
              page.setOnMousePressed((MouseEvent event) -> {
                  xOffset=event.getSceneX();
                  yOffset=event.getSceneY();
            });
        page.setOnMouseDragged((MouseEvent event) -> {
            if (event.getButton() != MouseButton.MIDDLE) {
                page.getScene().getWindow().setX(event.getScreenX() - xOffset);
                page.getScene().getWindow().setY(event.getScreenY() - yOffset);
            }
            });
        } finally {
            in.close();
        } 
        if("login.fxml".equals(fxml)){
        scene = new Scene(page, 500, 500);
        }
        else{
         scene = new Scene(page, 1250, 650);
        }
        
        
        stage.setScene(scene);
        stage.sizeToScene();
        
        return (Initializable) loader.getController();
    }
    public void Minimized(){
    }

}
