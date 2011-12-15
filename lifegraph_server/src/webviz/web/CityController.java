package webviz.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import webviz.model.City;
import webviz.service.CityService;


@Controller
public class CityController  {

	private CityService cityService; 
	
	@RequestMapping(value="/city/view.action")
	public @ResponseBody Map<String,? extends Object> view() throws Exception {

		try{

			List<City> cities = cityService.getCityList();

			return getMap(cities);

		} catch (Exception e) {

			return getModelMapError("Error retrieving Countries from database."+e.getStackTrace());
		}
	}
	
	

	private Map<String,Object> getMap(List<City> cities){
		
		Map<String,Object> modelMap = new HashMap<String,Object>(3);
		modelMap.put("total", cities.size());
		modelMap.put("cities", cities);
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
	public void setCityService(CityService cityService) {
		this.cityService = cityService;
	}

	public CityService getCityService() {
		return cityService;
	}

}
