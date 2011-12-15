package webviz.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import webviz.dao.CityDAO;
import webviz.model.City;



@Service
public class CityService {
	
	private CityDAO cityDAO;
	
	@Transactional(readOnly=true)
	public List<City> getCityList(){

		return cityDAO.getCities();
	}
		
	@Autowired
	public void setCityDAO(CityDAO cityDAO) {
		this.cityDAO = cityDAO;
	}

	
}
