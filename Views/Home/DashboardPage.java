package BusinessGenie.app.Bossex.Views.Home;

import BusinessGenie.app.Bossex.Bossex;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Tab;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static BusinessGenie.app.Bossex.Bossex.masterTabPane;
import static BusinessGenie.app.Bossex.Services.UniversalUtility.getTabIndex;

public class DashboardPage implements Initializable {
    public ImageView totalSalesImageView;
    public ImageView purchaseDueImageView;
    public ImageView totalPurchaseImageView;
    public ImageView invoiceDueImageView;
    public ImageView expenseDueImageView;
    public ToggleGroup toggleGroup;
    public ToggleButton todayToggleButton;
    public ToggleButton thisWeekToggleButton;
    public ToggleButton thisMonthToggleButton;
    public ToggleButton thisFinancialYearToggleButton;
    public BorderPane DashboardBorderPane;
    public ToggleButton thisQuarterToggleButton;
    public ImageView productStockAlertCautionImageView;
    public ImageView purchasePaymentDueCautionImageView;
    public ImageView salesPaymentDueCautionImageView;
    public ImageView exportToCSVImageView1;
    public ImageView exportToExcelImageView1;
    public ImageView exportToPDFImageView1;
    public ImageView printImageView1;
    public ImageView exportToCSVImageView2;
    public ImageView exportToExcelImageView2;
    public ImageView exportToPDFImageView2;
    public ImageView printImageView2;
    public ImageView exportToCSVImageView3;
    public ImageView exportToExcelImageView3;
    public ImageView exportToPDFImageView3;
    public ImageView printImageView3;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        toggleGroup=new ToggleGroup();
        todayToggleButton.setToggleGroup(toggleGroup);
        thisWeekToggleButton.setToggleGroup(toggleGroup);
        thisMonthToggleButton.setToggleGroup(toggleGroup);
        thisFinancialYearToggleButton.setToggleGroup(toggleGroup);
        thisQuarterToggleButton.setToggleGroup(toggleGroup);

    }

    public void totalPurchaseImageView(ActionEvent event) throws IOException {
        int index=getTabIndex("PO");
        if(index==-1)
        {
            Parent loader = FXMLLoader.load(getClass().getResource(Bossex.baseURL+"Views/Purchases/PurchaseManagementPage.fxml"));
            Tab tab = new Tab("PO",loader);
            ImageView imageView=new ImageView(new Image(getClass().getResource(Bossex.baseURL+"Resources/managePurchases.png").toExternalForm()));
            imageView.setFitHeight(20);
            imageView.setFitWidth(20);
            tab.setGraphic(imageView);
            Bossex.masterTabPane.getTabs().add(tab);
            Bossex.masterTabPane.getSelectionModel().select(Bossex.masterTabPane.getTabs().size()-1);
        }
        else {
            masterTabPane.getSelectionModel().select(index);
        }
    }

    public void totalSalesButtonAction(ActionEvent event) throws IOException {
        int index=getTabIndex("PO");
        if(index==-1)
        {
            Parent loader = FXMLLoader.load(getClass().getResource(Bossex.baseURL+"Views/Sell/SalesManagementPage.fxml"));
            Tab tab = new Tab("Sales Management",loader);
            ImageView imageView=new ImageView(new Image(getClass().getResource(Bossex.baseURL+"Resources/manageSales.png").toExternalForm()));
            imageView.setFitHeight(20);
            imageView.setFitWidth(20);
            tab.setGraphic(imageView);
            Bossex.masterTabPane.getTabs().add(tab);
            Bossex.masterTabPane.getSelectionModel().select(Bossex.masterTabPane.getTabs().size()-1);
        }
        else {
            masterTabPane.getSelectionModel().select(index);
        }
    }

    public void purchaseDueButtonAction(ActionEvent event) throws IOException {
        int index=getTabIndex("PO Return");
        if(index==-1)
        {
            Parent loader = FXMLLoader.load(getClass().getResource(Bossex.baseURL+"Views/Purchases/PurchaseReturnManagementPage.fxml"));
            Tab tab = new Tab("PO Return",loader);
            ImageView imageView=new ImageView(new Image(getClass().getResource(Bossex.baseURL+"Resources/managePurchaseReturn.png").toExternalForm()));
            imageView.setFitHeight(20);
            imageView.setFitWidth(20);
            tab.setGraphic(imageView);
            Bossex.masterTabPane.getTabs().add(tab);
            Bossex.masterTabPane.getSelectionModel().select(Bossex.masterTabPane.getTabs().size()-1);
        }
        else
        {
            masterTabPane.getSelectionModel().select(index);
        }
    }

    public void invoiceDueButtonAction(ActionEvent event) throws IOException {
        int index=getTabIndex("Sell Return");
        if(index==-1)
        {
            Parent loader = FXMLLoader.load(getClass().getResource(Bossex.baseURL+"Views/Sell/SellReturnManagementPage.fxml"));
        Tab tab = new Tab("Sell Return",loader);
        ImageView imageView=new ImageView(new Image(getClass().getResource(Bossex.baseURL+"Resources/manageSellReturn.png").toExternalForm()));
        imageView.setFitHeight(20);
        imageView.setFitWidth(20);
        tab.setGraphic(imageView);
        Bossex.masterTabPane.getTabs().add(tab);
        Bossex.masterTabPane.getSelectionModel().select(Bossex.masterTabPane.getTabs().size()-1);
        }
        else {
            masterTabPane.getSelectionModel().select(index);
        }
    }

    public void expenseDueButtonAction(ActionEvent event) throws IOException {
        int index=getTabIndex("Expenses");
        if(index==-1)
        {
            Parent loader = FXMLLoader.load(getClass().getResource(Bossex.baseURL+"Views/Expenses/ExpensesManagementPage.fxml"));
            Tab tab = new Tab("Expenses",loader);
            ImageView imageView=new ImageView(new Image(getClass().getResource(Bossex.baseURL+"Resources/manageExpenses.png").toExternalForm()));
            imageView.setFitHeight(20);
            imageView.setFitWidth(20);
            tab.setGraphic(imageView);
            Bossex.masterTabPane.getTabs().add(tab);
            Bossex.masterTabPane.getSelectionModel().select(Bossex.masterTabPane.getTabs().size()-1);
        }
        else {
            masterTabPane.getSelectionModel().select(index);
        }
    }
}
