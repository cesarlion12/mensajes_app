package com.example.mensajes_app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionSigleton {
    // Propiedades
    private static Connection connection = null;
    private String url;
    private String usuario;
    private String password;

    //constructor
    private ConexionSigleton(){
        String url = "jdbc:mysql://localhost:3306/mensajes_app";
        String usuario = "root";
        String password = "123456";

        try {
            connection = DriverManager.getConnection(url,usuario,password);
        }catch (SQLException e){
            System.out.println("Error de Conexión " + e);
        }
    }

    //Metodo de conexión
    public static Connection getConnection(){
        if(connection == null){
            new ConexionSigleton();
        }
        return connection;
    }

}
