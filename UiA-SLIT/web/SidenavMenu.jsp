<%-- 
    Document   : SidenavMenu
    Created on : Nov 12, 2017, 4:00:43 PM
    Author     : root
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<div id="mySidenav" class="sidenav">
  <a href="javascript:void(0)" class="closebtn" onclick="closeNav()">&times;</a>
  <br>
  <br>
  <a href="index.jsp"> Hjem </a>
  <p> Moduler</p>
  <a href="module.jsp">Endre/oppdatere</a>
  <a href="deliveryQueue.jsp">Leveringskø</a>
  <a href="Deliverable.jsp">Innlevering</a>
  <a href="Modules.jsp">Moduler</a> 
 
  <p> Brukere</p>
      <a href="Users.jsp"> Brukere</a>
  
</div>

<!-- Use any element to open the sidenav -->
<span onclick="openNav()">
    <button>Meny</button>
</span>

<!-- Add all page content inside this div if you want the side nav to push page content to the right (not used if you only want the sidenav to sit on top of the page -->
<div id="main">
<!--    <button id="test" name="bla" value="meny"></button>-->
</div> 

