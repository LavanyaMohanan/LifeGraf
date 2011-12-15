package webviz.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import webviz.dao.CategoryDAO;
import webviz.model.Category;

@Service
public class CategoryService {
	
	private CategoryDAO categoryDAO;
	
	@Transactional(readOnly=true)
	public List<Category> getCategoryList(){

		return categoryDAO.getCategories();
	}
		
	@Autowired
	public void setCategoryDAO(CategoryDAO categoryDAO) {
		this.categoryDAO = categoryDAO;
	}

	
}
