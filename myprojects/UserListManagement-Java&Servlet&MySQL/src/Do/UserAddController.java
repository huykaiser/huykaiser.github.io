package Do;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.User;
import section3.UserService;
import section3.UserServiceImplementation;

@WebServlet(urlPatterns = {"/user/add"})
public class UserAddController  extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		
		PrintWriter pw = resp.getWriter();
		
		pw.println("<form action='/HomeworkSection3/user/add' method='post'>");
		pw.println("Name: <input name='name'>");
		pw.println("Username: <input name='username' >");
		pw.println("Password: <input name='password' >");
		pw.println("Role: <input name='role' >");
		pw.println("<button type='submit'>ADD</button>");
		pw.println("</form>");
		
		pw.close();
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		User user = new User();

		user.setName(req.getParameter("name"));
		user.setUsername(req.getParameter("username"));
		user.setPassword(req.getParameter("password"));
		user.setRole(req.getParameter("role"));

		UserService us = new UserServiceImplementation();
		us.insert(user);

		resp.setContentType("text/html");
		PrintWriter pw = resp.getWriter();

		pw.println("Succeed!");
		pw.println("<a href=\"/HomeworkSection3/user/search\">User List</a>");
		
		pw.close();

	}

}
