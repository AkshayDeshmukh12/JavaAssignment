package com.nit.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nit.dto.ProductDTO;
import com.nit.entity.Category;
import com.nit.entity.Product;
import com.nit.repo.CategoryRepo;
import com.nit.repo.ProductRepo;

@Service
public class ProductService {

	@Autowired
	private ProductRepo productRepo;
	
	@Autowired
	private CategoryRepo cateRepo;
	
	public List<ProductDTO> getAllProduct()
	{
	 
		List<Product> products= productRepo.findAll();
		List<ProductDTO> prodDTO= new ArrayList<>();
		
		for(Product prod: products)
		{
			ProductDTO product= new ProductDTO();
		    product.setId(prod.getPid());
		    product.setPname(prod.getPname());
		    product.setPdesc(prod.getPdescription());
		    prodDTO.add(product);
		}
		return prodDTO;
	}

	public String saveProduct(Product product) {
		productRepo.save(product);
		return "Product Is saved with ID :: "+product.getPid();
	}

	public ProductDTO getProductById(Integer id) {
		
		Optional<Product> product= productRepo.findById(id);
		if(product.isPresent())
		{
			ProductDTO productDto= new ProductDTO();
			productDto.setId(product.get().getPid());
			productDto.setPdesc(product.get().getPdescription());
			productDto.setPname(product.get().getPname());
			return productDto;
		}
		else
			return null;
	}

	public String deleteByProductId(Integer id) {
	
		Optional<Product> productRecord= productRepo.findById(id);
		Integer categoryId= productRecord.get().getCategory().getCid();
		
		if(productRecord.isPresent())
		{
			productRepo.deleteById(id);
			cateRepo.deleteById(categoryId);
			return id+" :: Product Id is deleted";
		}
		return id+" :: Given product id not found";
	}

	public String updateProduct(Integer id, Product newProduct) {
		
		Optional<Product> prod= productRepo.findById(id);
		Product product=prod.get();
		if(prod.isPresent())
		{
			product.setPname(newProduct.getPname());
			product.setPdescription(newProduct.getPdescription());
			Category category = new Category();
			category.setCid(product.getCategory().getCid());
			category.setCname(newProduct.getCategory().getCname());
			category.setCdescription(newProduct.getCategory().getCdescription());
			product.setCategory(category);
			return id+ ":: Given Product Id Updated "+productRepo.save(product);
		}
		else
			return id+ ":: Given Product not found to update";
	}
}
