<%-- 
    Document   : Modules
    Created on : 27.okt.2017, 13:53:30
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
        
         <link rel="stylesheet" type="text/css" href="index.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
  
       
   <body>
         
        <h1><center>Alle moduler</center></h1>
        
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
        
        <div id="Textaline">
        <br>
        
      
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
            String query = "SELECT * FROM Module ORDER BY M_ID";

            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet rs = statement.executeQuery();
            
            
            
            while (rs.next())
                
            {
                out.println(rs.getInt("M_ID") + ("&nbsp;&nbsp;&nbsp;&nbsp"));
                out.println(rs.getString("M_Name") + ("&nbsp;&nbsp;&nbsp;&nbsp"));
                out.println(rs.getString("M_Tittle") + ("&nbsp;&nbsp;&nbsp;&nbsp"));
                out.println(rs.getString("M_Description"));
                out.println("<br>");
                 
                
               
            }
            
        %>
        
             <p>
            </div>
        <center><form name="Go back" action="index.jsp">
                <input type="submit" value="Gå tilbake"/> </form></center>
    </p>
    </body>

