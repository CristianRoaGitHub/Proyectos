/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crisoft.aplicacionjsf.modelos;

import java.io.Serializable;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author ACER
 */
@Entity
@Table(name = "telefono")
@NamedQueries({
    @NamedQuery(name = "Telefono.findAll", query = "SELECT t FROM Telefono t")})
public class Telefono implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codigotelefono")
    private Integer codigotelefono;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 12)
    @Column(name = "numerotel")
    private String numerotel;
    @JoinColumn(name = "codigopersona", referencedColumnName = "cedulapersona")
    @ManyToOne(optional = false)
    private String codigopersona;

    public Telefono() {
    }

    public Telefono(Integer codigotelefono) {
        this.codigotelefono = codigotelefono;
    }

    public Telefono(Integer codigotelefono, String numerotel) {
        this.codigotelefono = codigotelefono;
        this.numerotel = numerotel;
    }

    public Integer getCodigotelefono() {
        return codigotelefono;
    }

    public void setCodigotelefono(Integer codigotelefono) {
        this.codigotelefono = codigotelefono;
    }

    public String getNumerotel() {
        return numerotel;
    }

    public void setNumerotel(String numerotel) {
        this.numerotel = numerotel;
    }

    public String getCodigopersona() {
        return codigopersona;
    }

    public void setCodigopersona(String codigopersona) {
        this.codigopersona = codigopersona;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigotelefono != null ? codigotelefono.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Telefono)) {
            return false;
        }
        Telefono other = (Telefono) object;
        if ((this.codigotelefono == null && other.codigotelefono != null) || (this.codigotelefono != null && !this.codigotelefono.equals(other.codigotelefono))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.crisoft.aplicacionjsf.modelos.Telefono[ codigotelefono=" + codigotelefono + " ]";
    }
    
}
