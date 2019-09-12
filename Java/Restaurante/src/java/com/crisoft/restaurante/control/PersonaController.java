package com.crisoft.restaurante.control;

import com.crisoft.restaurante.dao.PersonaDao;
import com.crisoft.restaurante.dao.UsuarioDao;
import com.crisoft.restaurante.vo.Persona;
import com.crisoft.restaurante.vo.Usuario;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author croa
 */

/*
Arreglar campos
<p:inputMask id="txtTelefono" value="#{personaController.persona.perTelefono}" mask="(999) 999-9999" label="Telefono requerido"/>
<!--Arreglar o validar campo de corrreo-->
REalizar ejemplos
  www.adictosaltrabajo.com/tutoriales/conv-valid-jsf/

 */
@ManagedBean
@ViewScoped
public class PersonaController implements Serializable {

    private PersonaDao personaDao = new PersonaDao();
    private UsuarioDao usuarioDao = new UsuarioDao();

    private Persona persona;
    private Usuario usuario;

    @PostConstruct
    public void init() {
        persona = new Persona();
        usuario = new Usuario();
    }

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

    public String realizarRegistro() {
        String redireccion = "";
        try {
            boolean rtaPersona = personaDao.registrarPersonaBD(this.persona);

            if (rtaPersona) {
                usuario.setUsuPerIdCedula(persona);
                boolean rtaUsuario = usuarioDao.registrarUsuarioBD(this.usuario);
                if (rtaUsuario) {
                    //FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "Registro Exitoso"));
                    redireccion = "personaconsultacliente?faces-redirect=true";
                }
            }
        } catch (Exception e) {
            System.out.println("Error en clase PersonaController, metodo realizarRegistro() " + e);
        }
        return redireccion;
    }

    public String cancelar() {
        String redireccion = "";
        try {
            redireccion = "bienvenidoClient?faces-redirect=true";    
        } catch (Exception e) {
            System.out.println("Error en clase PersonaController, metodo cancelar() " + e);
        }
        return redireccion;
    }

}
