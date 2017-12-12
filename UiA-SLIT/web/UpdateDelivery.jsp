<%-- 
    Document   : UpdateDelivery
    Created on : Dec 12, 2017, 11:05:20 PM
    Author     : root
--%>
<%@page import="java.util.Arrays"%>
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
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>

  
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
    
        String moduleID = request.getParameter("moduleID");
        String deliveryID =request.getParameter("deliveryID");
        String userID =request.getParameter("userID");
        String asignedPoints = request.getParameter("pointList");
        System.out.println(asignedPoints);
        //String str = Arrays.toString(asignedPoints);


        if(deliveryID != null)
        {

        PreparedStatement ps = null;
        int user = Integer.parseInt(userID);
        System.out.println(Integer.parseInt(userID));
        int module = Integer.parseInt(moduleID);
        System.out.println(Integer.parseInt(moduleID));
        int points = Integer.parseInt(asignedPoints);
        System.out.println(Integer.parseInt(asignedPoints));
        int delivery = Integer.parseInt(deliveryID);
        System.out.println(Integer.parseInt(deliveryID));
        int approved = 0;
        if (points != 0) {
            approved = 1;
        }
        String rater = request.getSession().getAttribute("userName").toString();

        //String sql="UPDATE Deliverable SET D_Points=" + points + ",D_DeliverableStatus=" + approved +",D_RatedBy=" + rater + "WHERE D_ID=" + delivery;

        String sql="UPDATE Deliverable SET D_Points=?,D_DeliverableStatus=?,D_RatedBy=?WHERE D_ID=" + delivery;
        ps = connection.prepareStatement(sql);
        ps.setInt(1,points);
        ps.setInt(2, approved);
        ps.setString(3, rater);
        int i = ps.executeUpdate();
        if(i > 0)
        {
        out.print("Record Updated Successfully");
        %>
             <script>
//       window.onload="setTimeout(function() {alert('hello');},1250);">;
            var id = "<%=delivery%>";
        alert("Endringen på levering nummer " + id + " var vellykket");

</script>
        <%
        }
        else
        {
        out.print("There is a problem in updating Record.");
%>
<script>
//       window.onload="setTimeout(function() {alert('hello');},1250);">;
            var id = "<%=delivery%>";
        alert("Endringen på levering nummer " + id + " feilet");

</script>
<%
        }
        }
        %>

</center>
     
<%--<c:redirect url="deliveryQueue.jsp"/>--%>
    <meta http-equiv="Refresh" content="1;url=deliveryQueue.jsp">
    </body>
</html>
