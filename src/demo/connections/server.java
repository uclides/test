/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package demo.connections;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author desarrollo06
 */
public class server {
    String url="jdbc:mysql://localhost:3306/";
    String dbName="dtb";
    String driver="com.mysql.jdbc.Driver";
    String userName="root";
    String password="";
    String nombre;
    public void conectar(){
    Connection conn = null;
        try {
            conn = DriverManager.getConnection(url+dbName,userName,password);
            Statement st= conn.createStatement();
            ResultSet resultSet=st.executeQuery("select * from usuarios");
            while(resultSet.next()){
            nombre= resultSet.getString("nombre");
            }
                    
        } catch (SQLException ex) {
            Logger.getLogger(server.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(nombre);
    }
}
