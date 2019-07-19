package org.web.dbconnect;

import java.sql.Connection;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class Dbconnect {

	public static Connection getConnection() {
		
		Connection conn = null;

		DataSource dataSource;

		try {
			Context context = new InitialContext();
			
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/mysqlDB");
			
			conn=dataSource.getConnection();
			
			System.out.println("DB  OK");

		} catch (Exception e) {
			e.printStackTrace();
		}

		return conn;
	}

}




