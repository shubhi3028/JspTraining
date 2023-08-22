package service.Servlet;

import databaseConnection.connectionProvider;
import utils.JspUtils;

import java.io.IOException;
import java.sql.Connection;

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

        String ID= JspUtils.generateUUID();
        String FirstName = request.getParameter("fname");
        String LastName = request.getParameter("lname");
        String PhoneNumber = request.getParameter("contact");
        String Email = request.getParameter("email");
        String PasswordHash = request.getParameter("pass");
        String PasswordToHash = JspUtils.hashPassword(PasswordHash);
        String Role="customer";
        String Status= null;
        Boolean IsActive= true;
        Boolean IsApproved= false;
        Boolean IsDeleted= false;


        RequestDispatcher rd = null;
        Connection conn = null;

        try {
            conn= connectionProvider.getConnection();
            PreparedStatement ps = conn
                    .prepareStatement("insert into users(ID,FirstName,LastName,PhoneNumber,Email,PasswordHash,Role,Status,IsActive,IsApproved,IsDeleted) values(?,?,?,?,?,?,?,?,?,?,?)");
           ps.setString(1,ID);
            ps.setString(2,FirstName);
            ps.setString(3, LastName);
            ps.setString(4, PhoneNumber);
            ps.setString(5, Email);
            ps.setString(6, PasswordToHash);
            ps.setString(7,Role);
            ps.setString(8,Status);
            ps.setBoolean(9, IsActive);
            ps.setBoolean(10, IsApproved);
            ps.setBoolean(11, IsDeleted);
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
