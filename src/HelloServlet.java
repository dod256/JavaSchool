import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class HelloServlet extends HttpServlet{

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        PrintWriter out = null;
        res.setContentType("text/html");
        out = res.getWriter();

        out.println("<html>");
        out.println("<head><title>Sample</title></head>");
        out.println("<body>");
        out.print("Hello, ");
        String name = req.getParameter("name");
        out.println(name);
        out.println("</body>");
        out.println("</html>");
        out.close();
        //getServletContext().getRequestDispatcher("/hello.jsp").forward(req, res);
    }

    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        PrintWriter out = null;
        res.setContentType("text/html");
        out = res.getWriter();

        out.println("<html>");
        out.println("<head><title>Sample</title></head>");
        out.println("<body>");
        out.print("Hello, ");
        String name = req.getParameter("login");
        out.println(name);
        out.println("</body>");
        out.println("</html>");
        out.close();
        //getServletContext().getRequestDispatcher("/hello.jsp").forward(req, res);
    }
}
