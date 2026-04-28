package src;

import java.util.Scanner;
import java.util.ArrayList;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException; // Tratamento de exceções de entrada
import src.model.*;
import src.model.materiais.*;
import java.io.*;

public class Main {
    // Métodos auxiliares para leitura de dados com tratamento de exceções:
    public static int lerInteiro(Scanner leitor, String mensagem) {
        while (true) {
            try {
                System.out.print(mensagem);
                return leitor.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Erro: Digite um número inteiro válido!");
                leitor.nextLine();
            }
        }
    }

    public static double lerDouble(Scanner leitor, String mensagem) {
        while (true) {
            try {
                System.out.print(mensagem);
                return leitor.nextDouble();
            } catch (InputMismatchException e) {
                System.out.println("Erro: Digite um número decimal válido!");
                leitor.nextLine();
            }
        }
    }

    // Método para salvar os dados do cidadão em um arquivo .txt:
    public static void salvarDados(Cidadao c){
        try (PrintWriter gravar = new PrintWriter(new FileWriter("dados_ecocity.txt"))) {
            gravar.println(c.getNome() + ";" + c.getCpf() + ";" + c.getSaldoPontos());
            
            for (Material m : c.getHistoricoDescarte()) {
                gravar.println(m.getNome() + ";" + m.getPeso() + ";" + m.isToxico() + ";" + m.getDataHora());
            }
            System.out.println("Dados do cidadão salvos com sucesso!");
        } catch (IOException e) {
            System.out.println("Erro ao salvar os dados: " + e.getMessage());
        }
    }

    // Método para carregar os dados do cidadão a partir do arquivo .txt:
    public static Cidadao carregarDados(){
        File arquivo = new File("dados_ecocity.txt");

        if (!arquivo.exists()) return null;

        try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
            String linha = br.readLine(); // Lê a primeira linha do arquivo

            if (linha == null) return null;
            // A primeira linha contém os dados do cidadão: nome;cpf;pontos
            String[] partes = linha.split(";");
            Cidadao c = new Cidadao(partes[0], partes[1]);
            c.adicionarPontos(Integer.parseInt(partes[2]));
            // Lê o restante das linhas para reconstruir o histórico de descarte
            while ((linha = br.readLine()) != null) {
                String[] m = linha.split(";");

                Material mat = new Material(m[0], Double.parseDouble(m[1]), Boolean.parseBoolean(m[2]));
                c.getHistoricoDescarte().add(mat); // Adiciona o material ao histórico do cidadão .txt
            }
            return c;
        } catch (Exception e) { //NumberFormatException para tratar erros de conversão de pontos
            System.out.println("Erro ao carregar os dados: " + e.getMessage());
            return null;
        }
    }

    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);

        Cidadao cidadao1 = carregarDados(); // Tenta carregar os dados do cidadão ao iniciar o programa
        int opcao = -1;

        System.out.println("=====================================");
        System.out.println("     Bem-vindo ao sistema EcoCity");
        System.out.println("=====================================");

        do {
            System.out.println("\n--------------------------------");
            System.out.println("MENU:");
            System.out.println("1. Cadastrar cidadão");
            System.out.println("2. Realizar descarte");
            System.out.println("3. Consultar saldo de pontos");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            
            try {
                opcao = leitor.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Erro: Digite apenas números inteiros!");
                leitor.nextLine(); 
                continue;
            }

            switch (opcao) {
                case 1:
                    leitor.nextLine();
                    System.out.print("\n- Digite seu nome: ");
                    String nome = leitor.nextLine();

                    System.out.print("\n- Digite seu CPF: ");
                    String cpf = leitor.nextLine();

                    cidadao1 = new Cidadao(nome, cpf);
                    salvarDados(cidadao1);

                    System.out.println("\nOlá, " + nome + "! Vamos começar a reciclar e ganhar pontos!");
                    break;

                case 2:
                    if (cidadao1 == null) {
                        System.out.println("Por favor, cadastre-se primeiro na opção 1 do menu.");
                        break;
                    } 
                    
                    System.out.println("\n----- Vamos realizar um descarte! -----");

                    System.out.print("Escolha o tipo de material (1. Papel | 2. Plástico | 3. Vidro | 4. Orgânico | 5. Tóxico)");
                    int tipoMaterial = lerInteiro(leitor, "\n- Escolha o tipo (1-5): "); 
                    
                    double pesoMaterial = lerDouble(leitor, "- Peso do material (kg): ");

                    Material materialSelecionado = null;

                    switch (tipoMaterial) {
                        case 1: materialSelecionado = new MaterialPapel(pesoMaterial); break; 
                        case 2: materialSelecionado = new MaterialPlastico(pesoMaterial); break;
                        case 3: materialSelecionado = new MaterialVidro(pesoMaterial); break;
                        case 4: materialSelecionado = new MaterialOrganico(pesoMaterial); break;
                        case 5: materialSelecionado = new MaterialToxico(pesoMaterial); break;
                        default: 
                            System.out.println("Tipo inválido!");
                            break;
                    }

                    if (materialSelecionado != null) {
                        leitor.nextLine();
                        cidadao1.realizarDescarte(materialSelecionado);
                        System.out.println(materialSelecionado.getNome() + " processado com sucesso!\n");
                    }
                    salvarDados(cidadao1);
                    break;

                case 3:
                    if(cidadao1 == null) {
                        System.out.println("Por favor, cadastre-se primeiro na opção 1 do menu.");
                    } else {
                        System.out.println("\n----- EXTRATO DE PONTOS -----");
                        System.out.println("\n- Cidadão: " + cidadao1.getNome());
                        
                        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

                        for (Material m : cidadao1.getHistoricoDescarte()) {
                            String dataBonita = m.getDataHora().format(fmt);
                            
                            System.out.println("[" + dataBonita + "] " + m.getNome() + 
                                               " | " + m.getPeso() + "kg -> " + 
                                               m.calcularPontos() + " pts");
                        }

                        System.out.println("\n----- SALDO DE PONTOS -----");
                        System.out.println("Saldo total: " + cidadao1.getSaldoPontos() + " pontos.");
                    }
                    break;

                case 0:
                    System.out.println("\n----- Saindo do sistema... Até logo -----!");
                    break;

                default:
                    System.out.println("\n----- Opção inválida! Tente novamente. -----");
            }
        } while (opcao != 0);

        leitor.close();
    }
}