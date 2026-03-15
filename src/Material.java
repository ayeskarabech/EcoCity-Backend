package src;
public class Material {
    // 1. Declaração dos Atributos
    private String nome;
    private double peso;
    private boolean toxico;

    // 2. Contrutor para inicializar os atributos
    public Material(String nome, double peso, boolean toxico) {
        this.nome = nome;
        this.peso = peso;
        this.toxico = toxico;
    }

    // 3. Getters e Setters (Encapsulamento)
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

    // 4. Método de calcular pontos
    public double calcularPontos() {
        double pontosBase = peso * 10; 
        
        // se for orgânico, ganha bônus!
        if (this.nome.equalsIgnoreCase("Orgânico")) {
            return pontosBase * 2;
        }
        else if (this.toxico) {
            return pontosBase * 3; // materiais tóxicos valem mais pontos ainda, para incentivar a reciclagem correta e evitar descarte inadequado
        }
        return pontosBase;
    }
}