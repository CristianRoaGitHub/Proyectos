package com.crisoft.sistemacomercializadora.conexion;

import java.sql.Connection;
import java.sql.DriverManager;


public class Conexion extends Configuracion{
    public static Connection con = null;
    public void conectar(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection(url,usuario,contraseña);
            System.out.println("CONECTADO :)");
        } catch (Exception e) {
            
            System.out.println("Error en clase Conexion, conectar(); " + e);
        }
    }
    
    
    public Connection getConeConnection(){
        return this.con;
    }
            
    public void desconectar(){
        try {
            con.close();
            System.out.println("DESCONECTADO :)");
        } catch (Exception e) {
            System.out.println("Error en clase Conexion, desconectar(); " + e);
        }
        
    }
    
}
