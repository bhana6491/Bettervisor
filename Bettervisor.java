import java.util.ArrayList;
public class Bettervisor {

    public static void main(String[] args){

        // Course C3750 = new Course();
        // Course C2750 = new Course();
        // Course C3490 = new Course();
        // Course C3110 = new Course();
        // Course C1050 = new Course(); 

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
        Section s2_3490 = new Section(6, 20, 100, new ArrayList<Student>(), "Tues, Thurs 9am-10am", "Wed 1pm-2pm");
        Section s1_3110 = new Section(7, 20, 100, new ArrayList<Student>(), "Tues, Thurs 9am-10am", "Wed 1pm-2pm");
        Section s2_3110 = new Section(8, 20, 100, new ArrayList<Student>(), "Tues, Thurs 9am-10am", "Wed 1pm-2pm");
        Section s1_1050 = new Section(9, 20, 100, new ArrayList<Student>(), "Tues, Thurs 9am-10am", "Wed 1pm-2pm");
        
        Course C3750 = new Course(
            "CIS*3750",
            new HashMap<Student, Section>(),
            new ArrayList<Section>(){
                new Section(
                    1,
                    100,
                    100,
                    
                )
            }
        )e [First N
	}

    
}

Section s1_2750 = new Section(0101, 20, 100, null, "Tues, Thurs 9am-10am", "Wed 1pm-2pm");