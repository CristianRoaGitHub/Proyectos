package com.crisoft.aplicacionjsf.beans;

import com.crisoft.aplicacionjsf.conexion.Conexion;
import com.crisoft.aplicacionjsf.modelos.Nota;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author ACER
 */
@ManagedBean
@RequestScoped
public class ComentarBean extends Conexion {

    private List<Nota> notas = new ArrayList<>();
    private Nota nota;

    public ComentarBean() {
    }

    public List<Nota> getListaNotas() {
        return notas;
    }

    public void setListaNotas(List<Nota> listaNotas) {
        this.notas = listaNotas;
    }

    public void setNota(Nota nota) {
        this.nota = nota;
    }

    public Nota getNota() {
        return nota;
    }

    @PostConstruct
    public void init() {
        notas = consulta();
    }

    public List<Nota> consulta() {

        try {

            conectar();
            String consultar = "SELECT * FROM nota";
            sentencia = con.prepareStatement(consultar);
            resultado = sentencia.executeQuery();
            while (resultado.next()) {
                Nota n = new Nota();
                //codigo  , codigopersona, codigocategoria,encabezado,cuerpo, fecha, comentarioadmin, valorizacion
                n.setCodigo(resultado.getInt("codigo"));
                n.setCodigopersona(resultado.getString("codigopersona"));
                n.setCodigocategoria(resultado.getInt("codigocategoria"));
                n.setEncabezado(resultado.getString("encabezado"));
                n.setCuerpo(resultado.getString("cuerpo"));
                n.setFecha(resultado.getDate("fecha"));
                n.setComentarioadmin(resultado.getString("comentarioadmin"));
                n.setValorizacion(resultado.getInt("valorizacion"));
                notas.add(n);
            }
            desconectar();
        } catch (SQLException e) {
            System.err.println("Error en NotaBean, consulta()" + e);
        }
        return notas;
    }

    public void asignar(Nota nota) {
        this.nota = nota;
        //codigo  , codigopersona, codigocategoria,encabezado,cuerpo, fecha, comentarioadmin, valorizacion
        System.out.println("Rta codigo: " + nota.getCodigo());
        System.out.println("Rta codigopersona: " + nota.getCodigopersona());
        System.out.println("Rta codigocategoria: " + nota.getCodigocategoria());
        System.out.println("Rta encabezado: " + nota.getEncabezado());
        System.out.println("Rta cuerpo: " + nota.getCuerpo());
        System.out.println("Rta fecha: " + nota.getFecha());
        System.out.println("Rta comentarioadmin: " + nota.getComentarioadmin());
        System.out.println("Rta valorizacion: " + nota.getValorizacion());
        ver();
    }
    
    public  void ver(){
        System.out.println("El encavezado es " + getNota().getEncabezado());
    }

}
