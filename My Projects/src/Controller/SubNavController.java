package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Book;
import model.SubNavbarModel;
@WebServlet(urlPatterns = {"/UpdateStudent","/DeleteStudent","/askForDelete","/StdBookList","/EditLibInfo","/logout"})
public class SubNavController extends HttpServlet {
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	HttpSession ses=req.getSession(false);
	if(ses!=null) {
		SubNavbarModel s1=new SubNavbarModel();
		String url=req.getServletPath();
		if(url.equals("/UpdateStudent")) {
			int studentId=0;
			String studentName="";
			String studentContact="";
			try {
			studentId=Integer.parseInt(req.getParameter("stdid"));
			 studentName=req.getParameter("stdname");
			 studentContact=req.getParameter("stdcnt").toString();
			if(studentId==0||studentId>1000000000||studentName.length()>20||studentName.equals("")||studentContact.length()>10||studentContact.equals("")) {
				PrintWriter pw=resp.getWriter();
				pw.write("<script>var r=confirm('Enter Correct Details');"
						+ " if(r) {window.location.href ='UpdateStudent.jsp'}"
						+ "else {window.location.href ='StudentList'}"
						+ "</script>");		
			}
			 
			else {
			Boolean isUpdate=s1.updateStudent(studentId,studentName,studentContact);
			if(isUpdate==false) {
				PrintWriter pw=resp.getWriter();
				pw.write("<script>var r=confirm('Updated Successfully');"
						+ " if(r) {window.location.href ='StudentList'}"
						+ "else {window.location.href ='UpdateStudent.jsp'}"
								+ "</script>");
			}
			else {
				PrintWriter pw=resp.getWriter();
				pw.write("<script>var r=confirm('Enter Correct Details');"
						+ " if(r) {window.location.href ='UpdateStudent.jsp'}"
						+ "else {window.location.href ='StudentList'}"
						+ "</script>");	
			}
			}
		}catch(Exception e) {
			PrintWriter pw=resp.getWriter();
			pw.write("<script>var r=confirm('Enter Correct Details');"
					+ " if(r) {window.location.href ='UpdateStudent.jsp'}"
					+ "else {window.location.href ='StudentList'}"
					+ "</script>");	
		}
			}else if(url.equals("/askForDelete")) {
			String id=req.getParameter("delete");
			Cookie c1=new Cookie("idForDelete",id);
			resp.addCookie(c1);
			
			PrintWriter pw=resp.getWriter();
			pw.write("<script>var r=confirm('Do you want to delete');"
					+ " if(r) {window.location.href ='DeleteStudent'}"
					+ "else {window.location.href ='StudentList'}"
							+ "</script>");	
		}
		else if(url.equals("/DeleteStudent")) {
			int id=-1;	 	
     Cookie [] c=req.getCookies();
     for(Cookie s:c) {
    	 String name=s.getName();
    	 if(name.equals("idForDelete")) {
    	id=Integer.parseInt(s.getValue());
    	 }
     }
    // int id=Integer.parseInt("id1");
			boolean isDelete=s1.deleteStudent(id);
			if(isDelete==false) {
				PrintWriter pw=resp.getWriter();
				pw.write("<script>var r=confirm('Deleted Successfully ');"
						+ " if(r) {window.location.href ='StudentList'}"
						+ "else {window.location.href ='StudentList'}"
								+ "</script>");
			}
			else {
				PrintWriter pw=resp.getWriter();
				pw.write("<script>var r=confirm('Something Went Wrong');"
						+ " if(r) {window.location.href ='StudentList'}"
						+ "else {window.location.href ='StudentList'}"
						+ "</script>");	
			}
		}
		else if(url.equals("/StdBookList")) {
			int stdId=Integer.parseInt(req.getParameter("stdId"));
			ArrayList<Book> issuedbList=s1.getStudentBList(stdId);
			req.setAttribute("stdBookList", issuedbList);
			RequestDispatcher rd=req.getRequestDispatcher("studentBookList.jsp?bookId="+stdId+"");
			rd.forward(req, resp);
			
		}
		else if(url.equals("/EditLibInfo")) {
			String name=req.getParameter("libNewName");
			String contact=req.getParameter("libNewContact").toString();
			String oldPassword=req.getParameter("libOldPassword");
			String newPassword=req.getParameter("libNewPassword");
			if(contact.length()>10||name.length()>20||newPassword.length()>20) {
				PrintWriter pw=resp.getWriter();
				pw.write("<script>var r=confirm('Something went wrong,Try Again !');"
						+ " if(r) {window.location.href ='EditLibrarian.jsp'}"
						+ "else {window.location.href ='nav.html'}"
						+ "</script>");		
			}
			else {
			int updatedLib=s1.EditLibInfo(name,contact,oldPassword,newPassword);
			if(updatedLib==1) {
				ses.setAttribute("Password", newPassword);
				PrintWriter pw=resp.getWriter();
				pw.write("<script>var r=confirm('Updated Successfully');"
						+ " if(r) {window.location.href ='nav.html'}"
						+ "else {window.location.href ='nav.html'}"
						+ "</script>");	
			}
			else {
				PrintWriter pw=resp.getWriter();
				pw.write("<script>var r=confirm('Something went wrong,Try Again !');"
						+ " if(r) {window.location.href ='nav.html'}"
						+ "else {window.location.href ='nav.html'}"
						+ "</script>");	
			}
		}
		}
		else if(url.equals("/logout")) {
			ses.invalidate();
			RequestDispatcher rd=req.getRequestDispatcher("index.html");
			rd.forward(req, resp);
			
		}
	}
}
}
