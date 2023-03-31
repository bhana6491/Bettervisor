import java.util.ArrayList;
import java.util.Scanner;
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
    public String registerCourse(CourseCatalog catalog, String courseCode)
    {

        Course course = catalog.searchCatalog(courseCode); 

        if (registeredCourses.contains(course))
        {
            return "\nYou are already registered in this course!\n"; 
        } 

        Section section = course.selectSection(); 

        if (section.isFull() == true)
        {
            section.addToWaitlist(this); 
            return "You have been added to the Section " + section.getSectionID() + " waitlist"; 
        }
        else
        {
            course.addToClassList(this, section); 
            
            section.updateSection(-1); 
            updateBalance(course, true); 
            registeredCourses.add(course); 
            return "\nYou have successfuly registered for " + course.getCourseCode() + " in Section " + section.getSectionID() + "\n" + "Your balance has been updated, current total is: " + balance + "\n"; 
        }
    }
    
    public String addCourseReview(String courseCode)
    {
        return "Success";
    }

    public String deregisterCourse(String courseCode)
    {

        Course c = searchRegisteredCourses(courseCode);//should always be valid, since we do the check outside as well
        Section s = c.searchClassList(this);
        System.out.println(c.toString());
        c.removeFromClassList(this, s);
        registeredCourses.remove(c);
        updateBalance(c, false);

        return "\nSuccessfully deregistered from " + c.getCourseCode() + "\n" + "Your balance has been updated, current total is: " + balance;
    }

    public String updatePersonalInfo()
    {
        personalInfo.displayPersonalInfo();

        Scanner personalInfoScanner = new Scanner(System.in);  // Create a Scanner object
        System.out.print("Which info would you like to update? (1-5): ");
        int personalInfoChoice = 0;
        boolean isValid = true;
        do
        {
            if (!personalInfoScanner.hasNextInt())
            {
                personalInfoScanner.next();
                isValid = false;
            }
            else
            {
                personalInfoChoice = personalInfoScanner.nextInt();
                isValid = personalInfoChoice >= 1 && personalInfoChoice <= 5;
            }

            if (!isValid)
            {
                System.out.print("Invalid input: please try again");
                System.out.print("Please make a selection (1-5): ");
            }
        } while (!isValid);
        if (personalInfoChoice == 1)
        {
            boolean inputValid = true;
            do 
            {
                String input = "";
                System.out.println("Enter new value for ecFirstName");
                input = personalInfoScanner.next();
                String pattern = "[A-Za-z]{1}";
                if (!input.matches(pattern)) 
                {
                    System.out.println("Invalid format for first name");
                    inputValid = false;
                }
                else
                {
                    personalInfo.setEcFirstName(input);
                    personalInfo.displayPersonalInfo();
                    inputValid = true;
                }
            } while (!inputValid);
        }
        else if (personalInfoChoice == 2)
        {
            boolean inputValid = true;
            do 
            {
                String input = "";
                System.out.println("Enter new value for ecNumber");
                input = personalInfoScanner.next();
                String pattern = "\\d{10}|(?:\\d{3}-){2}\\d{4}|\\(\\d{3}\\)\\d{3}-?\\d{4}";
                if (!input.matches(pattern)) 
                {
                    System.out.println("Invalid format for phone number");
                    inputValid = false;
                }
                else
                {
                    personalInfo.setEcNumber(input);
                    personalInfo.displayPersonalInfo();
                    inputValid = true;
                }
            } while (!inputValid);
        }
        else if (personalInfoChoice == 3)
        {
            boolean inputValid = true;
            do
            {
                String input = "";
                System.out.println("Enter new value for ecEmail");
                input = personalInfoScanner.next();
                String pattern = "^(.+)@(.+)$";
                if (!input.matches(pattern)) 
                {
                    System.out.println("Invalid format for email address");
                    inputValid = false;
                }
                else
                {
                    personalInfo.setEcEmail(input);
                    personalInfo.displayPersonalInfo();
                    inputValid = true;
                }
            } while (!inputValid);
        }
        else if (personalInfoChoice == 4)
        {
            boolean inputValid = true;
            do
            {
                String input = "";
                System.out.println("Enter new value for Personal Number");
                input = personalInfoScanner.next();
                String pattern = "^\\d{10}$";
                if (!input.matches(pattern)) 
                {
                    System.out.println("Invalid format for phone number");
                    inputValid = false;
                }
                else
                {
                    personalInfo.setPersonalNumber(input);
                    personalInfo.displayPersonalInfo();
                    inputValid = true;
                }
            } while (!inputValid);
        }
        else if (personalInfoChoice == 5)
        {
            boolean inputValid = true;
            do
            {
                String countryInput = "";
                String proviceInput = "";
                String streetNameInput = "";
                String streetNumberInput = "";
                String postalInput = "";

                String countryPattern = "^[a-zA-Z]*$";
                String numberPattern = "\\d+";
                String postalPattern = "^(?!.*[DFIOQU])[A-VXY][0-9][A-Z] ?[0-9][A-Z][0-9]$";

                while (true)
                {
                    System.out.print("Enter new value for Country: ");
                    countryInput = personalInfoScanner.next();
                    if (countryInput.matches(countryPattern))
                    {
                        break;
                    }    
                }
                
                while (true)
                {
                    System.out.print("Enter new value for Province: ");
                    proviceInput = personalInfoScanner.next();
                    if (proviceInput.matches(countryPattern))
                    {
                        break;
                    }    
                }
                
                while (true)
                {
                    System.out.print("Enter new value for Street Name: ");
                    streetNameInput = personalInfoScanner.next();
                    if (streetNameInput.matches(countryPattern))
                    {
                        break;
                    }    
                }

                while (true)
                {
                    System.out.print("Enter new value for Street Number: ");
                    streetNumberInput = personalInfoScanner.next();
                    if (streetNumberInput.matches(numberPattern))
                    {
                        break;
                    }    
                }

                while (true)
                {
                    System.out.print("Enter new value for Postal Code: ");
                    postalInput = personalInfoScanner.next();
                    if (postalInput.matches(postalPattern))
                    {
                        break;
                    }    
                }
                personalInfo.setEcAddress(countryInput, proviceInput, streetNameInput, streetNumberInput, postalInput);
            } while (!inputValid);
        }
        return "SUCCESS";
    }
    public void updateBalance(Course course, boolean addMinusCost)
    {
        if (addMinusCost == true)
        {
            balance = balance + course.getCost();
        }
        else
        {
            balance = balance - course.getCost(); 
        }
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
    private Course findCourse(String courseCode)
    {
        return null;
    }
    private void createReview(Course course)
    {
    }
    public Course searchRegisteredCourses(String courseCode)
    {
        for (Course c: registeredCourses)
        {
            if (c.getCourseCode().equals(courseCode))
            {
                return c;
            }
        }
        return null; 
    }
    public String requestRefund(double amount)
    {
        return "Success";
    }
    public boolean isEligible()
    {
        return false; 
    }
    private double deductFee(double amount)
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
    public int listRegisteredCourses()
    {
        for (Course c: registeredCourses)
        {
            System.out.println("Course Code: " + c.getCourseCode()); 
        }
        
        if (registeredCourses.size() == 0)
        {
            System.out.println("You are currently registered in 0 courses\n");
        }
        return registeredCourses.size(); 
    }
    // public String payTuition()
    // {
    //     double total = 0.0;

    //     System.out.println("FINANCIAL REPORT:");
    //     for (Course toCheck : registeredCourses) {
    //         if (CourseCatalog.isPastDeadline(toCheck)) {
    //             deregisterCourse(null, toCheck.getCourseCode());
    //             System.out.println(toCheck.getCourseCode() + " is past deadline and you were unenrolled.");
    //         } else {
    //             System.out.println(toCheck.getCourseCode() + ": $" + toCheck.getCost());
    //             total += toCheck.getCost();
    //         }
    //         System.out.println("Total: $" + total);
    //         System.out.println("Accounted For: $" + (balance - total)*-1);
    //         System.out.println("Remaining Balance: $" + balance);
    //     }

    //     return "Success";
    // }

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
