/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Estructuras;

/**
 *
 * @author tommy_Burgos
 */
public class Stack<E>{
    private Node<E> cima;
    private int tam;
    
    public Stack(){
        cima=null;
        tam=0;
    }
    
    public boolean isEmpty(){
        return cima==null;
    }
    public void push(E dato){
        Node<E> nuevo = new Node<E>(dato);
        nuevo.next=cima;
        cima=nuevo;
        tam++;
    }
    public Node<E> pop(){
        Node<E> tmp=cima;
        if(!isEmpty()){
            cima=cima.next;
            tam--;
        }return tmp;        
    }
    public Node<E> peek(){
        return cima;
    }
    public int size(){
        return tam;
    }
    
    public class Node<E>{
        private E dato;
        private Node<E> next;
        
        public Node(E dato){
            this.dato=dato;
            this.next=null;
        }
    }
}
