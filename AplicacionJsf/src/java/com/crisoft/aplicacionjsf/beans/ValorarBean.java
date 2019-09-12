/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crisoft.aplicacionjsf.beans;

import com.crisoft.aplicacionjsf.modelos.Nota;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

/**
 *
 * @author ACER
 */
@ManagedBean
@RequestScoped
public class ValorarBean implements Serializable{

    @Inject
    private ComentarBean comentarB;
    private Nota nota;
    
    public ValorarBean() {
    }
    
    public Nota getNota() {
        return nota;
    }

    public void setNota(Nota nota) {
        this.nota = nota;
    }

   public ComentarBean getComentarB() {
        return comentarB;
    }

    public void setComentarB(ComentarBean comentarB) {
        this.comentarB = comentarB;
    }
    
    
    @PostConstruct
    public void init(){
        try { 
            System.out.println("Valor es: " + comentarB.getNota());
            
        } catch (Exception e) {
            System.err.println("Error en ValorarBean, Metodo init " + e);
        }
    }
    
    public void insertarComentario(){
            try {
                String actualizar = "";
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso","Se ingreso un comentario"));
            } catch (Exception e) {
                System.out.println("Error en la clase ValorarBean, Metodos insertarComentario " + e);
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Aviso","Error!!! comentario"));
            } finally{
                //Aprender Flash Scope
                FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
                
            }
    }
    
}
