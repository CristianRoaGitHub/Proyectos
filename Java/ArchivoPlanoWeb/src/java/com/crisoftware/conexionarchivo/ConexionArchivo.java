/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crisoftware.conexionarchivo;

import com.crisoftware.vo.HistorialVo;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author CROA
 */
public class ConexionArchivo {

    public List<HistorialVo> leerArchivo(String rutaArchivo) {
        try {
            File ruta = new File(rutaArchivo);
            BufferedReader br = new BufferedReader(new FileReader(ruta));
            String linea;
            List<HistorialVo> listaHistorial = new ArrayList<>();
            while ((linea = br.readLine()) != null) {
                String [] campos = linea.split(",");
                HistorialVo his = new HistorialVo();
                //System.out.println(Arrays.toString(campos));
                his.setIdentificacion(campos[0]);
                his.setNombrePaciente(campos[1]);
                his.setServicio(campos[2]);
                his.setPrecio(Double.parseDouble(campos[3]));
                his.setNombreDoctor(campos[4]);
                his.setFecha((campos[5]));
                listaHistorial.add(his);
            }
            
            br.close();
            return listaHistorial;
        } catch (Exception e) {
            System.out.println("Error en la clase ConexionArchivo. Metodo leerArchivo " + e.getMessage());
            return null;
        }
    }
}
