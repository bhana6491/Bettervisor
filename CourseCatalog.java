import java.util.ArrayList;
import java.util.Date;

public class CourseCatalog {
    private ArrayList<Course> courseList;
    private Date paymentDeadline;

    CourseCatalog(Date paymentDeadline)
    {
        this.paymentDeadline = paymentDeadline; 
        this.courseList = new ArrayList<Course>(); 
    }

    public Course searchCatalog(String courseCode)
    {
        for (Course c:courseList)
        {
            if (c.getCourseCode() == courseCode)
            {
                return c; 
            }
        } 
        return null; 
    }
    public void addCourse(Course course)
    {
        courseList.add(course); 
        
    }
    public void listCourses()
    {
        for (Course c: courseList)
        {
            c.toString(); 
        }
    }

    //public boolean isPastDeadline(Date deadline)
    //{
    //    return deadline.after(paymentDeadline);  
    //}
}
