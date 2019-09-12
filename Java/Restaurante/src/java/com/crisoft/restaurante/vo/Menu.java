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
import javax.validation.constraints.Size;

/**
 *
 * @author croa
 */
@Entity
@Table(name = "menu")
@NamedQueries({
    @NamedQuery(name = "Menu.findAll", query = "SELECT m FROM Menu m")
    , @NamedQuery(name = "Menu.findByMenCodigo", query = "SELECT m FROM Menu m WHERE m.menCodigo = :menCodigo")
    , @NamedQuery(name = "Menu.findByMenNombre", query = "SELECT m FROM Menu m WHERE m.menNombre = :menNombre")
    , @NamedQuery(name = "Menu.findByMenTipo", query = "SELECT m FROM Menu m WHERE m.menTipo = :menTipo")})
public class Menu implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "men_codigo")
    private Integer menCodigo;
    @Size(max = 50)
    @Column(name = "men_nombre")
    private String menNombre;
    @Size(max = 2)
    @Column(name = "men_tipo")
    private String menTipo;
    @OneToMany(mappedBy = "relIdMenu")
    private List<MenuRelSubmenu> menuRelSubmenuList;
    @JoinColumn(name = "men_usu_id_auto", referencedColumnName = "usu_id_auto")
    @ManyToOne
    private Usuario menUsuIdAuto;

    public Menu() {
    }

    public Menu(Integer menCodigo) {
        this.menCodigo = menCodigo;
    }

    public Integer getMenCodigo() {
        return menCodigo;
    }

    public void setMenCodigo(Integer menCodigo) {
        this.menCodigo = menCodigo;
    }

    public String getMenNombre() {
        return menNombre;
    }

    public void setMenNombre(String menNombre) {
        this.menNombre = menNombre;
    }

    public String getMenTipo() {
        return menTipo;
    }

    public void setMenTipo(String menTipo) {
        this.menTipo = menTipo;
    }

    public List<MenuRelSubmenu> getMenuRelSubmenuList() {
        return menuRelSubmenuList;
    }

    public void setMenuRelSubmenuList(List<MenuRelSubmenu> menuRelSubmenuList) {
        this.menuRelSubmenuList = menuRelSubmenuList;
    }

    public Usuario getMenUsuIdAuto() {
        return menUsuIdAuto;
    }

    public void setMenUsuIdAuto(Usuario menUsuIdAuto) {
        this.menUsuIdAuto = menUsuIdAuto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (menCodigo != null ? menCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Menu)) {
            return false;
        }
        Menu other = (Menu) object;
        if ((this.menCodigo == null && other.menCodigo != null) || (this.menCodigo != null && !this.menCodigo.equals(other.menCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.crisoft.restaurante.vo.Menu[ menCodigo=" + menCodigo + " ]";
    }
    
}
