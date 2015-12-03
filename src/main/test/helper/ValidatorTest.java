package main.test.helper;

import junit.framework.TestCase;
import main.java.helper.OperationResultMessage;
import main.java.helper.Validator;
import org.junit.Test;


public class ValidatorTest extends TestCase {

    @Test
    public void testCheckDate() throws Exception {
        OperationResultMessage successResultMessage = new OperationResultMessage("success","Date is ok");
        OperationResultMessage failedResultMessage = new OperationResultMessage("danger","Incorrect date");


        assertEquals(Validator.checkDate(""), (failedResultMessage));
    }

    public void testCheckEmail() throws Exception {

    }

    public void testCheckName() throws Exception {

    }

    public void testCheckPasswords() throws Exception {

    }
}