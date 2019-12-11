package dao;

import static Utils.DBUtils.getConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pojos.Candidate;
import pojos.Voters;

public class VotersDaoImpl implements IVotingDao {

	private Connection cn;
	private PreparedStatement pst1,pst2,pst3,pst4;
	
	public VotersDaoImpl() throws ClassNotFoundException, SQLException {
		cn = getConnection();
		pst1=cn.prepareStatement("select * from voters where email=? and password=?");
		pst2=cn.prepareStatement("select * from candidate");
		pst3 = cn.prepareStatement("update voters set status=true where id=?");
		pst4 = cn.prepareStatement("update candidate set votes= votes+1 where id=?");
	}
		@Override
	public Voters authenticateVoter(String em, String pass) throws Exception {
				pst1.setString(1, em);
				pst1.setString(2, pass);
		try(ResultSet rst=pst1.executeQuery()){
			if(rst.next())
				return new Voters(rst.getInt(1),rst.getString(2),rst.getBoolean(4));
		}
		
		return null;
	}

	@Override
	public List<Candidate> getCandidateList() throws Exception {
	
		List<Candidate> l1=new ArrayList<>();
		
		try(ResultSet rst=pst2.executeQuery()){
			while(rst.next())
			{
				l1.add(new Candidate(rst.getInt(1),rst.getString(2),rst.getString(3),rst.getInt(4)));
			}
		}
		return l1;
	}

	@Override
	public String incVotesUpdateStatus(int candidateId, int voterId) throws Exception {
		
		pst3.setInt(1, voterId);
		pst4.setInt(1, candidateId);
		
		int affCount1 = pst3.executeUpdate();
		int affCount2 = pst4.executeUpdate();
		
		if(affCount1 > 0 && affCount2 > 0)
			return "You have voted Successfully!";
		else
		return "Something went wrong. Try again!";
	}
	
	public void cleanUp() throws SQLException
	{
		if(cn != null)
			cn.close();
		
		if(pst1 != null)
			pst1.close();

		if(pst2 != null)
			pst2.close();

		if(pst3 != null)
			pst3.close();

		if(pst4 != null)
			pst4.close();
		
	}

}
