package com.example.ftrani.sqlitedemo;

/**
 * Created by ftrani on 16/9/17.
 */

public class Contacto {
    private int telefono;
    private String nombre;
    private String email;
    private String domicilio;
    private int id;

    public Contacto(int telefono, String nombre, String email, String domicilio) {
        this.telefono = telefono;
        this.nombre = nombre;
        this.email = email;
        this.domicilio = domicilio;
    }

    public int getTelefono() {
        return telefono;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }
}
