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
        String Id = request.getParameter("id");
        System.out.println("Hello id" + Id);
        setStatus(Id);
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

    private void setStatus(String Id) {

        try (Connection conn = connectionProvider.getConnection()) {
            Boolean status = false;
            User s = null;
            String sql;
            sql = "select * from users where ID= ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, Id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                s = new User();
                s.setId(rs.getString(1));
                s.setStatus(rs.getString(9));
            }
            if(s.getIsActive() == false) {
                status = true;
            }
            else if(s.getIsActive() == true) {
                status = false;
            }
            if (s != null) {
                boolean newStatus = !Boolean.parseBoolean(String.valueOf(s.getIsActive()));
                updateUserStatus(conn, Id, newStatus);
            } else {
                System.out.println("User not found");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void updateUserStatus(Connection conn, String userId, boolean newStatus) throws SQLException {
        String sql = "UPDATE users SET IsActive=? WHERE ID=?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setBoolean(1, newStatus);
            ps.setString(2, userId);
            int rowsUpdated = ps.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("User status updated successfully.");
            } else {
                System.out.println("Failed to update user status.");
            }
        }
    }
}

