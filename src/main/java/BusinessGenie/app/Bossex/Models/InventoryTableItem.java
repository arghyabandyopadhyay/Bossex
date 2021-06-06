package BusinessGenie.app.Bossex.Models;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class InventoryTableItem {
    private final SimpleIntegerProperty id;
    private final SimpleStringProperty name;
    private final SimpleStringProperty type;
    private final SimpleStringProperty category;
    private final SimpleStringProperty price;
    private final SimpleStringProperty soldMonth;
    private final SimpleStringProperty totalSold;
    private final SimpleStringProperty placement;
    private final SimpleStringProperty available;
    private final SimpleStringProperty discount;
    private final SimpleStringProperty tax;
    private final SimpleStringProperty uid;

    public InventoryTableItem(int id, String name, String type, String category, String price, String soldMonth, String totalSold, String placement, String available, String discount, String tax, String uid) {
        this.id = new SimpleIntegerProperty(id);
        this.name = new SimpleStringProperty(name);
        this.type= new SimpleStringProperty(type);
        this.category = new SimpleStringProperty(category);
        this.price = new SimpleStringProperty(price);
        this.soldMonth = new SimpleStringProperty(soldMonth);
        this.totalSold = new SimpleStringProperty(totalSold);
        this.placement = new SimpleStringProperty(placement);
        this.available = new SimpleStringProperty(available);
        this.discount= new SimpleStringProperty(discount);
        this.tax = new SimpleStringProperty(tax);
        this.uid = new SimpleStringProperty(uid);
    }

    public int getId() {
        return id.get();
    }
    public void setId(int a) {
        id.set(a);
    }
    public String getName() {
        return name.get();
    }
    public void setName(String b) {
        name.set(b);
    }
    public String getType() {
        return type.get();
    }
    public void setType(String b) {
        type.set(b);
    }
    public String getCategory() {
        return category.get();
    }
    public void setCategory(String fName) {
        category.set(fName);
    }
    public String getPrice() {
        return price.get();
    }
    public void setPrice(String fName) {
        price.set(fName);
    }
    public String getSoldMonth() {
        return soldMonth.get();
    }
    public void setSoldMonth(String fName) {
        soldMonth.set(fName);
    }
    public String getTotalSold() {
        return totalSold.get();
    }
    public void setTotalSold(String fName) {
        totalSold.set(fName);
    }
    public String getPlacement() {
        return placement.get();
    }
    public void setPlacement(String fName) {
        placement.set(fName);
    }
    public String getAvailable() {
        return available.get();
    }
    public void setAvailable(String fName) {
        available.set(fName);
    }
    public String getDiscount() {
        return discount.get();
    }
    public void setDiscount(String fName) {
        discount.set(fName);
    }
    public String getTax() {
        return tax.get();
    }
    public void setTax(String fName) {
        tax.set(fName);
    }
    public String getUid() {
        return uid.get();
    }
    public void setUid(String fName) {
        uid.set(fName);
    }
}