import java.util.ArrayList;
public class FutureSemester {
    private ArrayList<Course> courseList;
    private int year;
    private String season;

    FutureSemester(int year,String season)
    {
        this.year = year; 
        this.season = season; 
    }
    public String addCourseToPlan(Course course)
    {
        return "Success"; 
    }
    public int getNumPlanned()
    {
        return courseList.size(); 
    }
}
