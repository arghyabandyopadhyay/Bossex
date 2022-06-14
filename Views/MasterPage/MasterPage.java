package BusinessGenie.app.Bossex.Views.MasterPage;
/*
.root{
    -fx-font-family: "Courier New";
    -fx-base: #dbdbdb;
    -fx-background: #ffffff;
}
 */
import BusinessGenie.app.Bossex.Bossex;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.TabPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static BusinessGenie.app.Bossex.Services.UniversalUtility.openDialog;
import static BusinessGenie.app.Bossex.Services.UniversalUtility.openTab;

public class MasterPage implements Initializable {
    public TabPane MainAreaTabPane;
    public TabPane toolBarTabPane;
    public ImageView manageUsersImageView;
    public ImageView manageRolesImageView;
    public ImageView salesCommissionAgentsImageView;
    public ImageView manageSuppliersImageView;
    public ImageView manageCustomersImageView;
    public ImageView manageCustomersGroupsImageView;
    public ImageView manageProductsImageView;
    public ImageView addProductImageView;
    public ImageView printLabelImageView;
    public ImageView manageProductVariationsImageView;
    public ImageView importProductImageView;
    public ImageView importOpeningStockImageView;
    public ImageView sellingPriceGroupImageView;
    public ImageView manageUnitsImageView;
    public ImageView manageCategoriesImageView;
    public ImageView manageBrandsImageView;
    public ImageView warrantiesImageView;
    public ImageView helpImageView;
    public ImageView gettingStartedImageView;
    public ImageView contactSupportImageView;
    public ImageView demosAndScreenCastsImageView;
    public ImageView bugReportImageView;
    public ImageView submitFeedbackImageView;
    public ImageView downloadUpdateImageView;
    public ImageView aboutImageView;
    public ImageView manageTodoImageView;
    public ImageView openDashBoardImageView;
    public ImageView myProfileImageView;
    public ImageView businessSettingsImageView;
    public ImageView manageBusinessLocationImageView;
    public ImageView manageInvoiceSettingsImageView;
    public ImageView manageBarcodeSettingsImageView;
    public ImageView printerImageView;
    public ImageView manageTaxRatesImageView;
    public ImageView managePurchasesImageView;
    public ImageView addPurchaseImageView;
    public ImageView managePurchaseReturnImageView;
    public ImageView manageSalesImageView;
    public ImageView addSaleImageView;
    public ImageView managePOSImageView;
    public ImageView posImageView;
    public ImageView manageDraftsImageView;
    public ImageView manageQuotationsImageView;
    public ImageView manageSellReturnImageView;
    public ImageView manageShipmentsImageView;
    public ImageView manageDiscountsImageView;
    public ImageView importSalesImageView;
    public ImageView addStockTransfersImageView;
    public ImageView manageStockTransferImageView;
    public ImageView manageStockAdjustmentsImageView;
    public ImageView addStockAdjustmentsImageView;
    public ImageView manageExpensesImageView;
    public ImageView addExpenseImageView;
    public ImageView manageExpenseCategoriesImageView;
    public ImageView profitLossReportImageView;
    public ImageView purchaseSaleReportImageView;
    public ImageView taxReportImageView;
    public ImageView supplierCustomerReportImageView;
    public ImageView customerGroupsReportImageView;
    public ImageView stockReportImageView;
    public ImageView stockAdjustmentReportImageView;
    public ImageView trendingProductsReportImageView;
    public ImageView itemsReportImageView;
    public ImageView productPurchaseReportImageView;
    public ImageView productSellReportImageView;
    public ImageView purchasePaymentReportImageView;
    public ImageView sellPaymentReportImageView;
    public ImageView expenseReportImageView;
    public ImageView registerReportImageView;
    public ImageView salesRepresentativeReportImageView;
    public ImageView notificationTemplateImageView;
    public ImageView productTabImageView;
    public ImageView contactsTabImageView;
    public ImageView userManagementTabImageView;
    public ImageView purchasesTabImageView;
    public ImageView sellTabImageView;
    public ImageView stockTransferTabImageView;
    public ImageView stockAdjustmentsTabImageView;
    public ImageView expensesTabImageView;
    public ImageView reportsTabImageView;
    public ImageView settingsTabImageView;
    public ImageView helpTabImageView;
    public ImageView homeTabImageView;
    public ImageView applicationSettingsImageView;
    public ImageView logOutImageView;
    public ImageView importContactsImageView;
    public BorderPane MasterPageRootPane;
    public ImageView addUserImageView;
    public ImageView addRoleImageView;
    public ImageView addCustomersImageView;
    public ImageView addSuppliersImageView;
    public ImageView hrManagementTabImageView;
    public ImageView manageEmployeeHiringImageView;
    public ImageView manageEmployeePerformanceAndAppraisalImageView;
    public ImageView manageOnboardingAndOffboardingImageView;
    public ImageView administrationImageView;
    public ImageView managePayrollImageView;
    public ImageView trackingAndManagingEmployeeBenefitsImageView;
    public ImageView hrPlanningImageView;
    public ImageView recruitingImageView;
    public ImageView employeeSelfImageView;
    public ImageView manageSchedulingAndRotaImageView;
    public ImageView manageAbsenceImageView;
    public ImageView manageLeaveImageView;
    public ImageView manageReportingAndAnalysisImageView;
    public ImageView manageEmployeeReassingmentImageView;
    public ImageView manageGrievianceHandlingImageView;
    public ImageView toolsTabImageView;
    public ImageView calculatorToolImageView;
    public ImageView spreadSheetToolImageView;
    public ImageView spotifyToolImageView;
    public ImageView whatsappToolImageView;
    public ImageView addCustomersGroupsImageView;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Bossex.masterTabPane=MainAreaTabPane;
        try {
            openDashBoardButtonAction();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void manageUsersButtonAction(ActionEvent event) throws IOException {
        openTab("Views/User/UserManagementPage.fxml","Resources/user.png","Users",false);
    }
    public void manageRolesButtonAction(ActionEvent event) throws IOException {
        openTab("Views/User/RolesPage.fxml","Resources/manageRoles.png","Role",false);
    }
    public void salesCommissionAgentsButtonAction(ActionEvent event) throws IOException {
        openTab("Views/User/SalesCommissionAgentPage.fxml","Resources/salesCommissionAgents.png","SAC",false);
    }
    public void manageSuppliersButtonAction(ActionEvent event) throws IOException {
        openTab("Views/Contacts/SuppliersPage.fxml","Resources/manageSuppliers.png","Suppliers",false);
    }
    public void manageCustomersButtonAction(ActionEvent event) throws IOException {
        openTab("Views/Contacts/CustomersPage.fxml","Resources/customers.png","Customers",false);
    }
    public void manageCustomersGroupsButtonAction(ActionEvent event) throws IOException {
        openTab("Views/Contacts/CustomerGroupsPage.fxml","Resources/customerGroup.png","Customer Groups",false);
    }
    public void importContactsButtonAction(ActionEvent event) throws IOException {
        openTab("Views/Contacts/ImportContacts.fxml","Resources/importContacts.png","Import Contacts",false);
    }
    public void manageProductsButtonAction(ActionEvent event) throws IOException {
        openTab("Views/Products/ProductsManagementPage.fxml","Resources/manageProducts.png","Products Page",false);
    }
    public void addProductButtonAction(ActionEvent event) throws IOException {
        openTab("Views/Products/AddProductPage.fxml","Resources/addProduct.png","Add Product",true);
    }
    public void printLabelButtonAction(ActionEvent event) throws IOException {
        openTab("Views/Products/PrintLabelPage.fxml","Resources/printLabels.png","Print Label",true);
    }
    public void manageProductVariationsButtonAction(ActionEvent event) throws IOException {
        openTab("Views/Products/VariationsPage.fxml","Resources/manageProductVariations.png","Variations",false);
    }
    public void importProductButtonAction(ActionEvent event) throws IOException {
        openTab("Views/Products/ImportProductPage.fxml","Resources/importProducts.png","Import Product",true);
    }
    public void importOpeningStockButtonAction(ActionEvent event) throws IOException {
        openTab("Views/Products/ImportOpeningStocksPage.fxml","Resources/importOpeningStock.png","IOS",true);
    }
    public void sellingPriceGroupButtonAction(ActionEvent event) throws IOException {
        openTab("Views/Products/SellingPriceGroupPage.fxml","Resources/sellingPriceGroups.png","SPG",true);
    }
    public void manageUnitsButtonAction(ActionEvent event) throws IOException {
        openTab("Views/Products/UnitsManagementPage.fxml","Resources/manageUnits.png","Units",false);
    }
    public void manageCategoriesButtonAction(ActionEvent event) throws IOException {
        openTab("Views/Products/CategoriesManagementPage.fxml","Resources/manageCategories.png","Categories",false);
    }
    public void manageBrandsButtonAction(ActionEvent event) throws IOException {
        openTab("Views/Products/BrandsManagementPage.fxml","Resources/manageBrands.png","Brands",false);
    }
    public void warrantiesButtonAction(ActionEvent event) throws IOException {
        openTab("Views/Products/WarrantiesManagementPage.fxml","Resources/manageWarranties.png","Warranties",false);
    }
    public void helpButtonAction(ActionEvent event) throws IOException {
        openTab("Views/Help/HelpPage.fxml","Resources/help.png","Help",false);
    }
    public void gettingStartedButtonAction(ActionEvent event) throws IOException {
        openTab("Views/Help/GettingStartedPage.fxml","Resources/gettingStarted.png","Getting Started",false);
    }
    public void contactSupportButtonAction(ActionEvent event) throws IOException {
        openTab("Views/Help/ContactSupport.fxml","Resources/contactSupport.png","Contact Support",false);
    }
    public void demosAndScreenButtonAction(ActionEvent event) throws IOException {
        openTab("Views/Help/DemosAndScreencastPage.fxml","Resources/demosAndScreenCasts.png","Demonstration",false);
    }
    public void bugReportButtonAction(ActionEvent event) throws IOException {
        openTab("Views/Help/ReportBugPage.fxml","Resources/bugReport.png","Report Bug",false);
    }
    public void submitFeedbackButtonAction(ActionEvent event) throws IOException {
        openTab("Views/Help/SubmitFeedbackPage.fxml","Resources/submitFeedback.png","Submit Feedback",false);
    }
    public void downloadUpdateButtonAction(ActionEvent event) throws IOException {
        openTab("Views/Help/UpdatePage.fxml","Resources/update.png","Updates",false);
    }
    public void aboutButtonAction(ActionEvent event)throws IOException {
        openTab("Views/Help/AboutPage.fxml","Resources/aboutUs.png","About Us",false);
    }

    public void manageTodoButtonAction(ActionEvent event)throws IOException {
        openTab("Views/Home/TodoPage.fxml","Resources/manageTodos.png","Todo",false);
    }

    public void openDashBoardButtonAction()throws IOException {
        openTab("Views/Home/DashboardPage.fxml","Resources/openDashboard.png","Dashboard",false);
    }

    public void myProfileButtonAction(ActionEvent event)throws IOException {
        openTab("Views/Home/ProfilePage.fxml","Resources/myProfile.png","Profile",false);
    }

    public void manageBusinessLocationButtonAction(ActionEvent event)throws IOException {
        openTab("Views/Settings/BusinessLocationPage.fxml","Resources/businessLocation.png","Business Loc.",false);
    }
    public void businessSettingsButtonAction(ActionEvent event)throws IOException {
        openTab("Views/Settings/BusinessSettingsPage.fxml","Resources/businessSettings.png","Business Settings",false);
    }
    public void manageInvoiceSettingsButtonAction(ActionEvent event) throws IOException{
        openTab("Views/Settings/InvoiceSettingsPage.fxml","Resources/invoiceSettings.png","Invoice Settings",false);
    }
    public void manageBarcodeSettingsButtonAction(ActionEvent event)throws IOException {
        openTab("Views/Settings/BarcodeSettingsPage.fxml","Resources/barcodeSettings.png","Barcode Settings",false);
    }
    public void printersButtonAction(ActionEvent event)throws IOException {
        openTab("Views/Settings/PrinterSettingsPage.fxml","Resources/printer.png","Printers",false);
    }
    public void manageTaxRatesButtonAction(ActionEvent event)throws IOException {
        openTab("Views/Settings/TaxRatesSettingsPage.fxml","Resources/tax.png","Tax Rates",false);
    }
    public void managePurchasesButtonAction(ActionEvent event)throws IOException {
        openTab("Views/Purchases/PurchaseManagementPage.fxml","Resources/managePurchases.png","PO",false);
    }
    public void addPurchaseButtonAction(ActionEvent event)throws IOException {
        openTab("Views/Purchases/AddPurchasePage.fxml","Resources/addPurchase.png","add Po",true);
    }
    public void managePurchaseReturnButtonAction(ActionEvent event)throws IOException {
        openTab("Views/Purchases/PurchaseReturnManagementPage.fxml","Resources/managePurchaseReturn.png","PO Return",false);
    }
    public void manageSalesButtonAction(ActionEvent event)throws IOException {
        openTab("Views/Sell/SalesManagementPage.fxml","Resources/manageSales.png","Sales Management",false);
    }
    public void addSaleButtonAction(ActionEvent event)throws IOException {
        openTab("Views/Sell/AddSalePage.fxml","Resources/addSale.png","Add Sales",true);
    }
    public void managePOSButtonAction(ActionEvent event)throws IOException {
        openTab("Views/Sell/PosManagementPage.fxml","Resources/managePos.png","List POS",false);
    }
    public void posButtonAction(ActionEvent event)throws IOException {
        openTab("Views/Sell/PosPage.fxml","Resources/pos.png","POS",true);
    }
    public void manageDraftsButtonAction(ActionEvent event)throws IOException {
        openTab("Views/Sell/DraftManagementPage.fxml","Resources/manageDrafts.png","Drafts",false);
    }
    public void manageQuotationsButtonAction(ActionEvent event)throws IOException {
        openTab("Views/Sell/QuotationManagementPage.fxml","Resources/manageQuotations.png","Quotations",false);
    }
    public void manageSellReturnButtonAction(ActionEvent event)throws IOException {
        openTab("Views/Sell/SellReturnManagementPage.fxml","Resources/manageSellReturn.png","Sell Return",false);
    }
    public void manageShipmentsButtonAction(ActionEvent event)throws IOException {
        openTab("Views/Sell/ShipmentManagementPage.fxml","Resources/manageShipments.png","Shipments",false);
    }
    public void manageDiscountsButtonAction(ActionEvent event)throws IOException {
        openTab("Views/Sell/DiscountManagementPage.fxml","Resources/manageDiscounts.png","Discounts",false);
    }
    public void importSalesButtonAction(ActionEvent event)throws IOException {
        openTab("Views/Sell/ImportSalesPage.fxml","Resources/importSales.png","Import Sales",false);
    }
    public void addStockTransfersButtonAction(ActionEvent event)throws IOException {
        openTab("Views/StockTransfers/AddStockTransferPage.fxml","Resources/addStockTransfer.png","Add ST",true);
    }
    public void manageStockTransferButtonAction(ActionEvent event)throws IOException {
        openTab("Views/StockTransfers/StockTransferManagementPage.fxml","Resources/manageStockTransfer.png","Stock Transfer",false);
    }
    public void manageStockAdjustmentsButtonAction(ActionEvent event)throws IOException {
        openTab("Views/StockAdjustments/StockAdjustmentManagementPage.fxml","Resources/manageStockAdjustments.png","Stock Adjustment",false);
    }
    public void addStockAdjustmentsButtonAction(ActionEvent event)throws IOException {
        openTab("Views/StockAdjustments/AddStockAdjustmentPage.fxml","Resources/addStockAdjustment.png","Add SA",true);
    }
    public void manageExpensesButtonAction(ActionEvent event)throws IOException {
        openTab("Views/Expenses/ExpensesManagementPage.fxml","Resources/manageExpenses.png","Expenses",false);
    }
    public void addExpenseButtonAction(ActionEvent event)throws IOException {
        openTab("Views/Expenses/AddExpensesPage.fxml","Resources/addExpense.png","Add Expenses",true);
    }
    public void manageExpenseCategoriesButtonAction(ActionEvent event)throws IOException {
        openTab("Views/Expenses/ExpenseCategoriesPage.fxml","Resources/expensesGroups.png","Expense Categories",false);
    }
    public void profitLossReportButtonAction(ActionEvent event)throws IOException {
        openTab("Views/Reports/ProfitLossReportPage.fxml","Resources/reports.png","Profit / Loss Report",true);
    }
    public void purchaseSaleReportButtonAction(ActionEvent event)throws IOException {
        openTab("Views/Reports/PurchaseSaleReportPage.fxml","Resources/reports.png","Purchase Sale Report",true);
    }
    public void taxReportButtonAction(ActionEvent event)throws IOException {
        openTab("Views/Reports/TaxReportPage.fxml","Resources/reports.png","Tax Report",true);
    }
    public void supplierCustomerReportButtonAction(ActionEvent event)throws IOException {
        openTab("Views/Reports/SupplierCustomerReportPage.fxml","Resources/reports.png","Supplier Customer Report",true);
    }
    public void customerGroupsReportButtonAction(ActionEvent event)throws IOException {
        openTab("Views/Reports/CustomerGroupsReportPage.fxml","Resources/reports.png","Customer Group Report",true);
    }
    public void stockReportButtonAction(ActionEvent event)throws IOException {
        openTab("Views/Reports/StockReportPage.fxml","Resources/reports.png","Stock Report",true);
    }
    public void stockAdjustmentReportButtonAction(ActionEvent event)throws IOException {
        openTab("Views/Reports/StockAdjustmentReportPage.fxml","Resources/reports.png","Stock Adjustment Report",true);
    }
    public void trendingProductsReportButtonAction(ActionEvent event)throws IOException {
        openTab("Views/Reports/TrendingProductsReportPage.fxml","Resources/reports.png","Trending Report",true);
    }
    public void itemsReportButtonAction(ActionEvent event)throws IOException {
        openTab("Views/Reports/ItemsReportPage.fxml","Resources/reports.png","Item Report",true);
    }
    public void productPurchaseReportButtonAction(ActionEvent event)throws IOException {
        openTab("Views/Reports/ProductPurchaseReportPage.fxml","Resources/reports.png","Product Purchase Report",true);
    }
    public void productSellReportButtonAction(ActionEvent event)throws IOException {
        openTab("Views/Reports/ProductSellReportPage.fxml","Resources/reports.png","Product Sale Report",true);
    }
    public void purchasePaymentReportButtonAction(ActionEvent event)throws IOException {
        openTab("Views/Reports/PurchasePaymentReportPage.fxml","Resources/reports.png","Purchase Payment Report",true);
    }
    public void sellPaymentReportButtonAction(ActionEvent event)throws IOException {
        openTab("Views/Reports/SellPaymentReportPage.fxml","Resources/reports.png","Sell Payment Report",true);
    }
    public void expenseReportButtonAction(ActionEvent event)throws IOException {
        openTab("Views/Reports/ExpenseReportPage.fxml","Resources/reports.png","Expense Report",true);
    }
    public void registerReportButtonAction(ActionEvent event)throws IOException {
        openTab("Views/Reports/RegisterReportPage.fxml","Resources/reports.png","Register Report",true);
    }
    public void salesRepresentativeReportButtonAction(ActionEvent event)throws IOException {
        openTab("Views/Reports/SalesRepresentativeReportPage.fxml","Resources/reports.png","Sales Represent. Report",true);
    }
    public void notificationTemplateButtonAction(ActionEvent event)throws IOException {
        openTab("Views/Settings/NotificationTemplateSettingsPage.fxml","Resources/notificationTemplate.png","Notification Template",false);
    }
    public void addUserButtonAction(ActionEvent event)throws IOException {
        openTab("Views/User/AddUsersPage.fxml","Resources/addUser.png","Add Users",false);
    }
    public void addRoleButtonAction(ActionEvent event)throws IOException {
        openTab("Views/User/AddRolesPage.fxml","Resources/addRoles.png","Add Roles",false);
    }
    public void addCustomersButtonAction(ActionEvent event)throws IOException {
        openTab("Views/Contacts/AddCustomersPage.fxml","Resources/addContacts.png","Add Customers",false);
    }
    public void addCustomersGroupButtonAction(ActionEvent event)throws IOException {
        openTab("Views/Contacts/AddCustomerGroupPage.fxml","Resources/customerGroup.png","Add Customer Group",false);
    }
    public void addSuppliersButtonAction(ActionEvent event)throws IOException {
        openTab("Views/Contacts/AddSuppliersPage.fxml","Resources/addSupplier.png","Add Suppliers",false);
    }
    public void applicationSettingsButtonAction(ActionEvent event)throws IOException
    {
        openTab("Views/Settings/BossexSettingsPage.fxml","Resources/settings.png","Settings",false);
    }
    public void logOutButtonAction(ActionEvent event) throws IOException {
    }

    public void manageAppraisalsButtonAction(ActionEvent event) {
    }

    public void manageEmployeeHiringButtonAction(ActionEvent event) {
    }

    public void manageEmployeeTrainingAndDevelopmentButtonAction(ActionEvent event) {
    }

    public void manageEmployeePerformanceButtonAction(ActionEvent event) {
    }

    public void manageEmployeePerformanceAndAppraisalButtonAction(ActionEvent event) {
    }

    public void manageOnboardingAndOffboardingButtonAction(ActionEvent event) {
    }

    public void administrationButtonAction(ActionEvent event) {
    }

    public void managePayrollButtonAction(ActionEvent event) {
    }

    public void trackingAndManagingEmployeeBenefitsButtonAction(ActionEvent event) {
    }

    public void hrPlanningButtonAction(ActionEvent event) {
    }

    public void recruitingButtonAction(ActionEvent event) {
    }

    public void employeeSelfButtonAction(ActionEvent event) {
    }

    public void manageSchedulingAndRotaButtonAction(ActionEvent event) {
    }

    public void manageAbsenceButtonAction(ActionEvent event) {
    }

    public void manageLeaveButtonAction(ActionEvent event) {
    }

    public void manageReporingAndAnalysisButtonAction(ActionEvent event) {
    }

    public void manageEmployeeReassingmentButtonAction(ActionEvent event) {
    }

    public void manageGrievianceHandlingButtonAction(ActionEvent event) {
    }

    public void calculatorToolButtonAction(ActionEvent actionEvent) throws IOException {
        openDialog("Views/Tools/Calculator.fxml","Calculator");
    }

    public void spreadSheetToolButtonAction(ActionEvent actionEvent) {
    }

    public void spotifyToolButtonAction(ActionEvent actionEvent) {
    }

    public void whatsappToolButtonAction(ActionEvent actionEvent) {
    }
}