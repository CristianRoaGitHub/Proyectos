/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crisoft.sistemacomercializadora.dao;

import com.crisoft.sistemacomercializadora.conexion.Conexion;
import com.crisoft.sistemacomercializadora.modelos.Categoria;
import com.mysql.jdbc.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ACER
 */
public class CategoriaJdbcDao implements ICategoriaDao {

    
    
    
    @Override
    public List<Categoria> listAll() {
        Categoria cat;
        List<Categoria> listaCategorias = new ArrayList<>();
        try {
            Conexion con = new Conexion();
            con.conectar();
            String sql = "select * from categorias";
            PreparedStatement ps = (PreparedStatement) con.getConeConnection().prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            
            
            while (rs.next()) {
                cat = new Categoria();
                cat.setCategoriaId(rs.getInt("categoriaid"));
                cat.setNombreCat(rs.getString("nombrecat"));
                listaCategorias.add(cat);
            }
            
            con.desconectar();
        } catch (SQLException e) {
            System.err.println("Error en: \n Clase= 'CategoriaJdbcDao', Metodo = 'listAll()'" + e.getMessage());
        }
        
        return listaCategorias;
        
                
    }

}
