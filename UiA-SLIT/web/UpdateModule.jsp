
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

<head>
         <link rel="stylesheet" type="text/css" href="index.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
   <body>
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
try
{    

String sql="Update Module set M_ID=?, M_Name=?, M_Tittle=?, M_Description=? where M_ID="+M_ID;
ps = connection.prepareStatement(sql);
ps.setString(1, M_ID);
ps.setString(2, M_Name);
ps.setString(3, M_Tittle);
ps.setString(4, M_Description);


int i=ps.executeUpdate();
if(i > 0)
{
out.print("Record Updated Successfully");
}
else
{
out.print("There is a problem in updating Record.");
}
}

catch(SQLException sql)
{

request.setAttribute("error", sql);
out.println(sql);
}
}

%> 
        </center>
       </ul>
   </div>
             <p>
        <center><form name="Go back" action="index.jsp">
                <input type="submit" value="Gå tilbake"/> </form></center>
    </body>