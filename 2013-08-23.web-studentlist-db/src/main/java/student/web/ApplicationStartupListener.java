package student.web;

import student.app.ApplicationContext;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class ApplicationStartupListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ApplicationContext context = new ApplicationContext();
        context.init();
        System.out.println("STUDENTS Web Application started....");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("STUDENTS Web Application stoped ....");
    }
}
