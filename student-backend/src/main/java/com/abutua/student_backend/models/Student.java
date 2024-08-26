package com.abutua.student_backend.models;

public class Student {
    
    //Atributos
    private int id;
    private String name;
    private String email; 
    private String phone;
    private int idCurso;
    private int periodo;


    public Student(int id, String name, String email, String phone, int idCurso, int periodo){
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.idCurso = idCurso;
        this.periodo = periodo;

    }

    public Student(){

    }

    //Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(int idCurso) {
        this.idCurso = idCurso;
    }

    public int getPeriodo() {
        return periodo;
    }

    public void setPeriodo(int periodo) {
        this.periodo = periodo;
    }

    
}
