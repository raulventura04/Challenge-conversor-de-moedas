import conversor.moedas.api.conversorMoedaAPI;

import java.util.Scanner;

public class MenuConversor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean sair = false;
        conversorMoedaAPI conversor = new conversorMoedaAPI(); // Instância da classe de conversão de moeda

        while (!sair) {
            exibirMenu();
            int opcao = scanner.nextInt();
            switch (opcao) {
                case 1:
                    converterUSDparaEUR(conversor, scanner);
                    break;
                case 2:
                    converterEURparaJPY(conversor, scanner);
                    break;
                case 3:
                    converterJPYparaUSD(conversor, scanner);
                    break;
                case 4:
                    converterEURparaUSD(conversor, scanner);
                    break;
                case 5:
                    converterUSDtoJPY(conversor, scanner);
                    break;
                case 6:
                    converterJPYtoEUR(conversor, scanner);
                    break;
                case 7:
                    sair = true;
                    System.out.println("Saindo do programa. Obrigado!");
                    break;
                default:
                    System.out.println("Opção inválida. Escolha uma opção válida.");
            }
        }
        scanner.close();
    }

    public static void exibirMenu() {
        System.out.println("\n=== Conversor de Moedas ===");
        System.out.println("Escolha a conversão desejada:");
        System.out.println("1. USD para EUR");
        System.out.println("2. EUR para JPY");
        System.out.println("3. JPY para USD");
        System.out.println("4. EUR para USD");
        System.out.println("5. USD para JPY");
        System.out.println("6. JPY para EUR");
        System.out.println("7. Sair");
        System.out.print("Escolha uma Opção Válida: ");
    }

    public static void converterUSDparaEUR(conversorMoedaAPI conversor, Scanner scanner) {
        System.out.print("Digite o valor em USD para converter para EUR: ");
        double valorUSD = scanner.nextDouble();
        conversor.converterUSDparaEUR(valorUSD);
    }

    public static void converterEURparaJPY(conversorMoedaAPI conversor, Scanner scanner) {
        System.out.print("Digite o valor em EUR para converter para JPY: ");
        double valorEUR = scanner.nextDouble();
        conversor.converterEURparaJPY(valorEUR);
    }

    public static void converterJPYparaUSD(conversorMoedaAPI conversor, Scanner scanner) {
        System.out.print("Digite o valor em JPY para converter para USD: ");
        double valorJPY = scanner.nextDouble();
        conversor.converterJPYparaUSD(valorJPY);
    }

    public static void converterEURparaUSD(conversorMoedaAPI conversor, Scanner scanner) {
        System.out.print("Digite o valor em EUR para converter para USD: ");
        double valorEUR = scanner.nextDouble();
        conversor.converterEURparaUSD(valorEUR);
    }

    public static void converterUSDtoJPY(conversorMoedaAPI conversor, Scanner scanner) {
        System.out.print("Digite o valor em USD para converter para JPY: ");
        double valorUSD = scanner.nextDouble();
        conversor.converterUSDtoJPY(valorUSD);
    }

    public static void converterJPYtoEUR(conversorMoedaAPI conversor, Scanner scanner) {
        System.out.print("Digite o valor em JPY para converter para EUR: ");
        double valorJPY = scanner.nextDouble();
        conversor.converterJPYtoEUR(valorJPY);
    }
}
