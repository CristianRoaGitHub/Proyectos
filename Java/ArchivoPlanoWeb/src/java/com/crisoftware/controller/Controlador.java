/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crisoftware.controller;

import com.crisoftware.conexionarchivo.ConexionArchivo;
import com.crisoftware.vo.HistorialVo;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author CROA
 */
@ManagedBean
public class Controlador {

    private HistorialVo historiaVo = new HistorialVo();
    private List<HistorialVo> listaHistorial = new ArrayList<>();

    public List<HistorialVo> getListaHistorial() {
        return listaHistorial;
    }

    public void setListaHistorial(List<HistorialVo> listaHistorial) {
        this.listaHistorial = listaHistorial;
    }

    public void leer() {
        ConexionArchivo con = new ConexionArchivo();
        listaHistorial = con.leerArchivo("C:\\Users\\CROA\\Desktop\\Historial.txt");
    }
    
    

//    static public void main(String[] args) {
//        Controlador c = new Controlador();
//        c.leer();
//    }

}
