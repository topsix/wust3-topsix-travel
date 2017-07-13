package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import beans.Order;
import beans.User;

public class OrderDAO {
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

//	public boolean isOrderidExists(int orderid) {
//		conn = getConnectionn();
//		try {
//			pStat = conn.prepareStatement("select * from orders where orderid=?");
//			pStat.setInt(1, orderid);
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
//	} // end isUsernameExists

//	public boolean findUser(String username, String password) {
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
	public Order find_User(String username,String status) {

		conn = getConnectionn();
		Order order = new Order();
		// ArrayList<User> list=new ArrayList<User>();
		try {
			pStat = conn.prepareStatement("select * from orders where username=? and status=?");
			pStat.setString(1, username);
			pStat.setString(1, status);
			rs = pStat.executeQuery();

			if (rs.next()) {
				int orderid=rs.getInt("orderid");
				String sightname=rs.getString("sightname");
				
				order.setOrderid(orderid);
				order.setSightname(sightname);
				order.setUsername(username);
				order.setStatus(status);

			}

		} catch (Exception e) {

		} finally {
			close();

			return order;
		}

	} // end findUser

//	public boolean usernameisadminstrator(String username) {
//		if (username.equals("tmm") || username.equals("lsy"))
//			return true;
//		else
//			return false;
//
//	} // end findUser

	public boolean addOrder(Order order) {
		conn = getConnectionn();
		try {
			pStat = conn.prepareStatement("insert into orders values(null,?,?,?)");
			pStat.setInt(1, order.getOrderid());
			pStat.setString(2, order.getUsername());
			pStat.setString(3, order.getSightname());
			pStat.setString(4, order.getStatus());
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

	public boolean deleteOrder(String status) {
		conn = getConnectionn();
		try {
			pStat = conn.prepareStatement("delete from orders where status=?");
			pStat.setString(1, status);;
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

	public boolean updateUser(int orderid, String status) {
		conn = getConnectionn();
		try {

			pStat = conn.prepareStatement("update orders set status=? where orderid=?");
			pStat.setString(1, status);
			
			pStat.setInt(2, orderid);
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

}