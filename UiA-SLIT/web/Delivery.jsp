
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
                String moduleID = request.getParameter("modulenumber"); 
                
         String UserName = request.getSession().getAttribute("userName").toString(); 
         String role = request.getSession().getAttribute("role").toString();

         String ModulText = request.getParameter("D_Text");         
         String YoutubeLink = request.getParameter("D_YouTubeLink");
         String GithubLink = request.getParameter("D_GitHubLink");
         String UploadDate = request.getParameter("D_UploadDate");
        
         
         System.out.println(ModulText);
          System.out.println(YoutubeLink);
           System.out.println(GithubLink);
            System.out.println(UploadDate);
             
         
         st.executeUpdate("INSERT INTO Deliverable (D_Text, D_YouTubeLink, D_GitHubLink, D_UploadDate)VALUES('"+ModulText+"','"+YoutubeLink+"','"+GithubLink+"','"+UploadDate+"')");
          

                  
         String sql2 ="SELECT LG_ID FROM LearningGoals WHERE M_ID="+moduleID;
         PreparedStatement pst = connection.prepareStatement(sql2); 
         
        int learningGoalsID = 0; 
        Statement statement = connection.createStatement();    
        ResultSet lG = statement.executeQuery (sql2);
        while(lG.next()){
        
          learningGoalsID = lG.getInt ("LG_ID"); 
        }
        
        
        
         String getD_ID = "SELECT * FROM Deliverable ORDER BY D_ID DESC LIMIT 1";   
        PreparedStatement ptt = connection.prepareStatement(getD_ID); 
         
        int deliveryID = 0; 
        Statement statement2 = connection.createStatement();    
        ResultSet d_ID = statement2.executeQuery (getD_ID);
        while(d_ID.next()){
        
          deliveryID = d_ID.getInt ("D_ID"); 
        }
        
        
         String UserID = request.getSession().getAttribute("userID").toString();         
         String DeliverableID = request.getParameter("D_ID");
         
         
         System.out.println(UserID);
         System.out.println(moduleID);
         System.out.println(DeliverableID);
         System.out.println(learningGoalsID);
         
         int module = Integer.parseInt(moduleID);
         int User = Integer.parseInt(UserID);        
        
        
         
        
         String sql ="INSERT INTO StoredData (UserID=?, M_ID=?, D_ID=?, LG_ID=?)"; 
         PreparedStatement ps = connection.prepareStatement(sql);    
         ps.setInt(1, User);
         ps.setInt(2, module);
         ps.setInt(3, deliveryID);
         ps.setInt(4, learningGoalsID);
         
         
         
         ps.executeUpdate();
         
         out.println("Innleveringen har blitt lagret i systemet");
         
         
         
        %>
      
       
   
             <p>
        <center><form name="Go back" action="index.jsp">
                <input type="submit" value="Gå tilbake"/> </form></center>
   </body>