package BusinessGenie.app.Bossex.Models.Products;

import javafx.beans.property.*;

public class ProductsTableModel {
    private final IntegerProperty id= new SimpleIntegerProperty(this,"id");
    private final StringProperty product=new SimpleStringProperty(this,"product");
    private final IntegerProperty businessLocationId=new SimpleIntegerProperty(this,"businessLocationId");
    private final StringProperty businessLocation=new SimpleStringProperty(this,"businessLocation");
    private final DoubleProperty unitPurchasePrice=new SimpleDoubleProperty(this,"unitPurchasePrice");
    private final DoubleProperty sellingPrice=new SimpleDoubleProperty(this,"sellingPrice");
    private final DoubleProperty currentStock=new SimpleDoubleProperty(this,"currentStock");
    private final StringProperty productType=new SimpleStringProperty(this,"productType");
    private final IntegerProperty categoryId=new SimpleIntegerProperty(this,"categoryId");
    private final StringProperty category=new SimpleStringProperty(this,"category");
    private final StringProperty brand=new SimpleStringProperty(this,"brand");
    private final IntegerProperty brandId=new SimpleIntegerProperty(this,"brandId");
    private final DoubleProperty tax=new SimpleDoubleProperty(this,"tax");
    private final StringProperty sku=new SimpleStringProperty(this,"sku");
    private final IntegerProperty unitId=new SimpleIntegerProperty(this,"unitId");
    private final StringProperty unit=new SimpleStringProperty(this,"unit");
    public IntegerProperty idProperty(){
        return id;
    }
    public StringProperty productProperty(){
        return product;
    }
    public IntegerProperty businessLocationIdProperty(){
        return businessLocationId;
    }
    public StringProperty businessLocationProperty(){return businessLocation;}
    public DoubleProperty unitPurchaseProperty(){
        return unitPurchasePrice;
    }
    public DoubleProperty sellingPriceProperty(){
        return sellingPrice;
    }
    public DoubleProperty currentStockProperty(){
        return currentStock;
    }
    public StringProperty productTypeProperty(){
        return productType;
    }
    public IntegerProperty categoryIdProperty(){
        return categoryId;
    }
    public StringProperty categoryProperty(){
        return category;
    }
    public StringProperty brandProperty(){
        return brand;
    }
    public IntegerProperty brandIdProperty(){
        return brandId;
    }
    public DoubleProperty taxProperty(){
        return tax;
    }
    public StringProperty skuProperty(){return sku;}
    public IntegerProperty unitIdProperty(){
        return unitId;
    }
    public StringProperty unitProperty(){
        return unit;
    }

    public final int getId(){return idProperty().get();}
    public final String getProduct(){return productProperty().get();}
    public final int getBusinessLocationId(){return businessLocationIdProperty().get();}
    public final String getBusinessLocation(){return businessLocationProperty().get();}
    public final double getUnitPurchasePrice(){return unitPurchaseProperty().get();}
    public final double getSellingPrice(){return sellingPriceProperty().get();}
    public final double getCurrentStock(){return currentStockProperty().get();}
    public final String getProductType(){return productTypeProperty().get();}
    public final int getCategoryId(){return categoryIdProperty().get();}
    public final String getCategory(){return categoryProperty().get();}
    public final int getBrandId(){return brandIdProperty().get();}
    public final String getBrand(){return brandProperty().get();}
    public final double getTax(){return taxProperty().get();}
    public final String getSku(){return skuProperty().get();}
    public final int getUnitId(){return unitIdProperty().get();}
    public final String getUnit(){return unitProperty().get();}

    public final void setId(int id){idProperty().set(id);}
    public final void setProduct(String product){productProperty().set(product);}
    public final void setBusinessLocationId(int businessLocationId){businessLocationIdProperty().set(businessLocationId);}
    public final void setBusinessLocation(String businessLocation){businessLocationProperty().set(businessLocation);}
    public final void setUnitPurchasePrice(double unitPurchasePrice){unitPurchaseProperty().set(unitPurchasePrice);}
    public final void setSellingPrice(double sellingPrice){sellingPriceProperty().set(sellingPrice);}
    public final void setCurrentStock(double currentStock){currentStockProperty().set(currentStock);}
    public final void setProductType(String productType){productTypeProperty().set(productType);}
    public final void setCategoryId(int categoryId){categoryIdProperty().set(categoryId);}
    public final void setCategory(String category){categoryProperty().set(category);}
    public final void setBrandId(int brandId){brandIdProperty().set(brandId);}
    public final void setBrand(String brand){brandProperty().set(brand);}
    public final void setTax(double tax){taxProperty().set(tax);}
    public final void setSku(String sku){skuProperty().set(sku);}
    public final void setUnitId(int unitId){unitIdProperty().set(unitId);}
    public final void setUnit(String unit){unitProperty().set(unit);}

    public ProductsTableModel(int id,String product,int businessLocationId,String businessLocation,double unitPurchasePrice,double sellingPrice,double currentStock,String productType,int categoryId,String category,int brandId,String brand,double tax,String sku,int unitId,String unit){
        setId(id);
        setProduct(product);
        setBusinessLocationId(businessLocationId);
        setBusinessLocation(businessLocation);
        setUnitPurchasePrice(unitPurchasePrice);
        setSellingPrice(sellingPrice);
        setCurrentStock(currentStock);
        setProductType(productType);
        setCategoryId(categoryId);
        setCategory(category);
        setBrandId(brandId);
        setBrand(brand);
        setTax(tax);
        setSku(sku);
        setUnitId(unitId);
        setUnit(unit);
    }
}
