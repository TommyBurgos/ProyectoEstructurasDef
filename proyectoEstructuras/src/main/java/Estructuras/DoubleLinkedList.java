/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Estructuras;

import java.io.Serializable;

/**
 *
 * @author tommy_Burgos
 */
public class DoubleLinkedList<E> implements Serializable{
    static final long serialVersionUID = 1L;
    private Node<E> head;
    private Node<E> tail;

    public DoubleLinkedList() {
        head=tail=null;
    }
    //Esta vacia?
    public boolean isEmpty(){
        return head==null;
    }
    public void addLast(E dato){
        if(!isEmpty()){
            Node<E> nuevo=new Node(dato,null,tail);
            tail.next=nuevo;
            tail=nuevo;           
        }else{
            head=tail=new Node(dato);
        }
    }
    public void addFirst(E dato){
        if(!isEmpty()){
            Node<E> nuevo=new Node(dato,head,null);
            head.previous=nuevo;
            head=nuevo;
        }else{
            head=tail=new Node(dato);
        }
    }
    public Node<E> removeFirst(){
        Node<E> tmp=head;
        if(head==tail) head=tail=null;
        else{
            head=head.next;
            head.previous=null;
        }
        return tmp;
    }
    public Node<E> removeLast(){
        Node<E> tmp=tail;
        if(head==tail) head=tail=null;
        else{
            tail=tail.previous;
            tail.next=null;
        }
        return tmp;
    }

    @Override
    public String toString() {
        if(!isEmpty()){
            String datos="<=>";
            Node<E> aux=head;
            while(aux!=null){
                datos=datos + aux.dato+"<=>";
                aux=aux.next;
            }
            System.out.println(datos);
        
    }return " ";}
    
    
    public class Node<E>{
        private E dato;
        private Node<E> next;
        private Node<E> previous;
        
        
        public Node(E dato) {
            this.dato = dato;
            next=previous=null;
        }

        public Node( E dato,Node<E> next, Node<E> previous) {
            this.next = next;
            this.previous = previous;
            this.dato = dato;
        }

        public E getDato() {
            return dato;
        }

        public Node<E> getNext() {
            return next;
        }

        public Node<E> getPrevious() {
            return previous;
        }

        public void setDato(E dato) {
            this.dato = dato;
        }

        public void setNext(Node<E> next) {
            this.next = next;
        }

        public void setPrevious(Node<E> previous) {
            this.previous = previous;
        }
        
        
    }

    public Node<E> getHead() {
        return head;
    }

    public Node<E> getTail() {
        return tail;
    }

    public void setHead(Node<E> head) {
        this.head = head;
    }

    public void setTail(Node<E> tail) {
        this.tail = tail;
    }
    
}
