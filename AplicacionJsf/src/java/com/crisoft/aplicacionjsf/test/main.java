package com.crisoft.aplicacionjsf.test;

import com.crisoft.aplicacionjsf.beans.BuscarBean;
import com.crisoft.aplicacionjsf.beans.BuscarTelefonosBean;
import com.crisoft.aplicacionjsf.beans.ComentarBean;
import com.crisoft.aplicacionjsf.beans.MenuBean;
import com.crisoft.aplicacionjsf.beans.TelefonoBean;
import com.crisoft.aplicacionjsf.modelos.Menu;
import com.crisoft.aplicacionjsf.modelos.Nota;
import com.crisoft.aplicacionjsf.modelos.Persona;
import com.crisoft.aplicacionjsf.modelos.Telefono;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 *
 * @author ACER
 */
public class main {

    public static void main(String[] args) throws ParseException, Exception {

        /*ArrayList<Persona> persona = new ArrayList<>();
        
        PersonaBean perBean = new PersonaBean();
        Persona per = new Persona();
        
        per.setCedulapersona("111111111");
        per.setNombrepersona("Nelly1");
        per.setApellidopersona("Guerreo1");
        per.setEdadpersona(18);
        per.setSexopersona("F");
        per.setCorreopersona("Correo@email.com");
        
        persona.add(per);
        
        
        //perBean.registrarPersonaBD(persona);
        List<Persona> obtenerPersonasBD = perBean.obtenerPersonasBD();
        
        for (Persona obtenerPer : obtenerPersonasBD) {
//            System.out.println("Datos: " + obtenerPer.getCedula());
//            System.out.println("Datos: " + obtenerPer.getNombre());
//            System.out.println("Datos: " + obtenerPer.getApellido());
//            System.out.println("Datos: " + obtenerPer.getEdad());
//            System.out.println("Datos: " + obtenerPer.getSexo());
//            System.out.println("Datos: " + obtenerPer.getCorreo());
        }
        
        
        
        Login usu = new Login();
        UsuarioBean usuDao = new UsuarioBean();
        
        usu.setNombreusuario("cris");
        usu.setClaveusuario("123");
        //usu.setEstado(1);
        //usu.setTipo('A');
        //usuDao.registrarUsuarioBD(usu);
        //boolean rta = usuDao.iniciarSessionBD(usu);
        
        //System.out.println("La respuesta es " + rta);
        
        
        NotaBean cat = new NotaBean();
        
        List<Categoria> listaCat = cat.listaCategorias();
        
        for (Categoria liscat : listaCat) {
            System.out.println("Lista 1: " + liscat.getCodigo());
            System.out.println("Lista 2: " + liscat.getNombre());
            System.out.println("Lista 3: " + liscat.getEstado());
        }
        
        Nota nota = new Nota();
        nota.setCodigopersona("1019");
        nota.setCodigocategoria(1);
        nota.setEncabezado("Java PrimeFaces");
        nota.setCuerpo("Vamos con toda");
        NotaBean notaBean = new NotaBean();
        notaBean.registrarNotaBD(nota);
        
        ComentarBean com = new ComentarBean();
        List<Nota> consult = com.consulta();
        for (Nota cons : consult) {
            System.out.println("La consulta es " +cons.getEncabezado() + " "+ cons.getFecha());
        }
        
         
        String dateStr = "07/04/2018 00:00:00";
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

        Date date = formatter.parse(dateStr);
        
        BuscarBean busBean = new BuscarBean();
        List<Nota> buscar = busBean.buscar("1019", 1, date);
        
        for (Nota nota : buscar) {
                System.out.println("Test :" + nota.getCuerpo());
          }


         
        
        TelefonoBean tel = new TelefonoBean();
        List<Telefono> telef = tel.obtenerTelefonosBD();
        for (Telefono t : telef) {
            //System.out.println("telefonfos " + t.getCodigopersona() + " " +t.getNumerotel());
        }
        
        Telefono tel2 = new Telefono();
        tel2.setCodigopersona("1019");
        tel2.setNumerotel("3141233665");
        
    tel.registrarTelefonoBD(tel2);*/
        
       /* BuscarTelefonosBean bus = new BuscarTelefonosBean();
        List<Persona> list = bus.listarPersonasBD();
        for (Persona persona : list) {
            System.out.println("Lista " +persona.getNombrepersona());
        }*/
       
        /*MenuBean  menuBean = new MenuBean();
        List<Menu> miListaMenu = menuBean.miListaMenu();
        for (Menu menu : miListaMenu) {
            System.out.println("Valores " + menu.getUrl());
        }*/
              
    }
}
