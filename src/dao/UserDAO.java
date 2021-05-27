/*
 * CODE,
 * CODE NUA,
 * CODE MAI...
 */
package dao;

import model.User;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Son Vu
 */
public class UserDAO extends DAO {
	public UserDAO() {
		super();
	}
	
	public boolean checkLogin(User user) {
		boolean result = false;
		String query = "SELECT id,name,position FROM tbluser WHERE username = ? AND password = ?";
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1,user.getUsername());
			ps.setString(2, user.getPassword());
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				user.setPosition(rs.getString("position"));
				user.setName(rs.getString("name"));
				user.setId(rs.getInt("id"));
				result = true;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return result;
	}
	
}
