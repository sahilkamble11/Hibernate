package com.tap.tfl.demo;

import org.hibernate.Session;        
import org.hibernate.Transaction;

import com.tap.tfl.demo.entities.Course;
import com.tap.tfl.demo.entities.Student;
import com.tap.tfl.demo.util.HibernateUtil; 

public class App 
{
    public static void main( String[] args )
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        // 🔹 CREATE Course
        Course course = new Course();
        course.setName("Java Full Stack");
        course.setDuration("6 Months");
        session.save(course);

        // 🔹 CREATE Student
        Student student = new Student();
        student.setName("Nirjala");
        student.setEmail("nirjala@gmail.com");
        student.setCourse(course);
        session.save(student);

        tx.commit();
        session.close();

        // 🔹 READ
        Session readSession = HibernateUtil.getSessionFactory().openSession();
        Student s = readSession.get(Student.class, 2);
        System.out.println(s.getName());
        readSession.close();

        // 🔹 UPDATE
        Session updateSession = HibernateUtil.getSessionFactory().openSession();
        Transaction tx2 = updateSession.beginTransaction();
        Student updateStudent = updateSession.get(Student.class, 4);
        updateStudent.setName("Sahil");
        tx2.commit();
        updateSession.close();

        // 🔹 DELETE
        Session deleteSession = HibernateUtil.getSessionFactory().openSession();
        Transaction tx3 = deleteSession.beginTransaction();
        Student deleteStudent = deleteSession.get(Student.class, 3);
        deleteSession.delete(deleteStudent);
        tx3.commit();
        deleteSession.close();
    HibernateUtil.getSessionFactory().close();
        System.out.println("CRUD Operations Completed Successfully");
    }
}
