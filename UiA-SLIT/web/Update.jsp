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
       <h1>Update data from database in jsp</h1>

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
            String query = "SELECT * FROM Module";
            
PreparedStatement statement = connection.prepareStatement(query);
ResultSet rs = statement.executeQuery();
String M_ID = request.getParameter("M_ID");
while(rs.next()){
%>

<form action="UpdateModule.jsp" method = "post">
<input type="text" name="M_ID" value="<%=rs.getInt("M_ID") %>">
<br>
Module Name:<br>
<input type="text" name="Module Name" value="<%=rs.getString("M_Name") %>">
<br>
Module Tittle:<br>
<input type="text" name="Module Tittle" value="<%=rs.getString("M_Tittle") %>">
<br>
Module Description:<br>
<input type="text" name="Module Description" value="<%=rs.getString("M_Description") %>">
<br>
<input type="submit" value="submit">
</form>
<%
}
%>
</ul>
 
 <center><form name="Go back" action="index.jsp">
                <input type="submit" value="Gå tilbake"/> </form></center>
</body>
</html>
