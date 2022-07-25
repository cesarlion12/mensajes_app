package com.example.mensajes_app;

import java.util.ArrayList;
import java.util.Scanner;

public class MensajesService {
    public static void crearMensaje(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Escribe tu mensaje");
        String mensaje = sc.nextLine();

        System.out.println("Tu Nombre");
        String nombre = sc.nextLine();

        Mensajes registro = new Mensajes();
        registro.setMensaje(mensaje);
        registro.setAutor_Mensaje(nombre);
        MensajesDAO.crearMensajeDB(registro);
    }

    // Metodo para mostrar los mensajes listados de mi capa DAO para mostrarlos al usuario
    public static void listarMensaje(){
        System.out.println("Mensajes");
        ArrayList<Mensajes> mensajes = MensajesDAO.lerrMensajesDB();

        for (Mensajes mensaje:mensajes){
            System.out.println("ID: " + mensaje.getId_mensaje());
            System.out.println("Mensaje: " + mensaje.getMensaje());
            System.out.println("Autor: " + mensaje.getAutor_Mensaje());
            System.out.println("Fecha: " + mensaje.getFecha_Mensaje());
            System.out.println("");
        }
    }

    public static void borrarMensaje(){

    }

    public static void editarMensaje(){

    }
}
