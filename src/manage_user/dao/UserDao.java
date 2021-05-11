package manage_user.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jdbc.ConnectionProvider;
import manage_user.model.User;

public class UserDao {
	public void add(User user) {
		try (Connection conn = ConnectionProvider.getConnection();
				PreparedStatement stmt = conn.prepareStatement("")) {
			// TODO 쿼리문 작성
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	private User resultSetMapper(ResultSet rs) {
		// TODO 객체 생성
		return new User();
	}
	public User getByID(int id) throws SQLException {
		User user = null;
		try (Connection conn = ConnectionProvider.getConnection();
				PreparedStatement stmt = conn.prepareStatement("")) {
			stmt.setInt(1, id);
			try (ResultSet rs = stmt.executeQuery();) {
				while(rs.next()) {
					user = resultSetMapper(rs);
				}
			}
		}
		return user;
	}
	public List<User> getAll() {
		List<User> list = new ArrayList<>();
		User user = null;
		try (Connection conn = ConnectionProvider.getConnection();
				PreparedStatement stmt = conn.prepareStatement("SELECT * FROM users");
				ResultSet rs = stmt.executeQuery();) {
			while (rs.next()) {
				user = new User();
				user.setUser_num(rs.getInt("user_num"));
				user.setId(rs.getString("id"));
				user.setName(rs.getString("name"));
				user.setBirth(rs.getDate("birth"));
				user.setPhone_num(rs.getInt("phone_num"));
				user.setAddress(rs.getString("address"));
				user.setJoin_date(rs.getDate("join_date").toLocalDate());
				user.setGrade(rs.getInt("grade"));
				list.add(user);
				user.toString();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		list.toString();
		return list;
	}
	public void update(User user) throws SQLException {
		try (Connection conn = ConnectionProvider.getConnection();
				PreparedStatement stmt = conn.prepareStatement("");) {
			// TODO 쿼리문 작성, 값 지정
		}
	}
	public void delete(int id) throws SQLException {
		try (Connection conn = ConnectionProvider.getConnection();
				PreparedStatement stmt = conn.prepareStatement("DELETE FROM users WHERE id = ?");) {
			stmt.setInt(1, id);
			stmt.executeUpdate();
		}
	}
}