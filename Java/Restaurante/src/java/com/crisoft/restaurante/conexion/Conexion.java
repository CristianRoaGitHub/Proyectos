package com.crisoft.restaurante.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class Conexion extends Configuracion{
    public static  ResultSet resultado;
    public static PreparedStatement sentencia;
    public static Connection con = null;
    
    public void conectar(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection(url,usuario,contraseña);
            System.out.println("CONECTADO :) ");
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
            System.out.println("DESCONECTADO LA BD");
        } catch (Exception e) {
            System.out.println("Error en clase Conexion, desconectar(); " + e);
        }
        
    }
    
}
