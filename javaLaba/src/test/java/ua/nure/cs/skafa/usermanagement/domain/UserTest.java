package ua.nure.cs.skafa.usermanagement.domain;

import junit.framework.TestCase;
import java.util.Calendar;

public class UserTest extends TestCase {

	private static final int ETHALON_AGE = 20;
	private static final int DAY_OF_BIRTH = 5;
	private static final int MONTH_OF_BIRTH = 11;
	private static final int YEAR_OF_BIRTH = 1999;
	
	private static final int MONTH_OF_BIRTH_1 = 9;
	private static final int ETALON_AGE_1 = 20;
	
	private User user;
	
	public void testGetFullName() {
		user.setFirstName("John");
		user.setLastName("Doe");
		assertEquals("Doe John", user.getFullName());
	}

	public void testGetAge() {
		Calendar calendar = Calendar.getInstance();
		calendar.set(YEAR_OF_BIRTH, MONTH_OF_BIRTH, DAY_OF_BIRTH);
		user.setDateOfBirth(calendar.getTime());
		assertEquals(ETHALON_AGE, user.getAge());
	}
	
	public void testAge1() {
		Calendar calendar = Calendar.getInstance();
		calendar.set(YEAR_OF_BIRTH, MONTH_OF_BIRTH_1, DAY_OF_BIRTH);
		user.setDateOfBirth(calendar.getTime());
		assertEquals(ETALON_AGE_1, user.getAge());
	}
	
	 public void testAgeBirthdayToday() {
       Calendar calendar = Calendar.getInstance();  
       calendar.set(YEAR_OF_BIRTH, calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));
       user.setDateOfBirth(calendar.getTime());
       int real_age = user.getAge();
       assertEquals(ETHALON_AGE, real_age);
    }

	    public void testAgeBirthdayTomorrow() {	
        Calendar calendar = Calendar.getInstance();	        
        calendar.set(YEAR_OF_BIRTH, calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));
        calendar.add(Calendar.DAY_OF_MONTH, 1);
        user.setDateOfBirth(calendar.getTime());
        int real_age = user.getAge();	        
        assertEquals(ETHALON_AGE, real_age);
    }
	    
	    public void testNewbornAge() {
        int expected_age = 0;
        Calendar calendar = Calendar.getInstance();	        
        calendar.set(calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH),calendar.get(Calendar.DAY_OF_MONTH));
        user.setDateOfBirth(calendar.getTime());
        int real_age = user.getAge();        
        assertEquals(expected_age, real_age);
    }

	protected void setUp() throws Exception {
		super.setUp();
		user = new User();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

}
