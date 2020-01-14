package pojos;
import javax.persistence.*;

@Entity
@Table(name="dac_vehicles")
public class Vehicle {
	private Integer id;
	private String regNo;
	private Vendor myVendor;
	public Vehicle() {
		System.out.println("in vehicle constr");
	}
	
	public Vehicle(String regNo) {
		super();
		this.regNo = regNo;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	@Column(name="reg_no",unique=true)
	public String getRegNo() {
		return regNo;
	}
	public void setRegNo(String regNo) {
		this.regNo = regNo;
	}
	@ManyToOne
	@JoinColumn(name="v_id")
	public Vendor getMyVendor() {
		return myVendor;
	}
	public void setMyVendor(Vendor myVendor) {
		this.myVendor = myVendor;
	}
	@Override
	public String toString() {
		return "Vehicle [id=" + id + ", regNo=" + regNo + "]";
	}
	

}
