import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Scanner;

public class Course {

    private String courseCode;
    private HashMap<Student, Section> classList;
    private ArrayList<Section> sectionList;
    private ArrayList<Course> prerequisites;
    private String examTime;
    private double cost;
    private String term;
    private double weight;
    private String description;
    private ArrayList<Course> restrictions;
    private ArrayList<CourseReview> reviews;

    Course(String courseCode, HashMap<Student, Section> classList, ArrayList<Section> sectionList, ArrayList<Course> prerequisites, String examTime, double cost, String term, double weight, String description, ArrayList<Course> restrictions, ArrayList<CourseReview> reviews)
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
        // //Print all sections of a course
        System.out.println("\nCurrent Section Offerrings:");
        System.out.println("--------------------------\n");

        for (Section s: sectionList)
        {
            System.out.println(s.toString());
        }

        Scanner sectionScanner = new Scanner(System.in);

        System.out.print("Enter section ID(integer):");

        boolean isValid = true;

        int sectionID = 0;

        do
        {
            if (!sectionScanner.hasNextInt())
            {
                sectionScanner.next();
                isValid = false;
            }
            else
            {
                sectionID = sectionScanner.nextInt();
                for (Section s: sectionList)
                {
                    if (s.getSectionID() == sectionID)
                    {
                        return s; 
                    }
                }
                isValid = false; 
            }

            if (!isValid)
            {
                System.out.print("Please enter a valid Section ID: ");
            }
        } while (!isValid);

        //Iterate through sections to match section ID
        return null; 

    }
    public String addToClassList(Student student, Section section)
    {
        classList.put(student, section); 
        return "Added information to class list"; 
    }
    public void removeFromClassList(Student student, Section section)
    {

        classList.remove(student); 

        //increment number of empty seats available
        section.updateSection(-1); 

        //Add student from popped list and update their balance
        if (section.isFull() == false)
        {
            Student popped = section.popFromWaitlist(); 
            addToClassList(popped, section);
            popped.updateBalance(this, true);
        }        
    }
    public String publishCourseReview(CourseReview courseReview)
    {
        reviews.add(courseReview);
        return "Added Course Review";
    }
    public double getCost()
    {
        return this.cost; 
    }

    public Section searchClassList(Student student)
    {
        //returns null if student not in class
        return classList.get(student);  
    }

    public String getCourseCode()
    {
        return courseCode; 
    }
    public boolean isRestricted(Student student)
    {
        //Iterate through all the restrictions for the course and check if they're currently registered or have taken a course in restricted
        for (Course c:restrictions)
        {
            String code = c.getCourseCode(); 
            if (student.searchRegisteredCourses(code) == null && student.searchCompletedCourses(code) == false)
            {
                return false; 
            }
        }
        return true; 
    }
    public String toString()
    {
        return "Course Code: " + courseCode + "\n" + "Course Description: " + description + "\n" + "Course Weight: " + weight + "\n";
    }
    // public static void main(String[] args){

    //     HashMap<Student, Section> classList = new HashMap<Student, Section>(); 
    //     ArrayList<Section> sectionList = new ArrayList<Section>(); 
    //     ArrayList<Course> prerequisites = new ArrayList<Course>(); 
    //     Date examTime = new Date();
    //     float cost = 3.43f; 
    //     String term = "Winter";
    //     float weight = 0.75f; 
    //     String description = "Cool Course"; 
    //     ArrayList<Course> restrictions = new ArrayList<Course>(); 
    //     ArrayList<CourseReview> reviews = new ArrayList<CourseReview>(); 
	// 	// Course course = new Course("CIS1500", classList,sectionList,prerequisites, examTime, cost, term, weight, description, restrictions, reviews);
	// 	course.selectSection(); 
	// }

}
