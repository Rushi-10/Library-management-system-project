package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Librarian;
import model.Student;
import model.navbar;
@WebServlet(urlPatterns = {"/addStudent","/addBooks","/StudentList","/account"})
public class cnt2 extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
	HttpSession ses=request.getSession(false);
	String n=ses.getAttribute("UserName").toString();
		if(ses!=null) {
	String url=request.getServletPath();
	navbar n1=new navbar();
	if(url.equals("/addStudent")) {
		
		String name=request.getParameter("studName");
	   String contact=request.getParameter("contactNo").toString();
		 if(name.equals("")||contact.equals("")||contact.length()>10||name.length()>20) {
			PrintWriter pw=resp.getWriter();
			pw.write("<script>var r=confirm('Enter Correct Details');"
					+ " if(r) {window.location.href ='AddStudent.html'}"
					+ "else {window.location.href ='nav.html'}"
							+ "</script>");	
		 }else {
		boolean studentStatus=n1.addStudent(name,contact);
		
		if(studentStatus==false) {
			
			RequestDispatcher rd=request.getRequestDispatcher("nav.html");
			rd.forward(request, resp);
			
			PrintWriter pw=resp.getWriter();
			pw.write("<script> window.alert('Student Registered Successfully');</script>");
		}
		 }
	}else if(url.equals("/addBooks")) {
		String type=null;
		String name=null;
		int bookId=0;
		int numberCopy=0;
		try {
		type=request.getParameter("bookType");
		 name=request.getParameter("bookName");
		 bookId=Integer.parseInt(request.getParameter("bookId"));
		 numberCopy=Integer.parseInt(request.getParameter("bookCopy"));
		}
		catch(java.lang.NumberFormatException e) {
			PrintWriter pw=resp.getWriter();
			pw.write("<script>var r=confirm('Enter Correct Details');"
					+ " if(r) {window.location.href ='AddBooks.html'}"
					+ "else {window.location.href ='nav.html'}"
							+ "</script>");
			
		}
		boolean b=n1.addBooks(type,name,bookId,numberCopy);
		if(b==false) {
			PrintWriter pw=resp.getWriter();
			pw.write("<script>var r=confirm('Book Added Successfully');"
					+ " if(r) {window.location.href ='nav.html'}"
					+ "else {window.location.href ='AddBooks.html'}"
							+ "</script>");
			
		}else {
			PrintWriter pw=resp.getWriter();
			pw.write("<script>var r=confirm('Enter Correct Details');"
					+ " if(r) {window.location.href ='AddBooks.html'}"
					+ "else {window.location.href ='AddBooks.html'}"
					+ "</script>");	
		}
	}
	else if(url.equals("/StudentList")) {
		ArrayList<Student> studentList=(ArrayList<Student>) n1.studentList();
		request.setAttribute("studentList", studentList);
		RequestDispatcher rd=request.getRequestDispatcher("StudentList.jsp");
		rd.forward(request, resp);
	}
	else if(url.equals("/account")) {
		
		String userName=ses.getAttribute("UserName").toString();
		String password=ses.getAttribute("Password").toString();
		
		navbar n2=new navbar();
		Librarian l1=n2.getAccountInfo(password);
		request.setAttribute("LibrarianInfo",l1);
		RequestDispatcher rd=request.getRequestDispatcher("AccountInfo.jsp");
		rd.forward(request, resp);
	}
		
	}else if(n.isEmpty()) {
		resp.sendRedirect("index.html");
	}
}
}


