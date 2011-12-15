package webviz.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import webviz.model.Country;
import webviz.service.CountryService;


@Controller
public class CountryController  {

	private CountryService countryService;
	
	@RequestMapping(value="/country/view.action")
	public @ResponseBody Map<String,? extends Object> view() throws Exception {

		try{

			List<Country> country = countryService.getCountryList();

			return getMap(country);

		} catch (Exception e) {

			return getModelMapError("Error retrieving Countries from database."+e.getStackTrace());
		}
	}
	
	private Map<String,Object> getMap(List<Country> country){
		
		Map<String,Object> modelMap = new HashMap<String,Object>(3);
		modelMap.put("total", country.size());
		modelMap.put("data", country);
		modelMap.put("success", true);
		
		return modelMap;
	}
	
	/**
	 * Generates modelMap to return in the modelAndView in case
	 * of exception
	 * @param msg message
	 * @return
	 */
	private Map<String,Object> getModelMapError(String msg){

		Map<String,Object> modelMap = new HashMap<String,Object>(2);
		modelMap.put("message", msg);
		modelMap.put("success", false);

		return modelMap;
	} 


	@Autowired
	public void setCountryService(CountryService contactService) {
		this.countryService = contactService;
	}

}
