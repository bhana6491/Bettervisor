public class Counselor extends Person {
    
    private int employeeID;
    private String faculty;
    private String primaryEmail;

    Counselor(String firstName, String preferredName, String lastName, int employeeID, String faculty, String primaryEmail)
    {
        super(firstName, preferredName, lastName);
        this.employeeID = employeeID;
        this.faculty = faculty; 
        this.primaryEmail = primaryEmail; 
    }
	public static void main(String[] args){

		Counselor myCounselor = new Counselor("Gregory", "Greg", "Klotz", 11123,"Computing", "gklotz@uoguelph.ca");
		myCounselor.displayName();
	}

    public String makeMinorAppDecision(MinorApp minorApp)
    {
        Student minorAppStudent = minorApp.getStudent(); 

        int eligibility = minorAppStudent.canDeclareMinor(); 

        boolean isValid = true;

        if (eligibility == 1 || eligibility == 2)
        {
            minorApp.setIsApproved(false);
            if (eligibility == 1)
            {
                return "\nCannot declare minor: GPA < 60\n";
            }
            else
            {
                return "\nCannot declare minor: you're in your final semester\n";
            }
        }
        else
        {
            minorApp.setIsApproved(true);
            minorAppStudent.setMinor(minorApp.getMinor());
            return "\nMinor changed from " + minorAppStudent.getMinor() + " to " + minorApp.getMinor() + "!\n"; 
        }
        
    }
    
}
