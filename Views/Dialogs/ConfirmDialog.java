package BusinessGenie.app.Bossex.Views.Dialogs;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class ConfirmDialog implements Initializable {
    public Label messageLabel;
    public boolean response;

    public void handleOkButton(ActionEvent actionEvent) {
        response=true;
        //Hides the current dialog
        ((Node)(actionEvent.getSource())).getScene().getWindow().hide();
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {}

    public void handleNoButton(ActionEvent actionEvent) {
        response=false;
        //Hides the current dialog
        ((Node)(actionEvent.getSource())).getScene().getWindow().hide();
    }
}
