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


public class ScrapeProduct {

	
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
		Elements details = doc.select("table");
		org.jsoup.nodes.Element detailTable = details.get(4);
		Elements elementsByTag = detailTable.select(".tr_highlighted,.tr_standard");
		Iterator<org.jsoup.nodes.Element> iterator = elementsByTag.iterator();
		Transaction beginTransaction = session.beginTransaction();
		
		while(iterator.hasNext()){
			org.jsoup.nodes.Element element = iterator.next().select("td").iterator().next();
			String trim = element.text().trim();
			if(!trim.isEmpty())
				session.save(new Product(trim));
		}
		beginTransaction.commit();
		session.flush();
	
	}


}
