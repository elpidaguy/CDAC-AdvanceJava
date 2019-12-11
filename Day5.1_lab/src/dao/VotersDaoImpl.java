package dao;

import static utils.DBUtils.getConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import pojos.Voters;

public class VotersDaoImpl implements IVotingDao {

	private Connection cn;
	private PreparedStatement pst1, pst2;

	public VotersDaoImpl() throws ClassNotFoundException, SQLException {
		cn = getConnection();
		System.out.println("Connected to DB");
		pst1 = cn.prepareStatement("select * from voters where email=? and password=?");
		pst2 = cn.prepareStatement("update voters set votestatus=true where id=?");
	}

	@Override
	public Voters authenticateVoter(String em, String pass) throws Exception {
		pst1.setString(1, em);
		pst1.setString(2, pass);
		try (ResultSet rst = pst1.executeQuery()) {
			if (rst.next())
				return new Voters(rst.getInt(1), rst.getString(2), rst.getBoolean(4));
		}

		return null;
	}
	
	@Override
	public String UpdateStatus(int voterId) throws Exception {

		pst2.setInt(1, voterId);

		int affCount1 = pst2.executeUpdate();

		if (affCount1 > 0)
			return "You have voted Successfully!";
		return "Something went wrong. Try again!";
	}

	public void cleanUp() throws SQLException {
		if (cn != null)
			cn.close();

		if (pst1 != null)
			pst1.close();

		if (pst2 != null)
			pst2.close();

	}

}
