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
                InitialContext initialContext = new InitialContext();
            Context context = (Context) initialContext.lookup("java:comp/env");
            //The JDBC Data source that we just created
            DataSource ds = (DataSource) context.lookup("Randobase");
            Connection connection = ds.getConnection();

            if (connection == null)
            {
                throw new SQLException("Error establishing connection!");
            }
           
         Statement st = connection.createStatement();
                
         String LearningGoalsTittle = request.getParameter("LearningGoalsTittle");
         String LearningGoalsDescription = request.getParameter("LearningGoalsDescription");
         String ModuleNumber = request.getParameter("ModuleNumber");
         

          //out.println ("insert into LearningGoals (LG_Tittle, LG_Description, M_ID)values('"+LearningGoalsTittle+"', '"+LearningGoalsDescription+"', '"+ModuleNumber+"')"); 
          st.executeUpdate("insert into LearningGoals (LG_Tittle, LG_Description, M_ID)values('"+LearningGoalsTittle+"', '"+LearningGoalsDescription+"', '"+ModuleNumber+"')"); 
          
        
          out.println ("Læringsmål har blitt lagt til modulen du har valgt");
          

       

            
           
        %>
        
        
        
          </ul>
   
             <p>
        <center><form name="Go back" action="index.jsp">
                <input type="submit" value="Gå tilbake"/> </form></center>
    </body>