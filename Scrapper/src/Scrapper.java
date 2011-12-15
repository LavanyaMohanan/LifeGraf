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


public class Scrapper {

	
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
		List<String> allCountrieNames=new ArrayList<String>();
		Iterator<org.jsoup.nodes.Element> iterator = allCountries.iterator();
		while(iterator.hasNext()){
			org.jsoup.nodes.Element element = iterator.next();
			if(!element.val().trim().isEmpty())
					allCountrieNames.add(element.val());
		}
		Country countri = null;
		Transaction beginTransaction = session.beginTransaction();
		for(String country:allCountrieNames){
			
			String string = "http://www.numbeo.com/cost-of-living/country_result.jsp?country="+country.replace(" ","+")+"&displayCurrency=USD";
			System.out.println(string);
			Document countryPage = Jsoup.connect(string).get();
			
			countri=new Country(countryPage);
			session.save(countri);
			
		for (Country c:countri.getCities()) {
			System.out.println(c.getName());
		}
			
//			Collection<Attribute> values = countri.attributes.values();
//			Iterator<Attribute> iterator2 = values.iterator();
//			while(iterator2.hasNext())
//			{
//			Attribute next = iterator2.next();
//			System.out.println(next.getName() +" -- "+ next.getAvg()+" ( "+next.getMin()+" - "+next.getMax()+" )");
//			}
			System.out.println("\n\n");
		}
		beginTransaction.commit();
		session.flush();
		
		
	//		HTMLDocument htmlDoc = getHtmlDoc("http://www.numbeo.com/cost-of-living/");
	//		for (HTMLDocument.Iterator iterator = htmlDoc.getIterator(HTML.Tag.SELECT); iterator.isValid(); iterator.next()) {
	//	      AttributeSet attributes = iterator.getAttributes();
	//	      
	//	      String srcString = (String) attributes.getAttribute(HTML.Attribute.ID);
	//	      System.out.print(srcString);
	//	      int startOffset = iterator.getStartOffset();	
	//	      int endOffset = iterator.getEndOffset();
	//	      int length = endOffset - startOffset;
	//	      String text = htmlDoc.getText(startOffset, length);
	//	      System.out.println(" - " + text);
	//	    }
	//    System.exit(0);
	}


}
