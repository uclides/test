
package demo.tables;

import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author project
 */
public class App {

   public SimpleStringProperty detect;


  public App(String sdetect){ 

      this.detect=new SimpleStringProperty(sdetect);

  }
  public String getDetect(){
  return detect.get();
  }
  public void setDetect(String fdetect){
  detect.set(fdetect);
  }

}

