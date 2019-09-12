package com.crisoft.restaurante.dao;

import com.crisoft.restaurante.conexion.Conexion;
import static com.crisoft.restaurante.conexion.Conexion.con;
import static com.crisoft.restaurante.conexion.Conexion.resultado;
import static com.crisoft.restaurante.conexion.Conexion.sentencia;
import com.crisoft.restaurante.vo.Persona;
import com.crisoft.restaurante.vo.Usuario;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author croa
 */
public class UsuarioDao extends Conexion {

    public boolean registrarUsuarioBD(Usuario usuVo) {
        try {
            
            conectar();
            String insertar = "INSERT INTO usuario (usu_per_id_cedula, usu_nombre_usu, usu_clave, usu_estado, usu_tipo)"
                    + "VALUES (?,?,?,?,?)";
            sentencia = con.prepareStatement(insertar);
            Persona usu = usuVo.getUsuPerIdCedula();
            sentencia.setString(1, usu.getPerIdCedula());
            sentencia.setString(2, usuVo.getUsuNombreUsu());
            sentencia.setString(3, usuVo.getUsuClave());
            sentencia.setInt(4, usuVo.getUsuEstado());
            sentencia.setString(5, usuVo.getUsuTipo());
            int rta = sentencia.executeUpdate();
            desconectar();
            if (rta == 1) {
                System.out.println("Se registro satisfactoriamente el usuario");
                return true;
            } else {
                System.err.println("No registro el Usuario");
                desconectar();
                return false;
            }
        } catch (SQLException e) {
            desconectar();
            System.err.println("Error en Clase UsuarioDao, Metodo registrarUsuarioBD " + e);
        }
        return true;
    }

    public List<Usuario> listaUsuarioBD(String cedula) {
        List<Usuario> lista = new ArrayList<>();
        String consultar;
        consultar = "";
        try {
            conectar();
            if (cedula.equals("")) {
                consultar = "SELECT * FROM usuario";
            } else {
                consultar = "SELECT * FROM usuario  WHERE usu_per_id_cedula  like '" + cedula + "'";
            }
            sentencia = con.prepareStatement(consultar);
            resultado = sentencia.executeQuery();
            Persona per = new Persona();
            while (resultado.next()) {
                Usuario usu = new Usuario();
                usu.setUsuIdAuto(resultado.getInt("usu_id_auto"));
                per.setPerIdCedula(String.valueOf(resultado.getString("usu_per_id_cedula")));
                usu.setUsuPerIdCedula(per);
                usu.setUsuNombreUsu(resultado.getString("usu_nombre_usu"));
                usu.setUsuClave(resultado.getString("usu_clave"));
                usu.setUsuEstado(Integer.parseInt(resultado.getString("usu_estado")));
                usu.setUsuTipo(resultado.getString("usu_tipo"));
                lista.add(usu);
            }
            desconectar();
        } catch (Exception e) {
            System.out.println("Error en UsuarioDao, Metodo listaUsuarioBD " + e);
            return null;
        }
        return lista;
    }

    public boolean actualizarUsuarioBD(Usuario usuVo, String cedulaPersona) {
        try {
            conectar();
            String actualizar = "UPDATE persona SET usu_clave = ?, usu_tipo = ? WHERE usu_per_id_cedula = '"+cedulaPersona+"' and usu_estado = 1";
            sentencia = con.prepareStatement(actualizar);
            sentencia.setString(1, usuVo.getUsuClave());
            sentencia.setString(2, usuVo.getUsuClave());
             int rta = sentencia.executeUpdate();
            desconectar();
            if (rta == 1) {
                System.out.println("Se actualizo la contraseña");
                return true;
            } else {
                System.err.println("No se actualizo la contraseña");
                desconectar();
                return false;
            }
        } catch (SQLException e) {
            desconectar();
            System.err.println("Error en Clase PersonaDao, Metodo actualizarUsuarioBD " + e);
        }
        return true;
    }
    
    
    public boolean iniciarSessionBD(Usuario us) throws SQLException {

        
        try {
            conectar();
            String consulta = "SELECT * FROM usuario WHERE usu_nombre_usu=? AND usu_clave=? AND usu_estado=1";
            sentencia = con.prepareStatement(consulta);
            sentencia.setString(1, us.getUsuNombreUsu());
            sentencia.setString(2, us.getUsuClave());
            resultado = sentencia.executeQuery();
            Persona per = new Persona();
            if (resultado.first()) {
                Usuario usu = new Usuario();
                usu.setUsuIdAuto(Integer.parseInt(resultado.getString("usu_id_auto")));
                per.setPerIdCedula(String.valueOf(resultado.getString("usu_per_id_cedula")));
                usu.setUsuPerIdCedula(per);
                usu.setUsuNombreUsu(String.valueOf(resultado.getString("usu_nombre_usu")));
                usu.setUsuClave(String.valueOf(resultado.getString("usu_clave")));
                usu.setUsuEstado(Integer.parseInt(resultado.getString("usu_estado")));
                usu.setUsuTipo(resultado.getString("usu_tipo"));
                desconectar();
                return true;
            } else {
                desconectar();
                return false;
            }
        } catch (SQLException e) {
            desconectar();
            System.err.println("Error en Clase LoginBean, Metodo iniciarSessionBD " + e);
        }
        return true;
    }

}
