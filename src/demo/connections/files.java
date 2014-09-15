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
import com.sun.deploy.util.StringUtils;
import demo.GenericInterface;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import net.lingala.zip4j.core.ZipFile;
import net.lingala.zip4j.exception.ZipException;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.LineIterator;
public class files implements GenericInterface{
    
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
        zipFile.extractAll(folderegister);
        }
        catch(ZipException e){
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
String[] out = null;        
String line = null;
int x,initdetected = 1,endetected = 1,temp=0;
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
if(line.contains("####################")){
    endetected=y;
    break;
}
}
for(int z=initdetected;z<endetected;z++){
   out=new String[endetected];
//System.out.println(line=values.get(z).replaceAll(removefile,""));
out[z]=line=values.get(z);
System.out.println(out[z]);
}
       return out;
    }
}



