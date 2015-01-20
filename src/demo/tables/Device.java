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
public class Device {
    public SimpleStringProperty item,device;

public Device(String sitem,String sdevice){
this.item=new SimpleStringProperty(sitem);
this.device=new SimpleStringProperty(sdevice);
}
public String getItem(){
return item.get();
}
public void setItem(String fitem){
item.set(fitem);
}
public String getDevice(){
return device.get();
}
public void setDevice(String fdevice){
device.set(fdevice);
}
public SimpleStringProperty deviceProperty() {
    return this.device;
}

}
