/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crisoft.restaurante.vo;

import java.io.Serializable;
import java.util.List;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author croa
 */
@Entity
@Table(name = "usuario")
@NamedQueries({
    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u")
    , @NamedQuery(name = "Usuario.findByUsuIdAuto", query = "SELECT u FROM Usuario u WHERE u.usuIdAuto = :usuIdAuto")
    , @NamedQuery(name = "Usuario.findByUsuNombreUsu", query = "SELECT u FROM Usuario u WHERE u.usuNombreUsu = :usuNombreUsu")
    , @NamedQuery(name = "Usuario.findByUsuClave", query = "SELECT u FROM Usuario u WHERE u.usuClave = :usuClave")
    , @NamedQuery(name = "Usuario.findByUsuEstado", query = "SELECT u FROM Usuario u WHERE u.usuEstado = :usuEstado")
    , @NamedQuery(name = "Usuario.findByUsuTipo", query = "SELECT u FROM Usuario u WHERE u.usuTipo = :usuTipo")})
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "usu_id_auto")
    private Integer usuIdAuto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "usu_nombre_usu")
    private String usuNombreUsu;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "usu_clave")
    private String usuClave;
    @Basic(optional = false)
    @NotNull
    @Column(name = "usu_estado")
    private int usuEstado;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "usu_tipo")
    private String usuTipo;
    @JoinColumn(name = "usu_per_id_cedula", referencedColumnName = "per_id_cedula")
    @ManyToOne(optional = false)
    private Persona usuPerIdCedula;
    @OneToMany(mappedBy = "menUsuIdAuto")
    private List<Menu> menuList;

    public Usuario() {
    }

    public Usuario(Integer usuIdAuto) {
        this.usuIdAuto = usuIdAuto;
    }

    public Usuario(Integer usuIdAuto, String usuNombreUsu, String usuClave, int usuEstado, String usuTipo) {
        this.usuIdAuto = usuIdAuto;
        this.usuNombreUsu = usuNombreUsu;
        this.usuClave = usuClave;
        this.usuEstado = usuEstado;
        this.usuTipo = usuTipo;
    }

    public Integer getUsuIdAuto() {
        return usuIdAuto;
    }

    public void setUsuIdAuto(Integer usuIdAuto) {
        this.usuIdAuto = usuIdAuto;
    }

    public String getUsuNombreUsu() {
        return usuNombreUsu;
    }

    public void setUsuNombreUsu(String usuNombreUsu) {
        this.usuNombreUsu = usuNombreUsu;
    }

    public String getUsuClave() {
        return usuClave;
    }

    public void setUsuClave(String usuClave) {
        this.usuClave = usuClave;
    }

    public int getUsuEstado() {
        return usuEstado;
    }

    public void setUsuEstado(int usuEstado) {
        this.usuEstado = usuEstado;
    }

    public String getUsuTipo() {
        return usuTipo;
    }

    public void setUsuTipo(String usuTipo) {
        this.usuTipo = usuTipo;
    }

    public Persona getUsuPerIdCedula() {
        return usuPerIdCedula;
    }

    public void setUsuPerIdCedula(Persona usuPerIdCedula) {
        this.usuPerIdCedula = usuPerIdCedula;
    }

    public List<Menu> getMenuList() {
        return menuList;
    }

    public void setMenuList(List<Menu> menuList) {
        this.menuList = menuList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (usuIdAuto != null ? usuIdAuto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.usuIdAuto == null && other.usuIdAuto != null) || (this.usuIdAuto != null && !this.usuIdAuto.equals(other.usuIdAuto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.crisoft.restaurante.vo.Usuario[ usuIdAuto=" + usuIdAuto + " ]";
    }
    
}
