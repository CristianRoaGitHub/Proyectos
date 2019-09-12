/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crisoftware.karaoke.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author CROA
 */
public class Conexion extends Configuracion{
    /*https://cupi2.virtual.uniandes.edu.co/ejercicios-del-semestre-apo2/ejercicio-n9*/
    
    
    public static ResultSet resultado;
    public static PreparedStatement sentencia;
    public static Connection con=null;
    
    public boolean conectar(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection(url,usuario,contraseña);
            System.out.println("Conectado"); 
            return true;
       } catch (Exception e) {
            System.out.println("Error en la clase Conexion " + e.getMessage());
           return false;
                   
        }
    }
    
    
    public boolean desconectar(){
        try {
            con.close();
            return true;
        } catch (Exception e) {
            System.out.println("Error en la clase Conexion, desconectar " + e.getMessage());
            return false;
        }
    }
}
