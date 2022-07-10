/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.model;

import Estructuras.LinkedList;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author Melanie
 */
public class Foto implements Serializable{
     static final long serialVersionUID = 1L;
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
        return lista;
    }
    
    
     public static void serializar(LinkedList<Foto> lista,String archivo){
        try(FileOutputStream fout = new FileOutputStream(archivo)){
            try(ObjectOutputStream out = new ObjectOutputStream(fout)){
            out.writeObject(lista);
            }   
        }catch(IOException e){
                System.out.println(e);
        }
    }

    public static LinkedList<Foto> leer(String nomfile){
        LinkedList<Foto> fotos = new LinkedList<>();
        try(Scanner sc = new Scanner(new File(nomfile))){
            while (sc.hasNextLine())
            {
                String linea = sc.nextLine();
                String[] tokens = linea.split("\\|");
                
                if (tokens.length==5){
                    String personas = tokens[3];
                    String [] lista= personas.split(",");
                    LinkedList<String> nombres = new LinkedList<String>();
                    for(int i=0; i<lista.length;i++)
                        nombres.addLast(lista[i]);
        
                Foto a = new Foto(tokens[0],tokens[1],
                    tokens[2],nombres,tokens[4]);
                    
                    fotos.addLast(a);
                }
                
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        return fotos;
    

    


}
    public void guardarFoto(String nombreArch){
        try(FileWriter fw = new FileWriter(nombreArch,true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter out=new PrintWriter(bw);
            ){
            out.println(this.toString());
            
        }catch(Exception e){
            System.out.println("No se pudo crear el archivo");
        }
    }

    @Override
    public String toString() {
        return this.descripcion;
    }
     
    
    
}

