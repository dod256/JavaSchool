package main.java.Servlets;

import main.java.Entities.User;
import main.java.services.UserService;
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
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String birthDate = req.getParameter("birthdate");
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
