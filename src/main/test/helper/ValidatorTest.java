package main.test.helper;

import main.java.helper.Validator;
import org.junit.Test;
import static junit.framework.TestCase.assertEquals;

public class ValidatorTest  {

    private final String checkFailed = "danger";
    private final String checkPassed = "success";

    @Test
    public void testCheckDate() throws Exception {
        assertEquals(checkFailed, Validator.checkDate("").getStatus());
        assertEquals(checkFailed, Validator.checkDate(null).getStatus());
        assertEquals(checkPassed, Validator.checkDate("12/01/2011").getStatus());
    }

    @Test
    public void testCheckEmail() throws Exception {
        assertEquals(checkPassed, Validator.checkEmail("qwe").getStatus());
        assertEquals(checkPassed, Validator.checkEmail("qwe@qwe.").getStatus());
        assertEquals(checkPassed, Validator.checkEmail("-_").getStatus());
        assertEquals(checkFailed, Validator.checkEmail(",").getStatus());
        assertEquals(checkFailed, Validator.checkEmail("").getStatus());
        assertEquals(checkFailed, Validator.checkEmail("").getStatus());
        assertEquals(checkFailed, Validator.checkEmail(null).getStatus());
    }

    @Test
    public void testCheckName() throws Exception {
        assertEquals(checkPassed, Validator.checkName("qweRTYeiosdifosdjfoejjskdgjfkdf").getStatus());
        assertEquals(checkFailed, Validator.checkName("qwe9").getStatus());
        assertEquals(checkFailed, Validator.checkName("qwe ui").getStatus());
        assertEquals(checkFailed, Validator.checkName("").getStatus());
        assertEquals(checkFailed, Validator.checkName(",").getStatus());
        assertEquals(checkFailed, Validator.checkName(null).getStatus());

    }

    @Test
    public void testCheckPasswords() throws Exception {
        assertEquals(checkPassed, Validator.checkPasswords("qwe", "qwe").getStatus());
        assertEquals(checkFailed, Validator.checkPasswords("", "").getStatus());
        assertEquals(checkFailed, Validator.checkPasswords(" ", "  ").getStatus());
        assertEquals(checkFailed, Validator.checkPasswords(null, null).getStatus());
        assertEquals(checkFailed, Validator.checkPasswords(null, "qwe").getStatus());
    }
}