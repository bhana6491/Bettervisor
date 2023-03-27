import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class Course {

    private String courseCode;
    private HashMap<Student, Section> classList;
    private ArrayList<Section> sectionList;
    private ArrayList<Course> prerequisites;
    private Date examTime;
    private float cost;
    private String term;
    private float weight;
    private String description;
    private ArrayList<Course> restrictions;
    private ArrayList<CourseReview> reviews;

    Course(String courseCode, HashMap<Student, Section> classList, ArrayList<Section> sectionList, ArrayList<Course> prerequisites, Date examTime, float cost, String term, float weight, String description, ArrayList<Course> restrictions, ArrayList<CourseReview>  reviews)
    {
        this.courseCode = courseCode; 
        this.classList = classList; 
        this.sectionList = sectionList; 
        this.prerequisites = prerequisites; 
        this.examTime = examTime; 
        this.cost = cost; 
        this.term = term; 
        this.weight = weight; 
        this.description = description; 
        this.restrictions = restrictions; 
        this.reviews = reviews;
    }
    public Section selectSection()
    {
        return null;
    }
    public String addToClassList(Student student, Section section)
    {
        return "Success"; 
    }
    public void removeFromClassList(Student student, Section section)
    {
        
    }
    public String publishCourseReview(CourseReview courseReview)
    {
        return "Success";
    }
    public float getCost()
    {
        return this.cost; 
    }

    public Section searchClassList(Student student)
    {
        return null; 
    }

    public int getCourseCode()
    {
        return 5; 
    }
    public boolean isRestricted(Student student)
    {
        return false; 
    }
    public String toString()
    {
        return "Success"; 
    }
}
