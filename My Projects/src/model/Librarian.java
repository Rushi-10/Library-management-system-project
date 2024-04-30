package model;

public class Librarian {
private int id;
private String userName;
public Librarian() {
	super();
	// TODO Auto-generated constructor stub
}
public Librarian(int id, String userName, String contact, String password) {
	super();
	this.id = id;
	this.userName = userName;
	this.contact = contact;
	this.password = password;
}
private String contact;
private String password;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getUserName() {
	return userName;
}
public void setUserName(String userName) {
	this.userName = userName;
}
public String getContact() {
	return contact;
}
public void setContact(String contact) {
	this.contact = contact;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
}
