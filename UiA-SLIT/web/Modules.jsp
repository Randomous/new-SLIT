<%-- 
    Document   : Modules
    Created on : 27.okt.2017, 13:53:30
    Author     : Helll
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

<HTML>
    <head>        
         <link rel="stylesheet" type="text/css" href="index.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <jsp:include page="UserInfo.jsp" />
          <title>UiA-SLIT</title>
    </head>
  
       
   <body>
         
        <h1 class="TextFormat"><center>Alle moduler</center></h1>
        
        <div id="Textaline">
        <br>
     <%   
     
      
       
        Connection con= null;
        Statement statement = null;
        ResultSet resultSet = null;
        
           
        %>
        <center>
            <TABLE class="ModuleTable">
            <TR>    <br>
                <br>
                <TH><font size="4"</font>ID</TH>
                <TH><font size="4"</font>Navn</TH>
                <TH><font size="4"</font>Tittel</TH>
                <TH><font size="4"</font>Forklaring</TH>
                
                
                                      <% //Sjekker om rollen er lærer, hvis den er kjøres koden for vurderingsknapper   
        // Lager variabel for senere kall i kode
        
        String sesRole = request.getSession().getAttribute("role").toString();
                String checkRole = "Lærer";                
                String checkRoleTA = "Hjelpelærer";
                String checkRoleST = "Student"; 
            if( checkRole.equals(sesRole) || checkRoleTA.equals(sesRole)) { 
        %>
                  <TH><font size="4"</font>Modul</TH>
                  <TH><font size="4"</font>Læringsmål</TH>
              
        
        <% } 

            if(checkRoleST.equals(sesRole)) { 
              %>
          
                  <TH><font size="4"</font>Innlevering</TH>
           <% } 
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
             String sql ="select * from Module";
             resultSet = statement.executeQuery(sql);
             while(resultSet.next()){
     
             String M_ID = resultSet.getString("M_ID");
             session.setAttribute("M_ID", M_ID);
                
            %>
            
            
            
            <tr> 
              <TD>  <%= M_ID %></TD>
              <TD>  <%= resultSet.getString("M_Name") %></TD>
              <TD>  <%= resultSet.getString("M_Tittle") %></TD>
              <TD>  <%= resultSet.getString("M_Description")%></TD>
              
                               <% //Sjekker om rollen er lærer, hvis den er kjøres koden for vurderingsknapper   
        // Lager variabel for senere kall i kode
        
      
            if( checkRole.equals(sesRole) || checkRoleTA.equals(sesRole)) { 
System.out.println(M_ID);
        %>


                  
              <TD> <form name="<%= M_ID%>" action="Update.jsp" />
                  <input class="moduleBtn" type="submit" value="Endre" /> </form> </TD>
                   <TD> <form name="<%= M_ID%>" action="module.jsp" />
                  <input class="moduleBtn" type="submit" value="Endre" /> </form> </TD>
                    
                  <% 
                                     
             }
            if(checkRoleST.equals(sesRole)) { 
           System.out.println(M_ID);
              %>
              
             <input type=hidden id="modulenumber" name="<%= M_ID%>">
               <TD> <form name="<%= M_ID%>" action="DeliveryModule.jsp" />
                  <input class="moduleBtn" type="submit" value="Innlevering" /> </form> </TD>
            </TR>
           
            
           <%
               }
               }   
               %>
             </table>    
         System.out.println(M_ID);
        </center>
      
    </body>
</HTML>