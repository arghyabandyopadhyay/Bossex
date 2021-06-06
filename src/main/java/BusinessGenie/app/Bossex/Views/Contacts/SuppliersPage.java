package BusinessGenie.app.Bossex.Views.Contacts;

import BusinessGenie.app.Bossex.Bossex;
import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Tab;
import javafx.scene.control.TableView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static BusinessGenie.app.Bossex.Bossex.masterTabPane;
import static BusinessGenie.app.Bossex.Services.UniversalUtility.getTabIndex;
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
    public TableView suppliersTableView;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ObservableList<String> entries = FXCollections.observableArrayList("25","50","100","200","500","1000","All");
        entriesComboBox .setItems(entries);
        entriesComboBox.setValue("25");
        suppliersTableView.setFixedCellSize(25);
        suppliersTableView.prefHeightProperty().bind(Bindings.size(suppliersTableView.getItems()).multiply(suppliersTableView.getFixedCellSize()).add(30));
    }

    public void addButtonAction(ActionEvent event) throws IOException {
//        int index=getTabIndex("Add Suppliers");
//        if(index==-1)
//        {
//            Parent loader = FXMLLoader.load(getClass().getResource(Bossex.baseURL+"Views/Contacts/AddSuppliersPage.fxml"));
//            Tab tab = new Tab("Add Suppliers",loader);
//            ImageView imageView=new ImageView(new Image(getClass().getResource(Bossex.baseURL+"Resources/addSupplier.png").toExternalForm()));
//            imageView.setFitHeight(20);
//            imageView.setFitWidth(20);
//            tab.setGraphic(imageView);
//            masterTabPane.getTabs().add(tab);
//            masterTabPane.getSelectionModel().select(masterTabPane.getTabs().size()-1);
//        }
//        else {
//            masterTabPane.getSelectionModel().select(index);
//        }
        openTab("Views/Contacts/AddSuppliersPage.fxml","Resources/addSupplier.png","Add Suppliers",false);
    }
}
