package my.app.db;


public class DBInMemory implements DB{
    @Override
    public String name() {
        return "memory";
    }
}
