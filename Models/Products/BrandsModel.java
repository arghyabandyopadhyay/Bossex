package BusinessGenie.app.Bossex.Models.Products;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class BrandsModel {
    private final IntegerProperty id=new SimpleIntegerProperty(this,"id");
    private final StringProperty brand=new SimpleStringProperty(this,"brand");
    public final IntegerProperty idProperty(){return id;}
    public final StringProperty brandProperty(){return brand;}
    public final int getId(){return idProperty().get();}
    public final String getBrandProperty(){return brandProperty().get();}
    public final void setId(int id){idProperty().set(id);}
    public final void setBrand(String brand){brandProperty().set(brand);}

    public BrandsModel(int id,String brand){
        setId(id);
        setBrand(brand);
    }
}
