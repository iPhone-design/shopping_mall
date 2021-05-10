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

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		URL uploadDir = getServletContext().getResource("imageUpload");
        String uploadPath = uploadDir.toString().substring(6);
		int maxSize = 1024 * 1024 * 100;
		String encoding = "UTF-8";
		
		MultipartRequest mutlpartRequest = new MultipartRequest(request, System.getProperty("java.io.tmpdir"), maxSize, encoding, new DefaultFileRenamePolicy());
		
		String name = mutlpartRequest.getParameter("product-title");
		String[] fileName = new String[3];
		File[] photo = new File[3];
		for (int i = 0; i < 3; i++) {
			fileName[i] = mutlpartRequest.getOriginalFileName("product-file" + (i + 1));
			photo[i] = mutlpartRequest.getFile("product-file" + (i + 1));
		}
		int price = Integer.parseInt(mutlpartRequest.getParameter("product-price"));
		String description = mutlpartRequest.getParameter("product-content");
		String now = new SimpleDateFormat("yyyy-MM-dd-HH_mm_ss_").format(new Date());
		
		
		
		System.out.println(mutlpartRequest.getParameterValues("product-file"));
		ProductDao dao = new ProductDao();
		String[] renameFileName = new String[3];
		for (int i = 0; i < 3; i++) {
			File file = new File(uploadDir + "/" + fileName[i]);
			file.renameTo(new File(uploadDir + "/" + now + fileName[i]));
			renameFileName[i] = now + fileName[i];
			File imgFile = new File(uploadPath + renameFileName[i]);
			if (photo[i] != null) {
				BufferedImage img = ImageIO.read(photo[i]);
				ImageIO.write(img, "png", imgFile);
			}
		}
		dao.addProduct(name, renameFileName[0], renameFileName[1], renameFileName[2], price, description);
		
		response.sendRedirect("/shopping_mall");
	}

}
