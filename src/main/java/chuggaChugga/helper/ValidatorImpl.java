package chuggaChugga.helper;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidatorImpl implements Validator{

    public static ResultMessage generalCheck(String string) {
        if (string == null || string.equals("")) {
            return new ResultMessage("danger", "String is empty");
        } else {
            return new ResultMessage("success", "String is not empty");
        }
    }


    public static ResultMessage checkNumber(String number) {
        ResultMessage isEmpty = generalCheck(number);
        if (isEmpty.getStatus().equals("danger")) {
            return isEmpty;
        }
        Pattern p = Pattern.compile("^[0-9]+?$");
        Matcher m = p.matcher(number);
        if (m.matches()) {
            return new ResultMessage("success", "It's a number");
        } else {
            return new ResultMessage("danger", "It isn't a number");
        }
    }

    public static ResultMessage checkDate(String date) {
        ResultMessage isEmpty = generalCheck(date);
        if (isEmpty.getStatus().equals("danger")) {
            return isEmpty;
        }
        if (date == null || date.equals("")) {
            return new ResultMessage("danger", "Incorrect date");
        } else {
            return new ResultMessage("success", "Date is ok");
        }
    }

    public static ResultMessage checkEmail(String email) {
        ResultMessage isEmpty = generalCheck(email);
        if (isEmpty.getStatus().equals("danger")) {
            return isEmpty;
        }
        Pattern p = Pattern.compile("^[@a-zA-Z0-9_\\-\\.]+?$");
        Matcher m = p.matcher(email);
        if (m.matches()) {
            return new ResultMessage("success", "Email is ok");
        } else {
            return new ResultMessage("danger", "Incorrect email. Use only a-z, A-Z, 0-9, _ and -");
        }
    }

    public static ResultMessage checkName(String name) {
        ResultMessage isEmpty = generalCheck(name);
        if (isEmpty.getStatus().equals("danger")) {
            return isEmpty;
        }
        Pattern p = Pattern.compile("^[a-zA-Z]+?$");
        Matcher m = p.matcher(name);
        if (m.matches()) {
            return new ResultMessage("success", "Name is ok");
        } else {
            return new ResultMessage("danger", "Incorrect name. Use only a-z, A-Z");
        }
    }

    public static ResultMessage checkPasswords(String password, String secondPassword) {
        ResultMessage isEmpty = generalCheck(password);
        if (isEmpty.getStatus().equals("danger")) {
            return isEmpty;
        }
        isEmpty = generalCheck(secondPassword);
        if (isEmpty.getStatus().equals("danger")) {
            return isEmpty;
        }
        if (password.equals(secondPassword)) {
            return new ResultMessage("success", "Passwords is ok");
        } else {
            return new ResultMessage("danger", "The passwords don't match");
        }
    }

}
