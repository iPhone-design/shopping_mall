package board.qna.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.Date;

import board.qna.Article;
import jdbc.ConnectionProvider;

public class ArticleDao {
	public Article insert(Article article) throws SQLException {
		Statement stmt = null;
		ResultSet rs = null;
		
		try (Connection conn = ConnectionProvider.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(
						"INSERT INTO qna_article" + 
						" (writer_id, writer_name, title, regdate, moddate, read_cnt)" + 
						" VALUES (?, ?, ?, ? ,?, 0)");) {
			pstmt.setString(1, article.getWriter().getId());
			pstmt.setString(2, article.getWriter().getName());
			pstmt.setString(3, article.getTitle());
			pstmt.setTimestamp(4, toTimeStamp(article.getRegDate()));
			pstmt.setTimestamp(5, toTimeStamp(article.getModifiedDate()));
			int insertedCount = pstmt.executeUpdate();
			
			if (insertedCount > 0) {
				stmt = conn.createStatement();
				rs = stmt.executeQuery("SELECT last_insert_id() FROM qna_article");
				if (rs.next()) {
					Integer newNum = rs.getInt(1);
					return new Article(newNum,
							article.getWriter(),
							article.getTitle(),
							article.getRegDate(),
							article.getModifiedDate(), 0);
				}
			}
			return null;
		}
	}
	
	private Timestamp toTimeStamp(Date date) {
		return new Timestamp(date.getTime());
	}
}
