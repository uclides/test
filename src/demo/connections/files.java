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
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.lingala.zip4j.core.ZipFile;
import net.lingala.zip4j.exception.ZipException;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.LineIterator;
public class files implements GenericInterface{
      int val=0;
    adb adb =new adb();
    public String GetNameFile(){
        File dir= new File(folderegister);
        File[] filelist=dir.listFiles();
        String filename = null;
        if(dir.exists()){
            
            for(File file:filelist){
                filename=file.getName();
            }
        }
        else{
            System.out.println(emptyd);
           
        }
        return filename;
    }
    public boolean unZip(){
        try{
        ZipFile zipFile= new ZipFile(folderegister+GetNameFile());
        File file= new File(folderegister+GetNameFile());
        zipFile.extractAll(folderegister);
        FileUtils.deleteQuietly(file);
        }
        catch(ZipException e){
            return true;
        }
        
        return false;
    
    }
    public boolean checkDir(String dir,String extension){
        File file=new File(dir);
        String ext;
        if(file.isDirectory()&& file.list().length>0 &&((extension).equals(FilenameUtils.getExtension(folderegister+GetNameFile())))){
             System.out.println("HAY UN TXT DISPONIBLE");
            return true;         
        }
            else{
            return false;
        }
    }
    public List<String> FileToArray(){
        List<String> items=new ArrayList<>();
try {
    
//        FileInputStream inputStream = null;
//        try {
//            DataInputStream dataInputStream; 
//            BufferedReader bufferedReader;
//            inputStream = new FileInputStream(folderegister+GetNameFile());
//            List<String> items=new ArrayList<>();
//            dataInputStream = new DataInputStream(inputStream);
//            bufferedReader = new BufferedReader(new InputStreamReader(dataInputStream));
//            String str_line;
//            while(!"null".equals(str_line=bufferedReader.readLine())){
//                str_line=str_line.trim();
//                if((str_line.length()!=0)){
//                    items.add(str_line);
//                    System.out.println(str_line);
//                }
//                
//            }
//        } catch (IOException ex) {
//            Logger.getLogger(files.class.getName()).log(Level.SEVERE, null, ex);
//        } finally {
//            try {
//                inputStream.close();
//            } catch (IOException ex) {
//                Logger.getLogger(files.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
    
    File file=new File(folderegister+GetNameFile());
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

    public String[] ParseValues(String list){
String[] out = new String[100],finalout=null;        
String line = null;
int x,initdetected = 1,endetected = 1,temp=0,iterator=0,val=0;
List<String> values= FileToArray();


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
         String[] exit=ParseValues(section);
         String[]sal=new String[exit.length];
          System.arraycopy(exit, 0, sal, 0, exit.length);            
            
            return sal;
}
      @SuppressWarnings("null")
    public String[] PushInfoExt(String section){
         String[] exit=ParseValues(section);
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
         String[] exit=ParseValues(section);
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
         String[] exit=ParseValues(section);
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
         String[] exit=ParseValues(section);
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

        public String[] PushInfoOthers(String section){
         String[] exit=ParseValues(section);
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
         String[] exit=ParseValues(section);
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
      
    
}



