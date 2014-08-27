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
import com.google.gson.Gson;
import java.io.EOFException;
import java.io.File;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.core.ZipFile;
public class files {
    
    
    public String GetNameFile(){
        File dir= new File("C:\\registerDevice");
        File[] filelist=dir.listFiles();
        String filename = null;
        if(!dir.isDirectory()){
            
            for(File file:filelist){
                filename=file.getName();
            }
        }
        else{
            System.out.println("empty directory");
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
