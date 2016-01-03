package chuggaChugga.helper;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidatorImpl implements Validator{

    public static OperationResultMessage generalCheck(String string) {
        if (string == null || string.equals("")) {
            return new OperationResultMessage("danger", "String is empty");
        } else {
            return new OperationResultMessage("success", "String is not empty");
        }
    }


    public static OperationResultMessage checkNumber(String number) {
        OperationResultMessage isEmpty = generalCheck(number);
        if (isEmpty.getStatus().equals("danger")) {
            return isEmpty;
        }
        Pattern p = Pattern.compile("^[0-9]+?$");
        Matcher m = p.matcher(number);
        if (m.matches()) {
            return new OperationResultMessage("success", "It's a number");
        } else {
            return new OperationResultMessage("danger", "It isn't a number");
        }
    }

    public static OperationResultMessage checkDate(String date) {
        OperationResultMessage isEmpty = generalCheck(date);
        if (isEmpty.getStatus().equals("danger")) {
            return isEmpty;
        }
        if (date == null || date.equals("")) {
            return new OperationResultMessage("danger", "Incorrect date");
        } else {
            return new OperationResultMessage("success", "Date is ok");
        }
    }

    public static OperationResultMessage checkEmail(String email) {
        OperationResultMessage isEmpty = generalCheck(email);
        if (isEmpty.getStatus().equals("danger")) {
            return isEmpty;
        }
        Pattern p = Pattern.compile("^[@a-zA-Z0-9_\\-\\.]+?$");
        Matcher m = p.matcher(email);
        if (m.matches()) {
            return new OperationResultMessage("success", "Email is ok");
        } else {
            return new OperationResultMessage("danger", "Incorrect email. Use only a-z, A-Z, 0-9, _ and -");
        }
    }

    public static OperationResultMessage checkName(String name) {
        OperationResultMessage isEmpty = generalCheck(name);
        if (isEmpty.getStatus().equals("danger")) {
            return isEmpty;
        }
        Pattern p = Pattern.compile("^[a-zA-Z]+?$");
        Matcher m = p.matcher(name);
        if (m.matches()) {
            return new OperationResultMessage("success", "Name is ok");
        } else {
            return new OperationResultMessage("danger", "Incorrect name. Use only a-z, A-Z");
        }
    }

    public static OperationResultMessage checkPasswords(String password, String secondPassword) {
        OperationResultMessage isEmpty = generalCheck(password);
        if (isEmpty.getStatus().equals("danger")) {
            return isEmpty;
        }
        isEmpty = generalCheck(secondPassword);
        if (isEmpty.getStatus().equals("danger")) {
            return isEmpty;
        }
        if (password.equals(secondPassword)) {
            return new OperationResultMessage("success", "Passwords is ok");
        } else {
            return new OperationResultMessage("danger", "The passwords don't match");
        }
    }

}
