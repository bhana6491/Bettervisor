public class Person {

	private String firstName;
	private String preferredName;
	private String lastName;

	Person(String firstName, String preferredName, String lastName)
	{
		this.firstName = firstName;
		this.lastName = lastName; 
		this.preferredName = preferredName; 
	}

	public void displayName()
	{
		System.out.println(firstName + lastName + preferredName);
	}

	public static void main(String[] args){

		Person myPerson = new Person("Adhyayan", "Eddie", "Bhandari");
		myPerson.displayName();
	
	}
}

