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
	public static int qnaAdd(Qna qna) {
		try (Connection conn = ConnectionProvider.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(
						"INSERT INTO qna(id, title, content, date) VALUES (?, ?, ?, ?)");) {
				pstmt.setString(1, qna.getId());
				pstmt.setString(2, qna.getTitle());
				pstmt.setString(3, qna.getContent());
				pstmt.setString(4, qna.getDate());
				return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return -1;
	}
	
	public ArrayList<Qna> qnaListRead(int pageNum) {
		ArrayList<Qna> list = new ArrayList<Qna>();
		try (Connection conn = ConnectionProvider.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(
						"SELECT * FROM qna WHERE n < ? AND available = 1 ORDER BY qna_num DESC LIMIT 10");
				ResultSet rs = pstmt.executeQuery();) {
			
			pstmt.setInt(1, getNext() - (pageNum -1) * 10);

			while (rs.next()) {
				Qna qna = new Qna();
				qna.setQna_Num(rs.getInt(1));
				qna.setId(rs.getString(2));
				qna.setTitle(rs.getString(3));
				qna.setDate(rs.getString(4));
				qna.setContent(rs.getString(5));
//				qna.setBbsAvailable(rs.getInt(6));
				list.add(qna);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list; 
	}
	
	//10 단위 페이징 처리를 위한 함수
	public boolean nextPage (int pageNum) {
		try (Connection conn = ConnectionProvider.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(
						"SELECT * FROM qna WHERE qna_num < ? AND available = 1 ORDER BY qna_num DESC LIMIT 10");
				ResultSet rs = pstmt.executeQuery();) {
			pstmt.setInt(1, getNext() - (pageNum -1) * 10);
			if (rs.next()) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public void qnaDelete(int num) {
		try (Connection conn = ConnectionProvider.getConnection();
				PreparedStatement pstmt = conn.prepareStatement("DELETE FROM qna WHERE qna_num = ?")) {
			pstmt.setInt(1, num);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//mysql에서 현재 시간을 가져오는 메소드
	public String getDate() { 
		ResultSet rs = null;
		try (Connection conn = ConnectionProvider.getConnection();
				PreparedStatement pstmt = conn.prepareStatement("SELECT NOW()");) {
			pstmt.executeQuery();
			if(rs.next()) {
				return rs.getString(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ""; //데이터베이스 오류
	}
	
	//게시글 번호(qna_num 칼럼) 가져오는 메소드
	public int getNext() {
		ResultSet rs = null;
		try (Connection conn = ConnectionProvider.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(
						"SELECT qna_num FROM qna ORDER BY qna_num DESC");) {
			rs = pstmt.executeQuery();
			if(rs.next()) {
				return rs.getInt(1) + 1;
			}
			return 1;//첫 번째 게시물인 경우
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1; //데이터베이스 오류
	}
}
