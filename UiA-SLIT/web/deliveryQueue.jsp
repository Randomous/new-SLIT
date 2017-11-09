<%-- 
    Document   : index
    Created on : Oct 25, 2017, 1:45:21 PM
    Author     : root
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
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Delivery Queue</title>
        <script src="javascript.js" type="text/javascript"></script>
    </head>
   <body>
       <h1>Innleveringer</h1>
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
            String query = "SELECT * FROM Deliverable ORDER BY D_UploadDate";

            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet rs = statement.executeQuery();
        
            while (rs.next()) {
               // out.println("<div id='approve'");
                out.println(rs.getInt("D_ID") + ("&nbsp;&nbsp;&nbsp;&nbsp"));
                out.println(rs.getString("D_EvaluationDate") + ("&nbsp;&nbsp;&nbsp;&nbsp"));
                out.println(rs.getString("D_ModuleName") + ("&nbsp;&nbsp;&nbsp;&nbsp"));
                out.println(rs.getString("D_RatedBy"));
                out.println(rs.getString("D_UploadDate"));
                out.println("<div>");
                out.println("<script src='buttons.html'></sript>");
                out.println("</div>");
               /* out.println("<div id='editModule' style='display:none'>");
                out.println("<button>Godkjenn</button>");
                out.println("<button>Avvis</button>");
                out.println("<button onclick='asd(2, 'editModule')'>Avbryt Endring</button>");
                out.println("</div>");
                out.println("<button id='hideeditModule' onclick='asd(1, 'editModule')'>Rediger</button>");*/
         
                
            }
           
        %>

        <center><form name="Go back" action="index.jsp">
                <input type="submit" value="Gå tilbake"/> </form></center>
    </body>

