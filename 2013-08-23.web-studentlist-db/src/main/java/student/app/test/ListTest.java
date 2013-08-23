package student.app.test;

import student.app.ApplicationContext;
import student.app.db.DBService;
import student.domain.Student;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListTest {
    public List<Student> getStudents() {
        ApplicationContext context = ApplicationContext.getContext();
        DBService db = context.getDBService();
        List<Student> students = db.findAllStudents();
        return students;
    }
}
