package board.qna;

import java.util.Date;

public class Qna {
	private int num;
	private String id;
	private String title;
	private Date date;
	
	public Qna() {
		super();
	}

	
	public Qna(String id, String title, Date date) {
		super();
		this.id = id;
		this.title = title;
		this.date = date;
	}

	public Qna(int num, String id, String title, Date date) {
		super();
		this.num = num;
		this.id = id;
		this.title = title;
		this.date = date;
	}

	public int getNum() {
		return num;
	}

	public String getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public Date getDate() {
		return date;
	}

	@Override
	public String toString() {
		return "Qna [num=" + num + ", id=" + id + ", title=" + title + ", date=" + date + "]";
	}
}
