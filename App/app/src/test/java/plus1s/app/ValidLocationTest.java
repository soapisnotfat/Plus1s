package plus1s.app;

/**
 * Created by siyul on 7/16/2017.
 */
import plus1s.app.controllers.LostItemActivity;


import org.junit.Test;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ValidLocationTest {
    /**
     * Test for valid location input
     * @throws Exception if the input is not valid;
     */
    @Test
    public void locationValidTest() throws Exception {
        assertTrue(LostItemActivity.checkValidLocation("19", "19"));
        assertTrue(LostItemActivity.checkValidLocation("-19", "19"));
        assertTrue(LostItemActivity.checkValidLocation("19", "-19"));
        assertTrue(LostItemActivity.checkValidLocation("-19", "-19"));
    }

    /**
     * Test for invalid location input
     * @throws Exception if the input is not valid;
     */
    @Test
    public void locationInvalidTest() throws Exception {
        assertFalse(LostItemActivity.checkValidLocation("100", "19"));
        assertFalse(LostItemActivity.checkValidLocation("100", "189"));
        assertFalse(LostItemActivity.checkValidLocation("80", "189"));
        assertFalse(LostItemActivity.checkValidLocation("80", "-189"));
        assertFalse(LostItemActivity.checkValidLocation("-100", "19"));
        assertFalse(LostItemActivity.checkValidLocation("-100", "-189"));
        assertFalse(LostItemActivity.checkValidLocation("",""));
    }
}
