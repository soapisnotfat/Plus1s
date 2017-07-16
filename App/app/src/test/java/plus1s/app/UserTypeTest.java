package plus1s.app;

import org.junit.Before;
import org.junit.Test;

import plus1s.app.model.Account;
import plus1s.app.model.Administrator;
import plus1s.app.model.Manager;
import plus1s.app.model.User;

import static org.junit.Assert.assertTrue;

/**
 * Created by Ivorycandy on 7/16/17.
 *
 * check if user has correct account type
 */

public class UserTypeTest {
    private Account account;

    /**
     *  initialize the test
     */
    @Before
    public void initialize() {
        account = new User();
    }

    /**
     * check if a user account has the type "User"
     */
    @Test
    public void testUser() {
        account = new User();
        assertTrue(account.returnType().equals("User"));
    }

    /**
     * check if an administrator has the type "Administrator"
     */
    @Test
    public void testAdministrator() {
        account = new Administrator();
        assertTrue(account.returnType().equals("Administrator"));
    }

    /**
     * check if a manager has the type "Manager"
     */
    @Test
    public void testManager() {
        account = new Manager();
        assertTrue(account.returnType().equals("Manager"));
    }
}
