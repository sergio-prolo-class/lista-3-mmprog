package ifsc.poo.atendimento;

import java.util.Scanner;

public class AppAtendimento {
    public static void main(String[] args) {
        Atendimento sistema = new Atendimento();
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\n--- FILA DE ATENDIMENTO ---");
            System.out.println("1. Registrar novo cliente/solicitacao");
            System.out.println("2. Adicionar solicitacao existente");
            System.out.println("3. Listar telefones de clientes");
            System.out.println("4. Ver proximo cliente");
            System.out.println("5. Atender proxima solicitacao");
            System.out.println("6. Listar idades atendidos");
            System.out.println("7. Listar telefones em espera");
            System.out.println("0. Sair");
            System.out.print("Escolha: ");

            try {
                opcao = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                opcao = -1;
            }

            switch (opcao) {
                case 1:
                    System.out.print("Nome: ");
                    String nome = scanner.nextLine();
                    System.out.print("Idade: ");
                    int idade = Integer.parseInt(scanner.nextLine());
                    System.out.print("Telefone: ");
                    String tel = scanner.nextLine();
                    System.out.print("Descricao: ");
                    String desc = scanner.nextLine();
                    sistema.registrarCliente(new Cliente(nome, idade, tel), desc);
                    System.out.println("Registrado com sucesso!");
                    break;

                case 2:
                    System.out.print("Telefone do cliente: ");
                    String telefone = scanner.nextLine();
                    System.out.print("Nova descricao: ");
                    String novaDesc = scanner.nextLine();
                    sistema.adicionarSolicitacao(telefone, novaDesc);
                    System.out.println("Solicitacao adicionada!");
                    break;

                case 3:
                    System.out.println("\nTelefones cadastrados:");
                    sistema.listarTelefonesClientes().forEach(System.out::println);
                    break;

                case 4:
                    System.out.println("\nProximo cliente: " + sistema.proximoCliente());
                    break;

                case 5:
                    Solicitacao atendida = sistema.atenderProxima();
                    if (atendida != null) {
                        System.out.println("Atendendo: " + atendida);
                    } else {
                        System.out.println("Nenhuma solicitacao na fila!");
                    }
                    break;

                case 6:
                System.out.println("\nIdades dos atendidos:");
                for (Integer idadeAtendido : sistema.listarIdadesAtendidos()) {
                    System.out.print(idadeAtendido + " ");
                }
                System.out.println();
                break;

                case 7:
                    System.out.println("\nTelefones em espera:");
                    sistema.listarTelefonesEspera().forEach(System.out::println);
                    break;

                case 0:
                    System.out.println("Encerrando sistema...");
                    break;

                default:
                    System.out.println("Opcao invalida!");
            }
        } while (opcao != 0);

        scanner.close();
    }
}