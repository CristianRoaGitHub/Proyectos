package com.crisoft.restaurante.dao;

import com.crisoft.restaurante.conexion.Conexion;
import com.crisoft.restaurante.vo.DetalleVenta;
import com.crisoft.restaurante.vo.Persona;
import com.crisoft.restaurante.vo.Producto;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author CROA
 */
public class DetalleVentaDao extends Conexion {

//    public boolean crearDetalleVentaBD(DetalleVenta detVentaVo) {
//        try {
//            conectar();
//            String insertar = "INSERT INTO detalle_venta (det_cod_detalle, det_per_id_cedula, det_pro_id_auto, det_cantidad_producto)"
//                    + "VALUES (?,?,?,?)";
//            sentencia = con.prepareStatement(insertar);
//            sentencia.setInt(1, detVentaVo.getDetCodDetalle());
//            Persona per = detVentaVo.getDetPerIdCedula();
//            sentencia.setString(2, per.getPerIdCedula());
//            Producto idProducto = detVentaVo.getDetProIdAuto();
//            sentencia.setInt(3, idProducto.getProIdAuto());
//            sentencia.setInt(4, detVentaVo.getDetCantidadProducto());
//            int rta = sentencia.executeUpdate();
//            sentencia.close();
//            desconectar();
//            if (rta==1) {
//                System.out.println("Se registro el detalle de la venta");
//                return true;
//            }else{
//                System.out.println("No se registro el detalle de la venta");
//                return false;
//            }
//        } catch (SQLException e) {
//            System.err.println("Error la clase DetalleVentaDao, Metodo crearDetalleVentaBD " +e);
//            desconectar();
//            return false;
//        }
//    }
//    
//    public  List<DetalleVenta> listaDetalleVenta (){
//        List<DetalleVenta> listaDet = new ArrayList<DetalleVenta>();
//             try {
//            conectar();
//            String consultar = "SELECT * FROM detalle_venta";
//            sentencia = con.prepareStatement(consultar);
//            resultado = sentencia.executeQuery();
//            while (resultado.next()) {
//                DetalleVenta detVen =new DetalleVenta();
//                detVen.setDetIdAuto(resultado.getInt("det_id_auto"));
//                detVen.setDetCodDetalle(resultado.getInt("det_cod_detalle"));
//                Persona per = new Persona();
//                per.setPerIdCedula(resultado.getString("det_per_id_cedula"));
//                detVen.setDetPerIdCedula(per);
//                Producto pro = new Producto();
//                pro.setProIdAuto(resultado.getInt("det_pro_id_auto"));
//                detVen.setDetProIdAuto(pro);
//                detVen.setDetCantidadProducto(resultado.getInt("det_cantidad_producto"));
//                listaDet.add(detVen);
//            }
//            desconectar();
//        } catch (Exception e) {
//            System.out.println("Error en Clase DetalleVentaDao, Metodo listaDetalleVenta " + e);
//            return null;
//        }
//            return listaDet;
//    }

}
