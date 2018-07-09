/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aps_ed;

/**
 *
 * @author lab804
 */
public class Pilha {
    private Node1 topo;
    private int qtd = 1;

    public int getQtd() {
        return qtd;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
    }
    
    
    public Pilha() {
        topo = null; //Pilha vazia
    }

    public boolean isEmpty()// true se vazia
    {
        return (topo == null);
    }

    public void push(int dd) // insere no topo
    {
        Node1 novoNode1 = new Node1(dd);
        //verifica se alocou (pilha cheia)
        if (novoNode1 != null) //apenas por seguranÃ§a
        {
            novoNode1.next = topo;
            topo = novoNode1;
            qtd++;
        }
    }

    public int pop()// remove do topo -> desempiha
    {
        if (isEmpty())//se estiver vazia retorna -1
        {
            return -1;
        }

        Node1 temp = topo; //utilizado para retornar o dado
        topo = topo.next; //move o topo para o prox nÃ³
        qtd--;
        return temp.dado; //retorna o dado
        
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Pilha vazia.");
        } else {
            Node1 atual = topo;// inicia do topo
            while (atual != null)// atÃ© do final
            {
                atual.displayNode1(); //exibe a informaÃ§Ã£o do nÃ³
                atual = atual.next;// move para o proximo nÃ³
            }

            System.out.println();
        }
    }

    public Node1 getTopo(){
        return topo;
    }
    
}
