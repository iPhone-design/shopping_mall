package manage_user.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import manage_user.model.User;
import manage_user.servlet.ConnectionProvider;

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
		try (Connection conn = ConnectionProvider.getConnection();
				PreparedStatement stmt = conn.prepareStatement("SELECT * FROM users");
				ResultSet rs = stmt.executeQuery();) {
			while (rs.next()) {
				// TODO 리스트 유저 객체 추가
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
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