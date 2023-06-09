import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Scanner;
import java.lang.Math;
import java.time.LocalDate;
import java.time.Month;

public class Bettervisor {
    public static void main(String[] args){

        //Course review initializations
        CourseReview review2750 = new CourseReview("CIS2750", 1, "Not fun", 122343);
        CourseReview review3750 = new CourseReview("CIS3750", 5, "Very enjoyable course", 234242);
        CourseReview review3490 = new CourseReview("CIS3490", 3, "Very cool", 342334);
        CourseReview review3110 = new CourseReview("CIS3110", 5, "Great fun", 847598);
        CourseReview review1050 = new CourseReview("CIS1050", 5, "Web Development is cool", 347432); 

        Student studentTwo = new Student("Joseph", "Joe", "Den", 5673492, 3, "joseph@uoguelph.ca", 60, "Computer Science", "ECON", 0, true, 0, null, new ArrayList<Course>(), null);

        ArrayList<Student> s1_3750Waitlist = new ArrayList<Student>();
        
        //adding studentTwo to waitlist
        s1_3750Waitlist.add(studentTwo); 

        Section s1_2750 = new Section(1, 0, 100, new ArrayList<Student>(), "Tues, Thurs 9am-10am", "Wed 1pm-2pm");
        Section s2_2750 = new Section(2,20, 100, new ArrayList<Student>(), "Tues, Thurs 9am-10am", "Fri 1pm-2pm");
        Section s1_3750 = new Section(3, 1, 100, s1_3750Waitlist, "Mon, Wed, Fri 8am-9:30am", "Wed 11am-12pm");
        Section s2_3750= new Section(4, 20, 100, new ArrayList<Student>(), "Mon, Wed, Fri 8am-9:30am", "Mon 3pm-4pm");
        Section s1_3490 = new Section(5, 20, 100, new ArrayList<Student>(), "Tues, Thurs 2pm-3:30pm", "Wed 1pm-2pm");
        Section s2_3490 = new Section(6, 20, 100, new ArrayList<Student>(), "Tues, Thurs 4pm-6pm", "Wed 1pm-2pm");
        Section s1_3110 = new Section(7, 20, 100, new ArrayList<Student>(), "Mon, Wed, Fri 8:30am-10:50pm", "Wed 1pm-2pm");
        Section s2_3110 = new Section(8, 20, 100, new ArrayList<Student>(), "Mon, Wed, Fri 8:30am-10:50pm", "Tuesday 3pm-5pm");
        Section s1_1050 = new Section(9, 20, 100, new ArrayList<Student>(), "Tues, Thurs 11am-1pm", "Fri 2pm-3pm");
        Section s1_3370 = new Section(9, 20, 100, new ArrayList<Student>(), "Tues, Thurs 11am-1pm", "Fri 2pm-3pm");

        //Course initializations
        // To test refund amount, manipulate start date. For now, it will be 100% refund
        ArrayList<Section> cis2750Sections = new ArrayList<Section>();
        cis2750Sections.add(s1_2750);
        cis2750Sections.add(s2_2750);
        ArrayList<CourseReview> cis2750Reviews = new ArrayList<CourseReview>();
        cis2750Reviews.add(review2750);
        Course C2750 = new Course(
            "CIS2750",
            new HashMap<Student, Section>(),
            cis2750Sections,
            "Friday, April 7, 8:30am-10:30am",
            754.23,
            "Winter",
            0.75,
            "Course about creating a application",
            cis2750Reviews,
            LocalDate.of(2023, Month.APRIL, 2)
        );

        ArrayList<Section> cis3750Sections = new ArrayList<Section>();
        cis3750Sections.add(s1_3750);
        cis3750Sections.add(s2_3750);
        ArrayList<CourseReview> cis3750Reviews = new ArrayList<CourseReview>();
        cis3750Reviews.add(review3750);


        Course C3750 = new Course(
            "CIS3750",
            new HashMap<Student, Section>(),
            cis3750Sections,
            "Monday, April 10, 1:00pm-2:00pm",
            600.99,
            "Winter",
            0.75,
            "Course about software development process",
            cis3750Reviews,
            LocalDate.of(2023, Month.APRIL, 2)
        );

        ArrayList<Section> cis3490Sections = new ArrayList<Section>();
        cis3490Sections.add(s1_3490);
        cis3490Sections.add(s2_3490);
        ArrayList<CourseReview> cis3490Reviews = new ArrayList<CourseReview>();
        cis3490Reviews.add(review3490);

        Course C3490 = new Course(
            "CIS3490",
            new HashMap<Student, Section>(),
            cis3490Sections,
            "Monday, April 10, 1:00pm-2:00pm",
            500.00,
            "Winter",
            0.50,
            "Course about algorithms",
            cis3490Reviews,
            LocalDate.of(2023, Month.APRIL, 2)
        );

        ArrayList<Section> cis3110Sections = new ArrayList<Section>();
        cis3110Sections.add(s1_3110);
        cis3110Sections.add(s2_3110);
        ArrayList<CourseReview> cis3110Reviews = new ArrayList<CourseReview>();
        cis3110Reviews.add(review3110);

        Course C3110 = new Course(
            "CIS3110",
            new HashMap<Student, Section>(),
            cis3110Sections,
            "Friday, April 14, 8:30am-10:30am",
            754.23,
            "Winter",
            0.50,
            "Course about operating systems",
            cis3110Reviews,
            LocalDate.of(2023, Month.APRIL, 2)
        );

        ArrayList<Section> cis1050Sections = new ArrayList<Section>();
        cis1050Sections.add(s1_1050);
        ArrayList<CourseReview> cis1050Reviews = new ArrayList<CourseReview>();
        cis1050Reviews.add(review1050);

        Course C1050 = new Course(
            "CIS1050",
            new HashMap<Student, Section>(),
            cis1050Sections,
            "Tuesday, April 11, 10:30am-12:30pm",
            754.23,
            "Winter",
            0.50,
            "Course about web development",
            cis1050Reviews,
            LocalDate.of(2023, Month.MARCH, 21)
        );

        ArrayList<Section> phil3370Sections = new ArrayList<Section>();
        phil3370Sections.add(s1_3370);
        ArrayList<CourseReview> phil3370Reviews = new ArrayList<CourseReview>();

        Course P3370 = new Course(
            "PHIL3370",
            new HashMap<Student, Section>(),
            phil3370Sections,
            "Wednesday, April 12, 10:30am-12:30pm",
            754.23,
            "Winter",
            0.50,
            "Course about philosophy",
            phil3370Reviews,
            LocalDate.of(2023, Month.APRIL, 2)
        );

        ArrayList<Course> regiCourse = new ArrayList<Course>(); 
        ArrayList<Course> compCourse = new ArrayList<Course>(); 
        compCourse.add(P3370);
        HashMap<Student, Section> classList = new HashMap<Student, Section>(); 
        Address addressOne = new Address("Canada", "Ontario", "Newport", "23", "N45 8A4"); 

        PersonalInfo personalOne = new PersonalInfo("Jane", "322-123-5933", "jane@gmail.com", addressOne, "492-132-6945");


        //For Minor alt flows
        //1) Change gpa < 60
        //2) Change currSemester=8(student is in their final semester)

        //For Refund alt flows
        //1) Change isDomestic to true and currSemester to 1
        Student studentOne = new Student("John", "J", "Doe", 1234567, 1, "john@uoguelph.ca", 80, "Computer Science", "Undeclared", -600, true, 0, compCourse, regiCourse, personalOne);
        
        //Initializing Counselor
		Counselor counselorOne = new Counselor("Gregory", "Greg", "Klotz", 11123,"Computing", "gklotz@uoguelph.ca");

        //Instantiating courseCatalog Object
        //Change Long value to - 1680215967000L, to make new deadline 
        // march 30 - 1680215967000
        // april 10 - 1681166941000
        CourseCatalog courseCatalog = new CourseCatalog(new Date((1681166941000L)));
        //Adding courses to course catalog
        courseCatalog.addCourse(C2750);
        courseCatalog.addCourse(C3750);
        courseCatalog.addCourse(C3490);
        courseCatalog.addCourse(C3110);
        courseCatalog.addCourse(C1050);
        courseCatalog.addCourse(P3370);

        //Add minor to the catalog's minor list
        courseCatalog.addMinorToList("MATH");
        courseCatalog.addMinorToList("PHYSICS");
        courseCatalog.addMinorToList("ECON");
        courseCatalog.addMinorToList("BIOLOGY");
        courseCatalog.addMinorToList("PSYCH");

        

        //Main event loop
        int choice = 1;
        while(choice != 9)
        {
            System.out.println("Degree Management Subsystem");
            System.out.println("--------------------------\n");

            System.out.println("1. Register for a course"); 
            System.out.println("2. Deregister from course"); 
            System.out.println("3. Plan Future Semesters"); 
            System.out.println("4. Update personal information"); 
            System.out.println("5. Add course review"); 
            System.out.println("6. Pay Tuition & Fees"); 
            System.out.println("7. Request a refund"); 
            System.out.println("8. Declare minor");
            System.out.println("9. Exit");
             
            Scanner myObj = new Scanner(System.in);  
            
            System.out.print("Please make a selection (1-9): ");
            
            boolean isValid = true;

            //Getting user's main menu action and validating it
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

            //Register for course
            if (choice == 1)
            {
                System.out.println("\nCurrent Course Offerings:"); 
                System.out.println("--------------------------\n");
                
                courseCatalog.listCourses();
                
                System.out.print("Enter a course code: "); 

                String courseCodeInput = "";
                do
                {
                    courseCodeInput = myObj.next();
                    myObj.nextLine();

                    Course c = courseCatalog.searchCatalog(courseCodeInput);

                    isValid = c != null;

                    if (isValid == true)
                    {
                        String examConflict = studentOne.hasExamConflict(c);
                        if(examConflict != null)
                        {
                            System.out.println(examConflict + "\n");
                            isValid=false; 
                        }
                        else
                        {
                            isValid = true;
                        }
                    }
    
                    if (!isValid)
                    {
                        System.out.print("Please enter a valid course code: ");
                    }
                } while (!isValid);

                System.out.println(studentOne.registerCourse(courseCatalog, courseCodeInput));
            }
            
            //Deregister from course
            else if (choice == 2)
            {
                System.out.println("\nCurrently registered in the following courses:"); 
                System.out.println("------------------------------------------");
                int numCourses = studentOne.listRegisteredCourses();
                if (numCourses != 0)
                {
                    System.out.print("Enter a course code you want to deregister from: "); 

                    String courseCodeInput = "";
                    do
                    {
                        courseCodeInput = myObj.next();
                        myObj.nextLine();

                        isValid = studentOne.searchRegisteredCourses(courseCodeInput) != null;
        
                        if (!isValid)
                        {
                            System.out.print("Please enter a valid course code: ");
                        }
                    } while (!isValid);
                    System.out.println(studentOne.deregisterCourse(courseCodeInput));
                }

            }
            else if (choice == 3)
            {
                int year = 0;
                String season = "";

                System.out.print("Specify the year of the future semester: ");
                do
                {
                    if (!myObj.hasNextInt())
                    {
                        myObj.next();
                        isValid = false;
                    }
                    else
                    {
                        year = myObj.nextInt();
                        isValid = true;
                    }
                    
                    if (!isValid)
                    {
                        System.out.println("Invalid input: please try again");
                        System.out.print("Specify the year of the future semester: ");
                    }
                } while (!isValid);

                System.out.print("Specify the season of the future semester (Fall/Winter/Summer): ");
                do
                {
                    season = myObj.next();
                    isValid = season.equals("Fall") || season.equals("Winter") || season.equals("Summer");
                    
                    if (!isValid)
                    {
                        System.out.println("Invalid input: please try again");
                        System.out.print("Specify the season of the future semester (Fall/Winter/Summer): ");
                    }
                } while (!isValid);
                                                                        
                studentOne.createFutureSemester(courseCatalog, year, season);
            }
            else if (choice == 4)
            {
                studentOne.updatePersonalInfo();
            }
            else if (choice == 5)
            {
                String courseCodeInput = "";
                Course courseValid = null;
                boolean hasReviewed;
                do
                {
                    System.out.println("\n Completed Courses:"); 
                    System.out.println("-----------------------------------");
    
                    //listing completed courses
                    for (Course c: studentOne.getCompletedCourses())
                    {
                        System.out.println(c.toString()); 
                    }
                    System.out.print("\nSelect course to add review for: "); 

                    courseCodeInput = myObj.next();

                    myObj.nextLine();

                    courseValid = studentOne.findCourse(courseCodeInput);
                        
                } while (courseValid == null);
                hasReviewed = courseValid.hasReviewedCourse(studentOne.getStudentID());
                if (hasReviewed) {
                    System.out.println("You cannot submit another review for this course");
                }
                else
                {
                    System.out.println(studentOne.addCourseReview(courseCodeInput));
                }
            }
            else if (choice == 6)
            {
                System.out.println(studentOne.payTuition(courseCatalog));
            }
            else if (choice == 7)
            {
                double balance = studentOne.getBalance();
                if (balance >= 0)
                {
                    System.out.println("You are not eligible for refund, current balance is: " + balance); 
                }
                else
                {
                    System.out.println("Current balance is: " + balance); 
                    System.out.print("How much would you like to refund: "); 
                    double refundAmount = 0; 
                    do
                    {
                        if (!myObj.hasNextDouble())
                        {
                            myObj.next();
                            isValid = false;
                        }
                        else
                        {
                            refundAmount = myObj.nextDouble();
                            isValid = refundAmount <= Math.abs(balance);
                        }
                        
                        if (!isValid)
                        {
                            System.out.print("\nPlease select a valid amount to refund: ");
                        }
                    } while (!isValid);

                System.out.println(studentOne.requestRefund(refundAmount));     
                }
            }
            else if (choice == 8)
            {
                System.out.println("Available Minors");
                System.out.println("-----------------");
                courseCatalog.displayMinors();
                System.out.println("\nCurrent Minor: " + studentOne.getMinor()); 
                System.out.print("Please enter a new minor: "); 

                String minorInput = "";
                do
                {
                    minorInput = myObj.next();
                    myObj.nextLine();

                    isValid = courseCatalog.isValidMinor(minorInput) != false;
    
                    if (!isValid)
                    {
                        System.out.print("Please enter a valid minor: ");
                    }
                } while (!isValid);
                System.out.println(studentOne.applyMinor(counselorOne, minorInput)); 
            }
        }
	}
}