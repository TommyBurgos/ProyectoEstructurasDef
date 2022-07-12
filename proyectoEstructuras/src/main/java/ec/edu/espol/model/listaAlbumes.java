/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.model;

import Estructuras.LinkedList;
import Estructuras.LinkedList.Node;

/**
 *
 * @author tommy_Burgos
 */
public class listaAlbumes {
    private LinkedList<Album> misAlbumes= new LinkedList<>();

    public listaAlbumes() {
        this.misAlbumes=new LinkedList<>();
    }
    public void addAlbum(Album album){
        misAlbumes.addFirst(album);
    }
    public int size(){
        return misAlbumes.getSize();
    }
    public Album get(int i){
       return misAlbumes.get(i);
    }

    public LinkedList<Album> getMisAlbumes() {
        return misAlbumes;
    }

    public void setMisAlbumes(LinkedList<Album> misAlbumes) {
        this.misAlbumes = misAlbumes;
    }

    
    
}
