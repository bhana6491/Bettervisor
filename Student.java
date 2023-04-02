import java.util.ArrayList;
import java.util.Scanner;
import java.util.Date;
import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoUnit;

public class Student extends Person {
    private int studentID;
    private int currSemester;
    private String universityEmail;
    private double gpa;
    private String major;
    private String  minor;
    private double balance;
    private boolean isDomestic;
    private double totalCredits;
    private PersonalInfo personalInfo;
    private ArrayList<FutureSemester> futureSchedule;
    private ArrayList<Course> completedCourses;
    private ArrayList<Course> registeredCourses;
 
    Student(String firstName, String preferredName, String lastName, int studentID, int currSemester, String universityEmail, double gpa, String major, String minor, double balance, boolean isDomestic, double totalCredits, ArrayList<Course> completedCourses, ArrayList<Course> registeredCourses, PersonalInfo personalInfo)
    {
        super(firstName, preferredName, lastName);
        this.studentID = studentID;
        this.currSemester = currSemester;
        this.universityEmail = universityEmail; 
        this.gpa = gpa; 
        this.major = major; 
        this.minor = minor; 
        this.balance = balance; 
        this.isDomestic = isDomestic;
        this.totalCredits = totalCredits; 
        this.completedCourses = completedCourses; 
        this.registeredCourses = registeredCourses;
        this.personalInfo = personalInfo; 
        this.futureSchedule = new ArrayList<FutureSemester>();
    }

    public int getStudentID() {
        return studentID;
    }

    public ArrayList<Course> getCompletedCourses() {
        return completedCourses;
    }

   public String applyMinor(Counselor counselor, String minor)
    {
        //instantiating a minor app
        MinorApp minorApp = new MinorApp(this, minor);
        return counselor.makeMinorAppDecision(minorApp); 

    }
    public String hasExamConflict(Course course)
    {
        for (Course c: registeredCourses)
        {
            if (c.getExamTime().equals(course.getExamTime()))
            {
                return "Cannot register for " + course.getCourseCode() + ", exam time conflict with " + c.getCourseCode() + "!";
            }
        }
        return null; 
    }
    public String registerCourse(CourseCatalog catalog, String courseCode)
    {

        Course course = catalog.searchCatalog(courseCode); 

        if (registeredCourses.contains(course))
        {
            return "\nYou are already registered in this course!\n"; 
        } 
        if (registeredCourses.size() == 5)
        {
            return "\nYou are already registered for 5 courses!\n";
        }

        if (completedCourses.contains(course))
        {
            return "\nYou have already completed this course!\n";
        }

        Section section = course.selectSection(); 

        if (section.isFull() == true)
        {
            section.addToWaitlist(this); 
            return "You have been added to the Section " + section.getSectionID() + " waitlist"; 
        }
        else
        {
            course.addToClassList(this, section); 
            
            section.updateSection(-1); 
            updateBalance(course, true, 1); 
            registeredCourses.add(course); 
            return "\nYou have successfuly registered for " + course.getCourseCode() + " in Section " + section.getSectionID() + "\n" + "Your balance has been updated, current total is: " + String.format("%.2f", balance) + "\n"; 
        }
    }
    
    public String addCourseReview(String courseCode)
    {
        Course c = findCourse(courseCode);
        if (c == null)
        {
            return "Can't review a course that you haven't taken yet";
        }
        else
        {
            createReview(c);
            return "Successfully reviewed course!";
        }
    }

    public String deregisterCourse(String courseCode)
    {

        Course c = searchRegisteredCourses(courseCode);//should always be valid, since we do the check outside as well
        LocalDate startDate = c.getStartDate(); 
        LocalDate dateAfter = LocalDate.now();
        long num_days = ChronoUnit.DAYS.between(startDate, dateAfter);

        double multiplier = 0;

        if (dateAfter.isAfter(startDate))
        {
            if (num_days >=14)//no refund
            {
                System.out.println("You will recieve 0% refund for " + c.getCourseCode()); 
                multiplier = 0; 
            }
            else if (num_days >=7 && num_days < 14)//50% refund
            {
                System.out.println("You will recieve 50% refund for " + c.getCourseCode()); 
                multiplier = 0.5; 
            }
            else if (num_days < 7)//100% refund 
            {
                System.out.println("You will recieve 100% refund for " + c.getCourseCode()); 
                multiplier = 1; 
            }
        }
        else
        {
            System.out.println("You will recieve 100% refund for " + c.getCourseCode()); 
            multiplier = 1; 

        }
        Section s = c.searchClassList(this);
        c.removeFromClassList(this, s);
        registeredCourses.remove(c);
        updateBalance(c, false, multiplier);

        return "\nSuccessfully deregistered from " + c.getCourseCode() + "\n" + "Your balance has been updated, current total is: " + String.format("%.2f", balance);
    }

