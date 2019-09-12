/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crisoft.restaurante.dao;

import com.crisoft.restaurante.conexion.Conexion;
import static com.crisoft.restaurante.conexion.Conexion.con;
import static com.crisoft.restaurante.conexion.Conexion.resultado;
import static com.crisoft.restaurante.conexion.Conexion.sentencia;
import com.crisoft.restaurante.vo.Persona;
import com.crisoft.restaurante.vo.PersonaUsuario;
import com.crisoft.restaurante.vo.Usuario;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author croa
 */
public class PersonaUsuarioDao extends Conexion {

    public List<PersonaUsuario> listaPersonasUsuariosBD(String cedula) {
        List<PersonaUsuario> lista = new ArrayList<PersonaUsuario>();
        String consultar = "";
        try {
            conectar();
            if (cedula.equals("")) {
                consultar = "SELECT p.*, u.* FROM persona p INNER JOIN usuario u ON p.per_id_cedula=u.usu_per_id_cedula";
            } else {
                consultar = "SELECT p.*, u.* FROM persona p INNER JOIN usuario u ON p.per_id_cedula=u.usu_per_id_cedula WHERE p.per_id_cedula LIKE '" + cedula + "'";
            }
            sentencia = con.prepareStatement(consultar);
            resultado = sentencia.executeQuery();
            while (resultado.next()) {
                Persona per = new Persona();
                Usuario usu = new Usuario();
                PersonaUsuario perUsu = new PersonaUsuario();
                per.setPerIdAuto(resultado.getInt("per_id_auto"));
                per.setPerIdCedula(resultado.getString("per_id_cedula"));
                per.setPerNombre(resultado.getString("per_nombre"));
                per.setPerApellido(resultado.getString("per_apellido"));
                per.setPerGenero(resultado.getString("per_genero"));
                per.setPerFechaNac(resultado.getDate("per_fecha_nac"));
                per.setPerCorreo(resultado.getString("per_correo"));
                per.setPerTelefono(resultado.getInt("per_telefono"));

                usu.setUsuIdAuto(resultado.getInt("usu_id_auto"));
                per.setPerIdCedula(String.valueOf(resultado.getString("usu_per_id_cedula")));
                usu.setUsuPerIdCedula(per);
                usu.setUsuNombreUsu(resultado.getString("usu_nombre_usu"));
                usu.setUsuClave(resultado.getString("usu_clave"));
                usu.setUsuEstado(Integer.parseInt(resultado.getString("usu_estado")));
                usu.setUsuTipo(resultado.getString("usu_tipo"));
                
                if (per.getPerIdCedula().equals(usu.getUsuPerIdCedula().getPerIdCedula())) {
                    
                    perUsu.setPersona(per);
                    perUsu.setUsuario(usu);
                    lista.add(perUsu);
                }

            }
            desconectar();
        } catch (Exception e) {
            System.out.println("Error en PersonaUsuarioDao, Metodo listaPersonasUsuariosBD " + e);
            return null;
        }
        return lista;
    }
}
