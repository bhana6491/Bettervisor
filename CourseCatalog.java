import java.util.ArrayList;
import java.util.List;
import java.util.Date;

public class CourseCatalog {
    private ArrayList<Course> courseList;
    private Date paymentDeadline;
    private ArrayList<String> minorsList;

    CourseCatalog(Date paymentDeadline)
    {
        this.paymentDeadline = paymentDeadline; 
        this.courseList = new ArrayList<Course>(); 
        this.minorsList = new ArrayList<String>(); 
    }

    public Course searchCatalog(String courseCode)
    {
        for (Course c:courseList)
        {
            if (c.getCourseCode().equals(courseCode))
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
            System.out.println(c.toString()); 
        }
    }

    public boolean isPastDeadline(Date deadline)
    {
       return deadline.after(paymentDeadline);  
    }
    public void addMinorToList(String minor)
    {
        minorsList.add(minor); 
    }
    public void displayMinors()
    {
        for (String minor: minorsList)
        {
            System.out.println(minor); 
        }
    }
    public boolean isValidMinor(String minor)
    {
        return minorsList.contains(minor); 
    }

}
