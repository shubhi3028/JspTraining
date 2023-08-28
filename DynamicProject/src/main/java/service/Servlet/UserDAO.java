package service.Servlet;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.sql.DataSource;

public class UserDAO {
    private static DataSource dataSource;

    public static void updateUserStatus(int userId, boolean isActive) {
        try (Connection connection = dataSource.getConnection()) {
            String query = "UPDATE users SET IsActive = ? WHERE ID = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setBoolean(1, isActive);
            statement.setInt(2, userId);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}