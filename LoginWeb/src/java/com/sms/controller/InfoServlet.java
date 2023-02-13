/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sms.controller;


import com.sms.model.StudentInfo;
import com.sms.service.StudentService;
import com.sms.service.StudentServiceInterface;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import static jdk.nashorn.internal.runtime.Debug.id;

/**
 *
 * @author Niyon
 */
@WebServlet (urlPatterns = {"/InfoServlet"})
public class InfoServlet extends HttpServlet {

    private Long id;


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       //work on dopost 
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        // accept client credential from admission.hmtl file
        String phone = request.getParameter("phone");
        String birthdate = request.getParameter("birthdate");
        String gender = request.getParameter("gender");
        String studentid = request.getParameter("studentid");
        String degree = request.getParameter("degree");
        
        
         System.out.println("studentid"+studentid+"phone"+phone+"birthdate"+birthdate+"gender"+gender+"degree"+degree); 
            
        //database
        try{
            
            // save data
            StudentInfo student = new StudentInfo(Integer.valueOf(studentid) , phone, birthdate, gender , degree);
            StudentServiceInterface studentService = new StudentService();
            studentService.saveStudent(student);
           
           response.sendRedirect("welcome.html");
            
           
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
