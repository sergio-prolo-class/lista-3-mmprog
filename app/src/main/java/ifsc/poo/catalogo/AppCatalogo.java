package ifsc.poo.catalogo;

import java.util.Scanner;
import java.util.List;

public class AppCatalogo {
    public static void main(String[] args) {
        CatalogoFilmes catalogo = new CatalogoFilmes();
        Scanner scanner = new Scanner(System.in);
        int opcao;



        do {
            System.out.println("\n--- CATALOGO DE FILMES ---");
            System.out.println("1. Adicionar filme");
            System.out.println("2. Remover filme");
            System.out.println("3. Listar por titulo");
            System.out.println("4. Listar por gênero");
            System.out.println("5. Listar por ano");
            System.out.println("6. Buscar por ano");
            System.out.println("0. Sair");
            System.out.print("Escolha: ");

            try {
                opcao = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                opcao = -1;
            }

            switch (opcao) {
                case 1:
                    System.out.print("Titulo: ");
                    String titulo = scanner.nextLine();
                    System.out.print("Ano: ");
                    int ano = Integer.parseInt(scanner.nextLine());
                    System.out.print("Genero: ");
                    String genero = scanner.nextLine();
                    catalogo.adicionarFilme(new Filme(titulo, ano, genero));
                    System.out.println("Filme adicionado com sucesso!");
                    break;

                case 2:
                    System.out.print("Titulo do filme a remover: ");
                    String tituloRemover = scanner.nextLine();
                    System.out.print("Ano do filme: ");
                    int anoRemover = Integer.parseInt(scanner.nextLine());
                    if (catalogo.removerFilme(new Filme(tituloRemover, anoRemover, ""))) {
                        System.out.println("Filme removido com sucesso!");
                    } else {
                        System.out.println("Filme não encontrado!");
                    }
                    break;

                case 3:
                    System.out.println("\nFilmes ordenados por titulo:");
                    catalogo.listarPorTitulo().forEach(System.out::println);
                    break;

                case 4:
                    System.out.println("\nFilmes ordenados por genero:");
                    catalogo.listarPorGenero().forEach(System.out::println);
                    break;

                case 5:
                    System.out.println("\nFilmes ordenados por ano:");
                    catalogo.listarPorAno().forEach(System.out::println);
                    break;

                case 6:
                    System.out.print("Digite o ano para buscar: ");
                    int anoBusca = Integer.parseInt(scanner.nextLine());
                    List<Filme> filmesAno = catalogo.buscarPorAno(anoBusca);
                    if (filmesAno.isEmpty()) {
                        System.out.println("Nenhum filme encontrado para este ano!");
                    } else {
                        System.out.println("\nFilmes de " + anoBusca + ":");
                        filmesAno.forEach(System.out::println);
                    }
                    break;

                case 0:
                    System.out.println("Saindo do sistema...");
                    break;

                default:
                    System.out.println("Opcao invalida! Tente novamente.");
            }
        } while (opcao != 0);

        scanner.close();
    }
}