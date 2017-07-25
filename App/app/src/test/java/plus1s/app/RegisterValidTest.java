package plus1s.app;

import org.junit.Test;

import plus1s.app.controllers.RegisterActivity;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
/**
 * Created by Jinghua Zhang on 7/16/2017.
 * check if registervalid method works fine
 */
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
        assertFalse(RegisterActivity.registerQualified("", "", "shen@", "shen","shen"));
        assertFalse(RegisterActivity.registerQualified("", "jzhang", "shen", "shen","shen"));
        assertFalse(RegisterActivity.registerQualified("", "jzhang", "shen@", "sh","sh"));
        assertFalse(RegisterActivity.registerQualified("", "jzhang", "shen@", "sheng","shen"));
        assertFalse(RegisterActivity.registerQualified("jzhang866", "", "shen", "shen","shen"));
        assertFalse(RegisterActivity.registerQualified("jzhang866", "", "shen@", "sh","sh"));
        assertFalse(RegisterActivity.registerQualified("jzhang866", "", "shen@", "sheng","shen"));
        assertFalse(RegisterActivity.registerQualified("jzhang866", "jzhang", "shen", "sh","sh"));
        assertFalse(RegisterActivity.registerQualified("jzhang866", "jzhang", "shen", "sheng","shen"));
        assertFalse(RegisterActivity.registerQualified("jzhang866", "jzhang", "shen@", "sh","sheng"));
        assertFalse(RegisterActivity.registerQualified("", "", "shen", "shen","shen"));
        assertFalse(RegisterActivity.registerQualified("", "", "shen@", "sh","sh"));
        assertFalse(RegisterActivity.registerQualified("", "", "shen@", "sheng","shen"));
        assertFalse(RegisterActivity.registerQualified("", "jzhang", "shen", "sh","sh"));
        assertFalse(RegisterActivity.registerQualified("", "jzhang", "shen", "sheng","shen"));
        assertFalse(RegisterActivity.registerQualified("", "jzhang", "shen", "sh","sheng"));
        assertFalse(RegisterActivity.registerQualified("jzhang866", "", "shen", "sh","sh"));
        assertFalse(RegisterActivity.registerQualified("jzhang866", "", "shen", "sheng","shen"));
        assertFalse(RegisterActivity.registerQualified("jzhang866", "jzhang", "shen", "sh","sheng"));
        assertFalse(RegisterActivity.registerQualified("", "", "shen", "sh","sh"));
        assertFalse(RegisterActivity.registerQualified("", "", "shen", "sh","sheng"));
        assertFalse(RegisterActivity.registerQualified("", "", "shen", "sh","sheng"));
        assertFalse(RegisterActivity.registerQualified("", "jzhang", "shen", "sh","sheng"));
        assertFalse(RegisterActivity.registerQualified("jzhang866", "", "shen", "sh","sheng"));
        assertFalse(RegisterActivity.registerQualified("", "", "shen", "sh","sheng"));

    }
}
