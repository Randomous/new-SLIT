 
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>

<!DOCTYPE html>
 
    <head>
 
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    
 
        <title>UiA-SLIT</title>
       
    </head>
<jsp:include page="UserInfo.jsp" /> 
    <div class="wrapperofwrapper"> 
    <div class="wrapper">
 
    <body>
<div id="title">
            <jsp:useBean id="mybean2" scope="session" class="WebInput.Input"/>
            
            <% //Sjekker om rollen er lærer, hvis den er kjøres koden for vurderingsknapper   
        // Lager variabel for senere kall i kode
        
        String sesRole = request.getSession().getAttribute("role").toString();
                String checkRole = "Lærer";                
                String checkRoleTA = "Hjelpelærer";
            if( checkRole.equals(sesRole) || checkRoleTA.equals(sesRole)) {
        %>
             <sql:setDataSource
    var="myDS"
    driver="com.mysql.jdbc.Driver"
    url="jdbc:mysql://localhost:3306/Randobase"
    user="randmin" password="555666"
/>
             <sql:query var="list_Deliverables" dataSource="${myDS}">
    SELECT COUNT(D_ID) AS Innleveringer FROM Deliverable WHERE D_DeliverableStatus=0;
</sql:query>
    

        <table id="frontQueue">
            <tr id="frontqueuetr">
                <th id="frontqueueTH">Innleveringer i kø:</th>
            </tr>
            <c:forEach var="Deliverable" items="${list_Deliverables.rows}">
                <tr>
                    <td><c:out value="${Deliverable.Innleveringer}" /></td>
                </tr>
            </c:forEach>
        </table>
   <% } %>
        </div>
        
        <div id="userSearch"> 
        <h2>Studentsøk</h2>
<!--    <center><form id="userform" name="loginForm" method="post" action="InputHandler">
            Brukernavn:</font> <input type="text" name="name"/> <br/>
        <input type="submit" name="Search" value="Søk" /></center>
    <br>
</form>-->
 
     
    
<form name="userSearch" method="post" action="UserSearch.jsp">
            Student navn</font> <input type="text" name="name"/>
        <input type="submit" name="Search" value="Søk" />
</form>
      </div>
    </div>
    </div>
 
</body>
 