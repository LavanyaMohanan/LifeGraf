import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class Attribute {
	private Long id;
	private String name;
	private Float avg;
	private Float min;
	private Float max;
	private Long countryId;
	private Long cityId;
	private Long productId;
	Boolean isCityData;
	
	
	public Attribute(){}
	
	public Attribute(Element attr) {
		Elements elementsByTag = attr.getElementsByTag("td");
		setName(elementsByTag.get(0).text().trim());
		setAvg(longCleanUp((elementsByTag.get(1).text())));
		setMin(longCleanUp(elementsByTag.get(2).select(".lowValue .minorText").text()));
		setMax(longCleanUp(elementsByTag.get(2).select(".highValue .minorText").text()));
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setAvg(Float avg) {
		this.avg = avg;
	}
	public Float getAvg() {
		return avg;
	}
	public void setMin(Float min) {
		this.min = min;
	}
	public Float getMin() {
		return min;
	}
	public void setMax(Float max) {
		this.max = max;
	}
	public Float getMax() {
		return max;
	}

	public Float longCleanUp(String string){
		string.trim();
		if(string.contains("$"))
			string=string.substring(0,string.length()-2);
		if(string.contains(","))
			string=string.replaceAll(",", "");
		if(string.contains("?")||string.isEmpty()||string==null)
			return null;
	    return new Float(string);
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public void setCountryId(Long countryId) {
		this.countryId = countryId;
	}

	public Long getCountryId() {
		return countryId;
	}

	public void setCityId(Long cityId) {
		this.cityId = cityId;
	}

	public Long getCityId() {
		return cityId;
	}


	public void setIsCityData(String isCityData) {
		this.isCityData = Boolean.valueOf(isCityData);
	}

	public String getIsCityData() {
		return isCityData.toString();
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public Long getProductId() {
		return productId;
	}


}
