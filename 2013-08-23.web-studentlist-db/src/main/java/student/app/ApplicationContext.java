package student.app;

import student.app.db.DBService;

public class ApplicationContext {

    private static ApplicationContext context;

    private DBService db;

    public static ApplicationContext getContext() {
        return context;
    }

    public void init() {
        context = this;
        //
        db = new DBService();
        db.init();
        //
    }

    public DBService getDBService() {
        return db;
    }
}
