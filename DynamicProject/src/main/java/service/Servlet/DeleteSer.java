package service.Servlet;


import databaseConnection.connectionProvider;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/delete")
public class DeleteSer extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        String ID = req.getParameter("id");


        UserServlet dao = new UserServlet(connectionProvider.getConnection());
        boolean f = dao.deleteUser(ID);


        HttpSession session = req.getSession();


        if (f) {
            session.setAttribute("succMsg", "User details deleted sucessfully...");
            resp.sendRedirect("index.jsp");
        } else {
            session.setAttribute("errorMsg", "Something wrong on server!");
            resp.sendRedirect("index.jsp");
        }


    }
}
