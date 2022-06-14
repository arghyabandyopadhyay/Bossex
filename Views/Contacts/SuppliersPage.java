package BusinessGenie.app.Bossex.Views.Contacts;

import BusinessGenie.app.Bossex.Bossex;
import BusinessGenie.app.Bossex.Database.DatabaseAccessor;
import BusinessGenie.app.Bossex.Models.Contacts.SuppliersModel;
import BusinessGenie.app.Bossex.Models.Users.UsersModel;
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

public class SuppliersPage implements Initializable {
    public BorderPane suppliersManagementBorderPane;
    public Button addButton;
    public ImageView addImageView;
    public ComboBox<String> entriesComboBox;
    public ImageView exportToCSVImageView1;
    public ImageView exportToExcelImageView1;
    public ImageView exportToPDFImageView1;
    public ImageView printImageView1;
    public TableView<SuppliersModel> suppliersTableView;
    public TableColumn<SuppliersModel,String> businessNameTc;
    public TableColumn<SuppliersModel,String> nameTc;
    public TableColumn<SuppliersModel,String> emailTc;
    public TableColumn<SuppliersModel,String> gstinTc;
    public TableColumn<SuppliersModel,String> paytermDescTc;
    public TableColumn<SuppliersModel,Double> openingBalanceTc;
    public TableColumn<SuppliersModel,String> addedOnTc;
    public TableColumn<SuppliersModel,String> mnoTc;
    public TableColumn<SuppliersModel,Double> totalPurchaseDueTc;
    public TableColumn<SuppliersModel,Double> totalPurchaseReturnDueTc;
    public TableColumn<SuppliersModel,Void> actionTc;
    public ObservableList<SuppliersModel> suppliersModelObservableList;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        businessNameTc.setCellValueFactory(
                new PropertyValueFactory<>("businessName"));
        nameTc.setCellValueFactory(
                new PropertyValueFactory<>("name"));
        emailTc.setCellValueFactory(
                new PropertyValueFactory<>("emailId"));
        gstinTc.setCellValueFactory(
                new PropertyValueFactory<>("gstin"));
        paytermDescTc.setCellValueFactory(
                new PropertyValueFactory<>("paytermDesc"));
        openingBalanceTc.setCellValueFactory(
                new PropertyValueFactory<>("openingBalance"));
        addedOnTc.setCellValueFactory(
                new PropertyValueFactory<>("addedOn"));
        mnoTc.setCellValueFactory(
                new PropertyValueFactory<>("mNo"));
        totalPurchaseDueTc.setCellValueFactory(
                new PropertyValueFactory<>("totalPurchaseDue"));
        totalPurchaseReturnDueTc.setCellValueFactory(
                new PropertyValueFactory<>("totalPurchaseReturnDue"));
        List<SuppliersModel> suppliersModelList= Bossex.databaseAccessor.getSuppliers();
        ObservableList<String> entries = FXCollections.observableArrayList("25","50","100","200","500","1000","All");
        entriesComboBox .setItems(entries);
        entriesComboBox.setValue("25");
        suppliersTableView.setFixedCellSize(35);
        addButtonToTable();
        suppliersModelObservableList=FXCollections.observableList(suppliersModelList);
        suppliersTableView.setItems(suppliersModelObservableList);
        suppliersTableView.prefHeightProperty().bind(Bindings.size(suppliersTableView.getItems()).multiply(suppliersTableView.getFixedCellSize()).add(30));
    }

    private void addButtonToTable() {

        Callback<TableColumn<SuppliersModel, Void>, TableCell<SuppliersModel, Void>> cellFactory = new Callback<TableColumn<SuppliersModel, Void>, TableCell<SuppliersModel, Void>>() {
            @Override
            public TableCell<SuppliersModel, Void> call(final TableColumn<SuppliersModel, Void> param) {
                return new TableCell<>() {

                    private final Button btn = new Button("Delete");

                    {
                        btn.setOnAction((ActionEvent event) -> {
                            boolean result=openConfirmDialog("Are you sure?","Caution");
                            if(result){
                                SuppliersModel suppliersModel = getTableView().getItems().get(getIndex());
                                DatabaseAccessor databaseAccessor = new DatabaseAccessor();
                                databaseAccessor.deleteSupplier(suppliersModel);
                                suppliersModelObservableList.remove(suppliersModel);
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

    public void addButtonAction(ActionEvent event) throws IOException {
        openTab("Views/Contacts/AddSuppliersPage.fxml","Resources/addSupplier.png","Add Suppliers",false);
    }
}
