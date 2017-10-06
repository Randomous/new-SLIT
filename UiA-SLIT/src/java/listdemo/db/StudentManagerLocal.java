package listdemo.db;

import java.util.List;
import javax.ejb.Local;


/**
 * This class fakes a database connection (actually it fakes an EJB that manages
 * a database table). We will get more into that when we start working with EJBs
 * and databases.
 *
 * Depending on how you use the
 *
 * @author evenal
 */
@Local
public interface StudentManagerLocal
{

    public void addStudent(Student s);

    public boolean updateStudent(Student s);

    public Student getStudent(long id);

    public boolean removeStudent(long id);

    public List<Student> getStudents();
}
