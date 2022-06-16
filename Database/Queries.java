package BusinessGenie.app.Bossex.Database;

public class Queries {
    public static String getSuppliers="Select * from Suppliers inner join Payterm on Suppliers.payterm=Payterm.id;";
    public static String getCustomers="Select * from Customers inner join Payterm on Customers.payterm=Payterm.id inner join CustomerGroups on Customers.customerGroup=CustomerGroups.id;";
    public static String getCustomerGroups="Select * from CustomerGroups;";
    public static String getPayterms="Select * from Payterm;";
    public static String getProducts="Select * from Products inner join Brands on Products.brandId=Brands.id inner join ProductCategories on Products.categoryId=ProductCategories.id inner join Units on Products.unitId=Units.id inner join BusinessLocations on Products.businessLocationId=BusinessLocations.id;";
    public static String getBusinessLocations="Select * from BusinessLocations;";
    public static String getProductCategories="Select * from ProductCategories;";
    public static String getUnits="Select * from Units;";
    public static String getBrands="Select * from Brands";
    static String getUsersInnerJoinUserRoles="Select * from Users inner join UserRoles on Users.roleId=UserRoles.id;";
}
