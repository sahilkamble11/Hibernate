
package com.tap.tfl.demo.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="student")
public class Student {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    private String name;
    private String email;

    @ManyToOne
    @JoinColumn(name="course_id")
    private Course course;

    public void setId(int id){
        this.id=id;
    }

    public int getId(){
        return id;
    }

    public void setName(String name){
        this.name=name;
    }

    public String getName(){
        return name;
    }

    public void setEmail(String name){
        this.email=email;
    }

    public String getEmail(){
        return email;
    }

    public void setCourse(Course course2) {
        this.course=course;
    }

    public Course getCourse(){
        return course;
    }
}
