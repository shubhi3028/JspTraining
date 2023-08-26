package service.Servlet;



import databaseConnection.connectionProvider;
import exception.AdminAccessException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.security.MessageDigest;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


@WebServlet("/login")
public class Login extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
        String Email = request.getParameter("email");
        String plainPassword = request.getParameter("password");
        String Role= getUserRoleByEmail(Email);


        HttpSession session = request.getSession();
        RequestDispatcher rd = null;
        Connection conn = connectionProvider.getConnection();
        PreparedStatement ps = null;




            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(plainPassword.getBytes());
            byte[] hashedPasswordBytes = md.digest();
            StringBuilder hashedPassword = new StringBuilder();




            for (byte b : hashedPasswordBytes) {
                hashedPassword.append(String.format("%02x", b));
            }



            ps = conn.prepareStatement("select Role from users where Email = ? and PasswordHash = ? ");
            ps.setString(1, Email);
            ps.setString(2, hashedPassword.toString());


            if (Role==null){
                throw new AdminAccessException("Kindly talk to administrator");
            }
            else if(Role.equalsIgnoreCase("admin")) {

                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    session.setAttribute("email", Email);
                    rd = request.getRequestDispatcher("index.jsp");
                } else {
                    request.setAttribute("status", "failed");
                    rd = request.getRequestDispatcher("login.jsp");
                }
                rd.forward(request, response);
            }
            else {
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    session.setAttribute("email", Email);
                    rd = request.getRequestDispatcher("admin.jsp");
                } else {
                    request.setAttribute("status", "failed");
                    rd = request.getRequestDispatcher("login.jsp");
                }
                rd.forward(request, response);
            }




        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getUserRoleByEmail(String Email)
    {
        String Role = null;
        String query = "SELECT Role FROM users WHERE Email = ? and IsApproved=true and IsActive=true and IsDeleted= false";
        try (Connection connection = connectionProvider.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query))
        {
            preparedStatement.setString(1, Email);
            try (ResultSet resultSet = preparedStatement.executeQuery())
            {
                if (resultSet.next())
                {
                    Role = resultSet.getString("Role");
                }
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return Role;
    }

}