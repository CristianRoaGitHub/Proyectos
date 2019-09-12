/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crisoft.restaurante.control;

import com.crisoft.restaurante.dao.UsuarioDao;
import com.crisoft.restaurante.vo.Usuario;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;


/**
 *
 * @author croa
 */

@ManagedBean
@RequestScoped

public class LoginController  {

    private UsuarioDao usuarioDao = new UsuarioDao();

    private Usuario usuario = new Usuario();

    private List<Usuario> usuarios;

    @PostConstruct
    public void init() {
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public String iniciarSession() {

        String redireccion = "";
        
        try {
            boolean rta = usuarioDao.iniciarSessionBD(usuario);
            if (rta) {
                //redireccion = "administrador/bienvenidoClient?faces-redirect=true";
                redireccion = "administrador/bienvenidoClient";
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuariosesion", usuario);
            } else {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Aviso", "Credenciales Incorrectas"));
            }
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Aviso", "Error!.." + e));
        }
        return redireccion;
    }

}
