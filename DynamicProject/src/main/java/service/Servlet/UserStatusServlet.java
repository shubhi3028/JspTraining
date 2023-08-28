package service.Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/user-status")
public class UserStatusServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String UserIDStatus = request.getParameter("ID");
        Integer IsActiveStatus = Integer.valueOf(request.getParameter("IsActive"));

        if (UserIDStatus != null && IsActiveStatus != null) {
            int userId = Integer.parseInt(UserIDStatus);
            boolean isActive = Boolean.parseBoolean(String.valueOf(IsActiveStatus));
            UserDAO.updateUserStatus(userId, isActive);
        }else {
            response.sendRedirect(request.getContextPath() + "/index.jsp");
        }
    }
}