
package demo;

import demo.connections.server;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

/**
 * Login Controller.
 */
public class LoginController extends AnchorPane implements Initializable,GenericInterface {

    @FXML
    TextField userId;
    @FXML
    PasswordField password;
    @FXML
    Button login;
    @FXML
    Label errorMessage;
     server ser=new server();
    private Main application;
    int statusdevice;
    public ObservableList<String> attr;
    public void setApp(Main application){
        this.application = application;
    }
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        errorMessage.setText("");
        userId.setPromptText("demo");
        password.setPromptText("demo");
     
    }
   
    public void exit(ActionEvent actionEvent){
System.exit(0);

    }
    public void LoginUser(ActionEvent event){
        attr= ser.getLogin(userId.getText(),password.getText());
        if(!attr.isEmpty()){
            application.gotoProfile(attr);
            
            
        }
        else{
            errorMessage.setText(errorlogin);
        }
    }
   

   
}
