package day1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

//Insert Employee Record
public class Demo6 {
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
		
		String insertQuery = "insert into employee values " + 
		"(" + empid + ", '" + empname + "', " + salary + ", '" + gender + 
		"', '" + emailid + "', '" + password + "')";
		
		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, "root", "root");

			stmt = con.createStatement();
			int result = stmt.executeUpdate(insertQuery);

			if (result > 0) {
				System.out.println("Employee Record Inserted");
			} else {
				System.out.println("Failed to Insert the Employee Record!!!");
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
}
 

