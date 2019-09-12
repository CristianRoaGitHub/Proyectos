/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crisoft.restaurante.vo;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author croa
 */
@Entity
@Table(name = "persona")
@NamedQueries({
    @NamedQuery(name = "Persona.findAll", query = "SELECT p FROM Persona p")
    , @NamedQuery(name = "Persona.findByPerIdAuto", query = "SELECT p FROM Persona p WHERE p.perIdAuto = :perIdAuto")
    , @NamedQuery(name = "Persona.findByPerIdCedula", query = "SELECT p FROM Persona p WHERE p.perIdCedula = :perIdCedula")
    , @NamedQuery(name = "Persona.findByPerNombre", query = "SELECT p FROM Persona p WHERE p.perNombre = :perNombre")
    , @NamedQuery(name = "Persona.findByPerApellido", query = "SELECT p FROM Persona p WHERE p.perApellido = :perApellido")
    , @NamedQuery(name = "Persona.findByPerGenero", query = "SELECT p FROM Persona p WHERE p.perGenero = :perGenero")
    , @NamedQuery(name = "Persona.findByPerFechaNac", query = "SELECT p FROM Persona p WHERE p.perFechaNac = :perFechaNac")
    , @NamedQuery(name = "Persona.findByPerCorreo", query = "SELECT p FROM Persona p WHERE p.perCorreo = :perCorreo")
    , @NamedQuery(name = "Persona.findByPerTelefono", query = "SELECT p FROM Persona p WHERE p.perTelefono = :perTelefono")})
public class Persona implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "per_id_auto")
    private int perIdAuto;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "per_id_cedula")
    private String perIdCedula;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "per_nombre")
    private String perNombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "per_apellido")
    private String perApellido;
    @Size(max = 10)
    @Column(name = "per_genero")
    private String perGenero;
    @Column(name = "per_fecha_nac")
    @Temporal(TemporalType.DATE)
    private Date perFechaNac;
    @Size(max = 30)
    @Column(name = "per_correo")
    private String perCorreo;
    @Column(name = "per_telefono")
    private Integer perTelefono;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "detPerIdCedula")
    private List<DetalleVenta> detalleVentaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuPerIdCedula")
    private List<Usuario> usuarioList;

    public Persona() {
    }

    public Persona(String perIdCedula) {
        this.perIdCedula = perIdCedula;
    }

    public Persona(String perIdCedula, int perIdAuto, String perNombre, String perApellido) {
        this.perIdCedula = perIdCedula;
        this.perIdAuto = perIdAuto;
        this.perNombre = perNombre;
        this.perApellido = perApellido;
    }

    public int getPerIdAuto() {
        return perIdAuto;
    }

    public void setPerIdAuto(int perIdAuto) {
        this.perIdAuto = perIdAuto;
    }

    public String getPerIdCedula() {
        return perIdCedula;
    }

    public void setPerIdCedula(String perIdCedula) {
        this.perIdCedula = perIdCedula;
    }

    public String getPerNombre() {
        return perNombre;
    }

    public void setPerNombre(String perNombre) {
        this.perNombre = perNombre;
    }

    public String getPerApellido() {
        return perApellido;
    }

    public void setPerApellido(String perApellido) {
        this.perApellido = perApellido;
    }

    public String getPerGenero() {
        return perGenero;
    }

    public void setPerGenero(String perGenero) {
        this.perGenero = perGenero;
    }

    public Date getPerFechaNac() {
        return perFechaNac;
    }

    public void setPerFechaNac(Date perFechaNac) {
        this.perFechaNac = perFechaNac;
    }

    public String getPerCorreo() {
        return perCorreo;
    }

    public void setPerCorreo(String perCorreo) {
        this.perCorreo = perCorreo;
    }

    public Integer getPerTelefono() {
        return perTelefono;
    }

    public void setPerTelefono(Integer perTelefono) {
        this.perTelefono = perTelefono;
    }

    public List<DetalleVenta> getDetalleVentaList() {
        return detalleVentaList;
    }

    public void setDetalleVentaList(List<DetalleVenta> detalleVentaList) {
        this.detalleVentaList = detalleVentaList;
    }

    public List<Usuario> getUsuarioList() {
        return usuarioList;
    }

    public void setUsuarioList(List<Usuario> usuarioList) {
        this.usuarioList = usuarioList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (perIdCedula != null ? perIdCedula.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Persona)) {
            return false;
        }
        Persona other = (Persona) object;
        if ((this.perIdCedula == null && other.perIdCedula != null) || (this.perIdCedula != null && !this.perIdCedula.equals(other.perIdCedula))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.crisoft.restaurante.vo.Persona[ perIdCedula=" + perIdCedula + " ]";
    }
    
}
