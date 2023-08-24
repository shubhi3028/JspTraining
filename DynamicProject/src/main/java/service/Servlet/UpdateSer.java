package service.Servlet;

import data.entity.User;
import databaseConnection.connectionProvider;
import utils.JspUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
@WebServlet("/update")
public class UpdateSer extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String ID = req.getParameter("id");
            String FirstName = req.getParameter("fname");
            String LastName = req.getParameter("lname");
            String PhoneNumber = req.getParameter("phoneno");
            String PasswordHash = req.getParameter("password");
            String PasswordtoHash = JspUtils.hashPassword(PasswordHash);

            UserServlet dao = new UserServlet(connectionProvider.getConnection());

            HttpSession session = req.getSession();

            boolean f = dao.updateUser(ID,FirstName,LastName,PhoneNumber,PasswordHash);

            if (f) {
                session.setAttribute("succMsg", "User details updated sucessfully...");
            } else {
                session.setAttribute("errorMsg", "Something wrong on server!");
            }
            resp.sendRedirect("index.jsp");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
}
}
