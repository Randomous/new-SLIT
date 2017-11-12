
package com.login.dao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.login.bean.LoginBean;
import com.login.util.DBConnection;
public class LoginDao {
public String authenticateUser(LoginBean loginBean)
{
String userName = loginBean.getUserName();
String password = loginBean.getPassword();
Connection con = null;
Statement statement = null;
ResultSet resultSet = null;
String U_UserName = "";
String U_Password = "";
String U_Role = "";
String UserID = "";

try
{
con = DBConnection.createConnection();
statement = con.createStatement();
resultSet = statement.executeQuery("SELECT UserID, U_UserName, U_Password, U_Role, U_FirstName FROM Users");
while(resultSet.next())
{
U_UserName = resultSet.getString("U_UserName");
U_Password = resultSet.getString("U_Password");
U_Role = resultSet.getString("U_Role");
UserID = resultSet.getString("UserID");

if(userName.equals(U_UserName) && password.equals(U_Password) && U_Role.equals("Lærer")) {
    loginBean.setRole(U_Role);
    loginBean.setID(UserID);
    return "Lærer";
}
else if(userName.equals(U_UserName) && password.equals(U_Password) && U_Role.equals("Hjelpelærer")) {
    loginBean.setRole(U_Role);
    loginBean.setID(UserID);
    return "Hjelpelærer";
}
else if(userName.equals(U_UserName) && password.equals(U_Password) && U_Role.equals("Student")) {
    loginBean.setRole(U_Role);
    loginBean.setID(UserID);
    return "Student";
}
}
}
catch(SQLException e)
{
e.printStackTrace();
}
return "Ugyldig brukernavn eller passord";
}
}