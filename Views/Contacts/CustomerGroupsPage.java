package BusinessGenie.app.Bossex.Views.Contacts;

import BusinessGenie.app.Bossex.Bossex;
import BusinessGenie.app.Bossex.Database.DatabaseAccessor;
import BusinessGenie.app.Bossex.Models.Contacts.CustomerGroupsModel;
import BusinessGenie.app.Bossex.Models.Contacts.CustomersModel;
import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.util.Callback;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import static BusinessGenie.app.Bossex.Services.UniversalUtility.openConfirmDialog;
import static BusinessGenie.app.Bossex.Services.UniversalUtility.openTab;

public class CustomerGroupsPage implements Initializable {
    public BorderPane customerGroupsManagementBorderPane;
    public Button addButton;
    public ImageView addImageView;
    public ComboBox<String> entriesComboBox;
    public ImageView exportToCSVImageView1;
    public ImageView exportToExcelImageView1;
    public ImageView exportToPDFImageView1;
    public ImageView printImageView1;
    public TableView<CustomerGroupsModel> customerGroupsTableView;
    public TableColumn<CustomerGroupsModel,String> customerGroupNameTc;
    public TableColumn<CustomerGroupsModel,Double> calculationPercentageTc;
    public TableColumn<CustomerGroupsModel,Void> actionTc;
    ObservableList<CustomerGroupsModel> customerGroupsObservableList;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        customerGroupNameTc.setCellValueFactory(
                new PropertyValueFactory<>("customerGroupName"));
        calculationPercentageTc.setCellValueFactory(
                new PropertyValueFactory<>("calculationPercentage"));
        List<CustomerGroupsModel> customerGroupsModelList = Bossex.databaseAccessor.getCustomerGroupsModel();
        ObservableList<String> entries = FXCollections.observableArrayList("25", "50", "100", "200", "500", "1000", "All");
        entriesComboBox.setItems(entries);
        entriesComboBox.setValue("25");
        customerGroupsTableView.setFixedCellSize(35);
        addButtonToTable();
        customerGroupsObservableList = FXCollections.observableList(customerGroupsModelList);
        customerGroupsTableView.setItems(customerGroupsObservableList);
        customerGroupsTableView.prefHeightProperty().bind(Bindings.size(customerGroupsTableView.getItems()).multiply(customerGroupsTableView.getFixedCellSize()).add(30));
    }
    public void addButtonAction(ActionEvent event) throws IOException {
        openTab("Views/Contacts/AddCustomerGroupPage.fxml", "Resources/customerGroup.png", "Add Customer Group", false);
    }
    private void addButtonToTable() {

        Callback<TableColumn<CustomerGroupsModel, Void>, TableCell<CustomerGroupsModel, Void>> cellFactory = new Callback<TableColumn<CustomerGroupsModel, Void>, TableCell<CustomerGroupsModel, Void>>() {
            @Override
            public TableCell<CustomerGroupsModel, Void> call(final TableColumn<CustomerGroupsModel, Void> param) {
                return new TableCell<>() {

                    private final Button btn = new Button("Delete");

                    {
                        btn.setOnAction((ActionEvent event) -> {
                            boolean result = openConfirmDialog("Are you sure?", "Caution");
                            if (result) {
                                CustomerGroupsModel customerGroupsModel = getTableView().getItems().get(getIndex());
                                DatabaseAccessor databaseAccessor = new DatabaseAccessor();
                                databaseAccessor.deleteCustomerGroup(customerGroupsModel);
                                customerGroupsObservableList.remove(customerGroupsModel);
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
