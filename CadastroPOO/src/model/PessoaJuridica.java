package model;

import java.io.Serializable;

/**
 *
 * @author AntonioSantos
 */

public class PessoaJuridica extends Pessoa implements Serializable {

    private static final long serialVersionUID = 1L;
    private String cnpj;

    public PessoaJuridica(int id, String nome, String cnpj) {
        super(id, nome);
        this.cnpj = cnpj;
    }

    // setter
    public void setcnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    // getter
    public String getcnpj() {
        return cnpj;
    }

    @Override
    public void exibir() {
        super.exibir();
        System.out.println("CNPJ: " + getcnpj() + "\n");
    }
}
