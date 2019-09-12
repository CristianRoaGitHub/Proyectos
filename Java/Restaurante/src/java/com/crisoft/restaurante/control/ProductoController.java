/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crisoft.restaurante.control;

import com.crisoft.restaurante.dao.CategoriaDao;
import com.crisoft.restaurante.dao.ProductoDao;
import com.crisoft.restaurante.vo.CategoriaProducto;
import com.crisoft.restaurante.vo.Producto;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import javax.faces.view.ViewScoped;



/**
 *
 * @author croa
 * 
 * Falta lista tambien las categorias y tambien realizar filros por categoria
 */
@ManagedBean
@ViewScoped
public class ProductoController implements Serializable{

    /**
     * Creates a new instance of ProductoBean
     */
    private Producto producto = new Producto();
    
    private ProductoDao proDao = new ProductoDao();
    private CategoriaDao catDao = new CategoriaDao();
    
    
    private int codigoCat;
    private List<Producto> productos = new ArrayList<>();
    private List<CategoriaProducto> categorias = new ArrayList<>();
    
    @PostConstruct
    public void init(){
    
    productos=proDao.listaProductoBD(0,"");
    categorias=catDao.listaCategoriasBD(0);
    
    }
    
    
    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }
    
    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

    public int getCodigoCat() {
        return codigoCat;
    }

    public void setCodigoCat(int codigoCat) {
        this.codigoCat = codigoCat;
    }
    
    
    public List<CategoriaProducto> getCategorias() {
        return categorias;
    }

    public void setCategorias(List<CategoriaProducto> categorias) {
        this.categorias = categorias;
    }
    
    
    
    public void registrarProducto() {
        try {        
           proDao.registrarProducoBD(producto,codigoCat);
        } catch (Exception e) {
            System.err.println("Error aqui " + e);
        }
    }
}
