package com.crisoft.restaurante.dao;

import com.crisoft.restaurante.conexion.Conexion;
import com.crisoft.restaurante.vo.Persona;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author croa
 */
public class PersonaDao extends Conexion {

    public boolean registrarPersonaBD(Persona perVo) {
        try {
            conectar();
            String insertar = "INSERT INTO persona (per_id_cedula, per_nombre, per_apellido, per_genero, per_fecha_nac, per_correo, per_telefono)"
                    + "VALUES (?,?,?,?,?,?,?)";
            sentencia = con.prepareStatement(insertar);
            sentencia.setString(1, perVo.getPerIdCedula());
            sentencia.setString(2, perVo.getPerNombre());
            sentencia.setString(3, perVo.getPerApellido());
            sentencia.setString(4, perVo.getPerGenero());
            java.util.Date perFechaSql = new Date(perVo.getPerFechaNac().getTime());
            sentencia.setDate(5, (Date) perFechaSql);
            sentencia.setString(6, perVo.getPerCorreo());
            sentencia.setInt(7, perVo.getPerTelefono());

            int rta = sentencia.executeUpdate();
            desconectar();
            if (rta == 1) {
                System.out.println("Se registro satisfactoriamente la persona");
                return true;
            } else {
                System.err.println("No registro ");
                desconectar();
                return false;
            }
        } catch (SQLException e) {
            desconectar();
            System.err.println("Error en Clase PersonaDao, Metodo registrarPersonaBD " + e);
        }
        return true;
    }

    public List<Persona> listaPersonaBD(String cedula) {
        List<Persona> lista = new ArrayList<Persona>();
        String consultar = "";
        try {
            conectar();
            if (cedula.equals("")) {
                consultar = "SELECT * FROM persona;";
            } else {
                consultar = "SELECT * FROM persona WHERE persona.per_id_cedula like '" + cedula + "'";
            }
            sentencia = con.prepareStatement(consultar);
            resultado = sentencia.executeQuery();
            while (resultado.next()) {
                Persona per = new Persona();
                per.setPerIdAuto(resultado.getInt("per_id_auto"));
                per.setPerIdCedula(resultado.getString("per_id_cedula"));
                per.setPerNombre(resultado.getString("per_nombre"));
                per.setPerApellido(resultado.getString("per_apellido"));
                per.setPerGenero(resultado.getString("per_genero"));
                per.setPerFechaNac(resultado.getDate("per_fecha_nac"));
                per.setPerCorreo(resultado.getString("per_correo"));
                per.setPerTelefono(resultado.getInt("per_telefono"));
                lista.add(per);
            }
            desconectar();
        } catch (Exception e) {
            System.out.println("Error en PersonaDao, Metodo listaPersonaBD " + e);
            return null;
        }
        return lista;
    }
    
    public boolean actualizarPersonaBD(Persona perVo, String cedulaPersona) {
        try {
            conectar();
            String actualizar = "UPDATE persona SET per_nombre = ?, per_apellido = ?, per_genero = ?, per_fecha_nac = ?, per_correo = ?, per_telefono = ? WHERE per_id_cedula ='"+cedulaPersona+"'";
            sentencia = con.prepareStatement(actualizar);
            sentencia.setString(1, perVo.getPerNombre());
            sentencia.setString(2, perVo.getPerApellido());
            sentencia.setString(3, perVo.getPerGenero());
            java.util.Date perFechaSql = new Date(perVo.getPerFechaNac().getTime());
            sentencia.setDate(4, (Date) perFechaSql);
            sentencia.setString(5, perVo.getPerCorreo());
            sentencia.setInt(6, perVo.getPerTelefono());
             int rta = sentencia.executeUpdate();
            desconectar();
            if (rta == 1) {
                System.out.println("Se actualizo perfectamete");
                return true;
            } else {
                System.err.println("No se actualizo la persona");
                desconectar();
                return false;
            }
        } catch (SQLException e) {
            desconectar();
            System.err.println("Error en Clase PersonaDao, Metodo actualizarPersonaBD " + e);
        }
        return true;
    }

}
