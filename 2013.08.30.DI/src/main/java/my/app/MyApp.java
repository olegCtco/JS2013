package my.app;

import my.app.db.DB;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class MyApp {
    public static void main(String[] args) throws IOException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        System.out.println("Hello World!!");
        Properties properties = new Properties();
        InputStream resourceAsStream = MyApp.class.getClassLoader().getResourceAsStream("app.properties");
        properties.load(resourceAsStream);
        String dbName = properties.getProperty("my.app.db", "ERROR");
        System.out.println(dbName);

        Class<DB> clazz = (Class<DB>) Class.forName(dbName);
        DB db = clazz.newInstance();
        System.out.println("DB is: "+db.name());

    }
}
