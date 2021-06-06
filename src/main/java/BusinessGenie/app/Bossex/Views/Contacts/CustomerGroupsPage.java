package BusinessGenie.app.Bossex.Views.Contacts;

import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableView;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;

import java.net.URL;
import java.util.ResourceBundle;

public class CustomerGroupsPage implements Initializable {
    public BorderPane customerGroupsManagementBorderPane;
    public Button addButton;
    public ImageView addImageView;
    public ComboBox<String> entriesComboBox;
    public ImageView exportToCSVImageView1;
    public ImageView exportToExcelImageView1;
    public ImageView exportToPDFImageView1;
    public ImageView printImageView1;
    public TableView customerGroupsTableView;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ObservableList<String> entries = FXCollections.observableArrayList("25","50","100","200","500","1000","All");
        entriesComboBox .setItems(entries);
        entriesComboBox.setValue("25");
        customerGroupsTableView.setFixedCellSize(25);
        customerGroupsTableView.prefHeightProperty().bind(Bindings.size(customerGroupsTableView.getItems()).multiply(customerGroupsTableView.getFixedCellSize()).add(30));
    }
}
