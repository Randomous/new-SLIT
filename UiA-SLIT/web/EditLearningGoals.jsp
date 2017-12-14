<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="java.sql.*" %>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="javax.naming.Context"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.Connection"%>
<%@page import="javax.sql.DataSource"%>
<%@page import="javax.naming.InitialContext"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<center>
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
    
String LG_ID = request.getParameter("LG_ID");
String LG_Tittle=request.getParameter("LG_Tittle");
String LG_Description=request.getParameter("LG_Description");

if(LG_ID != null)
{

PreparedStatement ps = null;
int LearningGoalID = Integer.parseInt(LG_ID);

String sql="Update LearningGoals set LG_ID=?,LG_Tittle=?,LG_Description=? where LG_ID="+LG_ID;
ps = connection.prepareStatement(sql);
ps.setString(1,LG_ID);
ps.setString(2, LG_Tittle);
ps.setString(3, LG_Description);
int i = ps.executeUpdate();
if(i > 0)
{
out.print("Record Updated Successfully");
}
else
{
out.print("There is a problem in updating Record.");
}
}
%>

</center>
<c:redirect url="Modules.jsp"/>


