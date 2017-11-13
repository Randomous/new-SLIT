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
        <jsp:include page="Teacher.jsp" />
        <title>JSP Page</title>
    </head>
  
       
   <body>
         
        <h1><center>Alle moduler</center></h1>
        
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
            <TABLE BORDER="1">
            <TR>
                <TH><font size="4"</font>ID</TH>
                <TH><font size="4"</font>Navn</TH>
                <TH><font size="4"</font>Tittel</TH>
                <TH><font size="4"</font>Forklaring</TH>
                
               
            </TR>
            
            <%
            while (rs.next()){ %>
            
            <tr> 
              <TD>  <%= rs.getInt("M_ID") %></TD>
              <TD>  <%= rs.getString("M_Name") %></TD>
              <TD>  <%= rs.getString("M_Tittle") %></TD>
              <TD>  <%= rs.getString("M_Description")%></TD>
              <TD>   
                  <br>
                      <a href='Update.jsp'> Gå til Modul</a>
                 
                </tr>   
               
           <% } %>
             </table>    
        
        </center>
             <p>
           
        <center><form name="Go back" action="index.jsp">
                <input type="submit" value="Gå tilbake"/> </form></center>
    </p>
    </body>
</HTML>
