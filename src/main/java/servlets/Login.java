package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import database.RegisterDao;

@WebServlet("/Login")
public class Login extends HttpServlet {
	public void service(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String id = request.getParameter("id");
		String fullname = request.getParameter("fullname");
		
		RegisterDao database = new RegisterDao();
		boolean isValid =  database.checkLogin(id, fullname);
		if(isValid) {
			
			HttpSession session = request.getSession();
			session.setAttribute("loggedInId", id);
			response.sendRedirect("StudentProfile.jsp");
			
//			RequestDispatcher rd = request.getRequestDispatcher('StudentProfile.jsp');
//			rd.forward(request, response);
		}else {
			response.sendRedirect("Login.jsp");
//			RequestDispatcher rd = request.getRequestDispatcher('StudentProfile.jsp');
//			request.setAttribute("LoginMessage", "Fail");
//			rd.forward(request, response);
		}
		
	}
}
