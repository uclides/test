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
import com.sun.deploy.association.utility.AppUtility;
import demo.GenericInterface;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.lingala.zip4j.core.ZipFile;
import net.lingala.zip4j.exception.ZipException;
import org.apache.commons.io.FilenameUtils;
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
    public String[] FileToArray(){
        FileInputStream inputStream=null;
        try {
            String[] values=null;
            List<String> items=new ArrayList<String>();
            inputStream = new FileInputStream("");
            DataInputStream dataInputStream=new DataInputStream(inputStream);
            BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(dataInputStream));
            String str_line;
            while(!"null".equals(str_line=bufferedReader.readLine())){
                str_line=str_line.trim();
                if((str_line.length()!=0)){
                
                }
            }
            return null;
        } catch (FileNotFoundException ex) {
            Logger.getLogger(files.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(files.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                inputStream.close();
            } catch (IOException ex) {
                Logger.getLogger(files.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
}
}
