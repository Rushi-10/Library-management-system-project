package model;

import java.util.ArrayList;

public class Student {
	public Student(int studentId, String studentName, String studentContact) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
		this.studentContact = studentContact;
	}
	public Student() {
		super();
	}
	private int studentId;
	private String studentName;
	private String studentContact;
	private ArrayList<Book> bookList;
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getStudentContact() {
		return studentContact;
	}
	public void setStudentContact(String studentContact) {
		this.studentContact = studentContact;
	}
	public ArrayList<Book> getBookList() {
		return bookList;
	}
	public void setBookList(ArrayList<Book> bookList) {
		this.bookList = bookList;
	}
	

}
