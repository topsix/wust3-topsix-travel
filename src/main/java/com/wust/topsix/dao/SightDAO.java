package com.wust.topsix.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.wust.topsix.beans.Sight;

public class SightDAO {
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
	} 
	@SuppressWarnings("finally")
	public Sight find_Sight(String sightname) {

		conn = getConnectionn();
		Sight sight = new Sight();
		// ArrayList<User> list=new ArrayList<User>();
		try {
			pStat = conn.prepareStatement("select * from sight where sightname=?");
			pStat.setString(1, sightname);
			rs = pStat.executeQuery();

			if (rs.next()) {
				int price = rs.getInt("price");
				String place = rs.getString("place");
				String detail = rs.getString("detail");
				String picture = rs.getString("picture");
				sight.setSightname(sightname);
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

	} 
}
