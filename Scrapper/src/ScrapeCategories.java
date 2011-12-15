import java.io.IOException;
import java.util.Iterator;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class ScrapeCategories {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		Configuration configuration = new Configuration();
		Configuration configure = configuration.configure();
		SessionFactory sessionFactory = configure.buildSessionFactory();
		Session session = sessionFactory.openSession();
		new Constants();
		Document doc = Jsoup.connect("http://www.numbeo.com/cost-of-living/country_result.jsp?country=India").get();
		Elements allCategories = doc.select("td.tr_highlighted_menu");
		Iterator<Element> iterator = allCategories.iterator();
		Transaction beginTransaction = session.beginTransaction();
		while(iterator.hasNext())
			{
			String text = iterator.next().text();
				String trim = text.trim();
				if(!trim.isEmpty()){
					session.save(new Category(trim));
					}
			}
		beginTransaction.commit();
		session.flush();
	}

}
