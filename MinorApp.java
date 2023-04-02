public class MinorApp{
    private Student student;
    private String minor;
    private boolean isApproved;
     
    MinorApp(Student student,String minor)
    {
        this.student = student; 
        this.minor = minor; 
    }
    public Student getStudent()
    {
        // Have to return the copy of the student
        return this.student; 
    }
    public String getMinor()
    {
        return minor; 
    }
    public void setIsApproved(boolean isApproved)
    {
        this.isApproved = isApproved; 
    }
}
