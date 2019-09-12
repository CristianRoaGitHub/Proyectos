/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crisoft.restaurante.vo;

/**
 *
 * @author croa
 */
public class MenuRelacionSubmenu {
    private Menu menu;
    private MenuRelSubmenu menurelsubmenu;
    private Submenu submenu;

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public MenuRelSubmenu getMenurelsubmenu() {
        return menurelsubmenu;
    }

    public void setMenurelsubmenu(MenuRelSubmenu menurelsubmenu) {
        this.menurelsubmenu = menurelsubmenu;
    }

    public Submenu getSubmenu() {
        return submenu;
    }

    public void setSubmenu(Submenu submenu) {
        this.submenu = submenu;
    }
}
