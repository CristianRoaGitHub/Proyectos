/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crisoft.sistemacomercializadora.dao;

import com.crisoft.sistemacomercializadora.modelos.Categoria;
import java.util.List;

/**
 *
 * @author ACER
 */
public interface ICategoriaDao {
    // Aqui se escribe los metodos que va a tener esta interfaz
    public List<Categoria> listAll();
}
