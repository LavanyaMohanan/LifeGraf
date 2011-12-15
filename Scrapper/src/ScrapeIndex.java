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


public class ScrapeIndex {

	
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
		Document doc = Jsoup.connect("http://www.numbeo.com/cost-of-living/country_result.jsp?country=India").get();
		Elements elementsByTag = doc.select(".table_indexes tr");
		Iterator<org.jsoup.nodes.Element> iterator = elementsByTag.iterator();
		Transaction beginTransaction = session.beginTransaction();
		
		while(iterator.hasNext()){
			Elements select = iterator.next().select("td");
			if(!select.isEmpty()){
				org.jsoup.nodes.Element element = select.iterator().next();
				String trim = element.text().trim();
				if(!trim.isEmpty())
					session.save(new Index(trim));
				}
			}
		beginTransaction.commit();
		session.flush();
	
	}


}
