package BusinessGenie.app.Bossex.Views.Contacts;

import BusinessGenie.app.Bossex.Database.DatabaseAccessor;
import BusinessGenie.app.Bossex.Models.Contacts.PaytermModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.util.StringConverter;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import static BusinessGenie.app.Bossex.Services.UniversalUtility.openMessageDialog;

public class AddSuppliersPage implements Initializable {
    public TextField nameTF;
    public TextField emailIdTF;
    public TextField gstinTF;
    public TextField openingBalanceTF;
    public TextField addressTF;
    public TextField mobileTF;
    public TextField totalPurchaseDueTF;
    public TextField totalPurchaseReturnDueTF;
    public ComboBox<PaytermModel> paytermCB;
    public TextField businessNameTF;
    ObservableList<PaytermModel> payterms;

    public void createSupplierAction(ActionEvent actionEvent) {
        String name=nameTF.getText();
        String businessName=businessNameTF.getText();
        String emailId=emailIdTF.getText();
        String mNo=mobileTF.getText();
        String gstin=gstinTF.getText();
        double openingBalance= Double.parseDouble(openingBalanceTF.getText());
        String address= addressTF.getText();
        double totalPurchaseDue= Double.parseDouble(totalPurchaseDueTF.getText());
        double totalPurchaseReturnDue= Double.parseDouble(totalPurchaseReturnDueTF.getText());
        int payterm=paytermCB.getSelectionModel().getSelectedItem().getId();
        if(!name.isBlank()&&!emailId.isBlank()&&!gstin.isBlank()&&!mNo.isBlank()) {
            DatabaseAccessor accessor = new DatabaseAccessor();
            accessor.addSupplier(emailId,businessName,mNo,name,payterm,gstin,openingBalance,address,totalPurchaseDue,totalPurchaseReturnDue);
        }
        else openMessageDialog("The * Marked fields can't be empty","Error!!");
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        DatabaseAccessor databaseAccessor=new DatabaseAccessor();

        List<PaytermModel> paytermModels =databaseAccessor.getPaytermModels();
        payterms = FXCollections.observableArrayList(paytermModels);
        paytermCB.setItems(payterms);
        paytermCB.setConverter(new StringConverter<>() {
            @Override
            public String toString(PaytermModel paytermModel) {
                return paytermModel.getPaytermDesc();
            }

            @Override
            public PaytermModel fromString(String s) {
                return null;
            }
        });
        paytermCB.setValue(payterms.get(0));
    }
}
