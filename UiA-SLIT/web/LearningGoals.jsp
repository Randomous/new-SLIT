<%-- 
    Document   : LearningGoals
    Created on : Nov 9, 2017, 11:14:30 AM
    Author     : Daniel
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
        <title>LearningGoals</title>
    </head>
   <body>
       <h1> Resultat</h1>
        <br>
        
       <ul>
           <%
          //  try {
            //    Class.forName("com.mysql.jdbc.Driver");
              //  Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/randobase", "randmin", "555666");
                //Statement st = con.createStatement();
                
         //String LearningGoalsTittle = request.getParameter("Number");
         //String LearningGoalsDescription = request.getParameter("Name");
         //String ModuleNumber = request.getParameter("LearningGoals");
         

          //out.println ("insert into LearningGoals (LG_Tittle, LG_Description, M_ID)values('"+LearningGoalsTittle+"', '"+LearningGoalsDescription+"', '"+ModuleNumber+"')"); 
          //st.executeUpdate("insert into LearningGoals (LG_Tittle, LG_Description, M_ID)values('"+LearningGoalsTittle+"', '"+LearningGoalsDescription+"', '"+ModuleNumber+"')");
         // st.executeUpdate("insert into Module (M_Name, M_Tittle, M_Description)values('"+Number+"', '"+Name+"','"+Tittle+"','"+Description+"')");
          
        
          //out.println ("Læringsmål har blitt lagt til modulen du har valgt");
          

         //} catch (Exception e){
           //out.println (e);
         //}


            
           
        %>
        
        
        
          </ul>
   
             <p>
        <center><form name="Go back" action="index.jsp">
                <input type="submit" value="Gå tilbake"/> </form></center>
    </body>