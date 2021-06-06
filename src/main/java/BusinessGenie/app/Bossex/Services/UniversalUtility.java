package BusinessGenie.app.Bossex.Services;

import BusinessGenie.app.Bossex.Bossex;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import java.io.IOException;
import java.util.ListIterator;

import static BusinessGenie.app.Bossex.Bossex.masterTabPane;

public class UniversalUtility {
    public  void nextPage(ActionEvent event, String path, String title,boolean isDialog){
        Scene scene=getScene(path);
        if (isDialog)
        {
            //get the pre defines theme from database
            //scene.getStylesheets().add(getClass().getResource(Bossex.baseURL+"Css/"+ Bossex.userDetails.getTheme()+"Theme.css").toExternalForm());
            scene.getStylesheets().add(getClass().getResource(Bossex.baseURL+"Css/lightTheme.css").toExternalForm());
            Stage stage=new Stage();
            scene.setUserData(event);
            stage.setTitle(Bossex.appTitle+ title);
            stage.setScene(scene);
            stage.setResizable(false);
            stage.initStyle(StageStyle.UTILITY);
            stage.show();
            stage.requestFocus();
        }
        else
        {
            scene.setUserData(event);
            if(path.equals("LoginPage.fxml"));
            //else scene.getStylesheets().add(getClass().getResource(Bossex.baseURL+"Css/"+ Bossex.userDetails.getTheme()+"Theme.css").toExternalForm());
            else scene.getStylesheets().add(getClass().getResource(Bossex.baseURL+"Css/lightTheme.css").toExternalForm());
            Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            primaryStage.setTitle(Bossex.appTitle + title);
            primaryStage.setScene(scene);
            primaryStage.show();
            primaryStage.requestFocus();
        }
    }
    private Scene getScene(String path) {
        if(path.equals("LoginPage.fxml"))
            return Bossex.scene[0];
        else if(path.equals("MasterPage.fxml"))
            return Bossex.scene[1];
        else if(path.equals("SettingsPage.fxml"))
            return Bossex.scene[2];
        else if(path.equals("ReportManager/ReportManagementPage.fxml"))
            return Bossex.scene[4];
        else if(path.equals("InventoryManager/InventoryManagementPage.fxml"))
            return Bossex.scene[5];
        else if(path.equals("UserManager/UserManagementPage.fxml"))
            return Bossex.scene[6];
        else if(path.equals("UserManager/CreateUserPage.fxml"))
            return Bossex.scene[7];
        else if(path.equals("CustomerManager/CustomerManagementPage.fxml"))
            return Bossex.scene[8];
        else if(path.equals("SalesManager/ShowPreviousBills.fxml"))
            return Bossex.scene[9];
        else {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(Bossex.baseURL+"Views/" + path));
            Pane rootNode = null;
            try {
                rootNode = loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            assert rootNode != null;
            return new Scene(rootNode);
        }
    }

    public void refresh(String theme){
        for (Scene scene : Bossex.scene) {
            if (scene != null) {
                if(scene==Bossex.scene[0])continue;
                scene.getStylesheets().clear();
                scene.getStylesheets().add(getClass().getResource(Bossex.baseURL + "Css/" + theme).toExternalForm());
            }
        }
    }
    public static int getTabIndex(String tabName)
    {
        int index=-1;
        ListIterator<Tab> tabListIterator =masterTabPane.getTabs().listIterator();
        for (ListIterator<Tab> it = tabListIterator; it.hasNext(); ) {
            Tab tab = it.next();
            if(tab.getText().equalsIgnoreCase(tabName))index=it.previousIndex();
        }
        return index;
    }
    public  static void openTab(String fxmlUrl,String resourcesUrl,String tabName,boolean isRepeatable) throws IOException {
        if(isRepeatable)
        {
            addTab(fxmlUrl,resourcesUrl,tabName);
        }
        else
        {
            int index=getTabIndex(tabName);
            if(index==-1)
            {
                addTab(fxmlUrl,resourcesUrl,tabName);
            }
            else {
                masterTabPane.getSelectionModel().select(index);
            }
        }
    }
    public static void addTab(String fxmlUrl,String resourcesUrl,String tabName) throws IOException {
        Parent loader = FXMLLoader.load(UniversalUtility.class.getResource(Bossex.baseURL+fxmlUrl));
        Tab tab = new Tab(tabName,loader);
        ImageView imageView=new ImageView(new Image(UniversalUtility.class.getResource(Bossex.baseURL+resourcesUrl).toExternalForm()));
        imageView.setFitHeight(20);
        imageView.setFitWidth(20);
        tab.setGraphic(imageView);
        masterTabPane.getTabs().add(tab);
        masterTabPane.getSelectionModel().select(masterTabPane.getTabs().size()-1);
    }
    public static void openDialog(String fxmlUrl, String dialogTitle) throws IOException{
        FXMLLoader loader = new FXMLLoader(UniversalUtility.class.getResource(Bossex.baseURL+fxmlUrl));
        Pane rootNode = loader.load();
        Scene scene = new Scene(rootNode);
        Stage primaryStage=new Stage();
        primaryStage.setResizable(false);
        primaryStage.setTitle(dialogTitle);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
