<%@page import="javax.naming.Context"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.Connection"%>
<%@page import="javax.sql.DataSource"%>
<%@page import="javax.naming.InitialContext"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <jsp:include page="UserInfo.jsp" />
        <title>Innelvering</title>
    </head>
    <body>
         <% 
           
             
             String moduleID = request.getParameter("modulenumber"); 
                    String moduleName = request.getParameter("moduleName");
                    
          InitialContext initialContext = new InitialContext();
            Context context = (Context) initialContext.lookup("java:comp/env");
            //The JDBC Data source that we just created
            DataSource ds = (DataSource) context.lookup("Randobase");
            Connection connection = ds.getConnection();

            if (connection == null) {
                throw new SQLException("Error establishing connection!");
            }

//            String query = "SELECT Users.UserID, Users.U_FirstName, Users.U_SurName, Module.M_Description, Module.M_ID, Module.M_Tittle, Deliverable.D_DeliverableStatus, Deliverable.D_ID, Deliverable.D_UploadDate FROM StoredData LEFT JOIN Users ON StoredData.UserID=Users.UserID LEFT JOIN Module ON StoredData.M_ID=Module.M_ID LEFT JOIN Deliverable ON StoredData.D_ID = Deliverable.D_ID WHERE D_DeliverableStatus = 0 ORDER BY D_UploadDate;";
            String query = "SELECT * FROM Module WHERE M_ID=" + moduleID;
                    //String query = "SELECT * FROM Deliverable ORDER BY D_UploadDate";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                String moduleTitle = rs.getString("M_Tittle");
                String moduleDesc = rs.getString("M_Description");

        
            




                    %>
                    
                <center>
                  
                <b>Modul informasjon <br> </b>
                Modul nummer: <%=moduleID %> <br>
                <br>
                <b>Modul navn:<br> </b>
                <%= moduleName%>
                <br>
                <b>Module Tittel :<br> </b>
                <%= moduleTitle %>
                <br>
                <b>Modul Beskrivelse:<br> </b>
                <%= moduleDesc%>
                <br>
<% }    String sql2 ="SELECT * FROM LearningGoals WHERE M_ID="+moduleID;
//         PreparedStatement pst = connection.prepareStatement(sql2); 
         
        String LG_Description; 
        PreparedStatement statement2 = connection.prepareStatement(sql2);
            ResultSet rs2 = statement2.executeQuery();

            while (rs2.next()) {
        
          LG_Description = rs2.getString ("LG_Tittle"); 
        
            %>
            <b>Læringsmål er: </b>
           <br>
           <%= LG_Description%>
           <% } %>
         

<br>
<br>
     

           
            <div>
                <form action="Delivery.jsp" method="post"> 
                    <b> Tekst til levering </b><br>
                    <!--Modul text <input type="text" name="D_Text"/>-->
                    <textarea rows="6" cols="75" name="D_Text"></textarea>

                    <br>
                    Youtube Link <input type="text" name="D_YouTubeLink"/>
                    <br>
                    Github Link <input type="text" name="D_GitHubLink"/>
                    <br>
<!--                    Upload date <input type="text" name="D_UploadDate"/> -->
                    <br> 
                   
                     <input type=hidden name ="modulenumber" value="<%=moduleID%>">
                      <input  type="hidden" name="moduleName" value="<%= moduleName %>">
                    <input type="Submit" name="AddDelivery" value="Lever Modul" />
                </form>
                <br>
            </div>
            <br>
        </center>
    <br>
   
     <center><form name="Go back" action="index.jsp">
                <input type="submit" value="Gå tilbake"/> </form></center>
    </body>
</html>
