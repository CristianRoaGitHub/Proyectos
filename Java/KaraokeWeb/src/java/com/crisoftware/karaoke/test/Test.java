/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crisoftware.karaoke.test;

import com.crisoftware.karaoke.conexion.Conexion;

/**
 *
 * @author CROA
 */
public class Test {

    static public void main(String[] args) {
        
        Conexion con = new Conexion();
        con.conectar();

    }
}
