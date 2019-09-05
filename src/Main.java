import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.Scanner;

import com.mysql.jdbc.ResultSet;
import com.mysql.jdbc.Statement;

public class Main {

	public static void main(String args[]) throws Exception {
		Connection con = null;
		try {

			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver Loaded");

			String url = "jdbc:mysql://localhost:3306/db";
			String user = "root";
			String password = "root";
			con = DriverManager.getConnection(url, user, password);
			System.out.println("Connection Established");


			Scanner scan = new Scanner(System.in);
			ArrayList<Student> stud = new ArrayList<>();

			System.out.println("Choose any among the following options:");
			System.out.println("1. Add Emp");
			System.out.println("2. View All Employees");
			System.out.println("3. Remove an emp");
			System.out.println("4. Delete all records");
			System.out.println("5. Change Salary");
			System.out.println("6. Search Employee");
			System.out.println("7. View dept wise list");
			System.out.println("-----------------------------------");

			int a;
			a = scan.nextInt();
			switch (a) {
			case 1: {
				System.out.println("Enter empno");
				int empno = scan.nextInt();
				System.out.println("Enter emp name");
				String ename = scan.next();
				System.out.println("Enter emp salary");
				int salary = scan.nextInt();
				System.out.println("Enter emp designation");
				String designation = scan.next();
				System.out.println("Enter emp dept");
				String dept = scan.next();

				Statement stmt = con.createStatement();
				String sql = "insert into Emp values(" + empno + ",'" + ename + "'," + salary + ",'" + designation
						+ "','" + dept + "')";
				int k = stmt.executeUpdate(sql);
				if (k > 0) {
					System.out.println("Record Inserted");
				}

				else
					System.out.println("Please Check");

				break;

			}
			case 2: {
				System.out.println("Displaying record of all employees");
				System.out.println("------------------------------------------------------------------------------------------------------");


				Statement stmt = con.createStatement();
				String sql = "select * from Emp";
				ResultSet rs = stmt.executeQuery(sql);
				while (rs.next()) {
					System.out.println("EMPNO  " + rs.getInt(1));
					System.out.println("ENAME  " + rs.getString(2));
					System.out.println("SALARY  " + rs.getInt(3));
					System.out.println("DESIGNATION  " + rs.getString(4));
					System.out.println("DEPT  " + rs.getString(5));
					System.out.println("------------------------------------------------------------------------------------------------------");


				}
				break;

			}
			case 3: {
				Statement stmt = con.createStatement();
				System.out.println("Enter empno for removing its data");
				int d = scan.nextInt();
				String sql = "delete from Emp where(empno=" + d + ")";
				int l = stmt.executeUpdate(sql);
				if (l > 0) {
					System.out.println("record Deleted");

				} else
					System.out.println("Not deleted");
				break;
			}
			case 4: {
				System.out.println("Clearing all data");

				Statement stmt = con.createStatement();
				String sql = "delete from Emp";
				int o = stmt.executeUpdate(sql);
				if (o > 0)
					System.out.println("Employee Table Records Deleted");
				else
					System.out.println("Records cannot be deleted");
				break;
			}

			case 5: {

				Statement stmt = con.createStatement();
				System.out.println("Enter emp no and change salary");
				int em = scan.nextInt();
				String sql = "update Emp SET salary=3000 where empno= "+em+"  ";

				int l = stmt.executeUpdate(sql);
				if (l >= 0) {
					System.out.println("Table Altered");

				} else
					System.out.println("Table cannot be Altered");
				break;
			}

			case 6: {
				System.out.println("Enter empno for searching");
				int eno2 = scan.nextInt();
				Statement stmt = con.createStatement();
				String sql = "select * from Emp where empno=" + eno2 + "";
				ResultSet rs = stmt.executeQuery(sql);
				while (rs.next()) {
					System.out.println("Empno  :" + eno2);
					System.out.println("Ename  :" + rs.getString(2));
					System.out.println("Salary  :" + rs.getInt(3));
					System.out.println("Designation  :" + rs.getString(4));
					System.out.println("Department  :" + rs.getString(5));
				}
				break;

			}
			case 7: {
				System.out.println("Displaying department wise record");
				System.out.println("Enter dept name");
				String dnm = scan.next();
				Statement stmt=con.createStatement();
				String sql="select * from emp where dept="+dnm+"";
				ResultSet rs=stmt.executeQuery(sql);
				while(rs.next())
				{
					System.out.println("Record for dept name :");
					System.out.println("Eno "+ rs.getInt(1));
					System.out.println("Ename "+ rs.getString(2));
					System.out.println("Salary "+ rs.getInt(3));
					System.out.println("Designation "+ rs.getString(4));
				}
				
				
				break;
			}
			default:
				System.out.println("Exit");
			}
			con.close();
		}

		catch (Exception e) {
			e.printStackTrace();
		}

	}
}
