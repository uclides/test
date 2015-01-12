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
public class Fail {
        public SimpleStringProperty uf,nf,df,imgf;

public Fail(String suf,String snf,String sdf,String simf){
this.uf=new SimpleStringProperty(suf);
this.nf=new SimpleStringProperty(snf);
this.df=new SimpleStringProperty(sdf);
this.imgf=new SimpleStringProperty(simf);
}
public String getUf(){
return uf.get();
}
public void setUf(String fnt){
uf.set(fnt);
}
public String getNf(){
return nf.get();
}
public void setNf(String frt){
nf.set(frt);
}
public String getDf(){
return df.get();
}
public void setDf(String fit){
df.set(fit);
}
public String getImgf(){
return imgf.get();
}
public void getImgf(String fimt){
imgf.set(fimt);
}
}
