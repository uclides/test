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
public class Tst {
    public SimpleStringProperty nt,rt,it;

public Tst(String snt,String srt,String sit){
this.nt=new SimpleStringProperty(snt);
this.rt=new SimpleStringProperty(srt);
this.it=new SimpleStringProperty(sit);
}
public String getNt(){
return nt.get();
}
public void setNt(String fnt){
nt.set(fnt);
}
public String getRt(){
return rt.get();
}
public void setRt(String frt){
rt.set(frt);
}
public String getIt(){
return it.get();
}
public void setIt(String fit){
it.set(fit);
}
}
