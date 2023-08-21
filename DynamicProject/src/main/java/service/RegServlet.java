package service;

import databaseConnection.connectionProvider;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/register")
public class RegServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String FirstName = request.getParameter("fname");
        String LastName = request.getParameter("lname");
        String Password = request.getParameter("pass");
        String PhoneNumber = request.getParameter("contact");
        String Email = request.getParameter("email");

        RequestDispatcher rd = null;
        Connection conn = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn= connectionProvider.getConnection();
            PreparedStatement ps = conn
                    .prepareStatement("insert into user(FirstName,LastName,Password,PhoneNumber,Email) values(?,?,?,?,?)");
            ps.setString(1,FirstName);
            ps.setString(2, LastName);
            ps.setString(3, Password);
            ps.setString(4, PhoneNumber);
            ps.setString(5, Email);

            int rowCount = ps.executeUpdate();
            rd = request.getRequestDispatcher("registration.jsp");

            if(rowCount > 0) {
                request.setAttribute("status", "success");

            }else {
                request.setAttribute("status", "failed");
            }

            rd.forward(request, response);

        }catch(Exception e) {
            e.printStackTrace();
        }
        finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
