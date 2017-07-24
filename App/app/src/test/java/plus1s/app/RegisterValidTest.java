package plus1s.app;

/**
 * Created by Jinghua Zhang on 7/16/2017.
 */

import org.junit.Test;

import plus1s.app.controllers.RegisterActivity;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class RegisterValidTest {
    /**
     * Test for valid register user input
     * @throws Exception if the input is not valid;
     */
    @Test
    public void registerValidTest() throws Exception {
        assertTrue(RegisterActivity.registerQualified("jzhang866", "jzhang", "shen@", "shen","shen"));
        assertTrue(RegisterActivity.registerQualified("123456", "123456amazon", "shen@", "she","she"));
    }

    /**
     * Test for invalid register user input
     * @throws Exception if the input is not valid;
     */
    @Test
    public void registerInvalidTest() throws Exception {
        assertFalse(RegisterActivity.registerQualified("", "jzhang", "@", "shen","shen"));
        assertFalse(RegisterActivity.registerQualified("jzhang866", "", "@", "shen","shen"));
        assertFalse(RegisterActivity.registerQualified("jzhang866", "jzhang", "shen", "shen","shen"));
        assertFalse(RegisterActivity.registerQualified("jzhang866", "jzhang", "shen@", "sh","sh"));
        assertFalse(RegisterActivity.registerQualified("jzhang866", "jzhang", "shen@", "shen","sh"));
        assertFalse(RegisterActivity.registerQualified("jzhang866", "jzhang", "shen", "shen","sheng"));
    }
}
