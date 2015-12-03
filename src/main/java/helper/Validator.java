package main.java.helper;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {


    public static OperationResultMessage checkDate(String date) {
        if (date == null || date.equals("")) {
            return new OperationResultMessage("danger", "Inccorect date");
        } else {
            return new OperationResultMessage("success", "Date is ok");
        }
    }

    public static OperationResultMessage checkEmail(String email) {
        Pattern p = Pattern.compile("^[@a-zA-Z0-9_-]+?$");
        Matcher m = p.matcher(email);
        if (m.matches()) {
            return new OperationResultMessage("success", "Email is ok");
        } else {
            return new OperationResultMessage("danger", "Inccorect email. Use only a-z, A-Z, 0-9, _ and -");
        }
    }

    public static OperationResultMessage checkName(String name) {
        Pattern p = Pattern.compile("^[a-zA-Z]+?$");
        Matcher m = p.matcher(name);
        if (m.matches()) {
            return new OperationResultMessage("success", "Name is ok");
        } else {
            return new OperationResultMessage("danger", "Inccorect name. Use only a-z, A-Z");
        }
    }

    public static OperationResultMessage checkPasswords(String password, String secondPassword) {
        if (password.equals(secondPassword)) {
            return new OperationResultMessage("success", "Passwords is ok");
        } else {
            return new OperationResultMessage("danger", "The passwords don't match");
        }
    }

}
