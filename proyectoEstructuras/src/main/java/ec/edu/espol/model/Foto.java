/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.model;

import java.util.Date;

/**
 *
 * @author Melanie
 */
public class Foto {
    private String descripcion;
    private String lugar;
    private Date fecha;
    private String personas;

    public Foto(String descripcion, String lugar, Date fecha, String personas) {
        this.descripcion = descripcion;
        this.lugar = lugar;
        this.fecha = fecha;
        this.personas = personas;
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

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getPersonas() {
        return personas;
    }

    public void setPersonas(String personas) {
        this.personas = personas;
    }
    
    
    
}

