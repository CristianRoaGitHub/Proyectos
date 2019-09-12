/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crisoft.restaurante.control;

import com.crisoft.restaurante.vo.Usuario;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author CROA
 */
@ManagedBean
@RequestScoped
public class BienvenidosController {

    public void verificarSession() {
        try {

            FacesContext context = FacesContext.getCurrentInstance();
            Usuario usu = (Usuario) context.getExternalContext().getSessionMap().get("usuariosesion");
            if (usu == null) {
                context.getExternalContext().redirect("../../validacion/permisos.xhtml");
            }
        } catch (Exception e) {
            System.out.println("Error en PlantillaSessionBean, Metodo verificarSession()" + e);
        }
    }

//    public String mostrarUsuarioLogeado() {
//        Login usu = (Login) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuariosesion");
//        return usu.getNombreusuario();
//    }
    

    public String cerrarSession() {
        FacesContext context = FacesContext.getCurrentInstance();
        Usuario usu = (Usuario) context.getExternalContext().getSessionMap().get("usuariosesion");
        String redireccion ="";
        System.out.println("Si hay usuario " + usu.getUsuNombreUsu());
        if (usu != null) {
            FacesContext.getCurrentInstance().getExternalContext().invalidateSession();    
             redireccion = "/index?faces-redirect=true";
        }
        return redireccion;
    }
}
