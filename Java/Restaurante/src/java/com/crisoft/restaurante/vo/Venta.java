/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crisoft.restaurante.vo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
@Table(name = "venta")
@NamedQueries({
    @NamedQuery(name = "Venta.findAll", query = "SELECT v FROM Venta v")
    , @NamedQuery(name = "Venta.findByVenIdAuto", query = "SELECT v FROM Venta v WHERE v.venIdAuto = :venIdAuto")
    , @NamedQuery(name = "Venta.findByVenDetCodDetallesAut", query = "SELECT v FROM Venta v WHERE v.venDetCodDetallesAut = :venDetCodDetallesAut")
    , @NamedQuery(name = "Venta.findByVenNombreOperario", query = "SELECT v FROM Venta v WHERE v.venNombreOperario = :venNombreOperario")
    , @NamedQuery(name = "Venta.findByVenMesa", query = "SELECT v FROM Venta v WHERE v.venMesa = :venMesa")
    , @NamedQuery(name = "Venta.findByVenCantidadTotal", query = "SELECT v FROM Venta v WHERE v.venCantidadTotal = :venCantidadTotal")
    , @NamedQuery(name = "Venta.findByVenValorTotal", query = "SELECT v FROM Venta v WHERE v.venValorTotal = :venValorTotal")
    , @NamedQuery(name = "Venta.findByVenFecha", query = "SELECT v FROM Venta v WHERE v.venFecha = :venFecha")
    , @NamedQuery(name = "Venta.findByVenObservacion", query = "SELECT v FROM Venta v WHERE v.venObservacion = :venObservacion")})
public class Venta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ven_id_auto")
    private Long venIdAuto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ven_det_cod_detalles_aut")
    private int venDetCodDetallesAut;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "ven_nombre_operario")
    private String venNombreOperario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "ven_mesa")
    private String venMesa;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ven_cantidad_total")
    private int venCantidadTotal;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "ven_valor_total")
    private Double venValorTotal;
    @Column(name = "ven_fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date venFecha;
    @Size(max = 300)
    @Column(name = "ven_observacion")
    private String venObservacion;

    public Venta() {
    }

    public Venta(Long venIdAuto) {
        this.venIdAuto = venIdAuto;
    }

    public Venta(Long venIdAuto, int venDetCodDetallesAut, String venNombreOperario, String venMesa, int venCantidadTotal) {
        this.venIdAuto = venIdAuto;
        this.venDetCodDetallesAut = venDetCodDetallesAut;
        this.venNombreOperario = venNombreOperario;
        this.venMesa = venMesa;
        this.venCantidadTotal = venCantidadTotal;
    }

    public Long getVenIdAuto() {
        return venIdAuto;
    }

    public void setVenIdAuto(Long venIdAuto) {
        this.venIdAuto = venIdAuto;
    }

    public int getVenDetCodDetallesAut() {
        return venDetCodDetallesAut;
    }

    public void setVenDetCodDetallesAut(int venDetCodDetallesAut) {
        this.venDetCodDetallesAut = venDetCodDetallesAut;
    }

    public String getVenNombreOperario() {
        return venNombreOperario;
    }

    public void setVenNombreOperario(String venNombreOperario) {
        this.venNombreOperario = venNombreOperario;
    }

    public String getVenMesa() {
        return venMesa;
    }

    public void setVenMesa(String venMesa) {
        this.venMesa = venMesa;
    }

    public int getVenCantidadTotal() {
        return venCantidadTotal;
    }

    public void setVenCantidadTotal(int venCantidadTotal) {
        this.venCantidadTotal = venCantidadTotal;
    }

    public Double getVenValorTotal() {
        return venValorTotal;
    }

    public void setVenValorTotal(Double venValorTotal) {
        this.venValorTotal = venValorTotal;
    }

    public Date getVenFecha() {
        return venFecha;
    }

    public void setVenFecha(Date venFecha) {
        this.venFecha = venFecha;
    }

    public String getVenObservacion() {
        return venObservacion;
    }

    public void setVenObservacion(String venObservacion) {
        this.venObservacion = venObservacion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (venIdAuto != null ? venIdAuto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Venta)) {
            return false;
        }
        Venta other = (Venta) object;
        if ((this.venIdAuto == null && other.venIdAuto != null) || (this.venIdAuto != null && !this.venIdAuto.equals(other.venIdAuto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.crisoft.restaurante.vo.Venta[ venIdAuto=" + venIdAuto + " ]";
    }

    public void setVenIdAuto() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
