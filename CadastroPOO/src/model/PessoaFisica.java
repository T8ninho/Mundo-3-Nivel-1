package model;

import java.io.Serializable;

/**
 *
 * @author AntonioSantos
 */

public class PessoaFisica extends Pessoa implements Serializable {

    private static final long serialVersionUID = 1L;
    private String cpf;
    private int idade;

    public PessoaFisica(int id, String nome, String cpf, int idade) {
        super(id, nome);
        this.cpf = cpf;
        this.idade = idade;
    }

    // setters
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public void setIdade(int idade) {
        this.idade = idade;
    }

    // getters
    public String getCpf() {
        return cpf;
    }
    public int getIdade() {
        return idade;
    }

    @Override
    public void exibir() {
        super.exibir();
        System.out.println("CPF: " + getCpf());
        System.out.println("Idade: " + getIdade() + "\n");
    }
}
