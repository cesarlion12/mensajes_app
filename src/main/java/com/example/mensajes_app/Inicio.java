package com.example.mensajes_app;

import org.omg.CORBA.INTERNAL;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class Inicio {
    public static void main(String[] args) throws SQLException {

        Scanner sc = new Scanner(System.in);

        int opc = 0;

        do{
            System.out.println("-----------------");
            System.out.println("Aplicación de mensajes");
            System.out.println("1. crear mensajes");
            System.out.println("2. listar mensajes");
            System.out.println("3. eliminar mensajes");
            System.out.println("4. editar mensaje");
            System.out.println("5. salir");

            opc = sc.nextInt();

            switch(opc){
                case 1:
                    MensajesService.crearMensaje();
                    break;
                case 2:
                    MensajesService.listarMensaje();
                    break;
                case 3:
                    MensajesService.borrarMensaje();
                    break;
                case 4:
                    MensajesService.editarMensaje();
                    break;
                default:
                    break;
            }

        }while(opc != 5);


    }
}
