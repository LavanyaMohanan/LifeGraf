package webviz.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.stereotype.Component;

import webviz.model.City;
import webviz.model.Country;

@Component
public class Util {
	
	/**
	 * Get list of Contacts from request.
	 * @param data - json data from request 
	 * @return list of Contacts
	 */
	public List<Country> getCountriesFromRequest(Object data){

		List<Country> list;

		//it is an array - have to cast to array object
		if (data.toString().indexOf('[') > -1){

			list = getListContactsFromJSON(data);

		} else { //it is only one object - cast to object/bean

			Country contact = getContactFromJSON(data);

			list = new ArrayList<Country>();
			list.add(contact);
		}

		return list;
	}

	/**
	 * Transform json data format into Contact object
	 * @param data - json data from request
	 * @return 
	 */
	private Country getContactFromJSON(Object data){
		JSONObject jsonObject = JSONObject.fromObject(data);
		Country newContact = (Country) JSONObject.toBean(jsonObject, Country.class);
		return newContact;
	}

	/**
	 * Transform json data format into list of Contact objects
	 * @param data - json data from request
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private List<Country> getListContactsFromJSON(Object data){
		JSONArray jsonArray = JSONArray.fromObject(data);
		List<Country> newContacts = (List<Country>) JSONArray.toCollection(jsonArray,Country.class);
		return newContacts;
	}

	/**
	 * Tranform array of numbers in json data format into
	 * list of Integer
	 * @param data - json data from request
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Integer> getListIdFromJSON(Object data){
		JSONArray jsonArray = JSONArray.fromObject(data);
		List<Integer> idContacts = (List<Integer>) JSONArray.toCollection(jsonArray,Integer.class);
		return idContacts;
	}

	public List<City> getCityFromRequest(Object data) {
		List<City> list;

		//it is an array - have to cast to array object
		if (data.toString().indexOf('[') > -1){

			list = getListCitysFromJSON(data);

		} else { //it is only one object - cast to object/bean

			City city = getCityFromJSON(data);

			list = new ArrayList<City>();
			list.add(city);
		}

		return list;
	}

	private City getCityFromJSON(Object data) {
		JSONObject jsonObject = JSONObject.fromObject(data);
		City newCity = (City) JSONObject.toBean(jsonObject, City.class);
		return newCity;
	}

	private List<City> getListCitysFromJSON(Object data) {
		JSONArray jsonArray = JSONArray.fromObject(data);
		List<City> newCities = (List<City>) JSONArray.toCollection(jsonArray,City.class);
		return newCities;
	}
	
	

}
