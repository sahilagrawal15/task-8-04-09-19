//PROCEDURE(To insert data in table)
//--------------------------------------------------------------------------------------

/*create or replace PROCEDURE insertRecord
(p_student_id IN Record.student_id%TYPE,
p_name IN Record.name%TYPE,
p_mobile IN Record.mobile%TYPE,
p_city IN Record.city%TYPE,
p_blood_group IN Record.blood_group%TYPE)
AS
BEGIN
insert into Record(student_id,name,mobile,city,blood_group)
values
(p_student,p_name,p_mobile,p_city,p_blood_group);
END;
*/
//--------------------------------------------------------------------------------------
//--------------------------------------------------------------------------------------
//Table is
//--------------------------------------------------------------------------------------

/* create table Record(student_id number PRIMARY KEY,
 name varchar2(20), mobile number,
 city varchar2(20), blood_group varchar2(5));
*/

//--------------------------------------------------------------------------------------

//--------------------------------------------------------------------------------------

import java.sql.*;
import java.util.Scanner;

class CallableStatementUse {
	public static void main(String args[]) throws Exception {
		Scanner scan=new Scanner(System.in);
		try {
//step1 load the driver class  
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Driver Loaded");
			// --------------------------------------------------------------------------------------

//step2 create  the connection object  
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String id = "sahil";
			String password = "sahil";
			Connection con = DriverManager.getConnection(url, id, password);
			System.out.println("Connected");
			// --------------------------------------------------------------------------------------
			// --------------------------------------------------------------------------------------

//step3 create the statement object  
			Statement stmt = con.createStatement();

//step4 execute query  
			/*
			 * ResultSet rs = stmt.executeQuery("select * from emp"); while (rs.next())
			 * System.out.println(rs.getInt(1) + "  " + rs.getString(2) + "  " +
			 * rs.getString(3));
			 */
			CallableStatement cs = con.prepareCall("{call insertRecord(?,?,?,?,?)}");
			
			System.out.println("------------------------------------------------------------------------------------------------------");

			System.out.println("Enter ID");
			int a=scan.nextInt();
			System.out.println("Enter name");
			String b=scan.next();
			System.out.println("Enter Mobile Number");
			int c=scan.nextInt();
			System.out.println("Enter city");
			String d=scan.next();
			System.out.println("Enter blood group");
			String e=scan.next();
			
			cs.setInt(1, a);
			cs.setString(2, b);
			cs.setInt(3, c);
			cs.setString(4, d);
			cs.setString(5, e);
			
			System.out.println("------------------------------------------------------------------------------------------------------");
			
			
			cs.execute();
			System.out.println("Record Inserted");
			System.out.println("Procedure executed successfully");

//step5 close the connection object  
			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}