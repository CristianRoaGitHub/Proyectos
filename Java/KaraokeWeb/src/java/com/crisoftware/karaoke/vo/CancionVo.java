/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crisoftware.karaoke.vo;



/**
 *
 * @author CROA
 */
public class CancionVo {
private int id;
private int idCategoria;
private String imagenArtista;
private String nombreArtista;
private String nombreCancion;
private double duracionCancion;

    public CancionVo(int id, int idCategoria, String imagenArtista, String nombreArtista, String nombreCancion, double duracionCancion) {
        this.id = id;
        this.idCategoria = idCategoria;
        this.imagenArtista = imagenArtista;
        this.nombreArtista = nombreArtista;
        this.nombreCancion = nombreCancion;
        this.duracionCancion = duracionCancion;
    }

    public CancionVo() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getImagenArtista() {
        return imagenArtista;
    }

    public void setImagenArtista(String imagenArtista) {
        this.imagenArtista = imagenArtista;
    }

    public String getNombreArtista() {
        return nombreArtista;
    }

    public void setNombreArtista(String nombreArtista) {
        this.nombreArtista = nombreArtista;
    }

    public String getNombreCancion() {
        return nombreCancion;
    }

    public void setNombreCancion(String nombreCancion) {
        this.nombreCancion = nombreCancion;
    }

    public double getDuracionCancion() {
        return duracionCancion;
    }

    public void setDuracionCancion(double duracionCancion) {
        this.duracionCancion = duracionCancion;
    }




    

}
