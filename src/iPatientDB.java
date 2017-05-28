
public interface iPatientDB {

	public void insert(String fName, String lName, int age, String nextOfKin, String symptoms);
	public void addTreatment(String treatment, String fName, String lName);
	public void closeConnection();
	
}
