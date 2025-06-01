package ifsc.poo.app;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("ESCOLHA O SISTEMA:");
        System.out.println("1. Catalogo de Filmes");
        System.out.println("2. Fila de Atendimento");
        System.out.print("Opcao: ");
        int escolha = scanner.nextInt();

        if (escolha == 1) {
            ifsc.poo.catalogo.AppCatalogo.main(args);
        } else if (escolha == 2) {
            ifsc.poo.atendimento.AppAtendimento.main(args);
        }
        scanner.close();
    }
}