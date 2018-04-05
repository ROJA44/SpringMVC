package com.mtc.app.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.mtc.app.dao.IProductDAO;
import com.mtc.app.vo.Product;

@Controller
public class ProductController {
	
	@Autowired
	private IProductDAO productDAO;

	@RequestMapping("/searchProduct")
	public ModelAndView processSearchProduct(HttpServletRequest request){
		
		int productId = Integer.parseInt(request.getParameter("productId"));
		
		Product product = productDAO.getProductById(productId);
		
		ModelAndView modelAndView = new ModelAndView("productView");
		
		modelAndView.addObject("product",product);
		
		return modelAndView;
	}
	
}
