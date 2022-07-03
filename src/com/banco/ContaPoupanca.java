package com.banco;

public class ContaPoupanca extends Conta {
    public ContaPoupanca(Cliente cliente) {
        super(cliente);
    }

    @Override
    protected void imprimirInfosComuns() {
        super.imprimirInfosComuns();
    }

    public void imprimirExtrato() {
        System.out.println("=== Extrato Conta Pupança  ===");
        super.imprimirInfosComuns();
    }

}
