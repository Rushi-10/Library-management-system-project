package model;

import java.sql.*;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class SubNavbarModel {
	static Connection con=null;
	static {
	    try {
	    	Class.forName("com.mysql.cj.jdbc.Driver");
	        con= DriverManager.getConnection("jdbc:mysql://localhost:3306/library_project","root","Rushi@1094");
	    } catch (SQLException | ClassNotFoundException e) {
	        throw new RuntimeException(e);
	    }
	}
	public Boolean updateStudent(int studentId, String studentName, String studentContact) {
	String query="update student set std_name=?,std_contact=? where std_id=?";
	boolean s=true;
	try {
		PreparedStatement pstmt=con.prepareStatement(query);
		pstmt.setString(1,studentName);
		pstmt.setString(2,studentContact);
		pstmt.setInt(3,studentId);
		 s=pstmt.execute();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return s;
	}
	public boolean deleteStudent(int id) {
		String query="delete from student where std_id=?";
		boolean s=true;
		try {
			PreparedStatement pstmt=con.prepareStatement(query);
			
			pstmt.setInt(1,id);
			 s=pstmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return s;
	}
	public ArrayList<Book> getStudentBList(int stdId) {
		ArrayList<Book> stdBookList=new ArrayList<Book>();
		try {
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery("select bookId from issuedbooks where studentId='"+stdId+"'");
			while(rs.next()) {
				Statement stmt2=con.createStatement();
				ResultSet rs2=stmt2.executeQuery("select book_id,book_name,book_type from books where book_id='"+rs.getInt(1)+"'");
				while(rs2.next()) {
					Book b1=new Book();
					b1.setBookId(rs2.getInt(1));
					b1.setBookName(rs2.getString(2));
					b1.setBookType(rs2.getString(3));
					stdBookList.add(b1);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return stdBookList; 
	}
	public int EditLibInfo(String name, String contact, String oldPassword, String newPassword) {
		String query="update admin_data set user_name='"+name+"',contact_no='"+contact+"',password='"+newPassword+"' where password='"+oldPassword+"'";
		Statement stmt;
		int a=0;
		try {
			stmt = con.createStatement();
			a=stmt.executeUpdate(query);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return a;
	}

}
