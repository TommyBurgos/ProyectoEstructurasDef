/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Estructuras;

/**
 *
 * @author tommy_Burgos
 */
public class CircleList<E> {
    Node<E> tail;

    public CircleList() {
        tail=null;
    }
    public boolean isEmpty(){
        return tail==null;
    }
    public boolean add(E dato){
        Node<E> nuevo= new Node(dato);
        if(tail!=null){
            nuevo.next=tail.next;
            tail.next=nuevo;
        }tail=nuevo;
        return true;
    }
    public boolean remove(E dato){
        Node<E> actual;
        boolean encontrado=false;
        actual=tail;
        while(actual.next!=tail && !encontrado){
            encontrado=(actual.next.dato== dato);
            if(!encontrado){
                actual=actual.next;
            }
        }if(encontrado){
            Node<E> aux=actual.next;
            if(tail==tail.next){
                tail=null;
            }else{
                if(aux==tail){
                    tail=actual;
                }actual.next=aux.next;
            }aux=null;
        }return encontrado;
    }
    @Override
    public String toString() {
         Node<E> aux=tail.next;
        String cadena="";
        do{
            cadena=cadena+"["+aux.dato+"]->";
        }while(aux!=tail.next);
        return cadena;
    }

    
    public class Node<E>{
        private E dato;
        Node<E> next;
    
        public Node(E dato){
            this.dato=dato;
            next=this;
        }
    }
}
