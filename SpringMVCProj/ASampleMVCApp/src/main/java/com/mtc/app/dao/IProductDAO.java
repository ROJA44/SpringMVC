package com.mtc.app.dao;

import java.util.List;

import com.mtc.app.vo.Product;

public interface IProductDAO {
	
	public void addProduct(Product product);
	
	public Product getProductById(int id);
	
	public List<Product> getProducts();

}
