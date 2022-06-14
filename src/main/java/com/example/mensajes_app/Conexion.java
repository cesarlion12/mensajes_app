package com.example.mensajes_app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    public Connection get_connection(){
        Connection conection = null;
        try {
            conection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mensajes_app","root","123456");
            if (conection != null){
                System.out.println("Conexión Exitosa");
            }
        }catch(SQLException e){
            System.out.println("Error de Conexión " + e);
        }
        return conection;
    }
}
