package BusinessGenie.app.Bossex.Views.Products;

import BusinessGenie.app.Bossex.Bossex;
import BusinessGenie.app.Bossex.Database.DatabaseAccessor;
import BusinessGenie.app.Bossex.Models.Products.ProductsTableModel;
import BusinessGenie.app.Bossex.Models.Users.UsersModel;
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
import javafx.util.Callback;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import static BusinessGenie.app.Bossex.Services.UniversalUtility.openConfirmDialog;
import static BusinessGenie.app.Bossex.Services.UniversalUtility.openTab;

public class ProductsManagementPage implements Initializable {
    public TabPane productManagerTabPane;
    public BorderPane productManagementBorderPane;
    public Button addButton;
    public ImageView addImageView;
    public ComboBox<String> entriesComboBox;
    public ImageView exportToCSVImageView1;
    public ImageView exportToExcelImageView1;
    public ImageView exportToPDFImageView1;
    public ImageView printImageView1;
    public TableView<ProductsTableModel> productsTableView;
    public TableColumn<ProductsTableModel,String> productTC;
    public TableColumn<ProductsTableModel,String> businessLocationTC;
    public TableColumn<ProductsTableModel,Double> unitPurchasePriceTC;
    public TableColumn<ProductsTableModel,Double> sellingPriceTC;
    public TableColumn<ProductsTableModel,Double> currentStockTC;
    public TableColumn<ProductsTableModel,String> productTypeTC;
    public TableColumn<ProductsTableModel,String> categoryTC;
    public TableColumn<ProductsTableModel,Integer> brandTC;
    public TableColumn<ProductsTableModel,Double> taxTC;
    public TableColumn<ProductsTableModel,String> skuTC;
    public TableColumn<ProductsTableModel,Void> actionTC;
    public TableColumn<ProductsTableModel,String> unitTC;

    ObservableList<ProductsTableModel> productsObservableList;

    public void chooseFileButtonAction(ActionEvent event) {
    }

    public void uploadFileButtonAction(ActionEvent event) {
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        productTC.setCellValueFactory(
                new PropertyValueFactory<>("product"));
        businessLocationTC.setCellValueFactory(
                new PropertyValueFactory<>("businessLocation"));
        unitPurchasePriceTC.setCellValueFactory(
                new PropertyValueFactory<>("unitPurchasePrice"));
        sellingPriceTC.setCellValueFactory(
                new PropertyValueFactory<>("sellingPrice"));
        currentStockTC.setCellValueFactory(
                new PropertyValueFactory<>("currentStock"));
        productTypeTC.setCellValueFactory(
                new PropertyValueFactory<>("productType"));
        categoryTC.setCellValueFactory(
                new PropertyValueFactory<>("category"));
        brandTC.setCellValueFactory(
                new PropertyValueFactory<>("brand"));
        taxTC.setCellValueFactory(
                new PropertyValueFactory<>("tax"));
        skuTC.setCellValueFactory(
                new PropertyValueFactory<>("sku"));
        unitTC.setCellValueFactory(
                new PropertyValueFactory<>("unit"));

        List<ProductsTableModel> products= Bossex.databaseAccessor.getProducts();
        ObservableList<String> entries = FXCollections.observableArrayList("25","50","100","200","500","1000","All");
        entriesComboBox .setItems(entries);
        entriesComboBox.setValue("25");
        productsTableView.setFixedCellSize(35);
        addButtonToTable();
        productsObservableList=FXCollections.observableList(products);
        productsTableView.setItems(productsObservableList);
        productsTableView.prefHeightProperty().bind(Bindings.size(productsTableView.getItems()).multiply(productsTableView.getFixedCellSize()).add(30));
    }

    private void addButtonToTable() {

        Callback<TableColumn<ProductsTableModel, Void>, TableCell<ProductsTableModel, Void>> cellFactory = new Callback<TableColumn<ProductsTableModel, Void>, TableCell<ProductsTableModel, Void>>() {
            @Override
            public TableCell<ProductsTableModel, Void> call(final TableColumn<ProductsTableModel, Void> param) {
                return new TableCell<>() {

                    private final Button btn = new Button("Delete");

                    {
                        btn.setOnAction((ActionEvent event) -> {
                            boolean result=openConfirmDialog("Are you sure?","Caution");
                            if(result){
                                ProductsTableModel productsTableModel = getTableView().getItems().get(getIndex());
                                DatabaseAccessor databaseAccessor = new DatabaseAccessor();
                                databaseAccessor.deleteProduct(productsTableModel);
                                productsObservableList.remove(productsTableModel);
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

        actionTC.setCellFactory(cellFactory);
    }

    public void addButtonAction(ActionEvent event) throws IOException {
        openTab("Views/Products/AddProductPage.fxml","Resources/addProduct.png","Add Product",false);
    }
}
