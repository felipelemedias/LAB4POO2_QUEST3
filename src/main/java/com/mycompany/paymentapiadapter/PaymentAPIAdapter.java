/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.paymentapiadapter;

/**
 *
 * @author fleme
 */
import java.util.Scanner;

public class PaymentAPIAdapter {
    public static void main(String[] args) {
        // Criação dos provedores de pagamento
        ProvedorPagamento paypal = new Paypal();
        ProvedorPagamento pix = new Pix();

        // Criação do objeto de pagamento
        Pagamento pagamento;

        // Menu
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("Escolha uma opção de pagamento:");
            System.out.println("1 - PayPal (com taxa)");
            System.out.println("2 - PIX (sem taxa)");
            System.out.println("0 - Sair");
            System.out.print("Opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    pagamento = new Pagamento(paypal);
                    System.out.print("Digite o valor do pagamento: R$");
                    double valorComTaxa = scanner.nextDouble();
                    pagamento.pagamentoComTaxa(valorComTaxa, 0.02); // 2% de taxa
                    break;
                case 2:
                    pagamento = new Pagamento(pix);
                    System.out.print("Digite o valor do pagamento: R$");
                    double valorSemTaxa = scanner.nextDouble();
                    pagamento.pagamentoSemTaxa(valorSemTaxa); // Sem taxa
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 0);

        scanner.close();
    }
}

