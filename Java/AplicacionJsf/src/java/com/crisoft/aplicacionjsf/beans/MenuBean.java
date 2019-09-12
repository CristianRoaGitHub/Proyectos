package com.crisoft.aplicacionjsf.beans;



import com.crisoft.aplicacionjsf.conexion.Conexion;
import com.crisoft.aplicacionjsf.modelos.Login;
import com.crisoft.aplicacionjsf.modelos.Menu;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.primefaces.model.menu.BaseMenuModel;
import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSubMenu;
import org.primefaces.model.menu.MenuModel;



@ManagedBean
@SessionScoped
public final class MenuBean extends Conexion implements Serializable{

    
    private List<Menu> lista = new ArrayList<Menu>();
    private MenuModel model = new BaseMenuModel();
    //private String usuarioLogeado = null;
    @SuppressWarnings("unused") 
    private Login user = null;

    public Login getUser() {
        System.out.println("Entro a Get User");
        return (Login) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
    }

    public void setUser(Login user) {
        this.user = user;
    }

    

//    public String getUsuarioLogeado() {
//        Login us = (Login) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
//        usuarioLogeado = us.getNombreusuario();
//        return usuarioLogeado;
//    }
//
//    public void setUsuarioLogeado(String usuarioLogeado) {
//        this.usuarioLogeado = usuarioLogeado;
//    }

    public void listarMenus() {
        try {
            setLista(miListaMenu());
        } catch (Exception e) {
        }
    }

    public List<Menu> getLista() {
        return lista;
    }

    public void setLista(List<Menu> lista) {
        this.lista = lista;
    }


    
    public MenuBean() {
        listarMenus();
        model = new DefaultMenuModel();
        this.establecerPermisos();
    }

    public void establecerPermisos() {

        for (Menu m : lista) {
            if (m.getTipo().equals("S")) {
                DefaultSubMenu firstSubmenu = new DefaultSubMenu(m.getNombre());
                for (Menu i : lista) {
                    Menu submenu = i.getSubmenu();
                    
                    if (submenu != null) {
                        if (submenu.getCodigo() == m.getCodigo()) {
                            DefaultMenuItem item = new DefaultMenuItem(i.getNombre());
                            System.out.println("El item es " + i.getNombre());
                            item.setUrl(i.getUrl());
                            System.out.println("La url es " + i.getUrl());
                            firstSubmenu.addElement(item);
                        }
                    }
                }
                model.addElement(firstSubmenu);
            } else {
                if (m.getSubmenu() == null) {
                    DefaultMenuItem item = new DefaultMenuItem(m.getNombre());
                    item.setUrl(m.getUrl());
                    System.out.println("La url es " + m.getUrl());
                    model.addElement(item);
                }
            }
        }
    }

    public MenuModel getModel() {
        return model;
    }

    public void setModel(MenuModel model) {
        this.model = model;
    }

    public void cerrarSesion() {
        FacesContext.getCurrentInstance()
                .getExternalContext().invalidateSession();
    }

    
    public List<Menu> miListaMenu(){
        List<Menu> listica = new ArrayList<Menu>();
         try {
            
            conectar();
            String consultar = "SELECT * FROM menu";
            sentencia = con.prepareStatement(consultar);
            resultado = sentencia.executeQuery();
            while (resultado.next()) {
                Menu men =new Menu();
                men.setCodigo(resultado.getInt("codigo"));
                men.setNombre(resultado.getString("nombre"));
                men.setTipo(resultado.getString("tipo"));
                men.setTipoUsuario(resultado.getString("tipoUsuario"));
                men.setCodigoSubmenu(resultado.getShort("codigo_submenu"));
                men.setEstado(resultado.getBoolean("estado"));
                men.setUrl(resultado.getString("url"));
                listica.add(men);
            }
            desconectar();
        } catch (SQLException e) {
            System.err.println("Error en MenuBean, miListaMenu() " +e);
        }
        
        return listica;
    }
//    public String mostrarUsuarioLogeado() {
//        Usuario us
//                = (Usuario) FacesContext
//                        .getCurrentInstance()
//                        .getExternalContext()
//                        .getSessionMap()
//                        .get("usuario");
//        return us.getUsuario();
//    }
}

