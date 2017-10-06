package listdemo.db;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


/**
 * This class fakes a database connection (actually it fakes an EJB that manages
 * a database table). We will get more into that when we start working with EJBs
 * and databases.
 *
 * Depending on how you use the
 *
 * @author evenal
 */
@Stateless
public final class StudentManagerBean implements StudentManagerLocal
{

    /**
     * This is the "database" replace the hasjmap with entity mgr reference
     */
    @PersistenceContext
    EntityManager em;

    /**
     * Constructor - creates dummy test data
     */
    public StudentManagerBean() {
        System.err.println("em=" + em);

        
//        addStudent(new Student("Per", "Grua", "Ikke snill"));
//        addStudent(new Student("Paal", "Grua", "Enda verre"));
//        addStudent(new Student("Espen", "Grua", "Helten"));
//        addStudent(new Student("Kongen", "Slottet", "Slu"));
//        addStudent(new Student("Prinsessa", "Slottet", "Kverulant"));
//        addStudent(new Student("Heksa", "Skogen", "Kan trylle"));
//         
    }

//    public static StudentDb getInstance(HttpServlet servlet) {
//        ServletContext context = servlet.getServletContext();
//        StudentDb db = (StudentDb) context.getAttribute(STUDENT_DB);
//        if (db == null) {
//            db = new StudentDb();
//            context.setAttribute(STUDENT_DB, db);
//        }
//        return db;
//    }
    // methods for adding, deleting etc. students
    public void addStudent(Student s) {
        Student old = em.find(Student.class, s.getId());
        if (old == null) {
            em.persist(s);
        } else {
            em.merge(s);
        }
    }

    public boolean updateStudent(Student s) {
// should have test as in addstudent()
        em.merge(s);
        return true;
    }

    public Student getStudent(long id) {
        return em.find(Student.class, id);
    }

    public boolean removeStudent(long id) {
        Student s = em.find(Student.class, id);
        if (s != null)
            em.remove(s);
        return true;
    }

    public List<Student> getStudents() {
        System.err.println("em=" + em);
        Query q = em.createQuery("select s from Student s");
        List<Student> students = q.getResultList();
        return students;
    }
}
