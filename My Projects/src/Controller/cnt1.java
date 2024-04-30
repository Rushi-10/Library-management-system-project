package Controller;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionActivationListener;

import model.Login_Signup;
@WebServlet(urlPatterns = {"/login","/register","/addStudentsCnt1","/addBooksCnt1"})
public class cnt1 extends HttpServlet{
	
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	String path=req.getServletPath();
	
	if(path.equals("/login")) {
	String userName=req.getParameter("name");
	String password=req.getParameter("password");
	Login_Signup o1=new Login_Signup();
	boolean s=o1.login(userName,password);

	if(s==true) {
	HttpSession ses=req.getSession(true);
	ses.setAttribute("UserName",userName);
	ses.setAttribute("Password",password);
		RequestDispatcher rd=req.getRequestDispatcher("nav.html");
		rd.forward(req, resp);
	}else {
		RequestDispatcher rd=req.getRequestDispatcher("index.html");
		rd.forward(req, resp);
	}
	}else if(path.equals("/register")) {
	String userName=req.getParameter("userName");
	String contact=req.getParameter("contact");
	String password=req.getParameter("password");

	Login_Signup o2=new Login_Signup();
	boolean b=o2.register(userName,contact,password);
	if(b==true) {
		RequestDispatcher rd=req.getRequestDispatcher("Register.html");
		rd.forward(req, resp);
	}else {
		
		RequestDispatcher rd=req.getRequestDispatcher("index.html");
		rd.forward(req, resp);
	}
	}
	
}
}
