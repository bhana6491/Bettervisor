import java.util.ArrayList;
import java.util.Date;

public class Section{

    private int sectionID;
    private int emptySeats;
    private int maxSeats;
    private ArrayList<Student> waitlist;
    private String lectureTime;
    private String labTime; 

    Section(int sectionID, int emptySeats, int maxSeats, ArrayList<Student> waitlist, String lectureTime, String labTime)
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
        waitlist.add(student); 
        return "Student has been added to waitlist"; 
    }
    public Student popFromWaitlist()
    {
        //Don't know if this'll work depending on how objects are stored
        int n = waitlist.size()-1;
        Student popped = waitlist.get(n); 
        waitlist.remove(n); 
        return popped;
    }
    public boolean isFull()
    {
        return emptySeats == 0; 
    }
    public String updateSection(int numSeats)
    {
        emptySeats = emptySeats + numSeats; 
        return "Section Seats have been updated";
    }
    public String toString()
    {
        return "Section ID: " + sectionID + "\n" + "Empty Seats: " + emptySeats + "\n" + "Lec Time: " + lectureTime + "\n" + "Lab Time: " + labTime + "\n";
    }

    public int getSectionID()
    {
        return sectionID; 
    }

}
