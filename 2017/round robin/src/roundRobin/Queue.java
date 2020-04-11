/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package roundRobin;

/**
 *
 * @author carlos.reis
 */
public class Queue {

    private Node begin, end;


    public Queue() {
        begin = null;
        end = null;
    }

    public boolean isEmpty(){
        return (begin == null);
    }

    public Process peek() {
        if (!isEmpty()) {
            Node atual = begin;
            return atual.getData();
        } else {
            return null;
        }
    }
    
    public int size(){
        int tam = 0;
        
        Node current = begin;
        
        while(current != null){
            tam++;
            current = current.getNext();
        }
        
        return tam;
    }

    public String allList() {
        String saida = "";
        if (!isEmpty()) {
            Node current = begin; // do inicio
            while (current != null){
                if (current.getData() != null && current.getData() != peek() && current.getData().burst != 0) {
                    saida += current.getData().name + "(" + current.getData().burst + ") ";
                }
                current = current.getNext();
            }
            if (saida.equals("")) {
                return "Não há processos na fila";
            } else {
                return saida;
            }
        }

        return "Não há processos na fila";
    }

    //Insere elemento na Fila
    public void enqueue(Process dado){
        Node newNode = new Node(dado);

        if (begin == null) {
            begin = newNode;
            end = begin;
        } else {
            end.setNext(newNode);
            end = newNode;
        }
    }
    
    public Process[] asVector(){
        Process vect[] = new Process[size()];
        Node atual = begin;
        for(int i = 0; i < size(); i++){
            vect[i] = atual.getData();
            atual = atual.getNext();
        }
        return vect;
    }

    public boolean find(Process p) {
        Node atual = begin;
        while (atual != null){
                if (atual.getData() == p) {
                    return true;
                }
                atual = atual.getNext();
            }
        return false;
    }

 
    public Process dequeue(){
        if (isEmpty()) 
            return null;

        Node tmp = begin;
        begin = begin.getNext();
        if (begin == null)
            end = null;
        
        return tmp.getData();
    }
}
