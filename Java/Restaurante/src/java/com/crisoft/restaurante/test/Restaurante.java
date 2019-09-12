/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crisoft.restaurante.test;

import com.crisoft.restaurante.control.DetalleVentaController;
import com.crisoft.restaurante.vo.DetalleVenta;
import com.crisoft.restaurante.vo.Persona;
import com.crisoft.restaurante.vo.Producto;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author croa
 */
public class Restaurante {

    public static void main(String[] args) throws SQLException, ParseException {

//        Conexion con = new Conexion();
//        con.conectar();
//        con.desconectar();
//        Date fecha = new Date(18, 4, 3);
        /*
        //Persona per = new Persona();
        PersonaDao perDao = new PersonaDao();
        per.setPerIdCedula("1019");
        per.setPerNombre("Cristian");
        per.setPerApellido("Roa");
        per.setPerGenero("M");
        per.setPerFechaNac(fecha);
        per.setPerCorreo("crisoffpring@hotmail.com");
        per.setPerTelefono(555555);
        List<Persona> lista = perDao.listaPersonaBD("1019");
        for (Persona persona : lista) {
        System.out.println("Identificacion es " + persona.getPerIdCedula());
        }*/
 /*        boolean rta = perDao.registrarPersonaBD(per);
        if (rta) {
         */
        //UsuarioDao usuDao = new UsuarioDao();
/*
        Usuario usu = new Usuario();
        usu.setUsuPerIdCedula(per);
        usu.setUsuNombreUsu("cris");
        usu.setUsuClave("123");
        usu.setUsuEstado(1);
        usu.setUsuTipo('A');
        usuDao.registrarUsuarioBD(usu);
        }
         */
 /*  List<Usuario> listausu = usuDao.listaUsuarioBD("");
        for (Usuario u : listausu) {
        System.out.println("Usuario " + u.getUsuNombreUsu());
        }
         */
 /*
        CategoriaProducto cat = new CategoriaProducto("Comidas");
        Producto pro = new Producto(1, "Aguila", 2000.00, "No tiene alcohol");
        CategoriaDao catDao = new CategoriaDao();
        ProductoDao proDao = new ProductoDao();
        catDao.registrarCategoriaBD(cat);
        proDao.registrarProducoBD(pro);
        List<CategoriaProducto> lista = catDao.listaCategoriasBD();
        for (CategoriaProducto l : lista) {
        System.out.println("test " + l.getCatIdAuto() +" " + l.getCatTipo());
        }*/
 /*       catPro.setCatIdAuto(4);
        catPro.setCatTipo("Desayunos");
        catPro.setCatDescripcion("Los mejores");
        catDao.actualizarCategoriaBD(catPro);*/
 /*
        catPro.setCatIdAuto(6);
        catDao.eliminarCategoriaBD(catPro);
         */
 /*try {
        UsuarioDao usuDao = new UsuarioDao();
        Usuario usu = new Usuario();
        usu.setUsuNombreUsu("cris");
        usu.setUsuClave("123");
        Usuario usuario = usuDao.iniciarSessionBD(usu);
        List<Usuario> lista = new ArrayList<Usuario>();
        lista.add(usuario);
        for (Usuario u : lista) {
        System.out.println("Los registros son " + u.getUsuPerIdCedula().getPerIdCedula());
        }
        } catch (Exception e) {
        e.printStackTrace();
        }*/
 /*   ProductoDao proDao = new ProductoDao();
        Producto pro = new Producto();
        //        CategoriaProducto cat = new CategoriaProducto();
        //        cat.setCatIdAuto(1);
        //
        //        pro.setProIdCat(cat);
        pro.setProNombre("Salsa de tomate Fruco");
        pro.setProPrecioProducto(2000.00);
        pro.setProObservacion("Es original");
        proDao.registrarProducoBD(pro,1);
        DetalleVentaDao detVenDao = new DetalleVentaDao();
        DetalleVenta detVenta = new DetalleVenta();
        Persona per = new Persona();
        per.setPerIdCedula("1019031");
        Producto pro = new Producto();
        pro.setProIdAuto(4);
        detVenta.setDetPerIdCedula(per);
        detVenta.setDetProIdAuto(pro);
        detVenta.setDetCantidadProducto(10);
        detVenDao.crearDetalleVentaBD(detVenta);
        VentaDao facDao = new VentaDao();
        ArrayList<Venta> listFac = new ArrayList<Venta>();
        DetalleVenta detV = new DetalleVenta();
        Venta fac = new Venta();
        detV.setDetIdAuto(1);
        fac.setVenDetIdAuto(detV);
        fac.setVenCantidadTotal(10);
        fac.setVenValorTotal(25000.00);
        Date facFecha = new Date();
        fac.setVenFecha(facFecha);
        fac.setVenObservacion("Nueva venta por consola");
        listFac.add(fac);   
        facDao.registrarVentaBD(listFac);
         */
 /*PersonaUsuarioDao perUsuDao = new PersonaUsuarioDao();
       
       
        List<PersonaUsuario> listaPerUsu = perUsuDao.listaPersonasUsuariosBD("1019");
        for (PersonaUsuario personaUsuario : listaPerUsu) {
            
            System.out.println("Los nombres son " +  personaUsuario.getPersona().getPerNombre());
            System.out.println("Los usuarios son " +  personaUsuario.getUsuario().getUsuNombreUsu());
        }      
         */
 /*
        PersonaDao perDao = new PersonaDao();
        Persona perVo = new Persona();
        perVo.setPerNombre("Al");
        perVo.setPerApellido("Quina");
        perVo.setPerGenero("M");
        Date fecha = new Date(18, 4, 3);
        perVo.setPerFechaNac(fecha);
        perVo.setPerCorreo("Alex@gmail.com");
        perVo.setPerTelefono(5553332);
        perDao.actualizarPersonaBD(perVo, "1019031");
         */
 /*MenuRelacionSubmenuDao menu = new MenuRelacionSubmenuDao();
        List<MenuRelacionSubmenu> listaMenuSubmenu = menu.ListaMenuSubmenu();
        for (MenuRelacionSubmenu menu1 : listaMenuSubmenu) {
            System.out.println("EL menu es " + menu1.getSubmenu().getSubmUrl());
        }*/
 
        Producto pro = new Producto();
        Producto pro2 = new Producto();
        
        pro.setProPrecioProducto(2000.0);
        pro2.setProPrecioProducto(1500.0);
        
        DetalleVentaController detalleVentaCon = new DetalleVentaController();
        
        DetalleVenta detalleVenta1 = new DetalleVenta();
        DetalleVenta detalleVenta2 = new DetalleVenta();
        
        
        detalleVenta1.setDetPrecioProducto(pro.getProPrecioProducto());
        
        detalleVenta1.setDetCantidadProducto(1);
        
        detalleVenta2.setDetPrecioProducto(pro2.getProPrecioProducto());
        
        detalleVenta2.setDetCantidadProducto(2);
        
        List<DetalleVenta> lista = new ArrayList<DetalleVenta>();
        
        lista.add(detalleVenta1);
        lista.add(detalleVenta2);
        
        //detalleVentaCon.setListaDetalleProductos(lista);
        
        //System.out.println("detalle " + detalleVentaCon.getListaDetalleProductos().size());
        
      //  detalleVentaCon.calcularVenta(lista);
        
        
        
    }
}

