package product.view;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import product.Product;
import product.ProductDao;

/**
 * Servlet implementation class ProductDetailServlet
 */
@WebServlet("/detail")
public class ProductDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProductDao dao = new ProductDao();
		List<Product> list = dao.readProduct();
		String id = request.getParameter("product_id");
		int productId = Integer.parseInt(id);
		for (int i = 0; i < list.size(); i++) {
			int getId = list.get(i).getProduct_id();
			if (productId == getId) {
				request.setAttribute("name", list.get(i).getName());
				ArrayList<String> fileNameList = new ArrayList<>();
				
				fileNameList.add(list.get(i).getPhoto_1());
				fileNameList.add(list.get(i).getPhoto_2());
				fileNameList.add(list.get(i).getPhoto_3());
				
				System.out.println(fileNameList);
				
				request.setAttribute("file-names", fileNameList);
				request.setAttribute("price", list.get(i).getPrice());
				request.setAttribute("description", list.get(i).getDescription());
				break;
			}
		}
		request.getRequestDispatcher("product-detail.jsp").forward(request, response);
	}

}
