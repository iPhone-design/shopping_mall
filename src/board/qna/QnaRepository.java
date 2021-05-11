package board.qna;

import java.util.List;

import review.Review;
import review.ReviewDAO;
import review.ReviewRepository;

public class QnaRepository {
	private static QnaRepository instance = new QnaRepository(new QnaDao());
	private QnaDao dao;
	
	public QnaRepository(QnaDao dao) {
		super();
		this.dao = dao;
	}

	public static QnaRepository getInstance() {
		return instance;
	}
	
	public void qnaAdd(Qna qna) {
		dao.qnaAdd(qna);
	}
	
	public List<Qna> qnaRead() {
		return dao.qnaRead();
	}
	
	public void qnaDelete(int num) {
		dao.qnaDelete(num);
	}
}