    public String updatePersonalInfo()
    {
        personalInfo.displayPersonalInfo();

        Scanner personalInfoScanner = new Scanner(System.in);  // Create a Scanner object
        System.out.print("What information would you like to update? (1-5): ");
        int personalInfoChoice = 0;
        boolean isValid = true;
        do
        {
            if (!personalInfoScanner.hasNextInt())
            {
                personalInfoScanner.next();
                isValid = false;
            }
            else
            {
                personalInfoChoice = personalInfoScanner.nextInt();
                isValid = personalInfoChoice >= 1 && personalInfoChoice <= 5;
            }

            if (!isValid)
            {
                System.out.print("Invalid input: please try again");
                System.out.print("Please make a selection (1-5): ");
            }
        } while (!isValid);
        if (personalInfoChoice == 1)
        {
            boolean inputValid = true;
            do 
            {
                String input = "";
                System.out.print("Enter new value for ecFirstName: ");
                input = personalInfoScanner.next();
                String pattern = "^[a-zA-Z]*$";
                if (!input.matches(pattern)) 
                {
                    System.out.println("Invalid format for first name");
                    inputValid = false;
                }
                else
                {
                    personalInfo.setEcFirstName(input);
                    personalInfo.displayPersonalInfo();
                    inputValid = true;
                }
            } while (!inputValid);
        }
        else if (personalInfoChoice == 2)
        {
            boolean inputValid = true;
            do 
            {
                String input = "";
                System.out.print("Enter new value for ecNumber: ");
                input = personalInfoScanner.next();
                String pattern = "\\d{10}|(?:\\d{3}-){2}\\d{4}|\\(\\d{3}\\)\\d{3}-?\\d{4}";
                if (!input.matches(pattern)) 
                {
                    System.out.println("Invalid format for phone number");
                    inputValid = false;
                }
                else
                {
                    personalInfo.setEcNumber(input);
                    personalInfo.displayPersonalInfo();
                    inputValid = true;
                }
            } while (!inputValid);
        }
        else if (personalInfoChoice == 3)
        {
            boolean inputValid = true;
            do
            {
                String input = "";
                System.out.print("Enter new value for ecEmail: ");
                input = personalInfoScanner.next();
                String pattern = "^(.+)@(.+)$";
                if (!input.matches(pattern)) 
                {
                    System.out.println("Invalid format for email address");
                    inputValid = false;
                }
                else
                {
                    personalInfo.setEcEmail(input);
                    personalInfo.displayPersonalInfo();
                    inputValid = true;
                }
            } while (!inputValid);
        }
        else if (personalInfoChoice == 4)
        {
            boolean inputValid = true;
            do
            {
                String input = "";
                System.out.print("Enter new value for Personal Number: ");
                input = personalInfoScanner.next();
                String pattern = "^\\d{10}$";
                if (!input.matches(pattern)) 
                {
                    System.out.println("Invalid format for phone number");
                    inputValid = false;
                }
                else
                {
                    personalInfo.setPersonalNumber(input);
                    personalInfo.displayPersonalInfo();
                    inputValid = true;
                }
            } while (!inputValid);
        }
        else if (personalInfoChoice == 5)
        {
            boolean inputValid = true;
            do
            {
                String countryInput = "";
                String proviceInput = "";
                String streetNameInput = "";
                String streetNumberInput = "";
                String postalInput = "";

                String countryPattern = "^[a-zA-Z]*$";
                String numberPattern = "\\d+";
                String postalPattern = "^(?!.*[DFIOQU])[A-VXY][0-9][A-Z] ?[0-9][A-Z][0-9]$";

                while (true)
                {
                    System.out.print("Enter new value for Country: ");
                    countryInput = personalInfoScanner.next();
                    if (countryInput.matches(countryPattern))
                    {
                        break;
                    }    
                }
                
                while (true)
                {
                    System.out.print("Enter new value for Province: ");
                    proviceInput = personalInfoScanner.next();
                    if (proviceInput.matches(countryPattern))
                    {
                        break;
                    }    
                }
                
                while (true)
                {
                    System.out.print("Enter new value for Street Name: ");
                    streetNameInput = personalInfoScanner.next();
                    if (streetNameInput.matches(countryPattern))
                    {
                        break;
                    }    
                }

                while (true)
                {
                    System.out.print("Enter new value for Street Number: ");
                    streetNumberInput = personalInfoScanner.next();
                    if (streetNumberInput.matches(numberPattern))
                    {
                        break;
                    }    
                }

                while (true)
                {
                    System.out.print("Enter new value for Postal Code: ");
                    postalInput = personalInfoScanner.next();
                    if (postalInput.matches(postalPattern))
                    {
                        break;
                    }    
                }
                personalInfo.setEcAddress(countryInput, proviceInput, streetNameInput, streetNumberInput, postalInput);
            } while (!inputValid);
        }
        return "SUCCESS";
    }
    public void updateBalance(Course course, boolean addMinusCost, double multiplier)
    {
        if (addMinusCost == true)
        {
            balance = balance + course.getCost();
        }
        else
        {
            balance = balance - (course.getCost() * multiplier); 
        }
    }
    public String payBalance()
    {
        Scanner paymentScanner = new Scanner(System.in);  

        boolean isValid = true;
        double pay = 0;
        System.out.print("Please enter the amount you'd like to pay: "); 
        do
        {
            if (!paymentScanner.hasNextDouble())
            {
                paymentScanner.next();
                isValid = false;
            }
            else
            {
                pay = paymentScanner.nextDouble();
                if (pay > 0) {
                    isValid = true;
                } 
            }
            
            if (!isValid)
            {
                System.out.print("Invalid input: please try again");
                System.out.print("Please enter a valid amount ");
            }
        } while (!isValid);

        this.balance = this.balance - pay;

        System.out.println("\nPayment Complete!\nNew total is " + "$" + String.format("%.2f", balance));
        return "SUCCESS";
    }
    public Course findCourse(String courseCode)
    {
        boolean found = false;
        for (Course c : completedCourses)
        {
            if (c.getCourseCode().equals(courseCode))
            {
                found = true;
                return c;
            }
        }
        if (found == false)
        {
            System.out.println("Could not find course");
        }
        return null;
    }
    private void createReview(Course course)
    {
        ArrayList<String> profanityList = new ArrayList<>();
        profanityList.add("profanity1");
        profanityList.add("profanity2");
        profanityList.add("profanity3");

        Scanner courseReviewScanner = new Scanner(System.in);  // Create a Scanner object
        int ratingInput = 0;
        String commentInput = "";
        boolean isValid = true;
        while (true)
        {
            System.out.print("Enter a rating [1-5]: ");
            ratingInput = courseReviewScanner.nextInt();
            courseReviewScanner.nextLine();
            if (ratingInput >=1 && ratingInput <= 5)
            {
                break; 
            }
        }

        do
        {
            isValid = true;
            System.out.print("Enter an optional comment: ");
            commentInput = courseReviewScanner.nextLine();
            String[] words = commentInput.split("\\s+");

            if(words.length > 10)
            {
                System.out.println("Your comment cannot be over 10 words");
                isValid = false; 
            }

            for (String word : words)
            {
                if (profanityList.contains(word))
                {
                    System.out.println("You cannot have profanity in your comment");
                    isValid = false;
                }
            }
        } while (!isValid);
        
        CourseReview cr = new CourseReview(course.getCourseCode(), ratingInput, commentInput, studentID);
        course.publishCourseReview(cr);
        System.out.println(course.toString());
    }
    public Course searchRegisteredCourses(String courseCode)
    {
        for (Course c: registeredCourses)
        {
            if (c.getCourseCode().equals(courseCode))
            {
                return c;
            }
        }
        return null; 
    }
    public String requestRefund(double amount)
    {
        if(isEligible() == true)
        {
            if (!isDomestic)
            {
                this.balance = deductFee(amount);
            }
            System.out.println("\nEnter Bank Details:\n");
            getBankDetails(); 
            return giveRefund(amount); 
        }
        else
        {
            return "\nYou are not eligible for a refund\n"; 
        }
    }
    public boolean isEligible()
    {
        if (!isDomestic && currSemester <= 2)
        {
            return false; 
        } 
        return true; 
    }
    private double deductFee(double amount)
    {
        return balance + amount;//adding to a -ve number = reducing refund amount
    }
    public String getBankDetails()
    {
        String bankNamePattern = "^[a-zA-Z ]*$";
        String branchPattern = "^\\d{4}$";
        String transitPattern = "^\\d{3}$";


        String bankName = ""; 
        String branchNumber = ""; 
        String transitNumber = "";

        Scanner bankingScanner = new Scanner(System.in);  // Create a Scanner object

        //valid bank name
        while (true)
        {
            System.out.print("Enter Bank Name: ");
            bankName = bankingScanner.nextLine();
            if (bankName.matches(bankNamePattern))
            {
                break;
            }    
        }
        
        //valid branch number
        while (true)
        {
            System.out.print("Enter branch number(4 digits): ");
            branchNumber = bankingScanner.next();
            if (branchNumber.matches(branchPattern))
            {
                break;
            }    
        }
        //valid transit number
        while (true)
        {
            System.out.print("Enter transit number(3 digits): ");
            transitNumber = bankingScanner.next();
            if (transitNumber.matches(transitPattern))
            {
                break;
            }    
        }
        return "\nBank Name: " + bankName + "\nBranch Number: " + branchNumber + "\nTransit Number: " + transitNumber;

    }
    public String giveRefund(double amount)
    {
        balance = balance + amount;
        return "\nYour request has been processed\nCurrent balance is: " + String.format("%.2f", balance); 
    }
    public void setMinor(String minor)
    {
        this.minor = minor;
    }
    public double getBalance()
    {
        return this.balance; 
    }
    public String getMinor()
    {
        return this.minor; 
    }
    public int listRegisteredCourses()
    {
        for (Course c: registeredCourses)
        {
            System.out.println("Course Code: " + c.getCourseCode()); 
        }
        
        if (registeredCourses.size() == 0)
        {
            System.out.println("You are currently registered in 0 courses\n");
        }
        return registeredCourses.size(); 
    }
    public String payTuition(CourseCatalog catalog)
    {
       double total = 0;
       if (catalog.isPastDeadline(new Date())) {
            System.out.println("You are past the deadline, deregistering from all courses!");
            while (registeredCourses.size() > 0) {
                deregisterCourse(registeredCourses.get(0).getCourseCode());
            }
            
       }

        System.out.println("FINANCIAL REPORT:");
        for (Course toCheck : registeredCourses) {
            System.out.println(toCheck.getCourseCode() + ": $" + toCheck.getCost());
            total += toCheck.getCost();
        }
        System.out.println("------------------------");
        System.out.println("Semester Bill: $" + String.format("%.2f", total));
        System.out.println("Remaining Balance: $" + String.format("%.2f", balance));

        if (balance <= 0)
        {
            return "Cannot make payment you don't owe anything";
        }

        return payBalance();

    }

