package BusinessGenie.app.Bossex.Models.Users;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
public class UserRoleModel {
    private final IntegerProperty id = new SimpleIntegerProperty(this, "id");
    private final StringProperty permission = new SimpleStringProperty(this, "permission");
    private final StringProperty roleName = new SimpleStringProperty(this, "roleName");

    public IntegerProperty idProperty() {
        return id;
    }

    public StringProperty permissionProperty() {
        return permission;
    }
    public StringProperty roleNameProperty() {
        return roleName;
    }

    public final int getid() {
        return idProperty().get();
    }

    public final String getPermission() {
        return permissionProperty().get();
    }

    public final String getRoleName() {
        return roleNameProperty().get();
    }


    public final void setId(int id) {
        idProperty().set(id);
    }

    public final void setPermission(String permission) {
        permissionProperty().set(permission);
    }

    public final void setRoleName(String roleName) {
        roleNameProperty().set(roleName);
    }


    public UserRoleModel(int id, String roleName,String permission) {
        setId(id);
        setPermission(permission);
        setRoleName(roleName);
    }
}

