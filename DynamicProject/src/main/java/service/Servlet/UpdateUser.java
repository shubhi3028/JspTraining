package service.Servlet;

import data.entity.User;
import databaseConnection.connectionProvider;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class UpdateUser {

    @WebServlet("/update")
    public class UpdateServlet extends HttpServlet {

        @Override
        protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            String ID=req.getParameter("id");
            String FirstName = req.getParameter("fname");
            String LastName = req.getParameter("lname");
            String Email = req.getParameter("email");
            String PhoneNumber = req.getParameter("phoneno");
            String PasswordHash = req.getParameter("password");

               User user= new User(ID,FirstName,LastName,Email,PhoneNumber,PasswordHash);
            UserServlet dao = new UserServlet(connectionProvider.getConnection());

            HttpSession session = req.getSession();

            boolean f =dao.updateUser(user);

            if(f) {
                session.setAttribute("succMsg", "Student details updated sucessfully...");
                resp.sendRedirect("index.jsp");
            }
            else {
                session.setAttribute("errorMsg", "Something wrong on server!");
                resp.sendRedirect("index.jsp");

            }


        }


    }

}
