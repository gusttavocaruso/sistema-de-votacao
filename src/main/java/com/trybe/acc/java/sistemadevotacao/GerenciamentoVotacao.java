package com.trybe.acc.java.sistemadevotacao;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class GerenciamentoVotacao {

  private ArrayList<PessoaCandidata> pessoasCandidatas = new ArrayList<PessoaCandidata>();
  private ArrayList<PessoaEleitora> pessoasEleitoras = new ArrayList<PessoaEleitora>();
  private ArrayList<String> cpfComputado = new ArrayList<String>();
  private int totalVotos = 0;

  /**
   * Método para cadastrar pessoa candidata.
   */
  public void cadastrarPessoaCandidata(String nome, int numero) {

    boolean isNumberExists = false;
    for (PessoaCandidata candidato : pessoasCandidatas) {
      if (candidato.getNumero() == numero) {
        System.out.println("Número pessoa candidata já utilizado!");
        isNumberExists = true;
      }
    }

    if (!isNumberExists) {
      PessoaCandidata pessoaCandidata = new PessoaCandidata(nome, numero);
      pessoasCandidatas.add(pessoaCandidata);
    }

  }

  /**
   * Método para cadastrar pessoa eleitora.
   */
  public void cadastrarPessoaEleitora(String nome, String cpf) {

    boolean isCpfExists = false;
    for (PessoaEleitora eleitor : pessoasEleitoras) {
      if (eleitor.getCpf().compareTo(cpf) == 0) {
        System.out.println("Pessoa eleitora já cadastrada!");
        isCpfExists = true;
      }
    }

    if (!isCpfExists) {
      PessoaEleitora pessoaEleitora = new PessoaEleitora(nome, cpf);
      pessoasEleitoras.add(pessoaEleitora);
    }

  }

  /**
   * Método que permite realizar votação caso cpf ainda não tenha votado e
   * numero de pessoa candidata exista.
   */
  public void votar(String cpfPessoaEleitora, int numeroPessoaCandidata) {

    boolean isCpfRegistered = false;
    for (String cpf : cpfComputado) {
      if (cpf.compareTo(cpfPessoaEleitora) == 0) {
        System.out.println("Pessoa eleitora já votou!");
        isCpfRegistered = true;
      }
    }

    if (!isCpfRegistered) {
      for (PessoaCandidata candidato : pessoasCandidatas) {
        if (candidato.getNumero() == numeroPessoaCandidata) {
          candidato.receberVoto();
        }
      }
      cpfComputado.add(cpfPessoaEleitora);
      totalVotos += 1;
    }

  }

  /**
   * Método que exibe resultado da votação.
   */
  public void mostrarResultado() {

    DecimalFormat df = new DecimalFormat("#0.0#%");

    if (totalVotos == 0) {
      System.out.println("É preciso ter pelo menos um voto para mostrar o resultado.");
    } else {
      for (PessoaCandidata candidato : pessoasCandidatas) {
        System.out.println(
            "Nome: " + candidato.getNome() + " - " + candidato.getVotos()
            + " ( " + df.format(candidato.getVotos() / (float) totalVotos) + " ) "
        );
      }
      System.out.println("Total de votos: " + totalVotos);
    }

  }

}
