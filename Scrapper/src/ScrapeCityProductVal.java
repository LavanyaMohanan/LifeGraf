import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.map.HashedMap;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;


public class ScrapeCityProductVal {

	
	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws Exception {
		Configuration configuration = new Configuration();
		Configuration configure = configuration.configure();
		SessionFactory sessionFactory = configure.buildSessionFactory();
		new Constants();

		Session session = sessionFactory.openSession();
		Criteria crit = session.createCriteria(Product.class);
        @SuppressWarnings("unchecked")
		List<Product> products = crit.list();
		Map<String,Product> productMap=new HashMap<String, Product>();
        for(Product p:products)
        	productMap.put(p.getName(),p);
        session.close();
        
        session=sessionFactory.openSession();
        crit = session.createCriteria(City.class);
        @SuppressWarnings("unchecked")
		List<City> cities = crit.list();
		
        for(int i=827;i<=866;i++){
        	System.out.println(i);
        	City city=cities.get(i);
        	Country c= (Country) session.load(Country.class,city.getCountryId());
        	String string = "country="+c.getName()+"&city="+city.getName()+"&displayCurrency=USD";
        	System.out.println();
			Document doc = Jsoup.connect(new URI("http","www.numbeo.com","/cost-of-living/city_result.jsp",string,null).toURL().toString()).get();
			Elements details = doc.select("table");
			org.jsoup.nodes.Element detailTable = details.get(4);
			Elements elementsByTag = detailTable.select(".tr_highlighted,.tr_standard");
			Iterator<org.jsoup.nodes.Element> iterator2 = elementsByTag.iterator();
				while(iterator2.hasNext()){
					Transaction beginTransaction = session.beginTransaction();
					Attribute attribute = new Attribute(iterator2.next());
					attribute.setCityId(city.getId());
					attribute.setIsCityData("true");
					attribute.setProductId(productMap.get(attribute.getName()).getId());
					session.save(attribute);
					beginTransaction.commit();
					}
			}
        
        session.flush();
        
        }
        
    	

}
