package com.example.quang_project_rest_api.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Contact implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private String name;
    private Date date;
    private int age;
    private String email;
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;
    public Contact(){
        id=0;
    }
    public Contact(int id,String name, int age, Date date, String email) {
        this.id =id;
        this.name =name;
        this.age =age;
        this.date =date;
        this.email =email;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
}
