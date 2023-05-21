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

import com.nit.dto.CategoryDTO;
import com.nit.entity.Category;
import com.nit.service.CategoryService;

import jakarta.websocket.server.PathParam;

@RestController
@RequestMapping("/api/category")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;
	
	@GetMapping
	public List<CategoryDTO> getAllCategory(@RequestParam("page") Integer pageno)
	{
		return categoryService.getAllCategory();
	}
	@PostMapping
	public String saveCategory(@RequestBody Category category)
	{
		return categoryService.saveCategory(category);
	}
	@GetMapping("/{di}")
	public CategoryDTO getCateById(@PathVariable("di") Integer id)
	{
		return categoryService.getCatById(id);
	}
	@PutMapping("/{di}")
	public String updateCategory(@PathVariable("di") Integer id, @RequestBody Category category)
	{
		return categoryService.updateCategoryes(id,category);
	}
	@DeleteMapping("/{di}")
	public String deleteCategory(@PathVariable("di") Integer id)
	{
		return categoryService.deleteCategory(id);
	}
}
