package service.Servlet;



import databaseConnection.connectionProvider;



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



@WebServlet("/login")
public class Login extends HttpServlet {
    private static final long serialVersionUID = 1L;



    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String plainPassword = request.getParameter("password");



        HttpSession session = request.getSession();
        RequestDispatcher rd = null;
        Connection conn = connectionProvider.getConnection();
        PreparedStatement ps = null;



        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(plainPassword.getBytes());
            byte[] hashedPasswordBytes = md.digest();
            StringBuilder hashedPassword = new StringBuilder();



            for (byte b : hashedPasswordBytes) {
                hashedPassword.append(String.format("%02x", b));
            }



            ps = conn.prepareStatement("SELECT * FROM users WHERE Email = ? AND PasswordHash = ?");
            ps.setString(1, email);
            ps.setString(2, hashedPassword.toString());



            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                String username = rs.getString("email");



                session.setAttribute("email", email);
                session.setAttribute("username", username);



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