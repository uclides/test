/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo;

import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author project
 */
public class App {

   public final SimpleStringProperty nameapp,toinstallapp,toserverapp;


  App(String snameapp,String stoinstallapp,String stoserverapp){    


      this.nameapp=new SimpleStringProperty(snameapp);
      this.toinstallapp=new SimpleStringProperty(stoinstallapp);
        this.toserverapp=new SimpleStringProperty(stoserverapp);
  }
  public String getNameApp(){
  return nameapp.get();
  }
  public void setNameApp(String fnameapp){
  nameapp.set(fnameapp);
  }
  public String getToInstallApp(){
  return toinstallapp.get();
  }
  public void setToInstallApp(String ftoinstallapp){
  toinstallapp.set(ftoinstallapp);
  }
    public String getToServerApp(){
  return toserverapp.get();
  }
  public void setToServerApp(String ftoserverapp){
  toserverapp.set(ftoserverapp);
  }


}
