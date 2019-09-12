/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crisoft.aplicacionjsf.beans;

import com.crisoft.aplicacionjsf.conexion.Conexion;
import com.crisoft.aplicacionjsf.modelos.Categoria;
import com.crisoft.aplicacionjsf.modelos.Nota;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import org.jboss.weld.bean.builtin.FacadeInjectionPoint;

/**
 *
 * @author ACER
 */
@ManagedBean
@RequestScoped
public class NotaBean extends Conexion {

    /**
     * Creates a new instance of NotaBean
     */
    private Categoria categoria = new Categoria();
    private Nota nota = new Nota();
    private List<Categoria> lstCategoria;
    private String mensaje;

    public NotaBean() {
    }

    @PostConstruct
    public void init() {
        lstCategoria = listaCategorias();
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public List<Categoria> getLstCategoria() {
        return lstCategoria;
    }

    public void setLstCategoria(List<Categoria> lstCategoria) {
        this.lstCategoria = lstCategoria;
    }

    public Nota getNota() {
        return nota;
    }

    public void setNota(Nota nota) {
        this.nota = nota;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public List<Categoria> listaCategorias() {

        List<Categoria> listita = new ArrayList<Categoria>();
        try {
            conectar();
            String consultar = "SELECT * FROM categoria";
            sentencia = con.prepareStatement(consultar);
            resultado = sentencia.executeQuery();
            while (resultado.next()) {
                Categoria cat = new Categoria();
                cat.setCodigo(resultado.getInt("codigo"));
                cat.setNombre(resultado.getString("nombre"));
                cat.setEstado(resultado.getShort("estado"));
                listita.add(cat);
            }
            desconectar();
        } catch (Exception e) {
            System.out.println("Error en listaCategoria " + e);
            return null;
        }
        return listita;
    }

    public void registrar() {

        try {
            /*Login usu = (Login) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuariosesion");
            nota.setCodigopersona(usu.getId().toString());*/
            nota.setCodigocategoria(categoria.getCodigo());
            nota.setCodigopersona("1019");
            boolean rta = registrarNotaBD(nota);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Aviso", "Nota Registrada"));
            /*if (rta) {
                this.mensaje=("Nota registrada");
            }*/
        } catch (Exception e) {
            System.out.println("Hubo un error en clase NotaBean metodo registrar()" + e);
        }

    }

    public boolean registrarNotaBD(Nota notica) {

        try {
            conectar();

            String insertar = "INSERT INTO nota (codigopersona, codigocategoria, encabezado, cuerpo)"
                    + "VALUES (?,?,?,?)";
            sentencia = con.prepareStatement(insertar);
            int rta = 0;
            sentencia.setString(1, notica.getCodigopersona());
            sentencia.setInt(2, notica.getCodigocategoria());
            sentencia.setString(3, notica.getEncabezado());
            sentencia.setString(4, notica.getCuerpo());
            rta = sentencia.executeUpdate();

            desconectar();
            if (rta == 1) {
                System.out.println("Se registro satisfactoriamente la nota");
                return true;
            } else {
                desconectar();
                System.err.println("No registro ");
                return false;
            }
        } catch (SQLException e) {
            desconectar();
            System.err.println("Error en Clase NotaBean, Metodo registrarNotaBD " + e);
        }
        return true;

    }
}
