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
    
 
        <title>UiA-SLIT</title>
       
    </head>
<jsp:include page="UserInfo.jsp" /> 
    <div class="wrapperofwrapper"> 
    <div class="wrapper">
 
    <body>
        <div id="title">
            <jsp:useBean id="mybean2" scope="session" class="WebInput.Input"/>
        </div>
        
        <div>
        <%
            InitialContext initialContext = new InitialContext();
            Context context = (Context) initialContext.lookup("java:comp/env");
            //The JDBC Data source that we just created
            DataSource ds = (DataSource) context.lookup("Randobase");
            Connection connection = ds.getConnection();

            if (connection == null) {
                throw new SQLException("Error establishing connection!");
            }
            String query = "SET @mycount = (SELECT COUNT(D_ID) FROM Deliverable WHERE D_DeliverableStatus=0); SELECT SUM(@mycount) AS Innleveringer;";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet rs = statement.executeQuery();
            
            while (rs.next()) {
                
            int ID = rs.getInt("Innleveringer"); 
        %>
        <p>Det er <%= ID%> i kø</p>
        <% } %>
        <div id="userSearch"> 
        <h2>Studentsøk</h2>
<!--    <center><form id="userform" name="loginForm" method="post" action="InputHandler">
            Brukernavn:</font> <input type="text" name="name"/> <br/>
        <input type="submit" name="Search" value="Søk" /></center>
    <br>
</form>-->
 

<form name="userSearch" method="post" action="UserSearch.jsp">
            Student navn</font> <input type="text" name="name"/>
        <input type="submit" name="Search" value="Søk" />
</form>
      </div>
    </div>
    </div>
 
</body>
 