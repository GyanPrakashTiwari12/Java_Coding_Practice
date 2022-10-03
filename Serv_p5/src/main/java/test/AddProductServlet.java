package test;
import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
@SuppressWarnings("serial")
@WebServlet("/add")
public class AddProductServlet extends GenericServlet{

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		ProductBean pb = new ProductBean();//Bean object
		pb.setCode(req.getParameter("pcode"));
		pb.setName(req.getParameter("pname"));
		pb.setPrice(Float.parseFloat(req.getParameter("pprice")));
		pb.setQty(Integer.parseInt(req.getParameter("pqty")));
		PrintWriter pw = res.getWriter();
		res.setContentType("text/html");
		int k = new InsertDAO().insert(pb);
		if(k>0) {
			pw.println("Product Added Successfully....<br>");
		RequestDispatcher  rd = req.getRequestDispatcher("choice.html");
		rd.include(req, res);
		}
	}
}