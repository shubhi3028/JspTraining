package service.Servlet;


import databaseConnection.connectionProvider;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/isactive")

public class ActiveServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String userId = request.getParameter("ID");
        String action = request.getParameter("Status");
        updateStatus(userId, action);
        response.sendRedirect("index.jsp");

    }

    private void updateStatus(String userId, String action) {
        try (Connection conn = connectionProvider.getConnection()) {
            String sql;
            if ("activate".equals(action)) {
                sql = "UPDATE users SET Status = 'active' WHERE ID = ?";
            } else if ("deactivate".equals(action)) {
                sql = "UPDATE users SET Status = 'inactive' WHERE ID = ?";
            } else {
                return;
            }
            try (PreparedStatement ps = conn.prepareStatement(sql)) {
                ps.setString(1, userId);
                ps.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}