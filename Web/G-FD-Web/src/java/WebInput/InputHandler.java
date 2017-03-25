/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WebInput;


import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import WebInput.Input;
import Content.GamerRegister;


/**
 *
 * @author Tor Borgen <Tor Borgen at CastleDev>
 */


@WebServlet(name = "InputHandler", urlPatterns = {"/InputHandler"})
public class InputHandler extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Input input = new Input();
        GamerRegister gamerReg = new GamerRegister();
        String goBack = "<center><form name=\"Go back\" action=\"buttons.jsp\">\n" +
            "<input type=\"submit\" value=\"Go back\" />\n" +
            "</form></center>";
        
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
          if (request.getParameter("Commands") != null) {
            //out.println("<h3>Works!</h3>");
            out.println("<h1>" + input.getCommands() + "</h1>");
            out.println(goBack);
        } else if (request.getParameter("Leaderboard") != null) {
            out.println("<center><h1>" + input.getLeaderboard() + "</h1></center>");
            out.println(goBack);
        } else if (request.getParameter("Gamers") != null) {
            input.setName("!GAMERS");
            out.println("<center><h1>" + input.getName() + "</h1></center>");
            out.println(goBack);
        } else if (request.getParameter("AddGamer") != null) {
             //out.println("Please enter the gamer information\n" + 
               //             "Enter the gamertag assosiated with the gamer");
             String newname = request.getParameter("gamerTag");
             String description = request.getParameter("gamerDesc");
             String rank = request.getParameter("rankType");
             String rankP = request.getParameter("rankPoints");
             int result = Integer.valueOf(rankP);
             gamerReg.webCreateGamer(newname,description, rank, result);
             out.println("Gamer: > " + newname + " < was successfully"
                            + " added to the system");
             out.println(goBack);
        }else if (request.getParameter("Search") != null) {
            input.setName(request.getParameter("name"));
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet InputHandler</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<center><h1>Servlet InputHandler at " + request.getContextPath() + "</h1></center>");
            out.println("<center><h2> Response form system: <br>" + input.getName() + "</h2></center>");
            
            out.println(goBack);
            out.println("</body>");
            out.println("</html>");
        } else {
            // out.
        }
            /* TODO output your page here. You may use following sample code. */
            //String returned;
            //returned = request.getParameter("name");
           
          
        
    }
    
   
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
