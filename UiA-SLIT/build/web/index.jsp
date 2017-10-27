
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="index.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="javascript.js" type="text/javascript"></script>

        <title>UiA-SLIT</title>
    </head>

    <div id="first">
    </div>
    <div id="second">
    </div>

    <body>
        <div id="title">
            <jsp:useBean id="mybean2" scope="session" class="WebInput.Input"/>
        </div>
        <h2><jsp:getProperty name="mybean2" property="help" /></h2>
    <center><form id="userform" name="loginForm" method="post" action="InputHandler">
            Brukernavn:</font> <input type="text" name="name"/> <br/>
        <input type="submit" name="Search" value="Søk" /></center>
    <br>
</form>
        
         <div id="mySidenav" class="sidenav">
  <a href="javascript:void(0)" class="closebtn" onclick="closeNav()">&times;</a>
  <br>
  <br>
  <a href="module.jsp">Moduler</a>
  <a href="Users.jsp"> Brukere</a>
  <a href="Modules.jsp">Moduler(database)</a> 
  <a href="#">Funker</a>
  <a href="#">Ikke</a>
</div>

<!-- Use any element to open the sidenav -->
<span onclick="openNav()">
    <button>Meny</button>
</span>

<!-- Add all page content inside this div if you want the side nav to push page content to the right (not used if you only want the sidenav to sit on top of the page -->
<div id="main">
<!--    <button id="test" name="bla" value="meny"></button>-->
</div> 

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
</html>
