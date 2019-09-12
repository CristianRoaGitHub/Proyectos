package com.crisoft.restaurante.dao;

import com.crisoft.restaurante.conexion.Conexion;
import com.crisoft.restaurante.vo.Venta;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author CROA
 */
public class VentaDao extends Conexion{
    
    
    public boolean registrarVentaBD(ArrayList<Venta> lsVentaVo) {
        try {
            conectar();
            String insertar = "INSERT INTO venta (ven_det_cod_detalle, ven_cantidad_total, ven_valor_total, ven_fecha, ven_observacion)"
                    + "VALUES (?,?,?,?)";
            sentencia = con.prepareStatement(insertar);
            
            int rta=0;
            for (int i = 0; i < lsVentaVo.size(); i++) {
                //Arreglar por que se modifico la base de datos
                //sentencia.setInt(1, lsVentaVo.get(i).getVenDetCodDetalle());
                sentencia.setInt(2, lsVentaVo.get(i).getVenCantidadTotal());
                sentencia.setDouble(3, lsVentaVo.get(i).getVenValorTotal());
                Date facFecha = lsVentaVo.get(i).getVenFecha();
                long milisegundo = facFecha.getTime();
                java.sql.Timestamp sqlTimestamp = new java.sql.Timestamp(milisegundo);
                sentencia.setTimestamp(4, sqlTimestamp);
                sentencia.setString(5, lsVentaVo.get(i).getVenObservacion());
                rta = sentencia.executeUpdate();
                sentencia.close();
            }
            desconectar();
            if (rta == 1) {
                System.out.println("Se registro satisfactoriamente la factuta");
                return true;
            } else {
                desconectar();
                System.err.println("No registro la factura ");
                return false;
            }
        } catch (SQLException e) {
            desconectar();
            System.err.println("Error en Clase Venta, Metodo registrarFacturaBD" + e);
        }
        return true;

    }
}
