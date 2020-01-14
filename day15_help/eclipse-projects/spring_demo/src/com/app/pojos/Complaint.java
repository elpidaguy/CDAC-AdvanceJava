package com.app.pojos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "dac_complaints")
public class Complaint implements Serializable {
	private Integer id;
	private String name, email, password, city, platform, complaintDesc,
			status, browser;
	private List<String> techno;
	private Date compDate;

	public Complaint() {
		System.out.println("def constr of complaint pojo");
		techno = new ArrayList<>();
	}

	@Id
	@GeneratedValue
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(length = 20)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(length = 20)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(length = 20)
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(length = 20)
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Column(length = 20)
	public String getPlatform() {
		return platform;
	}

	public void setPlatform(String platform) {
		this.platform = platform;
	}

	
	@Column(name="comp_desc",length=100)
	public String getComplaintDesc() {
		return complaintDesc;
	}

	public void setComplaintDesc(String complaintDesc) {
		this.complaintDesc = complaintDesc;
	}

	@Column(length = 10)
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Column(length = 20)
	public String getBrowser() {
		return browser;
	}

	public void setBrowser(String browser) {
		this.browser = browser;
	}

	@Column(length = 20)
	@ElementCollection(fetch=FetchType.EAGER)
	// Mandatory
	@CollectionTable(name = "complaint_techno", joinColumns = @JoinColumn(name = "id"))
	public List<String> getTechno() {
		return techno;
	}

	public void setTechno(List<String> techno) {
		this.techno = techno;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "comp_date")
	public Date getCompDate() {
		return compDate;
	}

	public void setCompDate(Date compDate) {
		this.compDate = compDate;
	}

	@Override
	public String toString() {
		return "Complaint id=" + id + ", name=" + name + ", email=" + email
				+ ", password=" + password + " city=" + city + ", platform="
				+ platform + " complaintDesc=" + complaintDesc + ", status="
				+ status + ", browser=" + browser + ", techno=" + techno
				+ ", compDate=" + compDate ;
	}




}
