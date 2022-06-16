package BusinessGenie.app.Bossex.Database;

import BusinessGenie.app.Bossex.Bossex;
import BusinessGenie.app.Bossex.Models.Contacts.CustomerGroupsModel;
import BusinessGenie.app.Bossex.Models.Contacts.CustomersModel;
import BusinessGenie.app.Bossex.Models.Contacts.PaytermModel;
import BusinessGenie.app.Bossex.Models.Contacts.SuppliersModel;
import BusinessGenie.app.Bossex.Models.Employee.EmployeesTemplate;
import BusinessGenie.app.Bossex.Models.InventoryTableItem;
import BusinessGenie.app.Bossex.Models.Products.*;
import BusinessGenie.app.Bossex.Models.TodoTableItem;
import BusinessGenie.app.Bossex.Models.Users.UserRoleModel;
import BusinessGenie.app.Bossex.Models.Users.UsersModel;
import BusinessGenie.app.Bossex.Services.Encrypt;
import javafx.beans.property.*;
import javafx.collections.ObservableList;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static BusinessGenie.app.Bossex.Services.UniversalUtility.openMessageDialog;

public class DatabaseAccessor {
    private Connection connection;

    public DatabaseAccessor() {
        try {
            Class.forName(Bossex.driverClass);
            connection = DriverManager.getConnection(Bossex.apiUrl, Bossex.user, Bossex.password);

        } catch (Exception ex) {
            openMessageDialog( "An error occurred while connecting MySQL database", "Error!!");
            ex.printStackTrace();
        }
    }

