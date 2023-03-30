import java.util.ArrayList;
public class Student extends Person {

    private int studentID;
    private int currSemester;
    private String universityEmail;
    private double gpa;
    private String major;
    private String  minor;
    private double balance;
    private boolean isDomestic;
    private double totalCredits;
    private PersonalInfo personalInfo;
    private ArrayList<FutureSemester> futureSchedule;
    private ArrayList<Course> completedCourses;
    private ArrayList<Course> registeredCourses;
 


    // Need to figure out how to instantiate these variables 
    // personalInfo, futureSchedule, completedCourses, registeredCourses
    Student(String firstName, String preferredName, String lastName, int studentID, int currSemester, String universityEmail, double gpa, String major, String minor, double balance, boolean isDomestic, double totalCredits, ArrayList<Course> completedCourses, ArrayList<Course> registeredCourses, PersonalInfo personalInfo)
    {
        super(firstName, preferredName, lastName);
        this.studentID = studentID;
        this.currSemester = currSemester;
        this.universityEmail = universityEmail; 
        this.gpa = gpa; 
        this.major = major; 
        this.minor = minor; 
        this.balance = balance; 
        this.isDomestic = isDomestic;
        this.totalCredits = totalCredits; 
        this.completedCourses = completedCourses; 
        this.registeredCourses = registeredCourses;
        this.personalInfo = personalInfo; 
        this.futureSchedule = new ArrayList<FutureSemester>();
 
    }

    public String applyMinor(Counselor counselor, MinorApp minor)
    {

        return "Success";

    }
    public String registerCourse(CourseCatalog catalog, int courseCode)
    {
        return "Success";
    }
    
    public String addCourseReview(int courseCode)
    {
        return "Success";
    }

    public String deregisterCourse(CourseCatalog catalog, int courseCode)
    {
        return "Success";
    }

    public String updatePersonalInfo()
    {
        return "Success";
    }
    public String updateBalance(Course course, boolean addMinusCost)
    {
        return "Success";
    }
    // public String payBalance()
    // {
    //     float total = 0.0f;
    //     for (Course current : registeredCourses) {
    //         if (current.isPastDeadline() == true) {
    //             current.deregisterCourse();
    //         } else {
    //             total = current.getCost();
    //         }
    //     }
    //     return "Success";
    // }
    private Course findCourse(int courseCode)
    {
        return null;
    }
    private void createReview(Course course)
    {
    }
    public Course searchRegisteredCourses(String courseCode)
    {
        return null;
    }
    public String requestRefund(float amount)
    {
        return "Success";
    }
    public boolean isEligible()
    {
        return false; 
    }
    private double deductFee(int amount)
    {
        return (double)4.5;
    }
    public String getBankDetails()
    {
        return "Success";
    }
    public String submitRequest()
    {
        return "Success";
    }
    public void setMinor(String minor)
    {

    }
    public String payTuition()
    {
        double total = 0.0;
        for (Course toCheck : registeredCourses) {
            if (/*CourseCatalog.isPastDeadline()*/false) {

            }
        }
        return "Success";
    }

    public String createFutureSemester(CourseCatalog catalog, int year, String season)
    {
        return "Success";
    }

    public void addFutureSemester(FutureSemester futureSemester)
    {
        futureSchedule.add(futureSemester); 

    }
    public boolean searchCompletedCourses(String courseCode)
    {
        for (Course c: completedCourses)
        {
            if (c.getCourseCode() == courseCode)
            {
                return true; 
            }
        } 
        return false; 
    }
}
