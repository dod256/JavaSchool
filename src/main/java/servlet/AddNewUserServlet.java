package servlet;

import dto.UserDto;
import helper.OperationResultMessage;
import service.UserServiceImpl;
import helper.ValidatorImpl;
import org.joda.time.DateTime;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/*
*  Response for creating new users
* */
public class AddNewUserServlet extends HttpServlet {

    public void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        String email = req.getParameter("email");
        OperationResultMessage message = ValidatorImpl.checkEmail(email);
        if (message.getStatus().equals("danger")) {
            req.getSession().setAttribute("operationResultMessage", message);
            res.sendRedirect("/WEB-INF/pages/showMessage.jsp");
            return;
        }
        String password = req.getParameter("password");
        String secondPassword = req.getParameter("secondPassword");
        message = ValidatorImpl.checkPasswords(password, secondPassword);
        if (message.getStatus().equals("danger")) {
            req.getSession().setAttribute("operationResultMessage", message);
            res.sendRedirect("/WEB-INF/pages/showMessage.jsp");
            return;
        }
        String firstName = req.getParameter("firstName");
        message = ValidatorImpl.checkName(firstName);
        if (message.getStatus().equals("danger")) {
            req.getSession().setAttribute("operationResultMessage", message);
            res.sendRedirect("/WEB-INF/pages/showMessage.jsp");
            return;
        }
        String lastName = req.getParameter("lastName");
        message = ValidatorImpl.checkName(lastName);
        if (message.getStatus().equals("danger")) {
            req.getSession().setAttribute("operationResultMessage", message);
            res.sendRedirect("/WEB-INF/pages/showMessage.jsp");
            return;
        }
        String birthDate = req.getParameter("birthdate");
        message = ValidatorImpl.checkDate(birthDate);
        if (message.getStatus().equals("danger")) {
            req.getSession().setAttribute("operationResultMessage", message);
            res.sendRedirect("/WEB-INF/pages/showMessage.jsp");
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
        //UserServiceImpl.addUser(userDto);
        res.sendRedirect("/WEB-INF/pages/login.jsp");
    }

}
