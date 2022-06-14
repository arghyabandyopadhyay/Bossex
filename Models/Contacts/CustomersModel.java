package BusinessGenie.app.Bossex.Models.Contacts;

import javafx.beans.property.*;

public class CustomersModel {
    private final IntegerProperty id = new SimpleIntegerProperty(this, "id");
    private final StringProperty name = new SimpleStringProperty(this, "name");
    private final StringProperty emailId = new SimpleStringProperty(this, "emailId");
    private final StringProperty mNo = new SimpleStringProperty(this, "mNo");
    private final StringProperty pancard = new SimpleStringProperty(this, "pancard");
    private final DoubleProperty openingBalance= new SimpleDoubleProperty(this,"openingBalance");
    private final DoubleProperty creditLimit= new SimpleDoubleProperty(this,"creditLimit");
    private final DoubleProperty advanceBalance= new SimpleDoubleProperty(this,"advanceBalance");
    private final DoubleProperty totalSellDue= new SimpleDoubleProperty(this,"totalSellDue");
    private final DoubleProperty totalSellReturnDue= new SimpleDoubleProperty(this,"totalSellReturnDue");
    private final StringProperty  addedOn= new SimpleStringProperty(this,"addedOn");
    private final StringProperty  address= new SimpleStringProperty(this,"address");
    private final IntegerProperty customerGroup = new SimpleIntegerProperty(this, "customerGroup");
    private final StringProperty customerGroupName = new SimpleStringProperty(this, "customerGroupName");
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
    public StringProperty pancardProperty() {
        return pancard;
    }
    public DoubleProperty openingBalanceProperty(){
        return openingBalance;
    }
    public DoubleProperty creditLimitProperty(){
        return creditLimit;
    }
    public DoubleProperty advanceBalanceProperty(){
        return advanceBalance;
    }
    public DoubleProperty totalSellDueProperty(){
        return totalSellDue;
    }
    public DoubleProperty totalSellReturnDueProperty(){
        return totalSellReturnDue;
    }
    public StringProperty addedOnProperty(){
        return addedOn;
    }
    public StringProperty addressProperty(){
        return address;
    }
    public StringProperty paytermDescProperty(){
        return paytermDesc;
    }
    public IntegerProperty paytermProperty(){
        return payterm;
    }
    public IntegerProperty customerGroupProperty(){
        return customerGroup;
    }
    public StringProperty customerGroupNameProperty(){
        return customerGroupName;
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
    public final String getPancard(){
        return pancardProperty().get();
    }
    public final double getOpeningBalance(){
        return openingBalanceProperty().get();
    }
    public final double getCreditLimit(){
        return creditLimitProperty().get();
    }
    public final double getAdvanceBalance(){
        return advanceBalanceProperty().get();
    }
    public final int getCustomerGroup(){
        return customerGroupProperty().get();
    }
    public final String getCustomerGroupName(){
        return customerGroupNameProperty().get();
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
    public final double getTotalSellDue(){return totalSellDueProperty().get();}
    public final double getTotalSellReturnDue(){return totalSellReturnDueProperty().get();}
    public final void setEmailId(String emailId) {emailIdProperty().set(emailId);}
    public final void setMNo(String mNo) {mNoProperty().set(mNo);}

    public final void setId(int id) {
        idProperty().set(id);
    }

    public final void setName(String name) {
        nameProperty().set(name);
    }

    public final void setPayterm(int payterm){paytermProperty().set(payterm);}
    public final void setPaytermDesc(String paytermDesc){paytermDescProperty().set(paytermDesc);}

    public final void setAddedOn(String addedOn){addedOnProperty().set(addedOn);}

    public final void setCustomerGroup(int customerGroup){customerGroupProperty().set(customerGroup);}
    public final void setCustomerGroupName(String customerGroupName){customerGroupNameProperty().set(customerGroupName);}
    public final void setPancard(String pancard){
        pancardProperty().set(pancard);
    }
    public final void setOpeningBalance(double openingBalance){
        openingBalanceProperty().set(openingBalance);
    }
    public final void setCreditLimit(double creditLimit){
        creditLimitProperty().set(creditLimit);
    }
    public final void setAdvanceBalance(double advanceBalance){
        advanceBalanceProperty().set(advanceBalance);
    }
    public final void setAddress(String address){
        addressProperty().set(address);
    }
    public final void setTotalSellDue(double totalSellDue){totalSellDueProperty().set(totalSellDue);}
    public final void setTotalSellReturnDue(double totalSellReturnDue){totalSellReturnDueProperty().set(totalSellReturnDue);}



    public CustomersModel(String emailId, String mNo, int id, String name, int payterm, String paytermDesc, String addedOn, int customerGroup, String customerGroupName, String pancard, double openingBalance, double creditLimit, double advanceBalance, String address, double totalSellDue, double totalSellReturnDue) {
        setEmailId(emailId);
        setMNo(mNo);
        setId(id);
        setName(name);
        setPayterm(payterm);
        setPaytermDesc(paytermDesc);
        setAddedOn(addedOn);
        setCustomerGroup(customerGroup);
        setCustomerGroupName(customerGroupName);
        setPancard(pancard);
        setOpeningBalance(openingBalance);
        setCreditLimit(creditLimit);
        setAdvanceBalance(advanceBalance);
        setAddress(address);
        setTotalSellDue(totalSellDue);
        setTotalSellReturnDue(totalSellReturnDue);
    }
}

