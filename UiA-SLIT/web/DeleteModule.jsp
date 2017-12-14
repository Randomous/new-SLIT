<%@page import="javax.naming.InitialContext"%>
pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*" %>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="javax.naming.Context"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.Connection"%>
<%@page import="javax.sql.DataSource"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Delete Data</title>
</head>
<body>
    

    
    
    <ul class="TextFormat">
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
    

String M_ID = request.getParameter("M_ID");

if(M_ID != null)
{
PreparedStatement ps = null;
int MID = Integer.parseInt(M_ID);
try
{
String sqls = "DELETE FROM LearningGoals WHERE M_ID="+M_ID;
String sql = "DELETE FROM Module WHERE M_ID="+MID;
ps = connection.prepareStatement(sql);
ps = connection.prepareStatement(sqls);
int i = ps.executeUpdate(sqls);
int s = ps.executeUpdate(sql);
if(i > 0)
{
out.print("Modulen har blitt slettet");
 
}
else if (s > 0)
{
out.print("Modulen har blitt slettet"); 
} 
else 
{
    out.println("ops, Det oppsto et problem.");
}
    
    }
catch(SQLException sqe)
{
request.setAttribute("error", sqe);
out.println(sqe);
}
}
%>
</ul>
<p>
        <center><form name="Go back" action="index.jsp">
                <input type="submit" value="Gå tilbake"/> </form></center>
</body>