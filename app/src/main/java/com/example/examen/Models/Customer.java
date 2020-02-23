package com.example.examen.Models;

public class Customer {


    private String name;
    private String surname;
    private String DNI;

    public Customer() {
    }

    public Customer(String name, String surname, String DNI) {
        this.name = name;
        this.surname = surname;
        this.DNI = DNI;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

}
