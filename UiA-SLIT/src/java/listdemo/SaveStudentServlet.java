/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listdemo;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import listdemo.db.Student;
import listdemo.db.StudentManagerLocal;


/**
 *
 * @author evenal
 */
@WebServlet("/savestudent")
public class SaveStudentServlet extends HttpServlet
        implements StringConstants
{

    @EJB
    StudentManagerLocal studentMgr;

    protected void doIt(HttpServletRequest req, HttpServletResponse resp)
            throws UnsupportedEncodingException {
        req.setCharacterEncoding("UTF-8");
        String idStr = req.getParameter(ID);
        String name = req.getParameter(NAME);
        String address = req.getParameter(ADDRESS);
        String extra = req.getParameter(EXTRA);

        long id = Long.valueOf(idStr);

        Student existing = studentMgr.getStudent(id);
        if (existing == null) {
            existing = new Student(name, address, extra);
            studentMgr.addStudent(existing);
        } else {
            existing.setName(name);
            existing.setAddress(address);
            existing.setExtra(extra);
            studentMgr.updateStudent(existing);
        }

        RequestDispatcher dispatcher = req.getRequestDispatcher("studentlist");
        try {
            dispatcher.forward(req, resp);
        } catch (ServletException | IOException ioe) {
            ioe.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {
        doIt(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        doIt(req, resp);
    }
}
