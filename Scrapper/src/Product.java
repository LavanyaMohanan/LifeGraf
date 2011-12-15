
public class Product {
	private Long id;
	private String name;
	
	public Product(){}
	
	public Product(String name) {
		this.name = name;
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

	
}
