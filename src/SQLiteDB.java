import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SQLiteDB implements iPatientDB {
	
	Connection c = null;
	PreparedStatement stmt = null;
	
	public SQLiteDB(){ // create the connection for the database
		try {
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:PatientMedHistory.sqlite");
			System.out.println("We're connected!!");	// confirmation of connection
			
		}
		catch (Exception e) {
			System.err.println(e.getClass().getName()
			+ ": " + e.getMessage());
			System.exit(0);
		}
	}
	
	public void insert(String fName, String lName, int age, String nextOfKin, String symptoms){ // add an Patient object to the databasee
		
		String sql = "INSERT INTO PatientMedHistory (fName, lName, age, nextOfKin, symptoms) VALUES (?, ?, ?, ?, ?)";
		
		try { // here the string sql values are converted to match the values of parameters passed in
			stmt = c.prepareStatement(sql);
			stmt.setString(1, fName);
			stmt.setString(2, lName);
			stmt.setInt(3, age);
			stmt.setString(4, nextOfKin);
			stmt.setString(5, symptoms);
			stmt.executeUpdate(); // runs the update
			
		} catch (SQLException e) {
			System.out.println("Create Error: " + e.getMessage());
			e.printStackTrace();
		}
	}
	
	public void addTreatment(String treatment, String fName, String lName){ // update the database entry to add an additional value
		String sql = "UPDATE PatientMedHistory SET treatment = ?" +
				"WHERE fName = ? AND " + 
				"lName = ?";
		
		try {
			stmt = c.prepareStatement(sql); // here the string sql values are converted to match the values of parameters passed in
			stmt.setString(1, treatment);
			stmt.setString(2, fName);
			stmt.setString(3, lName);
			stmt.executeUpdate(); // runs the update
			
		} catch (SQLException e) {
			System.out.println("Update Error: " + e.getMessage());
			e.printStackTrace();
		}
	}
	
	
	public void closeConnection(){ // closes the connection
		try {
			c.close();
		} catch (SQLException e) {
			System.out.println("Error: " + e.getMessage());
			e.printStackTrace();
		}
	}

}
