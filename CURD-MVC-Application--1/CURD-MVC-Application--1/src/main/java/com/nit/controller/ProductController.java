package com.nit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nit.dto.ProductDTO;
import com.nit.entity.Product;
import com.nit.service.ProductService;

@RestController
@RequestMapping("/api/products")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@GetMapping
	public List<ProductDTO> getAllProduct(@RequestParam("page") Integer pageno)
	{
		return productService.getAllProduct();
	}
	
	@PostMapping
	public String saveProduct(@RequestBody Product product)
	{
		return productService.saveProduct(product);
	}
	
	@GetMapping("{di}")
	public ProductDTO getProductById(@PathVariable("di") Integer id)
	{
		return productService.getProductById(id);
	}
	@DeleteMapping("{di}")
	public String deleteProductById(@PathVariable("di") Integer id)
	{
		return productService.deleteByProductId(id);
	}
	
	@PutMapping("{di}")
	public String updateProduct(@PathVariable("di") Integer id, @RequestBody Product product )
	{
		return productService.updateProduct(id,product);
	}
}
