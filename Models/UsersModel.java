package BusinessGenie.app.Bossex.Models;

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
    private final IntegerProperty uid = new SimpleIntegerProperty(this, "uid");
    private final StringProperty theme = new SimpleStringProperty(this, "theme");
    private final StringProperty name = new SimpleStringProperty(this, "name");

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

    public IntegerProperty uidProperty() {
        return uid;
    }

    public StringProperty themeProperty() {
        return theme;
    }

    public StringProperty nameProperty() {
        return name;
    }

    public final String getuserId() {
        return userIdProperty().get();
    }

    public final String getMNo() {
        return mNoProperty().get();
    }

    public final int getUid() {
        return uidProperty().get();
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

    public final void setUid(int uid) {
        uidProperty().set(uid);
    }

    public final void setTheme(String theme) {
        themeProperty().set(theme);
    }

    public final void setName(String name) {
        nameProperty().set(name);
    }


    public UsersModel(String userId, String permission, String password, String emailId, String mNo, int uid, String theme, String name) {
        setUserId(userId);
        setPermission(permission);
        setPassword(password);
        setEmailId(emailId);
        setMNo(mNo);
        setUid(uid);
        setTheme(theme);
        setName(name);
    }
}
