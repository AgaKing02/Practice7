package controllers;

import interfaces.AuthManager;
import models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AuthorizationManager")
public class AuthorizationManager extends HttpServlet implements AuthManager {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        User user = new User(request.getParameter("username"), request.getParameter("password"));
        if (checkAuthorization(user)) {
            Cookie cookie = new Cookie("user", user.getUsername());
            cookie.setMaxAge(300);
            response.addCookie(cookie);
            request.setAttribute("username", user.getUsername());
            doGet(request, response);
//            request.getRequestDispatcher("/profile.jsp").forward(request, response);
        } else {
            response.sendRedirect(request.getContextPath() + "/");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/profile.jsp").forward(request, response);
    }

    public String getInMemoryUsername() {
        return "astanait";
    }

    public String getInMemoryPassword() {
        return "2020";
    }

    @Override
    public boolean checkAuthorization(User user) {
        return user.getUsername().equals(getInMemoryUsername()) && user.getPassword().equals(getInMemoryPassword());
    }
}
