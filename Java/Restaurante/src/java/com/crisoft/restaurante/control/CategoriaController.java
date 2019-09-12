/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crisoft.restaurante.control;

import com.crisoft.restaurante.dao.CategoriaDao;
import com.crisoft.restaurante.vo.CategoriaProducto;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;

import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;

/**
 *
 * @author croa
 */
@ManagedBean
@ViewScoped
public class CategoriaController implements Serializable {
    
    private CategoriaProducto categoria = new CategoriaProducto();
    private CategoriaProducto categoriaSelected;
    
    CategoriaDao catDao = new CategoriaDao();
    private List<CategoriaProducto> listaCategoria;
    
    
    
    private boolean accion;
    
    public List<CategoriaProducto> getListaCategoria() {
        return listaCategoria;
    }
    
    public void setListaCategoria(List<CategoriaProducto> listaCategoria) {
        this.listaCategoria = listaCategoria;
    }
    
    public CategoriaProducto getCategoria() {
        return categoria;
    }
    
    public void setCategoria(CategoriaProducto categoria) {
        this.categoria = categoria;
    }
    
    public CategoriaProducto getCategoriaSelected() {
        return categoriaSelected;
    }
    
    public void setCategoriaSelected(CategoriaProducto categoriaSelected) {
        
        this.categoriaSelected = categoriaSelected;
        
         System.out.println("1 Id de la categoria" + categoriaSelected.getCatIdAuto());
        System.out.println("1 nombre de la categoria " + categoriaSelected.getCatTipo());
        System.out.println("1 descripcion de la categoria " + categoriaSelected.getCatDescripcion());
        
    }


    

    public boolean isAccion() {
        return accion;
    }
    
    public void setAccion(boolean accion) {
        this.accion = accion;
    }
    
    public String registrarCategoria() {
        String redireccion="";
        try {
            
            CategoriaDao catDao = new CategoriaDao();
            boolean rta = catDao.registrarCategoriaBD(categoria);
            if (rta) {
                redireccion = "categoriaconsultarcliente?faces-redirect=true";
            }
        } catch (Exception e) {
            System.err.println("Hubo un error en CategoriaController, registrarCategoria()" + e);
        }
        return redireccion;
    }
    
    public String cancelar() {
        String redireccion = "";
        try {
            redireccion = "bienvenidoClient?faces-redirect=true";    
        } catch (Exception e) {
            System.out.println("Hubo un error en CategoriaController, cancelar() " + e);
        }
        return redireccion;
    }
    
    
    
    @PostConstruct
    public void init() {
        setAccion(true);
        listaCategoria = catDao.listaCategoriasBD(0);
        categoriaSelected = listaCategoria.get(0);
    }
    

    
    public void actualizarCategoria(CategoriaProducto categoria) {
        try {
             CategoriaDao catDao = new CategoriaDao();
            System.out.println("2 id de la categoria " + categoria.getCatIdAuto());
            System.out.println("2 nombre de la categoria " + categoria.getCatTipo());
            System.out.println("2 descripcion de la categoria " + categoria.getCatDescripcion());
            catDao.actualizarCategoriaBD(categoriaSelected);
        } catch (Exception e) {
            System.err.println("Hubo un error en CategoriaController, actualizarCategoria()" + e);
        }
    }
    
    public void eliminarCategoria(CategoriaProducto categoria) {
        try {
            if (accion==false) {
                System.out.println("Entro 1");
            CategoriaDao catDao = new CategoriaDao();
            int idCat =categoria.getCatIdAuto();
                System.out.println("id " + idCat);
            //catDao.eliminarCategoriaBD(categoria);
            }else{
                System.out.println("Entro 2");
            }
            
        } catch (Exception e) {
            System.err.println("Hubo un error en CategoriaController, eliminarCategoria()" + e);
        }
    }
    
}
