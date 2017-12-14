<%-- 
    Document   : UserDetails
    Created on : Dec 13, 2017, 2:22:33 PM
    Author     : root
--%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
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
        <jsp:include page="UserInfo.jsp" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="userDetailscontainer">
            <ul>
                 <%   
     
      
       
        Connection con = null;
        Statement statement = null;
        Statement statement2 = null;
               
           
        %>
            
                                                  <% //Sjekker om rollen er lærer, hvis den er kjøres koden for vurderingsknapper   
        // Lager variabel for senere kall i kode
        
        String sesRole = request.getSession().getAttribute("role").toString();
                String checkRole = "Lærer";                
                String checkRoleTA = "Hjelpelærer";
            if( checkRole.equals(sesRole) || checkRoleTA.equals(sesRole)) { 
        %>
            
        <%  }
            InitialContext initialContext = new InitialContext();
            Context context = (Context) initialContext.lookup("java:comp/env");
            //The JDBC Data source that we just created
            DataSource ds = (DataSource) context.lookup("Randobase");
            Connection connection = ds.getConnection(); 
            
               
            if (connection == null)
            {
                throw new SQLException("Error establishing connection!");
            }
             String uID = request.getParameter("UserID");
             statement = connection.createStatement();
             String rsU = "SELECT * FROM Users WHERE UserID=" + uID;
             ResultSet rsU_ID = statement.executeQuery(rsU);
             
             
             
            %>
                       <h1 class="UserDetails">Brukerinformasjon</h1>
             <TABLE class="ModuleTable">
            <TR>
                <TH><font size="4"</font>BrukerID</TH>
                <TH><font size="4"</font>Fornavn</TH>
                <TH><font size="4"</font>Etternavn</TH>
                <TH><font size="4"</font>Epost</TH>
              </TR>
            
           <% while(rsU_ID.next()){  %>
    
           <tr> 
              <TD>  <%= rsU_ID.getInt("UserID") %></TD>
              <TD>  <%= rsU_ID.getString("U_FirstName") %></TD>
              <TD>  <%= rsU_ID.getString("U_SurName") %></TD>
              <TD>  <%= rsU_ID.getString("U_Email")%></TD>
                </tr>   
            
               <% } %>             
               </table>
       
           <%
               Connection connection2 = ds.getConnection(); 
            
               
            if (connection == null)
            {
                throw new SQLException("Error establishing connection!");
            }
             statement2 = connection2.createStatement();
             String rsD = "SELECT * FROM StoredData INNER JOIN Deliverable ON StoredData.D_ID = Deliverable.D_ID WHERE StoredData.UserID=" + uID;
             ResultSet rsD_ID = statement2.executeQuery(rsD);
             
               %>
              
            <h1 class="UserDetails">Innleveringer</h1>
             <TABLE class="ModuleTable">
            <TR>
                <TH><font size="4"</font>Leveringsnummer</TH>
                <TH><font size="4"</font>Modul</TH>
                <TH><font size="4"</font>Status</TH>
                <TH><font size="4"</font>Rettet av</TH>
                <TH><font size="4"</font>Gå til</TH>
              </TR>     
               <% while(rsD_ID.next()){  
               
               %>
            <tr> 
              <TD> <%= rsD_ID.getInt("D_ID") %></TD>
              <TD> <%= rsD_ID.getString("D_ModuleName")%></TD>
              <TD> <%= rsD_ID.getString("D_DeliverableStatus")%></TD>
              <TD> <%= rsD_ID.getString("D_RatedBy")%></TD>  
              <TD><form action="ShowDelivery.jsp" /> 
                  <input type ="hidden" name="UserID" value="<%= rsD_ID.getInt("D_ID")%>"/>
              <input type="submit" value="Gå til" /></form></TD>
                </tr> 
             <% } %>
            </table>
            </ul>
        </div>
    </body>
</html>
