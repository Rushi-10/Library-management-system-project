package model;

import java.sql.*;

public class Login_Signup {
	static Connection con=null;
    static {
        try {
        	Class.forName("com.mysql.cj.jdbc.Driver");
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/library_project","root","Rushi@1094");
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
	public boolean login(String name, String password) {
		String query="select user_name,password from admin_data where user_name='"+name+"'and password='"+password+"'";
		Statement stmt=null;
		ResultSet rs=null;
		boolean status=false;
		try {
			stmt=con.createStatement();
			rs=stmt.executeQuery(query);
			if(rs.next()) {
				status=true;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return status;
	}

	public boolean register(String userName, String contact, String password) {
	String query="insert into admin_data (user_name,contact_no,password) values(?,?,?)";
	
	boolean status=true;;
	try {
		
		PreparedStatement pstmt=con.prepareStatement(query);
		
		pstmt.setString(1,userName);
		pstmt.setString(2,contact);
		pstmt.setString(3,password);
		status=pstmt.execute();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
		
	return status;
		
	}

}
