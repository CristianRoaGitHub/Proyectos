package com.crisoft.aplicacionjsf.beans;

import com.crisoft.aplicacionjsf.conexion.Conexion;
import com.crisoft.aplicacionjsf.modelos.Categoria;
import com.crisoft.aplicacionjsf.modelos.Nota;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
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
public class BuscarBean extends Conexion {

    private List<Categoria> listaCategorias;
    private List<Nota> listaNotas = new ArrayList<>();
    private int codigoCategoria;
    private Date fechaConsulta;

    public BuscarBean() {
    }

    public List<Categoria> getListaCategorias() {
        return listaCategorias;
    }

    public void setListaCategorias(List<Categoria> listaCategorias) {
        this.listaCategorias = listaCategorias;
    }

    public int getCodigoCategoria() {
        return codigoCategoria;
    }

    public void setCodigoCategoria(int codigoCategoria) {
        this.codigoCategoria = codigoCategoria;
    }

    public Date getFechaConsulta() {
        return fechaConsulta;
    }

    public void setFechaConsulta(Date fechaConsulta) {
        this.fechaConsulta = fechaConsulta;
    }

    public List<Nota> getListaNotas() {
        return listaNotas;
    }

    public void setListaNotas(List<Nota> listaNotas) {
        this.listaNotas = listaNotas;
    }

    
    @PostConstruct
    public void init() {
        listaCategorias = listCategoria();
    }

    public List<Categoria> listCategoria() {
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

    public void buscarTest() throws Exception {
        buscar("1019", codigoCategoria, fechaConsulta);
    }

    //public List<Nota> buscar(String codigoPersona, int codigoCategoria, Date fechaConsulta) throws Exception {
    public void buscar(String codigoPersona, int codigoCategoria, Date fechaConsulta) throws Exception {
        //List<Nota> miListaNotas = new ArrayList<>();
        java.sql.Date fechaSql = new java.sql.Date(fechaConsulta.getTime());
        try {
            conectar();
            String consulta = "SELECT * FROM nota WHERE codigopersona = ? AND codigocategoria = ? AND fecha = ?";
            sentencia = con.prepareStatement(consulta);
            sentencia.setString(1, codigoPersona);
            sentencia.setInt(2, codigoCategoria);
            sentencia.setDate(3, fechaSql);
            resultado = sentencia.executeQuery();
            while (resultado.next()) {
                Nota nota = new Nota();
                nota.setCodigo(resultado.getInt("codigo"));
                nota.setCodigopersona(resultado.getString("codigopersona"));
                nota.setCodigocategoria(resultado.getInt("codigocategoria"));
                nota.setEncabezado(resultado.getString("encabezado"));
                nota.setCuerpo(resultado.getString("cuerpo"));
                nota.setFecha(resultado.getDate("fecha"));
                nota.setComentarioadmin(resultado.getString("comentarioadmin"));
                nota.setValorizacion(resultado.getInt("valorizacion"));
          //      miListaNotas.add(nota);
          listaNotas.add(nota);
            }
            desconectar();
            
        } catch (SQLException e) {
            desconectar();
            System.err.println("Error en la clase BuscarBean, Metodo buscar() " + e);
        }
        //return miListaNotas;
    }
}
