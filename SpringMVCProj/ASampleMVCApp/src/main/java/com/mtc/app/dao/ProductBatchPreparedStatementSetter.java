package com.mtc.app.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.stereotype.Component;

import com.mtc.app.vo.Product;

@Component("productBatchPreparedStatementSetter")
public class ProductBatchPreparedStatementSetter implements BatchPreparedStatementSetter{
	
	private List<Product> products;
	
	public int getBatchSize() {
		// TODO Auto-generated method stub
		return products.size();
	}
	
	public void setValues(PreparedStatement preparedStatement, int index) throws SQLException {
		// TODO Auto-generated method stub
		
		Product product = products.get(index);
		
		preparedStatement.setInt(1, product.getId());
		preparedStatement.setString(2,product.getName());
		preparedStatement.setFloat(3, product.getPrice());
		preparedStatement.setString(4, product.getDescription());
		
	}
	
	public void setProducts(List<Product> products) {
		this.products = products;
	}

}
