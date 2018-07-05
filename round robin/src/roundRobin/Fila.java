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
public class Fila {

    private Node inicio, fim;


    public Fila() {
        inicio = null;
        fim = null;
    }

    public boolean isEmpty(){
        return (inicio == null);
    }

    public Processo peek() {
        if (!isEmpty()) {
            Node atual = inicio;
            return atual.getDado();
        } else {
            return null;
        }
    }
    
    public int size(){
        int tam = 0;
        
        Node atual = inicio;
        
        while(atual != null){
            tam++;
            atual = atual.getNext();
        }
        
        return tam;
    }

    public String allList() {
        String saida = "";
        if (!isEmpty()) {
            Node atual = inicio; 
            while (atual != null){
                if (atual.getDado() != null && atual.getDado() != peek() && atual.getDado().burst != 0) {
                    saida += atual.getDado().name + "(" + atual.getDado().burst + ") ";
                }
                atual = atual.getNext();
            }
            if (saida.equals("")) {
                return "Não há processos na fila";
            } else {
                return saida;
            }
        }

        return "Não há processos na fila";
    }

    
    public void enqueue(Processo dado){
        Node newNode = new Node(dado);

        if (inicio== null) {
            inicio= newNode;
            fim = inicio;
        } else {
            fim.setNext(newNode);
            fim = newNode;
        }
    }
    
    public Processo dequeue(){
        if (isEmpty()) 
            return null;

        Node tmp = inicio;
        inicio= inicio.getNext();
        if (inicio== null)
            fim = null;
        
        return tmp.getDado();
    }
    
    public Processo[] asVector(){
        Processo vect[] = new Processo[size()];
        Node atual = inicio;
        for(int i = 0; i < size(); i++){
            vect[i] = atual.getDado();
            atual = atual.getNext();
        }
        return vect;
    }

    public boolean find(Processo p) {
        Node atual = inicio;
        while (atual != null){
                if (atual.getDado() == p) {
                    return true;
                }
                atual = atual.getNext();
            }
        return false;
    }
}
