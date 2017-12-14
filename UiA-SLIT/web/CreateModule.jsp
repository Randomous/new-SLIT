<%-- 
    Document   : CreateModule
    Created on : Nov 9, 2017, 11:13:15 AM
    Author     : Daniel
--%>

<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
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
        <jsp:include page="UserInfo.jsp" />
        <title>JSP Page</title>
    </head>
   <body>
       <h1 class="TextFormat"> Resultat</h1>
        <br>
        
       <ul class="TextFormat">
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
                Statement st = connection.createStatement();
                
         String ModuleNumber = request.getParameter("ModuleNumber");         
         String ModuleName = request.getParameter("ModuleName");
         String Tittle = request.getParameter("Tittle");
         String Description = request.getParameter("Description");
           
          
          st.executeUpdate("insert into Module (M_Name, M_Tittle, M_Description)values('"+ModuleName+"','"+Tittle+"','"+Description+"')");
          

          out.println("modulen har blitt lagret i systemet");
            
           
        %>
   
      
       </ul>
   
             <p>
        <center><form name="Go back" action="index.jsp">
                <input type="submit" value="Gå tilbake"/> </form></center>
    </body>

