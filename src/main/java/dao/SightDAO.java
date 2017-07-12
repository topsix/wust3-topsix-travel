package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import beans.Sight;;

public class SightDAO {
	public static final String DRIVER = "com.mysql.jdbc.Driver";
	public static final String DBURL = "jdbc:mysql://localhost:3306/travel";
	public static final String DBUSER = "root";
	public static final String DBPASS = "tmm";
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

	public boolean isSightnameExists(String sightname) {
		conn = getConnectionn();
		try {
			pStat = conn.prepareStatement("select * from sight where sightname=?");
			pStat.setString(1, sightname);
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

//	public boolean findSight(String username, String password) {
//		conn = getConnectionn();
//		try {
//			pStat = conn.prepareStatement("select * from users where username=? and password=?");
//			pStat.setString(1, username);
//			pStat.setString(2, password);
//			rs = pStat.executeQuery();
//			if (rs.next())
//				return true;
//			else
//				return false;
//		} catch (Exception e) {
//			return false;
//		} finally {
//			close();
//		}
//	} // end findUser

	@SuppressWarnings("finally")
	public Sight find_User(String sightname) {

		conn = getConnectionn();
		Sight sight = new Sight();
		// ArrayList<User> list=new ArrayList<User>();
		try {
			pStat = conn.prepareStatement("select * from users where sightname=?");
			pStat.setString(1, sightname);
			rs = pStat.executeQuery();

			if (rs.next()) {
				int price = rs.getInt("price");
				String place = rs.getString("place");
                String detail=rs.getString("detail");
				String picture = rs.getString("picture");

				sight.setDetail(detail);
				sight.setPicture(picture);
				sight.setPlace(place);
				sight.setPrice(price);

			}

		} catch (Exception e) {

		} finally {
			close();

			return sight;
		}

	} // end findUser


//	public boolean usernameisadminstrator(String username) {
//		if (username.equals("tmm") || username.equals("lsy"))
//			return true;
//		else
//			return false;
//
//	} // end findUser

//	public boolean addSight(Sight sight) {
//		conn = getConnectionn();
//		try {
//			pStat = conn.prepareStatement("insert into users values(null,?,?,?)");
//			pStat.setString(1, sight.getSightname());
//			pStat.setString(2, sight.getPlace());
//			pStat.setString(3, sight.getPicture());
//			int cnt = pStat.executeUpdate();
//			if (cnt > 0)
//				return true;
//
//			else
//				return false;
//		} catch (Exception e) {
//			return false;
//		} finally {
//			close();
//		}
//	} // end add
//
//	public boolean deleteUser(String username) {
//		conn = getConnectionn();
//		try {
//			pStat = conn.prepareStatement("delete from users where username=?");
//			pStat.setString(1, username);
//			int cnt = pStat.executeUpdate();
//			if (cnt > 0)
//				return true;
//			else
//				return false;
//		} catch (Exception e) {
//			return false;
//		} finally {
//			close();
//		}
//	} // end add
//
//	public boolean updateUser(String username, String password, String phone) {
//		conn = getConnectionn();
//		try {
//
//			pStat = conn.prepareStatement("update users set password=?&phone=? where username=?");
//			pStat.setString(1, password);
//			pStat.setString(2, phone);
//			pStat.setString(3, username);
//			int cnt = pStat.executeUpdate();
//			if (cnt > 0)
//				return true;
//			else
//				return false;
//
//		} catch (Exception e) {
//			return false;
//		} finally {
//			close();
//		}
//	}
//
}
