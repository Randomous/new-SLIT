
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
        <jsp:include page="UserInfo.jsp" />
        <title>JSP Page</title>
    </head>
   <body>
       <h1 class="TextFormat"> Resultat</h1>
        <br>
        
       <ul class="TextFormat">
           
            <h2 class="header">UiA-SLIT for <% out.println(request.getSession().getAttribute("role")); %></h2>
    </div>
            <div id="rolecheck">
                <p>
Logget inn som <%=request.getSession().getAttribute("userName") %>
<br>
Med rolle: <% out.println(request.getSession().getAttribute("role")); %>
<br>
Og brukerID <% out.println(request.getSession().getAttribute("userID")); %>
<br>
<a id="logout" href="<%=request.getContextPath()%>/LogoutServlet">Logout</a>
                </p>
            </div>
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
                
         String ModulText = request.getParameter("D_Text");         
         String YoutubeLink = request.getParameter("D_YouTubeLink");
         String GithubLink = request.getParameter("D_GitHubLink");
         String UploadDate = request.getParameter("D_UploadDate");
         //String LearningGoalsTittle = request.getParameter("LearningGoalsTittle");
         //String LearningGoalsDescription = request.getParameter("LearningGoalsDescription");
       
            //out.println ("insert into Module (M_ID, M_Name, M_Tittle, M_Description)values('"+ModuleID+",'"+ModuleName+"','"+Tittle+"','"+Description+"')");    
          
          st.executeUpdate("insert into Deliverable (D_Text, D_YouTubeLink, D_GitHubLink,D_UploadDate)values('"+ModulText+"','"+YoutubeLink+"','"+GithubLink+"','"+UploadDate+"')");
          

                  
           
        %>
   
        <%  
         Statement td = connection.createStatement();
            
         String UserID = request.getParameter("UserID");         
         String ModuleID = request.getParameter("M_ID");
         String DeliveryID = request.getParameter("D_ID");
         String LearningGoalsID = request.getParameter("LG_ID");
        
         td.executeUpdate("insert into StoredData (UserID, M_ID, D_ID, LG_ID)values('"+UserID+"','"+ModuleID+"','"+DeliveryID+"','"+LearningGoalsID+"')");
          
         out.println("Innleveringen har blitt lagret i systemet");
        %>
      
       </ul>
   
             <p>
        <center><form name="Go back" action="index.jsp">
                <input type="submit" value="Gå tilbake"/> </form></center>
    </body>