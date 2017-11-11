<%-- 
    Document   : Login
    Created on : 09.nov.2017, 13:04:51
    Author     : Helle K. Trygsland
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login with JSP</title>
    </head>
    <body>
        <form method="post" action="LoginResponse.jsp">
            <center>
            <table border="1" cellpadding="5" cellspacing="2">
                <thead>
                    <tr>
                        <th colspan="2">Logg inn i UiA-SLIT systemet her</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>Brukernavn</td>
                        <td><input type="text" name="j_username" required/></td>
                    </tr>
                    <tr>
                        <td>Passord</td>
                        <td><input type="password" name="j_password" required/></td>
                    </tr>
                    <tr>
                        <td colspan="2" align="center"><input type="submit" value="Logg inn" />
                            &nbsp;&nbsp;
                            <input type="reset" value="Reset" />
                        </td>                        
                    </tr>                    
                </tbody>
            </table>
            </center>
        </form>
    </body>
</html>
