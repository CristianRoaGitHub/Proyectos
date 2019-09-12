package com.crisoft.aplicacionjsf.beans;

import com.crisoft.aplicacionjsf.conexion.Conexion;
import com.crisoft.aplicacionjsf.modelos.Persona;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;

/**
 *
 * @author ACER
 */
@ManagedBean
@RequestScoped
public class PersonaBean extends Conexion {

    private String mensaje;
    private Persona persona = new Persona();
    private static List<Persona> lstPersona = new ArrayList(); // static se utiliza para llama de base de datos
    

    public PersonaBean() {
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public List<Persona> getLstPersona() {
        return lstPersona;
    }

    public void setLstPersona(List<Persona> lstPersona) {
        PersonaBean.lstPersona = lstPersona;
    }

    public void agregarPersona() {
        PersonaBean.lstPersona.add(this.persona);
    }

    public void eliminarPersona(Persona per) {
        PersonaBean.lstPersona.remove(per);
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public void validar(FacesContext context, UIComponent toValidate, Object value) {
        context = FacesContext.getCurrentInstance();
        String texto = value.toString();
        if (!texto.equalsIgnoreCase("M") && !texto.equalsIgnoreCase("F")) {
            ((UIInput) toValidate).setValid(false);
            context.addMessage(toValidate.getClientId(), new FacesMessage("Sexo no valido"));
        }
    }

    public String guardarPersona() {
                
        boolean respuesta = registrarPersonaBD((ArrayList<Persona>) PersonaBean.lstPersona);
        
        if (respuesta) {
            this.mensaje = "Su registro es satisfactorio";
        } else {
            this.mensaje = "Hubo un error al registrar";
        }
        return this.mensaje;
    }

    /**
    public boolean registrarPersonaBD(Persona vo){
     try {
     conectar();
     //ArrayList<Persona> miLista;
     String insertar ="INSERT INTO persona (cedulapersona, nombrepersona, apellidopersona, edadpersona, sexopersona, correopersona)"
     + "VALUES (?,?,?,?,?,?)";
     sentencia = con.prepareStatement(insertar);
     sentencia.setString(1, vo.getCedula());
     sentencia.setString(2, vo.getNombre());
     sentencia.setString(3, vo.getApellido());
     sentencia.setInt(4, vo.getEdad());
     sentencia.setString(5, vo.getSexo());
     sentencia.setString(6, vo.getCorreo());
     int rta = sentencia.executeUpdate();
     desconectar();
     if (rta==1) {
     System.out.println("Se registro satisfactoriamente");
     return true;
     }else{
     System.err.println("No registro ");
     return false;
     }
     } catch (SQLException e) {
     System.err.println("Error en Clase PersonaBean, Metodo registrarPersonaBD");
     }
     return true;
     }
    */
    
    public boolean registrarPersonaBD(ArrayList<Persona> listaPersonasvo) {
        try {
            conectar();
           
            String insertar = "INSERT INTO persona (cedulapersona, nombrepersona, apellidopersona, edadpersona, sexopersona, correopersona)"
                    + "VALUES (?,?,?,?,?,?)";
            //System.out.println("hay "+listaPersonasvo.size());
            sentencia = con.prepareStatement(insertar);
            int rta=0;
            for (int i = 0; i < listaPersonasvo.size(); i++) {
             //   System.out.println("Registos: " +listaPersonasvo.get(i).getCedula());
                sentencia.setString(1, listaPersonasvo.get(i).getCedulapersona());
                sentencia.setString(2, listaPersonasvo.get(i).getNombrepersona());
                sentencia.setString(3, listaPersonasvo.get(i).getApellidopersona());
                sentencia.setInt(4, listaPersonasvo.get(i).getEdadpersona());
                sentencia.setString(5, listaPersonasvo.get(i).getSexopersona());
                sentencia.setString(6, listaPersonasvo.get(i).getCorreopersona());
                rta = sentencia.executeUpdate();    
            }
            desconectar();
            if (rta == 1) {
                System.out.println("Se registro satisfactoriamente el usuario");
                return true;
            } else {
                desconectar();
                System.err.println("No registro ");
                return false;
            }
        } catch (SQLException e) {
            desconectar();
            System.err.println("Error en Clase PersonaBean, Metodo registrarPersonaBD" + e);
        }
        return true;

    }

    /** 
     public String leer(Persona persona) {
        this.persona = persona;
        return "editar";
    }*/

    /**public boolean modificarPersonaBD(Persona vo) {
        try {
            conectar();
            String modificar = "UPDATE persona SET (nombrepersona = ?, apellidopersona=?, edadpersona=?, sexopersona=?, correopersona=?)"
                    + "WHERE (cedulapersona = ?)";
            sentencia = con.prepareStatement(modificar);
            sentencia.setString(1, vo.getNombre());
            sentencia.setString(2, vo.getApellido());
            sentencia.setInt(3, vo.getEdad());
            sentencia.setString(4, vo.getSexo());
            sentencia.setString(5, vo.getCorreo());
            sentencia.setString(6, vo.getCedula());
            int rta = sentencia.executeUpdate();
            desconectar();
            if (rta == 1) {
                System.out.println("Se actualizo satisfactoriamente");
                return true;
            } else {
                System.err.println("No se actualizo ");
                return false;
            }
        } catch (SQLException e) {
            System.err.println("Error en Clase PersonaBean, Metodo modificarPersonaBD");
        }
        return true;
    }*/

    public List<Persona> obtenerPersonasBD(){
        ArrayList<Persona> personitas = new ArrayList<>();
        try {
            
            conectar();
            String consultar = "SELECT * FROM persona";
            sentencia = con.prepareStatement(consultar);
            resultado = sentencia.executeQuery();
            while (resultado.next()) {
                Persona per =new Persona();                
                per.setCedulapersona(resultado.getString("cedulapersona"));
                per.setNombrepersona(resultado.getString("nombrepersona"));
                per.setApellidopersona(resultado.getString("apellidopersona"));
                per.setEdadpersona(Integer.parseInt(resultado.getString("edadpersona")));
                per.setSexopersona(resultado.getString("sexopersona"));
                per.setCorreopersona(resultado.getString("correopersona"));
                personitas.add(per);
            }
            desconectar();
        } catch (SQLException e) {
            System.err.println("Error en PersonaBean, obtenerPersonasBD()");
        }
        
        
        return personitas;
    }
    
}
