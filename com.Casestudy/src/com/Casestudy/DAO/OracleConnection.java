package com.Casestudy.DAO;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;



/**
 * @author amahome
 *
 */
public class OracleConnection{
	
	/**
	 * @author Manju Ajithkumar
	 * This method establishes the connection to the database for the given credentials
	 * return type - Connection (object)
	 *
	 */
	public Connection getConnection() throws ClassNotFoundException,
	IOException, SQLException {
	final Properties prop = new Properties();
	final InputStream inputStream = OracleConnection.class.getClassLoader()
			.getResourceAsStream(
					"com/Casestudy/Resources/db.properties");
	prop.load(inputStream);
	Class.forName(prop.getProperty("driver"));
	final Connection connection = DriverManager.getConnection(prop.getProperty("url"), 
			prop.getProperty("user"), prop.getProperty("password"));
		System.out.println(connection.isClosed() ?"connection closed" : "connection is open");
	return connection;
	}
	
	protected Connection connection = null;
	protected PreparedStatement ps = null;
	protected ResultSet rs = null;
	protected Statement stmt = null;
	
	//method to close all connections
	public void dispose() {
		try {
			if (!rs.equals(null)) {
				if (!rs.isClosed()) rs.close();
			}
			if (ps.equals(null)) {
				if (!ps.isClosed()) ps.close();
			}
			if (connection.equals(null)) {
				if (!connection.isClosed()) connection.close();
			}
		}catch(SQLException e) {
		}catch (NullPointerException e) {
		}
	}
}
