/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crisoftware.karaoke.dao;

import com.crisoftware.karaoke.conexion.Conexion;
import com.crisoftware.karaoke.vo.CategoriaVo;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author CROA
 */
public class CategoriaDao extends Conexion{
    
    public boolean registrar(CategoriaVo catVo){
        boolean respuesta=true;
        try {
            conectar();
            String insertar="insert into categoria (nombrecat,descripcion)"
                    + "values(?,?)";
            sentencia=con.prepareStatement(insertar);
            sentencia.setString(1, catVo.getNombreCategoria());
            sentencia.setString(2, catVo.getDescripcion());
            int rta = sentencia.executeUpdate();
            if (rta != 0) {
                System.out.println("Se registro la categoria");
                respuesta=true;
            }
            desconectar();
            return respuesta;
        } catch (Exception e) {
            System.out.println("Error en la clase CategoriaDao " +e.getMessage());
            return respuesta;
        }
    }
    
    
    public List<CategoriaVo> consultarCategorias(int id) throws SQLException{
        List<CategoriaVo> listaCategoria = new ArrayList<>();
        try {
            
            String consulta="select * from categoria";
            sentencia = con.prepareStatement(consulta);
            resultado = sentencia.executeQuery();
            while (resultado.next()) {                
                CategoriaVo catVo = new CategoriaVo();
                catVo.setId(resultado.getInt("id"));
                catVo.setNombreCategoria(resultado.getString("nombrecate"));
                catVo.setDescripcion(resultado.getString("descrip"));
                listaCategoria.add(catVo);
            }
        return  listaCategoria;            
        } catch (Exception e) {
            System.out.println("Error en la clase categoria dao " + e.getMessage());
            return  null;
        }
    }
}
