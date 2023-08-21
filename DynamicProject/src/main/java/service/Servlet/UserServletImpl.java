//package service.Servlet;
//
//import data.entity.User;
//import databaseConnection.Connection;
//import model.request.CreateUserRequest;
//import model.response.CreateUserResponse;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import service.UserServlet;
//import utils.JspUtils;
//
//import javax.servlet.RequestDispatcher;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.util.Date;
//
//@WebServlet("/register")
//public class UserServletImpl extends HttpServlet {
//    @Autowired
//    private Connection connection;
//    private void createUser(CreateUserRequest request, CreateUserResponse response) throws ServletException, IOException {
//
//        User user= new User();
//        user.setId(JspUtils.generateUUID());
//        user.setFirstName(request.getFirstName());
//        user.setLastName(request.getLastName());
//        user.setPhoneNumber(request.getPhoneNumber());
//        user.setEmail(request.getEmail());
//        user.setPasswordHash(request.getPassword());
//        user.setRole("customer");
//        user.setStatus(null);
//        user.setIsActive(true);
//        user.setIsApproved(false);
//        user.setIsDeleted(false);
//        user.setCreatedAt(new Date());
//        user.setModifiedAt(new Date());
//
//
//
//
////        String uname=request.("name");
////        String upwd=request.getParameter("pass");
////        String uemail=request.getParameter("email");
////        String umobile=request.getParameter("contact");
////        String url = "jdbc:mysql://127.0.0.1:3306/jsp?useSSL=false";
////        String user = "root";
////        String password = "root";
////        RequestDispatcher dispatcher=null;
////        Connection con=null;
////
////        try {
////            Class.forName("com.mysql.cj.jdbc.Driver");
////            con= DriverManager.getConnection(url,user,password);
////
////            PreparedStatement pst=con.prepareStatement("insert into users(uname,upwd,uemail,umobile) values(?,?,?,?)");
////            pst.setString(1, uname);
////            pst.setString(2, upwd);
////            pst.setString(3, uemail);
////            pst.setString(4, umobile);
////
////            int rowCount =  pst.executeUpdate();
////            dispatcher=request.getRequestDispatcher("registration.jsp");
////            if(rowCount>0) {
////                request.setAttribute("status", "success");
////
////
////            }
////            else {
////                request.setAttribute("status", "failed");
////
////            }
////            dispatcher.forward(request, response);
////
////        }catch(Exception e) {
////            e.printStackTrace();
////
////        }finally {
////            try {
////                if (con != null) {
////                    con.close();
////                }
////            } catch (SQLException e) {
////                e.printStackTrace();
////            }
////        }
////
////
////
////    }
//
//}
//
//
