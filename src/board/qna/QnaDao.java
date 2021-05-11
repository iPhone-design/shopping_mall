package board.qna;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

import jdbc.ConnectionProvider;

public class QnaDao {
	public int qnaAdd(Qna qna) {
		try (Connection conn = ConnectionProvider.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(
						"INSERT INTO qna(id, title, date) VALUES (?, ?, ?)");) {
				pstmt.setString(1, qna.getId());
				pstmt.setString(2, qna.getTitle());
				pstmt.setTimestamp(3, (Timestamp) qna.getDate());
				return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return -1;
	}
	
	public List<Qna> qnaRead() {
		List<Qna> list = new ArrayList<Qna>();
		try (Connection conn = ConnectionProvider.getConnection();
				PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM review");
				ResultSet rs = pstmt.executeQuery();) {
			while (rs.next()) {
				list.add(new Qna(rs.getString("id"), rs.getString("title"), rs.getDate("date")));
			}
			if (list.size() > 0) {
				return list;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void qnaDelete(int num) {
		try (Connection conn = ConnectionProvider.getConnection();
				PreparedStatement pstmt = conn.prepareStatement("DELETE FROM qna WHERE num = ?")) {
			pstmt.setInt(1, num);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
