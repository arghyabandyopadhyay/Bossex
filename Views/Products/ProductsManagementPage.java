package BusinessGenie.app.Bossex.Views.Products;

import BusinessGenie.app.Bossex.Bossex;
import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

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
    public TableView productsTableView;

    public void chooseFileButtonAction(ActionEvent event) {
    }

    public void uploadFileButtonAction(ActionEvent event) {
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ObservableList<String> entries = FXCollections.observableArrayList("25","50","100","200","500","1000","All");
        entriesComboBox .setItems(entries);
        entriesComboBox.setValue("25");
        productsTableView.setFixedCellSize(25);
        productsTableView.prefHeightProperty().bind(Bindings.size(productsTableView.getItems()).multiply(productsTableView.getFixedCellSize()).add(30));

    }

    public void addButtonAction(ActionEvent event) throws IOException {
        Parent loader = FXMLLoader.load(getClass().getResource(Bossex.baseURL+"Views/Products/AddProductPage.fxml"));
        Tab tab = new Tab("Add Product",loader);
        ImageView imageView=new ImageView(new Image(getClass().getResource(Bossex.baseURL+"Resources/addProduct.png").toExternalForm()));
        imageView.setFitHeight(20);
        imageView.setFitWidth(20);
        tab.setGraphic(imageView);
        Bossex.masterTabPane.getTabs().add(tab);
        Bossex.masterTabPane.getSelectionModel().select(Bossex.masterTabPane.getTabs().size()-1);
    }
}
