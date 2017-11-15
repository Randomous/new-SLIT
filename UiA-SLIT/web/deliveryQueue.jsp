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
    <jsp:include page="UserInfo.jsp" />
    <title>Delivery Queue</title>
    <link rel="stylesheet" type="text/css" href="index.css">

    <!--     <script src="JS/Repo.js-master/repo.min.js" </script>-->


</head>
<body>
    <div id="Textaline">
    <h1 class="TextFormat">Innleveringer
    </h1>
            
    <p id="listCount">

    </p>
    <br>
    <br>
    <% //Sjekker om rollen er lærer, hvis den er kjøres koden for vurderingsknapper   
        // Lager variabel for senere kall i kode
        
        String sesRole = request.getSession().getAttribute("role").toString();
                String checkRole = "Lærer";                
                String checkRoleTA = "Hjelpelærer";
            if( checkRole.equals(sesRole) || checkRoleTA.equals(sesRole)) { 
        %>
    <a>Velg fra listen av innleveringer</a>
    <br>
     Gå gjennom listen fra topp til bunn for rettferdig behandling. <br>
     <% } %>
    <p>
        Køen er sortert etter leveringstidspunkt. Øverste levering er første levering.
        <br>
       
    </p>


    <ul id="queueList1">
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
            <p><b> Innlevering på modul: <%= moduleName%> av student <%= firstname%>&nbsp; <%= surneame%></b></p>
            
            <%  //Sjekker om rollen er lærer, hvis den er kjøres koden for vurderingsknapper     
            if( checkRole.equals(sesRole) || checkRoleTA.equals(sesRole)) { 
                %>
            <div id=<%= divID%> , 
                 style="display:none">
                <form action="${pageContext.request.contextPath}/EditModule" method="post">
                    <p>
                        Her er informasjon om modulen: <%= moduleName%> 
                        <br>
                        Modul nummer <%= moduleID%>
                        <br>
                        Lastet opp <%= uplDate%>
                        LeveringsID: <%= id%>
                        <br>
                        Levert av: <%= firstname%>&nbsp; <%= surneame%>
                        <br>
                        Med studentID: <%= userID%>
                        <br>
                        Modul Tittel: <%= moduleTitle%>
                        <br>
                        Modul beskrivelse  
                        <br>
                        <%= moduleDesc%>
                        <br>
                        <%
                        // TODO implement learning goals in query and storedData
                                %>
                                PLACEHOLDER: Læringsmål
                        <br>

                    <h3> Studentens innhold i innleveringen er
                    </h3>
                    <br>
                    Tekst:  <%= delText%>
                    <br>
                    <%
                        if (delGitLink != "NULL") {
                    %>
                    GitHub repo link:
                    <a id ="repo1" target="_blank"> Studentens repo</a>
                    <script>
                        var repoID = idSetter('repo1');
                        setGitLink(repoID, '<%=delGitLink%>');
//                     setRepo(repoID);
                    </script>

                    <br>
                    <%
                    } else {
                    %>
                    GitHub repo mangler
                    <%}
                    %>
                    <%
                        if (delYTLink != "NULL") {
                    %>
                    Studenten har lastet opp følgende YouTube video
                    <br>

                    <script type='text/javascript'> var ytID = youtubeID('<%=delYTLink%>');

                        youtubePlayer(ytID, 'vidTest');
//                         
                    </script>
                    <iframe id="vidTest" width="560" height="315" src="https://www.youtube.com/embed/" frameborder="0" allowfullscreen></iframe>
                        <%
                        } else {
                        %>
                    Ingen youtube video lastet opp
                    <%
                        }
                    %>
                    <br>
                    Kommentar til student <br> <input class="textboxLarge" type="text" name="Number" />
<!--                    <textarea name='txtarea0' class="textboxLarge" placeholder="testing func">
                      <br>
                          
                     <br>
                    </textarea>-->
                    <br>
                 
                         <jsp:include page="textEditor.jsp"/>                         
                
                    <br>
                    Intern kommentar (Ikke synlig for student) <br> <input class="textboxLarge" type="text" name="Goal" />
                    <br>
                    Godkjenner navn <input type="text" name="Name" placeholder="Blir USER fra ROLE"/>
                    <br>
                    <!--Antall poeng <input type="number" name="Points" min="0" step="1"/>-->
                     <p>
                        <label>Poeng</label>
                        <select id = "pointList">
                          <option value = "1">1 Nesten stryk</option>
                          <option value = "2">2</option>
                          <option value = "3">3</option>
                          <option value = "4">4</option>
                          <option value = "5">5 Middels</option>
                          <option value = "6">6</option>
                          <option value = "7">7</option>
                          <option value = "8">8</option>
                          <option value = "9">9</option>
                          <option value = "10">10 Toppers! A!</option>
                        </select>
                     </p>
                    <br>
                    <input type="radio" name="delivery" value="Approved" checked> Godkjent<br>
                    <input type="radio" name="delivery" value="NotApproved"> Ikke godkjent<br>
                    
                    <input type="Submit" name="AddStudent" value="Bekreft Endering" />

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
            } else {
            %>
       
            <p> Vennligst vent i kø på din tur. Du rykker stadig bakover i køen </p>
            <br>
            
            <%
}
}
        %>
       

    </ul>
    <script type='text/javascript'>
        listSize("queueList1");
    </script>
            </div>

</body>

