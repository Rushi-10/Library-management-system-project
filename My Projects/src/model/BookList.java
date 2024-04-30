package model;

import java.sql.*;
import java.util.ArrayList;

public class BookList {
	static Connection con=null;
	static {
	    try {
	    	Class.forName("com.mysql.cj.jdbc.Driver");
	        con= DriverManager.getConnection("jdbc:mysql://localhost:3306/library_project","root","Rushi@1094");
	    } catch (SQLException | ClassNotFoundException e) {
	        throw new RuntimeException(e);
	    }
	}
	public ArrayList<Book> bookList(String bookCate) {
		ArrayList<Book> bookList=new ArrayList<Book>();
		String query="select book_id,book_name,copies from books where book_type='"+bookCate+"'";
		try {
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery(query);
			while(rs.next()) {
				Book b=new Book();
				b.setBookId(rs.getInt(1));
				b.setBookName(rs.getString(2));
				b.setBookCopies(rs.getInt(3));
				bookList.add(b);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bookList;
	}
	public String issueBook(int bookId, int studentId) {
		String qIssue="insert into issuedbooks values(?,?)";
		String qCheckAlreadyIssued="select * from issuedbooks where studentId='"+studentId+"'";
		String qCheckStudentId="select * from student where std_id='"+studentId+"'";
		String qCheckCopies="select copies from books where book_id='"+bookId+"'";
		String result="";
		Statement stmt;
		ResultSet rs;
		boolean ready=true;
		PreparedStatement pstmt;
		try {
			stmt=con.createStatement();
			rs=stmt.executeQuery(qCheckCopies);
			while(rs.next()) {
			if(rs.getInt(1)==0) {
				ready=false;
				result="CopyNotAvailable";
			}
			}
			rs.close();
			
			rs=stmt.executeQuery(qCheckStudentId);
			if(rs.next()==false) {
				ready=false;
				result="WrongStudentId";
			}
			rs.close();
			
			rs=stmt.executeQuery(qCheckAlreadyIssued);
			while(rs.next()) {
				if(rs.getInt(2)==bookId) {
					ready=false;
					result="BookAlreadyIssued";
				}
			}
			
			if(ready==true) {
				pstmt=con.prepareStatement(qIssue);
				pstmt.setInt(1, studentId);
				pstmt.setInt(2, bookId);
				int isInsert=pstmt.executeUpdate();
				if(isInsert==1) {
					stmt.execute("update books set copies=copies-1 where book_id='"+bookId+"'");
					result="Issue";
				}
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	return result;	
		
	}
	public ArrayList<Student> issuedStudentList(int bookId) {
		ArrayList<Student> studentList=new ArrayList<Student>();
		String qCheckStudents="select * from issuedbooks where bookId='"+bookId+"'";
		try {
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery(qCheckStudents);
			while(rs.next()) {
				String qStudentDetails="select * from student where std_id='"+rs.getInt(1)+"'";
				Statement stmt2=con.createStatement();
				ResultSet rs2=stmt2.executeQuery(qStudentDetails);
				while(rs2.next()) {
					Student s1=new Student();
					s1.setStudentId(rs2.getInt(1));
					s1.setStudentName(rs2.getString(2));
					s1.setStudentContact(rs2.getString(3));
					studentList.add(s1);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return studentList;
	}
	public boolean submitBook(int studentId, int bookId) {
		boolean result=true;
		try {
			PreparedStatement pstmt=con.prepareStatement("delete from issuedbooks where studentId=? and bookId=?");
			pstmt.setInt(1, studentId);
			pstmt.setInt(2, bookId);
			result=pstmt.execute();
			if(result==false) {
				PreparedStatement pstmt2=con.prepareStatement("update books set copies=copies+1 where book_id=?");
				pstmt2.setInt(1, bookId);
				result=pstmt2.execute();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
}
