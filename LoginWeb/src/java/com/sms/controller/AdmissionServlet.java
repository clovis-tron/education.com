package com.sms.controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.sms.model.Student;
import com.sms.service.StudentService;
import com.sms.service.StudentServiceInterface;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Niyon
 */
@WebServlet(urlPatterns = {"/AdmissionServlet"})
public class AdmissionServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    
        //work on dopost 
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        // accept client credential from admission.hmtl file
        String FirstName = request.getParameter("firstname");
        String LastName = request.getParameter("lastname");
        String Email = request.getParameter("email");
        String Password = request.getParameter("password");
        String ConfirmPassword = request.getParameter("confirmpassword");
        
        
        
        //database
        try{
            
            // save data
            Student student = new Student(FirstName, LastName, Email, Password, ConfirmPassword);
            StudentServiceInterface studentService = new StudentService();
            studentService.saveStudent(student);
            
            response.sendRedirect("Login.html");
            
            
            
        }catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
        
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
