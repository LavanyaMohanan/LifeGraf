
public class City {
	private Long id;
	private String name;
	private Long countryId;
	
	public City(){}
	
	public City(String name,Long id) {
		this.name = name;
		countryId=id;
		}

	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
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

}
