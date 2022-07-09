/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.model;

import Estructuras.LinkedList;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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
    private String fecha;
    private LinkedList<String> personas;
    private String rutaFoto;

    public Foto(String descripcion, String lugar, String fecha, LinkedList<String> personas, String rutaFoto) {
        this.descripcion = descripcion;
        this.lugar = lugar;
        this.fecha = fecha;
        this.personas = personas;
        this.rutaFoto=rutaFoto;
    }
    public Foto(String descripcion, String lugar, String fecha, LinkedList<String> personas) {
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

    public String getFecha() {
        return fecha;
    }
    public String getRutaFoto() {
        return rutaFoto;
    }
    
    
    public void setFecha(String fecha) {
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
        ArrayList<String> lista = new ArrayList(Arrays.asList("Descripción","Lugar","Fecha","Personas"));
        return lista;}
    
    
     public static void serializar(LinkedList<Foto> lista,String archivo){
        try(FileOutputStream fout = new FileOutputStream(archivo)){
            try(ObjectOutputStream out = new ObjectOutputStream(fout)){
            out.writeObject(lista);
            }   
        }catch(IOException e){
                System.out.println(e);
        }
    }
    
    public static LinkedList<Foto> leer(String archivo){
        LinkedList<Foto> lista = new LinkedList<>();
        try(ObjectInputStream in = new ObjectInputStream(new FileInputStream(archivo))){
            lista = (LinkedList<Foto>)in.readObject();
        }catch(Exception e){
            System.out.println(e);
        }
        return lista;
        
        
    }
     
    
    
}

