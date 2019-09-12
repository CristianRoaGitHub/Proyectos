package com.crisoft.restaurante.dao;

import com.crisoft.restaurante.conexion.Conexion;
import static com.crisoft.restaurante.conexion.Conexion.con;
import static com.crisoft.restaurante.conexion.Conexion.resultado;
import static com.crisoft.restaurante.conexion.Conexion.sentencia;
import com.crisoft.restaurante.vo.CategoriaProducto;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author croa
 */
public class CategoriaDao extends Conexion {

    public boolean registrarCategoriaBD(CategoriaProducto catVo) {
        try {
            conectar();
            String insertar = "INSERT INTO categoria_producto (cat_tipo, cat_descripcion)"
                    + "VALUES (?,?)";
            sentencia = con.prepareStatement(insertar);
            sentencia.setString(1, catVo.getCatTipo());
            sentencia.setString(2, catVo.getCatDescripcion());
            
            int rta = sentencia.executeUpdate();
            desconectar();
            if (rta == 1) {
                System.out.println("Se registro satisfactoriamente la categoria");
                return true;
            } else {
                System.err.println("No registro la categoria");
                desconectar();
                return false;
            }
        } catch (SQLException e) {
            desconectar();
            System.err.println("Error en Clase CategoriaDao, Metodo registrarCategoriaBD " + e);
        }
        return true;
    }
    
    public boolean actualizarCategoriaBD(CategoriaProducto catVo) {
        try {
            conectar();
            String actualizar = "UPDATE categoria_producto SET cat_tipo = ?, cat_descripcion = ? WHERE cat_id_auto ="+catVo.getCatIdAuto()+" ";
            sentencia = con.prepareStatement(actualizar);
            sentencia.setString(1, catVo.getCatTipo());
            sentencia.setString(2, catVo.getCatDescripcion());
            int rta = sentencia.executeUpdate();
            desconectar();
            if (rta == 1) {
                System.out.println("Se actualizo la categoria");
                return true;
            } else {
                System.err.println("No se actualizo la categoria");
                desconectar();
                return false;
            }
        } catch (SQLException e) {
            desconectar();
            System.err.println("Error en Clase CategoriaDao, Metodo actualizarCategoriaBD " + e);
        }
        return true;
    }
    
    
    public boolean eliminarCategoriaBD(CategoriaProducto catVo) {
        try {
            conectar();
            String actualizar = "DELETE FROM categoria_producto WHERE cat_id_auto ="+catVo.getCatIdAuto()+" ";
            sentencia = con.prepareStatement(actualizar);
            int rta = sentencia.executeUpdate();
            desconectar();
            if (rta == 1) {
                System.out.println("Se elimino la categoria");
                return true;
            } else {
                System.err.println("No se elimino la categoria");
                desconectar();
                return false;
            }
        } catch (SQLException e) {
            desconectar();
            System.err.println("Error en Clase CategoriaDao, Metodo eliminarCategoriaBD " + e);
        }
        return true;
    }
    
    
    

    public List<CategoriaProducto> listaCategoriasBD(int idCategoria) {

        List<CategoriaProducto> lista = new ArrayList<>();
        try {
            conectar();
            String consultar="";
            if (idCategoria == 0) {
                consultar = "SELECT * FROM categoria_producto";
            } else if (idCategoria != 0) {
                consultar = "SELECT * FROM categoria_producto WHERE cat_id_auto = "+idCategoria +"";
            }
            sentencia = con.prepareStatement(consultar);
            resultado = sentencia.executeQuery();
            while (resultado.next()) {
                CategoriaProducto cat = new CategoriaProducto();
                cat.setCatIdAuto(resultado.getInt("cat_id_auto"));
                cat.setCatTipo(resultado.getString("cat_tipo"));
                cat.setCatDescripcion(resultado.getString("cat_descripcion"));
                lista.add(cat);
            }
            desconectar();
        } catch (SQLException e) {
            System.out.println("Error en CategoriaDao, Metodo listaCategoriasBD " + e);
            return null;
        }
        return lista;
    }
}
