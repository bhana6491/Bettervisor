public class Address {
    private String country;
    private String province;
    private String streetName;
    private String streetNumber;
    private String postalCode;

    Address(String country,String province,String streetName,String streetNumber,String postalCode)
    {
        this.country = country; 
        this.province = province; 
        this.streetName = streetName; 
        this.streetNumber = streetNumber; 
        this.postalCode = postalCode; 
    }
    public String toString()
    {
        return "Country: " + country + "\n" + "\t      " + "Province: " + province + "\n" + "\t      " + "Street Name: " + streetName + "\n" + "\t      " + "Street Number: " + streetNumber + "\n" + "\t      " + "Postal Code: " + postalCode + "\n";
    }
    public void setCountry(String country)
    {
        this.country = country; 
    }
    public void setProvince(String province)
    {
        this.province = province; 
    }
    public void setStreetName(String streetName)
    {
        this.streetName = streetName; 
    }
    public void setStreetNumber(String streetNumber)
    {
        this.streetNumber = streetNumber; 
    }
    public void setPostalCode(String postalCode)
    {
        this.postalCode = postalCode; 
    }
}
