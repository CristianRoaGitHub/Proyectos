package com.crisoft.aplicacionjsf.beans;

import com.crisoft.aplicacionjsf.conexion.Conexion;
import static com.crisoft.aplicacionjsf.conexion.Conexion.con;
import static com.crisoft.aplicacionjsf.conexion.Conexion.sentencia;
import com.crisoft.aplicacionjsf.modelos.Login;
import java.io.Serializable;
import java.sql.SQLException;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author ACER
 */
@ManagedBean
@RequestScoped
public class UsuarioBean extends Conexion implements Serializable{

    
    private Login usuario = new Login();
    private String mensaje;

    public Login getLogin() {
        return usuario;
    }

    public void setLogin(Login usuario) {
        this.usuario = usuario;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    
   public String iniciarSession(){

       String redireccion = null;
        try {
           boolean rta = iniciarSessionBD(usuario);
            if (rta) {
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuariosesion", usuario);
                //Para ver No ver la ruta de la navegacion (Redireccion Implicita)
               // redireccion="/paginas/principal";
                //Para ver la ruta de la navegacion (Redireccion Explicita)
                redireccion="/paginas/principal?faces-redirect=true";

            }else{
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Aviso","Credenciales Incorrectas"));
            }
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Aviso","Error!.."));
        }
        return redireccion;
    }
 
   public boolean iniciarSessionBD(Login vo) throws SQLException{
        boolean rta;
        try {
            conectar();
            String consulta ="SELECT * FROM login WHERE nombreusuario=? AND claveusuario=? AND estadousuario=1";
            sentencia= con.prepareStatement(consulta);
            sentencia.setString(1, vo.getNombreusuario());
            sentencia.setString(2, vo.getClaveusuario());
            resultado= sentencia.executeQuery();
            if (resultado.next()) {
                desconectar();
                rta = true;
            }else{
             desconectar();
             rta = false;
            }           
        
        } catch (SQLException e) {
            desconectar();
            System.err.println("Error en Clase LoginBean, Metodo iniciarSessionBD " + e);
            rta = false;
        }
        return rta;
        
    }
    public void registrar() {
        try {
            boolean rta = registrarLoginBD(this.usuario);
            if (rta) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Aviso","Registro Satisfactorio"));
            } else {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,"Aviso","Error :( "));
            }
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL,"Fatal","Error :( " + e));
        }
        //return this.mensaje;
    }
    public boolean registrarLoginBD(Login vo) {
        try {
            conectar();
            String insertar = "INSERT INTO login (nombreusuario, claveusuario, estadousuario, tipo)"
                    + "VALUES (?,?,?,?)";
            sentencia = con.prepareStatement(insertar);
            sentencia.setString(1, vo.getNombreusuario());
            sentencia.setString(2, vo.getClaveusuario());
            sentencia.setInt(3, vo.getEstadousuario());
            sentencia.setString(4, String.valueOf(vo.getTipo()));
            int rta = sentencia.executeUpdate();
            desconectar();
            if (rta == 1) {
                System.out.println("Se registro satisfactoriamente el usuario");
                return true;
            } else {
                System.err.println("No registro ");
                desconectar();
                return false;
            }
        } catch (SQLException e) {
            desconectar();
            System.err.println("Error en Clase LoginBean, Metodo registrarLoginBD " + e);
        }
        return true;
    }

    /*public String verificarDatos() {
     String msj = "";
     System.err.print("El nombre de usuario es " + usuario.getNombreLogin());
     System.err.print("La clave es " + usuario.getClave());
     if (usuario.getNombreLogin().equals("cris")) {
     if (usuario.getClave().equals("123")) {
     msj = "Si puede entrar a la otra pagina";
     } else {
     msj = "Error en autenticacion";
     }
     } else {
     msj = "Error en autenticacion";
     }
     return this.mensajeSesion = msj;

     }*/
}

