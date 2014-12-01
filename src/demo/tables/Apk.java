
package demo.tables;

import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author project
 */
public class Apk {

   public SimpleStringProperty apk;


  public Apk(String sapk){ 

      this.apk=new SimpleStringProperty(sapk);

  }
  public String getApk(){
  return apk.get();
  }
  public void setApk(String fapk){
  apk.set(fapk);
  }

}

