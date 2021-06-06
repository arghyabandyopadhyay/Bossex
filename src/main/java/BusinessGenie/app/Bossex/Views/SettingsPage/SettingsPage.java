package BusinessGenie.app.Bossex.Views.SettingsPage;

import BusinessGenie.app.Bossex.Bossex;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.net.URL;
import java.util.ResourceBundle;

public class SettingsPage implements Initializable {
    public ComboBox<String> themeComboBox;
    public ImageView previewTheme;
    public Button applyButton;
    public Scene scene1;
    public Button cancelButton;
    public Button okButton;
    boolean isApplyButtonPressed=false;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ObservableList<String> observableList= FXCollections.observableArrayList();
        observableList.addAll("Dark Theme","Light Theme");
        previewTheme.setImage(new Image(getClass().getResource(Bossex.baseURL+"Resources/darkThemePreview.png").toExternalForm()));
        themeComboBox.setItems(observableList);
        themeComboBox.getSelectionModel().select(0);
        themeComboBox.setOnAction(event -> {
            if(themeComboBox.getSelectionModel().getSelectedItem()!=null)changePreviewImage(themeComboBox.getSelectionModel().getSelectedIndex());
            isApplyButtonPressed=false;
        });
        applyButton.setOnAction(actionEvent -> {
            if(themeComboBox.getSelectionModel().getSelectedItem()!=null&&!isApplyButtonPressed)setTheme(actionEvent,themeComboBox.getSelectionModel().getSelectedIndex());
            isApplyButtonPressed=true;
        });
        okButton.setOnAction(actionEvent -> {
            if(!isApplyButtonPressed){
                applyButton.fire();
            }
            ((Node)actionEvent.getSource()).getScene().getWindow().hide();
        });
        cancelButton.setOnAction(actionEvent->{
            ((Node)actionEvent.getSource()).getScene().getWindow().hide();
        });
    }

    private void setTheme(ActionEvent actionEvent, int selectedIndex) {
        Scene scene=((Node) actionEvent.getSource()).getScene();
        scene.getStylesheets().clear();
        //DatabaseAccessor accessor=new DatabaseAccessor();
        if(selectedIndex==1) {
            scene.getStylesheets().add(getClass().getResource(Bossex.baseURL+"Css/lightTheme.css").toExternalForm());
            /*if (scene1==null)
            {
                scene1=((Node)((ActionEvent) ((Node) actionEvent.getSource()).getScene().getUserData()).getSource()).getScene();
            }*/
            Bossex.universalUtility.refresh("lightTheme.css");
            Bossex.userDetails.setTheme("light");
            //database update
        }
        else
        {
            scene.getStylesheets().add(getClass().getResource(Bossex.baseURL+"Css/darkTheme.css").toExternalForm());
            /*if (scene1==null)
            {
                scene1=((Node)((ActionEvent) ((Node) actionEvent.getSource()).getScene().getUserData()).getSource()).getScene();
            }*/
            Bossex.universalUtility.refresh("darkTheme.css");
            Bossex.userDetails.setTheme("dark");
            //database update
        }
        //Bossex.apiAccessor.setTheme(Bossex.userDetails.getUid(),Bossex.userDetails.getTheme());
    }

    private void changePreviewImage(int selectedIndex) {
        if(selectedIndex==1)
            previewTheme.setImage(new Image(getClass().getResource(Bossex.baseURL+"Resources/lightThemePreview.png").toExternalForm()));
        else
            previewTheme.setImage(new Image(getClass().getResource(Bossex.baseURL+"Resources/darkThemePreview.png").toExternalForm()));
    }
}
