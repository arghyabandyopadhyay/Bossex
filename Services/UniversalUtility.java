package BusinessGenie.app.Bossex.Services;

import BusinessGenie.app.Bossex.Bossex;
import BusinessGenie.app.Bossex.Views.Dialogs.ConfirmDialog;
import BusinessGenie.app.Bossex.Views.Dialogs.MessageDialog;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.util.ListIterator;
import java.util.Objects;

import static BusinessGenie.app.Bossex.Bossex.masterTabPane;

public class UniversalUtility {
    public  void nextPage(ActionEvent event, String path, String title,boolean isDialog){
        Scene scene=getScene(path);
        if (isDialog)
        {
            //get the pre defines theme from database
            //scene.getStylesheets().add(getClass().getResource(Bossex.baseURL+"Css/"+ Bossex.userDetails.getTheme()+"Theme.css").toExternalForm());
            scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource(Bossex.baseURL + "Css/lightTheme.css")).toExternalForm());
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
            if(!path.equals("LoginPage.fxml"))scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource(Bossex.baseURL + "Css/lightTheme.css")).toExternalForm());
            Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            primaryStage.setTitle(Bossex.appTitle + title);
            primaryStage.setScene(scene);
            primaryStage.show();
            primaryStage.requestFocus();
        }
    }
    private Scene getScene(String path) {
        switch (path) {
            case "LoginPage.fxml":
                return Bossex.scene[0];
            case "MasterPage.fxml":
                return Bossex.scene[1];
            case "SettingsPage.fxml":
                return Bossex.scene[2];
            case "ReportManager/ReportManagementPage.fxml":
                return Bossex.scene[4];
            case "InventoryManager/InventoryManagementPage.fxml":
                return Bossex.scene[5];
            case "UserManager/UserManagementPage.fxml":
                return Bossex.scene[6];
            case "UserManager/CreateUserPage.fxml":
                return Bossex.scene[7];
            case "CustomerManager/CustomerManagementPage.fxml":
                return Bossex.scene[8];
            case "SalesManager/ShowPreviousBills.fxml":
                return Bossex.scene[9];
            default:
                FXMLLoader loader = new FXMLLoader(getClass().getResource(Bossex.baseURL + "Views/" + path));
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
                scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource(Bossex.baseURL + "Css/" + theme)).toExternalForm());
            }
        }
    }
    public static int getTabIndex(String tabName)
    {
        int index=-1;
        ListIterator<Tab> tabListIterator =masterTabPane.getTabs().listIterator();
        while (tabListIterator.hasNext()) {
            Tab tab = tabListIterator.next();
            if(tab.getText().equalsIgnoreCase(tabName))index= tabListIterator.previousIndex();
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
        Parent loader = FXMLLoader.load(Objects.requireNonNull(UniversalUtility.class.getResource(Bossex.baseURL + fxmlUrl)));
        Tab tab = new Tab(tabName,loader);
        ImageView imageView=new ImageView(new Image(Objects.requireNonNull(UniversalUtility.class.getResource(Bossex.baseURL + resourcesUrl)).toExternalForm()));
        imageView.setFitHeight(20);
        imageView.setFitWidth(20);
        tab.setGraphic(imageView);
        masterTabPane.getTabs().add(tab);
        masterTabPane.getSelectionModel().select(masterTabPane.getTabs().size()-1);
    }
    //Opens dialog according to the fxml url being passed.
    // The title of the dialog box is set according to the dialog title being passed in the second parameter.
    public static void openDialog(String fxmlUrl, String dialogTitle){
        FXMLLoader loader = new FXMLLoader(UniversalUtility.class.getResource(Bossex.baseURL+fxmlUrl));
        Pane rootNode;
        try {
            rootNode = loader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Scene scene = new Scene(rootNode);
        Stage primaryStage=new Stage();
        primaryStage.setResizable(false);
        primaryStage.setTitle(dialogTitle);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public static void openMessageDialog(String message, String dialogTitle) {
        System.out.println(message);
        FXMLLoader loader = new FXMLLoader(UniversalUtility.class.getResource(Bossex.baseURL+"Views/Dialogs/MessageDialog.fxml"));
        Pane rootNode;
        try {
            rootNode = loader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Scene scene = new Scene(rootNode);
        Stage primaryStage=new Stage();
        MessageDialog messageDialog=loader.getController();
        messageDialog.messageLabel.setText(message);
        primaryStage.setUserData(message);
        primaryStage.setResizable(false);
        primaryStage.setTitle(dialogTitle);
        primaryStage.setScene(scene);
        primaryStage.showAndWait();
    }

    public static boolean openConfirmDialog(String message, String dialogTitle) {
        System.out.println(message);
        FXMLLoader loader = new FXMLLoader(UniversalUtility.class.getResource(Bossex.baseURL+"Views/Dialogs/ConfirmDialog.fxml"));
        Pane rootNode;
        try {
            rootNode = loader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Scene scene = new Scene(rootNode);
        Stage primaryStage=new Stage();
        ConfirmDialog confirmDialog=loader.getController();
        confirmDialog.messageLabel.setText(message);
        primaryStage.setUserData(message);
        primaryStage.setResizable(false);
        primaryStage.setTitle(dialogTitle);
        primaryStage.setScene(scene);
        primaryStage.showAndWait();
        return confirmDialog.response;
    }

//    private void addButtonToTable(TableView tableView, ObservableList observableList, Class<?> cls) {
//        TableColumn<UserRoleModel, Void> colBtn = new TableColumn<>("Button Column");
//
//        Callback<TableColumn<cls, Void>, TableCell<UserRoleModel, Void>> cellFactory = new Callback<TableColumn<UserRoleModel, Void>, TableCell<UserRoleModel, Void>>() {
//            @Override
//            public TableCell<UserRoleModel, Void> call(final TableColumn<UserRoleModel, Void> param) {
//                return new TableCell<UserRoleModel, Void>() {
//
//                    private final Button btn = new Button("Delete");
//
//                    {
//                        btn.setOnAction((ActionEvent event) -> {
//                            UserRoleModel userRoleModel = getTableView().getItems().get(getIndex());
//                            DatabaseAccessor databaseAccessor=new DatabaseAccessor();
//                            databaseAccessor.deleteRole(userRoleModel);
//                            observableList.remove(userRoleModel);
//
//                        });
//                    }
//
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
//            }
//        };
//
//        colBtn.setCellFactory(cellFactory);
//        tableView.getColumns().add(colBtn);
//    }
}
