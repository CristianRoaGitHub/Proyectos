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
@Table(name = "producto")
@NamedQueries({
    @NamedQuery(name = "Producto.findAll", query = "SELECT p FROM Producto p")
    , @NamedQuery(name = "Producto.findByProIdAuto", query = "SELECT p FROM Producto p WHERE p.proIdAuto = :proIdAuto")
    , @NamedQuery(name = "Producto.findByProNombre", query = "SELECT p FROM Producto p WHERE p.proNombre = :proNombre")
    , @NamedQuery(name = "Producto.findByProPrecioProducto", query = "SELECT p FROM Producto p WHERE p.proPrecioProducto = :proPrecioProducto")
    , @NamedQuery(name = "Producto.findByProObservacion", query = "SELECT p FROM Producto p WHERE p.proObservacion = :proObservacion")})
public class Producto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pro_id_auto")
    private Integer proIdAuto;
    @Size(max = 50)
    @Column(name = "pro_nombre")
    private String proNombre;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "pro_precio_producto")
    private Double proPrecioProducto;
    @Size(max = 300)
    @Column(name = "pro_observacion")
    private String proObservacion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "detProIdAuto")
    private List<DetalleVenta> detalleVentaList;
    @JoinColumn(name = "pro_id_cat", referencedColumnName = "cat_id_auto")
    @ManyToOne(optional = false)
    private CategoriaProducto proIdCat;

    public Producto() {
    }

    public Producto(Integer proIdAuto) {
        this.proIdAuto = proIdAuto;
    }

    public Integer getProIdAuto() {
        return proIdAuto;
    }

    public void setProIdAuto(Integer proIdAuto) {
        this.proIdAuto = proIdAuto;
    }

    public String getProNombre() {
        return proNombre;
    }

    public void setProNombre(String proNombre) {
        this.proNombre = proNombre;
    }

    public Double getProPrecioProducto() {
        return proPrecioProducto;
    }

    public void setProPrecioProducto(Double proPrecioProducto) {
        this.proPrecioProducto = proPrecioProducto;
    }

    public String getProObservacion() {
        return proObservacion;
    }

    public void setProObservacion(String proObservacion) {
        this.proObservacion = proObservacion;
    }

    public List<DetalleVenta> getDetalleVentaList() {
        return detalleVentaList;
    }

    public void setDetalleVentaList(List<DetalleVenta> detalleVentaList) {
        this.detalleVentaList = detalleVentaList;
    }

    public CategoriaProducto getProIdCat() {
        return proIdCat;
    }

    public void setProIdCat(CategoriaProducto proIdCat) {
        this.proIdCat = proIdCat;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (proIdAuto != null ? proIdAuto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Producto)) {
            return false;
        }
        Producto other = (Producto) object;
        if ((this.proIdAuto == null && other.proIdAuto != null) || (this.proIdAuto != null && !this.proIdAuto.equals(other.proIdAuto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.crisoft.restaurante.vo.Producto[ proIdAuto=" + proIdAuto + " ]";
    }
    
}
