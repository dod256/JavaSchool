package main.java.Servlets;

import main.java.Service;
import main.java.Entities.User;
import org.joda.time.DateTime;

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
        User user = User.newBuilder()
                .withEmail(email)
                .withPassword(password)
                .withFirstName(firstName)
                .withLastName(lastName)
                .withBirthdate(new Date(dt.getMillis()))
                .build();
        Service.addUser(user);
        res.sendRedirect("/loginPage.jsp");
    }

}
