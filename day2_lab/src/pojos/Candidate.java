package pojos;

public class Candidate {
int id,votes;
String name,pol_party;
public Candidate(int id, String name, String pol_party, int votes) {
	super();
	this.id = id;
	this.votes = votes;
	this.name = name;
	this.pol_party = pol_party;
}
@Override
public String toString() {
	return "Candidate [id=" + id + ", votes=" + votes + ", name=" + name + ", pol_party=" + pol_party + "]";
}
public int getId() {
	return id;
}
public int getVotes() {
	return votes;
}
public String getName() {
	return name;
}
public String getPol_party() {
	return pol_party;
}


}
