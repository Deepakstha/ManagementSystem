package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.RegisterDao;

@WebServlet("/SignUp")
public class SignUp extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String fullname = request.getParameter("fullname");
		String department = request.getParameter("department");
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
		String gender = request.getParameter("gender");
		
		RegisterDao database = new RegisterDao();
		String message = database.registerEmployee(fullname, department, phone, address, gender);
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println(" <h1>"+message+"</h1>");
	}
}
