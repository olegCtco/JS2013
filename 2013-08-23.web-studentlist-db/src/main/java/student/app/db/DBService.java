package student.app.db;

import org.apache.commons.pool.BaseObjectPool;
import org.apache.commons.pool.BasePoolableObjectFactory;
import org.apache.commons.pool.PoolableObjectFactory;
import org.apache.commons.pool.impl.GenericObjectPool;
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
        Connection conn = null;
        try {
            conn = pool.borrowObject();
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
            returnConnectionToPool(conn);
            closeStatement(stmt);
        }
    }

     void closeStatement(Statement stmt) {
        try {
            if (stmt != null) stmt.close();
        } catch (SQLException ignore) {
        }
    }

     void returnConnectionToPool(Connection conn) {
        try {
            if (conn!=null) pool.returnObject(conn);
        } catch (Exception e) {
        }
    }


    GenericObjectPool<Connection> pool;
    PoolableObjectFactory<Connection> connectionFactory = new BasePoolableObjectFactory<Connection>(){
        @Override
        public Connection makeObject() throws Exception {
            try {
                String url = "jdbc:" + "h2:" + "./db/h2test";
                return DriverManager.getConnection(url, "sa", "");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        @Override
        public void destroyObject(Connection connection) throws Exception {
            connection.close();
        }
    };

    public void init() {
        try {
            String driverName = "org.h2.Driver";
            Class.forName(driverName);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        pool= new GenericObjectPool<Connection>(connectionFactory);
    }
}
