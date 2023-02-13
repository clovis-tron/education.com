/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sms.dao;


import com.sms.model.Student;
import com.sms.model.StudentInfo;
import jdk.nashorn.internal.runtime.AccessorProperty;
import org.hibernate.*;

/**
 *
 * @author hnjej
 */
public class StudentDAO {

    public boolean createStudent(Student student) {
        boolean result=false;
        Session session=FactoryManager.getSessionFactory().openSession();
        Transaction tx=session.beginTransaction();
        session.save(student);
        tx.commit();
        session.close();
        result=Boolean.TRUE;
        return result;
    }

    public boolean updateStudent(Student student) {
        boolean result=false;
        Session session=FactoryManager.getSessionFactory().openSession();
        Transaction tx=session.beginTransaction();
        session.update(student);
        tx.commit();
        session.close();
        result=Boolean.TRUE;
        return result;
    }

    public static boolean createStudent(StudentInfo student) {
        boolean results=false;
        Session session=FactoryManager.getSessionFactory().openSession();
        Transaction tx=session.beginTransaction();
        session.save(student);
        tx.commit();
        session.close();
        results=Boolean.TRUE;
        return results;       
    }
    public boolean updateStudent(StudentInfo student) {
        boolean result=false;
        Session session=FactoryManager.getSessionFactory().openSession();
        Transaction tx=session.beginTransaction();
        session.update(student);
        tx.commit();
        session.close();
        result=Boolean.TRUE;
        return result;
    }
    
    public static void main(String args[])
    {
        StudentInfo stud = new StudentInfo(20000,"0767564764768","13/12/2018","female","scientific");
       
        boolean result = createStudent(stud);
        System.out.println(result);
    }
}

