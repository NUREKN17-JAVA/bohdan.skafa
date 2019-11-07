package ua.nure.cs.skafa.usermanagement.domain.db;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;

import ua.nure.cs.skafa.usermanagement.domain.db.UserDao;
import ua.nure.cs.skafa.usermanagement.domain.User;

public class HsqldbUserDao implements UserDao {
	
	private ConnectionFactory connectionFactory;
	private static final String INSERT_QEURY = "INSERT INTO user (firstname, lastname, dataOfBirth) VALUE (?, ?, ?)";
	
	public HsqldbUserDao(ConnectionFactory connectionFactory) {
		this.connectionFactory = connectionFactory;
	}

	@Override
	public User create(User user) throws DatabaseException {
		try {
			Connection connection = connectionFactory.createConnection();
			PreparedStatement statement = connection
					.prepareStatement(INSERT_QEURY);
			statement.setString(1, user.getFirstName());
			statement.setString(2, user.getLastName());
			statement.setDate(3, new Date(user.getDateOfBirth().getTime()));
			int n = statement.executeUpdate();
			if  (n != 1) { 
				throw new DatabaseException("Number of the inserted rows: " + n);
			}
			CallableStatement callableStatement = connection.prepareCall("call IDENTIFY()");
			ResultSet keys = callableStatement.executeQuery();
			if (keys.next()) {
				user.setId(new Long(keys.getLong(1)));
			}
			return null;
			
		} catch (SQLException e) { 	
			throw new DatabaseException(e);			
		} catch (DatabaseException e) {
			throw e;
		}
		
	}

	@Override
	public void update(User user) throws DatabaseException {

	}

	@Override
	public void delete(User user) throws DatabaseException {

	}

	@Override
	public User find(Long id) throws DatabaseException {
		return null;
	}

	@Override
	public Collection findAll() throws DatabaseException {
		return null;
	}

}
