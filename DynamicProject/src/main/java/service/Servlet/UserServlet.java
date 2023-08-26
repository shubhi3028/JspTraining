package service.Servlet;

import data.entity.User;
import utils.JspUtils;

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

    public List<User> getAllUsers() {
        List<User> list = new ArrayList();
        User s = null;
        try {
            String sql = "select * from users where IsApproved=false and IsDeleted=false";
            PreparedStatement ps = conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                s = new User();
                s.setId(rs.getString(1));
                s.setFirstName(rs.getString(2));
                s.setLastName(rs.getString(3));
                s.setEmail(rs.getString(4));
                s.setPhoneNumber(rs.getString(5));
                s.setPasswordHash(rs.getString(6));
                list.add(s);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    public List<User> getUsers() {
        List<User> list = new ArrayList();
        User s = null;
        try {
            String sql = "select * from users where IsApproved=true and IsDeleted=false";
            PreparedStatement ps = conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                s = new User();
                s.setId(rs.getString(1));
                s.setFirstName(rs.getString(2));
                s.setLastName(rs.getString(3));
                s.setEmail(rs.getString(4));
                s.setPhoneNumber(rs.getString(5));
                s.setPasswordHash(rs.getString(6));
                list.add(s);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public User getUserById(String ID) {
        User s = null;
        try {
            String sql = "select * from users where ID=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, ID);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                s = new User();
                s.setId(rs.getString(1));
                s.setFirstName(rs.getString(2));
                s.setLastName(rs.getString(3));
                s.setEmail(rs.getString(4));
                s.setPhoneNumber(rs.getString(5));
                s.setPasswordHash(rs.getString(6));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return s;
    }

    public boolean updateUser(String ID, String FirstName, String LastName, String PhoneNumber, String PassWordHash, Boolean IsApproved) {

        boolean f = false;

        try {
          String sql=" Update users set FirstName=?,LastName=?,PhoneNumber=?,PasswordHash=?,IsApproved=?  where ID=? and IsDeleted=false";

            PreparedStatement ps = conn.prepareStatement(sql);
             IsApproved = false;

            ps.setString(1,FirstName);
            ps.setString(2, LastName);
            ps.setString(3, PhoneNumber);
            ps.setString(4,JspUtils.hashPassword(PassWordHash));
            ps.setBoolean(5,IsApproved);
            ps.setString(6,ID);



            Integer i = ps.executeUpdate();

            if (i ==1) {
                f = true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return f;
    }

    public boolean deleteUser(String ID) {
        boolean f = false;

        try {
            String sql = "update  users set IsDeleted= true  where ID=?";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, ID);

            int i = ps.executeUpdate();

            if (i == 1) {
                f = true;
            }

        }catch(Exception e) {
            e.printStackTrace();
        }
        return f;
    }



    public boolean approveUser(String ID) {
        boolean f = false;

        try {
            String sql = "update users set IsApproved= true  where ID=?";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, ID);

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
