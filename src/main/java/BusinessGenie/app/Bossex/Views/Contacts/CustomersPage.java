package BusinessGenie.app.Bossex.Views.Contacts;

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
import javafx.stage.FileChooser;
import javafx.util.Callback;

import java.io.IOException;
import java.net.URL;
import java.util.ListIterator;
import java.util.ResourceBundle;

import static BusinessGenie.app.Bossex.Services.UniversalUtility.getTabIndex;
import static BusinessGenie.app.Bossex.Bossex.masterTabPane;

public class CustomersPage implements Initializable {
    public BorderPane customerManagementBorderPane;
    public Button addButton;
    public ImageView addImageView;
    public ComboBox<String> entriesComboBox;
    public ImageView exportToCSVImageView1;
    public ImageView exportToExcelImageView1;
    public ImageView exportToPDFImageView1;
    public ImageView printImageView1;
    public TableView customersTableView;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ObservableList<String> entries = FXCollections.observableArrayList("25","50","100","200","500","1000","All");
        entriesComboBox .setItems(entries);
        entriesComboBox.setValue("25");
        customersTableView.setFixedCellSize(25);
        customersTableView.prefHeightProperty().bind(Bindings.size(customersTableView.getItems()).multiply(customersTableView.getFixedCellSize()).add(30));
    }

    public void addButtonAction(ActionEvent event) throws IOException {
        int index=getTabIndex("Add Customers");
        if(index==-1)
        {
            Parent loader = FXMLLoader.load(getClass().getResource(Bossex.baseURL+"Views/Contacts/AddCustomersPage.fxml"));
            Tab tab = new Tab("Add Customers",loader);
            ImageView imageView=new ImageView(new Image(getClass().getResource(Bossex.baseURL+"Resources/addContacts.png").toExternalForm()));
            imageView.setFitHeight(20);
            imageView.setFitWidth(20);
            tab.setGraphic(imageView);
            masterTabPane.getTabs().add(tab);
            masterTabPane.getSelectionModel().select(masterTabPane.getTabs().size()-1);
        }
        else {
            masterTabPane.getSelectionModel().select(index);
        }
    }
//    private void addButtonToTable() {
//        TableColumn<Data, Void> colBtn = new TableColumn("Button Column");
//
//        Callback<TableColumn<Data, Void>, TableCell<Data, Void>> cellFactory = new Callback<TableColumn<Data, Void>, TableCell<Data, Void>>() {
//            @Override
//            public TableCell<Data, Void> call(final TableColumn<Data, Void> param) {
//                final TableCell<Data, Void> cell = new TableCell<Data, Void>() {
//
//                    private final Button btn = new Button("Action");
//
//                    {
//                        btn.setOnAction((ActionEvent event) -> {
//                            Data data = getTableView().getItems().get(getIndex());
//                            System.out.println("selectedData: " + data);
//                        });
//                    }
//                    @Override
//                    public void updateItem(Void item, boolean empty) {
//                        super.updateItem(item, empty);
//                        if (empty) {
//                            setGraphic(null);
//                        } else {
//                            setGraphic(btn);
//                        }
//                    }
//                };
//                return cell;
//            }
//        };
//        colBtn.setCellFactory(cellFactory);
//        customersTableView.getColumns().add(colBtn);
//    }
//    public class Data {
//
//        private int id;
//        private String name;
//
//        private Data(int id, String name) {
//            this.id = id;
//            this.name = name;
//        }
//
//        public int getId() {
//            return id;
//        }
//
//        public void setId(int ID) {
//            this.id = ID;
//        }
//
//        public String getName() {
//            return name;
//        }
//
//        public void setName(String nme) {
//            this.name = nme;
//        }
//
//        @Override
//        public String toString() {
//            return "id: " + id + " - " + "name: " + name;
//        }
//
//    }
}
