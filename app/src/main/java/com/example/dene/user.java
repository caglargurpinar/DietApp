package com.example.dene;

public class user {
    private String user_name;
    private String user_lastname;
    private String password;
    private static int id=0;
    private String email;

    public user(String name, String surname, String email, String password) {
        this.user_name=name;
        this.email = email;
        this.user_lastname = surname;
        this.password =  password;

    }

    public String getUser_name() {
        return user_name;
    }

    public String getUser_lastname() {
        return user_lastname;
    }

    public String getPassword() {
        return password;
    }

    public static int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public void setUser_lastname(String user_lastname) {
        this.user_lastname = user_lastname;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public static void setId(int id) {
        user.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
