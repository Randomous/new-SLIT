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
    String LG_ID = request.getParameter("name"); 
    System.out.println(LG_ID);
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

String sql ="SELECT * FROM LearningGoals";
       
resultSet = statement.executeQuery(sql);
while(resultSet.next()){
%>

<!DOCTYPE html>
<html>
<body>
<center>
<h1>Update data from database in jsp</h1>
<form method="post" action="EditLearningGoals.jsp">
<input type="hidden" name="LG_ID" value="<%=resultSet.getString("LG_ID") %>">
<input type="text" name="LG_ID" value="<%=resultSet.getString("LG_ID") %>">
<br>
LearningGoal Tittle:<br>
<input type="text" name="LG_Tittle" value="<%=resultSet.getString("LG_Tittle") %>">
<br>
LearningGoal Description:<br>
<input type="text" name="LG_Description" value="<%=resultSet.getString("LG_Description") %>">
<br>
<input type="submit" value="submit">
<br>
<TD> <form method="post" action="UpdateLearningGoals.jsp" />
 <input type="submit" value="Slett" /> </form> </TD>
</center>
</form>
<%
}
%>
</ul>
 

</body>
</html>
