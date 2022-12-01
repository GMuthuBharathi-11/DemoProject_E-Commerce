package com.Demo_Project_ECommerce.Demo_Project_E_Commerce;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ImageModel {
    @WebServlet(name = "Servlet model", value = "/Servlet model")
    public class Imagemodel extends HttpServlet {
        @Override
        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        }
    }
}
