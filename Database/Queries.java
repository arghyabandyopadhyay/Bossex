package BusinessGenie.app.Bossex.Database;

public class Queries {
    static String getUsersInnerJoinUserRoles="Select * from Users inner join UserRoles on Users.roleId=UserRoles.id;";
}
