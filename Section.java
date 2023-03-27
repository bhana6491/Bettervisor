import java.util.ArrayList;
import java.util.Date;

public class Section{

    private int sectionID;
    private int emptySeats;
    private int maxSeats;
    private ArrayList<Student> waitlist;
    private Date lectureTime;
    private Date labTime;

    Section(int sectionID, int emptySeats, int maxSeats, ArrayList<Student> waitlist, Date lectureTime, Date labTime)
    {
        this.sectionID = sectionID; 
        this.emptySeats = emptySeats; 
        this.maxSeats = maxSeats; 
        this.waitlist = waitlist; 
        this.lectureTime = lectureTime; 
        this.labTime = labTime;
    }
    public String addToWaitlist(Student student)
    {
        return "Success"; 
    }
    public Student popFromWaitlist()
    {
        return null; 
    }
    public boolean isFull()
    {
        return false; 
    }
    public String updateSection(int numSeats)
    {
        return "Success";
    }
    public String toString()
    {
        return "Success";
    }

}
