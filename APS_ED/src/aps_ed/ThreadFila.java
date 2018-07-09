/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aps_ed;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author User
 */
public class ThreadFila extends Thread {

    private Node inicio, fim;
    private int totalDeElementos = 1;
    CaixasOperadores c = new CaixasOperadores();

    public int getTotalDeElementos() {
        return totalDeElementos;
    }

    //Construtor
    public ThreadFila() {
        start();
        inicio = null;
        fim = null;
    }

    // Verifica se a Fila está vazia
    public boolean isEmpty() {
        return (inicio == null);
    }

    //Insere elemento na Fila
    public void enqueue(int dado) {
        Node novoNode = new Node(dado);

        if (inicio == null) {
            inicio = novoNode;
            fim = inicio;
            totalDeElementos++;
        } else {
            fim.setNext(novoNode);
            fim = novoNode;
            totalDeElementos++;
        }
    }

    //Retira elemento na Fila
    public int dequeue() {
        if (isEmpty()) //se estiver vazia retorna -1
        {
            return -1;
        }

        Node tmp = inicio;// utilizado para retornar o dado
        inicio = inicio.getNext(); // move o topo para o prox node
        totalDeElementos--;
        if (inicio == null) {
            fim = null;
        }
        try {
            Thread.sleep(APS_ED.temp);
        } catch (InterruptedException ex) {
            Logger.getLogger(ThreadFila.class.getName()).log(Level.SEVERE, null, ex);
        }

        return tmp.getDado();// retorna o dado
    }

    public void display() {
        if (isEmpty()) {
            System.out.print("Fila vazia.");
        } else {
            Node atual = inicio; // do inicio
            while (atual != null) { // até o final
                System.out.print(atual.getDado() + " ");//exibe a informações do node
                atual = atual.getNext();// move para o proximo node
            }
            System.out.println();
        }
    }
}
