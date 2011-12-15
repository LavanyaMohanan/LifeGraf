import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;


public class ScrapeCountry {

	
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
		Document doc = Jsoup.connect("http://www.numbeo.com/cost-of-living/").get();
		Elements allCountries = doc.select("select#country option");
		Iterator<org.jsoup.nodes.Element> iterator = allCountries.iterator();
		Transaction beginTransaction = session.beginTransaction();
		while(iterator.hasNext()){
			org.jsoup.nodes.Element element = iterator.next();
			String trim = element.val().trim();
			if(!trim.isEmpty())
				session.save(new Country(trim));
		}
		beginTransaction.commit();
		session.flush();
	
	}


}
