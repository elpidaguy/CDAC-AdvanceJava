package pojos;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "dac_companies")
public class Company {
	private Integer id;
	private String name;
	private List<Vendor> vendors = new ArrayList<>();

	public Company() {
		System.out.println("company cnstr");
	}

	public Company(String name) {
		super();
		this.name = name;
	}

	@Id // mandatory
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "company_id")
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

	@ManyToMany
	@JoinTable(name="dac_comp_vendors",joinColumns = @JoinColumn(name = "comp_id"),
	inverseJoinColumns = @JoinColumn(name = "vendor_id"))
	public List<Vendor> getVendors() {
		return vendors;
	}

	public void setVendors(List<Vendor> vendors) {
		this.vendors = vendors;
	}

	// convenience method to add vendor
	public void addVendor(Vendor v) {
		vendors.add(v);
		v.getCompanies().add(this);
	}

	// convenience method to remove vendor
	public void removeVendor(Vendor v) {
		vendors.remove(v);
		v.getCompanies().remove(this);
	}

	@Override
	public String toString() {
		return "Company [id=" + id + ", name=" + name + "]";
	}

}
