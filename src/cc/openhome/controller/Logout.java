package cc.openhome.controller;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(
        urlPatterns={"/logout.do"},
        initParams={
                @WebInitParam(name = "LOGIN_VIEW", value = "index.html")
        }
)
public class Logout extends HttpServlet {
    private String LOGIN_VIEW;

    @Override
    public void init() throws ServletException {
        LOGIN_VIEW = getServletConfig().getInitParameter("LOGIN_VIEW");
    }

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {
        request.getSession().invalidate();
        response.sendRedirect(LOGIN_VIEW);
    }
}