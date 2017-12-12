<%-- 
    Document   : index
    Created on : Oct 25, 2017, 1:45:21 PM
    Author     : root
--%>
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


<ul>
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
       
https://stackoverflow.com/questions/3797285/how-can-i-pass-a-parameter-via-submit-button
Can be applied to get specific module
*/
resultSet = statement.executeQuery(sql);
while(resultSet.next()){
%>

<!DOCTYPE html>
<html>
<body>
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
<%
}
%>
</ul>
 

</body>
</html>
