package my.app;

import my.app.db.DB;
import sun.misc.Service;

import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
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

        Iterator<DB> providers = Service.providers(DB.class);
        while (providers.hasNext()) {
            DB db2 =  providers.next();
            System.out.println("Service name:"+db2.name());
        }
        System.out.println(Service.providers(DB.class).next());
        System.out.println(Service.providers(DB.class).next());

        String myDb = properties.getProperty("my.db");
        providers = Service.providers(DB.class);
        while (providers.hasNext()) {
            DB db2 =  providers.next();
           if (myDb.equals(db2.name())) {
               System.out.println("Use in my app:"+db2.name());
           }
        }

    }
}
