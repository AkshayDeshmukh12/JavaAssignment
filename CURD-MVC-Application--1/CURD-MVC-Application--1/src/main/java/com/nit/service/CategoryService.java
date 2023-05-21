package com.nit.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nit.dto.CategoryDTO;
import com.nit.dto.ProductDTO;
import com.nit.entity.Category;
import com.nit.entity.Product;
import com.nit.repo.CategoryRepo;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepo categoryRepo;
	
	public List<CategoryDTO> getAllCategory()
	{
		
		List<CategoryDTO> categoryDTOs= new ArrayList<>();
		
		List<Category> cateList= categoryRepo.findAll();
		if(cateList!=null)
		{
			for(Category cate: cateList)
			{
				CategoryDTO categoryDTO= new CategoryDTO();
				categoryDTO.setCateID(cate.getCid());
				categoryDTO.setCateName(cate.getCname());
				categoryDTO.setCateDesc(cate.getCdescription());
				List<ProductDTO> productDTOs= new ArrayList<>();
				for(Product prod: cate.getProduct())
				{
					
					ProductDTO prodDTO= new ProductDTO();
					prodDTO.setPname(prod.getPname());
					prodDTO.setPdesc(prod.getPdescription());
					prodDTO.setId(prod.getPid());
					productDTOs.add(prodDTO);
					
				}
				 categoryDTO.setProducts(productDTOs);
				categoryDTOs.add(categoryDTO);
				
			}
			return categoryDTOs;
		}
		return null;
		
	}

	public String saveCategory(Category category) {
		return categoryRepo.save(category).getCid()+" Created Successfully";
	}

	public CategoryDTO getCatById(Integer id) {
		
		Optional<Category> cate= categoryRepo.findById(id);
		if(cate.isPresent())
		{
			List<ProductDTO> pList= new ArrayList<>();
			CategoryDTO dto = new CategoryDTO();
			dto.setCateName(cate.get().getCname());
			dto.setCateID(cate.get().getCid());
			dto.setCateDesc(cate.get().getCdescription());
			
			for(int i=0; i<cate.get().getProduct().size(); i++)
			{
				ProductDTO pDto= new ProductDTO();
				pDto.setId(cate.get().getProduct().get(i).getPid());
				pDto.setPdesc(cate.get().getProduct().get(i).getPdescription());
				pDto.setPname(cate.get().getProduct().get(i).getPname());
				pList.add(pDto);
				
			}
			dto.setProducts(pList);
			return dto;
		}
		else
			return null;
	}

	public String updateCategoryes(Integer id, Category category) {
		
	Optional<Category> categoryRecords=	categoryRepo.findById(id);
	
	if(categoryRecords.isPresent())
	{
		Category cate=categoryRecords.get();
        cate.setCname(category.getCname());
        cate.setCdescription(category.getCdescription());
        cate.setProduct(category.getProduct());
        return "Category Updated Successsfully for ID :: "+categoryRepo.save(cate).getCid();
		
	}
	return "No Categoy ID found for update";
	}

	public String deleteCategory(Integer id) {
		
	Optional<Category> records=	categoryRepo.findById(id);
	if(records.isPresent())
	{
		categoryRepo.deleteById(id);
		return "Given Category deleted for ID:: "+id ;
	}
	return "Not found given Category ID :: "+id;
	}
}
