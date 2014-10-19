/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package demo.connections;
import demo.GenericInterface;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    Connection conn = null;
    Statement st;
    ResultSet resultSet;
    public void conectar(){
  
        try {
            conn = DriverManager.getConnection(url+dbName,userName,password);
             st= conn.createStatement();
             resultSet=st.executeQuery(stest);
            while(resultSet.next()){
            nombre= resultSet.getString("name_user");
            }
                    
        } catch (SQLException ex) {
            Logger.getLogger(server.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(nombre);
    }
    public int Consultation(String s) throws SQLException{
   int result = 0;
          resultSet=st.executeQuery(s);
            while(resultSet.next()){
            result= resultSet.getRow();
            }
        return result;
    }
}
