

public class Category {
	
	private Long id;
	private String name;
	
	public Category(String name) {
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
