package controllers;

import interfaces.AuthManager;
import models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class MyServlet1 extends HttpServlet implements AuthManager
{
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response) {
        try{
            response.setContentType("text/html");
            PrintWriter pwriter = response.getWriter();

            String name = request.getParameter("username");
            String password = request.getParameter("password");
            if(checkAuthorization(new User(name,password))){
                pwriter.print("Hello "+name);
                //Creating two cookies
                Cookie c1=new Cookie("username",name);
                //Adding the cookies to response header
                response.addCookie(c1);
                pwriter.print("<br><a href='welcome'>View Details</a>");
                pwriter.close();
            }

        }catch(Exception exp){
            System.out.println(exp);
        }
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