    public String createFutureSemester(CourseCatalog catalog, int year, String season)
    {
        Scanner inputSc = new Scanner(System.in);
        if (currSemester == 8) {
            return "Ineligible to add future semester: Student is on their last semester";
        }

        FutureSemester futureSem = new FutureSemester(year, season);

        String addCourse = "y";
        while (addCourse.equals("y")) {
            boolean isValid = true;
            String courseCode = "";
            Course courseToPlan = null;

            System.out.println("\nCurrent Course Offerings:"); 
            System.out.println("--------------------------\n");
            catalog.listCourses();

            System.out.print("Specify the the course code of the course you want to add to your future semester: ");
            do
            {
                courseCode = inputSc.next();
                inputSc.nextLine();
                
                courseToPlan = catalog.searchCatalog(courseCode);
                isValid = courseToPlan != null;

                if (!isValid)
                {
                    System.out.println("Please enter a valid course code.");
                    System.out.print("Specify the the course code of the course you want to add to your future semester: ");
                }
            } while (!isValid);
            
            if (futureSem.courseExists(courseToPlan)) {
                System.out.println("Ineligile to plan course: Student has already planned the selected course");
            }
            else {
                futureSem.addCourseToPlan(courseToPlan);
                if (futureSem.getNumPlanned() >= 5) {
                    break;
                }
            }

            System.out.print("Continue planning courses? (y/n): ");
            do
            {
                addCourse = inputSc.next();
                inputSc.nextLine();
                isValid = addCourse.equals("y") || addCourse.equals("n");

                if (!isValid)
                {
                    System.out.println("Invalid option");
                    System.out.print("Continue planning courses? (y/n): ");
                }
            } while (!isValid);
        }

        addFutureSemester(futureSem);
        System.out.println("Created future semester:");
        System.out.println(futureSem.toString());

        return "Successfully created a future semester!";
    }

    public void addFutureSemester(FutureSemester futureSemester)
    {
        futureSchedule.add(futureSemester); 

    }
    public boolean searchCompletedCourses(String courseCode)
    {
        for (Course c: completedCourses)
        {
            if (c.getCourseCode() == courseCode)
            {
                return true; 
            }
        } 
        return false; 
    }
    public int canDeclareMinor()
    {
        if (gpa < 60)
        {
            return 1;
        }
        else if(currSemester == 8)
        {
            return 2;
        }
        else
        {
            return 0; 
        }
    }
}
