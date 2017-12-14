
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
     <jsp:useBean id="ModuleID" class="Delivery.Bean.DeliveryBean" />
       Message is: <jsp:getProperty name="ModuleID" property="M_ID" /> 
       <body>
       <h1 class="TextFormat"> Resultat</h1>
        <br>
        
      <
            <h2 class="header">UiA-SLIT for <% out.println(request.getSession().getAttribute("role")); %></h2>
    
            <div id="rolecheck">
                <p>

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
               
                
         String UserName = request.getSession().getAttribute("userName").toString(); 
         String role = request.getSession().getAttribute("role").toString();
         String brukerID = request.getSession().getAttribute("userID").toString();
         String ModulText = request.getParameter("D_Text");         
         String YoutubeLink = request.getParameter("D_YouTubeLink");
         String GithubLink = request.getParameter("D_GitHubLink");
         String UploadDate = request.getParameter("D_UploadDate");
         String Comments = request.getParameter("D_CommentStudent");
         
         System.out.println(ModulText);
          System.out.println(YoutubeLink);
           System.out.println(GithubLink);
            System.out.println(UploadDate);
             System.out.println(Comments);
         //String LearningGoalsTittle = request.getParameter("LearningGoalsTittle");
         //String LearningGoalsDescription = request.getParameter("LearningGoalsDescription");
       
            //out.println ("insert into Module (M_ID, M_Name, M_Tittle, M_Description)values('"+ModuleID+",'"+ModuleName+"','"+Tittle+"','"+Description+"')");    
          
         // st.executeUpdate("INSERT INTO Deliverable (D_Text, D_YouTubeLink, D_GitHubLink, D_UploadDate, D_CommentStudent)VALUES('"+ModulText+"','"+YoutubeLink+"','"+GithubLink+"','"+UploadDate+"','"+Comments+"')");
          

                  
           
        %>
        
        
        
        <%  
        
        //ModuleID M_ID <jsp:getProperty name="ModuleID" property="M_ID"/>
         String UserID = request.getParameter("UserID");         
         String ModuleID = request.getParameter("M_ID");
         String DeliverableID = request.getParameter("D_ID");
         String LearningGoalsID = request.getParameter("LG_ID");
         
         System.out.println(UserID);
         System.out.println(ModuleID);
         System.out.println(DeliverableID);
         System.out.println(LearningGoalsID);
         
         int User = Integer.parseInt(UserID);
         int Module = Integer.parseInt(ModuleID);
         int Deliverable = Integer.parseInt(DeliverableID);
         int LearningGoals = Integer.parseInt(LearningGoalsID);
         
        
         String sql ="INSERT INTO StoredData (UserID=?, M_ID=?, D_ID=?, LG_ID=?"; 
         PreparedStatement ps = connection.prepareStatement(sql);    
         ps.setInt(1, User);
         ps.setInt(2, Module);
         ps.setInt(3, Deliverable);
         ps.setInt(4, LearningGoals);
         
         
         
         ps.executeUpdate();
         
         out.println("Innleveringen har blitt lagret i systemet");
        %>
      
       
   
             <p>
        <center><form name="Go back" action="index.jsp">
                <input type="submit" value="Gå tilbake"/> </form></center>
   </body>