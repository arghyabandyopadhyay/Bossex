package BusinessGenie.app.Bossex.Views.Contacts;

import BusinessGenie.app.Bossex.Database.DatabaseAccessor;
import BusinessGenie.app.Bossex.Models.Contacts.CustomerGroupsModel;
import BusinessGenie.app.Bossex.Models.Contacts.PaytermModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.util.StringConverter;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import static BusinessGenie.app.Bossex.Services.UniversalUtility.openMessageDialog;

public class AddCustomersPage implements Initializable {
    public TextField nameTF;
    public TextField emailIdTF;
    public TextField pancardTF;
    public TextField openingBalanceTF;
    public TextField creditLimitTF;
    public TextField advanceBalanceTF;
    public TextField addressTF;
    public TextField mobileTF;
    public TextField totalSellDueTF;
    public TextField totalSellReturnDueTF;
    public ComboBox<CustomerGroupsModel> customerGroupCB;
    public ComboBox<PaytermModel> paytermCB;
    public Button addButton;

    ObservableList<CustomerGroupsModel> customerGroups;
    ObservableList<PaytermModel> payterms;

    public void createCustomerAction(ActionEvent actionEvent) {
        String name=nameTF.getText();
        String emailId=emailIdTF.getText();
        String mNo=mobileTF.getText();
        String pancard=pancardTF.getText();
        double openingBalance= Double.parseDouble(openingBalanceTF.getText());
        double creditLimit= Double.parseDouble(creditLimitTF.getText());
        double advanceBalance= Double.parseDouble(advanceBalanceTF.getText());
        String address= addressTF.getText();
        double totalSellDue= Double.parseDouble(totalSellDueTF.getText());
        double totalSellReturnDue= Double.parseDouble(totalSellReturnDueTF.getText());
        int customerGroup=customerGroupCB.getSelectionModel().getSelectedItem().getId();
        int payterm=paytermCB.getSelectionModel().getSelectedItem().getId();
        if(!name.isBlank()&&!emailId.isBlank()&&!pancard.isBlank()&&!mNo.isBlank()) {
            DatabaseAccessor accessor = new DatabaseAccessor();
            accessor.addCustomer(emailId,mNo,name,payterm,pancard,openingBalance,creditLimit,advanceBalance,address,totalSellDue,totalSellReturnDue,customerGroup);
            openMessageDialog("Customer created successfully!!","Success");
            nameTF.clear();
            emailIdTF.clear();
            pancardTF.clear();
            openingBalanceTF.clear();
            addressTF.clear();
            mobileTF.clear();
            totalSellDueTF.clear();
            totalSellReturnDueTF.clear();
            creditLimitTF.clear();
            advanceBalanceTF.clear();
        }
        else openMessageDialog("The * Marked fields can't be empty","Error!!");
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        DatabaseAccessor databaseAccessor=new DatabaseAccessor();
        List<CustomerGroupsModel> customerGroupsModels =databaseAccessor.getCustomerGroupsModel();
        customerGroups = FXCollections.observableArrayList(customerGroupsModels);
        customerGroupCB.setItems(customerGroups);
        customerGroupCB.setConverter(new StringConverter<CustomerGroupsModel>() {
            @Override
            public String toString(CustomerGroupsModel customerGroupsModel) {
                return customerGroupsModel.getCustomerGroupName();
            }

            @Override
            public CustomerGroupsModel fromString(String s) {
                return null;
            }
        });
        customerGroupCB.setValue(customerGroups.get(0));

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
