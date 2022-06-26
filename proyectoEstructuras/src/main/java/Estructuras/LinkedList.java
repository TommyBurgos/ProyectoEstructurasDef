/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Estructuras;

/**
 *
 * @author tommy_Burgos
 */
public class LinkedList<E> {
    Node<E> head;
    Node<E> tail;

    public LinkedList() {
        head=null;
        tail=null;
    }
    public boolean isEmpty(){
        return head ==null;
    }
    public void addFirst(E e){
        if(isEmpty()){
            head=tail=new Node<E>(e);
        }else{
            head= new Node<E>(e,head);
        }
    }
    
    public void addLast(E e){
        Node<E> nuevo=new Node<E>(e);
        if(isEmpty()){
            head=tail=nuevo;
        }else{
            tail.next=nuevo;
            tail=nuevo;
        }
    }
    
    public class Node<E>{
        private E dato;
        private Node<E> next;

    public Node(E dato) {
        this.dato = dato;
        this.next=null;
    }

    public Node(E dato, Node<E> next) {
        this.dato = dato;
        this.next = next;
    }

        public E getDato() {
            return dato;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setDato(E dato) {
            this.dato = dato;
        }

        public void setNext(Node<E> next) {
            this.next = next;
        }
    
        
    
    }

    @Override
    public String toString() {
        Node<E> n= head;
        while(n!=null){
            System.out.print(n.dato+", ");
            n=n.next;
        }
        
        return "LinkedList{" + "head=" + head.dato + ", tail=" + tail.dato + '}';
    }
    
}
