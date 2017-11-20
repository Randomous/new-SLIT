 <%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="java.io.*" %>
<%@page import="java.sql.*" %>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="javax.naming.Context"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.Connection"%>
<%@page import="javax.sql.DataSource"%>
<%@page import="javax.naming.InitialContext"%>
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
           
Statement statement = null;
ResultSet resultSet = null;
String M_ID= request.getParameter("M_ID");
%>
<html>
<body>
<h1>Retrieve data from database in jsp</h1>
<table border="1">
<tr>
<td>Module id</td>
<td>Module name</td>
<td>Tittle</td>
<td>Description</td>
</tr>
<%
try{
statement=connection.createStatement();
String sql ="select * from users";
resultSet = statement.executeQuery(sql);
while(resultSet.next()){
%>
<tr>
 <TD>  <%= resultSet.getInt("M_ID") %></TD>
 <TD>  <%= resultSet.getString("M_Name") %></TD>
 <TD>  <%= resultSet.getString("M_Tittle") %></TD>
 <TD>  <%= resultSet.getString("M_Description")%></TD>
<td><a href="update.jsp?M_ID=<%=resultSet.getString("M_ID")%>">update</a></td>
</tr>
<%
}
connection.close();
} catch (Exception e) {
e.printStackTrace();
}
%>
</table>
</body>
</html> 