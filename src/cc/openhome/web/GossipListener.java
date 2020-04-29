package cc.openhome.web;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import cc.openhome.model.AccountDAOImpl;
import cc.openhome.model.BlahDAOImpl;
import cc.openhome.model.UserService;

@WebListener
public class GossipListener implements ServletContextListener {
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext context = sce.getServletContext();
        String USERS = sce.getServletContext().getInitParameter("USERS");
        context.setAttribute("userService", new UserService(new AccountDAOImpl(USERS), new BlahDAOImpl(USERS)));
    }

    public void contextDestroyed(ServletContextEvent sce) {
    }
}