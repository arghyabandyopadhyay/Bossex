package BusinessGenie.app.Bossex.Views.Contacts;

import BusinessGenie.app.Bossex.Models.ImportContactsInstructionTemplate;
import javafx.beans.binding.Bindings;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.File;
import java.net.URL;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;
import java.util.ResourceBundle;

public class ImportContacts implements Initializable {
    public Label filePathLabel;
    public TableColumn<ImportContactsInstructionTemplate,Integer> columnNumberTC;
    public TableColumn<ImportContactsInstructionTemplate,String> columnNameTC;
    public TableColumn<ImportContactsInstructionTemplate, List<String>> instructionTC;
    public TableView<ImportContactsInstructionTemplate> instructionTBV= new TableView<>();;
    FileChooser fil_chooser = new FileChooser();
    private final static ObservableList<ImportContactsInstructionTemplate> instructions = FXCollections.observableArrayList();
    File file;
    public void chooseFileButtonAction(ActionEvent event) {
        Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        // get the file selected
        file = fil_chooser.showOpenDialog(stage);
        if (file != null) {
            filePathLabel.setText(file.getAbsolutePath()
                    + "  selected");
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // set title
        fil_chooser.setTitle("Select File");
        String currentDir = System.getProperty("user.home") + File.separator;
        // set initial File
        fil_chooser.setInitialDirectory(new File(currentDir));
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("XLS files (*.xls)", "*.xls");
        FileChooser.ExtensionFilter extFilter2 = new FileChooser.ExtensionFilter("All Files", "*.*");
        fil_chooser.getExtensionFilters().addAll(extFilter,extFilter2);
        columnNumberTC.setCellValueFactory(new PropertyValueFactory<>("id"));
        columnNameTC.setCellValueFactory(new PropertyValueFactory<>("title"));
        instructionTC.setCellValueFactory(new PropertyValueFactory<>("instructions"));
        instructions.addAll(
                new ImportContactsInstructionTemplate(1,"Contact type \n(Required)",FXCollections.observableArrayList("Available Options:","1 = Customer","2 = Supplier","3 = Both") ),
                new ImportContactsInstructionTemplate(2,"Prefix (Optional)",null),
                new ImportContactsInstructionTemplate(3,"First Name (Required)",null),
                new ImportContactsInstructionTemplate(4,"Middle name (Optional)",null),
                new ImportContactsInstructionTemplate(5,"Last Name (Optional)",null),
                new ImportContactsInstructionTemplate(6,"Business Name(Required if contact type is supplier or both)",null),
                new ImportContactsInstructionTemplate(7,"Contact ID (Optional)",FXCollections.observableArrayList("Leave blank to auto generate Contact ID")),
                new ImportContactsInstructionTemplate(8,"Tax number (Optional)",null),
                new ImportContactsInstructionTemplate(9,"Opening Balance (Optional)",null),
                new ImportContactsInstructionTemplate(10,"Pay term (Required if contact type is supplier or both)",null),
                new ImportContactsInstructionTemplate(11,"Pay term period (Required if contact type is supplier or both)",FXCollections.observableArrayList("Available Options: days and months")),
                new ImportContactsInstructionTemplate(12,"Credit Limit (Optional)",null),
                new ImportContactsInstructionTemplate(13,"Email (Optional)",null),
                new ImportContactsInstructionTemplate(14,"Mobile (Required)",null),
                new ImportContactsInstructionTemplate(15,"Alternate contact number (Optional)",null),
                new ImportContactsInstructionTemplate(16,"Landline (Optional)",null),
                new ImportContactsInstructionTemplate(17,"City (Optional)",null),
                new ImportContactsInstructionTemplate(18,"State (Optional)",null),
                new ImportContactsInstructionTemplate(19,"Country (Optional)",null),
                new ImportContactsInstructionTemplate(20,"Address line 1 (Optional)",null),
                new ImportContactsInstructionTemplate(21,"Address line 2 (Optional)",null),
                new ImportContactsInstructionTemplate(22,"Zip Code (Optional)",null),
                new ImportContactsInstructionTemplate(23,"Date of birth (Optional)", FXCollections.observableArrayList("Format Y-m-d (2020-10-20)")),
                new ImportContactsInstructionTemplate(24,"Custom Field 1 (Optional)",null),
                new ImportContactsInstructionTemplate(25,"Custom Field 2 (Optional)",null),
                new ImportContactsInstructionTemplate(26,"Custom Field 3 (Optional)",null),
                new ImportContactsInstructionTemplate(27,"Custom Field 4 (Optional)",null)
        );
        instructionTBV.setItems(instructions);
        instructionTBV.setFixedCellSize(25);
        instructionTBV.prefHeightProperty().bind(Bindings.size(instructionTBV.getItems()).multiply(instructionTBV.getFixedCellSize()).add(30));
    }

    public void uploadFileButtonAction(ActionEvent event) {
        if(file.exists())
        {
            ;
            //upload the file to remote server
        }
        else
        {
            JOptionPane.showMessageDialog(null,"The Selected File Doesn't Exists.");
        }
    }
}
