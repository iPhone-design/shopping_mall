package product.upload;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import product.ProductDao;

@WebServlet("/product_upload")
public class ProductUploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("/shopping_mall");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		URL uploadDir = getServletContext().getResource("imageUpload");
        String uploadPath = uploadDir.toString().substring(6);
		int maxSize = 1024 * 1024 * 100;
		String encoding = "UTF-8";
		
		MultipartRequest mutlpartRequest = new MultipartRequest(request, System.getProperty("java.io.tmpdir"), maxSize, encoding, new DefaultFileRenamePolicy());
		
		String name = mutlpartRequest.getParameter("product-title");
		String fileName = mutlpartRequest.getOriginalFileName("product-file");
		int price = Integer.parseInt(mutlpartRequest.getParameter("product-price"));
		String description = mutlpartRequest.getParameter("product-content");
		String now = new SimpleDateFormat("yyyy-MM-dd-HH_mm_ss_").format(new Date());
		
		
		File photo = mutlpartRequest.getFile("product-file");
		
		
		File file = new File(uploadDir + "/" + fileName);
		file.renameTo(new File(uploadDir + "/" + now + fileName));
		String renameFileName = now + fileName;
		
		File imgFile = new File(uploadPath + renameFileName);
		BufferedImage img = ImageIO.read(photo);
		ImageIO.write(img, "png", imgFile);
		
		ProductDao dao = new ProductDao();
		dao.addProduct(name, renameFileName, price, description);
		doGet(request, response);
	}

}
