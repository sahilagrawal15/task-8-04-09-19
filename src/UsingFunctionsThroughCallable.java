import java.sql.*;
import java.util.Scanner;

class UsingFunctionsThroughCallable {
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


			 
			CallableStatement cs = con.prepareCall("{?=call get_full_address(?,?,?,?)}");
			
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
			System.out.println("Function executed successfully");

//step5 close the connection object  
			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}