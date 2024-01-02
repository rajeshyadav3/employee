package day1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

// Fetch and Display Employee Data, and Insert a New Employee
public class Demo5 {
	public static void main(String[] args) {

		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;

		String url = "jdbc:mysql://localhost:3306/fsd57";
		String query = "SELECT * FROM employee1";

		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, "root", "root");

			stmt = con.createStatement();
			rs = stmt.executeQuery(query);

			while (rs.next()) {
				System.out.println("EmpId   : " + rs.getInt(1));
				System.out.println("EmpName : " + rs.getString("empName"));
				System.out.println("Salary  : " + rs.getDouble(3));
				System.out.println("Gender  : " + rs.getString("gender"));
				System.out.println("EmailId : " + rs.getString(5));

				System.out.println("Password: " + rs.getString(6) + "\n");
			}

			// Insert a new employee
			String insertQuery = "INSERT INTO employee1 VALUES (105, 'Harsha', 1212.12, 'male', 'harsha@email.com', 'password123')";
			int rowsAffected = stmt.executeUpdate(insertQuery);
			System.out.println("Rows affected by insert: " + rowsAffected);

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} 
	}
}
