package cc.openhome.web;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import cc.openhome.model.UserService;

@WebListener
public class GossipListener implements ServletContextListener{
	public void contextInitialized(ServletContextEvent sce){
		ServletContext context = sce.getServletContext();
		String USERS = context.getInitParameter("USERS");
		context.setAttribute("userService", new UserService(USERS));
	}
	public void contextDestroyed(ServletContextEvent sce){}
}