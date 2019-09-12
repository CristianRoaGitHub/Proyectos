/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crisoft.aplicacionjsf.modelos;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author ACER
 */
@Entity
@Table(name = "nota")
@NamedQueries({
    @NamedQuery(name = "Nota.findAll", query = "SELECT n FROM Nota n")})
public class Nota {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codigo")
    private Integer codigo;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "encabezado")
    private String encabezado;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "cuerpo")
    private String cuerpo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha", insertable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @Size(max = 50)
    @Column(name = "comentarioadmin")
    private String comentarioadmin;
    @Size(max = 2)
    @Column(name = "valorizacion")
    private Integer valorizacion;
    @JoinColumn(name = "codigocategoria", referencedColumnName = "codigo")
    @ManyToOne(optional = false)
    private int codigocategoria;
    @JoinColumn(name = "codigopersona", referencedColumnName = "cedulapersona")
    @ManyToOne(optional = false)
    private String codigopersona;
    
    private Persona persona;
    private Categoria categoria;

    public Nota() {
    }

    public Nota(Integer codigo) {
        this.codigo = codigo;
    }

    public Nota(Integer codigo, String encabezado, String cuerpo, Date fecha) {
        this.codigo = codigo;
        this.encabezado = encabezado;
        this.cuerpo = cuerpo;
        this.fecha = fecha;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getEncabezado() {
        return encabezado;
    }

    public void setEncabezado(String encabezado) {
        this.encabezado = encabezado;
    }

    public String getCuerpo() {
        return cuerpo;
    }

    public void setCuerpo(String cuerpo) {
        this.cuerpo = cuerpo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getComentarioadmin() {
        return comentarioadmin;
    }

    public void setComentarioadmin(String comentarioadmin) {
        this.comentarioadmin = comentarioadmin;
    }

    public Integer getValorizacion() {
        return valorizacion;
    }

    public void setValorizacion(Integer valorizacion) {
        this.valorizacion = valorizacion;
    }

    public int getCodigocategoria() {
        return codigocategoria;
    }

    public void setCodigocategoria(int codigocategoria) {
        this.codigocategoria = codigocategoria;
    }

    public String getCodigopersona() {
        return codigopersona;
    }

    public void setCodigopersona(String codigopersona) {
        this.codigopersona = codigopersona;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigo != null ? codigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Nota)) {
            return false;
        }
        Nota other = (Nota) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.crisoft.aplicacionjsf.modelos.Nota[ codigo=" + codigo + " ]";
    }
    
}
