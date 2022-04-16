package com.example.finalproject.model;

public class User {

    public String Name;
    public String Email;
    public String Password;
    public String JobPosition;
    public String Title;
    public int id;

    public User() {
    }

    public User(int id, String name, String email, String password, String jobPosition, String title) {
        id = id;
        Name = name;
        Email = email;
        Password = password;
        JobPosition = jobPosition;
        Title = title;

    }

    public User(String name, String email, String password, String jobPosition, String title) {
        Name = name;
        Email = email;
        Password = password;
        JobPosition = jobPosition;
        Title = title;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getJobPosition() {
        return JobPosition;
    }

    public void setJobPosition(String jobPosition) {
        JobPosition = jobPosition;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

}
