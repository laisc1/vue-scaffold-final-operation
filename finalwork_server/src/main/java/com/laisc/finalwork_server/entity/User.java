package com.laisc.finalwork_server.entity;

public class User {
    private Integer id=0;
    private String username="";
    private String password="";
    private String role="";
    private String signature="";

    public User() {
    }

    public User(Integer id, String username, String password, String role, String signature) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.role = role;
        this.signature = signature;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                ", signature='" + signature + '\'' +
                '}';
    }
}
