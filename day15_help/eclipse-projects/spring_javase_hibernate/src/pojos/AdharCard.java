package pojos;
import javax.persistence.*;

@Entity
@Table(name="dac_cards")
public class AdharCard {
	private Integer id;
	private String adharNumber;
	//one-to-one --owning side
	private Vendor myVendor;
	public AdharCard() {
		System.out.println("in adhar card constr");
	}
	public AdharCard(String adharNumber) {
		super();
		this.adharNumber = adharNumber;
	}
	@Id //mandatory
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	@Column(name="card_num",unique=true)
	public String getAdharNumber() {
		return adharNumber;
	}
	public void setAdharNumber(String adharNumber) {
		this.adharNumber = adharNumber;
	}
	@OneToOne
	@JoinColumn(name="v_id")
	public Vendor getMyVendor() {
		return myVendor;
	}
	public void setMyVendor(Vendor myVendor) {
		this.myVendor = myVendor;
	}
	@Override
	public String toString() {
		return "AdharCard [id=" + id + ", adharNumber=" + adharNumber + "]";
	}
	

}