    public void shutdown(){
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException throwables) {
                openMessageDialog(throwables.getMessage(),"Error!!");
            }
        }
    }

    public void setTheme(int uid, String theme) {
        try {
            Statement stmt = connection.createStatement();
            stmt.executeUpdate("update Users set theme='"+theme+"' where uid ="+uid+";");
        } catch (Exception e) {
            openMessageDialog( e.getMessage(),"Error!!");
        }
    }
    public List<UsersModel> getUserList() {
        try (
                Statement stmnt = connection.createStatement();
                ResultSet rs = stmnt.executeQuery(Queries.getUsersInnerJoinUserRoles);
        ) {
            List<UsersModel> usersList = new ArrayList<>();
            while (rs.next()) {
                String userId = rs.getString("userId");
                String permission = rs.getString("permission");
                String password = rs.getString("password");
                String emailId = rs.getString("emailId");
                String mNo = rs.getString("mNo");
                int uid = rs.getInt("id");
                String theme=rs.getString("theme");
                String name=rs.getString("Name");
                String roleName=rs.getString("roleName");
                int roleId=rs.getInt("roleId");
                UsersModel usersTemplate = new UsersModel(userId, permission, password, emailId, mNo, uid,theme,name,roleId,roleName);
                usersList.add(usersTemplate);
            }
            return usersList;
        }
        catch (Exception e)
        {
            openMessageDialog(e.getMessage(),"Error!!");
            return null;
        }
    }
    public void addUser(String userId,String password, String emailId, String mNo,String theme, String name, int roleId) {
        try {
            Statement stmt = connection.createStatement();
            stmt.executeUpdate("Insert into Users(userId,password,emailId,mNo,theme,Name,roleId) values('" + userId + "','" +  Encrypt.getSHA(password) + "','" + emailId + "','" + mNo+ "','" +theme+ "','" + name + "'," +roleId+ ");");
        } catch (Exception e) {
            openMessageDialog( e.getMessage(),"Error!!");
        }
    }
    public void updateUser(UsersModel selectedItem) {
        try {
            Statement stmt = connection.createStatement();
            stmt.executeUpdate("update Users set name='"+selectedItem.getName()+"',userId='"+selectedItem.getuserId()+"',mNo='"+selectedItem.getMNo()+"',emailId='"+selectedItem.getEmailId()+"',permission='"+selectedItem.getPermission()+"',password='"+selectedItem.getPassword()+"' where uid ="+selectedItem.getId()+";");
        } catch (Exception e) {
            openMessageDialog( e.getMessage(),"Error!!");
        }
    }
    public void deleteUser(UsersModel usersModel) {
        try {
            Statement stmt = connection.createStatement();
            stmt.executeUpdate("delete from Users where id ="+usersModel.getId()+";");

        } catch (Exception e) {
            openMessageDialog( e.getMessage(),"Error!!");
        }
    }public void deleteUserList(ObservableList<UsersModel> selectedItem) {
        try {
            Statement stmt = connection.createStatement();
            for (UsersModel usersTemplate : selectedItem)
            {
                stmt.executeUpdate("delete from Users where uid ="+usersTemplate.getId()+";");
            }

        } catch (Exception e) {
            openMessageDialog( e.getMessage(),"Error!!");
        }
    }


    public List<InventoryTableItem> getInventoryList() {
        try (
                Statement stmnt = connection.createStatement();
                ResultSet rs = stmnt.executeQuery("select * from Inventory");
        ) {
            List<InventoryTableItem> inventoryTableItemList = new ArrayList<>();
            while (rs.next()) {
                InventoryTableItem inventoryTableItem = new InventoryTableItem(rs.getInt("id"), rs.getString("name"),rs.getString("type"), rs.getString("category"), rs.getString("price"), rs.getString("soldmonth"), rs.getString("totalsold"),rs.getString("placement"),rs.getString("available"),rs.getString("discount"),rs.getString("tax"),rs.getString("uid"));
                inventoryTableItemList.add(inventoryTableItem);
            }
            return inventoryTableItemList;
        }
        catch (Exception e)
        {
            openMessageDialog(e.getMessage(),"Error!!");
            return null;
        }
    }
    public void addInventoryItem(InventoryTableItem inventoryTableItem) {
        try {
            Statement stmt = connection.createStatement();
            stmt.executeUpdate("Insert into Inventory(name,type,category,price,soldmonth,totalsold,placement,available,discount,tax,uid) values('" + inventoryTableItem.getName() + "','" + inventoryTableItem.getType() + "','" + inventoryTableItem.getCategory() + "','" + inventoryTableItem.getPrice() + "','" + inventoryTableItem.getSoldMonth()+ "','" + inventoryTableItem.getTotalSold() + "','" + inventoryTableItem.getPlacement()+ "','" + inventoryTableItem.getAvailable() + "','" + inventoryTableItem.getDiscount()+ "','" + inventoryTableItem.getTax() + "','" + inventoryTableItem.getId() + "');");
        } catch (Exception e) {
            openMessageDialog( e.getMessage(),"Error!!");
        }
    }
    public void updateInventoryItem(InventoryTableItem selectedItem) {
        try {
            Statement stmt = connection.createStatement();
            stmt.executeUpdate("update Inventory set name='"+selectedItem.getName()+"',type='"+selectedItem.getType()+"',category='"+selectedItem.getCategory()+"',price='"+selectedItem.getPrice()+"',soldmonth='"+selectedItem.getSoldMonth()+"',totalsold='"+selectedItem.getTotalSold()+"',placement='"+selectedItem.getPlacement()+"',available='"+selectedItem.getAvailable()+"',discount='"+selectedItem.getDiscount()+"',tax='"+selectedItem.getTax()+"',uid='"+selectedItem.getId()+"' where id ="+selectedItem.getId()+";");
        } catch (Exception e) {
            openMessageDialog( e.getMessage(),"Error!!");
        }
    }
    public void deleteInventoryItem(ObservableList<InventoryTableItem> selectedItem) {
        try {
            Statement stmt = connection.createStatement();
            for (InventoryTableItem inventoryTableItem : selectedItem)
            {
                stmt.executeUpdate("delete from Inventory where id ="+inventoryTableItem.getId()+";");
            }
        } catch (Exception e) {
            openMessageDialog( e.getMessage(),"Error!!");
        }
    }


    public List<TodoTableItem> getTodoList() {
        try (
                Statement stmnt = connection.createStatement();
                ResultSet rs = stmnt.executeQuery("select * from Todo where uid='"+Bossex.userDetails.getId()+"'");
        ) {
            List<TodoTableItem> todoTableItemList  = new ArrayList<>();
            while (rs.next()) {
                TodoTableItem todoTableItem = new TodoTableItem(rs.getString("TodoDescription"),rs.getString("Date"),rs.getInt("id"));
                todoTableItemList.add(todoTableItem);
            }
            return todoTableItemList;
        }
        catch (Exception e)
        {
            openMessageDialog(e.getMessage(),"Error!!");
            return null;
        }
    }
    public void addTodo(String TodoDescription, String Date) {
        try {
            Statement stmt = connection.createStatement();
            stmt.executeUpdate("Insert into Todo(TodoDescription,Date,uid) values('" + TodoDescription + "','" + Date + "','" + Bossex.userDetails.getId() + "');");
        } catch (Exception e) {
            openMessageDialog( e.getMessage(),"Error!!");
        }
    }
    public void updateTodo(TodoTableItem selectedItem) {
        try {
            Statement stmt = connection.createStatement();
            stmt.executeUpdate("update Todo set TodoDescription='"+selectedItem.getTodoDescription()+"',Date='"+selectedItem.getDate()+"' where id ="+selectedItem.getId()+";");
        } catch (Exception e) {
            openMessageDialog( e.getMessage(),"Error!!");
        }
    }
    public void deleteTodo(ObservableList<TodoTableItem> selectedItem) {
        try {
            Statement stmt = connection.createStatement();
            for (TodoTableItem todoTableItem : selectedItem) stmt.executeUpdate("delete from Todo where id ="+todoTableItem.getId()+";");
        } catch (Exception e) {
            openMessageDialog( e.getMessage(),"Error!!");
        }
    }
    public void addIEmployee(EmployeesTemplate employeesTemplate) {
        try {
            Statement stmt = connection.createStatement();
            stmt.executeUpdate("Insert into Employee_Details(Personal_ID_Number,First_Name,Middle_Name,Last_Name,Date_of_Birth,Mobile,Alternate_Mobile,City,Address,Postal_Code,Qualification,Current_Experience,Start_Date,End_Date,Type_Employee,Designation_Id) values('"+employeesTemplate.getPersonal_ID_Number()+"','"+employeesTemplate.getFirst_Name()+"','"+employeesTemplate.getMiddle_Name()+"','"+employeesTemplate.getLast_Name()+"','"+employeesTemplate.getDate_of_Birth()+"','"+employeesTemplate.getMobile()+"','"+employeesTemplate.getAlternate_Mobile()+"','"+employeesTemplate.getCity()+"','"+employeesTemplate.getAddress()+"','"+employeesTemplate.getPostal_Code()+"','"+employeesTemplate.getQualification()+"','"+employeesTemplate.getCurrent_Experience()+"','"+employeesTemplate.getStart_Date()+"','"+employeesTemplate.getEnd_Date()+"','"+employeesTemplate.getType_Employee()+"','"+employeesTemplate.getDesignation_Id()+"');");
        } catch (Exception e) {
            openMessageDialog( e.getMessage(),"Error!!");
        }
    }
    public void updateEmployee(EmployeesTemplate changedVal) {
        try {
            Statement stmt = connection.createStatement();
            stmt.executeUpdate("update Employee_Details set Personal_ID_Number='"+changedVal.getPersonal_ID_Number()+"',First_Name='"+changedVal.getFirst_Name()+"',Middle_Name='"+changedVal.getMiddle_Name()+"',Last_Name='"+changedVal.getLast_Name()+"',Date_of_Birth='"+changedVal.getDate_of_Birth()+"',Mobile='"+changedVal.getMobile()+"',Alternate_Mobile='"+changedVal.getAlternate_Mobile()+"',City='"+changedVal.getCity()+"',Address='"+changedVal.getAddress()+"',Postal_Code='"+changedVal.getPostal_Code()+"',Qualification='"+changedVal.getQualification()+"',Current_Experience='"+changedVal.getCurrent_Experience()+"',Start_Date='"+changedVal.getStart_Date()+"',End_Date='"+changedVal.getEnd_Date()+"',Type_Employee='"+changedVal.getType_Employee()+"',Designation_Id='"+changedVal.getDesignation_Id()+"' where Employee_ID_Number ="+changedVal.getEmployee_ID_Number()+";");
        } catch (Exception e) {
            openMessageDialog( e.getMessage(),"Error!!");
        }
    }

    public List<EmployeesTemplate> getEmployeeList() {
        try (
                Statement stmnt = connection.createStatement();
                ResultSet rs = stmnt.executeQuery("select * from Employee_Details");
        ) {
            List<EmployeesTemplate> employeeDetailsList = new ArrayList<>();
            while (rs.next()) {
                EmployeesTemplate employeesTemplate = new EmployeesTemplate(rs.getInt("Employee_ID_Number"), rs.getString("Personal_ID_Number"),rs.getString("First_Name"), rs.getString("Middle_Name"), rs.getString("Last_Name"), rs.getString("Date_of_Birth"), rs.getString("Mobile"),rs.getString("Alternate_Mobile"),rs.getString("City"),rs.getString("Address"),rs.getString("Postal_Code"),rs.getString("Qualification"),rs.getString("Current_Experience"),rs.getString("Start_Date"),rs.getString("End_Date"),rs.getString("Type_Employee"),rs.getString("Designation_Id"));
                employeeDetailsList.add(employeesTemplate);
            }
            return employeeDetailsList;
        }
        catch (Exception e)
        {
            openMessageDialog(e.getMessage(),"Error!!");
            return null;
        }
    }
    public void deleteEmployee(ObservableList<EmployeesTemplate> selectedItem) {
        try {
            Statement stmt = connection.createStatement();
            for (EmployeesTemplate employeesTemplate : selectedItem) stmt.executeUpdate("delete from Employee_Details where id ="+employeesTemplate.getEmployee_ID_Number()+";");
        } catch (Exception e) {
            openMessageDialog( e.getMessage(),"Error!!");
        }
    }

    public static void main(String args[])
    {

    }

    public List<UserRoleModel> getRoleList() {
        try (
                Statement stmnt = connection.createStatement();
                ResultSet rs = stmnt.executeQuery("Select * from UserRoles;");
        ) {
            List<UserRoleModel> roleList = new ArrayList<>();
            while (rs.next()) {
                int id = rs.getInt("id");
                String permission = rs.getString("permission");
                String roleName=rs.getString("roleName");
                UserRoleModel userRoleModel = new UserRoleModel(id, roleName,permission);
                roleList.add(userRoleModel);
            }
            return roleList;
        }
        catch (Exception e)
        {
            openMessageDialog(e.getMessage(),"Error!!");
            return null;
        }
    }

    public void addRole(UserRoleModel userRoleModel) {
        try {
            Statement stmt = connection.createStatement();
            stmt.executeUpdate("Insert into UserRoles(roleName,permission) values('"+userRoleModel.getRoleName()+"','"+userRoleModel.getPermission()+"');");
        } catch (Exception e) {
            openMessageDialog( e.getMessage(),"Error!!");
        }
    }
    public void deleteRole(UserRoleModel userRoleModel) {
        try {
            Statement stmt = connection.createStatement();
            stmt.executeUpdate("Delete from UserRoles where id="+userRoleModel.getid()+";");
        } catch (Exception e) {
            openMessageDialog( e.getMessage(),"Error!!");
        }
    }

    public List<SuppliersModel> getSuppliers() {
        try (
                Statement stmnt = connection.createStatement();
                ResultSet rs = stmnt.executeQuery(Queries.getSuppliers);
        ) {
            List<SuppliersModel> suppliersList = new ArrayList<>();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String emailId = rs.getString("emailId");
                String mNo = rs.getString("mNo");
                String gstin = rs.getString("gstin");
                double openingBalance= rs.getDouble("openingBalance");
                double totalPurchaseDue= rs.getDouble("totalPurchaseDue");
                double totalPurchaseReturnDue= rs.getDouble("totalPurchaseReturnDue");
                String  addedOn= rs.getString("addedOn");
                String  address= rs.getString("address");
                String  businessName= rs.getString("businessName");
                String paytermDesc = rs.getString("paytermDesc");
                int payterm = rs.getInt("payterm");
                SuppliersModel suppliersTemplate = new SuppliersModel(emailId,businessName,mNo,id,name,payterm,paytermDesc,addedOn,gstin,openingBalance,address,totalPurchaseDue,totalPurchaseReturnDue);
                suppliersList.add(suppliersTemplate);
            }
            return suppliersList;
        }
        catch (Exception e)
        {
            openMessageDialog(e.getMessage(),"Error!!");
            return null;
        }
    }

    public void deleteSupplier(SuppliersModel suppliersModel) {
        try {
            Statement stmt = connection.createStatement();
            stmt.executeUpdate("Delete from Suppliers where id="+suppliersModel.getId()+";");
        } catch (Exception e) {
            openMessageDialog( e.getMessage(),"Error!!");
        }
    }
    public void addSupplier(String emailId, String businessName, String mNo, String name, int payterm, String gstin, double openingBalance,String address, double totalPurchaseDue, double totalPurchaseReturnDue) {
        try {
            Statement stmt = connection.createStatement();
            stmt.executeUpdate("Insert into Suppliers(emailId,businessName,mNo,name,payterm,gstin,openingBalance,address,totalPurchaseDue,totalPurchaseReturnDue) values('" + emailId + "','" +businessName+ "','" +mNo+ "','" +name+ "'," +payterm+ ",'" +gstin+ "'," +openingBalance+ ",'" +address+ "'," +totalPurchaseDue+ "," +totalPurchaseReturnDue+");");
        } catch (Exception e) {
            openMessageDialog( e.getMessage(),"Error!!");
        }
    }
    public List<CustomersModel> getCustomers() {
        try (
                Statement stmnt = connection.createStatement();
                ResultSet rs = stmnt.executeQuery(Queries.getCustomers);
        ) {
            List<CustomersModel> customersList = new ArrayList<>();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String emailId = rs.getString("emailId");
                String mNo = rs.getString("mNo");
                String pancard = rs.getString("pancard");
                double openingBalance= rs.getDouble("openingBalance");
                double creditLimit= rs.getDouble("creditLimit");
                double advanceBalance= rs.getDouble("advanceBalance");
                double totalSellDue= rs.getDouble("totalSellDue");
                double totalSellReturnDue= rs.getDouble("totalSellReturnDue");
                String  addedOn= rs.getString("addedOn");
                String  address= rs.getString("address");
                String paytermDesc = rs.getString("paytermDesc");
                int payterm = rs.getInt("payterm");
                String customerGroupName = rs.getString("customerGroupName");
                int customerGroup = rs.getInt("customerGroup");
                CustomersModel customersTemplate = new CustomersModel(emailId,mNo,id,name,payterm,paytermDesc,addedOn,customerGroup,customerGroupName,pancard,openingBalance,creditLimit,advanceBalance,address,totalSellDue,totalSellReturnDue);
                customersList.add(customersTemplate);
            }
            return customersList;
        }
        catch (Exception e)
        {
            openMessageDialog(e.getMessage(),"Error!!");
            return null;
        }
    }

    public void deleteCustomer(CustomersModel customersModel) {
        try {
            Statement stmt = connection.createStatement();
            stmt.executeUpdate("Delete from Customers where id="+customersModel.getId()+";");
        } catch (Exception e) {
            openMessageDialog( e.getMessage(),"Error!!");
        }
    }
    public void addCustomer(String emailId, String mNo, String name, int payterm, String pancard, double openingBalance, double creditLimit, double advanceBalance,String address, double totalSellDue, double totalSellReturnDue,int customerGroup) {
        try {
            Statement stmt = connection.createStatement();
            stmt.executeUpdate("Insert into Customers(emailId,mNo,name,payterm,pancard,openingBalance,address,totalSellDue,totalSellReturnDue,creditLimit,advanceBalance,customerGroup) values('" + emailId + "','" +mNo+ "','" +name+ "'," +payterm+ ",'" +pancard+ "'," +openingBalance+ ",'" +address+ "'," +totalSellDue+ "," +totalSellReturnDue+ "," +creditLimit+ "," +advanceBalance+ "," +customerGroup+");");
        } catch (Exception e) {
            openMessageDialog( e.getMessage(),"Error!!");
        }
    }

    public List<CustomerGroupsModel> getCustomerGroupsModel() {
        try (
                Statement stmnt = connection.createStatement();
                ResultSet rs = stmnt.executeQuery(Queries.getCustomerGroups);
        ) {
            List<CustomerGroupsModel> customersList = new ArrayList<>();
            while (rs.next()) {
                int id = rs.getInt("id");
                String customerGroupName = rs.getString("customerGroupName");
                double calculationPercentage = rs.getDouble("calculationPercentage");
                CustomerGroupsModel customerGroupsTemplate = new CustomerGroupsModel(id,customerGroupName,calculationPercentage);
                customersList.add(customerGroupsTemplate);
            }
            return customersList;
        }
        catch (Exception e)
        {
            openMessageDialog(e.getMessage(),"Error!!");
            return null;
        }
    }
    public void deleteCustomerGroup(CustomerGroupsModel customerGroupsModel) {
        try {
            Statement stmt = connection.createStatement();
            stmt.executeUpdate("Delete from CustomerGroups where id="+customerGroupsModel.getId()+";");
        } catch (Exception e) {
            openMessageDialog( e.getMessage(),"Error!!");
        }
    }
    public void addCustomerGroup(String customerGroupName, double calculationPercentage) {
        try {
            Statement stmt = connection.createStatement();
            stmt.executeUpdate("Insert into CustomerGroups(customerGroupName,calculationPercentage) values('" + customerGroupName + "'," +calculationPercentage+");");
        } catch (Exception e) {
            openMessageDialog( e.getMessage(),"Error!!");
        }
    }

    //Payterm model cred operations
    public List<PaytermModel> getPaytermModels() {
        try (
                Statement stmnt = connection.createStatement();
                ResultSet rs = stmnt.executeQuery(Queries.getPayterms);
        ) {
            List<PaytermModel> paytermList = new ArrayList<>();
            while (rs.next()) {
                int id = rs.getInt("id");
                String paytermDesc = rs.getString("paytermDesc");
                PaytermModel paytermTemplate = new PaytermModel(id,paytermDesc);
                paytermList.add(paytermTemplate);
            }
            return paytermList;
        }
        catch (Exception e)
        {
            openMessageDialog(e.getMessage(),"Error!!");
            return null;
        }
    }
    public  void addPayterm(String paytermDesc){
        try {
            Statement stmt = connection.createStatement();
            stmt.executeUpdate("Insert into Payterms(paytermDesc) values('" + paytermDesc+"');");
        } catch (Exception e) {
            openMessageDialog( e.getMessage(),"Error!!");
        }
    }
    public void deletePayterm(PaytermModel paytermModel) {
        try {
            Statement stmt = connection.createStatement();
            stmt.executeUpdate("Delete from Payterm where id="+paytermModel.getId()+";");
        } catch (Exception e) {
            openMessageDialog( e.getMessage(),"Error!!");
        }
    }

    //Product table model cred operations
    public List<ProductsTableModel> getProducts() {
        try (
                Statement stmnt = connection.createStatement();
                ResultSet rs = stmnt.executeQuery(Queries.getProducts);
        ) {
            List<ProductsTableModel> products = new ArrayList<>();
            while (rs.next()) {
                int id = rs.getInt("id");
                String productName = rs.getString("product");
                String businessLocation=rs.getString("businessLocation");
                int businessLocationId=rs.getInt("businessLocationId");
                double unitPurchasePrice=rs.getDouble("unitPurchasePrice");
                double sellingPrice=rs.getDouble("sellingPrice");
                double currentStock=rs.getDouble("currentStock");
                String productType=rs.getString("productType");
                String category=rs.getString("category");
                int categoryId=rs.getInt("categoryId");
                int brandId=rs.getInt("brandId");
                String brand=rs.getString("brand");
                double tax=rs.getDouble("tax");
                String sku=rs.getString("sku");
                int unitId=rs.getInt("unitId");
                String unit=rs.getString("unit");
                ProductsTableModel product = new ProductsTableModel(id,productName,businessLocationId,businessLocation,unitPurchasePrice,sellingPrice,currentStock,productType,categoryId,category,brandId,brand,tax,sku,unitId,unit);
                products.add(product);
            }
            return products;
        }
        catch (Exception e)
        {
            openMessageDialog(e.getMessage(),"Error!!");
            return null;
        }
    }
    public void addProducts(String product,int businessLocationId,double unitPurchasePrice,double sellingPrice,double currentStock,String productType,int categoryId,int brandId,double tax,String sku,int unitId){
        try {
            Statement stmt = connection.createStatement();
            stmt.executeUpdate("Insert into Products(product,businessLocationId,unitPurchasePrice,sellingPrice,currentStock,productType,categoryId,brandId,tax,sku,unitId) values('" + product + "'," + businessLocationId + ","+unitPurchasePrice+ ","+sellingPrice+ ","+currentStock+ ",'"+productType+ "',"+categoryId+","+brandId+","+tax+",'"+sku+"',"+unitId+");");
        } catch (Exception e) {
            openMessageDialog( e.getMessage(),"Error!!");
        }
    }
    public void deleteProduct(ProductsTableModel productsTableModel) {
        try {
            Statement stmt = connection.createStatement();
            stmt.executeUpdate("Delete from Products where id="+productsTableModel.getId()+";");
        } catch (Exception e) {
            openMessageDialog( e.getMessage(),"Error!!");
        }
    }
    //Business Location Model cred operation
    public List<BusinessLocationsModel> getBusinessLocations() {
        try (
                Statement stmnt = connection.createStatement();
                ResultSet rs = stmnt.executeQuery(Queries.getBusinessLocations);
        ) {
            List<BusinessLocationsModel> businessLocations = new ArrayList<>();
            while (rs.next()) {
                int id = rs.getInt("id");
                String businessLocation=rs.getString("businessLocation");
                String address=rs.getString("address");
                BusinessLocationsModel businessLocationsModel = new BusinessLocationsModel(id,businessLocation,address);
                businessLocations.add(businessLocationsModel);
            }
            return businessLocations;
        }
        catch (Exception e)
        {
            openMessageDialog(e.getMessage(),"Error!!");
            return null;
        }
    }

    public void addBusinessLocation(String businessLocationName, String address) {
        try {
            Statement stmt = connection.createStatement();
            stmt.executeUpdate("Insert into BusinessLocations(businessLocation,address) values('" + businessLocationName + "','" + address+"');");
        } catch (Exception e) {
            openMessageDialog( e.getMessage(),"Error!!");
        }
    }

    public void deleteBusinessLocations(BusinessLocationsModel businessLocation) {
        try {
            Statement stmt = connection.createStatement();
            stmt.executeUpdate("Delete from BusinessLocations where id="+businessLocation.getId()+";");
        } catch (Exception e) {
            openMessageDialog( e.getMessage(),"Error!!");
        }
    }

    //ProductCategories cred operations
    public List<ProductCategoriesModel> getProductCategories() {
        try (
                Statement stmnt = connection.createStatement();
                ResultSet rs = stmnt.executeQuery(Queries.getProductCategories);
        ) {
            List<ProductCategoriesModel> productCategories = new ArrayList<>();
            while (rs.next()) {
                int id = rs.getInt("id");
                String category=rs.getString("category");
                ProductCategoriesModel productCategoriesModel = new ProductCategoriesModel(id,category);
                productCategories.add(productCategoriesModel);
            }
            return productCategories;
        }
        catch (Exception e)
        {
            openMessageDialog(e.getMessage(),"Error!!");
            return null;
        }
    }

    public void addProductCategory(String category) {
        try {
            Statement stmt = connection.createStatement();
            stmt.executeUpdate("Insert into ProductCategories(category) values('" + category+"');");
        } catch (Exception e) {
            openMessageDialog( e.getMessage(),"Error!!");
        }
    }

    public void deleteProductCategory(ProductCategoriesModel productCategoriesModel) {
        try {
            Statement stmt = connection.createStatement();
            stmt.executeUpdate("Delete from ProductCategories where id="+productCategoriesModel.getId()+";");
        } catch (Exception e) {
            openMessageDialog( e.getMessage(),"Error!!");
        }
    }
    //Brands cred operations
    public List<BrandsModel> getBrands() {
        try (
                Statement stmnt = connection.createStatement();
                ResultSet rs = stmnt.executeQuery(Queries.getBrands);
        ) {
            List<BrandsModel> brands = new ArrayList<>();
            while (rs.next()) {
                int id = rs.getInt("id");
                String brand=rs.getString("brand");
                BrandsModel brandsModel = new BrandsModel(id,brand);
                brands.add(brandsModel);
            }
            return brands;
        }
        catch (Exception e)
        {
            openMessageDialog(e.getMessage(),"Error!!");
            return null;
        }
    }

    public void addBrand(String brand) {
        try {
            Statement stmt = connection.createStatement();
            stmt.executeUpdate("Insert into Brands(brand) values('" + brand+"');");
        } catch (Exception e) {
            openMessageDialog( e.getMessage(),"Error!!");
        }
    }

    public void deleteBrand(BrandsModel brandsModel) {
        try {
            Statement stmt = connection.createStatement();
            stmt.executeUpdate("Delete from Brands where id="+brandsModel.getId()+";");
        } catch (Exception e) {
            openMessageDialog( e.getMessage(),"Error!!");
        }
    }
    //Units cred operations
    public List<UnitsModel> getUnits() {
        try (
                Statement stmnt = connection.createStatement();
                ResultSet rs = stmnt.executeQuery(Queries.getUnits);
        ) {
            List<UnitsModel> units = new ArrayList<>();
            while (rs.next()) {
                int id = rs.getInt("id");
                String unit=rs.getString("unit");
                UnitsModel unitModel = new UnitsModel(id,unit);
                units.add(unitModel);
            }
            return units;
        }
        catch (Exception e)
        {
            openMessageDialog(e.getMessage(),"Error!!");
            return null;
        }
    }

    public void addUnits(String unit) {
        try {
            Statement stmt = connection.createStatement();
            stmt.executeUpdate("Insert into Units(unit) values('" + unit+"');");
        } catch (Exception e) {
            openMessageDialog( e.getMessage(),"Error!!");
        }
    }

    public void deleteUnit(UnitsModel unitsModel) {
        try {
            Statement stmt = connection.createStatement();
            stmt.executeUpdate("Delete from Units where id="+unitsModel.getId()+";");
        } catch (Exception e) {
            openMessageDialog( e.getMessage(),"Error!!");
        }
    }
}
