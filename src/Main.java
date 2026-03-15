package src;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Cabeçalho do sistema
        System.out.println("=====================================");
        System.out.println("     Bem-vindo ao sistema EcoCity");
        System.out.println("=====================================");

        // Entrada de dados do cidadão
        Scanner leitor = new Scanner(System.in);

        System.out.println("Digite seu nome: ");
        String nome = leitor.nextLine();

        System.out.println("Digite seu CPF: ");
        String cpf = leitor.nextLine();

        System.out.println("\nOlá, " + nome + "! Vamos começar a reciclar e ganhar pontos!\n");

        System.out.println("Que tipo de material você deseja descartar? (Ex: Orgânico, Plástico, Vidro, Metal, Tôxico)");
        String tipoMaterial = leitor.nextLine();

        System.out.println("Digite o peso do material em kg: ");
        double pesoMaterial = leitor.nextDouble();

        System.out.println("O material é tóxico? (true/false)");
        boolean toxico = leitor.nextBoolean();

        Cidadao cidadao1 = new Cidadao(nome, cpf);
        Material material1 = new Material(tipoMaterial, pesoMaterial, toxico);

        leitor.close();

        // Saída de dados:

        cidadao1.realizarDescarte(material1);

        // Qnts pontos que o material vale:
        System.out.println(material1.getNome() + " vale " + material1.calcularPontos() + " pontos.\n"); 

        // Exibindo o saldo de pontos do cidadão:''
        System.out.println("\n----- Saldo de pontos de " + cidadao1.getNome() + ": " + cidadao1.getSaldoPontos() + " -----\n");
    }
}