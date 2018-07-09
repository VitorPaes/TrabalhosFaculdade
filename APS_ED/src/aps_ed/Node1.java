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
public class Node1 {
    public int dado;
    public Node1 next;

    public Node1(int dd) {
        dado = dd;
        next = null;
    }

    public void displayNode1() {
        System.out.println(dado);
    }
    
    public int getDado(){
        return dado;
    }
    
}
