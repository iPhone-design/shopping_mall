package review;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet("/shopping_mall/reviewUpload")
public class ReviewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = getServletContext().getRealPath("");
		System.out.println(path);
		
		Part p = request.getPart("upload");
		System.out.println(p.getName());
		System.out.println(p.getSubmittedFileName());
		for (String name : p.getHeaderNames()) {
			System.out.println(name + " : " + p.getHeaders(name));
		}
		
		p.write(path + File.separator + p.getSubmittedFileName());
	}

}
