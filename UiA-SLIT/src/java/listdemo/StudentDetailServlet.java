/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listdemo;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import listdemo.db.Student;
import listdemo.db.StudentManagerLocal;


/**
 * This servlet writes a page with a form, for viewing and/or editing student
 * data
 *
 * @author evenal
 */
@WebServlet("/studentdetail")
public class StudentDetailServlet extends HttpServlet
        implements StringConstants
{

    @EJB
    StudentManagerLocal studentMgr;

    protected void doIt(HttpServletRequest req, HttpServletResponse resp)
            throws IOException, UnsupportedEncodingException {
        req.setCharacterEncoding("UTF-8");
        Student student = null;

        String id = req.getParameter("id");
        if (id != null) {
            long studno = Long.parseLong(id);
            student = studentMgr.getStudent(studno);
        }

        resp.setCharacterEncoding("UTF-8");
        PrintWriter out = resp.getWriter();

        out.format(StudentListServlet.PREAMBLE);
        out.format("<h1>Student details</h1>\n");
        if (student == null)
            student = new Student();
        writeForm(out, student);
    }

    private void writeForm(PrintWriter out, Student student) {
        out.format("<form action='savestudent' method='POST'>\n<table>\n");
        out.format(ID_FIELD, "Student no.", ID, student.getId());
        out.format(TEXT_FIELD, "Name", NAME, student.getName());
        out.format(TEXT_FIELD, "Address", ADDRESS, student.getAddress());
        out.format(TEXT_FIELD, "Extra info", EXTRA, student.getExtra());
        out.format(START_BUTTON_ROW);
        out.format(BUTTON, "Save");
        out.format(BUTTON_FORMACTION, "deletestudent", DELETE);
        out.format(BUTTON_FORMACTION, "studentlist", CANCEL);
        out.format(END_BUTTON_ROW);
        out.format("</table>\n</form>\n</body>\n</html>");
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
