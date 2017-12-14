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
    
String M_ID = request.getParameter("M_ID");
String M_Name=request.getParameter("M_Name");
String M_Tittle=request.getParameter("M_Tittle");
String M_Description=request.getParameter("M_Description");
if(M_ID != null)
{

PreparedStatement ps = null;
int ModuleID = Integer.parseInt(M_ID);

String sql="Update Module set M_ID=?,M_Name=?,M_Tittle=?,M_Description=? where M_ID="+M_ID;
ps = connection.prepareStatement(sql);
ps.setString(1,M_ID);
ps.setString(2, M_Name);
ps.setString(3, M_Tittle);
ps.setString(4, M_Description);
int i = ps.executeUpdate();
if(i > 0)
{
out.print("Modulen ble Oppdatert");
}
else
{
out.print("Det oppsto et problem, prøv igjen senere");
}
}
%>

</center>
<c:redirect url="Modules.jsp"/>


