import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class AddServlet extends HttpServlet {

    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String name = req.getParameter("name");
        int age = Integer.parseInt(req.getParameter("age"));
        if (req.getSession().getAttribute("personList") == null) {
            req.getSession().setAttribute("personList", new ArrayList<Person>());
        }
        ArrayList<Person> personList = (ArrayList<Person>) req.getSession().getAttribute("personList");
        personList.add(new Person(name, age));
        req.getSession().setAttribute("personList", personList);
        res.sendRedirect("/Ages.jsp");
    }

}
