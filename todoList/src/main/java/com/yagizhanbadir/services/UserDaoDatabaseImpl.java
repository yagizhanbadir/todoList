package com.yagizhanbadir.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UserDaoDatabaseImpl implements UserDao {

	private String kullanici_adi = "root";
	private String parola = "";
	private String db_ismi = "todolist"; // Database name
	private String host = "localhost";
	private int port = 3306;
	private Connection con = null;
	private Statement statement = null;
	private PreparedStatement preparedStatement = null;

	public UserDaoDatabaseImpl() {

		String url = "jdbc:mysql://" + host + ":" + port + "/" + db_ismi + "?useUnicode=true&characterEncoding=utf8";
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
		} catch (Exception e) {
			System.out.println("Driver Bulunamadý...");
		}

		try {
			con = DriverManager.getConnection(url, kullanici_adi, parola);
			System.out.println("Baðlantý Baþarýlý...");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String getUserId(String username) {
		String sorgu = "SELECT userUuid FROM user WHERE userName=?";
		try {
			preparedStatement = con.prepareStatement(sorgu);
			preparedStatement.setString(1, username);
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				String userUuid = rs.getString("userUuid");
				return userUuid;
			}

			return null;

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public void addUser(String userName, String password, String userId) {
		try {
			statement = con.createStatement();

			String sorgu2 = "SELECT *FROM user WHERE userName=?";
			preparedStatement = con.prepareStatement(sorgu2);
			preparedStatement.setString(1, userName);
			ResultSet rs = preparedStatement.executeQuery();
			if (!rs.next()) {
				String sorgu = "Insert Into user (userUuid, userName, password) VALUES(" + "'" + userId + "'," + "'"
						+ userName + "'," + "'" + password + "')";
				statement.executeUpdate(sorgu);
			}

		} catch (Exception e) {
			Logger.getLogger(UserDaoDatabaseImpl.class.getName()).log(Level.SEVERE, null, e);
		}
	}

	public boolean user(String username, String password) {

		String sorgu = "SELECT *FROM user WHERE userName=? and password=?";
		try {
			preparedStatement = con.prepareStatement(sorgu);
			preparedStatement.setString(1, username);
			preparedStatement.setString(2, password);
			ResultSet rs = preparedStatement.executeQuery();
			if (rs.next()) {
				return true;
			}

			return false;

		} catch (SQLException e) {

			e.printStackTrace();
			return false;

		}

	}
}