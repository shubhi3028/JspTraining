package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import data.entity.UserEntity;

public class UserDao {
	private Connection conn;

	public UserDao(Connection conn) {
		super();
		this.conn = conn;
	}

	public boolean addUser(UserEntity userEntity) {

		boolean f = false;

		try {
			String sql = "insert into user(fname,lname,password,email,phoneno) values(?,?,?,?,?)";

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, userEntity.getFname());
			ps.setString(2, userEntity.getLname());
			ps.setString(3, userEntity.getPassword());
			ps.setString(4, userEntity.getEmail());
			ps.setString(5, userEntity.getPhoneno());

			int i = ps.executeUpdate();

			if (i == 1) {
				f = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return f;
	}

	public List<UserEntity> getAllUser() {
		List<UserEntity> list = new ArrayList<UserEntity>();
		UserEntity s = null;
		try {
			String sql = "select * from user";
			PreparedStatement ps = conn.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				s = new UserEntity();
				s.setId(rs.getInt(1));
				s.setFname(rs.getString(2));
				s.setLname(rs.getString(3));
				s.setPassword(rs.getString(4));
				s.setEmail(rs.getString(5));
				s.setPhoneno(rs.getString(6));
				list.add(s);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public UserEntity getStudentById(int id) {
		List<UserEntity> list = new ArrayList<UserEntity>();
		UserEntity s = null;
		try {
			String sql = "select * from user where id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				s = new UserEntity();
				s.setId(rs.getInt(1));
				s.setFname(rs.getString(2));
				s.setLname(rs.getString(3));
				s.setPassword(rs.getString(4));
				s.setEmail(rs.getString(5));
				s.setPhoneno(rs.getString(6));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return s;
	}

	public boolean updateStudent(UserEntity userEntity) {

		boolean f = false;

		try {
			String sql = "update user set fname=?,lname=?,password=?,email=?,phoneno=? where id=?";

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, userEntity.getFname());
			ps.setString(2, userEntity.getLname());
			ps.setString(3, userEntity.getPassword());
			ps.setString(4, userEntity.getEmail());
			ps.setString(5, userEntity.getPhoneno());
			ps.setInt(6, userEntity.getId());

			int i = ps.executeUpdate();

			if (i == 1) {
				f = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return f;
	}
	
	public boolean deleteUser(int id) {
		boolean f = false;
		
		try {
			String sql = "delete from user where id=?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			
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
