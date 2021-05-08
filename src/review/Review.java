package review;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.Serializable;

public class Review implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private int num;
	private String id;
	private String filePath;
	private String text;
	private byte[] image;
	
	public Review(String id, String filePath, String text) {
		this.id = id;
		this.filePath = filePath;
		this.text = text;
	}
	
	public Review(String id, byte[] image, String text) {
		this.id = id;
		this.image = image;
		this.text = text;
	}

	public Review(String filePath) {
		super();
		this.filePath = filePath;
	}

	public String getId() {
		return id;
	}
	
	public String getFilePath() {
		return filePath;
	}

	public String getText() {
		return text;
	}
	
	public byte[] getImage() {
		return image;
	}
	
	public int getNum() {
		return num;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((filePath == null) ? 0 : filePath.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((text == null) ? 0 : text.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Review other = (Review) obj;
		if (filePath == null) {
			if (other.filePath != null)
				return false;
		} else if (!filePath.equals(other.filePath))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (text == null) {
			if (other.text != null)
				return false;
		} else if (!text.equals(other.text))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "Review [id=" + id + ", filePath=" + filePath + ", text=" + text + "]";
	}
	
	public static byte[] imageToByteArray(String filePath) {
		byte[] returnValue = null;
		ByteArrayOutputStream baos =null;
		FileInputStream fis = null;
		
		try {
			baos = new ByteArrayOutputStream();
			fis =  new FileInputStream(filePath);
			
			byte[] buf = new byte[1024];
			int read = 0;
			
			while((read=fis.read(buf, 0, buf.length)) != -1) {
				baos.write(buf, 0, read);
			}
			
			returnValue = baos.toByteArray();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (baos != null) {
				try {
					baos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (fis != null) {
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return returnValue;
	}
}
