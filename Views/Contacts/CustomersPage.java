package BusinessGenie.app.Bossex.Views.Contacts;

import BusinessGenie.app.Bossex.Bossex;
import BusinessGenie.app.Bossex.Database.DatabaseAccessor;
import BusinessGenie.app.Bossex.Models.Contacts.CustomersModel;
import BusinessGenie.app.Bossex.Models.Contacts.CustomersModel;
import BusinessGenie.app.Bossex.Models.Contacts.CustomersModel;
import BusinessGenie.app.Bossex.Models.Contacts.CustomersModel;
import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.stage.FileChooser;
import javafx.util.Callback;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ListIterator;
import java.util.ResourceBundle;

import static BusinessGenie.app.Bossex.Bossex.masterTabPane;
import static BusinessGenie.app.Bossex.Services.UniversalUtility.*;

public class CustomersPage implements Initializable {
    public BorderPane customerManagementBorderPane;
    public Button addButton;
    public ImageView addImageView;
    public ComboBox<String> entriesComboBox;
    public ImageView exportToCSVImageView1;
    public ImageView exportToExcelImageView1;
    public ImageView exportToPDFImageView1;
    public ImageView printImageView1;
    public TableView<CustomersModel> customersTableView;
    public TableColumn<CustomersModel, String> nameTc;
    public TableColumn<CustomersModel, String> emailTc;
    public TableColumn<CustomersModel, String> pancardTc;
    public TableColumn<CustomersModel, String> paytermDescTc;
    public TableColumn<CustomersModel, Double> openingBalanceTc;
    public TableColumn<CustomersModel, String> addedOnTc;
    public TableColumn<CustomersModel, String> mnoTc;
    public TableColumn<CustomersModel, Double> totalSellDueTc;
    public TableColumn<CustomersModel, Double> totalSellReturnDueTc;
    public TableColumn<CustomersModel, Void> actionTc;
    public ObservableList<CustomersModel> customersModelObservableList;
    public TableColumn<CustomersModel, Double> creditLimitTc;
    public TableColumn<CustomersModel, Double> advanceBalanceTc;
    public TableColumn<CustomersModel, String> customerGroupTc;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        nameTc.setCellValueFactory(
                new PropertyValueFactory<>("name"));
        emailTc.setCellValueFactory(
                new PropertyValueFactory<>("emailId"));
        pancardTc.setCellValueFactory(
                new PropertyValueFactory<>("pancard"));
        paytermDescTc.setCellValueFactory(
                new PropertyValueFactory<>("paytermDesc"));
        openingBalanceTc.setCellValueFactory(
                new PropertyValueFactory<>("openingBalance"));
        addedOnTc.setCellValueFactory(
                new PropertyValueFactory<>("addedOn"));
        mnoTc.setCellValueFactory(
                new PropertyValueFactory<>("mNo"));
        totalSellDueTc.setCellValueFactory(
                new PropertyValueFactory<>("totalSellDue"));
        totalSellReturnDueTc.setCellValueFactory(
                new PropertyValueFactory<>("totalSellReturnDue"));
        creditLimitTc.setCellValueFactory(
                new PropertyValueFactory<>("creditLimit"));
        advanceBalanceTc.setCellValueFactory(
                new PropertyValueFactory<>("AdvanceBalance"));
        customerGroupTc.setCellValueFactory(
                new PropertyValueFactory<>("CustomerGroupName"));
        List<CustomersModel> customersModelList = Bossex.databaseAccessor.getCustomers();
        ObservableList<String> entries = FXCollections.observableArrayList("25", "50", "100", "200", "500", "1000", "All");
        entriesComboBox.setItems(entries);
        entriesComboBox.setValue("25");
        customersTableView.setFixedCellSize(35);
        addButtonToTable();
        customersModelObservableList = FXCollections.observableList(customersModelList);
        customersTableView.setItems(customersModelObservableList);
        customersTableView.prefHeightProperty().bind(Bindings.size(customersTableView.getItems()).multiply(customersTableView.getFixedCellSize()).add(30));
    }

    public void addButtonAction(ActionEvent event) throws IOException {
        openTab("Views/Contacts/AddCustomersPage.fxml", "Resources/addContacts.png", "Add Customer", false);
    }

    private void addButtonToTable() {

        Callback<TableColumn<CustomersModel, Void>, TableCell<CustomersModel, Void>> cellFactory = new Callback<TableColumn<CustomersModel, Void>, TableCell<CustomersModel, Void>>() {
            @Override
            public TableCell<CustomersModel, Void> call(final TableColumn<CustomersModel, Void> param) {
                return new TableCell<>() {

                    private final Button btn = new Button("Delete");

                    {
                        btn.setOnAction((ActionEvent event) -> {
                            boolean result = openConfirmDialog("Are you sure?", "Caution");
                            if (result) {
                                CustomersModel customersModel = getTableView().getItems().get(getIndex());
                                DatabaseAccessor databaseAccessor = new DatabaseAccessor();
                                databaseAccessor.deleteCustomer(customersModel);
                                customersModelObservableList.remove(customersModel);
                            }
                        });
                    }

                    @Override
                    public void updateItem(Void item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
                            setGraphic(null);
                        } else {
                            setGraphic(btn);
                        }
                    }
                };
            }
        };

        actionTc.setCellFactory(cellFactory);
    }
}