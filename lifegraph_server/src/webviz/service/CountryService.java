package webviz.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import webviz.dao.CountryDAO;
import webviz.model.Country;



@Service
public class CountryService {
	
	private CountryDAO countryDAO;

	@Transactional(readOnly=true)
	public List<Country> getCountryList(){
		return countryDAO.getCountries();
	}
	
	@Autowired
	public void setCountryDAO(CountryDAO contactDAO) {
		this.countryDAO = contactDAO;
	}

	
}
