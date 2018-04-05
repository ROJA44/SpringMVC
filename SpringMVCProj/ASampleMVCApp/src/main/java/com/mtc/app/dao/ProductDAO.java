package com.mtc.app.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.mtc.app.dao.mapper.ProductRowMapper;
import com.mtc.app.vo.Product;

@Repository("productDAO")
public class ProductDAO implements IProductDAO{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
		
	@Autowired
	private ProductRowMapper productRowMapper;
	
	@Autowired
	private ProductBatchPreparedStatementSetter productBatchPreparedStatementSetter;
	
	public void addProductsList(List<Product> products){

		String insertQuery = "insert into test.product(product_id,product_name,product_price,product_description)"
				+ "values(?,?,?,?)";
		
		productBatchPreparedStatementSetter.setProducts(products);
		
		jdbcTemplate.batchUpdate(insertQuery, productBatchPreparedStatementSetter);

		
	}
	
	public float getMaxPrice(){
		
		String selectQuery = "select max(product_price) from test.product";
		
		float maxPrice = jdbcTemplate.queryForObject(selectQuery,Float.class);
		
		return maxPrice;
	}
	
	public void addProduct(Product product) {
		String insertQuery = "insert into test.product(product_id,product_name,product_price,product_description)"
				+ "values(?,?,?,?)";
		
		int i = jdbcTemplate.update(insertQuery, product.getId(),product.getName(),product.getPrice(),product.getDescription());
		
		if(i == 1){
			System.out.println("Record added successfully");
		}
	}

	public Product getProductById(int id) {
		// TODO Auto-generated method stub
		String selectQuery = "select * from test.product where product_id=?";
		
		Product product = jdbcTemplate.queryForObject(selectQuery,productRowMapper,id);
		
		return product;
	}

	public List<Product> getProducts() {

		String selectQuery = "select * from test.product";
		
		List<Product> products = jdbcTemplate.query(selectQuery, productRowMapper);
		
		return products;
	}
	
	

}
