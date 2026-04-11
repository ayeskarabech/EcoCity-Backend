package src;

import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Main {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);

        Cidadao cidadao1 = null;
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
            
            opcao = leitor.nextInt();
            leitor.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("\n- Digite seu nome: ");
                    String nome = leitor.nextLine();

                    System.out.print("- Digite seu CPF: ");
                    String cpf = leitor.nextLine();

                    cidadao1 = new Cidadao(nome, cpf);

                    System.out.println("\nOlá, " + nome + "! Vamos começar a reciclar e ganhar pontos!");
                    break;

                case 2:
                    if (cidadao1 == null) {
                        System.out.println("Por favor, cadastre-se primeiro na opção 1 do menu.");
                        break;
                    } 
                    
                    System.out.println("\n----- Vamos realizar um descarte! -----");

                    System.out.print("- Escolha o tipo de material (1. Papel | 2. Plástico | 3. Vidro | 4. Orgânico | 5. Tóxico): ");
                    int tipoMaterial = leitor.nextInt();
                    
                    System.out.print("- Peso do material (kg): ");
                    double pesoMaterial = leitor.nextDouble();

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
                    break;

                case 3:
                    if(cidadao1 == null) {
                        System.out.println("Por favor, cadastre-se primeiro na opção 1 do menu.");
                    } else {
                        System.out.println("\n----- EXTRATO DE PONTOS -----");
                        System.out.println("\n- Cidadao: " + cidadao1.getNome());

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