/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo.tables;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;



/**
 *
 * @author project
 */
public class Chart {
    public SimpleBooleanProperty bd;
    public SimpleStringProperty nd;

public Chart(String snd){
    this.bd=new SimpleBooleanProperty(false);
    this.nd=new SimpleStringProperty(snd);
}
public Boolean getBd(){
return bd.get();
}
public void setBd(Boolean fbd){
bd.set(fbd);
}
public String getNd(){
return nd.get();
}
public void setNd(String fnd){
nd.set(fnd);
}
 public BooleanProperty bdProperty() {
      return bd;
    }
}

