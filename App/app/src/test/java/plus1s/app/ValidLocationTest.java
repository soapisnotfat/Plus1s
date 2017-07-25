package plus1s.app;

import plus1s.app.controllers.LostItemActivity;


import org.junit.Test;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
/**
 * Created by siyul on 7/16/2017.
 * check if location works fine
 * latitude should be in [-90, 90]
 * longitude should be in [-180, 180]
 */
public class ValidLocationTest {
    /**
     * Test for valid location input
     * @throws Exception if the input is not valid;
     */
    @Test
    public void locationValidTest1() throws Exception {
        assertTrue(LostItemActivity.checkValidLocation("19", "19"));
    }

    /**
     * Test for valid location input
     * @throws Exception if the input is not valid;
     */
    @Test
    public void locationValidTest2() throws Exception {
        assertTrue(LostItemActivity.checkValidLocation("-19", "19"));
    }

    /**
     * Test for valid location input
     * @throws Exception if the input is not valid;
     */
    @Test
    public void locationValidTest3() throws Exception {
        assertTrue(LostItemActivity.checkValidLocation("19", "-19"));
    }

    /**
     * Test for valid location input
     * @throws Exception if the input is not valid;
     */
    @Test
    public void locationValidTest4() throws Exception {
        assertTrue(LostItemActivity.checkValidLocation("-19", "-19"));
    }

    /**
     * Test for invalid location input
     * @throws Exception if the input is not valid;
     */
    @Test
    public void locationInvalidTest1() throws Exception {
        assertFalse(LostItemActivity.checkValidLocation("100", "19"));
    }
    /**
     * Test for invalid location input
     * @throws Exception if the input is not valid;
     */
    @Test
    public void locationInvalidTest2() throws Exception {
        assertFalse(LostItemActivity.checkValidLocation("100", "189"));
    }

    /**
     * Test for invalid location input
     * @throws Exception if the input is not valid;
     */
    @Test
    public void locationInvalidTest3() throws Exception {
        assertFalse(LostItemActivity.checkValidLocation("80", "189"));
    }

    /**
     * Test for invalid location input
     * @throws Exception if the input is not valid;
     */
    @Test
    public void locationInvalidTest4() throws Exception {
        assertFalse(LostItemActivity.checkValidLocation("80", "-189"));
    }

    /**
     * Test for invalid location input
     * @throws Exception if the input is not valid;
     */
    @Test
    public void locationInvalidTest5() throws Exception {
        assertFalse(LostItemActivity.checkValidLocation("-100", "19"));
    }

    /**
     * Test for invalid location input
     * @throws Exception if the input is not valid;
     */
    @Test
    public void locationInvalidTest6() throws Exception {
        assertFalse(LostItemActivity.checkValidLocation("-100", "-189"));
    }

    /**
     * Test for invalid location input
     * @throws Exception if the input is not valid;
     */
    @Test
    public void locationInvalidTest7() throws Exception {
        assertFalse(LostItemActivity.checkValidLocation("",""));
    }
}
