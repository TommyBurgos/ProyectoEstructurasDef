/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.model;

import Estructuras.LinkedList;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author User
 */
public class Album {
    private File fichero=new File("albumes.data");
    private String descripcion;
    private String nombre;
    private LinkedList<Foto> fotos;
    ObjectOutputStream oos = null;

    public Album(String descripcion, String nombre, LinkedList<Foto> fotos) {
        this.descripcion = descripcion;
        this.nombre = nombre;
        this.fotos = fotos;
    }

    public Album() {
        this.descripcion="";
        this.nombre="Por defecto";
        this.fotos=new LinkedList<>();
    }

    public Album(String nombre) {
        this.nombre = nombre;
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
    
    public void createFile() throws FileNotFoundException, IOException{

        if(fichero.exists()){
            oos = new ObjectOutputStream(new FileOutputStream(fichero, true));

        }else{
            System.out.println("creando");
            oos = new ObjectOutputStream(new FileOutputStream(fichero));
        }
        
    }
    
    
    public void addFoto(Foto ft){
        fotos.addFirst(ft);
    }

    public File getFichero() {
        return fichero;
    }

    public void setFichero(File fichero) {
        this.fichero = fichero;
    }

    @Override
    public String toString() {
        return "Album{" + "fichero=" + fichero + ", descripcion=" + descripcion + ", nombre=" + nombre + ", fotos=" + fotos.toString2() + '}';
    }
    
    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
        Album alb=new Album();
        alb.createFile();
        System.out.println("hola Mundo");
    }
}
