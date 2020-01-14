package com.app.pojos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "appln_data")
public class ApplicationData {
	private Integer id;
	private List<String> browsers=new ArrayList<>();
	private List<String> technologies=new ArrayList<>();
	private List<String> cities=new ArrayList<>();
	private List<String> platforms=new ArrayList<>();

	public ApplicationData() {
		// TODO Auto-generated constructor stub
	}

	@ElementCollection
	@CollectionTable(name = "browsers", joinColumns = @JoinColumn(name = "id"))
	@Column(length=20)
	public List<String> getBrowsers() {
		return browsers;
	}

	public void setBrowsers(List<String> browsers) {
		this.browsers = browsers;
	}

	@ElementCollection
	@CollectionTable(name = "technos", joinColumns = @JoinColumn(name = "id"))
	@Column(length=20)	public List<String> getTechnologies() {
		return technologies;
	}

	public void setTechnologies(List<String> technologies) {
		this.technologies = technologies;
	}

	@ElementCollection
	@CollectionTable(name = "cities", joinColumns = @JoinColumn(name = "id"))
	@Column(length=20)	public List<String> getCities() {
		return cities;
	}

	public void setCities(List<String> cities) {
		this.cities = cities;
	}

	@ElementCollection
	@CollectionTable(name = "platforms", joinColumns = @JoinColumn(name = "id"))
	@Column(length=20)	public List<String> getPlatforms() {
		return platforms;
	}

	public void setPlatforms(List<String> platforms) {
		this.platforms = platforms;
	}

	@Id
	@GeneratedValue
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "ApplicationData id=" + id + ", browsers=" + browsers
				+ ", technologies=" + technologies + ", cities=" + cities
				+ ", platforms=" + platforms;
	}


	
}
