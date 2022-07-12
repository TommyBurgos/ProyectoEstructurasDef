/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.model;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.System.Logger;
import java.lang.System.Logger.Level;

/**
 *
 * @author tommy_Burgos
 */
public class paraSerializar {
    private File fichero=new File("albumes.data");
    ObjectOutputStream oos = null;
    Album album;
    

    
    public void writeAlbum(Album alb) throws IOException{
        oos.writeObject(alb);
        System.out.println(alb + " registrado.");
    }
    
    public void readContains(){
         
        System.out.println("*****************************\n"
                         + "**** Albumes existentes *****\n"+
                           "*****************************");
        
        try {       
           ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fichero));
           while (true) {
                album = (Album)ois.readObject();
                System.out.println(album.toString());
            }
        } catch (EOFException e) {
            System.out.println("[+] Ya no hay más albumes.");
        } catch(IOException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        
    }
    
     public void cargarAlbumesData(listaAlbumes listalb){
        
        try {
            if(fichero.exists()){
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fichero));
                while (true) {
                    album = (Album)ois.readObject();
                    listalb.addAlbum(album);                    
                }
            }
        } catch (EOFException e) {
            System.out.println("[+] No hay albumes por añadir.");
        } catch(IOException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        
    }
    public void createFile() throws FileNotFoundException, IOException{

        if(fichero.exists()){
            oos = new miObjectOutputStream(new FileOutputStream(fichero, true));

        }else{
            System.out.println("creando");
            oos = new ObjectOutputStream(new FileOutputStream(fichero));
        }
        
    }
   
    public void updateFile(listaAlbumes albuneS){
        
        try {
            fichero.delete();
            this.createFile();
            
            for (int i = 0; i < albuneS.size(); i++) {
                this.writeAlbum(albuneS.get(i));
            }
            
            
        } catch (IOException ex) {
            System.out.println("No se pudo actualizar");
        }
        
        
    }

    public Album getAlbum() {
        return album;
    }
    
    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
        paraSerializar o = new paraSerializar();
        
        o.createFile();
        o.readContains();
        System.out.println("hola Mundo");
    }
    
    
}
