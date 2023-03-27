import java.util.Date;
import java.time.LocalDate;
public class CourseReview {
    private String courseCode;
    private int rating;
    private String comment;
    private LocalDate reviewDate;

    CourseReview(String courseCode, int rating, String comment)
    {
        this.courseCode = courseCode; 
        this.rating = rating; 
        this.comment = comment;
        this.reviewDate = LocalDate.now(); 
    }
}
