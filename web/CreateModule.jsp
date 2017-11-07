<%-- 
    Document   : index
    Created on : Oct 25, 2017, 1:45:21 PM
    Author     : root
--%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
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
        <title>JSP Page</title>
    </head>
   <body>
       <h1> Resultat</h1>
        <br>
        
       <ul>
           <%
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/randobase", "randmin", "555666");
                Statement st = con.createStatement();
         String ModuleNumber = request.getParameter("ModuleNumber");         
         String ModuleName = request.getParameter("ModuleName");
         String Tittle = request.getParameter("Tittle");
         String Description = request.getParameter("Description");
         String LearningGoalsTittle = request.getParameter("LearningGoalsTittle");
         String LearningGoalsDescription = request.getParameter("LearningGoalsDescription");
       
            //out.println ("insert into Module (M_ID, M_Name, M_Tittle, M_Description)values('"+ModuleID+",'"+ModuleName+"','"+Tittle+"','"+Description+"')");    
          
          st.executeUpdate("insert into Module (M_ID, M_Name, M_Tittle, M_Description)values('"+ModuleNumber+"', '"+ModuleName+"','"+Tittle+"','"+Description+"')");
          

          out.println("modulen har blitt lagret i systemet");
           

         } catch (Exception e){
           out.println (e);
         }


            
           
        %>
   
      
       </ul>
   
             <p>
        <center><form name="Go back" action="index.jsp">
                <input type="submit" value="Gå tilbake"/> </form></center>
    </body>

