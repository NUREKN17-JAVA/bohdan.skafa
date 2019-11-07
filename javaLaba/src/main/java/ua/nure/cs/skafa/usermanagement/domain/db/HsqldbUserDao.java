package ua.nure.cs.skafa.usermanagement.domain.db;

import java.util.Collection;

import ua.nure.cs.skafa.usermanagement.domain.db.UserDao;
import ua.nure.cs.skafa.usermanagement.domain.User;

public class HsqldbUserDao implements UserDao {
	
	private ConnectionFactory connectionFactory;
	
	public HsqldbUserDao(ConnectionFactory connectionFactory) {
		this.connectionFactory = connectionFactory;
	}

	@Override
	public User create(User user) throws DatabaseException {
		return null;
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
