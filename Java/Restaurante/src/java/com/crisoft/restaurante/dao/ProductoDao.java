
package com.crisoft.restaurante.dao;

import com.crisoft.restaurante.conexion.Conexion;
import com.crisoft.restaurante.vo.CategoriaProducto;
import com.crisoft.restaurante.vo.Producto;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author croa
 */
public class ProductoDao extends Conexion{
    
    
    public List<Producto> listaProductoBD(int valor, String valorConsulta){
        
        List<Producto> lista = new ArrayList<Producto>();
        String consultar="";
        try {
            conectar();
            
            if (valor <=0) {
             consultar = "SELECT * FROM producto";  
            }else if(valor >0 && valorConsulta.equals("productoPorCategoria")){
             consultar = "SELECT * FROM producto WHERE producto.pro_id_cat="+valor+"";     
            }else if(valor >0 && valorConsulta.equals("producto")){
             consultar = "SELECT * FROM producto WHERE producto.pro_id_auto="+valor+"";     
            }
            sentencia = con.prepareStatement(consultar);
            resultado = sentencia.executeQuery();
            CategoriaProducto cat =new CategoriaProducto();
            
            while (resultado.next()) {
                Producto pro =new Producto();
                pro.setProIdAuto(resultado.getInt("pro_id_auto"));
                cat.setCatIdAuto(resultado.getInt("pro_id_cat"));
                pro.setProIdCat(cat);
                pro.setProNombre(resultado.getString("pro_nombre"));
                pro.setProPrecioProducto(resultado.getDouble("pro_precio_producto"));
                pro.setProObservacion(resultado.getString("pro_observacion"));
                lista.add(pro);
            }
            desconectar();
        } catch (SQLException e) {
            System.out.println("Error en ProductoDao, Metodo listaProductoBD " + e);
            return null;
        }
        return lista;
    }

    public boolean registrarProducoBD(Producto proVo, int codCat) {
        try {
            conectar();
            String insertar = "INSERT INTO producto (pro_id_cat, pro_nombre, pro_precio_producto, pro_observacion)"
                    + "VALUES (?,?,?,?)";
            sentencia = con.prepareStatement(insertar);
            sentencia.setInt(1, codCat);
            sentencia.setString(2, proVo.getProNombre());
            sentencia.setDouble(3, proVo.getProPrecioProducto());
            sentencia.setString(4, proVo.getProObservacion());
            int rta = sentencia.executeUpdate();
            desconectar();
            if (rta == 1) {
                System.out.println("Se registro satisfactoriamente el producto");
                return true;
            } else {
                System.err.println("No registro el producto");
                desconectar();
                return false;
            }
        } catch (SQLException e) {
            desconectar();
            System.err.println("Error en Clase ProductoDao, Metodo registrarProducoBD " + e);
        }
        return true;
    }
    
    public boolean actualizarProductoBD(Producto proVo) {
        try {
            conectar();
            String actualizar = "UPDATE producto SET pro_nombre = ?, pro_precio_producto = ?, pro_observacion = ? WHERE cat_id_auto ="+proVo.getProIdAuto()+" ";
            sentencia = con.prepareStatement(actualizar);
            sentencia.setString(1, proVo.getProNombre());
            sentencia.setDouble(2, proVo.getProPrecioProducto());
            sentencia.setString(3, proVo.getProObservacion());
            
            int rta = sentencia.executeUpdate();
            desconectar();
            if (rta == 1) {
                System.out.println("Se actualizo el producto");
                return true;
            } else {
                System.err.println("No se actualizo el producto");
                desconectar();
                return false;
            }
        } catch (SQLException e) {
            desconectar();
            System.err.println("Error en Clase ProductoDao, Metodo actualizarProductoBD " + e);
        }
        return true;
    }
    
    
    public boolean eliminarProductoBD(Producto proVo) {
        try {
            conectar();
            String actualizar = "DELETE FROM producto WHERE pro_id_auto ="+proVo.getProIdAuto()+" ";
            sentencia = con.prepareStatement(actualizar);
            int rta = sentencia.executeUpdate();
            desconectar();
            if (rta == 1) {
                System.out.println("Se elimino el producto");
                return true;
            } else {
                System.err.println("No se elimino el producto");
                desconectar();
                return false;
            }
        } catch (SQLException e) {
            desconectar();
            System.err.println("Error en Clase ProductoDao, Metodo eliminarProductoBD " + e);
        }
        return true;
    }
        
}
