package com.databot.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConnection {

	public Connection con = null;
	public Statement stm;
	private long lastUsed = System.currentTimeMillis();
	public Database database;

	public DatabaseConnection(Database database) {
		this.database = database;
		requestConnection();
	}

	private void requestConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			con = DriverManager.getConnection("jdbc:mysql://" + database.host
					+ (database.local ? "" : ":3306") + "/" + database.dbName,
					database.dbUser, database.dbPass);
			stm = con.createStatement();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Connection getConnection() throws Exception {
		if (con == null) {
			throw new Exception("Connection is null");
		}
		if (System.currentTimeMillis() - lastUsed > database.pingtime) {
			try {
				lastUsed = System.currentTimeMillis();
				con.close();
				requestConnection();
			} catch (Exception e) {
				throw new Exception("Error refreshing database connection");
			}
		}
		return con;
	}

	public ResultSet query(String s) throws SQLException {
		try {
			if (s.toLowerCase().startsWith("select")) {
				ResultSet rs = stm.executeQuery(s);
				System.out.println("1:" + s);
				return rs;
			} else {
				System.out.println("2:" + s);
				stm.executeUpdate(s);
			}
			return null;
		} catch (Exception e) {
			System.out.println("MySQL Error:" + s);
			e.printStackTrace();
		}
		return null;
	}

	public void destroyCon() {
		try {
			stm.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
