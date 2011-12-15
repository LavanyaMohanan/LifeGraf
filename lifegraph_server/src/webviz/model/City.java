package webviz.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonAutoDetect;

@JsonAutoDetect
@Entity
@Table(name="city")
public class City {
	
	private int id;
	private String name;
	private int countryId;
	
	@Id
	@GeneratedValue
	@Column(name="idCity")
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	@Column(name="name")
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	@Column(name="countryId")
	public void setCountryId(int countryId) {
		this.countryId = countryId;
	}

	public int getCountryId() {
		return countryId;
	}
	
	
}
