/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crisoft.restaurante.control;

import com.crisoft.restaurante.dao.PersonaUsuarioDao;
import com.crisoft.restaurante.vo.Persona;
import com.crisoft.restaurante.vo.PersonaUsuario;
import com.crisoft.restaurante.vo.Usuario;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;

/**
 *
 * @author croa
 * www.primefaces.org/showcase/ui/data/datatable/basic.xhtml
 */

@ManagedBean
@ViewScoped
public class PersonaUsuarioController implements Serializable{

    

    private PersonaUsuarioDao perUsuDao = new PersonaUsuarioDao();
    private List<PersonaUsuario> listaPersonasUsuario = new ArrayList<PersonaUsuario>();

    private Persona persona;
    private Usuario usuario;
    
    private String mensaje;
    private boolean accion;
    

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<PersonaUsuario> getListaPersonasUsuario() {
        return listaPersonasUsuario;
    }

    public void setListaPersonasUsuario(List<PersonaUsuario> listaPersonasUsuario) {
        this.listaPersonasUsuario = listaPersonasUsuario;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public boolean isAccion() {
        return accion;
    }

    public void setAccion(boolean accion) {
        this.accion = accion;
    }

    
    
    
    
    @PostConstruct
    public void init(){
        listaPersonasUsuario = perUsuDao.listaPersonasUsuariosBD("");
        setAccion(true);
    }
    
    
    
    
}