
<%@page import="java.sql.Statement"%>
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
        <title>UiA-SLIT</title>
        <jsp:include page="UserInfo.jsp" />
    </head>

    <body>
        



    <%   
        Connection con= null;
        Statement statement = null;
        ResultSet resultSet = null;  
        %>
        
        
<%
    String M_ID = request.getParameter("name"); 
    System.out.println(M_ID);
    InitialContext initialContext = new InitialContext();
            Context context = (Context) initialContext.lookup("java:comp/env");
            //The JDBC Data source that we just created
            DataSource ds = (DataSource) context.lookup("Randobase");
            Connection connection = ds.getConnection();

            if (connection == null)
            {
                throw new SQLException("Error establishing connection!");
                
            }
            
                   
statement=connection.createStatement();

String sql ="SELECT * FROM Module";

resultSet = statement.executeQuery(sql);
while(resultSet.next()){
%>

<center>
<h1>Update data from database in jsp</h1>
<form method="post" action="UpdateModule.jsp">
<input type="hidden" name="M_ID" value="<%=resultSet.getString("M_ID") %>">
<input type="text" name="M_ID" value="<%=resultSet.getString("M_ID") %>">
<br>
Module Nummer:<br>
<input type="text" name="M_Name" value="<%=resultSet.getString("M_Name") %>">
<br>
Module Title :<br>
<input type="text" name="M_Tittle" value="<%=resultSet.getString("M_Tittle") %>">
<br>
Modul Beskrivelse:<br>
<input type="text" name="M_Description" value="<%=resultSet.getString("M_Description") %>">
<br>
<input type="submit" value="submit">

<br>
</center>

</form>
</center>


<%
}
%>

 

</body>
