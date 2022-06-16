package BusinessGenie.app.Bossex.Views.Contacts;

import BusinessGenie.app.Bossex.Database.DatabaseAccessor;
import BusinessGenie.app.Bossex.Models.Users.UserRoleModel;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import static BusinessGenie.app.Bossex.Services.UniversalUtility.openMessageDialog;

public class AddCustomerGroupPage {
    public TextField rNameTF;
    public TextField calculationPercentageTF;
    public Button addButton;

    public void createCustomerGroupAction(ActionEvent actionEvent) {
        String groupName=rNameTF.getText();
        double calculationPercentage=Double.parseDouble(calculationPercentageTF.getText());
        if(!groupName.isBlank()&& !(calculationPercentage ==0)) {
            DatabaseAccessor accessor = new DatabaseAccessor();
            accessor.addCustomerGroup(groupName, calculationPercentage);
            openMessageDialog("Customer group created successfully!!","Success");
            rNameTF.clear();
            calculationPercentageTF.clear();
        }
        else openMessageDialog("The * Marked fields can't be empty","Error!!");
    }
}
