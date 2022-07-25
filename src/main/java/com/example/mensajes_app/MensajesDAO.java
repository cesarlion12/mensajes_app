package com.example.mensajes_app;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MensajesDAO {
    public static void crearMensajeDB(Mensajes mensajes){
        //Conexion db_connet = new Conexion();

        try(Connection connection = ConexionSigleton.getConnection()){
            PreparedStatement ps = null;
            try{
                String query = "INSERT INTO mensajes_app.mensajes(mensaje,autor,fecha_mensaje) VALUES (?, ?,CURRENT_TIMESTAMP())";
                ps= connection.prepareStatement(query);
                ps.setString(1, mensajes.getMensaje());
                ps.setString(2, mensajes.getAutor_Mensaje());
                ps.executeUpdate();
                System.out.println("Mensaje creado");
            }catch(SQLException ex){
                System.out.println(ex);
            }
        }catch(SQLException e){
            System.out.println(e);
        }

    }

    // Cree un metodo de tipo arraylist para manejar los mensajes de forma dinamica para en listarlos para ser pasados a mi capa MensajeService
    public static ArrayList<Mensajes> lerrMensajesDB(){
        //Conexion db_connet = new Conexion();

        ArrayList<Mensajes> mensajes = new ArrayList<Mensajes>();

        try(Connection connection = ConexionSigleton.getConnection()){

            String query ="SELECT * FROM mensajes_app.mensajes";
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()){
                Mensajes mensaje = new Mensajes();
                mensaje.setId_mensaje(rs.getInt("id_mensaje"));
                mensaje.setMensaje(rs.getString("mensaje"));
                mensaje.setAutor_Mensaje(rs.getString("autor"));
                mensaje.setFecha_Mensaje(rs.getString("fecha_mensaje"));
                mensajes.add(mensaje);
            }
        }catch(SQLException e){
            System.out.println("No se pudieron recuperar los mensajes");
            System.out.println(e);
        }
        return mensajes;
    }

    public static void borrarMensajeDB(int id_mensajes){

    }

    public static void actualizarMensajesDB(Mensajes mensajes){

    }
}
