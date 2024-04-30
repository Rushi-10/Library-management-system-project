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

import model.Book;
import model.BookList;
import model.Student;

@WebServlet(urlPatterns = {"/BookList","/IssueBook","/IssuedBookStudentList","/SubmitBook"})
public class BookListController extends HttpServlet{
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	HttpSession ses=req.getSession(false);

	if(ses!=null) {
		String url=req.getServletPath();
		BookList b1=new BookList();
		if(url.equals("/BookList")) {
			String bookCate=req.getParameter("bookName");
			ArrayList<Book> bookList1=b1.bookList(bookCate);
			req.setAttribute("bookList", bookList1);
			RequestDispatcher rd=req.getRequestDispatcher("BookList.jsp");
			rd.forward(req, resp);
			
		}
		else if(url.equals("/IssueBook")) {
			int studentId=-1;
			int bookId=-1;
			try {
			 studentId=Integer.parseInt(req.getParameter("stdid"));
			
		     bookId=Integer.parseInt(req.getParameter("bookId1"));
			}catch (Exception e) {
				// TODO: handle exception
				PrintWriter pw=resp.getWriter();
				pw.write("<script>var r=confirm('Enter Id');"
						+ " if(r) {window.location.href ='Issue.jsp'}"
						+ "else {window.location.href ='nav.html'}"
								+ "</script>");
			}
			String result=b1.issueBook(bookId,studentId);
			
			if(result.equals("Issue")) {
				PrintWriter pw=resp.getWriter();
				pw.write("<script>var r=confirm('Issued Successfully');"
						+ " if(r) {window.location.href ='nav.html'}"
						+ "else {window.location.href ='nav.html'}"
								+ "</script>");
			}
			else if(result.equals("CopyNotAvailable")) {
				PrintWriter pw=resp.getWriter();
				pw.write("<script>var r=confirm('Book Copy Not Available');"
						+ " if(r) {window.location.href ='nav.html'}"
						+ "else {window.location.href ='nav.html'}"
								+ "</script>");
			}
			else if(result.equals("WrongStudentId")) {
				PrintWriter pw=resp.getWriter();
				pw.write("<script>var r=confirm('Enter Correct Student Id');"
						+ " if(r) {window.location.href ='nav.html'}"
						+ "else {window.location.href ='nav.html'}"
								+ "</script>");
			}
			else if(result.equals("BookAlreadyIssued")) {
				PrintWriter pw=resp.getWriter();
				pw.write("<script>var r=confirm('This Book Is Already Issued To This Student');"
						+ " if(r) {window.location.href ='nav.html'}"
						+ "else {window.location.href ='nav.html'}"
								+ "</script>");
			}
		}
			else if(url.equals("/IssuedBookStudentList")) {
			int bookId=Integer.parseInt(req.getParameter("bookIdIssuedToStudent"));
			ArrayList<Student> studentList=b1.issuedStudentList(bookId);
			
			req.setAttribute("issuedStudentList", studentList);
			RequestDispatcher rd=req.getRequestDispatcher("BookIssuedStudentList.jsp?bookId="+bookId+"");
			rd.forward(req, resp);
		}
		else if(url.equals("/SubmitBook")) {
			int studentId=Integer.parseInt(req.getParameter("submitBookStudentId"));
			int bookId=Integer.parseInt(req.getParameter("bookIdForSubmit"));
			boolean result=b1.submitBook(studentId,bookId);
			if(result==false) {
				PrintWriter pw=resp.getWriter();
				pw.write("<script>var r=confirm('Book Submitted Successfully');"
						+ " if(r) {window.location.href ='nav.html'}"
						+ "else {window.location.href ='nav.html'}"
								+ "</script>");
			}
			else {
				PrintWriter pw=resp.getWriter();
				pw.write("<script>var r=confirm('Something Went Wrong, Try Again...');"
						+ " if(r) {window.location.href ='nav.html'}"
						+ "else {window.location.href ='nav.html'}"
								+ "</script>");
			}
		}
	}
}
}
