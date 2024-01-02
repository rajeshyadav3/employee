package day1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//Fetch Employee Data: select * from employee
public class demo2 {
	public static void main(String[] args) {

		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;

		String url = "jdbc:mysql://localhost:3306/fsd57";
		String query = "Select * from employee1";

		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, "root", "root");

			stmt = con.createStatement();
			rs = stmt.executeQuery(query);

			while (rs.next()) {
				System.out.println("EmpId   : " + rs.getInt(1));
				System.out.println("EmpName : " + rs.getString("empname"));
				System.out.println("Salary  : " + rs.getDouble(3));
				System.out.println("Gender  : " + rs.getString("gender"));
				System.out.println("EmailId : " + rs.getString(5));
				System.out.println("Password: " + rs.getString(6) + "\n");
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
}
