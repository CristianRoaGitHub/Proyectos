/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crisoft.aplicacionjsf.beans;

import com.crisoft.aplicacionjsf.modelos.Categoria;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author ACER
 */
@ManagedBean
@RequestScoped
public class CategoriaBean {

    /**
     * Creates a new instance of CategoriaBean
     */
    
    private Categoria categoria = new Categoria();
    public CategoriaBean() {
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
    
    
    
}
