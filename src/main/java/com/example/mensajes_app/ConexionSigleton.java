package com.example.mensajes_app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionSigleton {

    //Variable donde vamos a guardar el estado de la conexión a la BD
    private static Connection connection = null;

    private ConexionSigleton(){
        // Variables para podernos conectar a la base de datos
        String url = "jdbc:mysql://localhost:3306/mensajes_app";
        String usuario = "root";
        String password = "123456";
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                connection = DriverManager.getConnection(url,usuario,password);
            }catch(ClassNotFoundException | SQLException e){
                System.out.println(e);
            }
    }

    // Metodo para cerrar la conexion
   /* public static Connection closeConnectBD() throws SQLException {
        try{
            if(connection != null){
                connection.close();
            }
        }catch(Exception e){
            connection.close();
        }finally{
            connection.close();
        }
        return connection;
    }*/

    //Patron siglenton
    public static Connection getConnection(){
        if(connection == null){
            new ConexionSigleton();
        }
        return connection;
    }

}
