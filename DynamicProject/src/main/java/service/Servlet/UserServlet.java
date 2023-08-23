package service.Servlet;

import data.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserServlet {
    private Connection conn;

    public UserServlet(Connection conn) {
        super();
        this.conn = conn;
    }

//    public boolean addStudent(User user) {
//
//        boolean f = false;
//
//        try {
//            String sql = "insert into student_db(name,dob,address,qualification,email) values(?,?,?,?,?)";
//
//            PreparedStatement ps = conn.prepareStatement(sql);
//            ps.setString(1, user.getFirstName());
//            ps.setString(2, user.getEmail());
//            ps.setString(3);
//
//            int i = ps.executeUpdate();
//
//            if (i == 1) {
//                f = true;
//            }
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        return f;
//    }


//    public List<User> getAllUsers() {
//        List<User> list = new ArrayList();
//        User s = null;
//        try {
//            String sql = "select * from users";
//            PreparedStatement ps = conn.prepareStatement(sql);
//
//            ResultSet rs = ps.executeQuery();
//
//            while (rs.next()) {
//                s = new User();
//                s.setId(rs.getString(1));
//                s.setFirstName(rs.getString(2));
//                s.setLastName(rs.getString(3));
//                s.setEmail(rs.getString(4));
//                s.setPhoneNumber(rs.getString(5));
//                s.setPasswordHash(rs.getString(6));
//                list.add(s);
//            }
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return list;
//    }
//
//    public User getUserById(String id) {
////        List<User> list = new ArrayList<>();
//        User s = null;
//        try {
//            String sql = "select * from users where ID=?";
//            PreparedStatement ps = conn.prepareStatement(sql);
//            ps.setString(1, id);
//
//            ResultSet rs = ps.executeQuery();
//
//            while (rs.next()) {
//                s = new User();
//                s.setId(rs.getString(1));
//                s.setFirstName(rs.getString(2));
//                s.setLastName(rs.getString(3));
//                s.setEmail(rs.getString(4));
//                s.setPhoneNumber(rs.getString(5));
//                s.setPasswordHash(rs.getString(6));
//            }
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return s;
//    }
//
//    public boolean updateUser(User user) {
//
//        boolean f = false;
//
//        try {
//            String sql = "update users set FirstName=?,LastName=?,Email=?,PhoneNumber=?,PasswordHash=? where ID=?";
//
//            PreparedStatement ps = conn.prepareStatement(sql);
//            ps.setString(1, user.getFirstName());
//            ps.setString(2, user.getLastName());
//            ps.setString(3, user.getEmail());
//            ps.setString(4, user.getPhoneNumber());
//            ps.setString(5, user.getPasswordHash());
//            ps.setString(6, user.getId());
//
//            int i = ps.executeUpdate();
//
//            if (i == 1) {
//                f = true;
//            }
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        return f;
//    }

    public boolean deleteStudent(String id) {
        boolean f = false;

        try {
            String sql = "delete from users where ID=?";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, id);

            int i = ps.executeUpdate();

            if (i == 1) {
                f = true;
            }

        }catch(Exception e) {
            e.printStackTrace();
        }
        return f;
    }

}
