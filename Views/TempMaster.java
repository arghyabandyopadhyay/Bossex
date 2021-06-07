package BusinessGenie.app.Bossex.Views;

import BusinessGenie.app.Bossex.Bossex;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class TempMaster implements Initializable {
    public TabPane MainAreaTabPane;
    public ImageView newInvoiceImageView;
    public ImageView showPrevInvoicesImageView;
    public ImageView createItemImageView;
    public ImageView inventoryImageView;
    public ImageView createPurchaseOrderImageView;
    public TabPane toolBarTabPane;
    public ImageView settingsImageView;
    public Button settingsButton;
    public ImageView qrSyncImageView;
    public ImageView runningOrderImageView;
    public ImageView previousOrderImageView;
    public ImageView createReportImageView;
    public ImageView customerImageView;
    public ImageView addPaymentImageView;
    public ImageView generateReceiptImageView;
    public ImageView previousReportOrderImageView;
    public ImageView createUserImageView;
    public ImageView usersImageView;
    public ImageView createEmployeeImageView;
    public ImageView currentEmployeeImageView;
    public ImageView previousTodoImageView;
    public ImageView createTodoImageView;
    public ImageView aboutImageView;
    public ImageView downloadUpdateImageView;
    public ImageView helpImageView;
    public ImageView gettingStartedImageView;
    public ImageView contactSupportImageView;
    public ImageView demosAndScreenCastsImageView;
    public ImageView bugReportImageView;
    public ImageView submitFeedbackImageView;
    public ImageView attendanceEmployeeImageView;
    public ImageView holidayImageView;
    public ImageView dashBoardImageView;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }
    public void newInvoiceBtnAction(ActionEvent event) throws IOException {
        Parent loader = FXMLLoader.load(getClass().getResource(Bossex.baseURL+"Views/Fxmls/SalesManager/SalesManagementPage.fxml"));
        Tab tab = new Tab("New Invoice",loader);
        ImageView imageView=new ImageView(new Image(getClass().getResource(Bossex.baseURL+"Views/Resources/invoice.png").toExternalForm()));
        imageView.setFitHeight(20);
        imageView.setFitWidth(20);
        tab.setGraphic(imageView);
        MainAreaTabPane.getTabs().add(tab);
        MainAreaTabPane.getSelectionModel().select(MainAreaTabPane.getTabs().size()-1);
    }

    public void createItemBtnAction(ActionEvent event) throws IOException {
        if(Bossex.permission[1])
        {
            Parent loader = FXMLLoader.load(getClass().getResource(Bossex.baseURL+"Views/Fxmls/InventoryManager/CreateItemPage.fxml"));
            Tab tab = new Tab("Add To Inventory",loader);
            ImageView imageView=new ImageView(new Image(getClass().getResource(Bossex.baseURL+"Views/Resources/addIcon.png").toExternalForm()));
            imageView.setFitHeight(20);
            imageView.setFitWidth(20);
            tab.setGraphic(imageView);
            MainAreaTabPane.getTabs().add(tab);
            MainAreaTabPane.getSelectionModel().select(MainAreaTabPane.getTabs().size()-1);
        }
        else JOptionPane.showMessageDialog(null,"Sorry, you are not authorised for this. Please contact Admin","Error!!",JOptionPane.ERROR_MESSAGE);
    }
    public void inventoryManagerButtonAction(ActionEvent event) throws IOException {
        if(Bossex.permission[2])
        {
            Parent loader = FXMLLoader.load(getClass().getResource(Bossex.baseURL+"Views/Fxmls/InventoryManager/InventoryManagementPage.fxml"));
            Tab tab = new Tab("Inventory",loader);
            ImageView imageView=new ImageView(new Image(getClass().getResource(Bossex.baseURL+"Views/Resources/inventory.png").toExternalForm()));
            imageView.setFitHeight(20);
            imageView.setFitWidth(20);
            tab.setGraphic(imageView);
            MainAreaTabPane.getTabs().add(tab);
            MainAreaTabPane.getSelectionModel().select(MainAreaTabPane.getTabs().size()-1);
        }
        else JOptionPane.showMessageDialog(null,"Sorry, you are not authorised for this. Please contact Admin","Error!!",JOptionPane.ERROR_MESSAGE);
    }

    public void employeeManagerButtonAction(ActionEvent event) throws IOException {
        if(Bossex.permission[1])
        {
            Parent loader = FXMLLoader.load(getClass().getResource(Bossex.baseURL+"Views/Fxmls/EmployeeManager/EmployeeManagementPage.fxml"));
            Tab tab = new Tab("Employees",loader);
            ImageView imageView=new ImageView(new Image(getClass().getResource(Bossex.baseURL+"Views/Resources/employee.png").toExternalForm()));
            imageView.setFitHeight(20);
            imageView.setFitWidth(20);
            tab.setGraphic(imageView);
            MainAreaTabPane.getTabs().add(tab);
            MainAreaTabPane.getSelectionModel().select(MainAreaTabPane.getTabs().size()-1);
        }
        else JOptionPane.showMessageDialog(null,"Sorry, you are not authorised for this. Please contact Admin","Error!!",JOptionPane.ERROR_MESSAGE);
    }

    public void todoButtonAction(ActionEvent event) throws IOException {
        Parent loader = FXMLLoader.load(getClass().getResource(Bossex.baseURL+"Views/Fxmls/TodoPage.fxml"));
        Tab tab = new Tab("Todo",loader);
        ImageView imageView=new ImageView(new Image(getClass().getResource(Bossex.baseURL+"Views/Resources/todoList.png").toExternalForm()));
        imageView.setFitHeight(20);
        imageView.setFitWidth(20);
        tab.setGraphic(imageView);
        MainAreaTabPane.getTabs().add(tab);
        MainAreaTabPane.getSelectionModel().select(MainAreaTabPane.getTabs().size()-1);
    }

    public void settingsButtonAction(ActionEvent event) throws IOException {
        Bossex.universalUtility.nextPage(event,"SettingsPage.fxml","Settings",true);
    }
    public void createEmployeeButtonAction(ActionEvent event) throws IOException {
        Parent loader = FXMLLoader.load(getClass().getResource(Bossex.baseURL+"Views/Fxmls/EmployeeManager/CreateEmployee.fxml"));
        Tab tab = new Tab("Add Employee",loader);
        ImageView imageView=new ImageView(new Image(getClass().getResource(Bossex.baseURL+"Views/Resources/addUser.png").toExternalForm()));
        imageView.setFitHeight(20);
        imageView.setFitWidth(20);
        tab.setGraphic(imageView);
        MainAreaTabPane.getTabs().add(tab);
        MainAreaTabPane.getSelectionModel().select(MainAreaTabPane.getTabs().size()-1);
    }
    public void customerManagerButtonAction(ActionEvent event) throws IOException {
        if(Bossex.permission[0])
        {
            Parent loader = FXMLLoader.load(getClass().getResource(Bossex.baseURL+"Views/Fxmls/CustomerManager/CustomerManagementPage.fxml"));
            Tab tab = new Tab("Customers",loader);
            ImageView imageView=new ImageView(new Image(getClass().getResource(Bossex.baseURL+"Views/Resources/customers.png").toExternalForm()));
            imageView.setFitHeight(20);
            imageView.setFitWidth(20);
            tab.setGraphic(imageView);
            MainAreaTabPane.getTabs().add(tab);
            MainAreaTabPane.getSelectionModel().select(MainAreaTabPane.getTabs().size()-1);
        }
        else JOptionPane.showMessageDialog(null,"Sorry, you are not authorised for this. Please contact Admin","Error!!",JOptionPane.ERROR_MESSAGE);
    }
    public void showPrevInvoicesButtonAction(ActionEvent event) throws IOException {
        Parent loader = FXMLLoader.load(getClass().getResource(Bossex.baseURL+"Views/Fxmls/SalesManager/ShowPreviousBills.fxml"));
        Tab tab = new Tab("Invoices",loader);
        ImageView imageView=new ImageView(new Image(getClass().getResource(Bossex.baseURL+"Views/Resources/invoices.png").toExternalForm()));
        imageView.setFitHeight(20);
        imageView.setFitWidth(20);
        tab.setGraphic(imageView);
        MainAreaTabPane.getTabs().add(tab);
        MainAreaTabPane.getSelectionModel().select(MainAreaTabPane.getTabs().size()-1);
    }

    public void qrScannerSyncButtonAction(ActionEvent event) throws IOException{
        Parent loader = FXMLLoader.load(getClass().getResource(Bossex.baseURL+"Views/Fxmls/SalesManager/SalesManagementPage.fxml"));
        Tab tab = new Tab("Qr Scanner Sync",loader);
        ImageView imageView=new ImageView(new Image(getClass().getResource(Bossex.baseURL+"Views/Resources/qrCode.png").toExternalForm()));
        imageView.setFitHeight(20);
        imageView.setFitWidth(20);
        tab.setGraphic(imageView);
        MainAreaTabPane.getTabs().add(tab);
        MainAreaTabPane.getSelectionModel().select(MainAreaTabPane.getTabs().size()-1);
    }

    public void createPurchaseOrderButtonAction(ActionEvent event) throws IOException{
        Parent loader = FXMLLoader.load(getClass().getResource(Bossex.baseURL+"Views/Fxmls/InventoryManager/InventoryManagementPage.fxml"));
        Tab tab = new Tab("Create Purchase Order",loader);
        MainAreaTabPane.getTabs().add(tab);
        ImageView imageView=new ImageView(new Image(getClass().getResource(Bossex.baseURL+"Views/Resources/newPurchaseOrder.png").toExternalForm()));
        imageView.setFitHeight(20);
        imageView.setFitWidth(20);
        tab.setGraphic(imageView);
        MainAreaTabPane.getSelectionModel().select(MainAreaTabPane.getTabs().size()-1);
    }

    public void runningOrdersButtonAction(ActionEvent event) throws IOException{
        Parent loader = FXMLLoader.load(getClass().getResource(Bossex.baseURL+"Views/Fxmls/InventoryManager/InventoryManagementPage.fxml"));
        Tab tab = new Tab("Running Purchase Orders",loader);
        MainAreaTabPane.getTabs().add(tab);
        ImageView imageView=new ImageView(new Image(getClass().getResource(Bossex.baseURL+"Views/Resources/order.png").toExternalForm()));
        imageView.setFitHeight(20);
        imageView.setFitWidth(20);
        tab.setGraphic(imageView);
        MainAreaTabPane.getSelectionModel().select(MainAreaTabPane.getTabs().size()-1);
    }

    public void showPreviousPurchaseOrdersAction(ActionEvent event) throws IOException{
        Parent loader = FXMLLoader.load(getClass().getResource(Bossex.baseURL+"Views/Fxmls/InventoryManager/InventoryManagementPage.fxml"));
        Tab tab = new Tab("Previous Purchase Order.",loader);
        ImageView imageView=new ImageView(new Image(getClass().getResource(Bossex.baseURL+"Views/Resources/previousOrder.png").toExternalForm()));
        imageView.setFitHeight(20);
        imageView.setFitWidth(20);
        tab.setGraphic(imageView);
        MainAreaTabPane.getTabs().add(tab);
        MainAreaTabPane.getSelectionModel().select(MainAreaTabPane.getTabs().size()-1);
    }

    public void createReportBtnAction(ActionEvent event) throws IOException{
        Parent loader = FXMLLoader.load(getClass().getResource(Bossex.baseURL+"Views/Fxmls/ReportManager/ReportManagementPage.fxml"));
        Tab tab = new Tab("Create Report",loader);
        ImageView imageView=new ImageView(new Image(getClass().getResource(Bossex.baseURL+"Views/Resources/invoice.png").toExternalForm()));
        imageView.setFitHeight(20);
        imageView.setFitWidth(20);
        tab.setGraphic(imageView);
        MainAreaTabPane.getTabs().add(tab);
        MainAreaTabPane.getSelectionModel().select(MainAreaTabPane.getTabs().size()-1);
    }

    public void showPreviousReportButtonAction(ActionEvent event) throws IOException{
        Parent loader = FXMLLoader.load(getClass().getResource(Bossex.baseURL+"Views/Fxmls/ReportManager/ReportManagementPage.fxml"));
        Tab tab = new Tab("Previous Report",loader);
        ImageView imageView=new ImageView(new Image(getClass().getResource(Bossex.baseURL+"Views/Resources/invoice.png").toExternalForm()));
        imageView.setFitHeight(20);
        imageView.setFitWidth(20);
        tab.setGraphic(imageView);
        MainAreaTabPane.getTabs().add(tab);
        MainAreaTabPane.getSelectionModel().select(MainAreaTabPane.getTabs().size()-1);
    }

    public void addPaymentButtonAction(ActionEvent event) throws IOException{
        Parent loader = FXMLLoader.load(getClass().getResource(Bossex.baseURL+"Views/Fxmls/CustomerManager/CustomerManagementPage.fxml"));
        Tab tab = new Tab("Add Payment",loader);
        ImageView imageView=new ImageView(new Image(getClass().getResource(Bossex.baseURL+"Views/Resources/payment.png").toExternalForm()));
        imageView.setFitHeight(20);
        imageView.setFitWidth(20);
        tab.setGraphic(imageView);
        MainAreaTabPane.getTabs().add(tab);
        MainAreaTabPane.getSelectionModel().select(MainAreaTabPane.getTabs().size()-1);
    }

    public void generateReceiptButtonAction(ActionEvent event) throws IOException{
        Parent loader = FXMLLoader.load(getClass().getResource(Bossex.baseURL+"Views/Fxmls/CustomerManager/CustomerManagementPage.fxml"));
        Tab tab = new Tab("Generate Receipt",loader);
        ImageView imageView=new ImageView(new Image(getClass().getResource(Bossex.baseURL+"Views/Resources/receipt.png").toExternalForm()));
        imageView.setFitHeight(20);
        imageView.setFitWidth(20);
        tab.setGraphic(imageView);
        MainAreaTabPane.getTabs().add(tab);
        MainAreaTabPane.getSelectionModel().select(MainAreaTabPane.getTabs().size()-1);
    }

    public void createUserButtonAction(ActionEvent event) throws IOException{
        Parent loader = FXMLLoader.load(getClass().getResource(Bossex.baseURL+"Views/Fxmls/UserManager/CreateUserPage.fxml"));
        Tab tab = new Tab("Create User",loader);
        ImageView imageView=new ImageView(new Image(getClass().getResource(Bossex.baseURL+"Views/Resources/invoice.png").toExternalForm()));
        imageView.setFitHeight(20);
        imageView.setFitWidth(20);
        tab.setGraphic(imageView);
        MainAreaTabPane.getTabs().add(tab);
        MainAreaTabPane.getSelectionModel().select(MainAreaTabPane.getTabs().size()-1);
    }

    public void userManagerButtonAction(ActionEvent event) throws IOException{
        Parent loader = FXMLLoader.load(getClass().getResource(Bossex.baseURL+"Views/Fxmls/UserManager/UserManagementPage.fxml"));
        Tab tab = new Tab("Users",loader);
        ImageView imageView=new ImageView(new Image(getClass().getResource(Bossex.baseURL+"Views/Resources/user.png").toExternalForm()));
        imageView.setFitHeight(20);
        imageView.setFitWidth(20);
        tab.setGraphic(imageView);
        MainAreaTabPane.getTabs().add(tab);
        MainAreaTabPane.getSelectionModel().select(MainAreaTabPane.getTabs().size()-1);
    }

    public void createTodoButtonAction(ActionEvent event) throws IOException{
        Parent loader = FXMLLoader.load(getClass().getResource(Bossex.baseURL+"Views/Fxmls/TodoPage.fxml"));
        Tab tab = new Tab("Create Todo",loader);
        ImageView imageView=new ImageView(new Image(getClass().getResource(Bossex.baseURL+"Views/Resources/invoice.png").toExternalForm()));
        imageView.setFitHeight(20);
        imageView.setFitWidth(20);
        tab.setGraphic(imageView);
        MainAreaTabPane.getTabs().add(tab);
        MainAreaTabPane.getSelectionModel().select(MainAreaTabPane.getTabs().size()-1);
    }

    public void helpButtonAction(ActionEvent event) throws IOException{
        Parent loader = FXMLLoader.load(getClass().getResource(Bossex.baseURL+"Views/Fxmls/Help/HelpPage.fxml"));
        Tab tab = new Tab("Help",loader);
        ImageView imageView=new ImageView(new Image(getClass().getResource(Bossex.baseURL+"Views/Resources/help.png").toExternalForm()));
        imageView.setFitHeight(20);
        imageView.setFitWidth(20);
        tab.setGraphic(imageView);
        MainAreaTabPane.getTabs().add(tab);
        MainAreaTabPane.getSelectionModel().select(MainAreaTabPane.getTabs().size()-1);
    }

    public void gettingStartedButtonAction(ActionEvent event) throws IOException{
        Parent loader = FXMLLoader.load(getClass().getResource(Bossex.baseURL+"Views/Fxmls/Help/GettingStartedPage.fxml"));
        Tab tab = new Tab("Getting Started",loader);
        ImageView imageView=new ImageView(new Image(getClass().getResource(Bossex.baseURL+"Views/Resources/gettingStarted.png").toExternalForm()));
        imageView.setFitHeight(20);
        imageView.setFitWidth(20);
        tab.setGraphic(imageView);
        MainAreaTabPane.getTabs().add(tab);
        MainAreaTabPane.getSelectionModel().select(MainAreaTabPane.getTabs().size()-1);
    }

    public void contactSupportButtonAction(ActionEvent event) throws IOException{
        Parent loader = FXMLLoader.load(getClass().getResource(Bossex.baseURL+"Views/Fxmls/Help/ContactSupport.fxml"));
        Tab tab = new Tab("Support",loader);
        ImageView imageView=new ImageView(new Image(getClass().getResource(Bossex.baseURL+"Views/Resources/invoice.png").toExternalForm()));
        imageView.setFitHeight(20);
        imageView.setFitWidth(20);
        tab.setGraphic(imageView);
        MainAreaTabPane.getTabs().add(tab);
        MainAreaTabPane.getSelectionModel().select(MainAreaTabPane.getTabs().size()-1);
    }

    public void demosAndScreenButtonAction(ActionEvent event) throws IOException{
        Parent loader = FXMLLoader.load(getClass().getResource(Bossex.baseURL+"Views/Fxmls/Help/DemosAndScreencastPage.fxml"));
        Tab tab = new Tab("Demos",loader);
        ImageView imageView=new ImageView(new Image(getClass().getResource(Bossex.baseURL+"Views/Resources/invoice.png").toExternalForm()));
        imageView.setFitHeight(20);
        imageView.setFitWidth(20);
        tab.setGraphic(imageView);
        MainAreaTabPane.getTabs().add(tab);
        MainAreaTabPane.getSelectionModel().select(MainAreaTabPane.getTabs().size()-1);
    }

    public void bugReportButtonAction(ActionEvent event) throws IOException{
        Parent loader = FXMLLoader.load(getClass().getResource(Bossex.baseURL+"Views/Fxmls/Help/ReportBugPage.fxml"));
        Tab tab = new Tab("Report Bug",loader);
        ImageView imageView=new ImageView(new Image(getClass().getResource(Bossex.baseURL+"Views/Resources/bugReport.png").toExternalForm()));
        imageView.setFitHeight(20);
        imageView.setFitWidth(20);
        tab.setGraphic(imageView);
        MainAreaTabPane.getTabs().add(tab);
        MainAreaTabPane.getSelectionModel().select(MainAreaTabPane.getTabs().size()-1);
    }

    public void submitFeedbackButtonAction(ActionEvent event) throws IOException{
        Parent loader = FXMLLoader.load(getClass().getResource(Bossex.baseURL+"Views/Fxmls/Help/SubmitFeedbackPage.fxml"));
        Tab tab = new Tab("Feedback",loader);
        ImageView imageView=new ImageView(new Image(getClass().getResource(Bossex.baseURL+"Views/Resources/invoice.png").toExternalForm()));
        imageView.setFitHeight(20);
        imageView.setFitWidth(20);
        tab.setGraphic(imageView);
        MainAreaTabPane.getTabs().add(tab);
        MainAreaTabPane.getSelectionModel().select(MainAreaTabPane.getTabs().size()-1);
    }

    public void downloadUpdateButtonAction(ActionEvent event) throws IOException{
        Parent loader = FXMLLoader.load(getClass().getResource(Bossex.baseURL+"Views/Fxmls/Help/UpdatePage.fxml"));
        Tab tab = new Tab("Updates",loader);
        ImageView imageView=new ImageView(new Image(getClass().getResource(Bossex.baseURL+"Views/Resources/update.png").toExternalForm()));
        imageView.setFitHeight(20);
        imageView.setFitWidth(20);
        tab.setGraphic(imageView);
        MainAreaTabPane.getTabs().add(tab);
        MainAreaTabPane.getSelectionModel().select(MainAreaTabPane.getTabs().size()-1);
    }

    public void aboutButtonAction(ActionEvent event) {
        Bossex.universalUtility.nextPage(event,"Help/AboutPage.fxml","About",true);
    }

    public void addBrandBtnAction(ActionEvent event) {
    }

    public void attendanceButtonAction(ActionEvent event) {
    }

    public void holidaysButtonAction(ActionEvent event) {
    }
}
