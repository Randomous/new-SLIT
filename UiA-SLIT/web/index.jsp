
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

    <head>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    

        <title>UiA-SLIT</title>
        <jsp:include page="UserInfo.jsp" />
    </head>

    
      
    
    <div id="second">
    </div>

    <body>
        <div id="title">
            <jsp:useBean id="mybean2" scope="session" class="WebInput.Input"/>
        </div>
        <h2><jsp:getProperty name="mybean2" property="help" /></h2>
<!--    <center><form id="userform" name="loginForm" method="post" action="InputHandler">
            Brukernavn:</font> <input type="text" name="name"/> <br/>
        <input type="submit" name="Search" value="Søk" /></center>
    <br>
</form>-->

     
        
        <center><form id="userSearch" name="userSearch" method="post" action="UserSearch.jsp">
            Student navn</font> <input type="text" name="name"/> <br/>
        <input type="submit" name="Search" value="Søk" /></center>
    <br>
</form>
         
<form action="${pageContext.request.contextPath}/InputHandler" method="post">
    <center><input type="submit" name="Commands" value="Tekst kommandoer" />
        <input type="submit" name="Module" value="Siste moduler" />
        <input type="submit" name="Students" value="Studenter" />
    </center>
</form>

<form action="module.jsp" method="post"> 
    <center>
        <input type="submit" name="Module" value="Gå til Moduler">
    </center>

</form>



<center>
    <br>
    <div id="student" style="display:none">
        <form action="InputHandler" method="post"> 
            Navn <input type="text" name="Firstname" />
            Etternavn <input type="text" name="Surname" />
            <br>
            Epost <input type="text" name="Mail" />
            StudentID <input type="number" name="StudentID" min="0" step="1"/>
            <br>
            <input type="Submit" name="AddStudent" value="Legg til student" />

        </form>
        <br>
        <button onclick="asd(2, 'student')">Avbryt registrering</button>
    </div>

    <button id="hidestudent" onclick="asd(1, 'student')">Registrer ny student</button>
</center>

</body>

