/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crisoft.restaurante.vo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "categoria_producto")
@NamedQueries({
    @NamedQuery(name = "CategoriaProducto.findAll", query = "SELECT c FROM CategoriaProducto c")
    , @NamedQuery(name = "CategoriaProducto.findByCatIdAuto", query = "SELECT c FROM CategoriaProducto c WHERE c.catIdAuto = :catIdAuto")
    , @NamedQuery(name = "CategoriaProducto.findByCatTipo", query = "SELECT c FROM CategoriaProducto c WHERE c.catTipo = :catTipo")
    , @NamedQuery(name = "CategoriaProducto.findByCatDescripcion", query = "SELECT c FROM CategoriaProducto c WHERE c.catDescripcion = :catDescripcion")})
public class CategoriaProducto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cat_id_auto")
    private Integer catIdAuto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "cat_tipo")
    private String catTipo;
    @Size(max = 200)
    @Column(name = "cat_descripcion")
    private String catDescripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "proIdCat")
    private List<Producto> productoList;

    public CategoriaProducto() {
    }

    public CategoriaProducto(Integer catIdAuto) {
        this.catIdAuto = catIdAuto;
    }

    public CategoriaProducto(Integer catIdAuto, String catTipo) {
        this.catIdAuto = catIdAuto;
        this.catTipo = catTipo;
    }

    public Integer getCatIdAuto() {
        return catIdAuto;
    }

    public void setCatIdAuto(Integer catIdAuto) {
        this.catIdAuto = catIdAuto;
    }

    public String getCatTipo() {
        return catTipo;
    }

    public void setCatTipo(String catTipo) {
        this.catTipo = catTipo;
    }

    public String getCatDescripcion() {
        return catDescripcion;
    }

    public void setCatDescripcion(String catDescripcion) {
        this.catDescripcion = catDescripcion;
    }

    public List<Producto> getProductoList() {
        return productoList;
    }

    public void setProductoList(List<Producto> productoList) {
        this.productoList = productoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (catIdAuto != null ? catIdAuto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CategoriaProducto)) {
            return false;
        }
        CategoriaProducto other = (CategoriaProducto) object;
        if ((this.catIdAuto == null && other.catIdAuto != null) || (this.catIdAuto != null && !this.catIdAuto.equals(other.catIdAuto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.crisoft.restaurante.vo.CategoriaProducto[ catIdAuto=" + catIdAuto + " ]";
    }
    
}
