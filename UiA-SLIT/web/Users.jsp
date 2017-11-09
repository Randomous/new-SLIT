<%-- 
    Document   : index
    Created on : Oct 25, 2017, 1:45:21 PM
    Author     : root
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
         <link rel="stylesheet" type="text/css" href="index.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
   <body>
       <h1><center> Liste over studenter i emnet</center></h1>
       
    <div id="first">
    </div>
    <div id="second">
    </div>
    <div id="title">
    </div>
       
   <div id="mySidenav" class="sidenav">
  <a href="javascript:void(0)" class="closebtn" onclick="closeNav()">&times;</a>
  <br>
  <br>
  <a href="module.jsp">Moduler</a>
  <a href="Users.jsp"> Brukere</a>
  <a href="Modules.jsp">Moduler(database)</a> 
  <a href="Deliverable.jsp">Deliverable</a>
  <a href="#">Ikke</a>
</div>
        
        <br>
        <div id="Textaline">
         <a href="#">Users</a>
       <ul>
        <%
            InitialContext initialContext = new InitialContext();
            Context context = (Context) initialContext.lookup("java:comp/env");
            //The JDBC Data source that we just created
            DataSource ds = (DataSource) context.lookup("Randobase");
            Connection connection = ds.getConnection();

            if (connection == null)
            {
                throw new SQLException("Error establishing connection!");
            }
            String query = "SELECT * FROM Users ORDER BY U_FirstName, U_SurName";

            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet rs = statement.executeQuery();

            while (rs.next())
            {
                out.println(rs.getInt("UserID") + ("&nbsp;&nbsp;&nbsp;&nbsp"));
                out.println(rs.getString("U_FirstName") + ("&nbsp;&nbsp;&nbsp;&nbsp"));
                out.println(rs.getString("U_SurName") + ("&nbsp;&nbsp;&nbsp;&nbsp"));
                out.println(rs.getString("U_Email"));
//                out.println("<a href='Modules.jsp>" + rs.getInt("UserID"));
                out.println("<li><a href='Modules.jsp'> 'Gå til bruker " + rs.getInt("UserID") + "</a></li>");
                out.println("<br>");
            }
        %>
   
      
       </ul>
   </div>
             <p>
        <center><form name="Go back" action="index.jsp">
                <input type="submit" value="Gå tilbake"/> </form></center>
    </body>

