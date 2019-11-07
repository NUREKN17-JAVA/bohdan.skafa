package ua.nure.cs.skafa.usermanagement.domain.db;

import java.io.IOException;
import java.util.Properties;

public class DaoFactory {

	private final Properties properties;
	private static final String USER_DAO = "ua.nure.cs.skafa.usermanagement.domain.db.UserDao";
	
	public DaoFactory() {
		properties = new Properties();
		try {
			properties.load(getClass().getClassLoader().getResourceAsStream("settings.properties"));
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	
	private ConnectionFactory getConnectionFactory() {
		String user = properties.getProperty("connection.user");
		String password = properties.getProperty("connection.password");
		String url = properties.getProperty("connection.url");
		String driver = properties.getProperty("connection.driver");
		
		return new ConnectionFactoryImpl(driver, url, user, password);
	}
	
	public UserDao getUserDao() {
		UserDao result = null;
		try {
			Class clazz = Class.forName(properties.getProperty(USER_DAO));
			UserDao userDao = (UserDao) clazz.newInstance();
		}catch (Exception e) {
			throw new RuntimeException(e);
		}
		return result;
	}
	
}
