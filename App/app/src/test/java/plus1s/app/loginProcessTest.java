package plus1s.app;
import org.junit.Before;
import org.junit.Test;


import plus1s.app.controllers.LoginActivity;
import plus1s.app.model.Account;
import plus1s.app.model.User;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
/**
 * Created by Catherine z.zhuang on 7/16/2017.
 */

public class loginProcessTest {
    private Account user;
    @Before
    public void initialize(){
        String username = "123";
        String password = "123";
        user = new User();
        user.setUsername(username);
        user.setPassword(password);
    }
    /**
     * Test for valid login
     * @throws Exception if the input is not valid;
     */
    @Test
    public void LoginValidTest() throws Exception {
        assertTrue(LoginActivity.loginProcess("123", user));
    }

    /**
     * Test for invalid login
     * @throws Exception if the input is not valid;
     */
    @Test
    public void LoginInvalidTest() throws Exception {
        assertFalse(LoginActivity.loginProcess("345", user));
    }

}
