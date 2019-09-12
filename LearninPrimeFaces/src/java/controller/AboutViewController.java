/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.primefaces.event.TabChangeEvent;

/**
 *
 * @author croa
 */
@Named(value = "aboutViewController")
@SessionScoped
public class AboutViewController implements Serializable {

    /**
     * Creates a new instance of AboutViewController
     */
    public AboutViewController() {
    }
    
    public void tabChangeHandler(TabChangeEvent e){
        FacesMessage msg = new FacesMessage("Activo tab" +e.getTab().getTitle(),"");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
}
