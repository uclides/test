/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo.tables;

import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author project
 */
public class Update {
    
   public SimpleStringProperty update;


  public Update(String supdate){ 

      this.update=new SimpleStringProperty(supdate);

  }
  public String getUpdate(){
  return update.get();
  }
  public void setUpdate(String fupdate){
  update.set(fupdate);
  }
}
