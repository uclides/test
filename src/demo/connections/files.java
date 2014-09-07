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
import net.lingala.zip4j.core.ZipFile;
import net.lingala.zip4j.exception.ZipException;
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
    public boolean unZip(String path,String outpath){
        try{
        ZipFile zipFile= new ZipFile(path);
        zipFile.extractAll(outpath);
        }
        catch(ZipException e){
        e.printStackTrace();
        }
        
        return false;
    
    }
    
}
