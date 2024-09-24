package model;

import java.io.Serializable;

/**
 *
 * @author AntonioSantos
 */

public class Pessoa implements Serializable {

    private static final long serialVersionUID = 1L;
    private int id;
    private String nome;

    public Pessoa(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    // setters
    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    // getters
    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void exibir() {
        System.out.println("ID: " + getId());
        System.out.println("Nome: " + getNome());
    }
}
