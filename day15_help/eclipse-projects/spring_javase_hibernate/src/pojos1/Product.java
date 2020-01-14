package pojos1;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name="products")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	@Column(name = "pid", nullable = false, columnDefinition = "BIGINT UNSIGNED")
	private Long id;

	@Column
	private String name;
	
	@Column
	private String description;
	
	@Column
	private Long quantity;
	
	@OneToMany(mappedBy="product",fetch = FetchType.EAGER)
	private Set<VendorProduct> vendorProduct=new HashSet<>();

	
	public Product() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	public Product(String name, String description, Long quantity) {
		super();
		this.name = name;
		this.description = description;
		this.quantity = quantity;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getQuantity() {
		return quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

	public Set<VendorProduct> getVendorProduct() {
		return vendorProduct;
	}

	public void setVendorProduct(Set<VendorProduct> vendorProduct) {
		this.vendorProduct = vendorProduct;
	}
	//convenience method
	public void addVendorProduct(VendorProduct vp)
	{
		getVendorProduct().add(vp);
		vp.setProduct(this);
	
	}



	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", description=" + description + ", quantity=" + quantity + "]";
	}
	
}
