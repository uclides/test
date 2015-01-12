/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo;

import demo.connections.files;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputControl;
import javafx.scene.input.KeyEvent;

/**
 *
 * @author project
 */
public class Controls {
    files files=new files();
   public String[][]values=new String[20][20];
   public Controls(){
   
   }

        public void validateTextFile(TextField textField,Label lbl){
    
        textField.setOnKeyTyped(new EventHandler<KeyEvent>(){

          @Override
          public void handle(KeyEvent event) {
              String valtxt=((TextInputControl)event.getTarget()).getText();
              if(valtxt.length()<0||valtxt.isEmpty()){
                  ((Node)event.getTarget()).setStyle("-fx-border-color: red");
              }
              else{
              ((Node)event.getTarget()).setStyle("-fx-border-color: null");
              lbl.setText("");
              }
          }
        });
    }
        public EventHandler<KeyEvent> numericValidation(final Integer maxlengh){
            return new EventHandler<KeyEvent>() {

                @Override
                public void handle(KeyEvent event) {
                    TextField tf=(TextField)event.getSource();
                        if(tf.getText().length()>=maxlengh){
                            event.consume();
                        }
                        if(event.getCharacter().matches("[0-9|.]*")){
                            if(tf.getText().contains(".")&& event.getCharacter().matches("[.]")){
                                event.consume();
                            }
                            else if(tf.getText().length()==0&&event.getCharacter().matches("[.]")){
                                event.consume();
                            }
                        }
                        else{
                            event.consume();
                        }
                }
            };
        }
        public String[][] getInfoTabComp(Label ls,TextField[] tfses,MenuButton[] mbs,ComboBox[] cbs,ColorPicker cp){
    
        int w = 0,x = 0,y = 0,z=0;
       if("".equals(tfses[0].getText()) ||"".equals(tfses[1].getText())||"".equals(tfses[2].getText())
          ||"".equals(tfses[3].getText())||"".equals(tfses[4].getText()))
       {ls.setText("Existen campos vacios, ingrese información correspondiente");}
       else{
       values[0][0]=tfses[0].getText();
       values[1][0]=tfses[1].getText();
       values[2][0]=tfses[2].getText();
       for(String val:returnMenuItem(mbs[0])){ 
       values[3][w]=val;
       w++;
       }
       values[4][0]="#"+Integer.toHexString(cp.getValue().hashCode()).substring(0, 6).toUpperCase();
       for(String val:returnMenuItem(mbs[1])){ 
       values[5][x]=val;
       x++;
       }
       for(String val:returnMenuItem(mbs[2])){ 
       values[6][y]=val;
       y++;
       }
       values[7][0]=files.getValueCb(cbs[0]);
       values[8][0]=files.getValueCb(cbs[1]);
       values[9][0]=tfses[3].getText();
       values[10][0]=files.getValueCb(cbs[2]);
       values[11][0]=files.getValueCb(cbs[3]);
       values[12][0]=tfses[4].getText();
              for(String val:returnMenuItem(mbs[3])){ 
       values[13][z]=val;
       z++;
       }
       values[14][0]=files.getValueCb(cbs[4]);
       values[15][0]=files.getValueCb(cbs[5]);
       values[16][0]=tfses[5].getText();
       
//       for(String[] valu:values){
//       System.out.println(Arrays.toString(valu));
//       }
           for (String[] value1 : values) {
               for (String value : value1) {
                   if(value!=null){
                   System.out.println(value);
                   }
               }
           }
       }
    return values;
      

           
    }
        public String[] returnMenuItem(MenuButton mb){
            String array[]=new String [20];
            int y=0;
            for(String mi:files.getValueMI(mb)){
            array[y]=mi;
            y++;
            }
            return array;
        }
}
