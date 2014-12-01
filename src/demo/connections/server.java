/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package demo.connections;
import demo.GenericInterface;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.TableColumn;
/**
 *
 * @author desarrollo06
 */
public class server implements GenericInterface{
    String url="jdbc:mysql://localhost:3306/";
    String dbName="dtb";
    String driver="com.mysql.jdbc.Driver";
    String userName="root";
    String password="";
    String nombre;
    Connection  conn;;
    Statement st;
    ResultSet resultSet;
    adb adb=new adb();
    public String error;
    String valueerror,u;
    files file=new files();
  public Task task;
  //////////////////////////////items table device////////////////////////////////////////
  String id_device,name_dev,model_dev,product_dev,trade_dev,provider_dev,ver_so,build_dev,locale_dev,kernel_dev,sto_ext_dev_t,sto_ext_dev_d,sto_s2sd_t,
          sto_s2sd_d,p_height_dev,p_width_dev,p_density_dev,p_size_dev,p_refresh_dev,whitebalance_cam,scene_mode_cam,stabilization_video,quality_img,quality_thumb,sta_flash,sto_inter_t,
          sto_inter_d,sto_sys_t,sto_sys_d,cache_sys_t,cache_sys_d,ram_t,ram_d,ram_i,type_cpu,frec_cpu,reds,feature_cpu,imple_cpu,arch_cpu,var_cpu,
          part_cpu,rev_cpu,hard_cpu,revision,serial_cpu,weight_dev,focus_mode,max_focus_area;
  String[][] firsttab=new String[5][200];
  int cp,n_cam_dev;
  //////////////////////////////items table Comp//////////////////////////////////////// 
  String h_dev,w_dev,bulk_dev,mat_dev,color_dev,blu_dev,type_pant,n_colors,tactil_dev,type_bat,provider,cert_google;
  String[] type_band=new String[10],type_wifi=new String[10],type_sensors=new String[20];
  
  
public ObservableList<String> user;
    public server() {
//        try {
//            this.conn = DriverManager.getConnection(url+dbName,userName,password);
//          
//        } catch (SQLException ex) {
//            adb.alertMessage(mesagges[2]);
//        }
}
    public int Consultation(String s){
         int result = 0;
        try {
            conn = DriverManager.getConnection(url+dbName,userName,password);
             st= conn.createStatement();
             resultSet=st.executeQuery(s);
            while(resultSet.next()){
                result= resultSet.getRow();
               
            }
            return result;
        } catch (SQLException ex) {
            adb.alertMessage(mesagges[2]); 
        }
        return 0;
}
    public ObservableList<String> getLogin(String name,String pass){
        ObservableList<String> attr=FXCollections.observableArrayList();
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd"); 
        try {
            conn = DriverManager.getConnection(url+dbName,userName,password);
            st=conn.createStatement();
            resultSet=st.executeQuery("select name_user,permission,avatar,sesion from user where name_user='"+name+"' and password='"+pass+"'");
            while(resultSet.next()){
                attr.add(resultSet.getString("name_user"));
                attr.add(Integer.toString(resultSet.getInt("permission")));
                attr.add(resultSet.getString("avatar"));
                attr.add(df.format(resultSet.getDate("sesion")));
                
            }
              user=attr;
              
        } catch (SQLException ex) {
            //Logger.getLogger(server.class.getName()).log(Level.SEVERE, null, ex);
            adb.alertMessage(mesagges[2]);
        }
      
      return attr;
    }
    public void generateInfoIdent(TableColumn columnitem,TableColumn columndesc){
    for(int i=0;i<columnitem.getTableView().getItems().size();i++){
    //System.out.println((String) columnitem.getCellData(i));
    switch((String) columnitem.getCellData(i)){
        case("Dispositivo"):
            name_dev=(String) columndesc.getCellData(i);
            System.out.println(name_dev);
            break;
        case("Modelo"):
            model_dev=(String) columndesc.getCellData(i);
            System.out.println(model_dev);
            break;    
        case("Producto"):
            product_dev=(String) columndesc.getCellData(i);
            System.out.println(product_dev);
            break;
        case("Marca"):
            trade_dev=(String) columndesc.getCellData(i);
            System.out.println(trade_dev);
            break;
        case("Release"):
            ver_so=(String) columndesc.getCellData(i);
            System.out.println(ver_so);
            break;
        case("Build"):
            build_dev=(String) columndesc.getCellData(i);
            System.out.println(build_dev);
            break;
        case("Locale"):
            locale_dev=(String) columndesc.getCellData(i);
            System.out.println(locale_dev);
            break;
        case("Kernel"):
            kernel_dev=(String) columndesc.getCellData(i);
            System.out.println(kernel_dev);
            break;
        case("Almacenamiento externo SD total"):
            sto_ext_dev_t=(String) columndesc.getCellData(i);
            System.out.println(sto_ext_dev_t);
            break;
        case("Almacenamiento externo SD Disponible"):
            sto_ext_dev_d=(String) columndesc.getCellData(i);
            System.out.println(sto_ext_dev_d);
            break;
        case("Almacenamiento A2SD total"):
            sto_s2sd_t=(String) columndesc.getCellData(i);
            System.out.println(sto_s2sd_t);
            break;
        case("Almacenamiento A2SD Disponible"):
            sto_s2sd_d=(String) columndesc.getCellData(i);
            System.out.println(sto_s2sd_d);
            break; 
        case("Pantalla Height"):
            p_height_dev=(String) columndesc.getCellData(i);
            System.out.println(p_height_dev);
            break;
        case("Pantalla Width"):
            p_width_dev=(String) columndesc.getCellData(i);
            System.out.println(p_width_dev);
            break;
        case("Pantalla density"):
            p_density_dev=(String) columndesc.getCellData(i);
            System.out.println(p_density_dev);
            break;
        case("Pantalla  size"):
            p_size_dev=(String) columndesc.getCellData(i);
            System.out.println(p_size_dev);
            break;
        case("Pantalla refresh rate"):
            p_refresh_dev=(String) columndesc.getCellData(i);
            System.out.println(p_refresh_dev);
            break;
        case("soporte resolución imagenes camara principal "):
            
            firsttab[0][i]=(String) columndesc.getCellData(i);
            System.out.println(firsttab[0][i]);
            break;
        case("soporte resolución video camara principal "):
            firsttab[1][i]=(String) columndesc.getCellData(i);
            System.out.println(firsttab[1][i]);
            break;
        case("soporte resolución imagenes camara secundaria "):
            firsttab[2][i]=(String) columndesc.getCellData(i);
            System.out.println(firsttab[2][i]);
            break;
        case("soporte resolución video camara secundaria "):
            firsttab[3][i]=(String) columndesc.getCellData(i);
            System.out.println(firsttab[3][i]);
            break;
        case("modo de foco cámara "):
            firsttab[4][i]=(String) (columndesc.getCellData(i));
            System.out.println(firsttab[4][i]);
            break;
        case("Focus mode"):
            focus_mode=(String) columndesc.getCellData(i);
            System.out.println(focus_mode);
            break;
        case("Max Num Focus Areas"):
            max_focus_area=(String) columndesc.getCellData(i);
            System.out.println(max_focus_area);
            break;
        case("Whitebalance Values"):
            whitebalance_cam+=(String) columndesc.getCellData(i)+"/";
            System.out.println(whitebalance_cam);
            break;
        case("Scene mode Values"):
            scene_mode_cam=(String) columndesc.getCellData(i);
            System.out.println(scene_mode_cam);
            break;
        case("Stabilization Video"):
            stabilization_video=(String) columndesc.getCellData(i);
            System.out.println(stabilization_video);
            break;
        case("Quality JPEG"):
            quality_img=(String) columndesc.getCellData(i);
            System.out.println(quality_img);
            break;
        case("Quality Thumbnail"):
            quality_thumb=(String) columndesc.getCellData(i);
            System.out.println(quality_thumb);
            break;
        case("numero de cámaras disponibles"):
            n_cam_dev=(int) columndesc.getCellData(i);
            System.out.println(n_cam_dev);
            break;
        case("estatus flash"):
            sta_flash=(String) columndesc.getCellData(i);
            System.out.println(sta_flash);
            break;
        case("Almacenamiento Interno Total"):
            sto_inter_t=(String) columndesc.getCellData(i);
            System.out.println(sto_inter_t);
            break;
        case("Almacenamiento Interno Disponible"):
            sto_inter_d=(String) columndesc.getCellData(i);
            System.out.println(sto_inter_d);
            break;
        case("Almacenamiento del Sistema Total"):
            sto_sys_t=(String) columndesc.getCellData(i);
            System.out.println(sto_sys_t);
            break;
        case("Almacenamiento del Sistema Disponible"):
            sto_sys_d=(String) columndesc.getCellData(i);
            System.out.println(sto_sys_d);
            break;
        case("Caché del Sistema Total"):
            cache_sys_t=(String) columndesc.getCellData(i);
            System.out.println(cache_sys_t);
            break;
        case("Caché del Sistema Disponible"):
            cache_sys_d=(String) columndesc.getCellData(i);
            System.out.println(cache_sys_d);
            break;
        case("Memoria RAM Total"):
            ram_t=(String) columndesc.getCellData(i);
            System.out.println(ram_t);
            break;
        case("Memoria RAM Disponible"):
            ram_d=(String) columndesc.getCellData(i);
            System.out.println(ram_d);
            break;
        case("Memoria RAM Idle"):
            ram_i=(String) columndesc.getCellData(i);
            System.out.println(ram_i);
            break;
        case("Tipo CPU"):
            type_cpu=(String) columndesc.getCellData(i);
            System.out.println(type_cpu);
            break;
        case("Frecuencia CPU"):
            frec_cpu=(String) columndesc.getCellData(i);
            System.out.println(frec_cpu);
            break;
        case("Red"):
            reds=(String) columndesc.getCellData(i);
            System.out.println(reds);
            break;
        case("Caracteristicas"):
            feature_cpu=(String) columndesc.getCellData(i);
            System.out.println(feature_cpu);
            break;
        case("CPU implementador"):
            imple_cpu=(String) columndesc.getCellData(i);
            System.out.println(imple_cpu);
            break;
        case("CPU arquitectura"):
            arch_cpu=(String) columndesc.getCellData(i);
            System.out.println(arch_cpu);
            break;
        case("CPU variante"):
            var_cpu=(String) columndesc.getCellData(i);
            System.out.println(var_cpu);
            break;
        case("CPU parte"):
            part_cpu=(String) columndesc.getCellData(i);
            System.out.println(part_cpu);
            break;
        case("CPU revision"):
            rev_cpu=(String) columndesc.getCellData(i);
            System.out.println(rev_cpu);
            break;
        case("Hardware"):
            hard_cpu=(String) columndesc.getCellData(i);
            System.out.println(hard_cpu);
            break;
        case("Revision"):
            revision=(String) columndesc.getCellData(i);
            System.out.println(revision);
            break;
        case("Serial"):
            serial_cpu=(String) columndesc.getCellData(i);
            System.out.println(serial_cpu);
            break;
            
    }
    
    }
    }
    public ObservableList<CheckMenuItem> ConsultforUICMItem(String s,String column){
         ObservableList<CheckMenuItem> list = FXCollections.observableArrayList();

        try {
            conn = DriverManager.getConnection(url+dbName,userName,password);
             st= conn.createStatement();
             resultSet=st.executeQuery(s);
            while(resultSet.next()){
                
                list.add(new CheckMenuItem(resultSet.getString(column)));
             
            }
            return list;
        } catch (SQLException ex) {
            adb.alertMessage(mesagges[2]); 
        }
        return list;
}
    public String[] ConsultforUIArray(String s,String column){
         String[] values=new String[100];
         int x=0;
        try {
            conn = DriverManager.getConnection(url+dbName,userName,password);
             st= conn.createStatement();
             resultSet=st.executeQuery(s);
            while(resultSet.next()){
                
                values[x]= resultSet.getString(column);
               x++;
            }
            return file.RemoveNullValue2(values);
        } catch (SQLException ex) {
            adb.alertMessage(mesagges[2]); 
        }
        return file.RemoveNullValue2(values);
}
    public void generateInfoComp(){
   
    }
}
