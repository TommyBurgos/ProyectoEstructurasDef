/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.model;

import Estructuras.LinkedList;

/**
 *
 * @author User
 */
public class Album {
    private String descripcion;
    private String nombre;
    private LinkedList<Foto> fotos;

    public Album(String descripcion, String nombre, LinkedList<Foto> fotos) {
        this.descripcion = descripcion;
        this.nombre = nombre;
        this.fotos = fotos;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LinkedList<Foto> getFotos() {
        return fotos;
    }

    public void setFotos(LinkedList<Foto> fotos) {
        this.fotos = fotos;
    }
    
    
}
