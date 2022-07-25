package com.example.mensajes_app;

import org.omg.CORBA.PUBLIC_MEMBER;

public class Mensajes {
    private int id_mensaje;
    private String mensaje;
    private String autor;
    private String fecha_Mensaje;

    public Mensajes(){

    }

    public Mensajes(String mensaje, String autor, String fecha_Mensaje) {
        this.mensaje = mensaje;
        this.autor = autor;
        this.fecha_Mensaje = fecha_Mensaje;
    }

    public int getId_mensaje() {
        return id_mensaje;
    }

    public void setId_mensaje(int id_mensaje) {
        this.id_mensaje = id_mensaje;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getAutor_Mensaje() {
        return autor;
    }

    public void setAutor_Mensaje(String autor) {
        this.autor = autor;
    }

    public String getFecha_Mensaje() {
        return fecha_Mensaje;
    }

    public void setFecha_Mensaje(String fecha_Mensaje) {
        this.fecha_Mensaje = fecha_Mensaje;
    }
}
