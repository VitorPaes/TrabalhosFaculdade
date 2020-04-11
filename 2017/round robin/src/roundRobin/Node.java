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
public class Node {

    private Processo dado;
    private Node next;

    public Node(Processo dado) {
        this.dado = dado;
        next = null;
    }

    public Processo getDado() {
        return dado;
    }

    public void setDado(Processo dado) {
        this.dado = dado;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
