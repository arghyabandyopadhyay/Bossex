package BusinessGenie.app.Bossex.Models.Products;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class ProductCategoriesModel {
    private final IntegerProperty id=new SimpleIntegerProperty(this,"id");
    private final StringProperty category=new SimpleStringProperty(this,"category");
    public final IntegerProperty idProperty(){return id;}
    public final StringProperty categoryProperty(){return category;}
    public final int getId(){return idProperty().get();}
    public final String getCategoryProperty(){return categoryProperty().get();}
    public final void setId(int id){idProperty().set(id);}
    public final void setCategory(String category){categoryProperty().set(category);}

    public ProductCategoriesModel(int id,String category){
        setId(id);
        setCategory(category);
    }
}
