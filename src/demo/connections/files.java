package demo.connections;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *i
 * @author Uclides Gil
 */
import demo.GenericInterface;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.TextArea;
import javax.swing.text.TableView;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import net.lingala.zip4j.core.ZipFile;
import net.lingala.zip4j.exception.ZipException;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.LineIterator;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
public class files implements GenericInterface{
      int val=0;
      String string;
          String cadena="",temp="",error=null;
String[] result;
    adb adb =new adb();    

    public String GetNameFile(String folder){
        File dir= new File(folder);
        File[] filelist=dir.listFiles();
        String filename = null;
        if(dir.exists()){
            
            for(File file:filelist){
                filename=file.getName();
            }
            return filename;
        }
        else{
            System.out.println(emptyd);
           
        }
        return null;
    }
    public String[] GetNameVariousFile(String folder){
        File dir= new File(folder);
        File[] filelist=dir.listFiles();
        String[] number;
        String filename = null;
        if(dir.exists()){
            number=new String[filelist.length];
            for(int y=0;y<filelist.length;y++){
                number[y]=filelist[y].getName();
            }
            return number;
        }
        else{
            System.out.println(emptyd);
           
        }
        return null;
    }
    public boolean unZip(){
        try{
        ZipFile zipFile= new ZipFile(folderegister+GetNameFile(folderegister));
        File file= new File(folderegister+GetNameFile(folderegister));
        zipFile.extractAll(folderegister);
        FileUtils.deleteQuietly(file);
        File file2= new File(folderegister+GetNameFile(folderegister));
          removeEmptyLine(folderegister+GetNameFile(folderegister));
        }
        catch(ZipException e){
            return true;
        } catch (IOException ex) {
              Logger.getLogger(files.class.getName()).log(Level.SEVERE, null, ex);
          }
       
        return false;
    
    }
    public boolean checkDir(String dir,String extension){
        File file=new File(dir);
        String ext;
        if(file.isDirectory()&& file.list().length>0 &&((extension).equals(FilenameUtils.getExtension(folderegister+GetNameFile(folderegister))))){
             System.out.println("HAY UN TXT DISPONIBLE");
            return true;         
        }
            else{
            return false;
        }
    }
    public List<String> FileToArray(String path,String name){
        List<String> items=new ArrayList<>();
        
try {

    File file=new File(path+name);
    LineIterator it = FileUtils.lineIterator(file, "UTF-8");
    try {
        while (it.hasNext()) {

            String line = it.nextLine();
            items.add(line);
            //System.out.println(line);
            // do something with line
        }
    } finally {
        LineIterator.closeQuietly(it);
    }
} catch (IOException ex) {
            Logger.getLogger(files.class.getName()).log(Level.SEVERE, null, ex);
        }
        return items;
        }     
    public List<String> FileToArray2(String path,String name,TextArea a,Label l,ProgressIndicator p){
        List<String> items=new ArrayList<>();
Thread hilo=new Thread(new Runnable() {
    @Override public void run() {
 
            Platform.runLater(new Runnable() {
                @Override public void run() {
  
try {

    File file=new File(path+name);
    LineIterator it = FileUtils.lineIterator(file, "UTF-8");
    try {
        while (it.hasNext()) {
            String line = it.nextLine();
            items.add(line);
            a.appendText(line+"\n");
            //System.out.println(line);
            // do something with line
        }
    } finally {
        l.setVisible(false);
        p.setVisible(false);
        LineIterator.closeQuietly(it);
    }
} catch (IOException ex) {
            Logger.getLogger(files.class.getName()).log(Level.SEVERE, null, ex);
        }
                }
            });
        
    }
});
hilo.setDaemon(true);
hilo.start();
        return items;
        }     
    public String[] ParseValues(String list,String folder,String name){
String[] out = new String[1000],finalout=null;        
String line = null;
int x,initdetected = 1,endetected = 1,temp=0,iterator=0,val=0;
List<String> values= FileToArray(folder,name);
//List<String> values= FileToArray(folderegister,GetNameFile(folderegister));

for(x=0;x< values.size();x++){
line=values.get(x);
if(line.contains(list)){
    initdetected=x;
    break;
}
}
for(int y=initdetected;y<=values.size();y++){
line=values.get(y);
iterator++;
if(line.contains("####################")){
    endetected=y;
    break;
}
}
for(int z=initdetected;z<endetected;z++){
 ///  out=new String[endetected];
//System.out.println(line=values.get(z).replaceAll(removefile,""));
out[val]=line=values.get(z).replaceAll(removefile,"");
//System.out.println(out[z]);
//System.out.println(out.length);
val++;
}
       return out;
    }
    public String[] ParseValues2(String list,String folder,String name){
String[] out = new String[1000],finalout=null;        
String line = null;
int x,initdetected = 1,endetected = 1,temp=0,iterator=0,val=0;
List<String> values= FileToArray(folder,name);
//List<String> values= FileToArray(folderegister,GetNameFile(folderegister));

for(x=0;x< values.size();x++){
line=values.get(x);
if(line.contains(list)){
    initdetected=x;
    break;
}
}
for(int y=initdetected;y<=values.size();y++){
line=values.get(y);
iterator++;
if(line.contains("####################")){
    endetected=y;
    break;
}
}
for(int z=initdetected;z<endetected;z++){
 ///  out=new String[endetected];
//System.out.println(line=values.get(z).replaceAll(removefile,""));
out[val]=line=values.get(z);
//System.out.println(out[z]);
//System.out.println(out.length);
val++;
}
       return out;
    }
    public String[] splitString(String[]inStrings){
        String[] array = new String[inStrings.length];
        int val=0;
     for (String out1 : inStrings) {
    if (out1 != null) {
        String[] salida = out1.split(", ");
        for (String salida1 : salida) {
           // System.out.println(salida1);
        array[val]=salida1;
        val++;
        }
    }
}   
    return array;
    }
    public String[] PushInfoBasic(String section){
         String[] exit=ParseValues(section,folderegister,GetNameFile(folderegister));
         String[]sal=new String[exit.length];
          System.arraycopy(exit, 0, sal, 0, exit.length);            
            
            return sal;
}
    @SuppressWarnings("null")
    public String[] PushInfoExt(String section){
         String[] exit=ParseValues(section,folderegister,GetNameFile(folderegister));
         String[]sal=new String[exit.length];
          for (int y =0;y<exit.length;y++) {
              String exit1=exit[y];
              if(exit1==null || exit1.contains(section)){
              }
              else{
                  if(exit1.contains("Información no disponible")){
                  sal="Información no disponible,Información no disponible".split(",");
                  }
                  else{
                  sal=exit1.split(", ");
                  }
                  }
          }
            
            return sal;
}
    public String[] PushInfoA2SD(String section){
         String[] exit=ParseValues(section,folderegister,GetNameFile(folderegister));
         String[]sal=new String[exit.length];
          for (int y =0;y<exit.length;y++) {
              String exit1=exit[y];
              if(exit1==null || exit1.contains(section)){
              }
              else{
                  if(exit1.contains("Información no disponible")){
                  sal="Información no disponible,Información no disponible".split(",");
                  }
                  else{
                  sal=exit1.split(", ");
                  }
                  }
          }
            
            return sal;
}
    public String[] PushInfoDisplay(String section){
         String[] exit=ParseValues(section,folderegister,GetNameFile(folderegister));
         String[]sal=new String[exit.length];
          for (int y =0;y<exit.length;y++) {
              String exit1=exit[y];
              if(exit1==null || exit1.contains(section)){
              }
              else{
                  sal[y]=exit1;
              }
          }
            
            return sal;
}   
    public String[] PushInfoImgGeneric(String section){
         String[] exit=ParseValues(section,folderegister,GetNameFile(folderegister));
         String[]sal=new String[exit.length];
          for (int y =1;y<exit.length;y++) {
              String exit1=exit[y];
              if(exit1==null || exit1.contains(section)){
              }
              else{
                  sal[y]=exit1;
              }
          }
         
            return sal;
} 
    public String[] PushInfoApp(String section){
         String[] exit=ParseValues2(section,folderegister,GetNameFile(folderegister));
         String[]sal=new String[exit.length];
          for (int y =1;y<exit.length;y++) {
              String exit1=exit[y];
              if(exit1==null || exit1.contains(section)){
              }
              else{
                  sal[y]=exit1.split("<")[0];
              }
          }
         
            return RemoveNullValue2(sal);
} 
    public String[] PushInfoOthers(String section){
         String[] exit=ParseValues(section,folderegister,GetNameFile(folderegister));
         String[]sal=new String[exit.length];
          for (int y =0;y<exit.length;y++) {
              String exit1=exit[y];
              if(exit1==null || exit1.contains(section)){
              }
              else{
                  sal[y]=exit1;
              }
          }
            
            return sal;
}
    public String[] PushInfoCam(String section){
         String[] exit=ParseValues(section,folderegister,GetNameFile(folderegister));
         String[]sal=new String[exit.length];
          for (int y =0;y<exit.length;y++) {
              String exit1=exit[y];
              if(exit1==null || exit1.contains(section)){
              }
              else{
                  sal[y]=exit1;
              }
          }
            
            return sal;
}
    public String[] RemoveNullValue(String[] val) {
  
    List<String> list = new ArrayList<String>();

    for(String s : val) {
       if(s != null) {
          list.add(s);
       }
    }

    val = list.toArray(new String[list.size()+1]);

          return val;
  }
    public String[] RemoveNullValue2(String[] val) {
  
    List<String> list = new ArrayList<String>();

    for(String s : val) {
       if(s != null) {
          list.add(s);
       }
    }

    val = list.toArray(new String[list.size()]);

          return val;
  }
    public void removeEmptyLine(String file) throws IOException{
    
BufferedReader br= new BufferedReader(new FileReader(file));
        String line;String input = "";
        while((line=br.readLine())!=null){
            if(line.length()>0){
        input+=line+"\n";
            }
        }
        FileOutputStream fos=new FileOutputStream(file);
        fos.write(input.getBytes());
} 
    public void getValueColumn(TableView tv){

}    
    public String getValueCb(ComboBox cb){
    String selected = cb.getValue().toString();
          return selected;
}
    public String[] getValueMI(MenuButton mb){
String[] menui=new String[20];
int y = 0;
            for(MenuItem item : mb.getItems()) {
                CheckMenuItem checkMenuItem = (CheckMenuItem) item;
                if(checkMenuItem.isSelected()) {
                    menui[y]=checkMenuItem.getText();
                }
                y++;
            } 
    
    return RemoveNullValue2(menui);
}
    public List<String> readXml (String path) throws ParserConfigurationException{
    List<String> items=new ArrayList<>();
    File fXmlFile = new File(path);
    DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
    DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
    Document doc = null;
    try {
        doc = dBuilder.parse(fXmlFile);
    } catch (SAXException | IOException e) {
    }

    doc.getDocumentElement().normalize();

    System.out.println("Root element :" + doc.getDocumentElement().getNodeName());

    NodeList nList = doc.getElementsByTagName("item");

    System.out.println("----------------------------");

    for (int temp = 0; temp < nList.getLength(); temp++) {

        Node nNode = nList.item(temp);

        System.out.println("\nCurrent Element :" + nNode.getNodeName());

        if (nNode.getNodeType() == Node.ELEMENT_NODE) {

            Element eElement = (Element) nNode;

            items.add(eElement.getElementsByTagName("score").item(0).getTextContent());
//            System.out.println("Description : " + eElement.getElementsByTagName("description").item(0).getTextContent());
//            System.out.println("price : " + eElement.getElementsByTagName("price").item(0).getTextContent());
//            System.out.println("base qty : " + eElement.getElementsByTagName("base_qty").item(0).getTextContent());
//            System.out.println("Var qty : " + eElement.getElementsByTagName("var_qty").item(0).getTextContent());
//            System.out.println("Base price : " + eElement.getElementsByTagName("base_price_").item(0).getTextContent());                

        }
    }
          return items;
}
    public String oneString(String[] array){
        String[] value=RemoveNullValue2(array);
        String s = "";
        for(String val:value){
            s+=val+";";
        }
          return s;
    }
    public int booleanToint(String e,String v){
        if(e.equals(v)){
            return 1;
        }
        else{
            return 0;
        }
    }

}




