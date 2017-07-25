package plus1s.app;

import org.junit.Test;

import plus1s.app.controllers.LoginActivity;
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
    private Account account_expected;
    private Account account_actual;

//    /**
//     *  initialize the test
//     */
//    @Before
//    public void initialize() {
//        account = ac;
//    }

    /**
     * check if a user account has the type "User"
     */
    @Test
    public void testUser() {
        account_expected = new User();
        account_actual = LoginActivity.createUser("User");
        assertTrue(account_actual.returnType().equals(account_expected.returnType()));
    }

    /**
     * check if an administrator has the type "Administrator"
     */
    @Test
    public void testAdministrator() {
        account_expected = new Administrator();
        account_actual = LoginActivity.createUser("Administrator");
        assertTrue(account_actual.returnType().equals(account_expected.returnType()));
    }

    /**
     * check if a manager has the type "Manager"
     */
    @Test
    public void testManager() {
        account_expected = new Manager();
        account_actual = LoginActivity.createUser("Manager");
        assertTrue(account_actual.returnType().equals(account_expected.returnType()));
    }
}
