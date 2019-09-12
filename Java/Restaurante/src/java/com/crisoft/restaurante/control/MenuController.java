/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crisoft.restaurante.control;

import com.crisoft.restaurante.dao.MenuRelacionSubmenuDao;
import com.crisoft.restaurante.vo.MenuRelacionSubmenu;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;
import org.primefaces.model.menu.BaseMenuModel;
import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultSubMenu;
import org.primefaces.model.menu.MenuModel;

/**
 *
 * @author CROA
 */
@ManagedBean
@ViewScoped
public class MenuController implements Serializable {

    private MenuModel model = new BaseMenuModel();
    //private List<MenuRelacionSubmenu> listaMenuSubmenu = new ArrayList<MenuRelacionSubmenu>();
    private List<MenuRelacionSubmenu> listaMenu = new ArrayList<MenuRelacionSubmenu>();

    public MenuModel getModel() {
        return model;
    }

    public void setModel(MenuModel model) {
        this.model = model;
    }

    /*public List<MenuRelacionSubmenu> getListaMenuSubmenu() {
        return listaMenuSubmenu;
    }

    public void setListaMenuSubmenu(List<MenuRelacionSubmenu> listaMenuSubmenu) {
        this.listaMenuSubmenu = listaMenuSubmenu;
    }*/
    public List<MenuRelacionSubmenu> getListaMenu() {
        return listaMenu;
    }

    public void setListaMenu(List<MenuRelacionSubmenu> listaMenu) {
        this.listaMenu = listaMenu;
    }

    public MenuController() {
        listaMenusMetodo();
        model = new BaseMenuModel();
        this.verMenus();
    }

    public void listaMenusMetodo() {
        try {
            setListaMenu(listaMenusSubmenu());
        } catch (Exception e) {
        }
    }

    public List<MenuRelacionSubmenu> listaMenusSubmenu() {
        List<MenuRelacionSubmenu> listMenu = new ArrayList<>();
        try {

            MenuRelacionSubmenuDao menuRelSumenuDao = new MenuRelacionSubmenuDao();

            List<MenuRelacionSubmenu> ListaMenuSubmenu = menuRelSumenuDao.listaMenu();

            for (MenuRelacionSubmenu menuSubmenu : ListaMenuSubmenu) {
                listMenu.add(menuSubmenu);
            }

        } catch (Exception e) {
            System.out.println("Error en la clase MenuController, metodo listaMenus() " + e);
        }
        return listMenu;
    }

    public void verMenus() {
        MenuRelacionSubmenuDao menuRelSubmenuDao = new MenuRelacionSubmenuDao();
        for (MenuRelacionSubmenu m : listaMenu) {

            if (m.getMenu().getMenTipo().equals("M")) {
                DefaultSubMenu menuPrincipa = new DefaultSubMenu(m.getMenu().getMenNombre());
                List<MenuRelacionSubmenu> listaSubmenu = menuRelSubmenuDao.listaSubmenu(m.getMenu().getMenCodigo());

                for (MenuRelacionSubmenu s : listaSubmenu) {
                    if (s.getSubmenu().getSubmTipo().equals("S")) {
                        DefaultMenuItem item = new DefaultMenuItem(s.getSubmenu().getSubmNombre());
                        item.setUrl(s.getSubmenu().getSubmUrl());
                        menuPrincipa.addElement(item);
                    }
                }
                model.addElement(menuPrincipa);
            }

        }
    }
}
