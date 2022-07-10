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
public class LinkedList<E> implements Serializable {
    static final long serialVersionUID = 1L;
    Node<E> head;
    Node<E> tail;
    
    public E getFirst() {
        return head.getDato();
    }

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
    public Node<E> removeFirst(){
        Node<E> nuevo = head;
        if(head==null) return null;
        if(head==tail){
            head=tail=null;
        }else{
            head= nuevo.next;
        }
            return nuevo;
    }
    public Node<E> removeLast(){
        Node<E> nuevo = tail;
        if(head==tail)head=tail=null;
        else{
            Node<E> tmp = head;
            while(tmp.next!=tail){
                tmp=tmp.next;
            }
        tail=tmp;
        }tail.next=null;
        return nuevo;
    }
    public Node<E> remove(E dato){
        if(isEmpty()) return null;
        Node<E> anterior=head;
        Node<E> tmp=head.next;
        if(head==tail && head.dato==dato){
                head=tail=null;
                return head;
        }else if(dato==head.dato){
                head=head.next;
                return head;
                
        }else{    
            while(tmp!=null && tmp.dato!=dato){            
                anterior=anterior.next;
                tmp=tmp.next;
            }
            if(tmp!=null){
                anterior.next=tmp.next;
                if(tmp==tail){
                    tail=anterior;
                }
            }
            }
        
        return tmp;
    }
    public E get(int index) {
        if (index < 0)
			return null;
		Node n = null;
		if (head != null) {
			n = head.getNext();
			for (int i = 0; i < index; i++) {
				if (n.getNext() == null)
					return null;
 
				n = n.getNext();
			}
			return (E) n.getDato();
		}
		return (E) n.getDato();
    }
    public boolean search(E dato){
        Node tmp=head;
        while(tmp!=null && tmp.dato!=dato){
            tmp=tmp.next;
        }
        return tmp!=null;
    }
    
    public int getSize(){
            if(this.head==null)
                return 0;
            int cont =0;
            while(this.head!= null){
                cont++;
                this.head = head.getNext();
            }
            
            return cont;
        }
    
    
    
    public class Node<E> implements Serializable{
        static final long serialVersionUID = 1L;
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
