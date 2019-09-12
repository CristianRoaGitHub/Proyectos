
package com.crisoft.aplicacionjsf.beans;


import com.crisoft.aplicacionjsf.conexion.Conexion;
import static com.crisoft.aplicacionjsf.conexion.Conexion.con;
import static com.crisoft.aplicacionjsf.conexion.Conexion.sentencia;
import com.crisoft.aplicacionjsf.modelos.Telefono;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author CROA
 */
@ManagedBean
@RequestScoped
public class TelefonoBean extends Conexion{

    private List<Telefono> listaTelefonos = new ArrayList<>();
    private Telefono telefono = new Telefono();

    public List<Telefono> getListaTelefonos() {
        return listaTelefonos;
    }

    public void setListaTelefonos(List<Telefono> listaTelefonos) {
        this.listaTelefonos = listaTelefonos;
    }

    public Telefono getTelefono() {
        return telefono;
    }

    public void setTelefono(Telefono telefono) {
        this.telefono = telefono;
    }
    
    
    @PostConstruct
    public void init(){
        listaTelefonos=obtenerTelefonosBD();
    }
    
    public TelefonoBean() {
        
    }
    
    
    public void registrarTelefono(){
        telefono.setCodigopersona("1019");
        registrarTelefonoBD(telefono);
    }
    
    public void registrarTelefonoBD(Telefono tel){
         try {
            conectar();
            String insertar = "INSERT INTO telefono (codigopersona, numerotel)"
                    + "VALUES (?,?)";
            sentencia = con.prepareStatement(insertar);
            sentencia.setString(1, tel.getCodigopersona().toString());
            sentencia.setString(2, tel.getNumerotel());
            int rta = sentencia.executeUpdate();
            desconectar();
            if (rta == 1) {
                System.out.println("Se registro satisfactoriamente el Telefono");
                
            } else {
                System.err.println("No registro ");
                desconectar();
            }
        } catch (SQLException e) {
            desconectar();
            System.err.println("Error en Clase TelefonoBean, Metodo registrarTelefonoBD " + e);
        }
    }
    
    public List<Telefono> obtenerTelefonosBD(){
        ArrayList<Telefono> telfonito = new ArrayList<>();
        try {
            
            conectar();
            String consultar = "SELECT * FROM telefono";
            sentencia = con.prepareStatement(consultar);
            resultado = sentencia.executeQuery();
            while (resultado.next()) {
                Telefono tele = new Telefono();                
                tele.setCodigopersona(resultado.getString("codigopersona"));
                tele.setNumerotel(resultado.getString("numerotel"));
                
                telfonito.add(tele);
            }
            desconectar();
        } catch (SQLException e) {
            System.err.println("Error en PersonaBean, obtenerTelefonosBD()" +e);
        }
        return telfonito;
    }
    
}
