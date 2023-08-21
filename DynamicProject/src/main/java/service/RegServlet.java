package service;

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

        String fname = request.getParameter("fname");
        String lname = request.getParameter("lname");
        String password = request.getParameter("pass");
        String email = request.getParameter("email");
        String phoneno = request.getParameter("contact");

        RequestDispatcher rd = null;
        Connection conn = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/dynamicpage?useSSL=false","root","root");
            PreparedStatement ps = conn
                    .prepareStatement("insert into user(fname,lname,password,email,phoneno) values(?,?,?,?,?)");
            ps.setString(1,fname);
            ps.setString(2, lname);
            ps.setString(3, password);
            ps.setString(4, email);
            ps.setString(5, phoneno);

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
