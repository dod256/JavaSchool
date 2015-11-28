package main.java.Servlets;

import main.java.Service;
import main.java.User;
import main.java.builders.UserBuilder;
import org.joda.time.DateTime;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddNewUserServlet extends HttpServlet {

    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String birthdate = req.getParameter("birthdate");
        DateTime dt = DateTime.parse(birthdate);
        User user = new UserBuilder().setEmail(email).setPassword(password).setFirstName(firstName).setLastName(lastName).setBirthDate(dt).createUser();
        Service.addUser(user);
        res.sendRedirect("/loginPage.jsp");
    }

}
