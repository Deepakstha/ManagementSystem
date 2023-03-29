package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RegisterDao {
	
	public Connection getConnection() throws ClassNotFoundException, SQLException {
		String url ="jdbc:mysql://localhost/iic";
		String username = "root";
		String password = "";
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection(url,username,password);
		return con;
	}
//	public Connection getConnection() {
//		return null;
//		
//	}
	
	public String registerEmployee(String fullname, String department, String phone, String address, String gender) {
		
		String message = "";
		try {
			Connection con = getConnection();
			String query = "INSERT INTO employee(fullname,department,phone,address,gender) VALUES(?,?,?,?,?)";
			PreparedStatement psmt = con.prepareStatement(query);

			
			
			 psmt = con.prepareStatement(query);
			 psmt.setString(1, fullname);
			 psmt.setString(2, department);
			 psmt.setString(3, phone);
			 psmt.setString(4, address);
			 psmt.setString(5, gender);
			 
			 int rows = psmt.executeUpdate();
			 if(rows >= 1) {
				 message = "Thank You for Register !!";
			 }else {
				 message = "Try again";
			 }
			 
			 
			 
			
		}catch(Exception ex) {
			message = ex.getMessage();
		}
		return message;
	}
	
	public ResultSet fetchStudentRecord(){
		try {
			Connection con = getConnection();
			String query = "select * from employee";
			PreparedStatement st = con.prepareStatement(query);
			ResultSet table = st.executeQuery();
			return table;
			
			
//			while(table.next()) {
//				String id = table.getString(1);
//				String name = table.getString(2);
//				String gender = table.getString(3);
//				String password = table.getString(4);
//				
//				System.out.println(id+" "+name+" "+gender+" "+password);
//			}
			
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
		
	}
	
	
	public boolean checkLogin(String id, String fullname) {
		boolean isValid = false;
		try {
			Connection con = getConnection();
			String query = "select * from employee where id = ? and fullname = ?";
			PreparedStatement st = con.prepareStatement(query);
			st.setString(1, id);
			st.setString(2, fullname);
			ResultSet table = st.executeQuery();
			
			if(table.next()) {
				isValid = true;
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return isValid;
	}
	
	
}
