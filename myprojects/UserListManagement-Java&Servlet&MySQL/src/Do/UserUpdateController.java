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

@WebServlet(urlPatterns = { "/user/update" })
public class UserUpdateController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		
		UserService us = new UserServiceImplementation();
		User user = us.get(id);
		
		resp.setContentType("text/html");
		PrintWriter pw = resp.getWriter();
		
		//shows infos
		pw.println("<form action='/HomeworkSection3/user/update' method='post'>");
		pw.println("ID: <input name='id' value='" + user.getId() + "'>");
		pw.println("Name: <input name='name' value='" + user.getName() + "'>");
		pw.println("Username: <input name='username' value='" + user.getUsername() + "'>");
		pw.println("Password: <input name='password' value='" + user.getPassword() + "'>");
		pw.println("Role: <input name='role' value='" + user.getRole() + "'>");
		pw.println("<button type='submit'>update user</button>");
		pw.println("</form>");

		pw.close();
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		User user = new User();
		
		user.setId(Integer.parseInt(req.getParameter("id")));
		user.setName(req.getParameter("name"));
		user.setUsername(req.getParameter("username"));
		user.setPassword(req.getParameter("password"));
		user.setRole(req.getParameter("role"));
		
		UserService us = new UserServiceImplementation();
		
		us.update(user);
		
		resp.setContentType("text/html");
		PrintWriter pw = resp.getWriter();

		pw.println("Create Successfully!");
		pw.println("<a href=\"/HomeworkSection3/user/search\">User List</a>");
		
		pw.close();
	}
}
