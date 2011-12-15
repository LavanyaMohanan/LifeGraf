import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;


public class ScrapeCity {

	
	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws Exception {
		
		Configuration configuration = new Configuration();
		Configuration configure = configuration.configure();
		SessionFactory sessionFactory = configure.buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		new Constants();
		
		Criteria crit = session.createCriteria(Country.class);
        @SuppressWarnings("unchecked")
		List<Country> list = crit.list();
		List<City> cities=new ArrayList<City>();
        
        for(int index=101;index<=188;index++){
        	System.out.println(index);
        	Country c=list.get(index);
        	String string = "http://www.numbeo.com/cost-of-living/country_result.jsp?country="+c.getName().replace(" ","+")+"&displayCurrency=USD";
			Document doc = Jsoup.connect(string).get();
			Elements allCities = doc.select("select#city option");
			Iterator<org.jsoup.nodes.Element> iterator = allCities.iterator();
			while(iterator.hasNext()){
					org.jsoup.nodes.Element element = iterator.next();
					String trim = element.val().trim();
					if(!trim.isEmpty())
						cities.add(new City(trim,c.getId()));
	//				System.out.println(trim);
			}
	
        }
        
        for(City v:cities){
        	System.out.println("a");
			Transaction beginTransaction = session.beginTransaction();
			session.save(v);
			beginTransaction.commit();
			session.flush();
		}
	

	}
}
