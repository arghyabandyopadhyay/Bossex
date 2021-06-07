package BusinessGenie.app.Bossex.Views.LoginPage;

import BusinessGenie.app.Bossex.Bossex;
import BusinessGenie.app.Bossex.Models.UsersModel;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

import javax.swing.*;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class LoginPage implements Initializable {
    public TextField usernameTf;
    public BorderPane borderPane1;
    public PasswordField passwordTf;
    public Button goBtn;
    public VBox loginVBox;
    boolean isAuthenticated;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        isAuthenticated=false;
        usernameTf.setOnKeyPressed(keyEvent -> {
            KeyCode keyCode = keyEvent.getCode();
            if (keyCode.equals(KeyCode.ENTER) || keyCode.equals(KeyCode.TAB)) {
                passwordTf.requestFocus();
            }
        });
        passwordTf.setOnKeyPressed(keyEvent -> {
            KeyCode keyCode = keyEvent.getCode();
            if (keyCode.equals(KeyCode.ENTER) || keyCode.equals(KeyCode.TAB)) {
                goBtn.fire();
            }
        });
        goBtn.setOnAction(this::getMasterPage);

    }

    public void getMasterPage(javafx.event.ActionEvent event)
    {
        List<UsersModel> userList=null;
        //userList= Bossex.apiAccessor.getUserList();
        String usernameTfText= usernameTf.getText();
        String passwordTfText=passwordTf.getText();
        /*for (UsersModel usersTemplate : userList){
            if(passwordTfText.equals(usersTemplate.getPassword()) && usernameTfText.equals(usersTemplate.getuserId()))
            {
                usernameTf.clear();
                passwordTf.clear();
                usernameTf.requestFocus();
                char[] perm=usersTemplate.getPermission().toCharArray();
                Bossex.userDetails=usersTemplate;
                Bossex.permission[0]=perm[0] == '1';
                Bossex.permission[1]=perm[1] == '1';
                Bossex.permission[2]=perm[2] == '1';
                Bossex.permission[3]=perm[3] == '1';
                Bossex.permission[4]=perm[4] == '1';
                Bossex.universalUtility.nextPage(event,"MasterPage.fxml","Dashboard",false);
                isAuthenticated=true;
            }
        }
         */
        Bossex.permission[0]=true;
        Bossex.permission[1]=true;
        Bossex.permission[2]=true;
        Bossex.permission[3]=true;
        Bossex.permission[4]=true;
        Bossex.universalUtility.nextPage(event,"MasterPage.fxml","Admin",false);
        isAuthenticated=true;
        if(!isAuthenticated)
        {
            JOptionPane.showMessageDialog(null,"Authorization Unsuccessful!!","Error!!",JOptionPane.WARNING_MESSAGE);
        }

    }
}
