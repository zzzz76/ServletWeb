package cc.openhome.controller;

import java.io.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login.do")
public class Login extends HttpServlet {
    private final String USERS = "/home/zzzz76/IdeaProjects/ServletWeb/users";
    private final String SUCCESS_VIEW = "member.view";
    private final String ERROR_VIEW = "index.html";

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {
	    /*
	     * 实现步骤1、2
	     */
	    String username = request.getParameter("username");
	    String password = request.getParameter("password");
	    if (checkLogin(username, password)) {
	        request.getRequestDispatcher(SUCCESS_VIEW).forward(request, response);
        }
        response.sendRedirect(ERROR_VIEW);
    }

    private boolean checkLogin(String username, String password)
            throws IOException {
        if(username != null && password != null) {
            for (String file : new File(USERS).list()) {
                if (file.equals(username)) {
                    BufferedReader reader = new BufferedReader(
                            new FileReader(USERS + "/" + file + "/profile"));
                    String passwd = reader.readLine().split("\t")[1];
                    if(passwd.equals(password)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
