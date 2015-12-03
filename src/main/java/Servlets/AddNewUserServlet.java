package main.java.Servlets;

import main.java.Entities.User;
import main.java.services.OperationResultMessage;
import main.java.services.UserService;
import main.java.services.Validator;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;

public class AddNewUserServlet extends HttpServlet {

    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String secondPassword = req.getParameter("secondPassword");
        if (!password.equals(secondPassword)) {
            req.getSession().setAttribute("currentMessageType", "danger");
            req.getSession().setAttribute("currentMessage", "The passwords don't match.");
            res.sendRedirect("showMessage.jsp");
            return;
        }
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String birthDate = req.getParameter("birthdate");
        OperationResultMessage result = Validator.checkDate(birthDate);
        if (result.getStatus().equals("danger")) {
            req.getSession().setAttribute("operationResultMessage", result);
            res.sendRedirect("showMessage.jsp");
            return;
        }
        DateTime dt = DateTime.parse(birthDate);
        System.out.println(dt.toString(DateTimeFormat.fullDate()));
        User user = User.newBuilder()
                .withEmail(email)
                .withPassword(password)
                .withFirstName(firstName)
                .withLastName(lastName)
                .withBirthdate(new Date(dt.getMillis()))
                .withUserTypeId(2)
                .build();
        UserService.addUser(user);
        res.sendRedirect("/loginPage.jsp");
    }

}
