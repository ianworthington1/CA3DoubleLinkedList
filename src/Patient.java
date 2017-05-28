
public class Patient implements iPatient {

	public String firstname;
	public String lastname;
	public int Age;
	public String nextOfKin;		
	public String symptoms;
	public int priority;
	
	private String treatment;
	
	public Patient(String fname, String lname, String symptoms, int age, String nextOfKin){
		this.firstname = fname;
		this.lastname = lname;
		this.Age = age;
		this.nextOfKin = nextOfKin;
		this.symptoms = symptoms;
		this.priority = 0;
	}


	public String getTreatment() {
		return treatment;
	}

	public void setTreatment(String treatment) {
		this.treatment = treatment;
	}
	
}