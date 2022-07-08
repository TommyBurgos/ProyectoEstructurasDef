/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.model;

import Estructuras.LinkedList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

/**
 *
 * @author Melanie
 */
public class Foto {
    private String descripcion;
    private String lugar;
    private Date fecha;
    private LinkedList<String> personas;
    private String rutaFoto;

    public Foto(String descripcion, String lugar, Date fecha, LinkedList<String> personas, String rutaFoto) {
        this.descripcion = descripcion;
        this.lugar = lugar;
        this.fecha = fecha;
        this.personas = personas;
        this.rutaFoto=rutaFoto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public Date getFecha() {
        return fecha;
    }
    public String getRutaFoto() {
        return rutaFoto;
    }
    
    
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public LinkedList<String> getPersonas() {
        return personas;
    }

    public void setPersonas(LinkedList<String> personas) {
        this.personas = personas;
    }



    

    public void setRutaFoto(String rutaFoto) {
        this.rutaFoto = rutaFoto;
    }
    
    public static ArrayList<String> atributos(){
        ArrayList<String> lista = new ArrayList(Arrays.asList("Descripción","Lugar","Fecha"));
        return lista;}
    
    
}

