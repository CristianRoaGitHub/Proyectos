/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crisoftware.vo;

import java.util.Date;

/**
 *
 * @author CROA
 */
public class HistorialVo {

    private String identificacion;
    private String nombrePaciente;
    private String servicio;
    private double precio;
    private String nombreDoctor;
    private String fecha;

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getNombrePaciente() {
        return nombrePaciente;
    }

    public void setNombrePaciente(String nombrePaciente) {
        this.nombrePaciente = nombrePaciente;
    }

    public String getServicio() {
        return servicio;
    }

    public void setServicio(String servicio) {
        this.servicio = servicio;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getNombreDoctor() {
        return nombreDoctor;
    }

    public void setNombreDoctor(String nombreDoctor) {
        this.nombreDoctor = nombreDoctor;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public HistorialVo() {
    }

    public HistorialVo(String identificacion, String nombrePaciente, String servicio, double precio, String nombreDoctor, String fecha) {
        this.identificacion = identificacion;
        this.nombrePaciente = nombrePaciente;
        this.servicio = servicio;
        this.precio = precio;
        this.nombreDoctor = nombreDoctor;
        this.fecha = fecha;
    }
    
    
    
   

}
