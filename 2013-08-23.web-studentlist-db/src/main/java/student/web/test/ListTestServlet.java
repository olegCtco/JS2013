package student.web.test;

import com.fasterxml.jackson.core.JsonFactory;
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

@WebServlet(urlPatterns = {"/test/list"})
public class ListTestServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getContentType();
        ListTest app = new ListTest();
        List<Student> students = app.getStudents();
        req.setAttribute("students",students);
        //
        if ("application/json".equals(req.getContentType())) {
            //1. Convert Java object to JSON format
            ObjectMapper mapper = new ObjectMapper();
            mapper.writeValue(resp.getWriter(),students);
        } else {
            req.getRequestDispatcher("/WEB-INF/view/test/list.jsp").forward(req,resp);
        }
    }
}
