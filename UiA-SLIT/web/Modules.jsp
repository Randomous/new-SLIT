<%-- 
    Document   : Modules
    Created on : 27.okt.2017, 13:53:30
    Author     : Helll
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

<HTML>
    <head>        
         <link rel="stylesheet" type="text/css" href="index.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <jsp:include page="UserInfo.jsp" />
        <title>JSP Page</title>
    </head>
  
       
   <body>
         
        <h1 class="TextFormat"><center>Alle moduler</center></h1>
        
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
            ResultSet rs = statement.executeQuery("select * from Module");
           
            %>
            <center>
            <TABLE class="ModuleTable">
            <TR>
                <TH><font size="4"</font>ID</TH>
                <TH><font size="4"</font>Navn</TH>
                <TH><font size="4"</font>Tittel</TH>
                <TH><font size="4"</font>Forklaring</TH>
                <TH><font size="4"</font>Modul</TH>
                <TH><font size="4"</font>Læringsmål</TH>
        
                
               
            </TR>
            
            <%
            while (rs.next()){ 
             String M_ID = String.valueOf(rs.getInt("M_ID"));
            %>
            
            <tr> 
              <TD>  <%= M_ID %></TD>
              <TD>  <%= rs.getString("M_Name") %></TD>
              <TD>  <%= rs.getString("M_Tittle") %></TD>
              <TD>  <%= rs.getString("M_Description")%></TD>
              
              <TD> <form name="ChangeModule" action="module.jsp" value='<%= M_ID%>'>
                <input type="submit" value="Rediger" /> </form>
                <TD>  <form name="<%= M_ID%>" action="ChangeLearningGoals.jsp" />
                <input type="submit" value="Endre" /> </form>
                  
                 
                </tr>   
               
           <% } %>
             </table>    
        
        </center>
             <p>
           
        <center><form name="Go back" action="index.jsp">
                <input type="submit" value="Gå tilbake" onclick="history.back()"/> </form></center>
    </p>
    </body>
</HTML>
