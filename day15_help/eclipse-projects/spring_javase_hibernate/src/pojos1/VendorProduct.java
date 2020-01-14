package pojos1;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name="vendor_product")
public class VendorProduct implements Serializable {

	@Id
	@ManyToOne
	@JoinColumn(name="vid")
	private Vendor vendor;

	@Id
	@ManyToOne
	@JoinColumn(name="pid")
	private Product product;

	
	private Double price;

	public Vendor getVendor() {
		return vendor;
	}

	public void setVendor(Vendor vendor) {
		this.vendor = vendor;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
}
