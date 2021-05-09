package product.upload;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import product.ProductDao;

@WebServlet("/product_upload")
public class ProductUploadServlet extends HttpServlet {
	private String uploadDir;
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("/shopping_mall");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		uploadDir = this.getClass().getResource("").getPath();
		
		uploadDir = uploadDir.substring(1, uploadDir.indexOf(".metadata")) + "shopping_mall/WebContent/imageUpload";
		
        
        
		int maxSize = 1024 * 1024 * 100;
		String encoding = "UTF-8";
		
		MultipartRequest mutlpartRequest = new MultipartRequest(request, uploadDir, maxSize, encoding, new DefaultFileRenamePolicy());
		
		String name = mutlpartRequest.getParameter("product-title");
		String fileName = mutlpartRequest.getOriginalFileName("product-file");
		int price = Integer.parseInt(mutlpartRequest.getParameter("product-price"));
		String description = mutlpartRequest.getParameter("product-content");
		String now = new SimpleDateFormat("yyyy-MM-dd-HH_mm_ss_").format(new Date());

		File file = new File(uploadDir + "/" + fileName);
		file.renameTo(new File(uploadDir + "/" + now + fileName));
		String renameFileName = now + fileName;
		
		ProductDao dao = new ProductDao();
		dao.addProduct(name, renameFileName, price, description);
		doGet(request, response);
	}

}
