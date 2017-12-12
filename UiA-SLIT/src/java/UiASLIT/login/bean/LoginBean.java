package UiASLIT.login.bean;
public class LoginBean {
private String userName;
private String password;
private String role;
private String userID;
public String getUserName() {
return userName;
}
public void setUserName(String userName) {
this.userName = userName;
}
public String getPassword() {
return password;
}
public void setPassword(String password) {
this.password = password;
}
public void setRole(String role) {
    this.role = role;
}
public String getRole() {
    return role;
}
public void setID(String userID) {
    this.userID = userID;
}
public String getID() {
    return userID;
}
}
