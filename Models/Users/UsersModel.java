package BusinessGenie.app.Bossex.Models.Users;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class UsersModel {
    private final StringProperty userId = new SimpleStringProperty(this, "userId");
    private final StringProperty permission = new SimpleStringProperty(this, "permission");
    private final StringProperty password = new SimpleStringProperty(this, "password");
    private final StringProperty emailId = new SimpleStringProperty(this, "emailId");
    private final StringProperty mNo = new SimpleStringProperty(this, "mNo");
    private final IntegerProperty id = new SimpleIntegerProperty(this, "id");
    private final StringProperty theme = new SimpleStringProperty(this, "theme");
    private final StringProperty name = new SimpleStringProperty(this, "name");
    private final StringProperty roleName = new SimpleStringProperty(this, "roleName");
    private final IntegerProperty roleId = new SimpleIntegerProperty(this, "roleId");

    public StringProperty userIdProperty() {
        return userId;
    }

    public StringProperty permissionProperty() {
        return permission;
    }

    public StringProperty passwordProperty() {
        return password;
    }

    public StringProperty emailIdProperty() {
        return emailId;
    }

    public StringProperty mNoProperty() {
        return mNo;
    }

    public IntegerProperty idProperty() {
        return id;
    }

    public StringProperty themeProperty() {
        return theme;
    }

    public StringProperty nameProperty() {
        return name;
    }
    public StringProperty roleNameProperty() {
        return roleName;
    }
    public IntegerProperty roleIdProperty() {
        return roleId;
    }

    public final String getuserId() {
        return userIdProperty().get();
    }

    public final String getMNo() {
        return mNoProperty().get();
    }

    public final int getId() {
        return idProperty().get();
    }

    public final String getEmailId() {
        return emailIdProperty().get();
    }

    public final String getPassword() {
        return passwordProperty().get();
    }

    public final String getPermission() {
        return permissionProperty().get();
    }

    public final String getTheme() {
        return themeProperty().get();
    }

    public final String getName() {
        return nameProperty().get();
    }

    public final String getRoleName() {
        return roleNameProperty().get();
    }

    public final int getRoleId() {
        return roleIdProperty().get();
    }


    public final void setUserId(String userId) {
        userIdProperty().set(userId);
    }

    public final void setPermission(String permission) {
        permissionProperty().set(permission);
    }

    public final void setPassword(String password) {
        passwordProperty().set(password);
    }

    public final void setEmailId(String emailId) {
        emailIdProperty().set(emailId);
    }

    public final void setMNo(String mNo) {
        mNoProperty().set(mNo);
    }

    public final void setId(int id) {
        idProperty().set(id);
    }

    public final void setTheme(String theme) {
        themeProperty().set(theme);
    }

    public final void setName(String name) {
        nameProperty().set(name);
    }

    public final void setRoleName(String roleName) {
        roleNameProperty().set(roleName);
    }

    public final void setRoleId(int roleId) {
        roleIdProperty().set(roleId);
    }


    public UsersModel(String userId, String permission, String password, String emailId, String mNo, int id, String theme, String name,int roleId,String roleName) {
        setUserId(userId);
        setPermission(permission);
        setPassword(password);
        setEmailId(emailId);
        setMNo(mNo);
        setId(id);
        setTheme(theme);
        setName(name);
        setRoleName(roleName);
        setRoleId(roleId);
    }
}
