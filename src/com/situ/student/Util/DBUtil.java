package com.situ.student.Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtil {
	
	static {
		//1.加载驱动Class.forName("");
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	public static Connection getConnection() throws SQLException {
		//2.获取连接对象Connection
		 return DriverManager.getConnection("jdbc:mysql://localhost:3306/student_system","root","");
	}
	
	public static void close(Connection connection, Statement statement) {
		//6.后打开的先关闭
		if (statement != null) {
			try {
				statement.close();
				statement = null;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (connection != null) {
			try {
				connection.close();
				connection = null;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	public static void close(Connection connection, Statement statement, ResultSet resultSet) {
		//6.后打开的先关闭
		if (resultSet != null) {
			try {
				resultSet.close();
				resultSet = null;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (statement != null) {
			try {
				statement.close();
				statement = null;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (connection != null) {
			try {
				connection.close();
				connection = null;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
