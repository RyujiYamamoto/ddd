package com.yamari.idddd.domain.Services;

import com.yamari.idddd.domain.models.Users.User;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserService {
	
	/**
	 * ���[�U�̏d���m�F���s���B
	 * @param user 
	 * @return �d�����Ă����true, �d�����Ă��Ȃ����false
	 */
	public boolean exists(User user) {
		boolean exists = false;
		String url ="jdbc:postgresql://localhost:5432/testdb";
		String dbUser = "postgres";
		String password = "mysecretpassword1234";
		try(Connection conn = DriverManager.getConnection(url, dbUser, password);
			PreparedStatement ps =  conn.prepareStatement("SELECT * FROM users WHERE name = ?");) {
			ps.setString(1, user.name.getValue());
			try(ResultSet rs = ps.executeQuery()){
				exists = rs.next();
			}
		} catch (SQLException e) {			
			System.out.println(e.getErrorCode());
			System.out.println(e.getSQLState());
			System.out.println(e.getMessage());
		}
		
		return exists;
	}
}
