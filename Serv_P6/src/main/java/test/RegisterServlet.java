package test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@SuppressWarnings("serial")
@SuppressWarnings("serial")
@WebServlet("/reg")
public class RegisterServlet extends HttpServlet{
protected void doPost(HttpServletRequest req,HttpServletResponse res)
		throws ServletException,IOException {
	UserBean ub = new UserBean();//Bean object will hold data coming from database
	ub.setuName(req.getParameter("uname"));
	ub.setpWord(req.getParameter("pword"));
	ub.setfName(req.getParameter("fname"));
	ub.setlName(req.getParameter("lname"));
	ub.setAddr(req.getParameter("addr"));
	ub.setmId(req.getParameter("mid"));
	ub.setPhNo(Long.parseLong(req.getParameter("phno")));
int k = new RegisterDAO().register(ub);//DAO to hold Database related codes(Persistent Logics)
PrintWriter pw = res.getWriter();
res.setContentType("text/html");
if(k>0) {
	pw.println("User Registered Successfully...<br>");
RequestDispatcher rd=	req.getRequestDispatcher("login.html");
	rd.include(req, res);
}
}
	
}
