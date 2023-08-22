package service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import databaseConnection.*;
import Dao.*;
import data.entity.*;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("fname");
		String dob = req.getParameter("lname");
		String address = req.getParameter("password");
		String qualification = req.getParameter("email");
		String email = req.getParameter("phoenno");
		
		UserEntity userEntity = new UserEntity(0, fname, lname, password, email, phoneno);
		
		UserDao dao = new UserDao(connectionProvider.getConnection());
		
		HttpSession session = req.getSession();
		
		boolean f = dao.addUser(userEntity);
		
		if(f) {
			session.setAttribute("succMsg", "Student details submit sucessfully...");
			resp.sendRedirect("add_user.jsp");
		}
		else {
			session.setAttribute("errorMsg", "Something wrong on server!");
			resp.sendRedirect("add_user.jsp");
		}
	}

}
