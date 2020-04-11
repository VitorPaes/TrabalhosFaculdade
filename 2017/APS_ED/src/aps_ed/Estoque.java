/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aps_ed;

/**
 *
 * @author User
 */
public class Estoque {
    private String nome_prd;
    private int id;
    private int quantidade;
    private Pilha pilha;

    public Estoque() {
        pilha = new Pilha();
    }

    public Estoque(String nome_prd, int id, int quantidade, Pilha pilha) {
        this.nome_prd = nome_prd;
        this.id = id;
        this.quantidade = quantidade;
        this.pilha = pilha;
    }

    public String getNome_prd() {
        return nome_prd;
    }

    public void setNome_prd(String nome_prd) {
        this.nome_prd = nome_prd;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Pilha getPilha() {
        return pilha;
    }

    public void setPilha(Pilha pilha) {
        this.pilha = pilha;
    }
    
    
    
    
}
