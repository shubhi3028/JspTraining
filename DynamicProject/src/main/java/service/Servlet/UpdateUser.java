package service.Servlet;

import databaseConnection.connectionProvider;
import utils.JspUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/updateUser")
public class UpdateUser extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String FirstName = req.getParameter("fname");
            String LastName = req.getParameter("lname");
            String PhoneNumber = req.getParameter("phoneno");
            String Email=req.getParameter("email");
            String PasswordHash = req.getParameter("password");
            String PasswordtoHash = JspUtils.hashPassword(PasswordHash);
            Boolean IsApproved=false;

            UserServlet dao = new UserServlet(connectionProvider.getConnection());

            HttpSession session = req.getSession();

            boolean f = dao.updateUserByEmail( FirstName,LastName,PhoneNumber,Email,PasswordHash,IsApproved);

            if (f) {
                session.setAttribute("succMsg", "User details updated sucessfully...");
            } else {
                session.setAttribute("errorMsg", "Something wrong on server!");
            }
            resp.sendRedirect("login.jsp");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
