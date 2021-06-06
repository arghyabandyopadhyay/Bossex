package BusinessGenie.app.Bossex.Api;

import BusinessGenie.app.Bossex.Models.EmployeesTemplate;
import BusinessGenie.app.Bossex.Models.InventoryTableItem;
import javafx.collections.ObservableList;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import BusinessGenie.app.Bossex.Bossex;
import BusinessGenie.app.Bossex.Models.TodoTableItem;
import BusinessGenie.app.Bossex.Models.UsersModel;

public class ApiAccessor {
    private Connection connection;

    public ApiAccessor() {
        try {
            Class.forName(Bossex.driverClass);
            connection = DriverManager.getConnection(Bossex.apiUrl, Bossex.user, Bossex.password);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "An error occurred while connecting MySQL database", "Error!!", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }
    public void shutdown(){
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException throwables) {
                JOptionPane.showMessageDialog(null,throwables.getMessage(),"Error!!",JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public void setTheme(int uid, String theme) {
        try {
            Statement stmt = connection.createStatement();
            stmt.executeUpdate("update Users set theme='"+theme+"' where uid ="+uid+";");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(),"Error!!",JOptionPane.ERROR_MESSAGE);
        }
    }


    public List<UsersModel> getUserList() {
        try (
                Statement stmnt = connection.createStatement();
                ResultSet rs = stmnt.executeQuery("select * from Users");
        ) {
            List<UsersModel> usersList = new ArrayList<>();
            while (rs.next()) {
                String userId = rs.getString("userId");
                String permission = rs.getString("permission");
                String password = rs.getString("password");
                String emailId = rs.getString("emailId");
                String mNo = rs.getString("mNo");
                int uid = rs.getInt("uid");
                String theme=rs.getString("theme");
                String name=rs.getString("Name");
                UsersModel usersTemplate = new UsersModel(userId, permission, password, emailId, mNo, uid,theme,name);
                usersList.add(usersTemplate);
            }
            return usersList;
        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(null,e.getMessage(),"Error!!",JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }
    public void addUser(String userId, String permission, String password, String emailId, String mNo,String name) {
        try {
            Statement stmt = connection.createStatement();
            stmt.executeUpdate("Insert into Users(userId,permission,password,emailId,mNo,Name) values('" + userId + "','" + permission + "','" + password + "','" + emailId + "','" + mNo+ "','" + name + "');");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    public void updateUser(UsersModel selectedItem) {
        try {
            Statement stmt = connection.createStatement();
            stmt.executeUpdate("update Users set name='"+selectedItem.getName()+"',userId='"+selectedItem.getuserId()+"',mNo='"+selectedItem.getMNo()+"',emailId='"+selectedItem.getEmailId()+"',permission='"+selectedItem.getPermission()+"',password='"+selectedItem.getPassword()+"' where uid ="+selectedItem.getUid()+";");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(),"Error!!",JOptionPane.ERROR_MESSAGE);
        }
    }
    public void deleteUser(ObservableList<UsersModel> selectedItem) {
        try {
            Statement stmt = connection.createStatement();
            for (UsersModel usersTemplate : selectedItem)
            {
                stmt.executeUpdate("delete from Users where uid ="+usersTemplate.getUid()+";");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(),"Error!!",JOptionPane.ERROR_MESSAGE);
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
            JOptionPane.showMessageDialog(null,e.getMessage(),"Error!!",JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }
    public void addInventoryItem(InventoryTableItem inventoryTableItem) {
        try {
            Statement stmt = connection.createStatement();
            stmt.executeUpdate("Insert into Inventory(name,type,category,price,soldmonth,totalsold,placement,available,discount,tax,uid) values('" + inventoryTableItem.getName() + "','" + inventoryTableItem.getType() + "','" + inventoryTableItem.getCategory() + "','" + inventoryTableItem.getPrice() + "','" + inventoryTableItem.getSoldMonth()+ "','" + inventoryTableItem.getTotalSold() + "','" + inventoryTableItem.getPlacement()+ "','" + inventoryTableItem.getAvailable() + "','" + inventoryTableItem.getDiscount()+ "','" + inventoryTableItem.getTax() + "','" + inventoryTableItem.getId() + "');");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    public void updateInventoryItem(InventoryTableItem selectedItem) {
        try {
            Statement stmt = connection.createStatement();
            stmt.executeUpdate("update Inventory set name='"+selectedItem.getName()+"',type='"+selectedItem.getType()+"',category='"+selectedItem.getCategory()+"',price='"+selectedItem.getPrice()+"',soldmonth='"+selectedItem.getSoldMonth()+"',totalsold='"+selectedItem.getTotalSold()+"',placement='"+selectedItem.getPlacement()+"',available='"+selectedItem.getAvailable()+"',discount='"+selectedItem.getDiscount()+"',tax='"+selectedItem.getTax()+"',uid='"+selectedItem.getUid()+"' where id ="+selectedItem.getId()+";");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(),"Error!!",JOptionPane.ERROR_MESSAGE);
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
            JOptionPane.showMessageDialog(null, e.getMessage(),"Error!!",JOptionPane.ERROR_MESSAGE);
        }
    }


    public List<TodoTableItem> getTodoList() {
        try (
                Statement stmnt = connection.createStatement();
                ResultSet rs = stmnt.executeQuery("select * from Todo where uid='"+Bossex.userDetails.getUid()+"'");
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
            JOptionPane.showMessageDialog(null,e.getMessage(),"Error!!",JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }
    public void addTodo(String TodoDescription, String Date) {
        try {
            Statement stmt = connection.createStatement();
            stmt.executeUpdate("Insert into Todo(TodoDescription,Date,uid) values('" + TodoDescription + "','" + Date + "','" + Bossex.userDetails.getUid() + "');");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    public void updateTodo(TodoTableItem selectedItem) {
        try {
            Statement stmt = connection.createStatement();
            stmt.executeUpdate("update Todo set TodoDescription='"+selectedItem.getTodoDescription()+"',Date='"+selectedItem.getDate()+"' where id ="+selectedItem.getId()+";");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(),"Error!!",JOptionPane.ERROR_MESSAGE);
        }
    }
    public void deleteTodo(ObservableList<TodoTableItem> selectedItem) {
        try {
            Statement stmt = connection.createStatement();
            for (TodoTableItem todoTableItem : selectedItem) stmt.executeUpdate("delete from Todo where id ="+todoTableItem.getId()+";");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(),"Error!!",JOptionPane.ERROR_MESSAGE);
        }
    }



    public void addEmployee(EmployeesTemplate employeesTemplate) {
        try {
            Statement stmt = connection.createStatement();
            stmt.executeUpdate("Insert into Employee_Details(Personal_ID_Number,First_Name,Middle_Name,Last_Name,Date_of_Birth,Mobile,Alternate_Mobile,City,Address,Postal_Code,Qualification,Current_Experience,Start_Date,End_Date,Type_Employee,Designation_Id) values('"+employeesTemplate.getPersonal_ID_Number()+"','"+employeesTemplate.getFirst_Name()+"','"+employeesTemplate.getMiddle_Name()+"','"+employeesTemplate.getLast_Name()+"','"+employeesTemplate.getDate_of_Birth()+"','"+employeesTemplate.getMobile()+"','"+employeesTemplate.getAlternate_Mobile()+"','"+employeesTemplate.getCity()+"','"+employeesTemplate.getAddress()+"','"+employeesTemplate.getPostal_Code()+"','"+employeesTemplate.getQualification()+"','"+employeesTemplate.getCurrent_Experience()+"','"+employeesTemplate.getStart_Date()+"','"+employeesTemplate.getEnd_Date()+"','"+employeesTemplate.getType_Employee()+"','"+employeesTemplate.getDesignation_Id()+"');");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    public void updateEmployee(EmployeesTemplate changedVal) {
        try {
            Statement stmt = connection.createStatement();
            stmt.executeUpdate("update Employee_Details set Personal_ID_Number='"+changedVal.getPersonal_ID_Number()+"',First_Name='"+changedVal.getFirst_Name()+"',Middle_Name='"+changedVal.getMiddle_Name()+"',Last_Name='"+changedVal.getLast_Name()+"',Date_of_Birth='"+changedVal.getDate_of_Birth()+"',Mobile='"+changedVal.getMobile()+"',Alternate_Mobile='"+changedVal.getAlternate_Mobile()+"',City='"+changedVal.getCity()+"',Address='"+changedVal.getAddress()+"',Postal_Code='"+changedVal.getPostal_Code()+"',Qualification='"+changedVal.getQualification()+"',Current_Experience='"+changedVal.getCurrent_Experience()+"',Start_Date='"+changedVal.getStart_Date()+"',End_Date='"+changedVal.getEnd_Date()+"',Type_Employee='"+changedVal.getType_Employee()+"',Designation_Id='"+changedVal.getDesignation_Id()+"' where Employee_ID_Number ="+changedVal.getEmployee_ID_Number()+";");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(),"Error!!",JOptionPane.ERROR_MESSAGE);
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
            JOptionPane.showMessageDialog(null,e.getMessage(),"Error!!",JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }
    public void deleteEmployee(ObservableList<EmployeesTemplate> selectedItem) {
        try {
            Statement stmt = connection.createStatement();
            for (EmployeesTemplate employeesTemplate : selectedItem) stmt.executeUpdate("delete from Employee_Details where id ="+employeesTemplate.getEmployee_ID_Number()+";");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(),"Error!!",JOptionPane.ERROR_MESSAGE);
        }
    }
}

