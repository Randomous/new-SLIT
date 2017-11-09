<%-- 
    Document   : LoginResponse
    Created on : 07.nov.2017, 13:03:01
    Author     : Helll
--%>

<%@page import="javax.naming.Context"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.Connection"%>
<%@page import="javax.sql.DataSource"%>
<%@page import="javax.naming.InitialContext"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
   <body>
       <h1> Resultat</h1>
        <br>
         <a href="#"></a>
       <ul>
        <%
            
            try{
            InitialContext initialContext = new InitialContext();
            Context context = (Context) initialContext.lookup("java:comp/env");
            //The JDBC Data source that we just created
            DataSource ds = (DataSource) context.lookup("Randobase");
            Connection connection = ds.getConnection();
            
            String username = request.getParameter("j_username");
            String password = request.getParameter("j_password");
            
            PreparedStatement pst = connection.prepareStatement("SELECT U_UserName, U_Password FROM Users WHERE U_UserName =? AND U_Password =? ");
            pst.setString(1, username);
            pst.setString(2, password);
            ResultSet rs = pst.executeQuery();
            
            if(rs.next())
                out.println("Gyldig brukernavn og passord");
            else
                out.println("Brukernavn eller passord stemmer ikke overens, ellers ligger du ikke i systemet");
            }
            catch(Exception e){
                out.println("Something went wrong!! Please try again");
            }

           
        %>
   
      
       </ul>
   
             <p>
        <center><form name="Go back" action="Login.jsp">
                <input type="submit" value="Gå tilbake"/> </form></center>
    </body>


