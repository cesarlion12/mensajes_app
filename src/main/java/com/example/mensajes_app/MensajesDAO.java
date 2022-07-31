package com.example.mensajes_app;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MensajesDAO {

    // Intancia unica de conexión a la base de datos
    private static Connection connection = ConexionSigleton.getConnection();
    
    public static void crearMensajeDB(Mensajes mensajes) throws SQLException {

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
            }finally {
                connection.close();
            }

    }

    // Cree un metodo de tipo arraylist para manejar los mensajes de forma dinamica para en listarlos para ser pasados a mi capa MensajeService
    public static ArrayList<Mensajes> lerrMensajesDB() throws SQLException {

        ArrayList<Mensajes> mensajes = new ArrayList<Mensajes>();

            ResultSet rs = null;
            PreparedStatement ps = null;
            try {
                String query = "SELECT * FROM mensajes_app.mensajes";
                ps = connection.prepareStatement(query);
                rs = ps.executeQuery();

                while (rs.next()) {
                    Mensajes mensaje = new Mensajes();
                    mensaje.setId_mensaje(rs.getInt("id_mensaje"));
                    mensaje.setMensaje(rs.getString("mensaje"));
                    mensaje.setAutor_Mensaje(rs.getString("autor"));
                    mensaje.setFecha_Mensaje(rs.getString("fecha_mensaje"));
                    mensajes.add(mensaje);
                }
            } catch (SQLException e) {
                System.out.println("No se pudieron recuperar los mensajes");
                e.printStackTrace();
            }finally {
                connection.close();
            }
        return mensajes;
    }

    public static void borrarMensajeDB(int id_mensaje) throws SQLException {

            PreparedStatement ps = null;
            try {
                String query = "DELETE FROM mensajes_app.mensajes WHERE id_mensaje = ?";
                ps = connection.prepareStatement(query);
                ps.setInt(1, id_mensaje);
                ps.executeUpdate();
                System.out.println("El mensaje ha sido eliminado");
            } catch (SQLException e) {
                System.out.println(e);
                System.out.println("No se pudo eliminar el mensaje");
            }finally {
                connection.close();
            }
    }

    public static void actualizarMensajesDB(Mensajes mensajes) throws SQLException {

            PreparedStatement ps = null;
            try{
                String query = "UPDATE mensajes SET mensaje = ? WHERE id_mensaje = ?";
                ps = connection.prepareStatement(query);
                ps.setString(1, mensajes.getMensaje());
                ps.setInt(2, mensajes.getId_mensaje());
                ps.executeUpdate();
                System.out.println("El mensaje se actualizo correctamente");
            }catch(SQLException ex){
                System.out.println(ex);
                System.out.println("No se pudo actualizar el mensaje");
            }finally {
                connection.close();
            }
    }

}
