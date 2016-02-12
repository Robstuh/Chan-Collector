package com.databot.sql;

public class Database {

	public Database(String host, String dbName, String dbUser, String dbPass,
			boolean local, int pingtime) {
		this.host = host;
		this.dbName = dbName;
		this.dbUser = dbUser;
		this.dbPass = dbPass;
		this.local = local;
		this.pingtime = pingtime;
		this.databaseConnection = new DatabaseConnection(this);
	}

	public boolean local;
	public int pingtime;
	public String host, dbName, dbUser, dbPass;
	public DatabaseConnection databaseConnection;

}
