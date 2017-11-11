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
    <title>Delivery Queue</title>
    <link rel="stylesheet" type="text/css" href="index.css">

    <script src="javascript.js" type="text/javascript"></script>
</head>
<body>
    <h1>Innleveringer
    </h1>
    <p id="listCount">

    </p>
    <br>
    <br>
    <a href="#">Velg fra listen av innleveringer</a>
    <ul id="queueList">
        <%
            InitialContext initialContext = new InitialContext();
            Context context = (Context) initialContext.lookup("java:comp/env");
            //The JDBC Data source that we just created
            DataSource ds = (DataSource) context.lookup("Randobase");
            Connection connection = ds.getConnection();

            if (connection == null) {
                throw new SQLException("Error establishing connection!");
            }
            
//            String query = "SELECT Users.UserID, Users.U_FirstName, Users.U_SurName, Module.M_Description, Module.M_ID, Module.M_Tittle, Deliverable.D_DeliverableStatus, Deliverable.D_ID, Deliverable.D_UploadDate FROM StoredData LEFT JOIN Users ON StoredData.UserID=Users.UserID LEFT JOIN Module ON StoredData.M_ID=Module.M_ID LEFT JOIN Deliverable ON StoredData.D_ID = Deliverable.D_ID WHERE D_DeliverableStatus = 0 ORDER BY D_UploadDate;";
            String query = "SELECT Users.UserID, Users.U_FirstName, Users.U_SurName, Module.M_Description, Module.M_ID, Module.M_Tittle, Deliverable.D_DeliverableStatus, Deliverable.D_ID, Deliverable.D_UploadDate, D_Text, D_YouTubeLink, D_GitHubLink FROM StoredData LEFT JOIN Users ON StoredData.UserID=Users.UserID LEFT JOIN Module ON StoredData.M_ID=Module.M_ID LEFT JOIN Deliverable ON StoredData.D_ID = Deliverable.D_ID WHERE D_DeliverableStatus = 0 ORDER BY D_UploadDate;";

            //String query = "SELECT * FROM Deliverable ORDER BY D_UploadDate";

            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {

                int id = rs.getInt("D_ID");
       
                String moduleName = rs.getString("M_Tittle");
                
                String uplDate = rs.getString("D_UploadDate");
                String userID = rs.getString("UserID");
                String firstname = rs.getString("U_FirstName");
                String surneame = rs.getString("U_SurName");
                String moduleDesc = rs.getString("M_Description");
                String moduleID = rs.getString("M_ID");
                String moduleTitle = rs.getString("M_Tittle");
                String delivStatus = rs.getString("D_DeliverableStatus");
                String delText = rs.getString("D_Text");
                String delYTLink = rs.getString("D_YouTubeLink");
                String delGitLink = rs.getString("D_GitHubLink");
                
                  String divID = String.valueOf(id);
        %>
        <li>
            <p> Innlevering på modul: <%= moduleName%></p>
            <div id=<%= divID %> , 
                 style="display:none">
                <form action="${pageContext.request.contextPath}/EditModule" method="post">
                    <p>
                        Her er informasjon om modulen: <%= moduleName%> 
                        <br>
                        Modul nummer <%= moduleID %>
                        <br>
                        Lastet opp <%= uplDate%>
                        LeveringsID: <%= id%>
                        <br>
                        Levert av: <%= firstname %> <%= surneame %>
                        <br>
                        Modul Tittel: <%= moduleTitle %>
                        <br>
                        Modul beskrivelse  
                        <br>
                        <%= moduleDesc %>
                        <br>
                        <!--<div id="ytplayer<%=id%>">-->
                       
                        <%
                            if(delYTLink != "NULL") {
                        %>
                        <!--<div id="ytplayer"></div>-->

                        <script type='text/javascript'> var ytID = youtubeID('<%=delYTLink%>'); 
                            
                        youtubePlayer(ytID,'vidTest');
//                            var div = document.getElementById("vidTest");
//                            // With old JS syntax
////                            div.id = "ytplayer" + new Date().getTime().toString();
////                            alert(div.id);
////                          ##Looking good but needs some int change
//                            var datestr = new Date().getTime().toString(), randomstr = Math.random().toString(); 
//                            var bigString = 'ytplayer' + datestr + randomstr;
//                            div.id = bigString;
////                            alert(div.id);
//                            var ytStand = "https://www.youtube.com/embed/";
//                            var newLink = ytStand + ytID;
//                               document.getElementById(div.id).src = newLink;
                               
                               
                               
                               
                            
//                            document.getElementById("ytplayer").id = div.id;
//                            alert(document.getElementById("ytplayer").id);
                        
//                          wait(5000);
                          // Replace the 'ytplayer' element with an <iframe> and
                          // YouTube player after the API code downloads.
//                          var player;
//                          (function () {
//                              alert(div.id);
//                            player = new YT.Player(div.id.toString(), {
//                              height: '360',
//                              width: '640',
//                              videoId: ytID
//                            });
//                          }());
                        </script>
                        <iframe id="vidTest" width="560" height="315" src="https://www.youtube.com/embed/" frameborder="0" allowfullscreen></iframe>
                            <!-- 1. The <iframe> (and video player) will replace this <div> tag. -->
                            
                        <!--</div>-->
                        <%
                            } else {
                        %>
                        <iframe width="560" height="315" src="https://www.youtube.com/embed/b-Cr0EWwaTk" frameborder="0" allowfullscreen></iframe>
                        <%
                            }
                            %>
                        
<!--                        <p id="vidLink<%=id%>">
                        <embed height="500" width="500" src="http://htmlpreview.github.io/?https://github.com/Randomous/new-SLIT/blob/master/README.md"/>
                        </p>
                    <p id="vidLink<%=id%>'text'">
                        
                    </p>-->
                    
                        
                    </p>
                    Kommentar til student <br> <input class="textboxLarge" type="text" name="Number" />
                    <br>
                    Intern kommentar (Ikke synlig for student) <br> <input class="textboxLarge" type="text" name="Goal" />
                    <br>
                    Godkjenner navn <input type="text" name="Name" placeholder="HER BLIR USER STAPPET INN UTEN TEKST FELT"/>
                    <br>
                    Antall poeng <input type="number" name="Points" min="0" step="1"/>
                    <br>
                    <input type="Submit" name="AddStudent" value="Bekreft Endering" />

                    
                    <!--<script type='text/javascript'> youtubeEmbed('vidLink<%=id%>', 'vidLink<%=id%>text'); </script>-->
                </form>
                <br>
                <button onclick="asd(2, '<%= divID%>')">Avbryt Endring</button>
            </div>
            <%
                String hideID = "hide" + divID;
            %>

            <button id=<%=hideID%> , onclick="asd(1, '<%= divID%>')"> Gå til evaluering </button>
        </li>
        <%
            }
        %>

    </ul>
    <script type='text/javascript'> listSize("queueList");</script>
<center><form name="Go back" action="index.jsp">
        <input type="submit" value="Gå tilbake"/> </form></center>
</body>

