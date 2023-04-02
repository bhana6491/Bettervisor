import java.util.Date;
import java.time.LocalDate;
public class CourseReview {
    private String courseCode;
    private int rating;
    private String comment;
    private int authorID;
    private LocalDate reviewDate;

    CourseReview(String courseCode, int rating, String comment, int authorID)
    {
        this.courseCode = courseCode; 
        this.authorID = authorID; 
        this.rating = rating; 
        this.comment = comment;
        this.reviewDate = LocalDate.now(); 
    }

    public String toString() {
        return "\t" + "Rating: " + rating + "\n" + "\t" + "Comment: " + comment + "\n" + "\t" + "Review Date: " + reviewDate + "\n";
    }

    public int getAuthorID()
    {
        return authorID;
    }
}
