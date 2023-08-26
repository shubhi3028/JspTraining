package service.Servlet;

import data.entity.User;
import databaseConnection.connectionProvider;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/active")
public class ActServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String Id = request.getParameter("ID");
        String action = request.getParameter("IsActive");
        setStatus(Id, action);

        User user = getUserById(Id);

        request.setAttribute("user", user);
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

    private void setStatus(String Id, String action) {
        try (Connection conn = connectionProvider.getConnection()) {
            String sql;
            if (action.equals(false)) {
                sql = "UPDATE users SET IsActive= '1' WHERE ID = ?";
            } else if (action.equals(true)) {
                sql = "UPDATE users SET IsActive = '0' WHERE ID = ?";
            } else {
                return;
            }

            try (PreparedStatement ps = conn.prepareStatement(sql)) {
                ps.setString(1, Id);
                ps.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private User getUserById(String Id) {
        try (Connection conn = connectionProvider.getConnection()) {
            String sql = "SELECT * FROM users WHERE ID = ?";
            try (PreparedStatement ps = conn.prepareStatement(sql)) {
                ps.setString(1,Id);
                try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) {
                        User user = new User();
                        user.setId(rs.getString("ID"));
                        user.setStatus(rs.getString("IsActive"));
                        return user;
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}