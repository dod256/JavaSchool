package main.java.services;

public class Validator {


    public static OperationResultMessage checkDate(String date) {
        if (date == null || date.equals("")) {
            return new OperationResultMessage("danger", "Inccorect date");
        } else {
            return new OperationResultMessage("success", "Date is ok");
        }
    }
}
