/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crisoft.restaurante.dao;

import com.crisoft.restaurante.conexion.Conexion;
import com.crisoft.restaurante.vo.Menu;
import com.crisoft.restaurante.vo.MenuRelSubmenu;
import com.crisoft.restaurante.vo.MenuRelacionSubmenu;
import com.crisoft.restaurante.vo.Submenu;
import com.crisoft.restaurante.vo.Usuario;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author CROA
 */
public class MenuRelacionSubmenuDao extends Conexion {

    public List<MenuRelacionSubmenu> ListaMenuSubmenu() {
        List<MenuRelacionSubmenu> listica = new ArrayList<MenuRelacionSubmenu>();
        try {

            conectar();
            String consultar = "SELECT m.*, rms.*, s.*"
                    + "FROM menu m INNER JOIN menu_rel_submenu rms ON m.men_codigo = rms.rel_id_menu"
                    + " INNER JOIN submenu s ON rms.rel_id_submenu = s.subm_id";
            sentencia = con.prepareStatement(consultar);
            resultado = sentencia.executeQuery();
            Usuario usu = new Usuario();

            while (resultado.next()) {
                Menu m = new Menu();
                MenuRelSubmenu rms = new MenuRelSubmenu();
                Submenu s = new Submenu();
                MenuRelacionSubmenu mrsVo = new MenuRelacionSubmenu();

                m.setMenCodigo(resultado.getInt("men_codigo"));
                m.setMenNombre(resultado.getString("men_nombre"));
                m.setMenTipo(resultado.getString("men_tipo"));
                usu.setUsuIdAuto(resultado.getInt("men_usu_id_auto"));
                m.setMenUsuIdAuto(usu);

                s.setSubmId(resultado.getInt("subm_id"));
                s.setSubmTipo(resultado.getString("subm_tipo"));
                s.setSubmNombre(resultado.getString("subm_nombre"));
                s.setSubmUrl(resultado.getString("subm_url"));

                rms.setRelIdMenusubmenu(resultado.getInt("rel_id_menusubmenu"));
                rms.setRelIdMenu(m);
                rms.setRelIdSubmenu(s);
                rms.setRelDescripcionSunmenu(resultado.getString("rel_descripcion_sunmenu"));

                /*System.out.println("id menu " + m.getMenCodigo());
                System.out.println("id rel menu " + rms.getRelIdMenu().getMenCodigo());
                System.out.println("id rel submenu " + rms.getRelIdSubmenu().getSubmId());
                System.out.println("id menu " + s.getSubmId());*/
                if ((m.getMenCodigo().equals(rms.getRelIdMenu().getMenCodigo()) && (rms.getRelIdSubmenu().getSubmId().equals(s.getSubmId())))) {
                    mrsVo.setMenu(m);
                    mrsVo.setMenurelsubmenu(rms);
                    mrsVo.setSubmenu(s);
                    listica.add(mrsVo);
                }
            }
            desconectar();
        } catch (SQLException e) {
            System.err.println("Error en MenuBean, miListaMenu() " + e);
        }
        return listica;
    }

    public List<MenuRelacionSubmenu> listaMenu() {
        List<MenuRelacionSubmenu> listica = new ArrayList<MenuRelacionSubmenu>();
        try {
            conectar();
            String consultar = "SELECT m.* FROM menu m";
            sentencia = con.prepareStatement(consultar);
            resultado = sentencia.executeQuery();
            Usuario usu = new Usuario();

            while (resultado.next()) {
                Menu m = new Menu();

                MenuRelacionSubmenu mrsVo = new MenuRelacionSubmenu();

                m.setMenCodigo(resultado.getInt("men_codigo"));
                m.setMenNombre(resultado.getString("men_nombre"));
                m.setMenTipo(resultado.getString("men_tipo"));
                usu.setUsuIdAuto(resultado.getInt("men_usu_id_auto"));
                m.setMenUsuIdAuto(usu);

                mrsVo.setMenu(m);
                listica.add(mrsVo);

            }
            desconectar();
        } catch (SQLException e) {
            System.err.println("Error en MenuBean, ListaMenu() " + e);
        }
        return listica;
    }

    public List<MenuRelacionSubmenu> listaSubmenu( int idMenu) {
        List<MenuRelacionSubmenu> listica = new ArrayList<MenuRelacionSubmenu>();
        try {

            conectar();
            String consultar = "SELECT rms.*, s.*"
                    + " FROM menu_rel_submenu rms"
                    + " INNER JOIN submenu s ON rms.rel_id_submenu = s.subm_id"
                    + " WHERE rel_id_menu = " + idMenu;
            sentencia = con.prepareStatement(consultar);
            resultado = sentencia.executeQuery();

            while (resultado.next()) {
                Menu m = new Menu();
                MenuRelSubmenu rms = new MenuRelSubmenu();
                Submenu s = new Submenu();
                MenuRelacionSubmenu mrsVo = new MenuRelacionSubmenu();

                s.setSubmId(resultado.getInt("subm_id"));
                s.setSubmTipo(resultado.getString("subm_tipo"));
                s.setSubmNombre(resultado.getString("subm_nombre"));
                s.setSubmUrl(resultado.getString("subm_url"));

                rms.setRelIdMenusubmenu(resultado.getInt("rel_id_menusubmenu"));
                m.setMenCodigo(resultado.getInt("rel_id_menu"));
                rms.setRelIdMenu(m);
                s.setSubmId(resultado.getInt("rel_id_submenu"));
                rms.setRelIdSubmenu(s);
                rms.setRelDescripcionSunmenu(resultado.getString("rel_descripcion_sunmenu"));

                if (rms.getRelIdSubmenu().getSubmId().equals(s.getSubmId())) {

                    mrsVo.setMenurelsubmenu(rms);
                    mrsVo.setSubmenu(s);
                    listica.add(mrsVo);
                }
            }
            desconectar();
        } catch (SQLException e) {
            System.err.println("Error en MenuBean, listaSubmenu() " + e);
        }
        return listica;
    }
}
