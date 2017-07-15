package com.wust.topsix.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.wust.topsix.beans.User;

public class UserDAO {
	public static final String DRIVER = "com.mysql.jdbc.Driver";
	public static final String DBURL = "jdbc:mysql://localhost:3306/travel";
	public static final String DBUSER = "root";
	public static final String DBPASS = "123456";
	private Connection conn = null;
	private PreparedStatement pStat = null;
	private ResultSet rs = null;

	public Connection getConnectionn() {
		try {
			Class.forName(DRIVER).newInstance();
			return DriverManager.getConnection(DBURL, DBUSER, DBPASS);
		} catch (Exception e) {
			return null;
		}
	}

	public void close() {
		try {
			if (rs != null)
				rs.close();
			if (pStat != null)
				pStat.close();
			if (conn != null)
				conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	} // end close

	public boolean isUsernameExists(String username) {
		conn = getConnectionn();
		try {
			pStat = conn.prepareStatement("select * from users where username=?");
			pStat.setString(1, username);
			rs = pStat.executeQuery();
			if (rs.next())
				return true;
			else
				return false;
		} catch (Exception e) {
			return false;
		} finally {
			close();
		}
	} // end isUsernameExists

	public boolean findUser(String username, String password) {
		conn = getConnectionn();
		try {
			pStat = conn.prepareStatement("select * from users where username=? and password=?");
			pStat.setString(1, username);
			pStat.setString(2, password);
			rs = pStat.executeQuery();
			if (rs.next())
				return true;
			else
				return false;
		} catch (Exception e) {
			return false;
		} finally {
			close();
		}
	} // end findUser

	@SuppressWarnings("finally")
	public User find_User(String username) {

		conn = getConnectionn();
		User user = new User();
		// ArrayList<User> list=new ArrayList<User>();
		try {
			pStat = conn.prepareStatement("select * from users where username=?");
			pStat.setString(1, username);
			rs = pStat.executeQuery();

			if (rs.next()) {
				int id = rs.getInt("id");
				String phone = rs.getString("phone");

				String password = rs.getString("password");

				user.setId(id);
				user.setPassword(password);
				user.setUsername(username);
				user.setPhone(phone);

			}

		} catch (Exception e) {

		} finally {
			close();

			return user;
		}

	} // end findUser

	public boolean usernameisadminstrator(String username) {
		if (username.equals("tmm") || username.equals("lsy"))
			return true;
		else
			return false;

	} // end findUser

	public boolean addUser(User user) {
		conn = getConnectionn();
		try {
			pStat = conn.prepareStatement("insert into users values(null,?,?,?)");
			pStat.setString(1, user.getUsername());
			pStat.setString(2, user.getPassword());
			pStat.setString(3, user.getPhone());
			int cnt = pStat.executeUpdate();
			if (cnt > 0)
				return true;

			else
				return false;
		} catch (Exception e) {
			return false;
		} finally {
			close();
		}
	} // end add

	public boolean deleteUser(String username) {
		conn = getConnectionn();
		try {
			pStat = conn.prepareStatement("delete from users where username=?");
			pStat.setString(1, username);
			int cnt = pStat.executeUpdate();
			if (cnt > 0)
				return true;
			else
				return false;
		} catch (Exception e) {
			return false;
		} finally {
			close();
		}
	} // end add

	public boolean updateUser(String username, String password) {
		conn = getConnectionn();
		try {

			pStat = conn.prepareStatement("update users set password=? where username=?");
			pStat.setString(1, password);

			pStat.setString(2, username);
			int cnt = pStat.executeUpdate();
			if (cnt > 0)
				return true;
			else
				return false;

		} catch (Exception e) {
			return false;
		} finally {
			close();
		}
	}
} // end class
