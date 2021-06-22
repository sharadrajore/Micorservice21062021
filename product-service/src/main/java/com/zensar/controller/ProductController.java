package com.zensar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.zensar.entity.Coupon;
import com.zensar.entity.Product;
import com.zensar.services.ProductService;

@RestController
@RequestMapping("/api/v1")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@PostMapping("/products")
	public Product insertProduct(@RequestBody Product product) {
		// Making a call to coupon service
		Coupon coupon=restTemplate.getForObject("http://COUPON-SERVICE/api/v1/coupons/"+product.getCouponCode(), Coupon.class);
		product.setPrice(product.getPrice()-coupon.getDiscount());
		return productService.insertProduct(product);
	}
	

}
