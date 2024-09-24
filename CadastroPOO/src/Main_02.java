package model;

import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author AntonioSantos
 */

public class Main_02 {

    private static Scanner scanner = new Scanner(System.in);
    private static PessoaFisicaRepo repoPessoaFisica = new PessoaFisicaRepo();
    private static PessoaJuridicaRepo repoPessoaJuridica = new PessoaJuridicaRepo();

    public static void main(String[] args) {
        int opcao;
        do {
            System.out.println("=========================");
            System.out.println("Opções:");
            System.out.println("1. Incluir Pessoa");
            System.out.println("2. Alterar Pessoa");
            System.out.println("3. Excluir Pessoa");
            System.out.println("4. Exibir Por ID");
            System.out.println("5. Exibir Todos");
            System.out.println("6. Salvar Dados");
            System.out.println("7. Recuperar Dados");
            System.out.println("0. Finalizar Execução");
            System.out.println("=========================");

            opcao = lerInteiro("Digite a opção desejada: ");

            switch (opcao) {
                case 1:
                    incluir();
                    break;
                case 2:
                    alterar();
                    break;
                case 3:
                    excluir();
                    break;
                case 4:
                    exibirPorId();
                    break;
                case 5:
                    exibirTodos();
                    break;
                case 6:
                    salvarDados();
                    break;
                case 7:
                    recuperarDados();
                    break;
                case 0:
                    System.out.println("Finalizando o programa.");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 0);
    }

    private static void incluir() {
        String tipo = lerTipoValido(); // Método para ler o tipo (F ou J)
        if (tipo.equalsIgnoreCase("F")) {
            incluirPessoaFisica();
        } else if (tipo.equalsIgnoreCase("J")) {
            incluirPessoaJuridica();
        } else {
            System.out.println("Tipo inválido.");
        }
    }

    private static void incluirPessoaFisica() {
        int id = lerInteiro("Digite o ID: ");
        String nome = lerString("Digite o nome: ");
        String cpf = lerString("Digite o CPF: ");
        int idade = lerInteiro("Digite a idade: ");
        repoPessoaFisica.inserir(new PessoaFisica(id, nome, cpf, idade));
    }

    private static void incluirPessoaJuridica() {
        int id = lerInteiro("Digite o ID: ");
        String nome = lerString("Digite o nome: ");
        String cnpj = lerString("Digite o CNPJ: ");
        repoPessoaJuridica.inserir(new PessoaJuridica(id, nome, cnpj));
    }

    private static void alterar() {
        String tipo = lerTipoValido(); // Método para ler o tipo (F ou J)
        int id = lerInteiro("Digite o ID: ");

        if (tipo.equalsIgnoreCase("F")) {
            PessoaFisica pessoa = repoPessoaFisica.obter(id); // Obtendo a pessoa
            if (pessoa != null) {
                System.out.println("Dados atuais da pessoa física:");
                pessoa.exibir();
                System.out.println("Digite os novos dados:");

                // Leitura dos novos dados
                int novoId = lerInteiro("Digite o novo ID: ");
                String novoNome = lerString("Digite o novo nome: ");
                String novoCpf = lerString("Digite o novo CPF: ");
                int novaIdade = lerInteiro("Digite a nova Idade: ");

                // Usando os setters para atualizar os dados
                pessoa.setId(novoId);
                pessoa.setNome(novoNome);
                pessoa.setCpf(novoCpf);
                pessoa.setIdade(novaIdade);

                // Chamando o método alterar
                repoPessoaFisica.alterar(pessoa);

                System.out.println("Dados atualizados com sucesso:");
                pessoa.exibir(); // Exibir os dados atualizados
            } else {
                System.out.println("Pessoa física não encontrada.");
            }
        } else if (tipo.equalsIgnoreCase("J")) {
            PessoaJuridica pessoa = repoPessoaJuridica.obter(id); // Obtendo a empresa
            if (pessoa != null) {
                System.out.println("Dados atuais da pessoa jurídica:");
                pessoa.exibir();
                System.out.println("Digite os novos dados:");

                // Leitura dos novos dados
                int novoId = lerInteiro("Digite o novo ID: ");
                String novoNome = lerString("Digite o novo nome: ");
                String novoCnpj = lerString("Digite o novo CNPJ: ");

                // Usando os setters para atualizar os dados
                pessoa.setId(novoId);
                pessoa.setNome(novoNome);
                pessoa.setcnpj(novoCnpj);

                // Chamando o método alterar
                repoPessoaJuridica.alterar(pessoa);

                System.out.println("Dados atualizados com sucesso:");
                pessoa.exibir(); // Exibir os dados atualizados
            } else {
                System.out.println("Pessoa jurídica não encontrada.");
            }
        } else {
            System.out.println("Tipo inválido.");
        }
    }

    private static void excluir() {
        String tipo = lerTipoValido(); // Método para ler o tipo (F ou J)

        int id = lerInteiro("Digite o ID: ");

        if (tipo.equalsIgnoreCase("F")) {
            repoPessoaFisica.excluir(id);
        } else if (tipo.equalsIgnoreCase("J")) {
            repoPessoaJuridica.excluir(id);
        } else {
            System.out.println("Tipo inválido.");
        }
    }

    private static void exibirPorId() {
        String tipo = lerTipoValido(); // Método para ler o tipo (F ou J)
        int id = lerInteiro("Digite o ID: ");
        if (tipo.equalsIgnoreCase("F")) {
            PessoaFisica pessoa = repoPessoaFisica.obter(id);
            if (pessoa != null) {
                pessoa.exibir();
            } else {
                System.out.println("Pessoa física não encontrada.");
            }
        } else if (tipo.equalsIgnoreCase("J")) {
            PessoaJuridica pessoa = repoPessoaJuridica.obter(id);
            if (pessoa != null) {
                pessoa.exibir();
            } else {
                System.out.println("Pessoa jurídica não encontrada.");
            }
        } else {
            System.out.println("Tipo inválido.");
        }
    }

    private static void exibirTodos() {
        String tipo = lerTipoValido(); // Método para ler o tipo (F ou J)
        if (tipo.equalsIgnoreCase("F")) {
            for (PessoaFisica pessoa : repoPessoaFisica.obterTodos()) {
                pessoa.exibir();
                System.out.println();
            }
        } else if (tipo.equalsIgnoreCase("J")) {
            for (PessoaJuridica pessoa : repoPessoaJuridica.obterTodos()) {
                pessoa.exibir();
                System.out.println();
            }
        } else {
            System.out.println("Tipo inválido.");
        }
    }

    private static void salvarDados() {
        String prefixo = lerString("Digite o prefixo dos arquivos: ");
        try {
            repoPessoaFisica.persistir(prefixo + ".fisica.bin");
            repoPessoaJuridica.persistir(prefixo + ".juridica.bin");
            System.out.println("Dados salvos com sucesso.");
        } catch (IOException e) {
            System.out.println("Erro ao salvar dados: " + e.getMessage());
        }
    }

    private static void recuperarDados() {
        String prefixo = lerString("Digite o prefixo dos arquivos: ");
        try {
            repoPessoaFisica = PessoaFisicaRepo.recuperar(prefixo + ".fisica.bin");
            repoPessoaJuridica = PessoaJuridicaRepo.recuperar(prefixo + ".juridica.bin");
            System.out.println("Dados recuperados com sucesso.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Erro ao recuperar dados: " + e.getMessage());
        }
    }

    private static int lerInteiro(String mensagem) {
        System.out.print(mensagem);
        int valor = scanner.nextInt();
        scanner.nextLine(); // limpa o buffet e resolve erros entre lerString e lerInteiro
        return valor;
    }

    private static String lerString(String mensagem) {
        System.out.print(mensagem);
        return scanner.nextLine();
    }

    private static String lerTipoValido() {
        String tipo;

        while (true) {
            System.out.print("Escolha o tipo (F para Pessoa Física, J para Pessoa Jurídica): ");
            tipo = scanner.nextLine().trim().toUpperCase(); // Lê a entrada e a normaliza

            if (tipo.equals("F") || tipo.equals("J")) {
                break; // Sai do loop se a entrada for válida
            } else {
                System.out.println("Tipo inválido. Tente novamente."); // Mensagem de erro
            }
        }
        return tipo;
    }
}
