package ua.nure.cs.skafa.usermanagement.domain.db;

import java.sql.Connection;

public interface ConnectionFactory {
	
	Connection createConnection() throws DatabaseException;
	

}
