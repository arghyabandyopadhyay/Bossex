package BusinessGenie.app.Bossex.Models.Products;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class BusinessLocationsModel {
    private final IntegerProperty id=new SimpleIntegerProperty(this,"id");
    private final StringProperty businessLocation=new SimpleStringProperty(this,"businessLocation");
    private final StringProperty address=new SimpleStringProperty(this,"address");
    public final IntegerProperty idProperty(){return id;}
    public final StringProperty businessLocationProperty(){return businessLocation;}
    public final StringProperty addressProperty(){return address;}
    public final int getId(){return idProperty().get();}
    public final String getBusinessLocation(){return businessLocationProperty().get();}
    public final String getAddress(){return addressProperty().get();}
    public final void setId(int id){idProperty().set(id);}
    public final void setBusinessLocation(String businessLocation){businessLocationProperty().set(businessLocation);}
    public final void setAddress(String address){addressProperty().set(address);}

    public BusinessLocationsModel(int id,String businessLocation,String address){
        setId(id);
        setBusinessLocation(businessLocation);
        setAddress(address);
    }
}
