package BusinessGenie.app.Bossex.Views.Sell;

import BusinessGenie.app.Bossex.Bossex;
import BusinessGenie.app.Bossex.Models.InventoryTableItem;
import BusinessGenie.app.Bossex.Models.InvoiceTableItem;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;

import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

import static java.lang.Math.ceil;

public class AddSalePage  implements Initializable {
    public Label label;
    /**
     * Buttons
     */
//    public Button newInvoiceBtn;
//    public Button showPrevInvoicesBtn;
//    public Button checkOutBtn;
//    public Button customerBtn;
//    public Button addBtn;
//    public Button deleteBtn;
//    public Button closeButton;
//    public Button inventoryBtn;
//    public Button settingsBtn;

    /**
     * MenuItems
     */
    public MenuItem newInvoiceMenu;
    public MenuItem closeMenu;
    public MenuItem exitMenu;
    public MenuItem checkOutMenu;
    public MenuItem settingsMenu;
    public MenuItem clearMenu;
    public MenuItem deleteMenu;
    public MenuItem showInvoicesMenu;
    public MenuItem helpMenuItem;
    public MenuItem gettingStartedMenuItem;
    public MenuItem demoMenuItem;
    public MenuItem tipOfDayMenuItem;
    public MenuItem contactSupportMenuItem;
    public MenuItem reportBugMenuItem;
    public MenuItem submitFeedbackMenuItem;
    public MenuItem updatesMenuItem;
    public MenuItem aboutMenuItem;
    public MenuItem enterPresentationMenu;
    public MenuItem distractionFreeMenu;
    public MenuItem todoMenu;
    public MenuItem undoMenu;
    public MenuItem redoMenu;

    /**
     * Text fields
     */
    public TextField invoiceDateTf;
    public TextField customerNameTf;
    public TextField invoiceNoTf;
    public TextField customerMnoTf;
    public TextField itemTf;
    public TextField scannerTf;
    public TextField qtyTf;
    public TextField priceTf;
    public TextField discountTf;
    public TextField taxTf;
    public TextField totalTf;
    public TextField totalItemsTf;
    public TextField totalQtyTf;
    public TextField totalAmountTf;
    public TextField setOffTf;
    public TextField finalAmountTf;
    public TextField paymentValueTf;
    public TextField balanceAmountTf;

    /**
     * Text Area
     */
    public TextArea commentsTa;

    /**
     * TableView
     */
    public TableView<InvoiceTableItem> invoiceTable;

    /**
     * TableColumn
     */
    public TableColumn<InvoiceTableItem, String> posTc;
    public TableColumn<InvoiceTableItem, String> productNameTc;
    public TableColumn<InvoiceTableItem, String> unitPriceTc;
    public TableColumn<InvoiceTableItem, String> qtyTc;
    public TableColumn<InvoiceTableItem, Double> discountTc;
    public TableColumn<InvoiceTableItem, Double> totalTc;

