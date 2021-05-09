package review;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jdbc.ConnectionProvider;

public class ReviewDAO {
	public int reviewAdd(Review review) {
		try (Connection conn = ConnectionProvider.getConnection();
				PreparedStatement pstmt = conn.prepareStatement("INSERT INTO review(id, fileName, text) VALUES (?, ?, ?)");) {
				pstmt.setString(1, review.getId());
				pstmt.setString(2, review.getFileName());
				pstmt.setString(3, review.getText());
				return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return -1;
	}
	
	public List<Review> reviewRead() {
		List<Review> list = new ArrayList<Review>();
		try (Connection conn = ConnectionProvider.getConnection();
				PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM review");
				ResultSet rs = pstmt.executeQuery();) {
			while (rs.next()) {
				list.add(new Review(rs.getString("id"), rs.getString("fileName"), rs.getString("text")));
			}
			if (list.size() > 0) {
				return list;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void reviewDelete(int num) {
		try (Connection conn = ConnectionProvider.getConnection();
				PreparedStatement pstmt = conn.prepareStatement("DELETE FROM review WHERE num = ?")) {
			pstmt.setInt(1, num);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
