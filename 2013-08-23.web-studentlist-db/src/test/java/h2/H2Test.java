package h2;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class H2Test {

    private Statement stmt;
    private Connection conn;

    @Before
    public void setUp() throws ClassNotFoundException, SQLException {
        String driverName = "org.h2.Driver";
        Class.forName(driverName);
        String url = "jdbc:" + "h2:" + "./db/h2test";
        conn = DriverManager.getConnection(url, "sa", "");
        stmt = conn.createStatement();
    }

    @After
    public void teadDown() {
        if (stmt != null) try {
            stmt.close();
        } catch (SQLException ignore) {
        }
        if (conn != null) try {
            conn.close();
        } catch (SQLException ignore) {
        }

    }

    @Test
    public void init() throws SQLException {
        String sql = "CREATE TABLE STUDENTS (" +
                "ID INT auto_increment PRIMARY KEY," +
                " FNAME VARCHAR," +
                " SNAME VARCHAR," +
                " UNI VARCHAR" +
                ");";
        stmt.executeUpdate(sql);
    }

    void close(Statement stmt, Connection conn) {
    }

    @Test
    public void insert() throws SQLException {
        stmt.executeUpdate("INSERT INTO STUDENTS(FNAME,SNAME,UNI) VALUES('DENIS','UDOD','RKIIGA')");
        ResultSet rs = stmt.executeQuery("SELECT * FROM STUDENTS");
        while (rs.next()) {
            String s = rs.getInt("ID") + ":" +
                    rs.getString("FNAME") + ":" +
                    rs.getString("SNAME") + ":" +
                    rs.getString("UNI");
            System.out.println(s);
        }
    }

}
