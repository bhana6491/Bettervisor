import java.util.ArrayList;
import java.util.Date;

public class CourseCatalog {
    private ArrayList<Course> courseList;
    private Date paymentDeadline;

    CourseCatalog(Date paymentDeadline)
    {
        this.paymentDeadline = paymentDeadline; 
    }

    public Course searchCatalog(int courseCode)
    {
        return null; 
    }
    public void addCourse(Course course)
    {
        
    }
    public String listCourses()
    {
        return "Success"; 
    }

    public boolean isPastDeadline(Date deadline)
    {
        return false; 
    }
}
