import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Scanner;
import java.util.InputMismatchException; 

import javax.lang.model.util.ElementScanner14;
public class Bettervisor {
    public static void main(String[] args){
        CourseReview review3750 = new CourseReview("CIS3750", 5, "Very enjoyable course");
        CourseReview review2750 = new CourseReview("CIS2750", 1, "Not fun");
        CourseReview review3490 = new CourseReview("CIS3490", 3, "Very cool");
        CourseReview review3110 = new CourseReview("CIS3110", 5, "Great fun");
        CourseReview review1050 = new CourseReview("CIS1050", 5, "Web Development is cool"); 
        
        Section s1_2750 = new Section(1, 20, 100, new ArrayList<Student>(), "Tues, Thurs 9am-10am", "Wed 1pm-2pm");
        Section s2_2750 = new Section(2, 20, 100, new ArrayList<Student>(), "Tues, Thurs 9am-10am", "Fri 1pm-2pm");
        Section s1_3750 = new Section(3, 20, 100, new ArrayList<Student>(), "Mon, Wed, Fri 8am-9:30am", "Wed 11am-12pm");
        Section s2_3750= new Section(4, 20, 100, new ArrayList<Student>(), "Mon, Wed, Fri 8am-9:30am", "Mon 3pm-4pm");
        Section s1_3490 = new Section(5, 20, 100, new ArrayList<Student>(), "Tues, Thurs 2pm-3:30pm", "Wed 1pm-2pm");
        Section s2_3490 = new Section(6, 20, 100, new ArrayList<Student>(), "Tues, Thurs 4pm-6pm", "Wed 1pm-2pm");
        Section s1_3110 = new Section(7, 20, 100, new ArrayList<Student>(), "Mon, Wed, Fri 8:30am-10:50pm", "Wed 1pm-2pm");
        Section s2_3110 = new Section(8, 20, 100, new ArrayList<Student>(), "Mon, Wed, Fri 8:30am-10:50pm", "Tuesday 3pm-5pm");
        Section s1_1050 = new Section(9, 20, 100, new ArrayList<Student>(), "Tues, Thurs 11am-1pm", "Fri 2pm-3pm");
        
        ArrayList<Section> cis2750Sections = new ArrayList<Section>();
        cis2750Sections.add(s1_2750);
        cis2750Sections.add(s2_2750);
        ArrayList<Course> cis2750Prereqs = new ArrayList<Course>();
        ArrayList<Course> cis2750Restrictions = new ArrayList<Course>();
        ArrayList<CourseReview> cis2750Reviews = new ArrayList<CourseReview>();
        cis2750Reviews.add(review2750);

        Course C2750 = new Course(
            "CIS2750",
            new HashMap<Student, Section>(),
            cis2750Sections,
            cis2750Prereqs,
            "1:00pm",
            754.23,
            "Winter",
            0.75,
            "Course about creating a application",
            cis2750Restrictions,
            cis2750Reviews
        );

        ArrayList<Section> cis3750Sections = new ArrayList<Section>();
        cis3750Sections.add(s1_3750);
        cis3750Sections.add(s2_3750);
        ArrayList<Course> cis3750Prereqs = new ArrayList<Course>();
        ArrayList<Course> cis3750Restrictions = new ArrayList<Course>();
        ArrayList<CourseReview> cis3750Reviews = new ArrayList<CourseReview>();
        cis3750Reviews.add(review3750);

        Course C3750 = new Course(
            "CIS3750",
            new HashMap<Student, Section>(),
            cis3750Sections,
            cis3750Prereqs,
            "1:00pm",
            600.99,
            "Winter",
            0.75,
            "Course about software development process",
            cis3750Restrictions,
            cis3750Reviews
        );

        ArrayList<Section> cis3490Sections = new ArrayList<Section>();
        cis3490Sections.add(s1_3490);
        cis3490Sections.add(s2_3490);
        ArrayList<Course> cis3490Prereqs = new ArrayList<Course>();
        ArrayList<Course> cis3490Restrictions = new ArrayList<Course>();
        ArrayList<CourseReview> cis3490Reviews = new ArrayList<CourseReview>();
        cis3490Reviews.add(review3750);

        Course C3490 = new Course(
            "CIS3490",
            new HashMap<Student, Section>(),
            cis3490Sections,
            cis3750Prereqs,
            "1:00pm",
            500.00,
            "Winter",
            0.50,
            "Course about algorithms",
            cis3490Restrictions,
            cis3490Reviews
        );

        ArrayList<Section> cis3110Sections = new ArrayList<Section>();
        cis3110Sections.add(s1_3110);
        cis3110Sections.add(s2_3110);
        ArrayList<Course> cis3110Prereqs = new ArrayList<Course>();
        ArrayList<Course> cis3110Restrictions = new ArrayList<Course>();
        ArrayList<CourseReview> cis3110Reviews = new ArrayList<CourseReview>();
        cis3110Reviews.add(review3110);

        Course C3110 = new Course(
            "CIS3110",
            new HashMap<Student, Section>(),
            cis3110Sections,
            cis3110Prereqs,
            "1:00pm",
            754.23,
            "Winter",
            0.50,
            "Course about operating systems",
            cis3110Restrictions,
            cis3110Reviews
        );

        ArrayList<Section> cis1050Sections = new ArrayList<Section>();
        cis1050Sections.add(s1_1050);
        ArrayList<Course> cis1050Prereqs = new ArrayList<Course>();
        ArrayList<Course> cis1050Restrictions = new ArrayList<Course>();
        ArrayList<CourseReview> cis1050Reviews = new ArrayList<CourseReview>();
        cis1050Reviews.add(review1050);

        Course C1050 = new Course(
            "CIS1050",
            new HashMap<Student, Section>(),
            cis1050Sections,
            cis1050Prereqs,
            "1:00pm",
            754.23,
            "Winter",
            0.50,
            "Course about web development",
            cis1050Restrictions,
            cis1050Reviews
        );


        // );
        CourseCatalog courseCatalog = new CourseCatalog(new Date(1680555562));
        courseCatalog.addCourse(C2750);
        courseCatalog.addCourse(C3750);
        courseCatalog.addCourse(C3490);
        courseCatalog.addCourse(C3110);
        courseCatalog.addCourse(C1050);
        
        Address addressOne = new Address("Canada", "Ontario", "Newport", "23", "N45 8A4"); 

        PersonalInfo personalOne = new PersonalInfo("Jane", "322-123-5933", "jane@gmail.com", addressOne, "492-132-6945");
        Student studentOne = new Student("John", "J", "Doe", 1234567, 1, "john@uoguelph.ca", 4.0, "Computer Science", null, 0, true, 0, null, null, personalOne);
        // System.out.println(studentOne.toString());
        //Main event loop
        int choice = 1;
        while(choice != 9)
        {
            System.out.println("Degree Management Subsystem\n");
             
            System.out.println("1. Register for a course"); 
            System.out.println("2. Deregister from course"); 
            System.out.println("3. Plan Future Semesters"); 
            System.out.println("4. Update personal information"); 
            System.out.println("5. Add course review"); 
            System.out.println("6. Pay Tuition & Fees"); 
            System.out.println("7. Request a refund"); 
            System.out.println("8. Declare minor");
            System.out.println("9. Exit");
             
            Scanner myObj = new Scanner(System.in);  // Create a Scanner object
            System.out.print("Please make a selection (1-9): ");
            
            boolean isValid = true;

            do
            {
                if (!myObj.hasNextInt())
                {
                    myObj.next();
                    isValid = false;
                }
                else
                {
                    choice = myObj.nextInt();
                    isValid = choice >= 1 && choice <= 9;
                }

                if (!isValid)
                {
                    System.out.print("Invalid input: please try again");
                    System.out.print("Please make a selection (1-9): ");
                }
            } while (!isValid);

            if (choice == 1)
            {

                System.out.println("Current Course Offerings"); 
                courseCatalog.listCourses();
                System.out.print("Enter a course code: "); 

                String courseCodeInput = "";
                do
                {
                    courseCodeInput = myObj.next();
                    myObj.nextLine();

                    isValid = courseCatalog.searchCatalog(courseCodeInput) != null;
    
                    if (!isValid)
                    {
                        System.out.print("Please enter a valid course code: ");
                    }
                } while (!isValid);

                studentOne.registerCourse(courseCatalog, courseCodeInput);
            }
            else if (choice == 2)
            {
                //Deregister for a course
            }
            else if (choice == 3)
            {
                //plan future semesters
            }
            else if (choice == 4)
            {
                studentOne.updatePersonalInfo();
            }
            else if (choice == 5)
            {
                //add course review
            }
            else if (choice == 6)
            {
                // pay
            }
            else if (choice == 7)
            {
                //request a refund
            }
            else if (choice == 8)
            {
                //declare a minor
            }

        }



	}
}