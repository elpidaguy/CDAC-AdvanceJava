package dao;

import pojos.Voters;

public interface IVotingDao {
	
	Voters authenticateVoter(String em,String pass) throws Exception;
	public String UpdateStatus(int voterId) throws Exception;

}
