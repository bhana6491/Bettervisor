import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Scanner;

public class Course {

    private String courseCode;
    private HashMap<Student, Section> classList;
    private ArrayList<Section> sectionList;
    private String examTime;
    private double cost;
    private String term;
    private double weight;
    private String description;
    private ArrayList<CourseReview> reviews;

    Course(String courseCode, HashMap<Student, Section> classList, ArrayList<Section> sectionList, String examTime, double cost, String term, double weight, String description, ArrayList<CourseReview> reviews)
    {
        this.courseCode = courseCode; 
        this.classList = classList; 
        this.sectionList = sectionList; 
        this.examTime = examTime; 
        this.cost = cost; 
        this.term = term; 
        this.weight = weight; 
        this.description = description; 
        this.reviews = reviews;
    }
    public Section selectSection()
    {
        // //Print all sections of a course
        System.out.println("\nCurrent Section Offerrings:");
        System.out.println("----------------------------\n");

        for (Section s: sectionList)
        {
            System.out.println(s.toString());
        }

        Scanner sectionScanner = new Scanner(System.in);

        System.out.print("Enter section ID: ");

        boolean isValid = true;

        int sectionID = 0;

        //Validating Section ID
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
        section.updateSection(1); 

        //Add student from popped list and update their balance
        if (section.isFull() == false)
        {
            Student popped = section.popFromWaitlist(); 
            if (popped == null)
            {
                return;
            }
            addToClassList(popped, section);
            System.out.println("A student on the waitlist was added to the classlist!");
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

    public String toString()
    {
        return "Course Code: " + courseCode + "\n" + "Course Description: " + description + "\n" + "Course Weight: " + weight + "\n" + "Reviews:\n" + reviews.toString();
    }
}
