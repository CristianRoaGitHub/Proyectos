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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 *
 * @author croa
 */
@Entity
@Table(name = "menu_rel_submenu")
@NamedQueries({
    @NamedQuery(name = "MenuRelSubmenu.findAll", query = "SELECT m FROM MenuRelSubmenu m")
    , @NamedQuery(name = "MenuRelSubmenu.findByRelIdMenusubmenu", query = "SELECT m FROM MenuRelSubmenu m WHERE m.relIdMenusubmenu = :relIdMenusubmenu")
    , @NamedQuery(name = "MenuRelSubmenu.findByRelDescripcionSunmenu", query = "SELECT m FROM MenuRelSubmenu m WHERE m.relDescripcionSunmenu = :relDescripcionSunmenu")})
public class MenuRelSubmenu implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "rel_id_menusubmenu")
    private Integer relIdMenusubmenu;
    @Size(max = 200)
    @Column(name = "rel_descripcion_sunmenu")
    private String relDescripcionSunmenu;
    @JoinColumn(name = "rel_id_menu", referencedColumnName = "men_codigo")
    @ManyToOne
    private Menu relIdMenu;
    @JoinColumn(name = "rel_id_submenu", referencedColumnName = "subm_id")
    @OneToOne
    private Submenu relIdSubmenu;

    public MenuRelSubmenu() {
    }

    public MenuRelSubmenu(Integer relIdMenusubmenu) {
        this.relIdMenusubmenu = relIdMenusubmenu;
    }

    public Integer getRelIdMenusubmenu() {
        return relIdMenusubmenu;
    }

    public void setRelIdMenusubmenu(Integer relIdMenusubmenu) {
        this.relIdMenusubmenu = relIdMenusubmenu;
    }

    public String getRelDescripcionSunmenu() {
        return relDescripcionSunmenu;
    }

    public void setRelDescripcionSunmenu(String relDescripcionSunmenu) {
        this.relDescripcionSunmenu = relDescripcionSunmenu;
    }

    public Menu getRelIdMenu() {
        return relIdMenu;
    }

    public void setRelIdMenu(Menu relIdMenu) {
        this.relIdMenu = relIdMenu;
    }

    public Submenu getRelIdSubmenu() {
        return relIdSubmenu;
    }

    public void setRelIdSubmenu(Submenu relIdSubmenu) {
        this.relIdSubmenu = relIdSubmenu;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (relIdMenusubmenu != null ? relIdMenusubmenu.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MenuRelSubmenu)) {
            return false;
        }
        MenuRelSubmenu other = (MenuRelSubmenu) object;
        if ((this.relIdMenusubmenu == null && other.relIdMenusubmenu != null) || (this.relIdMenusubmenu != null && !this.relIdMenusubmenu.equals(other.relIdMenusubmenu))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.crisoft.restaurante.vo.MenuRelSubmenu[ relIdMenusubmenu=" + relIdMenusubmenu + " ]";
    }
    
}
