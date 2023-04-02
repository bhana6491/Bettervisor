import java.util.ArrayList;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

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

    public boolean isPastDeadline(Date currDate)
    {
       DateFormat df = new SimpleDateFormat("MM-dd-yyyy");
       System.out.println("PAYMENT DEADLINE DATE: "  + df.format(paymentDeadline.getTime()));
       return currDate.after(paymentDeadline);  
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
