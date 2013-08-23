package student.app.test;

import student.domain.Student;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListTest {
    public List<Student> getStudents() {
        return Arrays.asList(new Student("Dummy"));
    }
}
