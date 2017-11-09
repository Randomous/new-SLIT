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
//                out.println(rs.getInt("D_ID") + ("&nbsp;&nbsp;&nbsp;&nbsp"));
//                out.println(rs.getString("D_EvaluationDate") + ("&nbsp;&nbsp;&nbsp;&nbsp"));
//                out.println(rs.getString("D_ModuleName") + ("&nbsp;&nbsp;&nbsp;&nbsp"));
//                out.println(rs.getString("D_RatedBy"));
//                out.println(rs.getString("D_UploadDate"));
                int id = rs.getInt("D_ID");
                String evalDate = rs.getString("D_EvaluationDate");
                String moduleName = rs.getString("D_ModuleName");
                String ratedBy = rs.getString("D_RatedBy");
                String uplDate = rs.getString("D_UploadDate");
            
        %>
              <h2>Innlevering på modul </h2><p>(<%= moduleName %>)</p>
                <div id="editModule" style="display:none">
            <form action="${pageContext.request.contextPath}/EditModule" method="post">
                <p>
                    Her er informasjon om modulen: <%= evalDate %>
                    Lastet opp <%= uplDate %>
                    Ansvarlig <%= ratedBy %>
                    LeveringsID: <%= id %>
                </p>
                Godkjenner navn <input type="text" name="Name" />
                Kommentar til student<input type="text" name="Number" />
                <br>
                Intern kommentar (Ikke synlig for student <input type="text" name="Goal" />
                Antall poeng <input type="number" name="Points" min="0" step="1"/>
                <br>
                <input type="Submit" name="AddStudent" value="Bekreft Endering" />

            </form>
            <br>
            <button onclick="asd(2, 'editModule')">Avbryt Endring</button>
        </div>

        <button id="hideeditModule" onclick="asd(1, 'editModule')">Godkjenn modul</button>
        <%
        }
        %>
      

        <center><form name="Go back" action="index.jsp">
                <input type="submit" value="Gå tilbake"/> </form></center>
    </body>

