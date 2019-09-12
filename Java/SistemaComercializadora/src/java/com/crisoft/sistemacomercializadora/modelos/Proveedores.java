/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crisoft.sistemacomercializadora.modelos;

/**
 *
 * @author ACER
 */
public class Proveedores {
    private long proveedorId;
    private String nombreProv;
    private String contatoProv;
    private String celullarProv;
    private String fijoProv;

    public long getProveedorId() {
        return proveedorId;
    }

    public void setProveedorId(long proveedorId) {
        this.proveedorId = proveedorId;
    }

    public String getNombreProv() {
        return nombreProv;
    }

    public void setNombreProv(String nombreProv) {
        this.nombreProv = nombreProv;
    }

    public String getContatoProv() {
        return contatoProv;
    }

    public void setContatoProv(String contatoProv) {
        this.contatoProv = contatoProv;
    }

    public String getCelullarProv() {
        return celullarProv;
    }

    public void setCelullarProv(String celullarProv) {
        this.celullarProv = celullarProv;
    }

    public String getFijoProv() {
        return fijoProv;
    }

    public void setFijoProv(String fijoProv) {
        this.fijoProv = fijoProv;
    }
}
