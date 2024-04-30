package model;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class navbar {
static Connection con=null;
static {
    try {
    	Class.forName("com.mysql.cj.jdbc.Driver");
        con= DriverManager.getConnection("jdbc:mysql://localhost:3306/library_project","root","Rushi@1094");
    } catch (SQLException | ClassNotFoundException e) {
        throw new RuntimeException(e);
    }
}
public boolean addStudent(String name, String contact) {
	String query="insert into Student values(?,?,?)";
	PreparedStatement pstmt;
    boolean returnValue=true;
	try {
		pstmt = con.prepareStatement(query);
		pstmt.setInt(1, 0);
		pstmt.setString(2,name);
		pstmt.setString(3,contact);
		returnValue=pstmt.execute();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
return returnValue;	
}
public boolean addBooks(String type, String name, int bookId, int numberCopy) {
	String query="insert into books values(?,?,?,?)";
	PreparedStatement pstmt;
    boolean returnValue=true;
	try {
		pstmt = con.prepareStatement(query);
		pstmt.setInt(1, bookId);
		pstmt.setString(2,name);
		pstmt.setString(3,type);
		pstmt.setInt(4, numberCopy);
		returnValue=pstmt.execute();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return returnValue;
}
public ArrayList<Student> studentList() {
	String query="select * from student";
	ArrayList<Student> studentList=new ArrayList();
	try {
		Statement stmt=con.createStatement();
		ResultSet rs=stmt.executeQuery(query);
		while(rs.next()) {
			Student s1=new Student(rs.getInt(1),rs.getString(2),rs.getString(3));
			
			studentList.add(s1);
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
return studentList;	
}
public Librarian getAccountInfo(String password) {
	String query="select * from admin_data where password="+password+"";
	Librarian l1=new Librarian();
	try {
		
		Statement stmt=con.createStatement();
		ResultSet rs=stmt.executeQuery(query);
		while(rs.next()) {
			
			 l1.setId(rs.getInt(1));
			 l1.setUserName(rs.getString(2));
			 l1.setContact(rs.getString(3));
			 l1.setPassword(rs.getString(4));
			
		}
	} catch (SQLException e) {
		System.out.println("error yetay");
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return l1;
}
}
