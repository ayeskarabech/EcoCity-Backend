package src.model;

import java.util.ArrayList;

public class Cidadao {
    // Atributos Privados ENCAPSULADOS
    private String nome;
    private String cpf;
    private int saldoPontos;

    private ArrayList<Material> historicoDescarte;

    // Construtor
    public Cidadao(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
        this.saldoPontos = 0;
        this.historicoDescarte = new ArrayList<>();
    }

    // Realizar o descarte e ganhar pontos
    public void realizarDescarte(Material m) {
        double basePontos = m.calcularPontos();
        this.saldoPontos += (int) basePontos; 
        this.historicoDescarte.add(m); // adiciona o material ao histórico de descarte do cidadão para desenvolver um extrato de atividades e incentivar a participação contínua no programa de reciclagem.
        System.out.println("\nDescarte do cidadao " + this.nome + " realizado e salvo no histórico! +" + basePontos + " pontos.\n");
    }

    // Ganhar pontos
    public void adicionarPontos(int quantidade) {
        if (quantidade > 0) {
            this.saldoPontos += quantidade;
            System.out.println("Pontos adicionados com sucesso!");
        } else {
            System.out.println("Erro: Quantidade inválida.");
        }
    }

    // Getters e Setters PARA ENCAPSULAMENTO
    public String getNome() {  
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public int getSaldoPontos() {
        return this.saldoPontos;
    }

    public ArrayList<Material> getHistoricoDescarte() {
        return historicoDescarte;
    }
}
