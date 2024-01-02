package day1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

//Delete Employee Record
public class Demo9 {
	public static void main(String[] args) {

		Connection con = null;
		Statement stmt = null;

		System.out.print("Enter Employee Id: ");
		int empid = new Scanner(System.in).nextInt();
		System.out.println();
		
		String url = "jdbc:mysql://localhost:3306/fsd57";
		
		String deleteQuery = "delete from employee where empId = " + empid;				
				
		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, "root", "root");

			stmt = con.createStatement();
			int result = stmt.executeUpdate(deleteQuery);

			if (result > 0) {
				System.out.println("Employee Record Deleted");
			} else {
				System.out.println("Failed to Delete the Employee Record!!!");
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
}