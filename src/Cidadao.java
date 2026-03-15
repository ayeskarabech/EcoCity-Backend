package src;
public class Cidadao {
    // 1. Atributos Privados (Encapsulamento!)
    private String nome;
    private String cpf;
    private int saldoPontos;

    // 2. Construtor para inicializar os atributos
    public Cidadao(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
        this.saldoPontos = 0;
    }

    // 3. Método para realizar o descarte e ganhar pontos
    public void realizarDescarte(Material m) {
        double basePontos = m.calcularPontos();
        this.saldoPontos += (int) basePontos; 
        System.out.println("\nDescarte do cidadao " + this.nome + " realizado! +" + basePontos + " pontos.\n");
    }

    // 4. Método para ganhar pontos
    public void adicionarPontos(int quantidade) {
        if (quantidade > 0) {
            this.saldoPontos += quantidade;
            System.out.println("Pontos adicionados com sucesso!");
        } else {
            System.out.println("Erro: Quantidade inválida.");
        }
    }

    // 5. Método para ver o saldo (Getter)
    public int getSaldoPontos() {
        return this.saldoPontos;
    }

    // Getters e Setters para nome e cpf (Encapsulamento)
    public String getNome() {  
        return nome;
    }

    public String getCpf() {
        return cpf;
    }
}
