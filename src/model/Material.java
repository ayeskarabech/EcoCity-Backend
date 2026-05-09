/**
 * Classe abstrata que serve como base para todos os resíduos do sistema.
 * Não pode ser instanciada diretamente, garantindo que todo materialtenha um tipo específico e implemente sua própria lógica de pontuação.
 */

package src.model;

import java.time.LocalDateTime;

public abstract class Material {
    // Declaração dos Atributos:
    protected String nome;
    protected double peso;
    protected boolean toxico;
    protected LocalDateTime dataHora;

    // Contrutor para inicializar os atributos
    public Material(String nome, double peso, boolean toxico) {
        this.nome = nome;
        this.peso = peso;
        this.toxico = toxico;
        this.dataHora = LocalDateTime.now();
    }

    // Método de calcular pontos
    public abstract double calcularPontos();

    // Getters e Setters (Encapsulamento)
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public boolean isToxico() {
        return toxico;
    }

    public void setToxico(boolean toxico) {
        this.toxico = toxico;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }
}