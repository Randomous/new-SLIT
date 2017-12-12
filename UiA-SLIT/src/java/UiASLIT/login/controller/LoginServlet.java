/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package UiASLIT.login.controller;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import UiASLIT.login.bean.LoginBean;
import UiASLIT.login.dao.LoginDao;
public class LoginServlet extends HttpServlet {
private static final long serialVersionUID = 1L;

public LoginServlet() {
}
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
String userName = request.getParameter("username");
String password = request.getParameter("password");
LoginBean loginBean = new LoginBean();
loginBean.setUserName(userName);
loginBean.setPassword(password);
LoginDao loginDao = new LoginDao();
try
{
String userValidate = loginDao.authenticateUser(loginBean);
if(userValidate.equals("Lærer"))
{
System.out.println("Teacher's Home");
HttpSession session = request.getSession(); //Creating a session
session.setAttribute("userName", userName);
session.setAttribute("role", loginBean.getRole());
session.setAttribute("userID", loginBean.getID());
request.getRequestDispatcher("/index.jsp").forward(request, response);
}
else if(userValidate.equals("Hjelpelærer"))
{
System.out.println("Teacher Assistent's Home");
HttpSession session = request.getSession();
session.setAttribute("userName", userName);
session.setAttribute("role", loginBean.getRole());
session.setAttribute("userID", loginBean.getID());
request.getRequestDispatcher("/index.jsp").forward(request, response);
}
else if(userValidate.equals("Student"))
{
System.out.println("Student's Home");
HttpSession session = request.getSession();
session.setMaxInactiveInterval(10*60);
session.setAttribute("userName", userName);
session.setAttribute("role", loginBean.getRole());
session.setAttribute("userID", loginBean.getID());
request.getRequestDispatcher("/index.jsp").forward(request, response);
}
else
{
System.out.println("Error message = "+userValidate);
request.setAttribute("errMessage", userValidate);
request.getRequestDispatcher("/RoleLogin.jsp").forward(request, response);
}
}
catch (IOException e1)
{
e1.printStackTrace();
}
catch (Exception e2)
{
e2.printStackTrace();
}
}
}