    /**
     *Member Variables
     */
    static int ivnNum=0,pr=0;
    public HBox itemHbox;
    public ListView<String> inventoryList;
    public MenuItem inventoryMenu;
    public MenuItem customerMenu;
    int pos=0,serial=0;
    double totalInvoiceAmount=0;
    String st="";
    LinkedList<String> searchResult;
    private final SortedSet<String> entries=new TreeSet<>();
    protected final static ObservableList<InvoiceTableItem> data =
            FXCollections.observableArrayList();
    private double qty;
    private double tPrice;
    private double paymentAmount=0.0;
    private String invoiceNumber;
    private String[] array =getArray();
    private double sOff=0;
    List<InventoryTableItem> inventoryTableItemList;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        String today=getDate();
        generateInvoiceNumber(today);
        invoiceDateTf.setText(today);
        invoiceTable.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        invoiceTable.setPlaceholder(new Label("No entries yet."));
        inventoryTableItemList= Bossex.databaseAccessor.getInventoryList();
        for(InventoryTableItem inventoryTableItem: inventoryTableItemList) entries.add(inventoryTableItem.getName().toUpperCase()+":"+inventoryTableItem.getUid().toUpperCase());
        inventoryList.getItems().addAll(entries);
        itemTf.focusedProperty().addListener((observableValue, aBoolean, aBoolean2) -> {
            inventoryList.setVisible(aBoolean2);
            if(aBoolean2)itemTfKeyTyped(null);
        });
        posTc.setCellValueFactory(
                new PropertyValueFactory<InvoiceTableItem, String>("pos"));
        productNameTc.setCellValueFactory(
                new PropertyValueFactory<InvoiceTableItem, String>("productName"));
        unitPriceTc.setCellValueFactory(
                new PropertyValueFactory<InvoiceTableItem, String>("unitPrice"));
        qtyTc.setCellValueFactory(
                new PropertyValueFactory<InvoiceTableItem, String>("qty"));
        discountTc.setCellValueFactory(
                new PropertyValueFactory<InvoiceTableItem, Double>("discount"));
        totalTc.setCellValueFactory(
                new PropertyValueFactory<InvoiceTableItem, Double>("total"));
    }

    /**
     * Event Handlers
     */

    //Text field key event handlers
    public void paymentValueTfKeyPressed(KeyEvent keyEvent) {
        KeyCode keyCode = keyEvent.getCode();
        if (keyCode.equals(KeyCode.ENTER) || keyCode.equals(KeyCode.TAB)) {
            try {
                String str1=paymentValueTf.getText();
                if(str1.isEmpty()||str1.equals(" "))paymentAmount=0;
                else {
                    paymentAmount = Double.parseDouble(str1);
                    paymentAmount = ceil(paymentAmount);
                }
                if(paymentAmount>(totalInvoiceAmount-sOff)) throw new Exception("payment amount can't be greater than balance amount.");
                balanceAmountTf.setText(String.valueOf(ceil(totalInvoiceAmount-paymentAmount-sOff)));
                commentsTa.requestFocus();
            }
            catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Wrong data for Payment"+e.getMessage() , "Error!!", JOptionPane.ERROR_MESSAGE);
                paymentValueTf.setText("");
                paymentValueTf.requestFocus();
            }
        }
    }
    public void setOffTfKeyPressed(KeyEvent keyEvent) {
        KeyCode keyCode = keyEvent.getCode();
        if (keyCode.equals(KeyCode.ENTER) || keyCode.equals(KeyCode.TAB)) {
            try {
                String str1=setOffTf.getText();
                if(str1.isEmpty()||str1.equals(" "))sOff=0;
                else {
                    sOff = Double.parseDouble(str1);
                    sOff = ceil(sOff);
                }
                if(sOff>totalInvoiceAmount) throw new Exception("Set Off can't be Greater than Total Invoice amount");
                finalAmountTf.setText(String.valueOf(ceil(totalInvoiceAmount - sOff)));
                balanceAmountTf.setText(String.valueOf(ceil(totalInvoiceAmount-paymentAmount-sOff)));
                paymentValueTf.requestFocus();
            }
            catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Wrong data in set Off"+e.getMessage() , "Error!!", JOptionPane.ERROR_MESSAGE);
                setOffTf.setText("");
                setOffTf.requestFocus();
            }
        }
    }
    public void itemsTfKeyPressed(KeyEvent keyEvent) {
        KeyCode keyCode = keyEvent.getCode();
        if (keyCode.equals(KeyCode.ENTER)||keyCode.equals(KeyCode.TAB)) {
            //itemTf.setText(checkValue());
            String selectedItem=inventoryList.getSelectionModel().getSelectedItem();
            if(selectedItem!=null)
            {
                InventoryTableItem s=getInventoryItem(selectedItem);
                assert s != null;
                itemTf.setText(selectedItem);
                priceTf.setText(s.getPrice());
                discountTf.setText(s.getDiscount());
                taxTf.setText(s.getTax());
            }
            supervisor();
            qtyTf.requestFocus();
        }
        else if(keyCode.equals(KeyCode.DOWN))
        {
            inventoryList.getSelectionModel().select(inventoryList.getSelectionModel().getSelectedIndex()+1);
        }
        else if(keyCode.equals(KeyCode.UP))
        {
            inventoryList.getSelectionModel().select(inventoryList.getSelectionModel().getSelectedIndex()-1);
        }
    }
    public void qtyTfKeyPressed(KeyEvent keyEvent) {
        KeyCode keyCode = keyEvent.getCode();
        if (keyCode.equals(KeyCode.ENTER) || keyCode.equals(KeyCode.TAB)) {priceTf.requestFocus();
            supervisor();}
    }
    public void priceTfKeyPressed(KeyEvent keyEvent) {
        KeyCode keyCode = keyEvent.getCode();
        if (keyCode.equals(KeyCode.ENTER) || keyCode.equals(KeyCode.TAB)) {
            supervisor();
            discountTf.requestFocus();
        }
    }
    public void discountTfKeyPressed(KeyEvent keyEvent) {
        KeyCode keyCode = keyEvent.getCode();
        if (keyCode.equals(KeyCode.ENTER) || keyCode.equals(KeyCode.TAB)) {
            supervisor();
            taxTf.requestFocus();
        }
    }
    public void taxTfKeyPressed(KeyEvent keyEvent) {
        KeyCode keyCode = keyEvent.getCode();
        if (keyCode.equals(KeyCode.ENTER) || keyCode.equals(KeyCode.TAB)) {
            supervisor();
            String productName,qty,unitPrice,discount,tax,total;
            try {
                qty= qtyTf.getText();
                this.qty+=Double.parseDouble(qty);
            }
            catch (Exception e)
            {
                JOptionPane.showMessageDialog(null,"Quantity should be a number.","Error!!",JOptionPane.ERROR_MESSAGE);
                qtyTf.requestFocus();
                return;
            }
            try {
                unitPrice= priceTf.getText();
                Double.parseDouble(unitPrice);
            }
            catch (Exception e)
            {
                JOptionPane.showMessageDialog(null,"Price should be a number.","Error!!",JOptionPane.ERROR_MESSAGE);
                priceTf.requestFocus();
                return;
            }
            try {
                discount=discountTf.getText();
                Double.parseDouble(discount);
            }
            catch (Exception e)
            {
                JOptionPane.showMessageDialog(null,"Discount should be a number.","Error!!",JOptionPane.ERROR_MESSAGE);
                discountTf.requestFocus();
                return;
            }
            try {
                tax=taxTf.getText();
                Double.parseDouble(tax);
            }
            catch (Exception e)
            {
                JOptionPane.showMessageDialog(null,"Tax should be a number.","Error!!",JOptionPane.ERROR_MESSAGE);;
                taxTf.requestFocus();
                return;
            }
            total=totalTf.getText();
            total=total.indexOf('₹')==-1?total:total.substring(1);
            productName=customerNameTf.getText();
            pos++;
            //tPrice_String=tPrice_String.substring(1)+"="+tPrice;
            double totalPrice=Double.parseDouble(total);
            totalInvoiceAmount+=totalPrice;
            data.add(new InvoiceTableItem(pos,productName,unitPrice,qty,discount,tax,total));
            invoiceTable.setItems(data);
            totalAmountTf.setText(String.valueOf(ceil(totalInvoiceAmount)));
            finalAmountTf.setText(String.valueOf(ceil(totalInvoiceAmount-sOff)));
            balanceAmountTf.setText(String.valueOf(ceil(totalInvoiceAmount-paymentAmount-sOff)));
            totalItemsTf.setText(String.valueOf(pos));
            totalQtyTf.setText(String.valueOf(Math.round(this.qty*100.0)/100.0));
            totalTf.setText("₹ 0.0");
            itemTf.setText("");
            discountTf.setText("");
            priceTf.setText("");
            taxTf.setText("");
            qtyTf.setText("");
            priceTf.setText("");
            itemTf.requestFocus();
            st="";
        }
    }
    public void customerMnoKeyPressed(KeyEvent keyEvent) {
        KeyCode keyCode = keyEvent.getCode();
        if (keyCode.equals(KeyCode.ENTER) || keyCode.equals(KeyCode.TAB)) {
            itemTf.requestFocus();
        }
    }
    public void itemTfKeyTyped(KeyEvent keyEvent) {
        if (itemTf.getText().length() == 0)
        {
            populateList(new LinkedList<>(entries));
        }
        else
        {
            searchResult= new LinkedList<>(entries.subSet(itemTf.getText().toUpperCase(), itemTf.getText().toUpperCase() + Character.MAX_VALUE));
            if (entries.size() > 0)
            {
                populateList(searchResult);
            }
            else
            {
                inventoryList.setVisible(false);
            }
        }
    }
    public void customerNameTfKeyPressed(KeyEvent keyEvent) {
        KeyCode keyCode = keyEvent.getCode();
        if (keyCode.equals(KeyCode.ENTER) || keyCode.equals(KeyCode.TAB)) {
            supervisor();
            customerMnoTf.requestFocus();
        }
    }
    //MenuItems event handlers
    public void undoMenuAction(ActionEvent event) {
    }
    public void redoMenuAction(ActionEvent event) {
    }
    public void clearMenuAction(ActionEvent event) {
        itemTf.setText("");
        qtyTf.setText("");
        taxTf.setText("");
        priceTf.setText("");
        discountTf.setText("");
        totalTf.setText("₹ 0.0");
    }
    public void deleteMenuAction(ActionEvent event) {
        ObservableList<InvoiceTableItem> selectedItem = invoiceTable.getSelectionModel().getSelectedItems();
        if(selectedItem.size()!=0)
        {
            for (InvoiceTableItem tableItem : selectedItem) {
                pos--;
                String tPriceString = tableItem.getTotal();
                tPriceString = tPriceString.substring(tPriceString.lastIndexOf('=') + 1);

                totalInvoiceAmount -= Double.parseDouble(tPriceString);
                qty -= Double.parseDouble(tableItem.getQty());
            }
            invoiceTable.getItems().removeAll(selectedItem);

            int i=1;
            for(InvoiceTableItem invoiceTableItem:data)
            {
                invoiceTableItem.setPos(i++);
            }
            totalAmountTf.setText(String.valueOf(totalInvoiceAmount));
            finalAmountTf.setText(String.valueOf(ceil(totalInvoiceAmount-sOff)));
            totalItemsTf.setText(String.valueOf(pos));
            totalQtyTf.setText(String.valueOf(Math.round(qty*100.0)/100.0));
        }
        else {
            JOptionPane.showMessageDialog(null,"Please Select an entry from the Invoice Table","Error!!",JOptionPane.ERROR_MESSAGE);
        }
    }
    public void newInvoiceMenuAction(ActionEvent event) {
        customerMnoTf.setText("");
        customerNameTf.setText("");
        taxTf.setText("");
        priceTf.setText("");
        totalTf.setText("₹ 0.0");
        data.clear();
        //data_dialog.clear();
        invoiceTable.refresh();
        commentsTa.clear();
        customerNameTf.setText("Walk In");
        customerNameTf.requestFocus();
        paymentValueTf.setText("0.0");
        balanceAmountTf.setText("₹ 0.0");
        setOffTf.setText("0.0");
        totalAmountTf.setText("₹ 0.0");
        finalAmountTf.setText("₹ 0.0");
        totalQtyTf.setText("0.0");
        totalItemsTf.setText("0");
    }
    public void settingsMenuAction(ActionEvent event) {
        Bossex.universalUtility.nextPage(event,"SettingsPage.fxml","Settings",true);
    }
    public void checkOutMenuAction(ActionEvent event) {
        Bossex.universalUtility.nextPage(event,"Sell/CheckoutPage.fxml","Checkout Page",true);
    }
    public void closeMenuAction(ActionEvent event) {
        Bossex.universalUtility.nextPage(event, "MasterPage.fxml", "DashBoard", false);
    }
    public void exitMenuAction(ActionEvent event) {
        System.exit(0);
    }
    public void showInvoicesMenuAction(ActionEvent event) {
        Bossex.universalUtility.nextPage(event,"Sell/ShowPreviousBills.fxml","Previous Invoice",false);
    }
    public void todoMenuAction(ActionEvent event) {
        Bossex.universalUtility.nextPage(event,"TodoPage.fxml","Todo",true);
    }
    public void enterPresentationMenuAction(ActionEvent event) {
    }
    public void distractionFreeAction(ActionEvent event) {
    }
    public void helpMenuItemAction(ActionEvent event) {
        Bossex.universalUtility.nextPage(event,"Help/HelpPage.fxml","Help!!",true);
    }
    public void gettingStartedMenuItemAction(ActionEvent event) {
        Bossex.universalUtility.nextPage(event,"Help/GettingStartedPage.fxml","Getting Started",true);
    }
    public void demoMenuItemAction(ActionEvent event) {
        Bossex.universalUtility.nextPage(event,"Help/DemosAndScreencastPage.fxml","Demos And Screencast",true);
    }
    public void tipOfDayMenuItemAction(ActionEvent event) {
        Bossex.universalUtility.nextPage(event,"Help/TipOfTheDay.fxml","Tip Of The Day",true);
    }
    public void contactSupportMenuItemAction(ActionEvent event) {
        Bossex.universalUtility.nextPage(event,"Help/ContactSupport.fxml","Contact Support",true);
    }
    public void reportBugMenuItemAction(ActionEvent event) {
        Bossex.universalUtility.nextPage(event,"Help/ReportBugPage.fxml","Report Bug",true);
    }
    public void submitFeedbackMenuItemAction(ActionEvent event) {
        Bossex.universalUtility.nextPage(event,"Help/SubmitFeedbackPage.fxml","Submit Feedback",true);
    }
    public void updatesMenuItemAction(ActionEvent event) {
        Bossex.universalUtility.nextPage(event,"Help/UpdatePage.fxml","Updates",true);
    }
    public void aboutMenuItemAction(ActionEvent event) {
        Bossex.universalUtility.nextPage(event,"Help/AboutPage.fxml","About",true);
    }


    /**
     * Methods
     */
    //Generate Invoice Number
    private void generateInvoiceNumber(String now) {
        File myReader = new File("/home/arghya/BossexRepo/lastInvoiceNumber.txt");
        Scanner sc = null;
        try {
            sc = new Scanner(myReader);
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null,"invoice_amount.txt file is missing","Error", JOptionPane.ERROR_MESSAGE);
        }
        String lastInvoice="";
        assert sc != null;
        if(sc.hasNextLine()) lastInvoice=sc.nextLine();
        else
        {
            PrintWriter writer = null;
            try {
                writer = new PrintWriter("/home/arghya/BossexRepo/lastInvoiceNumber.txt");
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            now=now.replace('/','_');
            assert writer != null;
            writer.print(now+"_0");
            lastInvoice=sc.nextLine();
            writer.close();
        }
        int index=lastInvoice.lastIndexOf("_");
        String lastInvoiceDate=lastInvoice.substring(0,index);

        lastInvoiceDate=lastInvoiceDate.replace('_','/');
        int lastNo=Integer.parseInt(lastInvoice.substring(index+1));
        if(lastInvoiceDate.equals(getDate())) ivnNum=lastNo+1;
        else ivnNum=1;
        now=now.replace('/','_');
        invoiceNumber=now+"_"+ivnNum;
        invoiceNoTf.setText(invoiceNumber);
    }
    //Get Today's date
    private String getDate() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return dtf.format(now);
    }
    //Gets Item datas
    private String[] getArray() {
        File myReader=new File("/home/arghya/BossexRepo/others/invoice_options.txt");
        Scanner sc = null;
        try {
            sc = new Scanner(myReader);
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null,"invoice_options.txt file is missing","Error", JOptionPane.ERROR_MESSAGE);
        }
        int l=0,i=0;
        while (true){
            assert sc != null;
            if (!sc.hasNextLine()) break;
            sc.nextLine();
            ++l;
        }
        String ar[]=new String[l];
        try {
            sc = new Scanner(myReader);
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null,"invoice_options.txt file is missing","Error", JOptionPane.ERROR_MESSAGE);
        }
        while (sc.hasNextLine()) {
            String s=sc.nextLine();
            ar[i++]=s;
        }
        return ar;
    }
    //Gets Particular ProductName
    private String checkValue() {
        //get values from database
        String s=itemTf.getText();
        String r="";
        try
        {
            r=array[Integer.parseInt(s)-1];
            return r;
        }
        catch (Exception e)
        {
            return s;
        }
    }
    //Supervisor
    private void supervisor(){
        double qty;
        try {
            qty= Double.parseDouble(qtyTf.getText());
        }
        catch (Exception e)
        {
            qty=0;
        }
        double price;
        try {
            price= Double.parseDouble(priceTf.getText());
        }
        catch (Exception e)
        {
            price=0;
        }
        double discount;
        try {
            discount= Double.parseDouble(discountTf.getText());
        }
        catch (Exception e)
        {
            discount=0;
        }
        double tax;
        try {
            tax= Double.parseDouble(taxTf.getText());
        }
        catch (Exception e)
        {
            tax=0;
        }
        double total=qty*price;
        total=total*(1-discount/100);
        total=total*(1+tax/100);
        total=Math.round(total*100.0)/100.0;
        totalTf.setText(String.valueOf(total));

    }
    private InventoryTableItem getInventoryItem(String selectedItem) {
        String array[]=selectedItem.split(":");
        for (InventoryTableItem inventoryTableItem: inventoryTableItemList) {
            if (array[1].equalsIgnoreCase(inventoryTableItem.getUid())) {
                return inventoryTableItem;
            }
        }
        return null;
    }
    private void populateList(List<String> searchResult) {
        inventoryList.getItems().clear();
        inventoryList.getItems().addAll(searchResult);
        inventoryList.setVisible(true);
        inventoryList.getSelectionModel().select(0);

    }

    public void inventoryMenuClicked(ActionEvent event) {
        Bossex.universalUtility.nextPage(event,"InventoryManager/InventoryManagementPage.fxml","Inventory Manager",true);
    }
    public void customerMenuClicked(ActionEvent event) {
        Bossex.universalUtility.nextPage(event,"CustomerManager/CustomerManagementPage.fxml","Customer Manager",true);
    }
}
