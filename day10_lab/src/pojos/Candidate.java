package pojos;

import javax.persistence.*;

@Entity
@Table(name = "candidates")
public class Candidate extends AbstractEntity {
	int votes;
	String name, pol_party;

	public Candidate() {
		System.out.println("Candidate CTOR called");
	}

//public Candidate(int id, String name, String pol_party, int votes) {
//	super();
//	this.id = id;
//	this.votes = votes;
//	this.name = name;
//	this.pol_party = pol_party;
//}
	@Override
	public String toString() {
		return "Candidate [votes=" + votes + ", name=" + name + ", pol_party=" + pol_party + "]";
	}

	public int getVotes() {
		return votes;
	}

	public void setVotes(int votes) {
		this.votes = votes;
	}

	@Column(unique = true, length = 30)
	public void setName(String name) {
		this.name = name;
	}

	public void setPol_party(String pol_party) {
		this.pol_party = pol_party;
	}

	public String getName() {
		return name;
	}

	@Column(length = 20)
	public String getPol_party() {
		return pol_party;
	}

}
