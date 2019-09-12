/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crisoft.aplicacionjsf.modelos;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author ACER
 */
@Entity
@Table(name = "persona")
@NamedQueries({
    @NamedQuery(name = "Persona.findAll", query = "SELECT p FROM Persona p")})
public class Persona implements Serializable {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "idpersona")
    private int idpersona;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "cedulapersona")
    private String cedulapersona;
    @Size(max = 100)
    @Column(name = "nombrepersona")
    private String nombrepersona;
    @Size(max = 100)
    @Column(name = "apellidopersona")
    private String apellidopersona;
    @Column(name = "edadpersona")
    private Integer edadpersona;
    @Size(max = 10)
    @Column(name = "sexopersona")
    private String sexopersona;
    @Size(max = 100)
    @Column(name = "correopersona")
    private String correopersona;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codigopersona")
    private List<Telefono> telefonoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codigopersona")
    private List<Nota> notaList;

    public Persona() {
    }

    public Persona(String cedulapersona) {
        this.cedulapersona = cedulapersona;
    }


    public int getIdpersona() {
        return idpersona;
    }

    public void setIdpersona(int idpersona) {
        this.idpersona = idpersona;
    }

    public String getCedulapersona() {
        return cedulapersona;
    }

    public void setCedulapersona(String cedulapersona) {
        this.cedulapersona = cedulapersona;
    }

    public String getNombrepersona() {
        return nombrepersona;
    }

    public void setNombrepersona(String nombrepersona) {
        this.nombrepersona = nombrepersona;
    }

    public String getApellidopersona() {
        return apellidopersona;
    }

    public void setApellidopersona(String apellidopersona) {
        this.apellidopersona = apellidopersona;
    }

    public Integer getEdadpersona() {
        return edadpersona;
    }

    public void setEdadpersona(Integer edadpersona) {
        this.edadpersona = edadpersona;
    }

    public String getSexopersona() {
        return sexopersona;
    }

    public void setSexopersona(String sexopersona) {
        this.sexopersona = sexopersona;
    }

    public String getCorreopersona() {
        return correopersona;
    }

    public void setCorreopersona(String correopersona) {
        this.correopersona = correopersona;
    }

    public List<Telefono> getTelefonoList() {
        return telefonoList;
    }

    public void setTelefonoList(List<Telefono> telefonoList) {
        this.telefonoList = telefonoList;
    }

    public List<Nota> getNotaList() {
        return notaList;
    }

    public void setNotaList(List<Nota> notaList) {
        this.notaList = notaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cedulapersona != null ? cedulapersona.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Persona)) {
            return false;
        }
        Persona other = (Persona) object;
        if ((this.cedulapersona == null && other.cedulapersona != null) || (this.cedulapersona != null && !this.cedulapersona.equals(other.cedulapersona))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.crisoft.aplicacionjsf.modelos.Persona[ cedulapersona=" + cedulapersona + " ]";
    }
    
}
