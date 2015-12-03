package main.java.Servlets;

import main.java.Entities.User;
import main.java.dto.UserDto;
import main.java.helper.OperationResultMessage;
import main.java.services.UserService;
import main.java.helper.Validator;
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
        OperationResultMessage message = Validator.checkEmail(email);
        if (message.getStatus().equals("danger")) {
            req.getSession().setAttribute("operationResultMessage", message);
            res.sendRedirect("showMessage.jsp");
            return;
        }
        String password = req.getParameter("password");
        String secondPassword = req.getParameter("secondPassword");
        message = Validator.checkPasswords(password, secondPassword);
        if (message.getStatus().equals("danger")) {
            req.getSession().setAttribute("operationResultMessage", message);
            res.sendRedirect("showMessage.jsp");
            return;
        }
        String firstName = req.getParameter("firstName");
        message = Validator.checkName(firstName);
        if (message.getStatus().equals("danger")) {
            req.getSession().setAttribute("operationResultMessage", message);
            res.sendRedirect("showMessage.jsp");
            return;
        }
        String lastName = req.getParameter("lastName");
        message = Validator.checkName(lastName);
        if (message.getStatus().equals("danger")) {
            req.getSession().setAttribute("operationResultMessage", message);
            res.sendRedirect("showMessage.jsp");
            return;
        }
        String birthDate = req.getParameter("birthdate");
        message = Validator.checkDate(birthDate);
        if (message.getStatus().equals("danger")) {
            req.getSession().setAttribute("operationResultMessage", message);
            res.sendRedirect("showMessage.jsp");
            return;
        }
        DateTime dt = DateTime.parse(birthDate);
        UserDto userDto = UserDto.newBuilder()
                .withEmail(email)
                .withPassword(password)
                .withFirstName(firstName)
                .withLastName(lastName)
                .withBirthdate(dt)
                .withUserTypeId(2)
                .build();
        UserService.addUser(userDto);
        res.sendRedirect("/loginPage.jsp");
    }

}
