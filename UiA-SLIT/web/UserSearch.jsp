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
        <title>JSP Page</title>
    </head>
   <body>
       <h1 class="TextFormat"> Resultat</h1>
        <br>
         <a href="#">Flere treff, velg en student</a>
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
            String user = request.getParameter("name");
            String query = "SELECT * FROM Users WHERE U_FirstName LIKE '%" 
                    + user + "%'" + "ORDER BY U_FirstName, U_SurName";

            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet rs = statement.executeQuery();
      
           
            if (rs.isBeforeFirst() && rs.next() && rs.isFirst() && rs.isLast()) {
                 // Logic for where there's exactly 1 row
                    out.println(rs.getInt("UserID") + ("&nbsp;&nbsp;&nbsp;&nbsp"));
                out.println(rs.getString("U_FirstName") + ("&nbsp;&nbsp;&nbsp;&nbsp"));
                out.println(rs.getString("U_SurName") + ("&nbsp;&nbsp;&nbsp;&nbsp"));
                out.println(rs.getString("U_Email"));
                // TODO Her må mer inn
                out.println("PLCACEHOLDER her stapper vi inn modul info og slikt når det er på plass");

             } else if (!rs.next() ) {
                out.println("Fant ingen med det navnet, prøv igjen");
            }
            
            else do {
                      out.println(rs.getInt("UserID") + ("&nbsp;&nbsp;&nbsp;&nbsp"));
                out.println(rs.getString("U_FirstName") + ("&nbsp;&nbsp;&nbsp;&nbsp"));
                out.println(rs.getString("U_SurName") + ("&nbsp;&nbsp;&nbsp;&nbsp"));
                out.println(rs.getString("U_Email"));
//                out.println("<a href='Modules.jsp>" + rs.getInt("UserID"));
                out.println("<li><a href='Modules.jsp'> 'Gå til bruker " + rs.getInt("UserID") + "</a></li>");
                out.println("<br>");
                 } while (rs.next());
            
           
        %>
   
      
       </ul>
   
             <p>
        <center><form name="Go back" action="index.jsp">
                <input type="submit" value="Gå tilbake"/> </form></center>
    </body>

