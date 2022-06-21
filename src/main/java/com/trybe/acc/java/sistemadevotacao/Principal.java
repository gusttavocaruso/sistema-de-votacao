package com.trybe.acc.java.sistemadevotacao;

import java.util.Scanner;

public class Principal {

  /**
   * Javadoc comment.
   */
  public static void main(String[] args) {

    GerenciamentoVotacao gerenciamentoVotacao = new GerenciamentoVotacao();
    Scanner scan = new Scanner(System.in);

    String nome;
    String cpf;
    int numero;
    
    short menuChoice;
    boolean inLoop = true;

    do {
      menuCadastroCandidato();
      menuChoice = scan.nextShort();

      if (menuChoice == 1) {
        System.out.println("Entre com o nome da pessoa candidata:");
        nome = scan.next();

        System.out.println("Entre com o numero da pessoa candidata:");
        numero = scan.nextInt();

        gerenciamentoVotacao.cadastrarPessoaCandidata(nome, numero);
      } else if (menuChoice == 2) {
        inLoop = false;
      } else {
        System.out.println("Opção inválida.");
      }

    } while (inLoop);

    inLoop = true;

    do {
      menuCadastroEleitor();
      menuChoice = scan.nextShort();

      if (menuChoice == 1) {
        System.out.println("Entre com o nome da pessoa eleitora:");
        nome = scan.next();

        System.out.println("Entre com o cpf da pessoa eleitora:");
        cpf = scan.next();

        gerenciamentoVotacao.cadastrarPessoaEleitora(nome, cpf);
      } else if (menuChoice == 2) {
        inLoop = false;
      } else {
        System.out.println("Opção inválida.");
      }

    } while (inLoop);

    inLoop = true;

    do {
      mainMenu();
      menuChoice = scan.nextShort();

      if (menuChoice == 1) {
        System.out.println("Entre com o cpf da pessoa eleitora:");
        cpf = scan.next();

        System.out.println("Entre com o número da pessoa candidata:");
        numero = scan.nextInt();

        gerenciamentoVotacao.votar(cpf, numero);
      } else if (menuChoice == 2) {
        gerenciamentoVotacao.mostrarResultado();
      } else if (menuChoice == 3) {
        gerenciamentoVotacao.mostrarResultado();
        inLoop = false;
      } else {
        System.out.println("Opção inválida.");
      }

    } while (inLoop);

    scan.close();
  }

  /**
   * Estrutura de menu para cadastrar candidato.
   */
  public static void menuCadastroCandidato() {
    System.out.println(
        "Cadastrar pessoa candidata? \n"
        + "1 - Sim \n"
        + "2 - Não \n"
        + "Entre com o número correspondente à opção desejada:"
    );
  }

  /**
   * Estrutura de menu para cadastrar eleitor.
   */
  public static void menuCadastroEleitor() {
    System.out.println(
        "Cadastrar pessoa eleitora? \n"
        + "1 - Sim \n"
        + "2 - Não \n"
        + "Entre com o número correspondente à opção desejada:"
    );
  }

  /**
   * Estrurura de menu principal.
   */
  public static void mainMenu() {
    System.out.println(
        "Entre com o número correspondente à opção desejada: \n"
        + "1 - Votar \n"
        + "2 - Resultado Parcial \n"
        + "3 - Finalizar Votação"
    );
  }

}
