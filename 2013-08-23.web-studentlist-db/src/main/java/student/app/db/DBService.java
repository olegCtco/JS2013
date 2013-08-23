package student.app.db;

import student.domain.Student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DBService {

    public List<Student> findAllStudents() {
        Statement stmt = null;
        try {
            List<Student> students = new ArrayList<>();
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM STUDENTS");
            while (rs.next()){
                String name = rs.getString("FNAME");
                Student student = new Student(name);
                students.add(student);
            }
            return students;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (stmt != null) stmt.close();
            } catch (SQLException ignore) {
            }
        }
    }

    private Connection conn;

    public void init() {
        try {
            String driverName = "org.h2.Driver";
            Class.forName(driverName);
            String url = "jdbc:" + "h2:" + "./db/h2test";
            conn = DriverManager.getConnection(url, "sa", "");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
