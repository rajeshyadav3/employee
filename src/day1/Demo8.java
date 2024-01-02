package day1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

//Update Employee Name, Salary, Gender, EmailId, Password
public class Demo8 {
	public static void main(String[] args) {

		Connection con = null;
		Statement stmt = null;

		System.out.println("Enter Employee Id, Name, Salary, Gender, EmailId, Password");
		Scanner scan = new Scanner(System.in);
		int empid = scan.nextInt();
		String empname = scan.next();
		double salary = scan.nextDouble();
		String gender = scan.next();
		String emailid = scan.next();
		String password = scan.next();
		System.out.println();
		
		String url = "jdbc:mysql://localhost:3306/fsd57";
		
		String updateQuery = "update employee set " + 
		"empName = '" + empname + "', salary = " + salary + ", gender = '" + gender + 
		"', emailId = '" + emailid + "', password = '" + password + "' where empId = " + empid;
				
				
				
		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, "root", "root");

			stmt = con.createStatement();
			int result = stmt.executeUpdate(updateQuery);

			if (result > 0) {
				System.out.println("Employee Record Updated");
			} else {
				System.out.println("Failed to Update the Employee Record!!!");
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
}