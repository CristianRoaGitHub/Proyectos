/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crisoftware.karaoke.controlador;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

/**
 *
 * @author croa
 */
@ManagedBean
public class ControladorBean {

    private String txtNombreCategoria;
    private String txtDescripcionCategoria;
    
    private String txtNombreArtista;
    private String txtNombreCancion;
    private String txtRutaImagen;
    

    public String getTxtNombreCategoria() {
        return txtNombreCategoria;
    }

    public void setTxtNombreCategoria(String txtNombreCategoria) {
        this.txtNombreCategoria = txtNombreCategoria;
    }

    public String getTxtDescripcionCategoria() {
        return txtDescripcionCategoria;
    }

    public void setTxtDescripcionCategoria(String txtDescripcionCategoria) {
        this.txtDescripcionCategoria = txtDescripcionCategoria;
    }

    public String getTxtNombreArtista() {
        return txtNombreArtista;
    }

    public void setTxtNombreArtista(String txtNombreArtista) {
        this.txtNombreArtista = txtNombreArtista;
    }

    public String getTxtNombreCancion() {
        return txtNombreCancion;
    }

    public void setTxtNombreCancion(String txtNombreCancion) {
        this.txtNombreCancion = txtNombreCancion;
    }

    public String getTxtRutaImagen() {
        return txtRutaImagen;
    }

    public void setTxtRutaImagen(String txtRutaImagen) {
        this.txtRutaImagen = txtRutaImagen;
    }

    
    public ControladorBean() {

    }

    public void registrarCategoria() throws IOException {
        List<String> lista = new ArrayList<>();

        lista.add(txtNombreCategoria + ",");
        lista.add(txtDescripcionCategoria + "\n");

        boolean rta = crearArchivoCategoria(lista);
        if (rta) {
            this.txtNombreCategoria = null;
            this.txtDescripcionCategoria = null;
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Creacion Exitosa", "PrimeFaces Rocks."));

        }
    }

    public boolean crearArchivoCategoria(List<String> lista) throws IOException {
        boolean rta = true;
        try {

            String ruta = "C:\\Users\\croa\\Documents\\NetBeansProjects\\Proyectos\\Java\\KaraokeWeb\\web\\utilidades\\categorias.txt";
            File file = new File(ruta);
            FileWriter fw = new FileWriter(file, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);

            for (String l : lista) {
                pw.append(l);
            }
            pw.close();
            bw.close();
            return rta;
        } catch (Exception e) {
            System.out.println("Error en la clase ControladorBean " + e.getMessage());
            return rta = false;
        }
    }
    
    
    public void cargarImagen(FileUploadEvent e) throws IOException{
        String nombreImagen = e.getFile().getFileName();
        FacesMessage mensaje = new FacesMessage("Cargado "+nombreImagen,"");
        FacesContext.getCurrentInstance().addMessage(null, mensaje);
        UploadedFile file = e.getFile();
        InputStream input = file.getInputstream();
        String rutaDestino = "C:\\Users\\croa\\Documents\\NetBeansProjects\\Proyectos\\Java\\KaraokeWeb\\web\\utilidades\\imgcanciones";
        String rutaFinal=rutaDestino+"\\"+nombreImagen;
        System.out.println("Ruta "+ rutaFinal);
        setTxtRutaImagen(rutaFinal);
        Files.copy(input, new File(rutaDestino, nombreImagen).toPath());       
    }
    
    public void registrarCancion(){
        List<String> lista = new ArrayList<>();
        
        lista.add(txtNombreArtista+",");
        lista.add(txtNombreCancion+",");
        lista.add(getTxtRutaImagen()+"\n");
        
        boolean rta =crearArchivoCanciones(lista);
        if (rta) {
            this.txtNombreArtista=null;
            this.txtNombreCancion=null;
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Creacion de cancion", ""));
        }
        
        
    }
    
    public boolean crearArchivoCanciones(List<String> lista){
        boolean rta=true;
        try {
            String ruta ="C:\\Users\\croa\\Documents\\NetBeansProjects\\Proyectos\\Java\\KaraokeWeb\\web\\utilidades\\canciones.txt";
            File file = new File(ruta);
            FileWriter fw = new FileWriter(file,true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
            for (String l : lista) {
                pw.append(l);
            }
            pw.close();
            bw.close();
            
            return rta;
        } catch (Exception e) {
            return rta=false;
        }
    }
   
}
