<%-- 
    Document   : ChangeLearningGoals
    Created on : 14.nov.2017, 13:07:38
    Author     : Helle K. Trygsland
--%>

<%@page import="java.sql.*" %>
<%@page import="javax.naming.Context"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.Connection"%>
<%@page import="javax.sql.DataSource"%>
<%@page import="javax.naming.InitialContext"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
         <link rel="stylesheet" type="text/css" href="index.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>

    <body>
         
        <h1 class="TextFormat"><center> Læringsmål </center></h1>
        
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
            String query = "SELECT * FROM LearningGoals WHERE M_ID";

            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet rs = statement.executeQuery(query);
           
            %>
            
             <%
            while (rs.next()){ %>
            
            <tr> 
              <TD>  <%= rs.getInt("LG_ID") %></TD>
              <TD>  <%= rs.getString("LG_Tittle") %></TD>
              <TD>  <%= rs.getString("LG_Description") %></TD>
             <% } %>
              
 
        
        </center>
             <p>
           
        <center>
                <input type="submit" value="Gå tilbake" onclick="history.back(-1)"/> </form></center>
    </p>
    </body>
</HTML>
