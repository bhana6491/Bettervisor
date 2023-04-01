public class PersonalInfo {
    private String ecFirstName;
    private String ecNumber;
    private String ecEmail;
    private Address ecAddress;
    private String personalNumber;

    PersonalInfo(String ecFirstName,String ecNumber,String ecEmail,Address ecAddress,String personalNumber)
    {
        this.ecFirstName = ecFirstName; 
        this.ecNumber = ecNumber; 
        this.ecEmail = ecEmail; 
        this.ecAddress = ecAddress; 
        this.personalNumber = personalNumber;
    }
    public void displayPersonalInfo()
    {
        System.out.println("\nCurrent Personal Information");
        System.out.println("--------------------------\n");

        System.out.println("1. ecFirstName: " + ecFirstName + "\n" + "2. ecNumber: " + ecNumber + "\n" + "3. ecEmail: " + ecEmail + "\n" + "4. Personal Number: " + personalNumber + "\n" + "5. ecAddress: " + ecAddress.toString());
    }
    public void setEcFirstName(String ecFirstName)
    {
        this.ecFirstName = ecFirstName;
    }
    public void setEcNumber(String ecNumber)
    {
        this.ecNumber = ecNumber; 
    }
    public void setEcEmail(String ecEmail)
    {
        this.ecEmail = ecEmail; 
    }
    public void setEcAddress(String country,String province,String streetName,String streetNumber,String postalCode)
    {
        ecAddress.setCountry(country); 
        ecAddress.setProvince(province);
        ecAddress.setStreetName(streetName);
        ecAddress.setStreetNumber(streetNumber);
        ecAddress.setPostalCode(postalCode);
    }
    public void setPersonalNumber(String personalNumber)
    {
        this.personalNumber = personalNumber; 
    }

}
