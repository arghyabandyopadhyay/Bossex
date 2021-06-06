package BusinessGenie.app.Bossex.Views.User;

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

public class UserManagementPage implements Initializable {
    public BorderPane UserManagementBorderPane;
    public ImageView exportToCSVImageView1;
    public ImageView exportToExcelImageView1;
    public ImageView exportToPDFImageView1;
    public ImageView printImageView1;
    public ImageView addImageView;
    public Button addButton;
    public ComboBox<String> entriesComboBox;
    public TableView usersTableView;

    public int noOfEntries;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ObservableList<String> entries = FXCollections.observableArrayList("25","50","100","200","500","1000","All");
        entriesComboBox .setItems(entries);
        entriesComboBox.setValue("25");
        usersTableView.setFixedCellSize(25);
        usersTableView.prefHeightProperty().bind(Bindings.size(usersTableView.getItems()).multiply(usersTableView.getFixedCellSize()).add(30));
    }
}
