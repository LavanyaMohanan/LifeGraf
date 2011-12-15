package webviz.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import webviz.model.Category;
import webviz.model.City;
import webviz.service.CategoryService;
import webviz.service.CityService;


@Controller
public class CategoryController  {

	private CategoryService categoryService; 
	
	@RequestMapping(value="/category/view.action")
	public @ResponseBody Map<String,? extends Object> view() throws Exception {

		try{

			List<Category> categories = categoryService.getCategoryList();

			return getMap(categories);

		} catch (Exception e) {

			return getModelMapError("Error retrieving Countries from database."+e.getStackTrace());
		}
	}
	
	

	private Map<String,Object> getMap(List<Category> categories){
		
		Map<String,Object> modelMap = new HashMap<String,Object>(3);
		modelMap.put("total", categories.size());
		modelMap.put("cities", categories);
		modelMap.put("success", true);
		
		return modelMap;
	}
	
	private Map<String,Object> getModelMapError(String msg){

		Map<String,Object> modelMap = new HashMap<String,Object>(2);
		modelMap.put("message", msg);
		modelMap.put("success", false);

		return modelMap;
	} 


	@Autowired
	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	public CategoryService getCategoryService() {
		return categoryService;
	}

}
