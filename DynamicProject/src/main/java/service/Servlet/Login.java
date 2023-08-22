package service.Servlet;

import databaseConnection.connectionProvider;

import java.io.IOException;
import java.sql.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login")
public class Login extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("username");
        String password = request.getParameter("password");

        HttpSession session = request.getSession();
        RequestDispatcher rd = null;
        Connection conn = connectionProvider.getConnection();
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("select * from users where email = ? and passwordhash = ?");
            ps.setString(1, email);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                session.setAttribute("email", rs.getString("email"));
                rd = request.getRequestDispatcher("index.jsp");
            } else {
                request.setAttribute("status", "failed");
                rd = request.getRequestDispatcher("login.jsp");
            }
            rd.forward(request, response);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
