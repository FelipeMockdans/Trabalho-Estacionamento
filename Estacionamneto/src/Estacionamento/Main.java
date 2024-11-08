package Estacionamento;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        SistemaEstacionamento sistema = new SistemaEstacionamento();
        Scanner scanner = new Scanner(System.in);
        int opcao;

        
        do {
            System.out.println("\n--- Sistema de Gerenciamento de Estacionamento ---");
            System.out.println("1. Adicionar Vaga");
            System.out.println("2. Registrar Entrada de Veículo");
            System.out.println("3. Registrar Saída de Veículo");
            System.out.println("4. Gerar Relatório de Vagas Ocupadas");
            System.out.println("5. Gerar Histórico de Permanência dos Veículos");
            System.out.println("6. Sair");
            System.out.print("Escolha uma opção: ");
            
            opcao = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcao) {
                case 1:
                   
                    System.out.print("Número da vaga: ");
                    int numeroVaga = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Tamanho da vaga (pequeno, médio, grande): ");
                    String tamanhoVaga = scanner.nextLine();
                    
                    
                    sistema.adicionarVaga(numeroVaga, tamanhoVaga); 
                    System.out.println("Vaga adicionada com sucesso!");
                    break;

                case 2:
                    
                    System.out.print("Placa do veículo: ");
                    String placa = scanner.nextLine();
                    System.out.print("Modelo do veículo: ");
                    String modelo = scanner.nextLine();
                    System.out.print("Tamanho do veículo (pequeno, médio, grande): ");
                    String tamanhoVeiculo = scanner.nextLine();
                    
                   
                    sistema.registrarEntradaVeiculo(placa, modelo, tamanhoVeiculo);
                    break;

                case 3:
                  
                    System.out.print("Placa do veículo para saída: ");
                    String placaSaida = scanner.nextLine();
                    
                   
                    sistema.registrarSaidaVeiculo(placaSaida);
                    break;

                case 4:
                    
                    sistema.gerarRelatorioVagasOcupadas();
                    break;

                case 5:
                   
                    sistema.gerarHistoricoPermanencia();
                    break;

                case 6:
                    System.out.println("Saindo do sistema...");
                    break;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 6);

        scanner.close();
    }
}


