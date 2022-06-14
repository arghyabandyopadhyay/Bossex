package BusinessGenie.app.Bossex.Models.Contacts;

import javafx.beans.property.*;

public class SuppliersModel {
    private final IntegerProperty id = new SimpleIntegerProperty(this, "id");
    private final StringProperty name = new SimpleStringProperty(this, "name");
    private final StringProperty emailId = new SimpleStringProperty(this, "emailId");
    private final StringProperty mNo = new SimpleStringProperty(this, "mNo");
    private final StringProperty gstin = new SimpleStringProperty(this, "gstin");
    private final DoubleProperty openingBalance= new SimpleDoubleProperty(this,"openingBalance");
    private final DoubleProperty totalPurchaseDue= new SimpleDoubleProperty(this,"totalPurchaseDue");
    private final DoubleProperty totalPurchaseReturnDue= new SimpleDoubleProperty(this,"totalPurchaseReturnDue");
    private final StringProperty  addedOn= new SimpleStringProperty(this,"addedOn");
    private final StringProperty  address= new SimpleStringProperty(this,"address");
    private final StringProperty  businessName= new SimpleStringProperty(this,"businessName");
    private final StringProperty paytermDesc = new SimpleStringProperty(this, "paytermDesc");
    private final IntegerProperty payterm = new SimpleIntegerProperty(this, "payterm");

    public StringProperty emailIdProperty() {
        return emailId;
    }

    public StringProperty mNoProperty() {
        return mNo;
    }

    public IntegerProperty idProperty() {
        return id;
    }

    public StringProperty nameProperty() {
        return name;
    }
    public StringProperty gstinProperty() {
        return gstin;
    }
    public DoubleProperty openingBalanceProperty(){
        return openingBalance;
    }
    public DoubleProperty totalPurchaseDueProperty(){
        return totalPurchaseDue;
    }
    public DoubleProperty totalPurchaseReturnDueProperty(){
        return totalPurchaseReturnDue;
    }
    public StringProperty addedOnProperty(){
        return addedOn;
    }
    public StringProperty addressProperty(){
        return address;
    }
    public StringProperty businessNameProperty(){
        return businessName;
    }
    public StringProperty paytermDescProperty(){
        return paytermDesc;
    }
    public IntegerProperty paytermProperty(){
        return payterm;
    }
    public final String getMNo() {
        return mNoProperty().get();
    }
    public final int getId() {
        return idProperty().get();
    }
    public final String getEmailId() {
        return emailIdProperty().get();
    }
    public final String getName() {
        return nameProperty().get();
    }
    public final String getGstin(){
        return gstinProperty().get();
    }
    public final double getOpeningBalance(){
        return openingBalanceProperty().get();
    }
    public final String getBusinessName(){
        return businessNameProperty().get();
    }
    public final String getAddress(){
        return addressProperty().get();
    }
    public final String getPaytermDesc(){
        return paytermDescProperty().get();
    }
    public final int getPayterm(){
        return paytermProperty().get();
    }
    public final String getAddedOn(){
        return addedOnProperty().get();
    }
    public final double getTotalPurchaseDue(){return totalPurchaseDueProperty().get();}
    public final double getTotalPurchaseReturnDue(){return totalPurchaseReturnDueProperty().get();}
    public final void setEmailId(String emailId) {emailIdProperty().set(emailId);}
    public final void setMNo(String mNo) {mNoProperty().set(mNo);}

    public final void setId(int id) {
        idProperty().set(id);
    }

    public final void setName(String name) {
        nameProperty().set(name);
    }

    public final void setPaytermDesc(String paytermDesc){paytermDescProperty().set(paytermDesc);}
    public final void setPayterm(int payterm){paytermProperty().set(payterm);}

    public final void setAddedOn(String addedOn){addedOnProperty().set(addedOn);}
    public final void setGstin(String gstin){
        gstinProperty().set(gstin);
    }
    public final void setOpeningBalance(double openingBalance){
        openingBalanceProperty().set(openingBalance);
    }
    public final void setBusinessName(String businessName){
        businessNameProperty().set(businessName);
    }
    public final void setAddress(String address){
        addressProperty().set(address);
    }
    public final void setTotalPurchaseDue(double totalPurchaseDue){totalPurchaseDueProperty().set(totalPurchaseDue);}
    public final void setTotalPurchaseReturnDue(double totalPurchaseReturnDue){totalPurchaseReturnDueProperty().set(totalPurchaseReturnDue);}



    public SuppliersModel(String emailId, String businessName, String mNo, int id, String name, int payterm, String paytermDesc, String addedOn, String gstin, double openingBalance,String address, double totalPurchaseDue, double totalPurchaseReturnDue) {
        setEmailId(emailId);
        setMNo(mNo);
        setId(id);
        setName(name);
        setPayterm(payterm);
        setPaytermDesc(paytermDesc);
        setAddedOn(addedOn);
        setGstin(gstin);
        setOpeningBalance(openingBalance);
        setBusinessName(businessName);
        setAddress(address);
        setTotalPurchaseDue(totalPurchaseDue);
        setTotalPurchaseReturnDue(totalPurchaseReturnDue);
    }
}

