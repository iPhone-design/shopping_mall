package product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import jdbc.ConnectionProvider;


public class ProductDao {
	public List<Product> readProduct() {
		List<Product> list = new ArrayList<>();
		try (Connection conn = ConnectionProvider.getConnection();
				PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM product_upload");
				ResultSet rs = pstmt.executeQuery();
				){
			while(rs.next()) {
				int productId = rs.getInt("number");
				String name = rs.getString("name");
				String photo_1 = rs.getString("photo_1");
				String photo_2 = rs.getString("photo_2");
				String photo_3 = rs.getString("photo_3");
				int price = rs.getInt("price");
				String description = rs.getString("description");
				list.add(new Product(productId, name, photo_1, photo_2, photo_3, price, description));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public int addProduct(String name, String photo_1, int price, String description) {
		try (Connection conn = ConnectionProvider.getConnection();
				PreparedStatement pstmt = conn.prepareStatement("INSERT INTO product_upload(name, photo_1, price, description) VALUES (?, ?, ?, ?)");
				){
			pstmt.setString(1, name);
			pstmt.setString(2, photo_1);
			pstmt.setInt(3, price);
			pstmt.setString(4, description);
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return -1;
	}
}
