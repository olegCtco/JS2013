package student.web.test;

import org.codehaus.jackson.map.ObjectMapper;
import student.app.test.ListTest;
import student.domain.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"/test/json2"})
public class ListJSON2Servlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ListTest app = new ListTest();
        List<Student> students = app.getStudents();
        req.setAttribute("students", students);
        req.getRequestDispatcher("/WEB-INF/view/test/json.jsp").forward(req, resp);
    }
}

