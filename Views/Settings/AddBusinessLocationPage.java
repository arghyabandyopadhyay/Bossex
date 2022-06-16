package BusinessGenie.app.Bossex.Views.Settings;

import BusinessGenie.app.Bossex.Database.DatabaseAccessor;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import static BusinessGenie.app.Bossex.Services.UniversalUtility.openMessageDialog;

public class AddBusinessLocationPage {
    public TextField businessLocationTF;
    public TextField addressTF;
    public Button addButton;

    public void createBusinessLocationAction(ActionEvent actionEvent) {
        String businessLocationName=businessLocationTF.getText();
        String address=addressTF.getText();
        if(!businessLocationName.isBlank()&& !address.isBlank()) {
            DatabaseAccessor accessor = new DatabaseAccessor();
            accessor.addBusinessLocation(businessLocationName, address);
            openMessageDialog("Business location created successfully!!","Success");
            businessLocationTF.clear();
            addressTF.clear();
        }
        else openMessageDialog("The * Marked fields can't be empty","Error!!");
    }
}
