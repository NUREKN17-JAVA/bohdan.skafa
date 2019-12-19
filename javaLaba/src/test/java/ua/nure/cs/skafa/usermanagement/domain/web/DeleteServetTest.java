package ua.nure.cs.skafa.usermanagement.domain.web;

import java.text.DateFormat;
import java.util.Date;

import junit.framework.TestCase;
import ua.nure.cs.skafa.usermanagement.domain.User;

public class DeleteServetTest extends MockServlerTestCase {
	@Override
    public void setUp() throws Exception {
        super.setUp();
        createServlet(DeleteServlet.class);

    }

    public void testDelete() {
        User user = new User(new Long(1000), "John", "Doe", new Date());
        getMockUserDao().expect("delete", user);
        setSessionAttribute("user", user);
        addRequestParameter("ok", "Ok");
        doPost();
    }

}
