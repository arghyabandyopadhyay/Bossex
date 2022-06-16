package BusinessGenie.app.Bossex.Views.User;

import BusinessGenie.app.Bossex.Database.DatabaseAccessor;
import BusinessGenie.app.Bossex.Models.Users.UserRoleModel;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;

import static BusinessGenie.app.Bossex.Bossex.masterTabPane;
import static BusinessGenie.app.Bossex.Services.UniversalUtility.getTabIndex;
import static BusinessGenie.app.Bossex.Services.UniversalUtility.openMessageDialog;

public class AddRolesPage {
    public TextField rName;
    public CheckBox salesManagerCB;
    public CheckBox inventoryManagerCB;
    public CheckBox userManagerCB;
    public CheckBox reportManagerCB;
    public CheckBox createNewUserCB;
    public Button addButton;

    public void createRoleAction(ActionEvent actionEvent) {

        Tab rolesTab=masterTabPane.getTabs().get(getTabIndex("Role"));
        System.out.println(rolesTab.getContent().getScene().getWindow().getClass());
        String roleName=rName.getText();
        if(!roleName.isBlank()) {
            DatabaseAccessor accessor = new DatabaseAccessor();
            String permission=""+(salesManagerCB.isSelected()?"1":"0")+(createNewUserCB.isSelected()?"1":"0")+(inventoryManagerCB.isSelected()?"1":"0")+(userManagerCB.isSelected()?"1":"0")+(reportManagerCB.isSelected()?"1":"0");
            accessor.addRole(new UserRoleModel(0,roleName, permission));
            openMessageDialog("Role created successfully!!","Success");
            rName.clear();
            salesManagerCB.setSelected(false);
            inventoryManagerCB.setSelected(false);
            userManagerCB.setSelected(false);
            reportManagerCB.setSelected(false);
            createNewUserCB.setSelected(false);
        }
        else openMessageDialog("The * Marked fields can't be empty","Error!!");
    }
}
