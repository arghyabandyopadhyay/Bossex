package BusinessGenie.app.Bossex.Database;

public class Queries {
    public static String getSuppliers="Select * from Suppliers inner join Payterm on Suppliers.payterm=Payterm.id;";
    public static String getCustomers="Select * from Customers inner join Payterm on Customers.payterm=Payterm.id inner join CustomerGroups on Customers.customerGroup=CustomerGroups.id;";
    public static String getCustomerGroups="Select * from CustomerGroups;";
    public static String getPayterms="Select * from Payterm;";
    static String getUsersInnerJoinUserRoles="Select * from Users inner join UserRoles on Users.roleId=UserRoles.id;";
}
