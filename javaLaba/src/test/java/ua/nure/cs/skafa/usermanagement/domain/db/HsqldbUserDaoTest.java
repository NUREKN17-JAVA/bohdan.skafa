package ua.nure.cs.skafa.usermanagement.domain.db;

import java.util.Date;

import junit.framework.TestCase;
import ua.nure.cs.skafa.usermanagement.domain.User;

public class HsqldbUserDaoTest extends TestCase {
	
	private HsqldbUserDao dao;
	private ConnectionFactory connectionFactory;
	
	

	protected void setUp() throws Exception {
		super.setUp();
		connectionFactory = new ConnectionFactoryImpl();
		dao = new HsqldbUserDao(connectionFactory);
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testCreate() {
		try {
			User user = new User();
			user.setFirstName("John");
			user.setLastName("Doe");
			user.setDateOfBirth(new Date());
			assertNull(user.getId());
			user = dao.create(user);
			assertNotNull(user.getId());
		} catch (DatabaseException e) {
			e.printStackTrace();
			fail(e.toString());
		}

	}

}
