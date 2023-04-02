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
    public boolean courseExists(Course course)
    {
        for (Course c : courseList) {
            if (course.getCourseCode().equals(c.getCourseCode())) {
                return true;
            }
        }
        return false;
    }

    public String toString()
    {
        String result = "\nFuture Semester\n------------------\nYear: " + year + "\nSeason: " + season +  "\n------------------" + "\nPlanned Courses:\n";

        for (Course c : courseList) {
            result = result + c.toString() + "\n------------------\n";
        }

        return result;
    }
}
