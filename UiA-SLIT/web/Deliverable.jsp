<%-- 
    Document   : Modules
    Created on : 27.okt.2017, 13:53:30
    Author     : Helll
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
        <jsp:include page="Teacher.jsp" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
            String query = "SELECT * FROM Deliverable ORDER BY D_ID";

            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet rs = statement.executeQuery("select * from Deliverable");
            
            %>
            <center>
            
            <TABLE BORDER="1">
            <TR>
                <TH><font size="4"</font>ID</TH>
                <TH><font size="4"</font>Module Navn</TH>
                <TH><font size="4"</font>Status:</TH>
                <TH><font size="4"</font>Godkjent av</TH>
               
            </TR>
            
            <%
            while (rs.next()){ %>
            
            <tr> 
              <TD>  <%= rs.getInt("D_ID") %></TD>
              <TD>  <%= rs.getString("D_ModuleName")%></TD>
              <TD>  <%= rs.getString("D_DeliverableStatus")%></TD>
              <TD>  <%= rs.getString("D_RatedBy")%></TD>
              <TD>   
                 
                </tr>   
               
           <% } %>
             </table>    
        
        </center>

          
             <p>
                 </div>
        <center><form name="Go back" action="index.jsp">
                <input type="submit" value="Gå tilbake"/> </form></center>
    </p>
    </body>