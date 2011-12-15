import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;


public class Country {
	
	private Long id;
	HashMap<String, Attribute> attributes=new HashMap<String, Attribute>();
	
	private List<Country> cities=new ArrayList<Country>();
	private List<Index> indexes=new ArrayList<Index>();
	private String name;
	
	public Country(Document countryPage) {
		
		Elements allCities = countryPage.select("select#city option");
		
		Iterator<org.jsoup.nodes.Element> iterator = allCities.iterator();
		while(iterator.hasNext()){
			org.jsoup.nodes.Element element = iterator.next();
//			if(!element.val().trim().isEmpty())
//					getCities().add(new Country(element.val(), true));
		}
		
		Elements details = countryPage.select("table");
		org.jsoup.nodes.Element detailTable = details.get(4);
		Elements elementsByTag = detailTable.select(".tr_highlighted,.tr_standard");
		Iterator<org.jsoup.nodes.Element> iterator2 = elementsByTag.iterator();
		while(iterator2.hasNext()){
			Attribute attribute = new Attribute(iterator2.next());
			attributes.put(attribute.getName(), attribute);
			}
	}
	public Country(){}
	
	public Country(String trim) {
		setName(trim);
	}

	public void setCities(List<Country> cities) {
		this.cities = cities;
	}

	public List<Country> getCities() {
		return cities;
	}

	public String getName() {
		return name;
	}

	
	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public void setIndexes(List<Index> indexes) {
		this.indexes = indexes;
	}

	public List<Index> getIndexes() {
		return indexes;
	}

	public void setName(String name) {
		this.name = name;
	}



}
