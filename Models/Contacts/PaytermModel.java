package BusinessGenie.app.Bossex.Models.Contacts;

import javafx.beans.property.*;

public class PaytermModel {
    private final IntegerProperty id = new SimpleIntegerProperty(this, "id");
    private final StringProperty paytermDesc = new SimpleStringProperty(this, "paytermDesc");

    public IntegerProperty idProperty() {
        return id;
    }
    public StringProperty paytermDescProperty() {
        return paytermDesc;
    }

    public final int getId() {
        return idProperty().get();
    }

    public final String getPaytermDesc() {
        return paytermDescProperty().get();
    }


    public final void setId(int id) {
        idProperty().set(id);
    }

    public final void setPaytermDesc(String paytermDesc) {
        paytermDescProperty().set(paytermDesc);
    }


    public PaytermModel(int id, String paytermDesc) {
        setId(id);
        setPaytermDesc(paytermDesc);
    }
}


