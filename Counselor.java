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
        return "Success";
    }
    
}
