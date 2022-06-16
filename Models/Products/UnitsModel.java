package BusinessGenie.app.Bossex.Models.Products;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class UnitsModel {
    private final IntegerProperty id=new SimpleIntegerProperty(this,"id");
    private final StringProperty unit=new SimpleStringProperty(this,"unit");
    public final IntegerProperty idProperty(){return id;}
    public final StringProperty unitProperty(){return unit;}
    public final int getId(){return idProperty().get();}
    public final String getUnitProperty(){return unitProperty().get();}
    public final void setId(int id){idProperty().set(id);}
    public final void setUnit(String unit){unitProperty().set(unit);}

    public UnitsModel(int id,String unit){
        setId(id);
        setUnit(unit);
    }
}
