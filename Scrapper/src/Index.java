
public class Index {
	private Long id;
	private String name;
	
	public Index(String trim) {
		name=trim;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

}
