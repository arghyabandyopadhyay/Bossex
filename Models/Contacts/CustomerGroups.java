package BusinessGenie.app.Bossex.Models.Contacts;

import javafx.beans.property.*;

public class CustomerGroups {
    private final IntegerProperty id = new SimpleIntegerProperty(this, "id");
    private final DoubleProperty calculationPercentage = new SimpleDoubleProperty(this, "calculationPercentage");
    private final StringProperty customerGroupName = new SimpleStringProperty(this, "customerGroupName");

    public IntegerProperty idProperty() {
        return id;
    }

    public DoubleProperty calculationPercentageProperty() {
        return calculationPercentage;
    }
    public StringProperty customerGroupNameProperty() {
        return customerGroupName;
    }

    public final int getid() {
        return idProperty().get();
    }

    public final double getCalculationPercentage() {
        return calculationPercentageProperty().get();
    }

    public final String getCustomerGroupName() {
        return customerGroupNameProperty().get();
    }


    public final void setId(int id) {
        idProperty().set(id);
    }

    public final void setCalculationPercentage(double calculationPercentage) {
        calculationPercentageProperty().set(calculationPercentage);
    }

    public final void setCustomerGroupName(String customerGroupName) {
        customerGroupNameProperty().set(customerGroupName);
    }


    public CustomerGroups(int id, String customerGroupName,double calculationPercentage) {
        setId(id);
        setCalculationPercentage(calculationPercentage);
        setCustomerGroupName(customerGroupName);
    }
}


