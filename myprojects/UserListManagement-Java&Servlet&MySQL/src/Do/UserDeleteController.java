package Do;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import section3.UserService;
import section3.UserServiceImplementation;

@WebServlet(urlPatterns = { "/user/delete" })
public class UserDeleteController extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		
		UserService us = new UserServiceImplementation();
		us.delete(id);
		
		resp.setContentType("text/html");
		
		PrintWriter pw = resp.getWriter();
		
		pw.println("Delete Successfully");
		pw.println("<a href='/HomeworkSection3/user/search'>User List</a>");
		pw.close();
	}
	
}
