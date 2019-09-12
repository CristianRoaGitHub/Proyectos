/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crisoft.aplicacionjsf.beans;

import com.crisoft.aplicacionjsf.modelos.Login;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author ACER
 */
@ManagedBean
@RequestScoped

public class PlantillaSessionBean implements Serializable {

    /**
     * Creates a new instance of PlantillaSessionBean
     */
    public PlantillaSessionBean() {
    }

    public void verificarSession() {
        try {
            System.out.println("Si verifica la sesion");
            FacesContext context = FacesContext.getCurrentInstance();
            Login usu = (Login) context.getExternalContext().getSessionMap().get("usuariosesion");
            if (usu == null) {
                context.getExternalContext().redirect("./../paginas/permisos.xhtml");
            }
        } catch (Exception e) {
            System.out.println("Error en PlantillaSessionBean, Metodo verificarSession()" + e);
        }
    }

    public String mostrarUsuarioLogeado() {
        Login usu = (Login) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuariosesion");
        return usu.getNombreusuario();
    }
    
    public String cerrarSession() {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        String redireccion = "/login?faces-redirect=true";
        return redireccion;
    }

    
}
