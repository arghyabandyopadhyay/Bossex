package BusinessGenie.app.Bossex.Models;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class InvoiceTableItem {
    private final SimpleIntegerProperty pos;
    private final SimpleStringProperty productName;
    private final SimpleStringProperty unitPrice;
    private final SimpleStringProperty qty;
    private final SimpleStringProperty discount;
    private final SimpleStringProperty tax;
    private final SimpleStringProperty total;

    public InvoiceTableItem(int pos, String productName, String unitPrice, String qty, String discount, String tax, String total) {
        this.pos = new SimpleIntegerProperty(pos);
        this.productName = new SimpleStringProperty(productName);
        this.unitPrice = new SimpleStringProperty(unitPrice);
        this.qty = new SimpleStringProperty(qty);
        this.discount= new SimpleStringProperty(discount);
        this.tax = new SimpleStringProperty(tax);
        this.total = new SimpleStringProperty(total);
    }

    public int getPos() {
        return pos.get();
    }
    public void setPos(int a) {pos.set(a);}
    public String getProductName() {
        return productName.get();
    }
    public void setProductName(String b) {
        productName.set(b);
    }
    public String getUnitPrice() {
        return unitPrice.get();
    }
    public void setUnitPrice(String fName) {
        unitPrice.set(fName);
    }
    public String getQty() {
        return qty.get();
    }
    public void setQty(String fName) {
        qty.set(fName);
    }
    public String getDiscount() {return discount.get();}
    public void setDiscount(String fName) {
        discount.set(fName);
    }
    public String getTax() {
        return tax.get();
    }
    public void setTax(String fName) {
        tax.set(fName);
    }
    public String getTotal() {return total.get();}
    public void setTotal(String fName) {total.set(fName);}
}