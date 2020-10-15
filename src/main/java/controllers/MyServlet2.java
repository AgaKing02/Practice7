package controllers;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class MyServlet2 extends HttpServlet {
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response){
        try{
            response.setContentType("text/html");
            PrintWriter pwriter = response.getWriter();
            //Reading cookies
            Cookie c[]=request.getCookies();
            //Displaying User name value from cookie
            for (Cookie cookie:c){
                if(cookie.getName().equals("username")){
                    pwriter.print("Name: "+cookie.getValue());
                }
            }

            pwriter.print("<form method='post' action="+request.getContextPath()+"/welcome"+"><input type='submit' value='Logout'></form>");
            //Displaying user password value from cookie


            pwriter.close();
        }catch(Exception exp){
            System.out.println(exp);
        }
    }
    public void doPost(HttpServletRequest request,
                      HttpServletResponse response){
        Cookie c[]=request.getCookies();
        for (Cookie cookie:c){

            if(cookie.getName().equals("username")){
                System.out.println(cookie.getValue()+" going to be removed");
                cookie.setMaxAge(0);
                cookie.setValue("");
                cookie.setPath("/");
                System.out.println(cookie.getValue()+" going to be removed 2" );
                response.addCookie(cookie);
            }

        }


        try {
            request.getRequestDispatcher("/").forward(request,response);
        } catch (IOException | ServletException e) {
            e.printStackTrace();
        }
    }

}