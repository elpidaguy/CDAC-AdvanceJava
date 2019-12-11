package dao;

import pojos.Voters;

public interface IVotingDao {
	
	public Voters authenticateVoter(String em,String pass) throws Exception;
	public String UpdateStatus(int voterId) throws Exception;
	public Integer registerVoter(String em, String pass) throws Exception;

}
