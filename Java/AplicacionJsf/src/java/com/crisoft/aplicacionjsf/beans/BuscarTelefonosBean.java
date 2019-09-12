/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crisoft.aplicacionjsf.beans;

import com.crisoft.aplicacionjsf.conexion.Conexion;
import static com.crisoft.aplicacionjsf.conexion.Conexion.con;
import static com.crisoft.aplicacionjsf.conexion.Conexion.resultado;
import static com.crisoft.aplicacionjsf.conexion.Conexion.sentencia;
import com.crisoft.aplicacionjsf.modelos.Persona;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class BuscarTelefonosBean extends Conexion {

    /**
     * Creates a new instance of BuscarTelefonosBean
     */
    private List<Persona> listapersonas;
    private int codigopersona;

    public BuscarTelefonosBean() {
    }

    public List<Persona> getListapersonas() {
        return listapersonas;
    }

    public void setListapersonas(List<Persona> listapersonas) {
        this.listapersonas = listapersonas;
    }

    public int getCodigopersona() {
        return codigopersona;
    }

    public void setCodigopersona(int codigopersona) {
        this.codigopersona = codigopersona;
    }

    @PostConstruct
    public void init() {
        listapersonas = listarPersonasBD();
    }

    public List<Persona> listarPersonasBD() {
        ArrayList<Persona> personitas = new ArrayList<>();
        try {

            conectar();
            String consultar = "SELECT * FROM persona";
            sentencia = con.prepareStatement(consultar);
            resultado = sentencia.executeQuery();
            while (resultado.next()) {
                Persona per = new Persona();
                //idpersona
                per.setIdpersona(resultado.getInt("idpersona"));
                per.setCedulapersona(resultado.getString("cedulapersona"));
                per.setNombrepersona(resultado.getString("nombrepersona"));
                per.setApellidopersona(resultado.getString("apellidopersona"));
                per.setEdadpersona(Integer.parseInt(resultado.getString("edadpersona")));
                per.setSexopersona(resultado.getString("sexopersona"));
                per.setCorreopersona(resultado.getString("correopersona"));
                personitas.add(per);
            }
            desconectar();
        } catch (SQLException e) {
            System.err.println("Error en BuscarTelefonosBean, listarPersonasBD()" + e);
        }
        return personitas;
    }
}
