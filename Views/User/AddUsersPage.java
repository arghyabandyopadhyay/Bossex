package BusinessGenie.app.Bossex.Views.User;

import BusinessGenie.app.Bossex.Database.DatabaseAccessor;
import BusinessGenie.app.Bossex.Models.Users.UserRoleModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.util.StringConverter;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import static BusinessGenie.app.Bossex.Services.UniversalUtility.openMessageDialog;

public class AddUsersPage implements Initializable {
    public Button createUserButton;
    public Button cancelButton;
    public TextField uName;
    public TextField uId;
    public PasswordField passwordTF;
    public PasswordField confirmPasswordTF;
    public TextField emailIdTF;
    public TextField mNoTF;
    public ComboBox<UserRoleModel> roleComboBox;
    public ComboBox<String> themeComboBox;

    ObservableList<UserRoleModel> roles;

    public void createUserAction(ActionEvent actionEvent) {
        String name=uName.getText();
        String userId=uId.getText();
        String password=passwordTF.getText();
        String emailId=emailIdTF.getText();
        String mNo=mNoTF.getText();
        String theme=themeComboBox.getSelectionModel().getSelectedItem();
        int roleId=roleComboBox.getSelectionModel().getSelectedItem().getid();
        if(password.equals(confirmPasswordTF.getText()))
        {
            if(!name.isBlank()&&!userId.isBlank()&&!password.isBlank()&&!mNo.isBlank()) {
                DatabaseAccessor accessor = new DatabaseAccessor();
                accessor.addUser(userId, password, emailId, mNo, theme, name, roleId);
            }
            else openMessageDialog("The * Marked fields can't be empty","Error!!");
        }
        else openMessageDialog("Both the Passwords don't match","Error!!");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        DatabaseAccessor databaseAccessor=new DatabaseAccessor();
        List< UserRoleModel> roleList =databaseAccessor.getRoleList();
        roles = FXCollections.observableArrayList(roleList);
        roleComboBox.setItems(roles);
        roleComboBox.setConverter(new StringConverter<UserRoleModel>() {
            @Override
            public String toString(UserRoleModel userRoleModel) {
                return userRoleModel.getRoleName();
            }

            @Override
            public UserRoleModel fromString(String s) {
                return null;
            }
        });
        roleComboBox.setValue(roleList.get(0));
        ObservableList<String> themes = FXCollections.observableArrayList("dark","light");
        themeComboBox.setItems(themes);
        themeComboBox.setValue(themes.get(0));
    }
}
