
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

try
{
con = DBConnection.createConnection();
statement = con.createStatement();
resultSet = statement.executeQuery("SELECT U_UserName, U_Password, U_Role, U_FirstName FROM Users");
while(resultSet.next())
{
U_UserName = resultSet.getString("U_UserName");
U_Password = resultSet.getString("U_Password");
U_Role = resultSet.getString("U_Role");

if(userName.equals(U_UserName) && password.equals(U_Password) && U_Role.equals("Lærer"))
return "Lærer";
else if(userName.equals(U_UserName) && password.equals(U_Password) && U_Role.equals("Hjelpelærer"))
return "Hjelpelærer";
else if(userName.equals(U_UserName) && password.equals(U_Password) && U_Role.equals("Student"))
return "Student";
}
}
catch(SQLException e)
{
e.printStackTrace();
}
return "Ugyldig brukernavn eller passord";
}
}