package dao;

import static utils.DBUtils.getConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pojos.Candidate;

public class CandidateDaoImpl implements ICandidateDao {

	private Connection cn;
	private PreparedStatement pst1, pst2;

	public CandidateDaoImpl() throws ClassNotFoundException, SQLException {
		cn = getConnection();
		System.out.println("Connected to DB");
		pst1 = cn.prepareStatement("update candidates set votes= votes+1 where id=?");
		pst2= cn.prepareStatement("select * from candidates");
	}

	@Override
	public String incVotes(int candidateId) throws Exception {

		pst1.setInt(1, candidateId);

		int affCount1 = pst1.executeUpdate();

		if (affCount1 > 0)
			return "You have voted Successfully!";
		return "Something went wrong. Try again!";
	}

	@Override
	public List<Candidate> getCandidateList() throws Exception {

		List<Candidate> l1 = new ArrayList<>();

		try (ResultSet rst = pst2.executeQuery()) {
			while (rst.next()) {
				l1.add(new Candidate(rst.getInt(1), rst.getString(2), rst.getString(3), rst.getInt(4)));
			}
		}
		return l1;
	}
}
