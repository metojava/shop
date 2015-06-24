package com.shop.webservices.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.stereotype.Repository;

import com.shop.my.Products;

@Repository
public class ProductsDaoImpl implements ProductsDao {

	@Override
	public Products getProduct(String pid) {

		Products prod = new Products();
		String connectionURL = "jdbc:mysql://localhost:3306/shop";

		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(connectionURL, "root", "nbuser");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from products where id="
					+ pid);

			while (rs.next()) {

				prod.setId(rs.getInt(1));
                prod.setName(rs.getString(2));
                prod.setDescr(rs.getString(3));
                prod.setPrice(rs.getFloat(4));
                prod.setPhoto(rs.getString(5));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return prod;
	}

}
