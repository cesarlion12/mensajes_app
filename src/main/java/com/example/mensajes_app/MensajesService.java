package com.example.mensajes_app;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class MensajesService {
    public static void crearMensaje() throws SQLException {
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
    public static void listarMensaje() throws SQLException {
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

    public static void borrarMensaje() throws SQLException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce el ID del mensaje que desea eliminar");
        int id_mensaje = sc.nextInt();
        MensajesDAO.borrarMensajeDB(id_mensaje);
    }

    public static void editarMensaje() throws SQLException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Escribe tu nuevo mensaje");
        String mensaje = sc.nextLine();

        System.out.println("Indica el id del mensaje que desea editar");
        int id_mesaje = sc.nextInt();
        Mensajes actualizacionMensaje = new Mensajes();
        actualizacionMensaje.setId_mensaje(id_mesaje);
        actualizacionMensaje.setMensaje(mensaje);
        MensajesDAO.actualizarMensajesDB(actualizacionMensaje);

    }
}
