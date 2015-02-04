/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reports;

import demo.GenericInterface;
import demo.connections.files;
import demo.connections.server;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javax.imageio.ImageIO;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.util.JRLoader;

/**
 *
 * @author project
 */
public class Reports implements GenericInterface{
     JasperReport jasperReport;
    server s=new server();
    JasperCompileManager jasperCompileManager;
    files f=new files();
    List<Map<String, Object>> ParamList = new ArrayList<>();
    List<File> filesreport = new ArrayList<>();
    JasperPrint jasperPrint1,jasperPrint2,jasperPrint3,jasperPrint4,jasperPrint5,jasperPrint6,jasperPrint7;
public Reports(){
 

}

public Map<String, Object> generateParams(String[] infobasic,String[] infosuppor,
        String[] infomobile,String[] infowf,String[] infocpu,String[] infodis,String[] infocam1,
        String[] infobat,String[] infomat,String[] infimgdev,String[] infimgtest,String[]infimgfail,String[]infimgdesfail,String despos,String desneg,List<String> lista,String[] txtlista){
    Map <String,Object> parameters = new HashMap<>(); 
    String value;
    String []array;
    java.util.Date utilDate = new java.util.Date();
    String temp="";
    for(String it:infobasic){
                 value=s.ConsultforUIString("select "+it+" as t from device where id_device='SP-5110'","t");
    parameters.put(it,value);
    }
    value=s.ConsultforUIString("select type_blu as t from bluetooth where id_blu in(select id_blu from device where id_device='SP-5110')", "t");
    parameters.put("type_blu",value); 
    
    for(String ite:infosuppor){
                 value=s.ConsultforUIString("select other_support.name_sup as t from other_support,device_support where name_sup='"+ite+"' and other_support.id_sup=device_support.id_sup and id_dev in(select id_device from device,device_support where id_device=id_dev and id_device='SP-5110')","t");
                 if(value == null){
     parameters.put(ite,"no disponible");
    }
    else{
    parameters.put(ite,"soportado");
    }           
    }
    for(String ite2:infomobile){
                 value=s.ConsultforUIString("select val_net as t from device,device_network,network where type_net='mobile' and val_net='"+ite2+"' and id_device=id_dev and id_net=net_dev and id_device='SP-5110'","t");
                 if(value == null){
     parameters.put(ite2,"no disponible");
    }
    else{
    parameters.put(ite2,"soportado");
    }           
    }
    for(String ite2:infowf){
                 value=s.ConsultforUIString("select val_net as t from device,device_network,network where type_net='wifi' and val_net='"+ite2+"' and id_device=id_dev and id_net=net_dev and id_device='SP-5110'","t");
                 if(value == null){
     parameters.put(ite2,"no disponible");
    }
    else{
    parameters.put(ite2,"soportado");
    }           
    }
    for(String ite2:infocpu){
                 value=s.ConsultforUIString("select "+ite2+" as t from cpu,device_cpu,device where id_cpu=id_cpu_c and id_device=id_dev_cpu and id_device='SP-5110'","t");            
     parameters.put(ite2,value);          
    }
    for(String ite2:infodis){
                 value=s.ConsultforUIString("select "+ite2+" as t from display,display_tactil,display_type,device where id_device=i_dev and id_dis=id_type_dis and type_tac=id_tactil and id_device='SP-5110'","t");            
     parameters.put(ite2,value);          
    }
    for(String ite2:infocam1){
                 value=s.ConsultforUIString("select "+ite2+" as t from device_cam,device where type_cam='primary' and id_device=id_dev_cam and id_device='SP-5110'","t");            
     parameters.put(ite2,value);          
    }
    for(String ite2:infocam1){
                 value=s.ConsultforUIString("select "+ite2+" as t from device_cam,device where type_cam='secundary' and id_device=id_dev_cam and id_device='SP-5110'","t");            
     ite2+="1";
                 parameters.put(ite2,value);          
    }
    for(String ite2:infobat){
                 value=s.ConsultforUIString("select "+ite2+" as t from battery,device,device_battery where id_device=id_dev_b and battery.id_bat=device_battery.type_bat and id_device='SP-5110'","t");            

                 parameters.put(ite2,value);          
    }
    for(String ite2:infomat){
        
                 value=s.ConsultforUIString("select name_mat as t from material,device_mat,device where name_mat='"+ite2+"' and id_dev_mat = id_device and id_mat=id_mate and id_device='SP-5110'","t");            
      if(value == null){

    }
    else{
   temp+=value+";";
    }           
                          
    }
if(!lista.isEmpty()){
    /////////////////////////////
for(int v=0;v<lista.size();v++){
    parameters.put(txtlista[v],lista.get(v));
}
}
    
 array=s.ConsultforUIArray("select file_img as t from image,device where type_img='dispositivo' and id_dev=id_device and id_dev='SP-5110'","t");            

        for(int r=0;r<array.length;r++){
        
      if(array[r] == null){

    }
    else{
    value=array[r].replaceAll("file:", "").trim();
    String url =value.replaceAll("[/]+", "\\\\\\\\").trim();
    BufferedImage image;
         try {
             image = ImageIO.read(new File(url).getAbsoluteFile());
         parameters.put(infimgdev[r], image );
         } catch (IOException ex) {
             Logger.getLogger(Reports.class.getName()).log(Level.SEVERE, null, ex);
         }
    }           
                          
    }
         array=s.ConsultforUIArray("select file_img as t from image,device where type_img='test' and id_dev=id_device and id_dev='SP-5110'","t");            

        for(int r=0;r<array.length;r++){
        
      if(array[r] == null){

    }
    else{
    value=array[r].replaceAll("file:", "").trim();
    String url =value.replaceAll("[/]+", "\\\\\\\\").trim();
    BufferedImage image;
         try {
             image = ImageIO.read(new File(url).getAbsoluteFile());
         parameters.put(infimgtest[r], image );
         } catch (IOException ex) {
             Logger.getLogger(Reports.class.getName()).log(Level.SEVERE, null, ex);
         }
    }           
                          
    }
         array=s.ConsultforUIArray("select file_img as t from image,device where type_img='falla' and id_dev=id_device and id_dev='SP-5110'","t");            

        for(int r=0;r<array.length;r++){
      if(array[r] == null){

    }
    else{
    String idming=s.ConsultforUIString("select id_image as t from image,device,device_failure where id_image= id_img_fail and type_img='falla' and id_device=image.id_dev and id_device=device_failure.id_dev and file_img='"+array[r]+"'", "t");
    String desc=s.ConsultforUIString("select name_fail as t from device_failure where id_img_fail="+idming, "t");
    value=array[r].replaceAll("file:", "").trim();
    String url =value.replaceAll("[/]+", "\\\\\\\\").trim();
    BufferedImage image;
         try {
             image = ImageIO.read(new File(url).getAbsoluteFile());
         parameters.put(infimgfail[r], image );
         parameters.put(infimgdesfail[r], desc );
         } catch (IOException ex) {
             Logger.getLogger(Reports.class.getName()).log(Level.SEVERE, null, ex);
         }
    }           
                          
    }
    parameters.put("name_mat",temp); 
    parameters.put("color",s.ConsultforUIString("select color as t from device where id_device='SP-5110'", "t"));
    parameters.put("name_provider",s.ConsultforUIString("select name_provider as t from provider,device,device_provider where id_device=id_dev_prov and id_provider=id_prov and id_device='SP-5110'", "t"));
    parameters.put("datecreate",utilDate);
    parameters.put("Positive",despos);
    parameters.put("Negative",desneg);
    
        
return parameters;
}  

public Runnable unitedReport(String path,String[] datareport,Button[] buttons,List<String> valuesdevice,String[]paramasvalues,Label label,TextArea[] tfs){
         try {
             ParamList.add(generateParams(valRepGe,valRepOherS,valRepMob,valRepWf,valRepcpu,valRepdis,valRepcam,
                     valRepbat,valRepmat,valRepimgdev,valRepimgtest,valRepimgfail,valRepdesimgfail,datareport[2],datareport[3],
                     valuesdevice,paramasvalues));
             Map<String, Object> parameters = ParamList.get(0);
             filesreport.add(new File("C:\\Users\\project\\Documents\\GitHub\\test\\src\\reports\\test.jasper"));
             filesreport.add(new File("C:\\Users\\project\\Documents\\GitHub\\test\\src\\reports\\test_1.jasper"));
             filesreport.add(new File("C:\\Users\\project\\Documents\\GitHub\\test\\src\\reports\\test_2.jasper"));
             filesreport.add(new File("C:\\Users\\project\\Documents\\GitHub\\test\\src\\reports\\test_3.jasper"));
             filesreport.add(new File("C:\\Users\\project\\Documents\\GitHub\\test\\src\\reports\\test_4.jasper"));
             filesreport.add(new File("C:\\Users\\project\\Documents\\GitHub\\test\\src\\reports\\test_5.jasper"));
             filesreport.add(new File("C:\\Users\\project\\Documents\\GitHub\\test\\src\\reports\\test_6.jasper"));
//CreateReport(filesreport, ParamList);
             JasperReport jasperReport = (JasperReport) JRLoader.loadObject(filesreport.get(0).getAbsoluteFile());
             //Map<String, Object> parameters = parameters;
             jasperPrint1 = JasperFillManager.fillReport(jasperReport, parameters, s.getConnection());
             
                JasperReport jasperReport2 = (JasperReport) JRLoader.loadObject(filesreport.get(1).getAbsoluteFile());
             //Map<String, Object> parameters = parameters;
             jasperPrint2 = JasperFillManager.fillReport(jasperReport2, parameters, s.getConnection());
                JasperReport jasperReport3 = (JasperReport) JRLoader.loadObject(filesreport.get(2).getAbsoluteFile());
             //Map<String, Object> parameters = parameters;
             jasperPrint3 = JasperFillManager.fillReport(jasperReport3, parameters, s.getConnection());
             JasperReport jasperReport4 = (JasperReport) JRLoader.loadObject(filesreport.get(3).getAbsoluteFile());
             //Map<String, Object> parameters = parameters;
             jasperPrint4 = JasperFillManager.fillReport(jasperReport4, parameters, s.getConnection());
             JasperReport jasperReport5 = (JasperReport) JRLoader.loadObject(filesreport.get(4).getAbsoluteFile());
             //Map<String, Object> parameters = parameters;
             jasperPrint5 = JasperFillManager.fillReport(jasperReport5, parameters, s.getConnection());
             JasperReport jasperReport6 = (JasperReport) JRLoader.loadObject(filesreport.get(5).getAbsoluteFile());
             //Map<String, Object> parameters = parameters;
             jasperPrint6 = JasperFillManager.fillReport(jasperReport6, parameters, s.getConnection());
             
              JasperReport jasperReport7 = (JasperReport) JRLoader.loadObject(filesreport.get(6).getAbsoluteFile());
             //Map<String, Object> parameters = parameters;
             jasperPrint7 = JasperFillManager.fillReport(jasperReport7, parameters, s.getConnection());
             JRExporter exporter = new JRPdfExporter();
             try (FileOutputStream fileOutputStream = new FileOutputStream(path)) {
                 exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, fileOutputStream);
                 //The following is the important line
                 exporter.setParameter(JRExporterParameter.JASPER_PRINT_LIST, Arrays.asList(jasperPrint1, jasperPrint2,jasperPrint7,jasperPrint3,jasperPrint4,jasperPrint5,jasperPrint6));
                 exporter.exportReport();
                
                    int irep=s.ConsultforUIInt("select count(id_rep) as t from report","t");
                    irep++;
                    s.Addelement("insert into report values("+irep+",'"+datareport[0]+".pdf"+"','N/D','"+"file:C:/application/pdf/"+datareport[0]+".pdf"+"','pdf','"+datareport[1]+"')");
                    s.Addelement("insert into device_report values('"+datareport[0]+"',"+irep+")"); 
             String[]list=f.GetNameVariousFile("C:\\application\\pdf");
             for(String valid:list){
                 if(valid.contains(datareport[0])){
                     buttons[1].setVisible(false);
                 buttons[0].setVisible(true);
                 label.setText("Se ha creado informe correctamente");
                 tfs[0].setText("");tfs[1].setText("");
                 }
             }
             
             }
         } catch (JRException | FileNotFoundException ex) {
             Logger.getLogger(Reports.class.getName()).log(Level.SEVERE, null, ex);
         } catch (IOException ex) {
             Logger.getLogger(Reports.class.getName()).log(Level.SEVERE, null, ex);
         }
         return null;
      
}

}
