/*
 * CODE,
 * CODE NUA,
 * CODE MAI...
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Son Vu
 */
public class DAO {
	public static Connection con;
	
	public DAO() {
		if(con == null) {
			String dbUrl = "jdbc:mysql://localhost:3306/nmcnpm?autoReconnect=true&useSSL=false";
			String dbClass = "com.mysql.cj.jdbc.Driver";
			try {
				Class.forName(dbClass);
				con = DriverManager.getConnection(dbUrl,"sonvu","mysql@password");
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		
	}
}
