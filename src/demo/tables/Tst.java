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
    public SimpleStringProperty nt,rt,it,it1,it2,it3,it4;

public Tst(String snt,String srt,String sit,String sit1,String sit2,String sit3,String sit4){
this.nt=new SimpleStringProperty(snt);
this.rt=new SimpleStringProperty(srt);
this.it=new SimpleStringProperty(sit);
this.it1=new SimpleStringProperty(sit1);
this.it2=new SimpleStringProperty(sit2);
this.it3=new SimpleStringProperty(sit3);
this.it4=new SimpleStringProperty(sit4);
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
public String getIt1(){
return it1.get();
}
public void setIt1(String fit1){
it1.set(fit1);
}
public String getIt2(){
return it2.get();
}
public void setIt2(String fit2){
it2.set(fit2);
}
public String getIt3(){
return it3.get();
}
public void setIt3(String fit3){
it3.set(fit3);
}
public String getIt4(){
return it4.get();
}
public void setIt4(String fit4){
it4.set(fit4);
}
}
