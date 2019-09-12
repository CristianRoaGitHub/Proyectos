/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crisoft.restaurante.vo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author croa
 */
@Entity
@Table(name = "submenu")
@NamedQueries({
    @NamedQuery(name = "Submenu.findAll", query = "SELECT s FROM Submenu s")
    , @NamedQuery(name = "Submenu.findBySubmId", query = "SELECT s FROM Submenu s WHERE s.submId = :submId")
    , @NamedQuery(name = "Submenu.findBySubmTipo", query = "SELECT s FROM Submenu s WHERE s.submTipo = :submTipo")
    , @NamedQuery(name = "Submenu.findBySubmNombre", query = "SELECT s FROM Submenu s WHERE s.submNombre = :submNombre")
    , @NamedQuery(name = "Submenu.findBySubmUrl", query = "SELECT s FROM Submenu s WHERE s.submUrl = :submUrl")})
public class Submenu implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "subm_id")
    private Integer submId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "subm_tipo")
    private String submTipo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "subm_nombre")
    private String submNombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "subm_url")
    private String submUrl;
    @OneToOne(mappedBy = "relIdSubmenu")
    private MenuRelSubmenu menuRelSubmenu;

    public Submenu() {
    }

    public Submenu(Integer submId) {
        this.submId = submId;
    }

    public Submenu(Integer submId, String submTipo, String submNombre, String submUrl) {
        this.submId = submId;
        this.submTipo = submTipo;
        this.submNombre = submNombre;
        this.submUrl = submUrl;
    }

    public Integer getSubmId() {
        return submId;
    }

    public void setSubmId(Integer submId) {
        this.submId = submId;
    }

    public String getSubmTipo() {
        return submTipo;
    }

    public void setSubmTipo(String submTipo) {
        this.submTipo = submTipo;
    }

    public String getSubmNombre() {
        return submNombre;
    }

    public void setSubmNombre(String submNombre) {
        this.submNombre = submNombre;
    }

    public String getSubmUrl() {
        return submUrl;
    }

    public void setSubmUrl(String submUrl) {
        this.submUrl = submUrl;
    }

    public MenuRelSubmenu getMenuRelSubmenu() {
        return menuRelSubmenu;
    }

    public void setMenuRelSubmenu(MenuRelSubmenu menuRelSubmenu) {
        this.menuRelSubmenu = menuRelSubmenu;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (submId != null ? submId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Submenu)) {
            return false;
        }
        Submenu other = (Submenu) object;
        if ((this.submId == null && other.submId != null) || (this.submId != null && !this.submId.equals(other.submId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.crisoft.restaurante.vo.Submenu[ submId=" + submId + " ]";
    }
    
}
