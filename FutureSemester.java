import java.util.ArrayList;
public class FutureSemester {
    private ArrayList<Course> courseList;
    private int year;
    private String season;

    FutureSemester(int year,String season)
    {
        courseList = new ArrayList<Course>();
        this.year = year; 
        this.season = season; 
    }
    public void addCourseToPlan(Course course)
    {
        courseList.add(course);
    }
    public int getNumPlanned()
    {
        return courseList.size(); 
    }
    //public boolean courseExists(Course course)
    //{
        //return courseList
    //}
}
