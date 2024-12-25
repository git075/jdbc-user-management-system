package dev.anurag.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dev.anurag.config.DataBaseConfig;
import dev.anurag.encryption.EncryptionUtil;
import dev.anurag.entity.User;

public class Model {
	
	public static List<User> getallUsers(){
		List<User> list = new ArrayList<>();
		Connection connect = DataBaseConfig.getConnection();
		try {
			PreparedStatement ps = connect.prepareStatement("select * from users");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				int id = rs.getInt(1);
				String encryptedname = rs.getString(2);
				String encryptedemail = rs.getString(3);
				String decryptedName = EncryptionUtil.decrypt(encryptedname);
				String decryptedEmail = EncryptionUtil.decrypt(encryptedemail);
				User users = new User(id,decryptedName,decryptedEmail);
				list.add(users);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	public static void insert(User user) {
		Connection conn = DataBaseConfig.getConnection();
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement("insert into users values(default, ?, ?)");
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getEmail());
			ps.executeUpdate();
	
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void update(User user) {
		try {
			Connection conn = DataBaseConfig.getConnection();
			PreparedStatement ps = conn.prepareStatement("update users set name = ?, email = ?, where id= ?");
			ps.setString(1,user.getUsername());
	        ps.setString(2,user.getEmail());
	        ps.setInt(3,user.getUser_id());
	        ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static void delete(int id) {
		Connection conn = DataBaseConfig.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement("delete from users where id = ?");
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}
}
