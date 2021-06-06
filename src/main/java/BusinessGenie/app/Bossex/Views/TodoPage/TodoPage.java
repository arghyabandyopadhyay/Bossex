package BusinessGenie.app.Bossex.Views.TodoPage;

import BusinessGenie.app.Bossex.Models.TodoTableItem;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Paint;

import javax.swing.*;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

public class TodoPage implements Initializable {
    public TableView<TodoTableItem> todoTable;
    public TableColumn<TodoTableItem, String> todoDescTbc;
    public TableColumn<TodoTableItem, String> dateTbc;
    public Button createTodoBtn;
    public Button printBtn;
    public Button deleteBtn;
    public TextArea todoDescTa;
    public Label sizeLbl;
    public Button closeBtn;
    int taSize=0;
    public void printMenuAction(ActionEvent event) {
        printBtn.fire();
    }
    public void closeMenuAction(ActionEvent event) {
        closeBtn.fire();
    }
    public void undoMenuAction(ActionEvent event) {
        todoDescTa.undo();
    }
    public void redoMenuAction(ActionEvent event) {
        todoDescTa.redo();
    }
    public void deleteMenuAction(ActionEvent event) {
        deleteBtn.fire();
    }
    public void printBtnAction(ActionEvent event) {
    }
    public void addMenuAction(ActionEvent event) {
        createTodoBtn.fire();
    }
    public void deleteBtnAction(ActionEvent event) {
        ObservableList<TodoTableItem> selectedItem = todoTable.getSelectionModel().getSelectedItems();
        if(selectedItem.size()>0)
        {
            if(JOptionPane.showConfirmDialog(null,"Are You Sure? The Todo Item data can't be recovered.","Confirm!!",JOptionPane.OK_CANCEL_OPTION)==0)
            {
                //Bossex.apiAccessor.deleteTodo(selectedItem);
                todoTable.getItems().removeAll(selectedItem);
            }
        }
        else JOptionPane.showMessageDialog(null,"Please Select a Todo Item For Deleting","Error!!",JOptionPane.ERROR_MESSAGE);
    }
    public void closeBtnAction(ActionEvent event) {
        ((Node)event.getSource()).getScene().getWindow().hide();
    }
    public void createTodoBtnAction(ActionEvent event) {
        if(todoDescTa.getLength()>0)
        {
            if(todoDescTa.getLength()<255)
            {
                LocalDateTime now = LocalDateTime.now();
                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                //Bossex.apiAccessor.addTodo(todoDescTa.getText(), dtf.format(now));
                todoTable.getItems().clear();
                //todoTable.getItems().addAll(Bossex.apiAccessor.getTodoList());
                todoDescTa.clear();
            }
            else
            {
                JOptionPane.showMessageDialog(null,"The length of the todo can't be greater than 255 ");
                todoDescTa.requestFocus();
            }
        }
        else
        {
            JOptionPane.showMessageDialog(null,"Please Type something in the field below the Table ");
            todoDescTa.requestFocus();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        todoDescTbc.setCellValueFactory(new PropertyValueFactory<>("todoDescription"));
        dateTbc.setCellValueFactory(new PropertyValueFactory<>("date"));
        //todoTable.getItems().addAll(Bossex.apiAccessor.getTodoList());
    }
    public void checkSize(KeyEvent keyEvent) {
        taSize=todoDescTa.getLength();
        sizeLbl.setText(taSize+"/255");
        if(taSize>255)sizeLbl.setTextFill(Paint.valueOf("#ff0000"));
        else sizeLbl.setTextFill(Paint.valueOf("#9c9c9c"));
    }


}
