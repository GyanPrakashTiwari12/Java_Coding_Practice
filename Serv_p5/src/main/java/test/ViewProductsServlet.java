package test;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
@SuppressWarnings("serial")
@WebServlet("/view")
public class ViewProductsServlet extends GenericServlet{

	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
	ArrayList<ProductBean> al= new 	RetrieveDAO().retrieve();
	PrintWriter pw = res.getWriter();
		res.setContentType("text/html");
		if(al.size()==0) {
			pw.println("Products Not Available....<br>");
		}//end of if
		else {
			Iterator<ProductBean> it =al.iterator();
		while(it.hasNext())	{
			ProductBean pb = (ProductBean)it.next();
			pw.println
			(pb.getCode()+"&nbsp&nbsp"+pb.getName()+
			"&nbsp&nbsp"+pb.getPrice()+"&nbsp&nbsp"+pb.getQty()+"<br>");
		}//end of while
		}//end of else
		RequestDispatcher rd = req.getRequestDispatcher("choice.html");
		rd.include(req, res);
	}

}
