<%-- 
    Document   : FullApp
    Created on : Feb 23, 2017, 1:36:52 AM
    Author     : Tor Borgen <Tor Borgen at CastleDev>
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    
    <body>
        <jsp:useBean id="mybean2" scope="session" class="WebInput.Input"/>
        <h2><jsp:getProperty name="mybean2" property="help" /></h2>
    <center><form name="loginForm" method="post" action="InputHandler">
    Username: <input type="text" name="name"/> <br/>
        <input type="submit" name="Search" value="Search" /></center>
    <br>
</form>
        
    <form action="${pageContext.request.contextPath}/InputHandler" method="post">
    <center><input type="submit" name="Commands" value="Text Input Commands" />
    <input type="submit" name="Leaderboard" value="Leaderboard" />
    <input type="submit" name="Gamers" value="Registered Gamers" />
    </center>
</form>

    <center>
        <br>
    <div id="asd">
    <form action="InputHandler" method="post">
    Foreløpig Test Tittel <input type="text" name="gamerTag" />
    Enter a description of the gamer <input type="text" name="gamerDesc" />
    <br>
    Enter the rank type <input type="text" name="rankType" />
    Enter rank points <input type="number" name="rankPoints" min="0" step="1"/>
    <br>
    <input type="submit" name="AddGamer" value="Submit new gamer" />
    
    </form>
        <br>
        <button onclick="asd(1)">Close without submitting</button>
    </div>

    <button onclick="asd(2)">Add new Gamer</button>

    <script type="text/javascript">
    function asd(a)
    {
        if(a===1)
        document.getElementById("asd").style.display="none";
        else
        document.getElementById("asd").style.display="block";
    }
    window.onload = asd(1);
    </script>
        </center>

        </body>
    </html>
