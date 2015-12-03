package main.test.helper;

import main.java.helper.ValidatorImpl;
import org.junit.Test;
import static junit.framework.TestCase.assertEquals;

public class ValidatorImplTest {

    private final String checkFailed = "danger";
    private final String checkPassed = "success";

    @Test
    public void testCheckDate() throws Exception {
        assertEquals(checkFailed, ValidatorImpl.checkDate("").getStatus());
        assertEquals(checkFailed, ValidatorImpl.checkDate(null).getStatus());
        assertEquals(checkPassed, ValidatorImpl.checkDate("12/01/2011").getStatus());
    }

    @Test
    public void testCheckEmail() throws Exception {
        assertEquals(checkPassed, ValidatorImpl.checkEmail("qwe").getStatus());
        assertEquals(checkPassed, ValidatorImpl.checkEmail("qwe@qwe.").getStatus());
        assertEquals(checkPassed, ValidatorImpl.checkEmail("-_").getStatus());
        assertEquals(checkFailed, ValidatorImpl.checkEmail(",").getStatus());
        assertEquals(checkFailed, ValidatorImpl.checkEmail("").getStatus());
        assertEquals(checkFailed, ValidatorImpl.checkEmail("").getStatus());
        assertEquals(checkFailed, ValidatorImpl.checkEmail(null).getStatus());
    }

    @Test
    public void testCheckName() throws Exception {
        assertEquals(checkPassed, ValidatorImpl.checkName("qweRTYeiosdifosdjfoejjskdgjfkdf").getStatus());
        assertEquals(checkFailed, ValidatorImpl.checkName("qwe9").getStatus());
        assertEquals(checkFailed, ValidatorImpl.checkName("qwe ui").getStatus());
        assertEquals(checkFailed, ValidatorImpl.checkName("").getStatus());
        assertEquals(checkFailed, ValidatorImpl.checkName(",").getStatus());
        assertEquals(checkFailed, ValidatorImpl.checkName(null).getStatus());

    }

    @Test
    public void testCheckPasswords() throws Exception {
        assertEquals(checkPassed, ValidatorImpl.checkPasswords("qwe", "qwe").getStatus());
        assertEquals(checkFailed, ValidatorImpl.checkPasswords("", "").getStatus());
        assertEquals(checkFailed, ValidatorImpl.checkPasswords(" ", "  ").getStatus());
        assertEquals(checkFailed, ValidatorImpl.checkPasswords(null, null).getStatus());
        assertEquals(checkFailed, ValidatorImpl.checkPasswords(null, "qwe").getStatus());
    }
}