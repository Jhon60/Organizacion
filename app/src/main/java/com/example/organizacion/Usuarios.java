package com.example.organizacion;

public class Usuarios {
    private String Nombre;
    private String Apellido;
    private String Email;
    private String Contraseña;
    private String ConfContraseña;

    public Usuarios(){

    }

    public  Usuarios(String Nombre, String Apellido, String Email, String Contraseña, String ConfContraseña){
        this.setNombre(Nombre);
        this.setApellido(Apellido);
        this.setEmail(Email);
        this.setContraseña(Contraseña);
        this.setConfContraseña(ConfContraseña);
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String apellido) {
        Apellido = apellido;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getContraseña() {
        return Contraseña;
    }

    public void setContraseña(String contraseña) {
        Contraseña = contraseña;
    }

    public String getConfContraseña() {
        return ConfContraseña;
    }

    public void setConfContraseña(String confContraseña) {
        ConfContraseña = confContraseña;
    }
}
