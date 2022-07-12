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
    private String descripcion;
    private String lugar;
    private String fecha;
    private LinkedList<Persona> personas;
    private String rutaFoto;

    public Foto(String descripcion, String lugar, String fecha, LinkedList<Persona> personas, String rutaFoto) {
        this.descripcion = descripcion;
        this.lugar = lugar;
        this.fecha = fecha;
        this.personas = personas;
        this.rutaFoto=rutaFoto;
    }
    public Foto(String descripcion, String lugar, String fecha, LinkedList<Persona> personas) {
        this.descripcion = descripcion;
        this.lugar = lugar;
        this.fecha = fecha;
        this.personas = personas;
        
    }

    public Foto(String descripcion, String lugar, String fecha, String rutaFoto) {
        this.descripcion = descripcion;
        this.lugar = lugar;
        this.fecha = fecha;
        this.rutaFoto = rutaFoto;
    }

    public Foto(String descripcion, String lugar, String fecha) {
        this.descripcion = descripcion;
        this.lugar = lugar;
        this.fecha = fecha;
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

    public LinkedList<Persona> getPersonas() {
        return personas;
    }

    public void setPersonas(LinkedList<Persona> personas) {
        this.personas = personas;
    }
 

    public void setRutaFoto(String rutaFoto) {
        this.rutaFoto = rutaFoto;
    }
    
    public static ArrayList<String> atributos(){
        ArrayList<String> lista = new ArrayList(Arrays.asList("Descripción","Lugar","Fecha","Personas"));
        return lista;
    }
    
    public static void crearArchivoFoto(){
        try{
            File file = new File("fotos3.txt");
            file.createNewFile();
        }catch(Exception e){
            e.getMessage();
        }
    }    

  
    
    public static void registrarFoto(String archivo,String descripcion, String lugar, String fecha,LinkedList<Persona> personas, String ruta){
        try(FileWriter fw = new FileWriter(archivo,true);
        BufferedWriter bw = new BufferedWriter(fw);
        PrintWriter out = new PrintWriter(bw)){
            out.println(descripcion+","+lugar+","+fecha+","+personas.toString2().toString()+","+ruta);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }}
    
    
    
    
     public static void serializar(LinkedList<Foto> lista,String archivo){
        try(FileOutputStream fout = new FileOutputStream(archivo)){
            try(ObjectOutputStream out = new ObjectOutputStream(fout)){
            out.writeObject(lista);
            }   
        }catch(IOException e){
                System.out.println(e);
        }
    }
    
  /*  public static LinkedList<Foto> leer(String archivo){
       
        LinkedList<Foto> lista = new LinkedList<>();
        try(ObjectInputStream in = new ObjectInputStream(new FileInputStream(archivo))){
            lista = (LinkedList<Foto>)in.readObject();
        }catch(Exception e){
            System.out.println(e);
        }
            return lista;
       
   */     
        
   public static LinkedList<Foto> leer(String nomfile){
       File f = new File(nomfile);
       if(f.exists())System.out.println("Existe");
       else{
           System.out.println("no Existe");
       }
        LinkedList<Foto> fotos = new LinkedList<>();
        try(Scanner sc = new Scanner(new File(nomfile))){
            while (sc.hasNextLine())
            {
                String linea = sc.nextLine();               
                String[] tokens = linea.split(",");
                
                
                    String personas = tokens[3];
                    String [] lista= personas.split("$");
                    LinkedList<Persona> nombres = new LinkedList<>();
                    for(int i=0; i<lista.length;i++){
                        
                        Persona pn = new Persona(lista[i]);
                        nombres.addLast(pn);
                    }
        
                    Foto a = new Foto(tokens[0],tokens[1],
                    tokens[2],nombres,tokens[4]);
                    
                    fotos.addLast(a);
                
                Foto b = new Foto(tokens[0],tokens[1],tokens[2],tokens[4]);
                System.out.println(b.getRutaFoto());
                fotos.addFirst(b);
                
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        return fotos;
}
}

