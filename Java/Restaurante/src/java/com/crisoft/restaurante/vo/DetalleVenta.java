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
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author croa
 */
@Entity
@Table(name = "detalle_venta")
@NamedQueries({
    @NamedQuery(name = "DetalleVenta.findAll", query = "SELECT d FROM DetalleVenta d")
    , @NamedQuery(name = "DetalleVenta.findByDetIdAuto", query = "SELECT d FROM DetalleVenta d WHERE d.detIdAuto = :detIdAuto")
    , @NamedQuery(name = "DetalleVenta.findByDetCodDetallesAut", query = "SELECT d FROM DetalleVenta d WHERE d.detCodDetallesAut = :detCodDetallesAut")
    , @NamedQuery(name = "DetalleVenta.findByDetPrecioProducto", query = "SELECT d FROM DetalleVenta d WHERE d.detPrecioProducto = :detPrecioProducto")
    , @NamedQuery(name = "DetalleVenta.findByDetCantidadProducto", query = "SELECT d FROM DetalleVenta d WHERE d.detCantidadProducto = :detCantidadProducto")})
public class DetalleVenta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "det_id_auto")
    private Integer detIdAuto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "det_cod_detalles_aut")
    private int detCodDetallesAut;
    @Basic(optional = false)
    @NotNull
    @Column(name = "det_precio_producto")
    private double detPrecioProducto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "det_cantidad_producto")
    private int detCantidadProducto;
    @JoinColumn(name = "det_per_id_cedula", referencedColumnName = "per_id_cedula")
    @ManyToOne(optional = false)
    private Persona detPerIdCedula;
    @JoinColumn(name = "det_pro_id_auto", referencedColumnName = "pro_id_auto")
    @ManyToOne(optional = false)
    private Producto detProIdAuto;

    public DetalleVenta() {
    }

    public DetalleVenta(Integer detIdAuto) {
        this.detIdAuto = detIdAuto;
    }

    public DetalleVenta(Integer detIdAuto, int detCodDetallesAut, double detPrecioProducto, int detCantidadProducto) {
        this.detIdAuto = detIdAuto;
        this.detCodDetallesAut = detCodDetallesAut;
        this.detPrecioProducto = detPrecioProducto;
        this.detCantidadProducto = detCantidadProducto;
    }

    public Integer getDetIdAuto() {
        return detIdAuto;
    }

    public void setDetIdAuto(Integer detIdAuto) {
        this.detIdAuto = detIdAuto;
    }

    public int getDetCodDetallesAut() {
        return detCodDetallesAut;
    }

    public void setDetCodDetallesAut(int detCodDetallesAut) {
        this.detCodDetallesAut = detCodDetallesAut;
    }

    public double getDetPrecioProducto() {
        return detPrecioProducto;
    }

    public void setDetPrecioProducto(double detPrecioProducto) {
        this.detPrecioProducto = detPrecioProducto;
    }

    public int getDetCantidadProducto() {
        return detCantidadProducto;
    }

    public void setDetCantidadProducto(int detCantidadProducto) {
        this.detCantidadProducto = detCantidadProducto;
    }

    public Persona getDetPerIdCedula() {
        return detPerIdCedula;
    }

    public void setDetPerIdCedula(Persona detPerIdCedula) {
        this.detPerIdCedula = detPerIdCedula;
    }

    public Producto getDetProIdAuto() {
        return detProIdAuto;
    }

    public void setDetProIdAuto(Producto detProIdAuto) {
        this.detProIdAuto = detProIdAuto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (detIdAuto != null ? detIdAuto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetalleVenta)) {
            return false;
        }
        DetalleVenta other = (DetalleVenta) object;
        if ((this.detIdAuto == null && other.detIdAuto != null) || (this.detIdAuto != null && !this.detIdAuto.equals(other.detIdAuto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.crisoft.restaurante.vo.DetalleVenta[ detIdAuto=" + detIdAuto + " ]";
    }
    
}
