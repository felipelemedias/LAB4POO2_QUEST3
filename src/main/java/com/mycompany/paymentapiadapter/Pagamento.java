/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.paymentapiadapter;

/**
 *
 * @author fleme
 */
public class Pagamento {
    private ProvedorPagamento provedor;

    public Pagamento(ProvedorPagamento provedor) {
        this.provedor = provedor;
    }

    public void realizarPagamento(double valor) {
        provedor.efetuarPagamento(valor);
    }

    public void pagamentoComTaxa(double valor, double taxa) {
        double valorComTaxa = valor + (valor * taxa);
        realizarPagamento(valorComTaxa);
        System.out.println("Taxa aplicada: " + (taxa * 100) + "%");
    }

    public void pagamentoSemTaxa(double valor) {
        realizarPagamento(valor);
    }
}
