package ua.nure.cs.skafa.usermanagement.domain.db;

import java.util.Collection;
import ua.nure.cs.skafa.usermanagement.domain.User;

public interface UserDao {
	
	User create(User user) throws DatabaseException;
	
	void update(User user) throws DatabaseException;
	
	void delete(User user) throws DatabaseException;
	
	User find(Long id) throws DatabaseException;
	
	Collection findAll() throws DatabaseException;
	
	Collection findAll(String firstName, String lastName) throws DatabaseException;
	
	void setConnectionFactory(ConnectionFactory connectionFactory);

}
