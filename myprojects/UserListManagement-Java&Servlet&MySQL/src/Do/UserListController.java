package Do;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.User;
import section3.UserService;
import section3.UserServiceImplementation;

@WebServlet(urlPatterns = {"/user/search"})
public class UserListController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		
		UserService us = new UserServiceImplementation();
		
		List<User> users = us.search("");
		
		PrintWriter pw = resp.getWriter();
		
		pw.println("<table>");
		pw.println("<tr>" + "<th>ID</th>" + "<th>Name</th>" + "<th>Username</th>"
				+ "<th>Password</th>" + "<th>Role</th>" + "<th>To do</th>" + "</tr>");
		
		for(User user : users) {
			pw.println("<tr>" 
					+ "<td>" + user.getId() + "</td>" 
					+ "<td>" + user.getName() + "</td>" 
					+ "<td>" + user.getUsername() + "</td>" 
					+ "<td>" + user.getPassword() + "</td>" 
					+ "<td>" + user.getRole() + "</td>" 
					+ "<td><a href='/HomeworkSection3/user/delete?id=" + user.getId() + "'>Delete</a> " 
					+ "| <a href='/HomeworkSection3/user/update?id=" + user.getId() + "'>Update</a></td>" 
					+ "</tr>");
		}
		pw.println("</table>");
		
		pw.println("<a href=\"/HomeworkSection3/user/add\">Add User</a>");
		pw.close();
	}
}
