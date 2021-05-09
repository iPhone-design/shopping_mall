package product.upload;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import jdbc.connectionProvider.ConnectionProvider;


public class ProductDao {
	public List<Product> readProduct() {
		List<Product> list = new ArrayList<>();
		try (Connection conn = ConnectionProvider.getConnection();
				PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM product_upload");
				ResultSet rs = pstmt.executeQuery();
				){
			while(rs.next()) {
				int productId = rs.getInt("product_id");
				String name = rs.getString("name");
				String photo_1 = rs.getString("photo-1");
				String photo_2 = rs.getString("photo-2");
				String photo_3 = rs.getString("photo-3");
				int price = rs.getInt("price");
				String description = rs.getString("description");
				list.add(new Product(productId, name, photo_1, photo_2, photo_3, price, description));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
}
