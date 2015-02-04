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
public class Mant {
    public SimpleStringProperty mant1,mant2,mant3,mant4,mant5;
    
public Mant(String smant1,String smant2,String smant3,String smant4,String smant5){
this.mant1=new SimpleStringProperty(smant1);
this.mant2=new SimpleStringProperty(smant2);
this.mant3=new SimpleStringProperty(smant3);
this.mant4=new SimpleStringProperty(smant4);
this.mant5=new SimpleStringProperty(smant5);

}
public String getMant1(){
return mant1.get();
}
public void setMant1(String fmant1){
mant1.set(fmant1);
} 
public String getMant2(){
return mant2.get();
}
public void setMant2(String fmant2){
mant2.set(fmant2);
}
public String getMant3(){
return mant3.get();
}
public void setMant3(String fmant3){
mant3.set(fmant3);
}
public String getMant4(){
return mant4.get();
}
public void setMant4(String fmant4){
mant4.set(fmant4);
}
public String getMant5(){
return mant5.get();
}
public void setMant5(String fmant5){
mant5.set(fmant5);
}

}
