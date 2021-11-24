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

@WebServlet(urlPatterns = { "/user/detail" })
public class DetailUserController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		
		int id = Integer.parseInt(req.getParameter("id"));
		
		UserService us = new UserServiceImplementation();
		User user = us.get(id);
		
		PrintWriter pw = resp.getWriter();
		
		pw.println("<table>");
		pw.println("<tr>"
				+ "<th>ID</th>"
				+ "<th>Name</th>"		
				+ "<th>Username</th>"
				+ "<th>Password</th>"
				+ "<th>Role</th>"
				+ "</tr>");

		pw.println("<tr>"
				+ "<td>" +user.getId()+ "</td>"				
				+ "<td>" +user.getName()+"</td>"
				+ "<td>" +user.getUsername()+"</td>"
				+ "<td>" +user.getPassword()+"</td>"
				+ "<td>" +user.getRole()+"</td>"
				+ "</tr>");
		pw.println("</table>");
		
		pw.println("<a href=\"/HomeworkSection3/user/search\">User List</a>");
		pw.close();
	}
}
